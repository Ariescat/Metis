package netty.hashedWheelTimer;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

public class TestHashedWheelTimer {

    public static void main(String[] args) {
        HashedWheelTimer timer = new HashedWheelTimer(24, //时间轮一圈的长度
                TimeUnit.SECONDS, 12);//时间轮的度刻

        TimerTask task = timeout -> System.out.println("任务执行");

        timer.newTimeout(task, 13, TimeUnit.SECONDS);
    }
}
