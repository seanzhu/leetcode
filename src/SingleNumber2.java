public class SingleNumber2 {
//    public static int singleNumber(int[] A) {
//        int ret = 0;
//        for (int i = 0; i < 32; i++) {
//            int bit = 0;
//            for (int j = 0; j < A.length; j++) {
//                bit = (bit + ((A[j] >> i) & 1)) % 3;
//            }
//            if (bit > 0)
//                bit = 1;
//            ret += (bit << i);
//        }
//        return ret;
//    }

    public static int singleNumber(int[] A) {
        int one = 0, two = 0, three = 0;
        for (int num : A) {
            two = two | one & num;
            one = one ^ num;
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}
