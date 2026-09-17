public class SelectionSort {

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }

    static void main(String[] args) {
        int[]nums = {29,10,14,37,13};

        System.out.println("Antes da ordenação: ");
        for(int n : nums) {
            System.out.print(n + " -> ");
        }

        selectionSort(nums);
        System.out.println(".");
        System.out.println("Depois da ordenação: ");
        for(int n : nums) {
            System.out.print(n + " -> ");
        }

    }
}
