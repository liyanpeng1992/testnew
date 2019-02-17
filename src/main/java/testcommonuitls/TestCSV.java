package testcommonuitls;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TestCSV {
	public static void main(String[] args) throws IOException {

		Appendable out = new PrintWriter("file.csv");
		// CSVPrinter printer = CSVFormat.DEFAULT.withHeader("userId", "userName").print(out);

		CSVPrinter print = CSVFormat.DEFAULT.print(out);
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");

		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			print.printRecord(s);
		}
		print.flush();
		print.close();

		System.out.println("CSV文件创建成功,文件路径:");
	}
}
