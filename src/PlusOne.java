public class PlusOne {
    public int[] plusOne(int[] digits) {
        int i;
        for (i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else
                digits[i] = 0;
        }
        if (i < 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (i = 1; i <= digits.length; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }
        return digits;
    }
}
