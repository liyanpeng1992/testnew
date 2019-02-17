package testcommonuitls;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.LinkedListMultimap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class TestExeprot {
	public static void main(String[] args) throws IOException {
		long begin = System.currentTimeMillis();
		//统计第一层的时候用数组，统计第二层的时候用HashSet

		LinkedListMultimap<String, String> hourMultimap = LinkedListMultimap.create();
		List<String> logs = FileUtils.readLines(new File("3.tsv"), StandardCharsets.UTF_8);
		System.out.println(logs.size());
		for (String log : logs) {
			String[] logArr = log.replaceAll("\"", "").split("\t");
			//system : dataset
			String system = logArr[1];
			String dataset = StringUtils.substringBefore(StringUtils.substringAfter(logArr[2], "from "), " where");
			String hour = logArr[0].substring(10, logArr[0].length() - 6);
			hour = hour + "--" + String.valueOf((Integer.valueOf(hour) + 1));

			hourMultimap.put(hour, system + "\t" + dataset);
		}

		//遍历Mutlimap key为小时数，value为systemID dataset
		StringBuilder sb = new StringBuilder();

		for (String hour : hourMultimap.keySet()) {
			List<String> hourValues = hourMultimap.get(hour);

			//每小时一共有多少个查询--并不能计算出每个systemID有多少
			sb.append(hour).append("\t").append(hourValues.size()).append("\n");

			ArrayListMultimap<String, String> systemMultimap = ArrayListMultimap.create();

			for (String s : hourValues) {
				String[] arr = s.split("\t");
				String system = arr[0];
				String dataset = arr[1];
				systemMultimap.put(system, dataset);
			}
			System.out.println("----------------------------------");
			for (String system : systemMultimap.keySet()) {
				System.out.println(system);
				System.out.println(systemMultimap.get(system).size());
				sb.append("\t").append(system).append("\t").append(systemMultimap.get(system).size()).append("\n");

				//对每一个systemId的daset进行统计
				ArrayListMultimap<String, String> datasetMultimap = ArrayListMultimap.create();
				List<String> datasetList = systemMultimap.get(system);
				for (String d : datasetList) {
					datasetMultimap.put(d, d);
				}
				for (String dataset : datasetMultimap.keySet()) {
					sb.append("\t\t").append(dataset).append("\t").append(datasetMultimap.get(dataset).size()).append("\n");
				}
			}
			System.out.println("----------------------------------");
		}

		FileUtils.write(new File("succes.txt"), sb.toString(), StandardCharsets.UTF_8);
		System.out.println(System.currentTimeMillis() - begin);
		System.out.println("Done");
	}
}
