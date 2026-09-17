public class BoubbleSort {
    public static void boubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    static void main(String[] args) {
        int[] nums = {5, 3, 8, 4, 2};

        System.out.println("Antes da ordenação: ");
        for(int n : nums) {
            System.out.print(n + " -> ");
        }

        boubbleSort(nums);
        System.out.println(".");
        System.out.println("Depois da ordenação: ");
        for(int n : nums) {
            System.out.print(n + " -> ");
        }

    }
}
