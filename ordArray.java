public class ordArray {
    static void order(int[] a) {
        int ip = 0, in = a.length - 1;
        while (true) {
            while (a[ip] > 0 && ip < a.length)
                ip++;
            while (a[in] <= 0 && in > 0)
                in--;
            if (ip >= in)
                break;
            int temp = a[in];
            a[in] = a[ip];
            a[ip] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, -2, 0, 5, -4, 1, 2, -3 };
        order(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
    }
}