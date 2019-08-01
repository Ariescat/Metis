package koloboke;

import net.openhft.koloboke.collect.map.hash.HashIntObjMap;
import net.openhft.koloboke.collect.map.hash.HashIntObjMaps;
import net.openhft.koloboke.collect.map.hash.HashObjObjMap;
import net.openhft.koloboke.collect.map.hash.HashObjObjMaps;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        HashIntObjMap<TestObj> map = HashIntObjMaps.newUpdatableMap();
        // 直接put int类型，避免装箱 ！！！
        map.put(1, new TestObj(1));
        map.put(12, new TestObj(12));
        map.put(3, new TestObj(3));
        map.put(17, new TestObj(3));
        map.put(new Integer(4), new TestObj(4));
        System.err.println(map);

        map.get(12);
        map.get(5);

        Map<Integer, Integer> jdkMap = new HashMap<>();
        // jdk map 会自动装箱
        jdkMap.put(1, 1);

        HashObjObjMap<TestObj, TestObj> objObjMap = HashObjObjMaps.newUpdatableMap();
        objObjMap.put(new TestObj(1), new TestObj(3));
    }
}
