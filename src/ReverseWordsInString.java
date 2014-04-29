public class ReverseWordsInString {
    public static String reverseWords(String s) {
        if (s.isEmpty() || s.length() == 0)
            return s;

        // store one word
        StringBuffer buffer = new StringBuffer();

        // head and tail index for one word
        int head, tail;

        for (int i = s.length() - 1; i >= 0; i--) {
            while (i >= 0 && s.charAt(i) ==' ') i--;
            if (i < 0)
                break;
            // set tail
            tail = i;

            // set head
            while (i >=0 && s.charAt(i) != ' ') i--;
            head = ++i;

            // if not the first word, append a space char before the word
            if (head <= tail && buffer.length() > 0)
                buffer.append(' ');

            for (int j = head; j <= tail; j++)
                buffer.append(s.charAt(j));
        }

        return buffer.toString();

    }

    public static void main(String[] args) {
        String raw = "the sky is blue";
        String reverse = reverseWords(raw);
        System.out.println(reverse);
    }
}
