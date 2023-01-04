import java.util.*;
public class TextContainer
{   
    private String[] array;
    private int arraySize;

    /*
    costruttore di un contenitore di testo vuoto
    */
    public TextContainer()
    {   array = new String[1];
        arraySize=0;
        array[0]="";
    }

    /*
      verifica se il testo e` vuoto, restituisce
      true se l'oggetto non contiene testo, false altrimenti
    */
    public boolean isEmpty()
    {  return array[0].isEmpty();
    }

    /*
      aggiunge la stringa "stringa" in coda al testo. Termina senza errori
      se String stringa e` uguale a null.
    */
    public void add(String stringa)
    {   if(stringa == null){
            return;
        }
        if(arraySize == array.length){
            array = resize(array);
        }
        array[arraySize++]= stringa;

    }

    private static String[] resize(String[] array){
        String[] array2 = new String[array.length*2];
        System.arraycopy(array, 0, array2, 0, array.length);
        return array2;
    }

    /*
     conta e restituisce il numero di stringhe nel testo
    */
    public int count()
    {   return arraySize;
    }

    /*
     separa le stringhe del testo in parole. Crea un nuovo oggetto di classe
     TextContainer in cui tutte le parole sono separate, e ne restituisce il
     riferimento. Usa l'insieme di delimitatori di default di Scanner, ovvero
     "\p{JavaWhitespace" (si veda la documentazione di Scanner, in particolare
     dei metodi delimiter e useDelimiter, e la documentazione della classe
     Pattern)
    */
    public TextContainer splitWords()
    {   TextContainer parola = new TextContainer();
        for(int j=0; j<arraySize; j++){
            Scanner c = new Scanner(array[j]);
            while(c.hasNext()){
                parola.add(c.next());
            }
            c.close();
        }   
        return parola;
    }

    /*
     separa le stringhe del testo in parole. Crea un nuovo oggetto di classe
     TextContainer in cui tutte le parole sono separate, e ne restituisce il
     riferimento. Usa l'insieme di delimitatori specificato dalla stringa delim
     (si veda la documentazione di Scanner, in particolare dei metodi delimiter
     e useDelimiter, e la documentazione della classe Pattern)
    */
    public TextContainer splitWords(String delim)
    {   TextContainer parola = new TextContainer();
        for(int j=0; j<arraySize; j++){
            Scanner c = new Scanner(array[j]);
            c.useDelimiter(delim);
            while(c.hasNext()){
                parola.add(c.next());
            }
            c.close();
        }   
        return parola;

    }

    /*
     Rimuovi tutte le occorrenze della stringa "stringa".
     - Se la stringa compare piu` volte vengono eliminate tutte le occorrenze.
     - Lancia IllegalArgumentException se il parametro esplicito e` null.
     Attenzione: si devono scandire tutte le stringhe del testo perche`
     la parola da cancellare puo` comparire piu` volte nel testo.
    */
    public void remove(String stringa)
    {   if(stringa==null)
            throw new IllegalArgumentException();
        for(int j=0; j<arraySize; j++){
            if(array[j].equals(stringa)){
                for(int k=j; k<arraySize; k++){
                    String a= array[k];
                    array[k]= array[k+1];
                    array[k+1]= a;

                }
                arraySize--;
                j--;
            }
        }
    }

    /*
      Restituisce il numero di occorrenze nel testo della stringa "stringa".
      Lancia IllegalArgumentException se il parametro esplicito e` null.
    */
    public int frequency(String stringa)
    {   int count=0;
        if(stringa==null)
        throw new IllegalArgumentException();
        for(int j=0; j<arraySize; j++){
            if(array[j].equals(stringa)){
                count++;
            }
        } 
        return count;
    }

    /*
      restituisce la stringa che compare piu` volte nel testo (frequenza massima).
      Se piu` stringhe hanno frequenza massima, ne restituisce una qualsiasi.
      Se il testo e` vuoto restituisce null.
    */
    public String maxFrequency()
    {   int frequenza=0;
        int a=0;
       for(int j=0; j<arraySize; j++){
            if(frequenza < this.frequency(array[j])){
                frequenza=this.frequency(array[j]);
                a=j;
            }
        }
        return array[a];
    }

    /*
      restituisce la prima stringa del testo in ordine lessicografico.
      Se il testo e` vuoto restituisce null.
    */
    public String min()
    {   if(this.isEmpty()){
            return null;
        }
        int a=0;
        for(int j=1; j<arraySize; j++){
            if(array[j].compareTo(array[a]) < 0){
                a=j;
            }
        }
        return array[a]; 
    }

    /*
      restituisce l'ultima stringa del testo in ordine lessicografico.
      Se il testo e` vuoto restituisce null.
    */
    public String max()
    {   if(this.isEmpty()){
            return null;
        }
        int a=0;
        for(int j=1; j<arraySize; j++){
            if(array[j].compareTo(array[a]) > 0){
                a=j;
            }
        }
        return array[a]; 

    }

    /*
      trasforma il testo in stringa. Viene inserito un carattere di nuova riga (\n)
      fra le stringhe. Se il testo e` vuoto restituisce la stringa vuota "".
    */
    public String toString()
    {
        if(this.isEmpty()){
            return "";
        }
        String a="";
        for(int j=0; j<arraySize; j++){
            a= a + array[j] + "\n";
        }
        return a;
    }

    /*
      crea un nuovo oggetto di tipo TextContainer in cui tutti i caratteri non
      alfabetici sono stati eliminati dalle stringhe del testo. Ad esempo elimina
      la punteggiatura, i numeri, le parentesi. Usa il metodo
      java.lang.Character.isLetter(char c)
    */
    public TextContainer onlyLetters()
    {   TextContainer x = this.copy();
        for(int j=0; j<arraySize; j++){
            for(int k=0; k<x.array[j].length(); k++){
                if(!Character.isLetter(x.array[j].charAt(k))){
                    x.array[j]= x.array[j].substring(0, k) + x.array[j].substring(k+1);
                    k--;
                }
            }

        }
        return x;
    }

    /*
     crea un nuovo oggetto di tipo TextContainer nel quale tutti i caratteri
     maiuscoli sono stati convertiti in minuscoli.
    */
    public TextContainer toLowerCase()
    {   TextContainer x = this.copy();
        for(int j=0; j<arraySize; j++){
            x.array[j] = x.array[j].toLowerCase();
        }
        return x;
    }

    /*
     crea una copia dell'oggetto TextContainer, e ne restituisce il riferimento
    */
    public TextContainer copy()
    {   TextContainer x = new TextContainer();
        for(int j=0; j<arraySize; j++){
            x.add(array[j]);
        }  
        return x;
    }

}