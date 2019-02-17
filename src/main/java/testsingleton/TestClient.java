package testsingleton;

public class TestClient {

	public static void main(String[] args) {
        /*
        运用缓存的方法每次都要判断
        运用new对象的方法，虽然不用判断
        对象在类第一次初始化的时候就把它本身和属性值都构建好了
        但是得到属性值的时候，首先得通过对象的私有方法得到对象本身
        然后再用对象本身获得对象的属性

       总上，饿汉式不仅书写麻烦，理解麻烦，而且调用的时候还要分两步
       虽然懒汉式多判断了一次，其实对性能基本上也没有影响，
       而且易于理解，便于书写，以后写缓存也可以直接利用
       应该以懒汉式为主，最多加一个线程安全的锁而已

         */


		//这种方法理论上没有用到构造器，没有构造出单例的整个对象，用的是缓存的原理
		String connection = TestSingleton.getConnection();
		System.out.println(connection);

		TestSingleton2 sington2 = TestSingleton2.getSington2();
		String dataSource = sington2.getDataSource();
		System.out.println(dataSource);
	}


	public static class TestSingleton2 {
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
}
