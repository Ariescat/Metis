package redpacket;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestRedPacket {
    private static final DecimalFormat FORMAT = new DecimalFormat("######.##");
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        redpacket();
    }

    private static void redpacket() {
        List<String> redPackage = getRedPackage(10, 20, 0.3);
        for (String red : redPackage) {
            System.out.println(red);
        }
    }

    /**
     * @Title: getRedPackage
     * @param: totalAmount:总金额
     * @param: number:总人数
     * @param: minAmount:每人最少的金额，默认为0.01
     * @return: String[]
     */
    private static List<String> getRedPackage(double totalAmount, int number, double minAmount) {
        if (totalAmount <= 0 || number < 1 || minAmount < 0) {
            throw new NumberFormatException("传入参数有误！");
        }
        minAmount = minAmount == 0 ? 0.01 : minAmount;

        List<String> everyMoneys = new ArrayList<>();
        //最后一个人的红包=总金额-其他人的红包金额和。所以在循环时，去掉一个人，从1开始
        for (int i = 1; i < number; i++) {

            //剩余的人数
            int remainNumber = number - i;
            //最少剩余总金额：每个人至少都分最少的红包金额后的剩余金额
            double totalMinAmount = minAmount * remainNumber;
            //为了不出现红包分配不均衡的情况，取随机数时的上限为去掉最少剩余总金额的平均数
            double tempMax = (totalAmount - totalMinAmount) / remainNumber;
            //计算随机数，这个数就是一个红包的金额
            String temp = FORMAT.format(RANDOM.nextDouble() * (tempMax - minAmount) + minAmount);
            everyMoneys.add(temp);
            //总金额-这一次产生的金额，进入下次循环
            totalAmount -= Double.parseDouble(temp);
        }
        //把最后一次的金额加到红包列表中
        everyMoneys.add(FORMAT.format(totalAmount));
        return everyMoneys;
    }
}