public class RemoveDupFromArray2 {
    public int removeDuplicates(int[] A) {
        if (A.length <= 2)
            return A.length;

        int index = 1, curr = 2;

        while (curr < A.length) {
            if (A[curr] == A[index] && A[curr] == A[index - 1])
                curr++;
            else {
                ++index;
                A[index] = A[curr];
                ++curr;
            }
        }
        return index + 1;
    }
}
