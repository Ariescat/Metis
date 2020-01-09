package com.agent;

import com.agent.transformer.PerfMonXformer;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/**
 * @author Ariescat
 * @version 2020/1/9 17:23
 * <p>
 * {@link jdk.hotswap.agentmain.TestTransformer}
 */
public class AgentTransformer {

    public static void agentmain(String args, Instrumentation inst) {
        System.out.println("PerfMonAgent.premain() was called.");
        // Set up the class-file transformer.
        ClassFileTransformer trans = new PerfMonXformer();
        System.out.println("Adding a PerfMonXformer instance to the JVM.");
        inst.addTransformer(trans);
    }
}
