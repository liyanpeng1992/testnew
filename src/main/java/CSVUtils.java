import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

/**
 * @version 1.0.0
 * @类名称：CSVUtils
 * @类描述：csv文件读写
 * @创建时间：2017年1月10日 上午11:05:12
 */
public class CSVUtils {

    // 写csv文件 传参数文件名 路径 csv文件表头 需要写入的数据
    public static File writeCsvFile(String fileName, String path, String[] fileHeaders, List<List<String>> list) {
        File csvFile = null;
        BufferedWriter csvFileOutputStream = null;
        CSVPrinter csvPrinter = null;
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(fileHeaders);
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.mkdir();
            }
            csvFile = new File(path + fileName + ".csv");
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "GBK"),
                    1024);
            // 初始化 CSVPrinter
            csvPrinter = new CSVPrinter(csvFileOutputStream, csvFileFormat);
            List<String> ls = null;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    ls = new ArrayList<String>();
                    ls = list.get(i);
                    for (int j = 0; j < ls.size(); j++) {
                        csvPrinter.print(ls.get(j));
                    }
                    csvPrinter.println();// 换行
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
//            log.error("csv文件写入异常");
        } finally {
            try {
                csvFileOutputStream.flush();
                csvFileOutputStream.close();
                csvPrinter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvFile;
    }

    //测试写入功能
    public static void main(String[] args) {
        String[] fileHeaders={"1","2","3"};
//        String[] fileHeaders = null;
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> ls = new ArrayList<String>();
        ls.add("a");
        ls.add("b");
        ls.add("c");
        List<String> ls1 = new ArrayList<String>();
        ls1.add("北京");
        ls1.add("上海");
        ls1.add("成都");
        list.add(ls);
        list.add(ls1);
        File file = writeCsvFile("abc", "E:/Test", fileHeaders, list);
    }

    // 读取csv文件 传参数 文件 表头 从第几行开始
    public static List readCsvFile(File file, String[] fileHeaders, Integer num) {
        BufferedReader br = null;
        CSVParser csvFileParser = null;
        List list = null;
        // 创建CSVFormat（header mapping）
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(fileHeaders);
        try {
            // 初始化FileReader object
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));//解决乱码问题
            // 初始化 CSVParser object
            csvFileParser = new CSVParser(br, csvFileFormat);
            // CSV文件records
            List<CSVRecord> csvRecords = csvFileParser.getRecords();
            List data = new ArrayList();
            list = new ArrayList();
            for (int i = num; i < csvRecords.size(); i++) {
                CSVRecord record = csvRecords.get(i);
                for (int j = 0; j < fileHeaders.length; j++) {
                    data.add(record.get(fileHeaders[j]));
                }
                list.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
//            log.error("csv文件读取异常");
        } finally {
            try {
                br.close();
                csvFileParser.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}