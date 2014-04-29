import java.util.Set;

public class WordBreak {
    public static boolean wordBreak(String s, Set<String> dict) {
        String newString = "#" + s;
        int length = newString.length();
        boolean[] possible = new boolean[length];

        possible[0] = true;
        for (int i = 1; i < length; i++) {
            possible[i] =false;
            for (int k = 0; k < i; k++) {
                if (possible[k] && dict.contains(newString.substring(k + 1, i + 1))) {
                    possible[i] = true;
                    break;
                }
            }
        }
        return possible[length - 1];
    }

    public static void main(String[] args) {

    }
}
