import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadFactory {

	/**
	 * 1.如果当前线程池中的线程数目小于corePoolSize，则每来一个任务，就会创建一个线程去执行这个任务；
	 * 2.如果当前线程池中的线程数目>=corePoolSize，则每来一个任务，会尝试将其添加到任务缓存队列当中，
	 * 若添加成功，则该任务会等待空闲线程将其取出去执行；若添加失败（一般来说是任务缓存队列已满），
	 * 则会尝试创建新的线程去执行这个任务；
	 * 3.如果当前线程池中的线程数目达到maximumPoolSize，则会采取任务拒绝策略进行处理；
	 * 4.如果线程池中的线程数量大于 corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止，
	 * 直至线程池中的线程数目不大于corePoolSize；如果允许为核心池中的线程设置存活时间，
	 * 那么核心池中的线程空闲时间超过keepAliveTime，线程也会被终止。
	 */



	/**
	 *线程池测试
	 * 5：coreThreadCount核心线程数，即前5个线程来了就创建线程，加入线程池
	 * 10：maxThreadCount最大线程数，当core满时，会向workBlockQueue加入线程，等待执行
	 * newArrayBlockingQueue(5)，当blockqueue中满，会根据maxThreadCount再创建加入线程池
	 * 当maxThreadCount满时，RejectedExecutionHandleer拒绝策略上场
	 * shutdown，关闭线程池，等待缓存队列中线程执行完成
	 * shutdownNow立即遍历线程池
	 */

	/**
	 * 1.当线程池小于corePoolSize时，新提交任务将创建一个新线程任务，即使此时线程池中存在空闲线程
	 * 2.当线程池达到corePoolSize时，新提交任务将被放入workqueue中，等待线程池中任务调度执行
	 * 3.当workQueue已满，且maximumPoolSize>corePoolSize时，新提交任务会创建新线程执行任务
	 * 4.当提交任务数超过maximumPoolSize时，新提交任务有哦RejectedExecutionHandler处理
	 * 5.当线程池中超过corePoolSize线程，空闲时间达到keepAliveTime时，关闭空闲线程
	 * 6.当设置allowCoreThreadTimeOut(true)时，线程池中corePoolSize线程空闲时间达到keepAliveTime也将关闭
	 */

	private static ThreadPoolExecutor executor = null;

	static {
		executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));
		//预启动一个线程
		executor.prestartCoreThread();
		//预启动corePoolSize个线程到线程池
//		executor.prestartAllCoreThreads();

	}

	public static void main(String[] args) {
		System.out.println("线程池线程数："+executor.getPoolSize());
		for (int i = 0; i <15 ; i++) {
			System.out.println(executor.isShutdown());
//			executor.execute(new MyTask(i,"lee线程："+i));
		}
	}


		/**
	 * 自定义线程工厂
	 */
	class  MyTaskThreadFactory implements ThreadFactory {

		private  String FACTORYNAME = "mytaskfactory";
		private  List<? super Thread> threadList = new ArrayList<>();

		public void setFactoryname(String name) {
			FACTORYNAME = name;
		}

		@Override
		public Thread newThread(Runnable r) {
			synchronized (r) {
				//这里可以自定义一个Thread，用了处理在创建线程前后预处理
				Thread t = new Thread(r, FACTORYNAME + threadList.size());
				threadList.add(t);
				return t;
			}
		}
	}

	/**
	 * 任务线程类
	 */
	class MyTask extends Thread {
		private int num;

		public MyTask(int num, String name) {
			super(name);
			this.num = num;
		}

		@Override
		public void run() {
			try {
				System.out.println(this.getName() + ",正在执行task" + num);
				Thread.sleep(200);
			} catch (Exception e) {

			}
			System.out.println(this.getName() + ",task" + num + "执行完成");
		}
	}


}
