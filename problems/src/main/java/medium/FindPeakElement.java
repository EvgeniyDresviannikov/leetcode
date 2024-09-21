package medium;

public class FindPeakElement {

    public static void main(String[] args) {
        System.out.println(new FindPeakElement().findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }


    public int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        while(start < end){

            int mid= start + (end-start) / 2;

            if (arr[mid] < arr[mid+1]) {
                start= mid+1;
            } else{
                end= mid;
            }
        }
        return start;
    }
}
