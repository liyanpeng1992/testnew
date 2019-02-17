package concurrent;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;


public class TestCurrent {

    // 创建线程池
    final static ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

    public static void main(String[] args) {


        ListenableFuture<String> task1 = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });

        ListenableFuture<String> task2 = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });

        ListenableFuture<String> task3 = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });






    }




}
