package Java_Core_Advance.src.Lesson6_c;

import Utils.ConnectProperties;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class MessageProducer implements Runnable{
     public static final int SIZE_QUEUE = Integer.parseInt(new ConnectProperties().createProperties().
             getProperty("SIZE_QUEUE"));
     public static final int MAX_RANDOM = Integer.parseInt(
             new ConnectProperties().createProperties().getProperty("MAX_RANDOM"));
     public BlockingQueue<Integer> blockingQueue ;

     public MessageProducer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
     public int createNumberRandom(){
        return new Random().nextInt(MAX_RANDOM);
    }

    @Override
    public void run() {
        try {
            while(true){
                int number_message = this.createNumberRandom();
                Thread.sleep(2000);
                blockingQueue.put(number_message);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
