public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int[] diff = new int[length];
        for (int i = 0; i < length; i++)
            diff[i] = gas[i] - cost[i];

        int left = 0, sum = 0, start = 0;
        for (int i = 0; i < length; i++) {
            left += diff[i];
            sum += diff[i];
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        if (left >= 0)
            return start;
        else
            return -1;
    }
}
