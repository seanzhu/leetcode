import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {


    public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        dict.remove(start);
        int ret = 1;
        int currNum = 1;

        while (!queue.isEmpty()) {
            int temp = 0;
            for (int i = 0; i < currNum; i++) {
                String word = queue.poll();
                if (word.equals(end))
                    return ret;

                // get adjacent words
                for (int k = 0; k < word.length(); k++) {
                    StringBuilder builder = new StringBuilder(word);
                    // for each character in word
                    for (char c = 'a'; c <= 'z'; c++) {
                        builder.setCharAt(k, c);
                        String testStr = builder.toString();
                        if (dict.contains(testStr)) {
                            queue.add(testStr);
                            dict.remove(testStr);
                            ++temp;
                        }
                    }
                }

            }
            ++ret;
            currNum = temp;
        }
        return 0;
    }

}


