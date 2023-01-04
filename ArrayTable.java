public interface Table extends Container
{ void insert(int key, Object value);
 void remove(int key);
 Object find(int key);
}
interface Container{
    boolean isEmpty();
    void makeEmpty();
 
 }

public class ArrayTable implements Table{
    private Object[] v;
    private int count; // count rende isEmpty O(1)
    
    public ArrayTable()
    {   v = new Object[100];
        makeEmpty();
    }

    public void makeEmpty()
    {   count = 0;
    } 

    public boolean isEmpty()
    {   return (count == 0);
    }

    private void check(int key)
    {   if (key < 0 || key >= v.length)
            throw new IllegalArgumentException();
    }

    public void insert(int key, Object value)
    {   check(key);
        if (v[key] == null)
        {   count++;
            v[key] = value;
        }else 
            v[key] = value;
    }

    public void remove(int key)
    {   check(key); 
        if (v[key] != null)
        {   count--;
            v[key] = null;
        }
    }

    public Object find(int key)
    {   check(key);
        return v[key];
    }
}
