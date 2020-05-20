package io.imwj.queue;

import java.util.Random;

/**
 * 循环队列测试
 * @author langao_q
 * @create 2020-05-20 16:28
 */
public class LoopQueueMain {

    public static void main(String[] args) throws Exception {
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");
    }

    /**
     * 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
     */
    private static double testQueue(Queue<Integer> q, int opCount) throws Exception {

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i = 0 ; i < opCount ; i ++){
            q.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    /**
     * 测试入队和出队
     */
    public static void fun1(){
        LoopQueue<Object> queue = new LoopQueue(10);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 2 == 0){
                queue.dequeue();
            }
        }
    }
}
