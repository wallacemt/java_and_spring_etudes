package buscas.linear;

public class LinearSearch {

    public static int search(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }


    static void main(String[] args) {
        int[] nums = {1, 45, 56, 22, 204, 102, 22, 9};
        System.out.println(search(nums, 204));
    }
}
