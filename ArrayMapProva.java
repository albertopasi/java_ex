public class ArrayMapProva {

    public class Pair{
        private Object key;
        private Object value;

        public Pair(Object chiave, Object valore){
            setKey(chiave);
            setValue(valore);
        }
        public void setKey(Object chiave){
            key=chiave;
        }
        public void setValue(Object valore){
            value=valore;
        }
        public Object getKey(){
            return key;
        }
        public Object getValue(){
            return value;
        }
    }

    private Pair[] p;
    private int pSize;
    private static final int INITSIZE=10;

    public ArrayMapProva(){
        p=new Pair[INITSIZE];
        makeEmpty();
    }

    public void makeEmpty(){
        pSize=0;
    }

    public boolean isEmpty(){
        return pSize==0;
    } 

    public int size(){
        return pSize;
    }

    public Object[] keys(){
        Object[] keysArray = new Object[pSize];
        for(int j=0; j<pSize; j++){
            keysArray[j]=p[j].getKey();
        }
        return keysArray;
    }

    public Object put(Object k, Object v){
        if(k==null || v==null) throw new IllegalArgumentException();
        for(int j=0; j<pSize; j++){
            if(p[j].getKey().equals(k)){
                Object oldValue=p[j].getValue();
                p[j].value=v;
                return oldValue;
            }
        }
        if(pSize==p.length) p=resize(p);
        p[pSize++]=new Pair(k, v);
        return v;
    }

    public Pair[] resize(Pair[] arr){
        Pair[] arr2=new Pair[arr.length*2];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        return arr2;
    }

    public Object get(Object k){
        for(int j=0; j<pSize; j++){
            if(p[j].getKey().equals(k)){
                return p[j].getValue();            
            }
        }
        return null;
    }

    public Object remove(Object k){
        for(int j=0; j<pSize; j++){
            if(p[j].getKey().equals(k)){
                Object obj=p[j].getValue();
                p[j]=p[pSize-1];
                pSize--;
                return obj;
            }
        }
        return null;
    }
}
