import java.util.*;
public class SortedArray
{   
    private int[] array;
    private int arraySize;

    /*
        Crea un oggetto SortedArray vuoto
    */
    public SortedArray()
    {   array=new int[1]; 
        arraySize=0;
    }

    /*
        verifica se l'array e` vuoto. Prestazioni O(1)
    */
    public boolean isEmpty()
    {   return arraySize==0;
    }

    /*
        Aggiunge il valore value all'array ordinato, conservando l'ordinamento.
        Prestazioni O( n) (prima dell'inserimento l'array e' ordinato!)
    */
    public void add(int value)
    {   if(arraySize==array.length){
            int[] array2=new int[array.length*2];
            System.arraycopy(array, 0, array2, 0, array.length);
            array=array2;
        }
        int j=0;
        for(j=arraySize; j>0 && value<array[j-1]; j--){
            array[j]=array[j-1];
            
        }
        array[j]=value;
        arraySize++;
    }

    /*
        Cancella il valore massimo dall'array, e lo restituisce.
        Prestazioni O(1). Lancia NoSuchElementException se l'array e' vuoto
    */
    public int removeMax()
    {   if(arraySize==0) throw new NoSuchElementException();
        arraySize--;
        return array[arraySize];
    }


    public String toString(){
        String a="";
        for(int j=0; j<arraySize; j++){
            a = a + array[j] + " ";
        }
        return a;
    }


    /*
        Restituisce la media (average) dei valori dell'array
        Prestazioni O( n)
    */
    public double avg()
    {   int somma=0;
        for(int j=0; j<arraySize; j++){
            somma += array[j];
        } 
        return somma/(double) arraySize;
    }

    /*
        Cerca un numero value nell'array ordinato (ricerca binaria).
        Prestazioni O(log n). Restituisce l'indice nell'array dell'intero 
        value se questo viene trovato, altrimenti restituisce il valore -1
    */
    public int search(int value)
    {
        return binSearch(0, arraySize-1, value);
    }
    private int binSearch(int from, int to, int value)
    {  
        if (from > to) return -1;// el. non trovato
        int mid = (from + to) / 2; // circa in mezzo
        int middle = array[mid];
        if (middle == value)
            return mid; // elemento trovato
        else if (middle < value)  //cerca a destra
            return binSearch(mid + 1, to, value);
        else // cerca a sinistra
            return binSearch(from, mid - 1, value);
    }

}