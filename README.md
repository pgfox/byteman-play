# byteman-play

to test a rule

${BYTEMAN_HOME}/bin/bmcheck.sh -cp target/byteman-play-1.0-SNAPSHOT.jar ./scripts/inject_exception.btm




simple byteman example scripts

- script/artemis_postoffice.btm
  prints out the routed message to the console.

- script/inject_exception.btm
   throws an execption when a specific method is called.

    java  -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=script:./scripts/inject_exception.btm -cp target/byteman-play-1.0-SNAPSHOT.jar com.acme.samples.ExceptionInjectSample

- script/custom_helper
    uses a customer helper method
    gets a handler to the crosscut object and invokes a method on that object

    java  -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=script:./scripts/custom_helper.btm -cp target/byteman-play-1.0-SNAPSHOT.jar com.acme.samples.ExceptionInjectSample


- script/log_to_file
    write logs to a file relative to where JVM started ( the files can also be absolute path)
    add a date timestamp to the log entry

    java  -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=script:./scripts/log_to_file.btm -cp target/byteman-play-1.0-SNAPSHOT.jar com.acme.samples.ExceptionInjectSample


- script/counter.btm
    uses 2 rules,
    - one rule to increment the counter
    - one rule to print out the counter when a condition is met

    java  -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=script:./scripts/counter.btm -cp target/byteman-play-1.0-SNAPSHOT.jar com.acme.samples.CounterSample


- script/log_exception.btm
    logs an exception stack trace using a helper class        

    java -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=script:./scripts/log_exception.btm -cp target/byteman-play-1.0-SNAPSHOT.jar  com.acme.samples.ExceptionThrowerSample


- script/waiter_threads.btm
    - creates an order between threads with thread_1 (with app id "thread_1") waiting for thread_2 to complete a method first

    java -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=script:./scripts/waiter_threads.btm -cp target/byteman-play-1.0-SNAPSHOT.jar com.acme.samples.ThreadSample

- script/trace_call.btm
    - prints a stack trace for the calling thread that triggers the rule

    java -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=script:./scripts/trace_call.btm -cp target/byteman-play-1.0-SNAPSHOT.jar com.acme.samples.ThreadSample

 - script/set_default_exception_handler.btm
    - sample scription to set the DefaultExceptionHandler to print to System out

    java -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=script:./scripts/set_default_exception_handler.btm -cp target/byteman-play-1.0-SNAPSHOT.jar com.acme.samples.ThreadExceptionSample