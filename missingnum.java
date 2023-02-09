public class missingnum {
    public static int missNum(int[] a) {
        return missNum2(a, 0, a.length - 1);
    }

    public static int missNum2(int[] a, int from, int to) {
        if (from == to) {
            if (a[to] == to)
                return to + 1;
            else
                return to;
        }
        int midpos = (from + to) / 2;
        int mid = a[midpos];
        if (midpos == mid)
            return missNum2(a, midpos + 1, to);
        else
            return missNum2(a, from, midpos - 1);
    }

    public static void main(String[] args) {
        int[] a = { 0, 2, 3, 4, 5, 6, 7 };
        System.out.println(missNum(a));
    }

}
