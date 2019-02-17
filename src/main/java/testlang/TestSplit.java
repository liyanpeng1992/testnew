package testlang;

import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;

public class TestSplit {


	public static void main(String[] args) throws IOException {

		String file = FileUtils.readFileToString(new File("test.txt"), "UTF-8");
		System.out.println(file);
		String[] split = file.split("\n");
		System.out.println(split.length);
		for (String s:split
			 ) {
			System.out.println(s);
		}


	}
}
