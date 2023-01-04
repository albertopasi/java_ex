public class ArrayStackProva implements Stack2{
    
    private Comparable[] v;
    private int vSize;
    private static final int INITSIZE=10;

    public ArrayStackProva(){
        v=new Comparable[INITSIZE];
        makeEmpty();
    }

    public boolean isEmpty(){
        return vSize==0;
    }

    public void makeEmpty(){
        vSize=0;
    }

    public static Comparable[] resize(Comparable[] a){
        Comparable[] a2=new Comparable[a.length*2];
        System.arraycopy(a, 0, a2, 0, a.length);
        return a2;
    }

    public void push(Comparable x){
        if(x==null) throw new IllegalArgumentException();
        if(vSize==v.length) v= resize(v);
        v[vSize++]=x;
    }

    public Comparable top(){
        if(isEmpty()) throw new EmptyStackException();
        return v[vSize-1];
    }

     public Comparable pop(){
        Comparable x = top();
        vSize--;
        return x;
     }
}
