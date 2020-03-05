package com.agent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;

/**
 * @author Ariescat
 * @version 2020/1/9 15:40
 * <p>
 * {@link jdk.hotswap.agentmain.TestRedefineClasses}
 */
public class AgentRedefineClasses {

    public static void agentmain(String args, Instrumentation inst) {
        System.out.println("agent 启动成功,开发重定义对象....");
        redefineClasses(inst);
    }

    public static void redefineClasses(Instrumentation inst) {
        Class<?>[] allClass = inst.getAllLoadedClasses();
//        for (Class<?> c : allClass) {
//            if (c.getName().endsWith("Person")) {

        System.err.println("find Person");

        String pathname = "C:\\LQZ_Projects\\Idea_Projects\\Metis\\base-test\\target\\classes\\jdk\\hotswap\\Person.class";
        File file = new File(pathname);
        try {
            byte[] bytes = fileToBytes(file);
            System.out.println("文件大小：" + bytes.length);
            Class<?> clazz = Class.forName("jdk.hotswap.Person");
            ClassDefinition classDefinition = new ClassDefinition(clazz, bytes);
            System.out.println("转换代码 -> " + file.getName());
            inst.redefineClasses(classDefinition);
        } catch (Exception e) {
            e.printStackTrace();
        }
//            }
//        }
        System.out.println("热更新成功....");
    }

    private static byte[] fileToBytes(File file) throws IOException {
        FileInputStream in = new FileInputStream(file);
        byte[] bytes = new byte[in.available()];
        in.read(bytes);
        in.close();
        return bytes;
    }
}