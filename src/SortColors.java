public class SortColors {
    public void sortColors(int[] A) {
        int red = 0, white = 0, blue = A.length - 1;
        while (white <= blue) {
            if (A[white] == 0) {
                swap(A, white++, red++);
            } else if (A[white] == 2) {
                swap(A, white, blue--);
            } else {
                white++;
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
