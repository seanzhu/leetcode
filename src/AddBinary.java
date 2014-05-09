public class AddBinary {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        char[] ret = new char[m > n ? m + 1 : n + 1];
        int index = ret.length - 1, carry = 0;
        for (int i = m - 1, j = n - 1; i >= 0 || j >= 0; i--, j--) {
            int ai = i >= 0 ? a.charAt(i) - '0' : 0;
            int bj = j >= 0 ? b.charAt(j) - '0' : 0;
            ret[index] = (char) ('0' + (ai + bj + carry) % 2);
            carry = (ai + bj + carry) / 2;
            index--;
        }
        if (carry > 0)
            ret[index] = (char) ('0' + carry);
        return String.valueOf(ret).trim();
    }

    public static void main(String[] args) {
        AddBinary test = new AddBinary();
        System.out.println(test.addBinary("0", "0"));
    }
}
