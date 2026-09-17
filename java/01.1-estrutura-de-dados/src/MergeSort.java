public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            //Divide esquerda
            mergeSort(arr, left, middle);

            //Divide Direita
            mergeSort(arr, middle + 1, right);

            //Mesclar
            merge(arr, left, middle, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {

        int size1 = middle - left + 1;
        int size2 = right - middle;


        int[] arrLeft = new int[size1];
        int[] arrRight = new int[size2];

        for (int i = 0; i < size1; i++) {
            arrLeft[i] = arr[left + i];
        }
        for (int j = 0; j < size2; j++) {
            arrRight[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0, k = left;


        while (i < size2 && j < size2) {
            if (arrLeft[i] <= arrRight[j]) {
                arr[k] = arrLeft[i];
                i++;
            } else {
                arr[k] = arrRight[j];
                j++;
            }
            k++;
        }

        while (i < size1) {
            arr[k] = arrLeft[i];
            i++;
            k++;
        }
        while (j < size2) {
            arr[k] = arrRight[j];
            j++;
            k++;
        }

    }

    private static void showArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " -> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== TESTE DO MERGE SORT ===\n");

        // Teste 1: Array aleatório
        int[] array1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array original:");
        showArray(array1);
        mergeSort(array1);
        System.out.println("Array ordenado:");
        showArray(array1);

        // Teste 2: Array com números negativos
        System.out.println("\nTeste 2 - Com números negativos:");
        int[] array2 = {-5, 10, -3, 0, 8, -1, 15};
        System.out.println("Array original:");
        showArray(array2);
        mergeSort(array2);
        System.out.println("Array ordenado:");
        showArray(array2);

        // Teste 3: Array já ordenado
        System.out.println("\nTeste 3 - Array já ordenado:");
        int[] array3 = {1, 2, 3, 4, 5};
        System.out.println("Array original:");
        showArray(array3);
        mergeSort(array3);
        System.out.println("Array ordenado:");
        showArray(array3);

        // Teste 4: Array com elementos duplicados
        System.out.println("\nTeste 4 - Com elementos duplicados:");
        int[] array4 = {5, 2, 8, 2, 9, 1, 5};
        System.out.println("Array original:");
        showArray(array4);
        mergeSort(array4);
        System.out.println("Array ordenado:");
        showArray(array4);
    }
}
