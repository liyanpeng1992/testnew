package testguava;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestGuava {
	private static final Logger logger = LoggerFactory.getLogger(TestGuava.class);

	public static void main(String[] args) {
		// 定时器线程池
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
		// 执行查询的线程池
		ExecutorService pool = Executors.newCachedThreadPool();

		// guava的线程池
		ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(pool);

		ListenableFuture<?> task = listeningExecutorService.submit(() -> {
			//查询的方法
			return "测试多线程";
		});

		ListenableFuture<?> future = Futures.withTimeout(task, 60, TimeUnit.SECONDS, scheduledExecutorService);

		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
