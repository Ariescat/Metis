关于libs里的jar：

- arthas-boot.jar：
  Arthas（阿尔萨斯）是阿里巴巴开源的 Java 诊断工具
  可以反编译代码（查看groovy编译后的java代码），甚至热替换（暂未研究）

- hotswap-agent-1.3.0.jar：

  来源于[Release 1.3.0 · HotswapProjects/HotswapAgent · GitHub](https://github.com/HotswapProjects/HotswapAgent/releases/tag/RELEASE-1.3.0)

  该项目也能实现热替换代码，但缺点是需要打一个DCEVM补丁（jvm级别的补丁，稳定性未知），曾经也研究过该工程的源码，现在估计也忘得七七八八了吧＞﹏＜

- hotswap-code/libs/metis-hotswap-agent-${project.version}.jar

  自己研究的`Instrumentation`代码