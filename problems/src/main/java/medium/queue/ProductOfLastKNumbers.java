package medium.queue;

public class ProductOfLastKNumbers {

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        System.out.println(productOfNumbers.getProduct(2)); // return 20. The product of the last 2 numbers is 5 * 4 = 20
        System.out.println(productOfNumbers.getProduct(3)); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
        System.out.println(productOfNumbers.getProduct(4)); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        System.out.println(productOfNumbers.getProduct(2)); // return 32. The product of the last 2 numbers is 4 * 8 = 32
    }
}


class ProductOfNumbers {

    int[] nums;
    int end;

    public ProductOfNumbers() {
        nums  = new int[10000];
        end = -1;
    }

    public void add(int num) {
        end++;
        nums[end] = num;
    }

    public int getProduct(int k) {
        int res = 1;
        for (int i = end; i > end - k; i--) {
            res *= nums[i];
            if (res == 0) return 0;
        }
        return res;
    }
}
