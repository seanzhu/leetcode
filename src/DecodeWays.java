public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        int[] table = new int[n + 1];
        table[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0')
                table[i] += table[i - 1];
            if (i >= 2 && (
                    s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'
            ))
                table[i] += table[i - 2];
        }

        return table[n];
    }

    public static void main(String[] args) {
        DecodeWays test = new DecodeWays();
        System.out.println(test.numDecodings("17"));
    }
}
