public class RecSubstringGenerator{
    private static String[] recursivesubstring(String a){
        if(a.length()<2){
            return new String[] {a};
        } 
        String[] substrings1= new String[a.length()];
        for(int j =0; j<a.length(); j++){
            substrings1[j]= a.substring(0, j+1);
        }   
        String[] substrings2= recursivesubstring(a.substring(1));
        String[] substrings= new String[substrings1.length+substrings2.length];
        for(int j =0; j<substrings1.length; j++){
            substrings[j]= substrings1[j];
        } 
        for(int j =0; j<substrings2.length; j++){
            substrings[substrings1.length+j]= substrings2[j];
        } 
        return substrings;
    }

    public static void main(String[] args)
    {
        
        String[] sub= recursivesubstring(args[0]);
        for(int j =0; j<sub.length; j++){
            System.out.println(sub[j]);
        } 
    }
}