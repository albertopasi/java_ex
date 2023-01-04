import java.util.*;
public class StudentManager{
    private static Student[] resize(Student[] array){
        Student[] array2 = new Student[array.length*2];
        System.arraycopy(array, 0, array2, 0, array.length);
        return array2;
    }

    private static int search(Student[] array, String cognome, int arraySize){
        for(int j=0; j<arraySize; j++){
            if(cognome.equalsIgnoreCase(array[j].getCognome())){
                return j;
            }
        }
        return -1;
    }



    public static void main(String[] args){
        Scanner c = new Scanner(System.in);
        System.out.println("Inserire \"Cognome VotoOrale VotoScritto\" degli studenti: ");
        Student[] array = new Student[2];
        int arraySize=0;
        boolean vuoto=false;
        do{
            String temp1= c.nextLine();
            if(temp1.equals("")){
                vuoto=true;
            }else{
                if(arraySize == array.length){
                    array= resize(array);
                }
                try{
                    array[arraySize]= new Student(temp1);
                    arraySize++;
                }
                catch(InputMismatchException e){
                    System.out.println("Reinserisci i nomi: ");
                }
                catch(NoSuchElementException e){
                    System.out.println("Reinserisci i nomi: ");
                }
            }
        }while(!vuoto);

        do{
            System.out.println("Inserire \"q\" per terminare il programma, \"s\" per cercare il cognome di uno studente: ");
            String comando = c.next();
            if(comando.equalsIgnoreCase("q")){
                break;
            }else if(comando.equalsIgnoreCase("s")){
                System.out.println("Inserire cognome: ");
                String cognome = c.next();
                int j = search(array, cognome, arraySize);
                if(j!=-1){
                        System.out.println("La media dei voti di " + cognome +" e': "+ array[j].getVoto());      
                }else{
                    System.out.println("Cognome errato.");
                }
            }else{
                System.out.println("Comando errato.");
            }

        }while(true);

        c.close();
    }

}



/*
import java.util.Scanner;
public class StudentManager{
     private static void resize(Student[] array){
        Student[] array2 = new Student[array.length*2];
        System.arraycopy(array, 0, array2, 0, array.length);
        array = array2;
    }
    public static void main(String[] args){
        Scanner c = new Scanner(System.in);
        System.out.println("Inserire \"Cognome VotoOrale VotoScritto\" degli studenti: ");
        Student[] array = new Student[10];
        int arraySize=0;
        do{
            String temp1= c.next();
            if(temp1.equals("")){
                break;
            }
            int temp2=c.nextInt();
            int temp3=c.nextInt();
            if(arraySize == array.length){
                resize(array);
            }
            array[arraySize++]= new Student(temp1, temp2, temp3);
        }while(true);







    }

} */