import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Properties;

public class TestRead {
    public static void main(String[] args) throws IOException {

        /*
        配置文件的配置项大部分情况下都是英文，
        而且项目中新建的配置文件编码格式一般都为UTF-8,所以第二种两者符合一种就能满足情况
         */

        /*
         若不是读取配置文件这种问题，不需要输出的是一个输出流的话，直接用FileUtils即可
         */
        String s = FileUtils.readFileToString(new File("text.txt"), "UTF-8");

        //需要对读取的配置文件转码的时候
        FileInputStream in = new FileInputStream("text.txt");
        InputStreamReader inReader = new InputStreamReader(in, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inReader);

        //用文件的默认编码方式读取
        File file = new File("text.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufreader = new BufferedReader(fileReader);

        Properties properties = new Properties();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("AppConfig.properties"));
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
