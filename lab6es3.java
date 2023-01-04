/*Scrivere un programma che identifichi la più lunga sottostringa appartenente a due stringhe ricevute come 
argomenti sulla riga di comando. 

Esempio: la piu` lunga sottostringa comune alle due stringhe

	ciaone  0   lenght=6
	xiao    1   lenght=4
e` la stringa

	iao*/
    public class lab6es3 {
        public static void main(String[] args){
            boolean uguale = false;
            int a = 0;
            int lenght = args[0].length();
            if(args[1].length() < args[0].length()){
                lenght = args[1].length();
            }
            for(; lenght > 0 && !uguale; lenght--){
                for(int j = 0; j < args[0].length() - lenght + 1 && !uguale; j++){
                    for(int k = 0; k < args[1].length() - lenght + 1 && !uguale; k++){
                        System.out.print("Confronta ");
                        System.out.print(args[0].substring(j, lenght + j));
                        System.out.print(" con ");
                        System.out.println(args[1].substring(k, lenght + k));
                        if((args[0].substring(j, lenght + j)).equals(args[1].substring(k, lenght + k))){
                            uguale = true;
                            a = j;
                        }
                    } 
                }
            }
            if(uguale){
                System.out.println("La sottostringa piu' lunga e': " + args[0].substring(a, lenght + a + 1));
            }else{
                System.out.println("Non ci sono sottostringhe in comune.");
            }
        }
    }
