
package com.acme.samples;

import org.apache.log4j.Logger;

public class ExceptionInjectSample {

    Logger logger = Logger.getLogger(ExceptionInjectSample.class);
    private String myId = "id1";



    public static void main(String [] arg) throws Exception {



        ExceptionInjectSample app = new ExceptionInjectSample();
        app.doit();


    }

    private void doit() throws Exception{
        logger.info("doit() called ");
        method1();
        logger.info("doit() finished, myid :"+getMyId());

    }

    private void method1() throws Exception{
        logger.info("method1() called.");
        logger.info("method1() ended.");
        
    }

    public String getMyId() {
        return myId;
    }

    public void setMyId(String myId) {
        this.myId = myId;
    }
}
