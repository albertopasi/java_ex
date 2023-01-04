public class lab7es8 {
    private static void swap(int[] arr, int j, int k){
        int temp = arr[j];
        arr[j]=arr[k];
        arr[k]=temp;
    }
    private static int findMinPos(int[] v, int from, int to)
    {   int pos = from;
        int min = v[from];
        for (int i = from + 1; i <= to; i++)
            if (v[i] < min)
            {   pos = i;      
                min = v[i];   }
        return pos;
    }

    private static void selSortFrom(int[] arr, int from, int arrSize){
        if(arrSize-1!=from){
           int minPos = findMinPos(arr, from, arrSize-1);
           if (minPos != 0) swap(arr, minPos, from);
           selSortFrom(arr, from+1 , arrSize);
        }
    }

    private static void recSelSort(int[] arr, int arrSize){
        selSortFrom(arr, 0, arrSize);
    }
        /* private static void reSelSort(int[] arr, int arrSize){
        if(arrSize>1){
            selectionSort(arr, arrSize);
            arrSize--;
            int[] arr2 = new int[arrSize];
            System.arraycopy(arr, 1, arr2, 0, arrSize);
            reSelSort(arr2, arrSize);
        }*/

   
    public static void main(String[] args){
        int dim=0;
        int n=0;
        try{
            dim = Integer.parseInt(args[0]);
            n = Integer.parseInt(args[1]);
        }
        catch(NumberFormatException e){
            System.out.println("I parametri inseriti non rispettano le condizioni.");
            System.exit(1);
        }
        int[] array=new int[dim];
        for(int j=0; j<dim; j++){
            array[j] = (int) (Math.random()*n);
        }
        for(int j=0; j<dim; j++){
            System.out.print(array[j] + " ");
        }
        System.out.print("\n");

        recSelSort(array, dim);
        for(int j=0; j<dim; j++){
            System.out.print(array[j] + " ");
        }
        

        
    }
}
