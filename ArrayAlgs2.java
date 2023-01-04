public class ArrayAlgs2
{
    public static void selectionSort(Comparable[] v, int vSize)
    {
        for (int i = 0; i < vSize - 1; i++)
        {   int minPos = findMinPos(v, i, vSize-1);
            if (minPos != i) swap(v, minPos, i);
        }
    }
    private static void swap(Comparable[] v, int i, int j)
    {   Comparable temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
    private static int findMinPos(Comparable[] v, int from, int to)
    {   int pos = from;
        Comparable min = v[from];
        for (int i = from + 1; i <= to; i++)
            if (v[i].compareTo(min) < 0)
            {   pos = i;      
                min = v[i];   }
        return pos;
    }


    public static void mergeSort(Comparable[] v, int vSize)
    {
        if (vSize < 2) return; // caso base
        int mid = vSize / 2; //dividiamo circa a meta`
        Comparable[] left = new Comparable[mid];
        Comparable[] right = new Comparable[vSize - mid];
        System.arraycopy(v, 0, left, 0, mid);
        System.arraycopy(v, mid, right, 0, vSize-mid);
        // passi ricorsivi: ricorsione multipla (doppia)
        mergeSort(left, mid);
        mergeSort(right, vSize-mid);
        // fusione (metodo ausiliario)
        merge(v, left, right);
    }
    private static void merge(Comparable[] v, Comparable[] v1, Comparable[] v2)
    {  
        int i = 0, i1 = 0, i2 = 0;
        while (i1 < v1.length && i2 < v2.length)
            if (v1[i1].compareTo(v2[i2]) < 0)
                // prima si usa i, poi lo si incrementa...
                v[i++] = v1[i1++];
            else
                v[i++] = v2[i2++];
        while (i1 < v1.length)
            v[i++] = v1[i1++];
        while (i2 < v2.length)
            v[i++] = v2[i2++];
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

    // --------------------- algoritmi di ricerca su Array ------------------

    public static int linearSearch(Comparable[] v, int vSize, Comparable value)
    {
        for (int i = 0; i < vSize; i++)
            if (v[i].compareTo(value) == 0) return i; // trovato valore
        return -1;  // valore non trovato
    }

    public static int binarySearch(Comparable[] v, int vSize, Comparable value)
    {
        return binSearch(v, 0, vSize-1, value);
    }
    private static int binSearch(Comparable[] v, int from, int to, 
                                 Comparable value)
    {  
        if (from > to) return -1;// el. non trovato
        int mid = (from + to) / 2; // circa in mezzo
        Comparable middle = v[mid];
        if (middle.compareTo(value) == 0)
            return mid; // elemento trovato
        else if (middle.compareTo(value) < 0)  //cerca a destra
            return binSearch(v, mid + 1, to, value);
        else // cerca a sinistra
            return binSearch(v, from, mid - 1, value);
   }    //ATTENZIONE: e` un algoritmo con ricorsione SEMPLICE



    // ----------------------- altri metodi di utilita` ---------------------

    // Ridimensiona l'array oldv attribuendogli la lunghezza newLength
    public static Comparable[] resize(Comparable[] oldv, int newLength)
    {
        if (newLength < 0 || oldv == null)
            throw new IllegalArgumentException();
        Comparable[] newv = new Comparable[newLength];
        int count = oldv.length;
        if (newLength < count) 
            count = newLength;
        for (int i = 0; i < count; i++)
            newv[i] = oldv[i];
        return newv;
    }

    //Stampa tutti gli elementi di un array.
    public static String printArray(Comparable[] v, int vSize)
    {
        String s = "[";
        for (int i = 0; i<vSize; i++)
            s = s + v[i] + " ";
        s = s + "\b]";
        return s;
    }
    
}