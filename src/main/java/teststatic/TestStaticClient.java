package teststatic;

public class TestStaticClient {
    public static void main(String[] args) {
        TestStatic testStatic = new TestStatic();
        testStatic.test("lee","sg");
//        testStatic.test("zl","sure");
        TestStatic testStatic1 = new TestStatic();
        testStatic1.test("zl","sure");

        testStatic.shutdown();
    }


}
