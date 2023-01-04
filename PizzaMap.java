public class PizzaMap extends FixedArrayMap {
    public Object put(Object key, Object value){
        if (key == null || value == null || !(key instanceof String) || !(value instanceof Double)){
            throw new IllegalArgumentException();
        }
        try{
            return super.put(key, value);
        }
        catch(FullMapException e){
            p = resize(p);
            return super.put(key, value);
        }
    }

    private static Pair[] resize(Pair[] a){
        Pair[] a2 = new Pair[a.length*2];
        System.arraycopy(a,0,a2,0, a.length);
        return a2;
    }

    

    public String printMenu(){
        Object[] arrKeys = keys();
        Pair[] sortedArr = new Pair[arrKeys.length];
        for(int i=0; i< arrKeys.length; i++){
            sortedArr[i]=new Pair(arrKeys[i], get(arrKeys[i]));
        }
        mergeSort(sortedArr);
        String out="";
        for (Pair pair : sortedArr) {
            out += pair.toString() + "\n";
        }
        return out;
    }

    public static void mergeSort(Pair[] a){
        if(a==null) throw new IllegalArgumentException();
        if(a.length<2) return;
        int mid=a.length/2;
        Pair[] left = new Pair[mid];
        Pair[] right = new Pair[a.length-mid];
        System.arraycopy(a, 0, left, 0, mid);
        System.arraycopy(a, mid, right, 0, a.length-mid);
        mergeSort(left);
        mergeSort(right);
        merge(a,left,right);
    }

    public static void merge(Pair[] v, Pair[] v1, Pair[] v2){
        int i=0, i1=0, i2=0;
        while(i1<v1.length && i2<v2.length){
            if(((Comparable) v1[i1].getValue()).compareTo((Comparable) v2[i2].getValue())<0){
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

}
