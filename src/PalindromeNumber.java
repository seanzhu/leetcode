public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        // count digit
        int digit = 0, temp = x;
        while (temp > 0) {
            ++digit;
            temp /= 10;
        }

        int left, right;
        while (digit > 0) {
            temp = (int)Math.pow(10, digit - 1);
            left = x / temp;
            right = x % 10;
            if (left != right)
                return false;
            x = (x - left * temp) / 10;
            digit -= 2;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(12322));
        System.out.println(isPalindrome(23332));
        System.out.println(isPalindrome(23344));
        System.out.println(isPalindrome(2332));
        System.out.println(isPalindrome(0));
    }
}
