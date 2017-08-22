

package com.acme.helper;

import com.acme.samples.ExceptionInjectSample;
import org.jboss.byteman.rule.Rule;
import org.jboss.byteman.rule.helper.Helper;

public class SampleHelper extends Helper {

    protected SampleHelper(Rule rule) {
        super(rule);
    }

    public void bang(){
        System.out.println("*** bang called****");
    }


    public void bang(ExceptionInjectSample obj){
        System.out.println("*** bang setting myID****");
        obj.setMyId("bangID");
    }


    public void exceptionStack(Throwable throwable){
        throwable.printStackTrace(System.out);
    }

}
