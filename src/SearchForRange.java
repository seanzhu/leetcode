import java.util.Arrays;

public class SearchForRange {

    public static int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0)
            return null;
        int[] ret = new int[] {-1,-1};
        int head = searchMaxEqLess(A, target);
        int tail = searchMaxEqLess(A, target + 1);
//        System.out.println("head: " + head + "  tail: " + tail);

        if (head == tail)
            return ret;
        ret[0] = ++head;
        ret[1] = tail;
        return ret;
    }

    public static int searchMaxEqLess(int A[], int target) {
        int head = 0, tail = A.length - 1;

        while (head <= tail) {
            if (head == tail)
                return A[head] < target ? head : head - 1;
            if (head == tail - 1)
                return A[tail] < target ? tail :
                        (A[head] < target ? head : head - 1);

            int mid = head + (tail - head) / 2;
            if (A[mid] < target)
                head = mid;
            else
                tail = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(test, 8)));
    }
}
