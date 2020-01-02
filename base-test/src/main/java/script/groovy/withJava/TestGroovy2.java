package script.groovy.withJava;

public class TestGroovy2 implements ITestGroovy2 {

    @Override
    public void print(String msg) {
        System.out.println(msg);

//        throw new RuntimeException("ppp");
        testCall();
    }

    private void testCall() {
//        new TestGroovy().printArgs("1", "2", "3");
        throw new RuntimeException("testCall");
    }

}
