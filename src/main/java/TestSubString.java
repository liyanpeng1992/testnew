import org.apache.commons.lang3.StringUtils;

public class TestSubString {

	public static void main(String[] args) {
//		String s= "hdfs://runcdhInt:8020/entitydata/bcpdata31";
//
//		String substringAfter = StringUtils.substringAfter(s, "hdfs://runcdhInt:8020");
//		System.out.println(substringAfter);

		String path = "test.sh";
		String s = StringUtils.substringAfterLast(path,"/");
		String s1 = StringUtils.substringAfter(path, "/");
		String s2 = StringUtils.substringBeforeLast(path, ".");


		// System.out.println(s);
		// System.out.println(s1);
		System.out.println(s2);


	}


}
