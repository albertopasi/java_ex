import java.util.NoSuchElementException;

public class Text implements Container
{   private int arrSize;
    private String[] arr;
    /*
        costruisce un contenitore di testo vuoto
    */
    public Text()
    {   arr = new String[1];
        makeEmpty();
    }

    /*
      ... metodi di Container da realizzare ...
    */

    /*
        restituisce il numero di elementi presenti nel contenitore
    */
    public int size()
    { return arrSize; 
    } 

    /*
        aggiunge la parola aWord in coda all'elenco
        se l'elenco e' pieno, ridimensiona l'elenco.
    */
    public void add(String aWord)
    {   if(arrSize==arr.length){
            String[] arr2 = new String[arrSize*2];
            System.arraycopy(arr, 0, arr2, 0, arrSize);
            arr=arr2;
        }
        arr[arrSize++]=aWord; 
    }

    /*
        ordina per fusione l'elenco delle parole.
    */
    public void sort()
    {   
        mergeSort(arr, arrSize);
    }

    private static void mergeSort(String[] v, int vSize){
        if(vSize<2) return;
        int mid=vSize/2;
        String[] left=new String[mid];
        String[] right=new String[vSize-mid];
        System.arraycopy(v, 0, left, 0, mid);
        System.arraycopy(v, mid, right, 0, vSize-mid);
        mergeSort(left, mid);
        mergeSort(right, vSize-mid);
        merge(v,left, right);
    }

    private static void merge(String[] v, String[] v1, String[] v2){
        int i=0,i1=0,i2=0;
        while(i1<v1.length && i2<v2.length){
            if(v1[i1].compareTo(v2[i2])<0){
                v[i++]=v1[i1++];
            }else{
                v[i++]=v2[i2++];
            }
        }
        while(i1<v1.length){
            v[i++]=v1[i1++];
        }
        while(i2<v2.length){
            v[i++]=v2[i2++];
        }
    }

    /*
        restituisce l'ultima parola dell'elenco, rimuovendola
        Lancia NoSuchElementException se l'elenco e' vuoto
    */
    public String removeLast()  throws NoSuchElementException
    {   if(isEmpty()) throw new NoSuchElementException();
        arrSize--;
        return arr[arrSize];
    }

    public void makeEmpty(){
        arrSize=0;
    }
    public boolean isEmpty(){
        return arrSize==0;
    }
}
