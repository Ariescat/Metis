package script.groovy.withJava;

import base.math.round.Main;

public class TestGroovy2 implements ITestGroovy2 {

    @Override
    public void print(String msg) {
        System.out.println(msg);

        // ���ñ��෽��
//        testCall();

        // ���������෽��
        Main.main(null);
    }

    private void testCall() {
//        new TestGroovy().printArgs("1", "2", "3");
        throw new RuntimeException("testCall");
    }

}
