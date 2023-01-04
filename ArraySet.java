public class ArraySet implements Set
{ 
    private final static int INITIAL_CAPACITY = 1; 
    private Object[] v;
    private int vSize; 

    public ArraySet() 
    {   v = new Object[INITIAL_CAPACITY]; 
        makeEmpty(); 
    }
    
    public void makeEmpty(){
        vSize = 0; 
    }

    public boolean isEmpty() { 
        return vSize == 0; 
    } 

    public int size(){ 
        return vSize;
    } 
    
    public Object[] toArray() // O(n)
    {   Object[] x = new Object[vSize];
        System.arraycopy(v, 0, x, 0, vSize);
        return x; 
    }

    public boolean contains(Object x) // O(n)
    {   for (int i = 0; i < vSize; i++)
            if (v[i].equals(x)) 
                return true;
        return false; 
    } 

    public void add(Object x) // O(n) (usa contains)
    {   if (contains(x)) return; // esce silenziosamente
        if (vSize == v.length) v = resize(v);
        v[vSize++] = x; 
    }
    
    private static Object[] resize(Object[] v) { 
        Object[] v2 = new Object[v.length*2];
        System.arraycopy(v, 0, v2, 0, v.length);
        return v2;
     }

     public static Set union(Set s1, Set s2)
    {   Set x = new ArraySet();
            // inseriamo gli elementi del primo insieme
        Object[] v = s1.toArray();
        for (int i = 0; i < v.length; i++)
            x.add(v[i]);
            // inseriamo tutti gli elementi del
            // secondo insieme, sfruttando le
            // proprietà di add (niente duplicati...)
        v = s2.toArray();
        for (int i = 0; i < v.length; i++)
            x.add(v[i]);
        return x;
    }

    public static Set intersection(Set s1, Set s2)
    {   Set x = new ArraySet();
        Object[] v = s1.toArray();
        for (int i = 0; i < v.length; i++)
            if (s2.contains(v[i]))      // O(n)
                x.add(v[i]); 
        return x;
    }       // O(n2)

    public static Set subtract(Set s1, Set s2)
    {   Set x = new ArraySet();
        Object[] v = s1.toArray();
        for (int i = 0; i < v.length; i++)
            if (!s2.contains(v[i]))     // O(n)
                x.add(v[i]); 
        return x;
    }            // O(n2)
}
