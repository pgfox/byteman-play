# byteman-play

to test a rule

/apps/byteman-download-3.0.10/bin/bmcheck.sh -cp target/byteman-play-1.0-SNAPSHOT.jar ./scripts/inject_exception.btm




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
    