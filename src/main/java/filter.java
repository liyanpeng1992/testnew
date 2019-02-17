
public class filter {
	public static void main(String[] args) {
		String s = "182 3356 1426F N";
		s = s.replaceAll("[^0-9a-zA-Z]", "");
		System.out.print(s);
	}
}
