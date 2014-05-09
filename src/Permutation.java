import java.util.ArrayList;

public class Permutation {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ret.add(new ArrayList<Integer>());

        for (int i = 0; i < num.length; i++) {
            ArrayList<ArrayList<Integer>> newRet = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> curr : ret) {
                for (int j = 0; j <= curr.size(); j++) {
                    ArrayList<Integer> temp = new ArrayList<Integer>(curr);
                    temp.add(j, num[i]);
                    newRet.add(temp);
                }
            }
            ret = newRet;
        }

        return ret;
    }

    public static void main(String[] args) {
        Permutation test = new Permutation();
        int[] num = new int[] {1,2,3};
        System.out.println(test.permute(num));
    }
}
