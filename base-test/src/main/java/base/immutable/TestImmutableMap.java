package base.immutable;

import com.google.common.collect.ImmutableMap;

public class TestImmutableMap {

    /**
     * 这里根据entry的数量(0, 1, >1)会返回不同的ImmutableMap
     * <p>
     * 1. 在fromEntryArray里，会判断 <code> bucketSize > MAX_HASH_BUCKET_LENGTH </code> 来返回 JdkBackedImmutableMap 或是 RegularImmutableMap
     * 2. bucketSize是指同个entryIndex里的entry个数，MAX_HASH_BUCKET_LENGTH 为 8
     * 3. JdkBackedImmutableMap 是用 jdk 的 HashMap 再包装一层
     * <p>
     * RegularImmutableMap的优化主要是 <code> Hashing.smear(key.hashCode()) & mask </code>, mask为 <code> tableSize - 1 </code>, 把table的容量设置为真实的容量
     * 这里的smear算法有点像高低位扰动（为了散列更均匀，个人想法），这里可回想下jdk7和jdk8的HashMap的hash计算，下面贴了代码
     * <p>
     * ———— lqz 记于2019-07-22
     */
    public static void main(String[] args) {
        ImmutableMap.Builder<Integer, Integer> builder = ImmutableMap.builder();
        builder.put(1, 2);
        ImmutableMap<Integer, Integer> immutableMap = builder.build();
        System.err.println(immutableMap);
    }

    /**
     * @link https://www.cnblogs.com/xiaolovewei/p/7993521.html
     * 这是一个神奇的函数，用了很多的异或，移位等运算，对key的hashcode进一步进行计算以及二进制位的调整等来保证最终获取的存储位置尽量分布均匀
     */
    int hashSeed = 0;

    final int hash_jdk7(Object k) {
        int h = hashSeed;
//        if (0 != h && k instanceof String) {
//            return sun.misc.Hashing.stringHash32((String) k);
//        }

        h ^= k.hashCode();

        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
     * @link https://www.cnblogs.com/morethink/p/7762168.html
     */
    static final int hash_jdk8(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
