package com.acme.samples;

import org.apache.log4j.Logger;

public class ThreadExceptionSample {

   Logger logger = Logger.getLogger(ThreadExceptionSample.class);

   public static void main(String[] arg) {

      ThreadExceptionSample app = new ThreadExceptionSample();
      app.doit();

   }

   private void doit() {

      Thread thread_1 = new Thread(new Task("thread_1"));
      thread_1.start();



   }

   private void method1(String id) {

      logger.info("method1(), id  now :" + id);

   }

   class Task implements Runnable {

      private final String id;

      public Task(String id) {
         this.id = id;
      }

      public void run() {

         method1(id);
         throw new RuntimeException("Dummy Exception");

      }
   }





}
