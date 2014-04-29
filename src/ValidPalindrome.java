public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !isChar(s.charAt(left)))
                ++left;
            while (left < right && !isChar(s.charAt(right)))
                --right;
            if (left == right)
                return true;

            if (s.charAt(left) != s.charAt(right))
                return false;

            ++left;
            --right;
        }
        return true;
    }

    private boolean isChar(char c) {
        if (c >= 'a' && c <= 'z')
            return true;
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }

    public static void main(String[] args) {
        ValidPalindrome test = new ValidPalindrome();
        System.out.println(test.isPalindrome("aa"));
    }
}
