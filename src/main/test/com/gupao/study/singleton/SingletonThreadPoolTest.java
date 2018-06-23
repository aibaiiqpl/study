package com.gupao.study.singleton;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fandonghui@baixing.com
 * @date 2018/6/17
 */
public class SingletonThreadPoolTest {
    public static void main(String[] args) {
        Integer threadSize = 200;
        ExecutorService threadPool = new ThreadPoolExecutor(
                threadSize,
                threadSize,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                new SingletonThreadPoolTest.DefaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        CyclicBarrier barrier  = new CyclicBarrier(threadSize + 1);
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        for(int i=0; i<threadSize; i++){
            threadPool.execute(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                barrier.await();
                                //LazyOne one = LazyOne.getInstance();
                                Hungry one = Hungry.getInstance();
                                System.out.println(one);
                            } catch (BrokenBarrierException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } finally {
                                countDownLatch.countDown();
                            }
                        }
                    }
            );
        }

        try {
            Thread.currentThread().setPriority(10);
            System.out.println("等待"+threadSize+"个子线程执行完毕...");
            Long start = System.currentTimeMillis();
            barrier.await();
            countDownLatch.await();
            Long end = System.currentTimeMillis();
            System.out.println("总耗时"+(end-start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        threadPool.shutdown();

    }

    /**
     * The default thread factory
     */
    static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        DefaultThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" +
                    POOL_NUMBER.getAndIncrement() +
                    "-thread-";
        }
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }
}
