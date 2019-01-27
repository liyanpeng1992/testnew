public class TestExecption {
	public static void main(String[] args) {
		try {
			test();
		} catch (RuntimeException e) {
			System.out.println("---------------抓到了异常");
		}

	}

	private static String test() {
		if (true) {
			throw new RuntimeException("---------测试");
		}

		return "Done";
	}


}
