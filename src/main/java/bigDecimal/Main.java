package bigDecimal;

import java.math.BigDecimal;

public class Main {

    /**
     * 悬赏征集！5道题征集代码界前3%的超级王者 阿里云
     *
     * @see https://developer.aliyun.com/article/705658
     */
    public static void main(String[] args) {
//        System.err.println("10" > "9"); // sql : select "10" > "9"
        BigDecimal a = new BigDecimal(0.1);
        System.out.println(a);

        BigDecimal b = new BigDecimal("0.1");
        System.out.println(b);
    }
}
