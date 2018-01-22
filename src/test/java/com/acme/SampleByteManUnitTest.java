package com.acme;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.acme.samples.ParamTest;
import com.acme.samples.SampleObject;
import org.jboss.byteman.contrib.bmunit.BMRule;
import org.jboss.byteman.contrib.bmunit.BMRules;
import org.jboss.byteman.contrib.bmunit.BMUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(BMUnitRunner.class)
public class SampleByteManUnitTest  {

   static  CountDownLatch delayCalled;

   @Test
   @BMRules(rules = {@BMRule(
      name = "Delay delay methodOne by 2 secs ",
      targetClass = "com.acme.samples.SampleObject",
      targetMethod = "methodOne()",
      targetLocation = "ENTRY",
      action = "com.acme.SampleByteManUnitTest.delay(2)")})

   public void testMethodOne() throws Exception {

      ExecutorService executorService = Executors.newFixedThreadPool(1);

      final SampleObject sampleObject = new SampleObject();

      delayCalled = new CountDownLatch(2);

      try {

       executorService.submit(new Runnable() {
          public void run() {
             sampleObject.methodOne();
          }
       });

       sampleObject.methodOne();



      } finally {
         executorService.shutdown();
      }
   }


   @Test
   @BMRules(rules = {@BMRule(
      name = "call print info",
      targetClass = "com.acme.samples.ParamTest",
      targetMethod = "method1",
      targetLocation = "ENTRY",
      action = "com.acme.SampleByteManUnitTest.printInfo($1)")})
   public void testMethodParam() throws Exception {

      final ParamTest paramTest = new ParamTest();

      delayCalled = new CountDownLatch(1);

      paramTest.method1("one","two");

      paramTest.method1("one","two", "three", "four");

   }

   //notify delay has been called and wait for X seconds
   public static void delay(int seconds) {
      System.out.println("#### Delay CALLED: " +Thread.currentThread().getName());

      try {
         Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
      } catch (InterruptedException e) {
         e.printStackTrace();
      }finally {
         delayCalled.countDown();
      }

      System.out.println("#### Delay FINISHED: " +Thread.currentThread().getName());

   }

   //notify delay has been called and wait for X seconds
   public static void printInfo(Object p1) {
      System.out.println("#### PRINT INFO CALLED: " + p1);
   }



}