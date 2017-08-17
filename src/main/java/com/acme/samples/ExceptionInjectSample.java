/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.acme.samples;

import org.apache.log4j.Logger;

public class ExceptionInjectSample {

    Logger logger = Logger.getLogger(ExceptionInjectSample.class);


    public static void main(String [] arg) throws Exception {



        ExceptionInjectSample app = new ExceptionInjectSample();
        app.doit();


    }

    private void doit() throws Exception{
        logger.info("doit() called ");
        method1();
        logger.info("doit() finished ");

    }

    private void method1() throws Exception{
        logger.info("method1() called.");
        logger.info("method1() ended.");
        
    }
}
