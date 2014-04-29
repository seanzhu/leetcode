import java.util.ArrayList;

public class PalindromePartitioning {

    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();

        if (s == null || s.length() == 0)
            return ret;
        ArrayList<String> currOutput = new ArrayList<String>();
        DFS(s, 0, currOutput, ret);
        return ret;
    }

    private void DFS(String s,
                     int start,
                     ArrayList<String> currOutput,
                     ArrayList<ArrayList<String>> ret) {
        if (start == s.length()) {
            ArrayList<String> found = new ArrayList<String>(currOutput);
            ret.add(found);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String prefix = s.substring(start, i + 1);
            if (isPalindrome(prefix)) {
                currOutput.add(prefix);
                DFS(s, i + 1, currOutput, ret);
                currOutput.remove(currOutput.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            ++start;
            --end;
        }
        return true;
    }
}
