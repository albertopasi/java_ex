public class StackByQueueTester {
    public static void main(String[] args){
        Stack stack1= new ArrayStack();
        Stack stack2=new StackByQueue();
        stack1.push(2);
        stack1.push("pippo");
        stack1.top();
        stack1.pop();
        stack1.push("pluto");
        stack1.top();

        stack2.push(2);
        stack2.push("pippo");
        stack2.top();
        stack2.pop();
        stack2.push("pluto");
        stack2.top();
        if(compareStack(stack1, stack2)){
            System.out.println("Collaudo riuscito");
        }else{
            System.out.println("Collaudo non riuscito");

        }
    }

    public static boolean compareStack(Stack s1, Stack s2){
        Stack temp1=new ArrayStack();
        Stack temp2=new ArrayStack();
        boolean areEquals = true;
        while (!s1.isEmpty() && !s2.isEmpty() && areEquals)
        {   Object obj1 = s1.pop();
	        temp1.push(obj1);
	        Object obj2 = s2.pop();
	        temp2.push(obj2);
            // controllo che obj1 e obj2 siano o entrambi null o riferimenti 
            // ad oggetti uguali
            areEquals = (obj1 == null && obj2 == null) || 
                        (obj1 != null && obj1.equals(obj2) );
        }
        if (!s1.isEmpty() || !s2.isEmpty()) //le due pile non contengono
            areEquals = false;              // lo stesso numero di elementi

        while (!temp1.isEmpty())  // ri-travasiamo i contenuti di temp1 e temp2
            s1.push(temp1.pop());   // nelle due pile iniziali
        while (!temp2.isEmpty())
            s2.push(temp2.pop());

        return areEquals;
    }
    
}
