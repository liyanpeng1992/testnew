package testlang;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;


public class TestReplaceEach {
	public static void main(String[] args) throws IOException {
		String s = "%%__AAA__";

		String replaceEach = StringUtils.replaceEach(s, new String[]{"%", "_"}, new String[]{"*", "?"});
		System.out.println(replaceEach);
		new FileInputStream(new File("xxx"));
	}
}
