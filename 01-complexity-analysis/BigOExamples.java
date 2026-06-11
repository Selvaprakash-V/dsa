public class BigOExamples {

    // ─── O(1) — Constant ───────────────────────────────────────────
    // No matter how large the array, always one operation
    public static int getFirst(int[] arr) {
        return arr[0];
    }

    // ─── O(log n) — Logarithmic ────────────────────────────────────
    // Input is halved each iteration
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // avoids overflow vs (left+right)/2
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // ─── O(n) — Linear ─────────────────────────────────────────────
    // Visits each element once
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // ─── O(n log n) — Linearithmic ─────────────────────────────────
    // Merge sort: splits log n times, merges n elements each time
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] L = new int[n1], R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // ─── O(n²) — Quadratic ─────────────────────────────────────────
    // Nested loops — each element compared with every other
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    // ─── O(2ⁿ) — Exponential ───────────────────────────────────────
    // Each call spawns 2 more calls — tree doubles every level
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // ─── O(n!) — Factorial ─────────────────────────────────────────
    // Generates all permutations of a string
    public static void permutations(String str, String current) {
        if (str.isEmpty()) {
            System.out.println(current);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            permutations(
                str.substring(0, i) + str.substring(i + 1),
                current + str.charAt(i)
            );
        }
    }

    // ─── Driver ────────────────────────────────────────────────────
    public static void main(String[] args) {
        int[] sorted = {1, 3, 5, 7, 9, 11};

        System.out.println("O(1)      getFirst       → " + getFirst(sorted));
        System.out.println("O(log n)  binarySearch 7 → " + binarySearch(sorted, 7));
        System.out.println("O(n)      linearSearch 9 → " + linearSearch(sorted, 9));

        int[] unsorted = {5, 3, 8, 1, 9, 2};
        mergeSort(unsorted, 0, unsorted.length - 1);
        System.out.print("O(n logn) mergeSort      → ");
        for (int x : unsorted) System.out.print(x + " ");
        System.out.println();

        int[] arr2 = {64, 34, 25, 12};
        bubbleSort(arr2);
        System.out.print("O(n²)     bubbleSort     → ");
        for (int x : arr2) System.out.print(x + " ");
        System.out.println();

        System.out.println("O(2ⁿ)     fibonacci(6)  → " + fibonacci(6));
        System.out.print("O(n!)     permutations   → ");
        permutations("ABC", "");
    }
}