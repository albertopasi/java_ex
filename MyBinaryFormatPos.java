import java.util.Scanner;

public class MyBinaryFormatPos {
    public static void main (String[] args){
        Scanner console = new Scanner(System.in);
        int num;
        do{
            System.out.println("Inserisci numero tra -128 e 127: ");
            num = console.nextInt();
        }while(num<-128 || num>127);
        int a = num;
        String n ="";
        if(num>=0){
            for(int j=0; j<8; j++ ){
                n = Integer.toString(num % 2) + n;
                num /= 2;
                if(j==3)
                    n = "_" + n;
            }
            System.out.println("il numero " + a + " convertito in complemento a due e': " + "0d" + n);
        }else{
            num *= -1;         
            for(int j=0; j<8; j++ ){
                n = Integer.toString(num % 2) + n;
                num /= 2;
                if(j==3)
                    n = "_" + n;
            }

            n = n.replace('0' , 'q');
            n = n.replace('1' , '0');
            n = n.replace('q' , '1');

            String m = "";
            for(int j = n.length() - 1 ; j >= 0 ; j--){
                char c = n.charAt(j);
                if(c == '0'){
                    m = n.substring(0, j) + "1";
                    for(int k=0; k < n.length()-j-1 ; k++){
                        m += "0";
                    }
                    break;
                }
            }
        System.out.println("il numero " + a + " convertito in complemento a due e': " + "0d" + m);
        }
        console.close();
    }
}
