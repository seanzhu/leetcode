public class SingleNumber {
    public static int singleNumber(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum ^= i;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
