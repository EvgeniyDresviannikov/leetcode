package array.string.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandomO1 {

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());

    }
}

class RandomizedSet {

    private int len;
    private Map<Integer, Integer> map = new HashMap<>();
    private int[] arr = new int[1000000];
    private Random random = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        arr[len] = val;
        map.put(val, len);
        len++;
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int newVal = arr[len-1];
        arr[index] = newVal;
        map.put(newVal, index);
        map.remove(val);
        len--;
        return true;
    }

    public int getRandom() {
        if (len == 1) return arr[0];
        int index =   random.ints(0, len)
                .findFirst()
                .getAsInt();
        return arr[index];
    }
}
