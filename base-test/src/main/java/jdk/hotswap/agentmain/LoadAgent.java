package jdk.hotswap.agentmain;

import com.sun.tools.attach.VirtualMachine;

/**
 * @author Ariescat
 * @version 2020/1/9 16:11
 */
public class LoadAgent {

    public static void main(String[] args) throws Exception {
        String pid = "18376";

        //VirtualMachine是jdk中tool.jar里面的东西，所以要在pom.xml引用这个jar
        VirtualMachine vm = VirtualMachine.attach(pid);
        // 这个路径是相对于被热更的服务的，也就是这个pid的服务，也可以使用绝对路径。
        vm.loadAgent(System.getProperty("user.dir") + "\\agent\\target\\agent-1.0-SNAPSHOT.jar");

        System.err.println("suc");
    }
}
