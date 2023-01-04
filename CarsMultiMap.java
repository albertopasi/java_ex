public class CarsMultiMap extends ArrayMultiMap{
    public void insert(Object key, Object value){
        if (key == null || value == null || !(key instanceof Double) || !(value instanceof String)){
          throw new IllegalArgumentException();
        }
        if (pSize == p.length){ 
            p = super.resize(p, 2*pSize);
        }   
        // inserisco nuova coppia in fondo e inc. pSize
        p[pSize++] = new Pair(key, value);
        for(int j=pSize-2; j>=0; j--){
            if((Double)(p[j].getKey()) > (Double)(p[j+1].getKey())){
                Pair temp = p[j+1];
                p[j+1]=p[j];
                p[j]=temp;
            }else break;
        }     
    }
    
    public Object find(Object key){
        if(key == null){
			throw new IllegalArgumentException();
		}
		int pos = binSearch(0,pSize, key);
        //NOTA: uso la dimensione logica!
		if(pos != -1) 
			return p[pos].getValue();
		else
			return null;
    }

    private int binSearch(int from, int to, Object k){
        if(from>to) return -1;
        int mid = (from+to)/2;
        if(p[mid].getKey().equals(k)){
            return mid;
        }else if(((Double)p[mid].getKey()).compareTo((Double) k)>0){
            return binSearch(mid+1, to, k);
        }else{
            return binSearch(0, mid-1, k);
        }
    }
}
