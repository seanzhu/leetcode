import java.util.HashMap;

public class MaxPointsonLine {

    class Point {
        int x, y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }


    public static int maxPoints(Point[] points) {
        int result = 0;

        if (points == null)
            return 0;
        int number = points.length;
        if (number <= 2)
            return number;

        // use irreducible fraction to store each slope, not double
        HashMap<String, Integer> record = new HashMap<String, Integer>();

        for (int i = 0; i < number - 1; i++) {
            int dup = 1;
            int max = 0;
            record.clear();
            for (int j = i + 1; j < number; j++) {
                int x, y, gcdXY;
                if (points[i].x > points[j].x) {
                    x = points[i].x - points[j].x;
                    y = points[i].y - points[j].y;
                } else {
                    x = points[j].x - points[i].x;
                    y = points[j].y - points[i].y;
                }
                gcdXY = gcd(Math.abs(x), Math.abs(y));
                if (gcdXY == 0)
                    ++dup;
                else {
                    x /= gcdXY;
                    y /= gcdXY;

                    if (x == 0 || y==0) {
                        x = Math.abs(x);
                        y = Math.abs(y);
                    }

                    // fixed format
                    String key = x + "|" + y;
                    int value = 0;
                    if (record.containsKey(key))
                        value = record.get(key);
                    record.put(key, ++value);
                    max = Math.max(max, value);
                }
            }
            result = Math.max(result, max +dup);
        }
        return result;

    }

    public static int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }

    public static void main(String[] args) {

    }

}
