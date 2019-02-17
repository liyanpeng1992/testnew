public class TestSingleton2 {
    /**
     * 私有化构造方法
     */
    private TestSingleton2() {
        init();
        System.out.println("构造器工作");
    }

    //外部能访问到的方法都是static的
    private static TestSingleton2 instance = new TestSingleton2();

    public static TestSingleton2 getSington2() {
        return instance;
    }

    /**
     * 作为整个类的一个属性存在的
     */
    private String dataSource = null;

    /**
     * 初始化DBCP数据库连接池
     */
    private void init() {
        //一定要加this，要不然无法位属性赋值
        this.dataSource = "test";
    }

    public String getDataSource() {
        return this.dataSource;
    }
}
