package testloadclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Wells on 2018年09月29日
 */

public class LoadJarUtil{
	private static final Logger logger = LoggerFactory.getLogger(LoadJarUtil.class.getName());

	/**
	 * 文件分隔前缀
	 */
	public static final String FILE_PATH_SPLIT = "|";

	/**
	 * 本地文件
	 */
	public static final String LOCAL_FILE_PRE = "local";

	/**
	 * 远程文件
	 */
	public static final String REMOTE_FILE_PRE = "remote";

	/**
	 * s3文件
	 */
	public static final String AWS_FILE_PRE = "aws";


	/**
	 * @Description 加载jar包
	 * @MethodName  loadJar
	 * @param jarPath
	 * @Return void
	 * @Date: 2018年09月29日 13:02:54
	 * @Author Wells
	 */
	public static void loadJar(String jarPath) {
		URL url = null;
		// 获取jar的真实路径，过滤掉标志前缀(本地路径以"local|"标志，远程路径以"remote|"标志，s3路径以"s3|"标志)
		String realJarPath = jarPath.substring(jarPath.indexOf(FILE_PATH_SPLIT) + 1);
		try{
			// 根据jarPath前缀获取url
			if(jarPath.startsWith(LOCAL_FILE_PRE)){
				// 加载本地jar，比如：local|/User/xxx/test/demo.jar
				File jarFile = new File(realJarPath);
				url = jarFile.toURI().toURL();
			}else if(jarPath.startsWith(REMOTE_FILE_PRE)){
				// 加载远程jar，比如：remote|http://192.168.xx.xxx/test/demo.jar
				url = new URL(realJarPath);
			}
		}catch (Exception e){
			logger.error("get url exception, jarPath:" + jarPath, e);
		}

		if(null != url){
			// 从URLClassLoader类中获取类所在文件夹的方法，jar也可以认为是一个文件夹
			Method method = null;
			try {
				method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
			} catch (NoSuchMethodException e) {
				logger.error("get method exception, jarPath:" + jarPath, e);
			}

			// 获取方法的访问权限以便写回
			boolean accessible = method.isAccessible();
			try {
				method.setAccessible(true);

				// 获取系统类加载器
				URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
				method.invoke(classLoader, url);
			} catch (Exception e) {
				logger.error("load url to classLoader exception, jarPath:" + jarPath, e);
			} finally {
				method.setAccessible(accessible);
			}
		}
	}

	public void testInvokeMethod() throws Exception{
		String fullClassName = "";
		Class<?> clazz = Class.forName(fullClassName);
		if(null != clazz){
			Object instance = clazz.newInstance();
			// if(instance instanceof Template){
			// Template t = (Template) instance;
			// t.run();
			// }
		}
	}


}

