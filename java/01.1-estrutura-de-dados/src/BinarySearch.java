public class BinarySearch {


    public static int search(int[] arr, int value) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;

            if (arr[middle] == value) {
                return middle;
            }

            if (arr[middle] < value) {
                start = middle + 1;

            } else {
                end = middle - 1;
            }
        }

        return -1;
    }


    static void main(String[] args) {
        int[] nums = {1, 45, 56, 22, 204};
        System.out.println(search(nums, 22));
    }
}
