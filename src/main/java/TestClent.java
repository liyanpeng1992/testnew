public class TestClent {

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


}
