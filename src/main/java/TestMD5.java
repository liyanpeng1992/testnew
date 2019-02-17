import org.apache.commons.codec.digest.DigestUtils;

public class TestMD5 {
	public static void main(String[] args) {
		String placeIdType = "0020001";
		String placeIdString = "_15580873586";
		String prefix = DigestUtils.md5Hex(placeIdType + placeIdString).substring(0, 2);
		System.out.println(prefix);

	}
}
