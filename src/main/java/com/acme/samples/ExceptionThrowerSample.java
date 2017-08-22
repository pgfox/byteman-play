
package com.acme.samples;

import org.apache.log4j.Logger;

public class ExceptionThrowerSample {

    Logger logger = Logger.getLogger(ExceptionThrowerSample.class);



    public static void main(String[] arg) {

        try {
            ExceptionThrowerSample app = new ExceptionThrowerSample();
            app.doit();
        }catch (Throwable throwable){
            //Swallow the exception to simulate naughty code !
        }


    }

    private void doit() throws Exception {
        logger.info("doit() called." );
        method1();
        logger.info("doit() finished");

    }

    private void method1() throws Exception {
        logger.info("method1() called.");
        throw new RuntimeException("DUMMY EXCEPTION");

    }

}
