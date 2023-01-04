import java.util.*;
public class ArrayAlgs1Tester {
    public static void main(String[] args){
        Scanner c = new Scanner(System.in);
        int l=0;
        while(l<=0){
            try{
                System.out.println("Inserire lunghezza array: ");
                l=c.nextInt();
            }
            catch(InputMismatchException e){
                c.nextLine();
            }
            catch(NoSuchElementException e){
                //vuoto
            }
        }
        int min=0, max=0;
        while(true){
            try{
                System.out.println("Inserire estremi: ");
                min=c.nextInt();
                max=c.nextInt();
                if(max<min){
                    int temp=max;
                    max=min;
                    min= temp;
                }
                break;
            }
            catch(InputMismatchException e){
                c.nextLine();
            }
            catch(NoSuchElementException e){
                //vuoto
            }
        }

        Random random = new Random();
        int[] array= new int[l];
        while(true){
            System.out.println("Inserire comando di ordinamento: ");
            String comando1= c.next();
            if(comando1.equalsIgnoreCase("s")){
                array= random.ints(l, min, max+1).toArray();
                System.out.println(ArrayAlgs1.printArray(array, l));
                ArrayAlgs1.selectionSort(array, l);
                System.out.println(ArrayAlgs1.printArray(array, l));
            }else if(comando1.equalsIgnoreCase("i")){
                array= random.ints(l, min, max+1).toArray();
                System.out.println(ArrayAlgs1.printArray(array, l));
                ArrayAlgs1.insertionSort(array, l);
                System.out.println(ArrayAlgs1.printArray(array, l));
            }else if(comando1.equalsIgnoreCase("m")){
                array= random.ints(l, min, max+1).toArray();
                System.out.println(ArrayAlgs1.printArray(array, l));
                ArrayAlgs1.mergeSort(array, l);
                System.out.println(ArrayAlgs1.printArray(array, l));
            }else if(comando1.equalsIgnoreCase("q")){
                break;
            }
        }
        int valore=0;
        
        while(true){
            do{
                try{
                    System.out.println("Inserire valore da cercare: ");
                    valore=c.nextInt();
                }
                catch(InputMismatchException e){
                    c.nextLine();
                }
                catch(NoSuchElementException e){
                    //vuoto
                }
            }while(min>valore && max<valore);
            System.out.println("Inserire comando di ricerca: ");
            String comando2= c.next();
            if(comando2.equalsIgnoreCase("l")){
                if(ArrayAlgs1.linearSearch(array, l, valore)!=-1){
                    System.out.println("Valore trovato");
                }else{
                    System.out.println("Valore non trovato");
                }
                
            }else if(comando2.equalsIgnoreCase("b")){
                if(ArrayAlgs1.binarySearch(array, l, valore)!=-1){
                    System.out.println("Valore trovato");
                }else{
                    System.out.println("Valore non trovato");
                }
            }else if(comando2.equalsIgnoreCase("q")){
                break;
            }
        }


        c.close();
    }
}
