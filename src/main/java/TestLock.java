import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestLock {
	/**
	 * 高并发锁的三种实现
	 * 	减少锁粒度，提高系统并发能力
	 */

	/**
	 * 1、
	 * 初级技巧--乐观锁
	 * 乐观锁适用场景：读不会冲突，写会冲突，同时读的频率远大于写
	 */

	Map<Object, Object> map = new HashMap<>(16);

	/**
	 * 悲观锁-----上来先加锁，然后再判断执行代码
	 */
	public Object get(Object key) {
		synchronized (map) {
			if (map.get(key) == null) {
				//set some values
				map.put("key", "value");
			}
			return map.get(key);
		}
	}

	/**
	 * 乐观锁 ----先判断，符合条件再加锁，---要二次加锁，免得造成不同步
	 */
	public Object get1(Object key) {
		Object val = map.get(key);
		if (val == null) {
			//当map取值为null时再加锁判断
			synchronized (map) {
				if (val == null) {
					// set some value to map
					map.put("key", "value");
				}
			}
		}
		return val;
	}

	/**
	 * 中级技巧---String.intern()
	 * 乐观锁不能很好解决大量写冲突问题，但是很多场景下，锁实际上只是针对某个用户或者订单。
	 * 比如一个用户必须先创建Session，才能进行后面的操作。但是由于网络原因，创建用户Session的请求和后续请求几乎同时达到
	 * 而并行线程可能会处理后续请求。一般情况下，需要对用户sessionMap加锁，比如上面的乐观锁。
	 * 在这种场景下，可以将锁限定到用户本身上，即从原来的
	 * lock.lock() lock.unlock
	 * 改为  lock.lock(key) lock.unlock(key)
	 * 这个比较类似于数据库表锁和行锁的概念，显然行锁的并发能力比表锁高很多
	 * <p>
	 * 尽管在输出中调用intern方法并没有什么效果，但是实际上后台这个方法会做一系列的动作和操作。
	 * 在调用”ab”.intern()方法的时候会返回”ab”，但是这个方法会首先检查字符串池中是否有”ab”这个字符串，如果存在则返回这个字符串的引用，否则就将这个字符串添加到字符串池中，然会返回这个字符串的引用。
	 * 使用String.inter()是这种思路的一种具体实现。类String维护一个字符串池。
	 * 当调用intern方式时，如果池已经包含一个等于此String对象的字符串(该对象由equals(Object)方法确定)，则返回池中的字符串
	 * 可见，当String相同时，String.intern()总是返回同一个对象，因此就实现了对同一用户加锁。
	 * 由于锁的粒度局限于具体用户，使系统获得了最大的并发
	 */

	public void doSomeThing(String uid) {
		synchronized (uid.intern()) {

		}
	}

	/**
	 * 高级技巧---类ConcurrentHashMap
	 * CopyOnWrite是这样一种机制。当我们读取共享数据的时候，直接读取，不需要同步
	 * 当我们修改数据的时候，我们就把当前数据copy一份副本，然后在这个副本上进行修改，完成之后，
	 * 再用修改后的副本，替换掉原来的的数据
	 * JDK并没有提供CopyonWriteMap-----因为已经有ConcurrentHashMap
	 * <p>
	 * String.inter()的缺陷是类String维护一个字符串池是放在JVM perm区，如果用户数特别多，导致放入字符串池的String不可控，
	 * 有可能导致OOM错误或者过多的Full GC。
	 * 可以借鉴ConcurrentHashMap的方式，将需要加锁的对象分为多个bucket，每个bucket加锁
	 */
	public void test(String uid) {
		Map lockMap = new HashMap();
		List lockKeysList = new ArrayList();
		for (int i = 1; i < 10000; i++) {
			Object lockKey = new Object();
			lockKeysList.add(lockKey);
			lockMap.put(lockKey, new Object());
		}

		Object lockKey = lockKeysList.get(uid.hashCode() % lockKeysList.size());
		Object lock = lockMap.get(lockKey);

		synchronized (lock){
			//do something
		}
	}
}
