package concurrent;

import java.util.concurrent.*;

public class TestFuture {

    /*
   此方法不再写一个Callable的实现类，直接new Callable()
   并提交到线程池
     */

    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        Future<String> future1 = querySolr("solr");
        String result = null;
        try {
         result=   future1.get(5,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        System.out.println(result);


    }

    private static Future<String> querySolr(String taskName) {
        return executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return taskName;
            }
        });


    }


}
