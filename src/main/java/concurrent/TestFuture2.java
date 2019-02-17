package concurrent;

import java.util.concurrent.*;

public class TestFuture2 {
    /*
    一般的流程，先声明一个线程池
    再写一个task类继承自Callable
    再把task提交sumit进线程池等到future
     */
    public static ExecutorService service = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        Task task = new Task("solr");

        Future<String> future = service.submit(task);
        String result=null;
        try {
            result =future.get(10,TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        System.out.println(result);



    }

    //Callable中的是返回参数类型
    private static class Task implements Callable<String>{

        //若想在一个类中传入参数，可以用构造器
        private String taskName;

        //带参构造起，new Task的时候可以把参数传进去
        public Task(String taskName) {
            this.taskName = taskName;
        }


        @Override
        public String call() throws Exception {
            return taskName;
        }
    }


}
