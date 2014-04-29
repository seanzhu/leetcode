public class SearchInRotateArray {
    public int search(int[] A, int target) {
        int left = 0, right = A.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target)
                return mid;

            if (A[mid] >= A[left]) {
                if (target > A[mid])
                    left = mid + 1;
                else if (target < A[left])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                if (target < A[mid])
                    right = mid - 1;
                else if (target < A[left])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

}
