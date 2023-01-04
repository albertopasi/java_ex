/*Realizzare una classe FactorGenerator che 
effettui la scomposizione di un numero intero 
positivo nei suoi fattori primi con un 
comportamento simile a quello della classe 
Scanner con i suoi metodi nextInt e hasNextInt*/
public class FactorGenerator {
    private int num;
    public FactorGenerator(int a){
        if(a<=1){
            throw new IllegalArgumentException();
        }
        num=a;
    }

    public int nextFactor(){
        for(int j=2; j<=num; j++){
            if(num%j == 0){
                num /= j;
                return j;
            }
        }
        throw new IllegalStateException();
    }

    public boolean hasMoreFactors(){
        if(num==1){
            return  false;
        }
        return true;
    }


    
}


