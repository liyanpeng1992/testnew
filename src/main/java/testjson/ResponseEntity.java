package testjson;

import java.util.Map;

public class ResponseEntity {
	private Header header;
	private Body body;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public class Header {

		private int status;
		private String time;
		private String errorDes;

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getErrorDes() {
			return errorDes;
		}

		public void setErrorDes(String errorDes) {
			this.errorDes = errorDes;
		}
	}

	public class Body {

		private Map<String, String> props;

		public Map<String, String> getProps() {
			return props;
		}

		public void setProps(Map<String, String> props) {
			this.props = props;
		}
	}


}
