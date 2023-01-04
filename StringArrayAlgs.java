public class StringArrayAlgs{

    // ---------------- semplici algoritmi su array ---------------------------
    public static void remove(String[] v, int vSize, int index)
    {
        v[index] = v[vSize - 1];
    }

    public static void removeSorted(String[] v, int vSize, int index)
    {
        for (int i=index; i<vSize-1; i++)
            v[i] = v[i + 1];
    }

    public static String[] insert(String[] v, int vSize, int index, String value)
    {
        if (vSize == v.length)
            v = resize(v, 2*v.length);
        for (int i = vSize; i > index; i--)
            v[i] = v[i - 1];
        v[index] = value;
        return v;
    }

    public static String findMin(String[] v, int vSize)
    {
        String min = v[0];
        for (int i = 1; i < vSize; i++)
            if (v[i].compareTo(min)<0)
                min = v[i];
        return min;
    }

    public static String findMax(String[] v, int vSize)
    {
        String max = v[0];
        for (int i = 1; i < vSize; i++)
        if (v[i].compareTo(max)>0)
                max = v[i];
        return max;
    }


    // ---------------------- algoritmi di ordinamento su Array ----------------

    public static void selectionSort(String[] v, int vSize)
    {
        for (int i = 0; i < vSize - 1; i++)
        {   int minPos = findMinPos(v, i, vSize-1);
            if (minPos != i) swap(v, minPos, i);
        }
    }
    private static void swap(String[] v, int i, int j)
    {   String temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
    private static int findMinPos(String[] v, int from, int to)
    {   int pos = from;
        String min = v[from];
        for (int i = from + 1; i <= to; i++)
            if (v[i].compareTo(min)<0)
            {   pos = i;      
                min = v[i];   }
        return pos;
    }

    public static void iterMerge(String[] v, int vSize){
        for(int j=1; j<vSize; j=j*2){
            for(int k=0; k<vSize; k+=2*j){
                String[] sottoarr1=new String[j];
                System.arraycopy(v, k, sottoarr1, 0, j);
               // System.out.println(printArray(sottoarr1, sottoarr1.length));
                String[] sottoarr2=new String[j];
                System.arraycopy(v, k+j, sottoarr2, 0, j);
               // System.out.println(printArray(sottoarr2, sottoarr2.length));
                mergeIter(v,k, sottoarr1, sottoarr2);            
               // System.out.println(printArray(finale, vSize));

            }
        }
    }
    private static void mergeIter(String[] v,int i, String[] v1, String[] v2)
    {  
        int i1 = 0, i2 = 0;
        while (i1 < v1.length && i2 < v2.length){
            if (v1[i1].compareTo(v2[i2])<0)
                // prima si usa i, poi lo si incrementa...
                v[i++] = v1[i1++];
            else
                v[i++] = v2[i2++];
        }
        while (i1 < v1.length)
            v[i++] = v1[i1++];
        while (i2 < v2.length)
            v[i++] = v2[i2++];
    }


    public static void mergeSort(String[] v, int vSize)
    {
        if (vSize < 2) return; // caso base
        int mid = vSize / 2; //dividiamo circa a meta`
        String[] left = new String[mid];
        String[] right = new String[vSize - mid];
        System.arraycopy(v, 0, left, 0, mid);
        System.arraycopy(v, mid, right, 0, vSize-mid);
        // passi ricorsivi: ricorsione multipla (doppia)
        mergeSort(left, mid);
        mergeSort(right, vSize-mid);
        // fusione (metodo ausiliario)
        merge(v, left, right);
    }
    private static void merge(String[] v, String[] v1, String[] v2)
    {  
        int i = 0, i1 = 0, i2 = 0;
        while (i1 < v1.length && i2 < v2.length){
            if (v1[i1].compareTo(v2[i2])<0)
                // prima si usa i, poi lo si incrementa...
                v[i++] = v1[i1++];
            else
                v[i++] = v2[i2++];
        }
        while (i1 < v1.length)
            v[i++] = v1[i1++];
        while (i2 < v2.length)
            v[i++] = v2[i2++];
    }

    public static void insertionSort(String[] v, int vSize)
    {   // il ciclo inizia da 1 perché il primo
        // elemento non richiede attenzione
        for (int i = 1; i < vSize; i++)
        {
            String temp = v[i]; // nuovo elemento da inserire
            // j va definita fuori dal ciclo perche'
            // il suo valore finale viene usato in seguito
            int j;
            // sposta a destra di un posto tutti gli el. a
            // sin. di temp e > di temp, partendo da destra
            for (j = i; j > 0 && temp.compareTo(v[j-1])<0; j--)
                v[j] = v[j-1];
            v[j] = temp; // inserisci temp in posizione
        }
    }

    // --------------------- algoritmi di ricerca su Array ------------------

    public static int linearSearch(String[] v, int vSize, String value)
    {
        for (int i = 0; i < vSize; i++)
            if (v[i].equals(value)) return i; // trovato valore
        return -1;  // valore non trovato
    }

    public static int binarySearch(String[] v, int vSize, String value)
    {
        return binSearch(v, 0, vSize-1, value);
    }
    private static int iterativeBinSearch(String[] v, int from, int to, String value)
    {   
        while(from>to){
            int mid = (from + to) / 2; // circa in mezzo
            String middle = v[mid];
            if (middle.equals(value))
                return mid; // elemento trovato
            if (middle.compareTo(value)<0){  //cerca a destra
                from=mid+1;
            }else{
                to=mid-1;
            }
        }
        return -1;
    }

    private static int binSearch(String[] v, int from, int to, String value)
    {  
        if (from > to) return -1;// el. non trovato
        int mid = (from + to) / 2; // circa in mezzo
        String middle = v[mid];
        if (middle.equals(value))
            return mid; // elemento trovato
        if (middle.compareTo(value)<0)  //cerca a destra
            return binSearch(v, mid + 1, to, value);
        // cerca a sinistra
        return binSearch(v, from, mid - 1, value);
   }    //ATTENZIONE: e` un algoritmo con ricorsione SEMPLICE

   private static void recBubbleSort(String[] arr, int from, int to){
        if(from!=to){
            String min=arr[to];
            if(min.compareTo(arr[to-1])<0){
                swap(arr, to, to-1);
            }
            recBubbleSort(arr, from, to-1);
            recBubbleSort(arr, from+1, to);
        }
   }
   private static void iterBubbleSort(String[] arr, int from, int to){
        for(int j=from; j<to; j++){
            for(int k=to; k>from; k--){
                if(arr[k].compareTo(arr[k-1])<0){
                    swap(arr, to-1, to-2);
                }
            }
        }

   }


    // ----------------------- altri metodi di utilita` ---------------------

    // Ridimensiona l'array oldv attribuendogli la lunghezza newLength
    public static String[] resize(String[] oldv, int newLength)
    {
        if (newLength < 0 || oldv == null)
            throw new IllegalArgumentException();
        String[] newv = new String[newLength];
        int count = oldv.length;
        if (newLength < count) 
            count = newLength;
        for (int i = 0; i < count; i++)
            newv[i] = oldv[i];
        return newv;
    }


     //Stampa tutti gli elementi di un array.
    public static String printArray(String[] v, int vSize)
    {
        String s = "";
        for (int i = 0; i<vSize; i++)
            s = s + v[i] + " ";
        return s;
    }
}

