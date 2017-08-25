
package com.acme.samples;

import org.apache.log4j.Logger;

public class ThreadSample {

    Logger logger = Logger.getLogger(ThreadSample.class);
    


    public static void main(String[] arg) throws Exception {


        ThreadSample app = new ThreadSample();
        app.doit();


    }

    private void doit() throws Exception {

        Thread thread_1 = new Thread(new Task("thread_1"));
        thread_1.start();

        Thread thread_2 = new Thread(new Task("thread_2"));
        thread_2.start();

    }

    private void method1(String id) throws Exception {
        
        logger.info("method1(), id  now :" + id);

    }

    

    class Task implements Runnable {

        private final String id;

        public Task(String id){
            this.id = id;
        }

        public void run() {

            try {
                method1(id);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }


}
