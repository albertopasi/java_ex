import java.util.*;
public class lab7es6 {

    private static int findMin(int[] a){
        if(a.length==1){
            return a[0];
        }
        int[] copia= new int[a.length-1];
        System.arraycopy(a, 1, copia, 0, a.length-1);
        int min= findMin(copia);
        if(a[0]<=min){
            return a[0];
        }
        return min;
    }
    public static void main(String[] args){
        Random random = new Random();
        int[] array = random.ints(Integer.parseInt(args[0]), 1, Integer.parseInt(args[1])+1).toArray();
        for(int j=0; j<array.length-1; j++){
            System.out.print(array[j] + " ");
        }
        System.out.println("\nIl valore minimo e': " + findMin(array));

    }
}
