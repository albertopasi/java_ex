public class lab7es4 {
    private static boolean palindroma(String s){
        if(s.length()<0){
            throw new IllegalArgumentException();
        }
        if(s.length()<=1 ){
            return true;
        }
        if(!Character.isLetter(s.charAt(0))){
            return palindroma(s.substring(1));
        }
        if(!Character.isLetter(s.charAt(s.length()-1))){
            return palindroma(s.substring(0, s.length()-1));
        }
        if(Character.toUpperCase(s.charAt(0))!=Character.toUpperCase(s.charAt(s.length()-1))){
            return false;
        }
        return palindroma(s.substring(1, s.length()-1));
    }

    public static void main(String[] args){
        if(args.length==0 || palindroma(args[0])){
            System.out.println("E' palindroma.");
        }else{
            System.out.println("Non e' palindroma.");

        }
    }
    
}
