package medium.priorityqueue;


import java.util.ArrayList;
import java.util.List;

class ExamRoom {
    private int n;
    private int cnt;
    private int[] arr = new int[]{};

    private List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        ExamRoom obj = new ExamRoom(10);
        int param_1 = obj.seat();
        int param_2 = obj.seat();
        int param_3 = obj.seat();
        int param_4 = obj.seat();
        //obj.leave(4);
        int param_5 = obj.seat();

        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
        System.out.println(param_5);
    }

    public ExamRoom(int n) {
        this.n = n;
        this.arr = new int[n];
    }

    public int seat() {
        if (cnt == 0) {
            arr[0] = 1;
            cnt++;
            return 0;
        }

        int lastOccupied = 0;
        int lengthOfFree = 0;
        int maxLengthOfFree = 0;
        int indexOfMaxLengthOfFree = 0;
        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length-1) {
                if (arr[i] == 0 && lengthOfFree > maxLengthOfFree) {
                    arr[i] = 1;
                    return arr.length-1;
                }


                indexOfMaxLengthOfFree = lengthOfFree > maxLengthOfFree ? lastOccupied : indexOfMaxLengthOfFree;
                maxLengthOfFree = Math.max(lengthOfFree, maxLengthOfFree);
                int index = indexOfMaxLengthOfFree + (maxLengthOfFree / 2);
                arr[index] = 1;
                return index;

            }
            else if (arr[i] == 0) {
                lengthOfFree++;
            } else {
                indexOfMaxLengthOfFree = lengthOfFree > maxLengthOfFree ? lastOccupied : indexOfMaxLengthOfFree;
                maxLengthOfFree = Math.max(lengthOfFree, maxLengthOfFree);

                lastOccupied = i;
                lengthOfFree = 0;
            }
        }
        return -1;

    }

    public void leave(int p) {

    }
}

