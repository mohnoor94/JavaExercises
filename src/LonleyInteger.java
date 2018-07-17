import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class LonleyInteger {
    public static void main(String[] args) {
        System.out.println(lonelyinteger(new int[]{1, 2, 3, 6, 5, 6, 5, 2, 1}));

//        int x = 18;
//        System.out.println(Integer.toBinaryString((5 << 2)));
    }

    static int lonelyinteger(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            if (map.containsKey(i))
                map.merge(i, map.get(i), (x, y) -> x + y);
            else
                map.put(i, 1);
        }

        AtomicInteger value = new AtomicInteger();
        map.forEach((k, v) -> {
            if (v == 1) value.set(k);
        });

        return value.get();
    }
}
