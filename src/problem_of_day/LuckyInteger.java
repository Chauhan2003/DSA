package problem_of_day;

import java.util.HashMap;

public class LuckyInteger {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3};

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxValue = -1;

        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == key) {
                maxValue = Math.max(maxValue, key);
            }
        }

        System.out.println("Lucky integer: " + maxValue);
    }
}

//        | Aspect           | `map.entrySet()` version                              | `map.keySet()` + `map.get(key)` version                  |
//        | ---------------- | ----------------------------------------------------- | -------------------------------------------------------- |
//        | Access method    | Directly accesses both `key` and `value` from `entry` | Accesses `key` and retrieves value with `map.get(key)`   |
//        | Efficiency       | Slightly **faster**, no extra lookups                 | Slightly **slower**, one extra hash lookup per iteration |
//        | Code readability | More explicit (clearly uses key-value pair)           | Simpler if you only care about the key                   |

