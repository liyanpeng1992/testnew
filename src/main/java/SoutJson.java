import com.google.gson.Gson;

import java.util.HashMap;

public class SoutJson {
	public static void main(String[] args) {

		ResponseEntity.Header header = new ResponseEntity().new Header();


		header.setErrorDes("noErr");
		header.setStatus(1);
		header.setTime("1992");

		ResponseEntity.Body body = new ResponseEntity().new Body();
		HashMap<String, String> prpos = new HashMap<String, String>() {{
			put("H050014", "1836");
			put("B050016", "1987");
			put("test", null);
		}};
		body.setProps(prpos);

		ResponseEntity responseEntity = new ResponseEntity();
		responseEntity.setHeader(header);
		responseEntity.setBody(body);

		String s = new Gson().toJson(responseEntity);
		System.out.println(s);

	}


}
