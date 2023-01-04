public class SecondoAppEs1 {
    public static void main(String[] args){
        int[] v = {3, 5, 4, 6, 3, 2, 9};
        System.out.println("******Contenuto array*******");
        for (int i : v) {
            System.out.print(i+" ");
        }
        System.out.println("\n");
        for(int i=0; i<v.length; i++){
            boolean found = true;
            if((i-1>=0 && v[i]<v[i-1]) || (i-2>=0 && v[i]<v[i-2]) || (i+1<v.length && v[i]<v[i+1]) || (i+2<v.length && v[i]<v[i+2])){
                found=false;
            }
            if(found){
                System.out.println(v[i] + " e' massimo locale.");
            }
        }
    }
}
