import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger("queueLogger");
		logger.info("test-------------");

		String s = null;
		Boolean aBoolean = Boolean.valueOf(s);
		System.out.println(aBoolean);
	}
}
