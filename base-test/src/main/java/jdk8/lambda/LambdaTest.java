package jdk8.lambda;

/**
 * 查看字节码 lambda的底层实现原理
 *
 * @author Ariescat
 * @version 2019/12/31 15:28
 */
public class LambdaTest {
    public static void printString(String s, Print<String> print) {
        print.print(s);
    }

    public static void main(String[] args) {
        printString("test", (x) -> System.out.println(x));
    }
}

@FunctionalInterface
interface Print<T> {
    public void print(T x);
}
