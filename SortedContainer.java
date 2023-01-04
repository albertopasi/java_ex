import java.util.NoSuchElementException;

public class SortedContainer implements Container
{   private Comparable[] v;
    private int vSize;
    /*
       Costruisce un contenitore vuoto
    */
    public SortedContainer()
    {
        v = new Comparable[1];
        vSize=0;
    }

    /*
      ... metodi di Container da realizzare ...
    */

    /*
        Aggiunge l'elemento compObj, ridimensionando l'array se necessario.
        L'elemento viene inserito in coda all'array e successivamente l'array
        viene ordinato. Andamento asintotico O(n) (prima dell'inserimento 
        l'array e' ordinato!)
    */
    public void add(Comparable compObj)
    {   if(vSize==v.length) v=resize(v, vSize*2);
        v[vSize++]=compObj;
        insertionSort(v, vSize);
    }

    public static void insertionSort(Comparable[] v, int vSize)
    {   // il ciclo inizia da 1 perche' il primo
        // elemento non richiede attenzione
        for (int i = 1; i < vSize; i++)
        {
            Comparable temp = v[i]; // nuovo elemento da inserire
            // j va definita fuori dal ciclo perche'
            // il suo valore finale viene usato in seguito
            int j;
            // sposta a destra di un posto tutti gli el. a
            // sin. di temp e > di temp, partendo da destra
            for (j = i; j > 0 && temp.compareTo(v[j-1]) < 0; j--)
                v[j] = v[j-1];
            v[j] = temp; // inserisci temp in posizione
        }
    }

    public Comparable[] resize(Comparable[] oldAr, int newLength)
    {
        Comparable[] v2 = new Comparable[newLength];
        System.arraycopy(oldAr, 0, v2, 0, vSize);
        return v2;
    }

    /*
        restituisce il valore massimo del contenitore (massimo nel senso 
        definito dal metodo compareTo()), e lo cancella dal contenitore. 
        Andamento asintotico O(1).
        Lancia NoSuchElementException se l'array e' vuoto
    */
    public Comparable removeMax() throws NoSuchElementException
    {   if(isEmpty()) throw new NoSuchElementException();
        vSize--;
        return v[vSize];

    }
    public void makeEmpty(){
        vSize=0;
    }
    public boolean isEmpty(){
        return vSize==0;
    }
}
