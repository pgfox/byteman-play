package com.acme.helper;

import org.jboss.byteman.rule.Rule;
import org.jboss.byteman.rule.helper.Helper;

public class DefaultExceptionHelper extends Helper {

   protected DefaultExceptionHelper(Rule rule) {
      super(rule);
   }

   public void addDefaultExceptionHelper() {

      Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
      System.out.println("********** Original uncaughtExceptionHandler(), is " + uncaughtExceptionHandler);

      System.out.println("********** DefaultExceptionHelper setting uncaughtExceptionHandler()");
      Thread.setDefaultUncaughtExceptionHandler(new MyDefaultHandler());

   }

   public void exceptionStack(Throwable throwable) {
      throwable.printStackTrace(System.out);
   }

   class MyDefaultHandler implements Thread.UncaughtExceptionHandler {

      public void uncaughtException(Thread t, Throwable e) {

         //print it to the sys out
         System.out.println("DefaultExceptionHelper Throwable: " + e.getMessage());
         e.printStackTrace(System.out);
      }
   }

}
