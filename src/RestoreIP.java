import java.util.ArrayList;

public class RestoreIP {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> ret = new ArrayList<String>();
        getAddr(s, "", ret, 4);
        return ret;
    }

    private void getAddr(String s, String t, ArrayList<String> ret, int remain) {
        if (remain == 0) {
            if (s.length() == 0)
                ret.add(t);
        } else {
            for (int i = 1; i <= 3; i++) {
                if (s.length() >= i && isValid(s.substring(0, i))) {
                    if (remain == 4)
                        getAddr(s.substring(i), t + s.substring(0, i), ret, remain - 1);
                    else
                        getAddr(s.substring(i), t + "." + s.substring(0, i), ret, remain - 1);
                }
            }
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0')
            return false;
        return s.length() > 0 && s.length() <= 3 && Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 255;
    }
}
