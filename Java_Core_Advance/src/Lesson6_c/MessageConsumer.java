package Java_Core_Advance.src.Lesson6_c;
import Utils.ConnectProperties;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageConsumer implements Runnable{
    BlockingQueue<Integer> blockingQueue ;
    public MessageConsumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
          try {
               while(true) {
                   int messageProducer =  blockingQueue.take();
                   System.out.println("Message: "+messageProducer);
               }

          } catch (InterruptedException e) {
              e.printStackTrace();
          }

    }

    public static void main(String[] args) {
        final String SIZE_QUEUE = new ConnectProperties().createProperties().getProperty("SIZE_QUEUE") ;
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(Integer.parseInt(SIZE_QUEUE)) ;
        MessageProducer messageProducer = new MessageProducer(blockingQueue);
        MessageConsumer messageConsumer = new MessageConsumer(blockingQueue);
        Thread ThreadProducer = new Thread(messageProducer);
        Thread ThreadConsumer =new Thread(messageConsumer);
        ThreadProducer.start(); ThreadConsumer.start();
    }
}
