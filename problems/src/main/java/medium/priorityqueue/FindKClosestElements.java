package medium.priorityqueue;

import java.util.*;

public class FindKClosestElements {

    public static void main(String[] args) {
        System.out.println(new FindKClosestElements().findClosestElements(new int[]{3,5,8,10}, 2, 15));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        int l = 0; int r = len - 1;
        int closest = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                closest = mid;
                break;
            }

            if (arr[mid] > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (closest == -1) {
            if (r < 0) {
                closest = l;
            } else if (l > len-1) {
                closest = r;
            } else if (Math.abs(x - arr[r]) <= Math.abs(x - arr[l])) {
                closest = r;
            } else {
                closest = l;
            }
        }
        k -= 1;
        l = closest; r = closest;
        while (k > 0) {
           if (l == 0) {
               r++;
           } else if (r == len-1 || Math.abs(arr[l - 1] - x) <= Math.abs(arr[r + 1] - x)) {
               l--;
           } else {
               r++;
           }
           k--;
        }

        return Arrays.stream(Arrays.copyOfRange(arr, l, r+1)).boxed().toList();


    }
}
