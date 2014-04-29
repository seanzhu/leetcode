public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int p = m + n - 1, p1 = m - 1, p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (A[p1] >= B[p2])
                A[p--] = A[p1--];
            else
                A[p--] = B[p2--];
        }

        while (p2 >= 0) {
            A[p--] = B[p2--];
        }
    }
}
