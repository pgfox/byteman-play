
package com.acme.samples;

import org.apache.log4j.Logger;

public class CounterSample {

    Logger logger = Logger.getLogger(CounterSample.class);
    private String myId = "id1";



    public static void main(String [] arg) throws Exception {



        CounterSample app = new CounterSample();
        app.doit();


    }

    private void doit() throws Exception{
        logger.info("doit() called ");

        for(int i = 0; i < 100 ; i++){
            method1(i);
        }

        logger.info("doit() finished, myid :"+getMyId());

    }

    private void method1(int i) throws Exception{

        if((i%10)==0) {
            logger.info("method1(), i is now :" +i);
        }

    }

    public String getMyId() {
        return myId;
    }

    public void setMyId(String myId) {
        this.myId = myId;
    }
}
