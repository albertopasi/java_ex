public class ArrayStack implements Stack
{   protected Object[] v;
    protected int vSize;

    public ArrayStack(){
        v=new Object[10];
        makeEmpty();
    }
    public void makeEmpty(){
        vSize=0;
    }
    public boolean isEmpty(){
        return vSize==0;
    }
    public void push(Object obj){
        if(vSize==v.length) v= resize(v,vSize*2);
        v[vSize++]=obj;
    }
    public static Object[] resize(Object[] ar, int newLength){
        Object[] ob = new Object[newLength];
        System.arraycopy(ar, 0, ob, 0, ar.length);
        ar=ob;
        return ar;
    }
    public Object pop(){
        Object ob = top();
        vSize--;
        return ob;
    }
    public Object top(){
        if(isEmpty()) System.out.println("Stack vuoto");
        return v[vSize-1];
    }
    
    public String toString(){
        String a="";
        for(int i=0; i<vSize; i++){
            a= a + v[i] + " ";
        }
        return a;
    }
}
