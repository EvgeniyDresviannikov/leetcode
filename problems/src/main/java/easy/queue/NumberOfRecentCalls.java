package easy.queue;

public class NumberOfRecentCalls {

    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        System.out.println(obj.ping(1));
        System.out.println(obj.ping(100));
        System.out.println(obj.ping(3001));
        System.out.println(obj.ping(3002));

    }
}


class RecentCounter {
    int start;
    int end;

    int[] calls;

    public RecentCounter() {
        start = 0;
        end = 0;

        calls = new int[10000];
    }

    public int ping(int t) {

        while (start < end && t - calls[start] > 3000) {
            start++;
        }

        calls[end++] = t;


        return end - start;
    }
}
