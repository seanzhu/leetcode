public class Sqrt {
    public int sqrt(int x) {
        int start = 0;
        int end = x / 2 < Math.sqrt(Integer.MAX_VALUE)? x/2+1:(int)Math.sqrt(Integer.MAX_VALUE);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int sqr = mid * mid;
            if (sqr == x)
                return mid;
            else if (sqr < x)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return end;
    }
}
