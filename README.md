# byteman-play

to test a rule

/apps/byteman-download-3.0.10/bin/bmcheck.sh -cp target/byteman-play-1.0-SNAPSHOT.jar ./scripts/inject_exception.btm




simple byteman example scripts

- script/artemis_postoffice.btm
  prints out the routed message to the console.

- script/inject_exception.btm
   throws an execption when a specific method is called.

    java  -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=script:./scripts/inject_exception.btm -cp target/byteman-play-1.0-SNAPSHOT.jar com.acme.samples.ExceptionInjectSample
