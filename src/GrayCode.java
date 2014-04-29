import java.util.ArrayList;

public class GrayCode {
    public static ArrayList<Integer> grayCode(int n) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        if (n == 0) {
            result.add(0);
            return result;
        }

        result.add(0);result.add(1);

        for (int bit = 2; bit <= n; bit++) {
            for (int i = 0; i < (int)Math.pow(2, bit - 1); i++) {
                result.add(result.get((int)Math.pow(2, bit - 1) - 1 - i) + (int)Math.pow(2, bit - 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        printArray(grayCode(3));
    }

    public static void printArray(ArrayList<Integer> list) {
        System.out.println(list);
    }

}
