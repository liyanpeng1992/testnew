package testsingleton;

public class TestSingleton {

    /**
     * 私有化构造方法
     */
    private TestSingleton() {
        System.out.println("构造器工作");
    }

    /**
     * DBCP连接池
     */
    private volatile static String dataSource = null;

    /**
     * 初始化DBCP数据库连接池
     */
    private static void init() {
        dataSource = "test";
    }

    /**
     * 获取数据库连接
     */
    public static String getConnection() {
        String connection = null;
        //双重检查加锁
        if (dataSource == null) {

            init();

        }
      connection=dataSource+"success";
        return connection;
    }
}
