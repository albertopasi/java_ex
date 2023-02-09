
public class gemelliarray {

    static int countTwins(int[] a, int[] b) {
        int count = 0;
        boolean previnA = false;
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                if (!(i == 0 && j == 0)) {
                    if (previnA)
                        count++;
                }
                previnA = true;
                i++;
            } else {
                if (!(i == 0 && j == 0)) {
                    if (!previnA)
                        count++;
                }
                previnA = false;
                j++;
            }
        }
        while (i < a.length) {
            if (previnA)
                count++;
            previnA = true;
            i++;
        }
        while (j < b.length) {
            if (!previnA)
                count++;
            previnA = false;
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 5, 8, 9, 10, 11, 14 };
        int[] b = { 4, 6, 7, 12, 13 };

        System.out.println(countTwins(a, b));

    }

}