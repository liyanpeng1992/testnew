package concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;

public class TestSemaphore {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(TestSemaphore.class);
		/*
		线程池默认的命名机制是pool-N-thread-M，
		这里N是线程池的序号（每新创建一个线程池，这个N都会加一），
		而M是池 里线程的序号。
		比方说，pool-2-thread-3指的是JVM生命周期中第二个线程池里的第三个线程
		 */
		ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("test-pool-%d").build();
		ExecutorService poool = Executors.newCachedThreadPool(threadFactory);

		final Semaphore semaphore = new Semaphore(3, true);
		for (int i = 0; i <10 ; i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						//获取信号灯许可   只有获得信号量才可以往下执行
						semaphore.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					logger.info("Thread {} 进入，当前系统的并发数是 {}",Thread.currentThread().getName(),(3-semaphore.availablePermits()));
					try {
						Thread.sleep(new Random().nextInt(1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					logger.info("Thread {} 即将离开",Thread.currentThread().getName() );
					//释放信号灯
					semaphore.release();
					logger.info("Thread {} 已经离开，当前系统的并发数是 {}",Thread.currentThread().getName(),(3-semaphore.availablePermits()));
				}
			};
			poool.execute(runnable);
		}
		poool.shutdown();
	}
}
