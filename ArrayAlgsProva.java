public class ArrayAlgsProva {
    
    public static void removeSorted(Comparable[] v, int vSize, int index){
        for(int j=index; j<vSize-1; j++){
            v[j]=v[j+1];
        }
    }

    public static Comparable[] resize(Comparable[] v){
        Comparable[] v2 = new Comparable[v.length*2];
        System.arraycopy(v, 0, v2, 0, v.length);
        return v2;
    }

    public static Comparable[] insert(Comparable[] v, int vSize, int index, Comparable value){
        if(v.length==vSize) v=resize(v);
        for(int j=vSize; j>index; j--){
            v[j]=v[j-1];
        }
        v[index]=value;
        return v;
    }

    public static Comparable findMin(Comparable[] v, int vSize){
        Comparable min = v[0];
        for(int j=1; j<vSize; j++){
            if(v[j].compareTo(min)<0){
                min=v[j];
            }
        }
        return min;
    }

    public static Comparable findMax(Comparable[] v, int vSize){
        Comparable max = v[0];
        for(int j=1; j<vSize; j++){
            if(v[j].compareTo(max)>0){
                max=v[j];
            }
        }
        return max;
    }

    public static int findMinPosition(Comparable[] v, int vSize){
        int minPos=0;
        for(int j=1; j<vSize; j++){
            if(v[j].compareTo(v[minPos])<0){
                minPos=j;
            }
        }
        return minPos;
    }

    public static void swap(Comparable[] v, int j, int k){
        Comparable temp = v[j];
        v[j]=v[k];
        v[k]=temp;
    }

    public static void selectionSort(Comparable[] v, int vSize){
        for(int j=0; j<vSize; j++){
            int minPos = findMinPosition(v, vSize);
            if(minPos!=j) swap(v, j, minPos);
        }
    }

    public static void mergeSort(Comparable[] v, int vSize){
        if(vSize<2) return;
        int mid=vSize/2;
        Comparable[] left = new Comparable[mid];
        Comparable[] right = new Comparable[vSize-mid];
        System.arraycopy(v, 0, left, 0, mid);
        System.arraycopy(v, mid, right, 0, vSize-mid);
        mergeSort(left, mid);
        mergeSort(right, vSize-mid);
        merge(v,left, right);
    }

    public static void merge(Comparable[] v, Comparable[] v1, Comparable[] v2){
        int i=0, i1=0, i2=0;
        while(i1<v1.length && i2<v2.length){
            if(v1[i1].compareTo(v2[i2])<0){
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

    public static void insertionSort(Comparable[] v, int vSize){
        for (int i = 1; i < vSize; i++)
        {   Comparable temp = v[i]; 
            int j;
            for (j = i; j > 0 && temp.compareTo(v[j-1]) < 0; j--)
                v[j] = v[j-1];
            v[j] = temp;
        }
    }

    public static int linearSearch(Comparable[] v, int vSize, Comparable value){
        for(int j=0; j<vSize; j++){
            if(v[j].equals(value)) return 1;
        }
        return -1;
    }

    public static int binarySearch(Comparable[] v, int vSize, Comparable value){
        return binSearch(v,0,vSize, value);
    }

    public static int binSearch(Comparable[] v, int from, int to, Comparable value){
        if(from>to) return -1;
        int mid = (from+to)/2;
        if(v[mid].equals(value)){
            return 1;
        }else if(v[mid].compareTo(value)<0){
            return binSearch(v, mid+1, to, value);
        }else{
            return binSearch(v, from, mid-1, value);

        }
    }

}
