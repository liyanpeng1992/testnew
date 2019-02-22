package testloadclass;

import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;

import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Console;


public class TestLoadJarUtil {

	//https://weifly.iteye.com/blog/941730

	public static void main(String[] args) throws Exception {
		// 系统ClassLoader只能加载.jar
		// 动态加载jar
		Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
		// 获取方法的访问权限
		addURL.setAccessible(true);

		URLClassLoader myClassloader = (URLClassLoader) ClassLoader.getSystemClassLoader();

		// file:C:\workspace\idea\testnew/test.jar
		String jarPath =SystemUtils.USER_DIR + "/test.jar";

		URL jarUrl = new File(jarPath).toURI().toURL();
		Console.log(jarUrl);


		// 这一步已经把jar包加载成功了
		addURL.invoke(myClassloader, jarUrl);
		// myclassloader.close();



		// 用Protubuf的时候调用反射的时候与以前一致了
		// String className = "com.run.hello.HelloWorld";
		// Class<?> helloWorld = Class.forName(className);
		// // 反射生成HellWord类的实例
		// Object obj = helloWorld.newInstance();
		// // 被调用函数的参数
		// Method method2 = helloWorld.getDeclaredMethod("out");
		// method2.invoke(obj);

		InputStream resourceAsStream = myClassloader.getResourceAsStream("Version.txt");
		String version = IoUtil.read(resourceAsStream, StandardCharsets.UTF_8);
		Console.log(version);

	}
}
