package org.example.util;

import java.util.concurrent.*;

/**
 * 线程池
 */
public class ThreadPool {
    /**
     * ThreadPoolExecutor：
     * 构造方法参数详解：
     * corePoolSize：核心池的大小，这个参数跟后面讲述的线程池的实现原理有非常大的关系。在创建了线程池后，默认情况下，
     * 线程池中并没有任何线程，而是等待有任务到来才创建线程去执行任务，除非调用了prestartAllCoreThreads()或者prestartCoreThread()方法，
     * 从这2个方法的名字就可以看出，是预创建线程的意思，即在没有任务到来之前就创建corePoolSize个线程或者一个线程。默认情况下，
     * 在创建了线程池后，线程池中的线程数为0，当有任务来之后，就会创建一个线程去执行任务，当线程池中的线程数目达到corePoolSize后，
     * 就会把到达的任务放到缓存队列当中；
     *
     * maximumPoolSize：线程池最大线程数，这个参数也是一个非常重要的参数，它表示在线程池中最多能创建多少个线程；
     *
     * keepAliveTime：表示线程没有任务执行时最多保持多久时间会终止。默认情况下，只有当线程池中的线程数大于corePoolSize时，
     * keepAliveTime才会起作用，直到线程池中的线程数不大于corePoolSize，即当线程池中的线程数大于corePoolSize时，
     * 如果一个线程空闲的时间达到keepAliveTime，则会终止，直到线程池中的线程数不超过corePoolSize。
     * 但是如果调用了allowCoreThreadTimeOut(boolean)方法，在线程池中的线程数不大于corePoolSize时，
     * keepAliveTime参数也会起作用，直到线程池中的线程数为0；
     *
     * unit：参数keepAliveTime的时间单位，有7种取值，在TimeUnit类中有7种静态属性：
     * TimeUnit.DAYS;               //天
     * TimeUnit.HOURS;             //小时
     * TimeUnit.MINUTES;           //分钟
     * TimeUnit.SECONDS;           //秒
     * TimeUnit.MILLISECONDS;      //毫秒
     * TimeUnit.MICROSECONDS;      //微妙
     * TimeUnit.NANOSECONDS;       //纳秒
     *
     * workQueue：一个阻塞队列，用来存储等待执行的任务，这个参数的选择也很重要，会对线程池的运行过程产生重大影响，一般来说，这里的阻塞队列有以下几种选择：
     * ArrayBlockingQueue;
     * LinkedBlockingQueue;
     * SynchronousQueue;
     * ArrayBlockingQueue和PriorityBlockingQueue使用较少，一般使用LinkedBlockingQueue和Synchronous。线程池的排队策略与BlockingQueue有关。
     *
     * threadFactory：线程工厂，主要用来创建线程；
     *
     * handler：表示当拒绝处理任务时的策略，有以下四种取值：
     * ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
     * ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
     * ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
     * ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
     */

    /*private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;
    public static void main(String[] args) {
        System.out.println("COUNT_BITS="+COUNT_BITS);

        System.out.println("RUNNING="+RUNNING);
        System.out.println("SHUTDOWN="+SHUTDOWN);
        System.out.println("STOP="+STOP);
        System.out.println("TIDYING="+TIDYING);
        System.out.println("TERMINATED="+TERMINATED);
    }*/
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        for(int i=0;i<15;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    }

    static class MyTask implements Runnable{

        private int taskNum;

        public MyTask(int num) {
            this.taskNum = num;
        }
        @Override
        public void run() {
            System.out.println("正在执行task "+taskNum);
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task "+taskNum+"执行完毕");
        }
    }
}
