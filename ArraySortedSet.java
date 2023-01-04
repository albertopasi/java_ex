public class ArraySortedSet implements SortedSet{
    private static final int INITIAL_CAPACITY = 1; 
    private Comparable[] v;
    private int vSize;
 
    public ArraySortedSet() 
    {   v = new Comparable[INITIAL_CAPACITY]; 
        makeEmpty(); 
    } 

    public void makeEmpty(){ vSize = 0; } 

    public boolean isEmpty(){ return vSize == 0; }

    public Comparable[] toSortedArray() // O(n)
    {   Comparable[] x = new Comparable[vSize];
        System.arraycopy(v, 0, x, 0, vSize);
        return x; 
    }
 
    public Object[] toArray()
    {   return toSortedArray();
    } 

    public boolean contains(Object x) // O(log n)
    {       // si può fare una ricerca binaria
            return binSearch(v,0, vSize, (Comparable) x);
    }

    public static boolean binSearch(Comparable[] a, int from, int to, Comparable value){
        if(from>to) return false;
        int mid = (from+to)/2;
        if(a[mid].equals(value)){
            return true;
        }else if(a[mid].compareTo(value)<0){
            return binSearch(a, mid+1, to, value);
        }else{
            return binSearch(a, 0, mid-1, value);
        }
    }

    public void add(Object x) // non deve essere usato!
    { throw new IllegalArgumentException(); }
 
    public void add(Comparable x) // O(n)
    {   if (contains(x)) return;
        if (vSize == v.length) v = resize(v);
        v[vSize++] = x;
        // usiamo insertion sort che è O(n)
        // perché inseriamo in un array ordinato
        for(int j=vSize-2; j>=0; j--){
            if(x.compareTo(v[j])<0){
                v[j+1]=v[j];
                v[j]=x;
            }else{
                return;
            }
        }
    }


    public static Comparable[] resize(Comparable[] a){
        Comparable[] a2 = new Comparable[a.length*2];
        System.arraycopy(a,0,a2,0,a.length);
        return a2;
    }

    public static SortedSet union(SortedSet s1,SortedSet s2)
    { 
        SortedSet x = new ArraySortedSet();
        Comparable[] v1 = s1.toSortedArray();
        Comparable[] v2 = s2.toSortedArray(); 
        int i = 0, j = 0;
        while (i < v1.length && j < v2.length) 
        {   if (v1[i].compareTo(v2[j]) < 0)
                x.add(v1[i++]); // contains:O(log n); ins:O(1)
            else if (v1[i].compareTo(v2[j]) > 0) 
                x.add(v2[j++]);
            else // sono uguali: avanzo entrambi gli indici
            {   x.add(v1[i++]);
                j++;
            }
        } 
        while (i < v1.length)
            x.add(v1[i++]);
        while (j < v2.length)
            x.add(v2[j++]);
        return x;
    } // prestazioni O(n log n) anziché quadratiche

    public static SortedSet intersection(SortedSet s1, SortedSet s2)
    {   SortedSet x = new ArraySortedSet();
        Comparable[] v1 = s1.toSortedArray();
        Comparable[] v2 = s2.toSortedArray();
        for (int i = 0, j = 0; i < v1.length; i++){ 
            while (j < v2.length && v1[i].compareTo(v2[j]) > 0)
                j++;
            if (j == v2.length) break;
            if (v1[i].compareTo(v2[j]) == 0)
                x.add(v1[i]); j++;
        }
        return x;
    } // prestazioni O(n log n) anziché quadratiche
}
