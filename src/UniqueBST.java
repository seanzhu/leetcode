public class UniqueBST {
    public int numTrees(int n) {
        if (n == 0)
            return 1;
        Double ret = (double) 1;
        for (int i = n + 2; i <= 2 * n; i++) {
            ret *= (double) i / (double) (i - n - 1);
        }
        return (int) Math.round(ret / n);
    }

    public static void main(String[] args) {
        UniqueBST test = new UniqueBST();
        System.out.println(test.numTrees(8));
    }
}
