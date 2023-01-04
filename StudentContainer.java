import java.io.FileReader;
import java.io.IOException;
import java.util.*;
class StudentContainer extends SortedContainer
{
    /*
      Costruisce un contenitore vuoto
    */
    public StudentContainer()
    {   super();
    }
   
    /*
      Costruisce un contenitore e vi inserisce oggetti di tipo Student
      usando i dati letti dal file filename, nel formato nome:matricola
    */
    public StudentContainer(String filename) throws IOException
    {   this();
        Scanner in = new Scanner(new FileReader(filename));
        int linecount = 0;
        //lettura di filename e riempimento dell'archivio. Gestione eccezioni:
        //le righe scritte in formato non corretto vengono saltate.
        while (in.hasNextLine())
        {   linecount++;
            String line = in.nextLine();
            Scanner linescan = new Scanner(line).useDelimiter(":");
            try
            {   String nome = linescan.next();
                int matricola = Integer.parseInt(linescan.next());
                add(nome, matricola);
            }
            catch (NoSuchElementException e)
            {   System.out.println("riga " + linecount + " errata: " + line);
            }
            catch (NumberFormatException e)
            {   System.out.println("riga " + linecount + " errata: " + line);
            }
        }
        in.close();
    }

    /*
        Inserisce il nuovo oggetto compObj di tipo Student nel contenitore. 
        Questo metodo sovrascrive il metodo omonimo di SortedContainer. Se  
        l'oggetto compObj non e` di tipo Student il metodo deve lanciare
        IllegalArgumentException. Per il resto il comportamento del metodo e` 
        identico a quello del metodo omonimo di SortedContainer
    */
    public void add(Comparable compObj)
    {   if (!(compObj instanceof Student))
            throw new IllegalArgumentException();
        super.add(compObj);
    }

    /*
        Crea un nuovo oggetto Student con il nome n e la matricola m, e 
        successivamente lo inserisce nel contenitore con le stesse modalita`
        del metodo add(Comparable compObj)
    */
    public void add(String n, int m)
    {   Student2 s = new Student2(n,m);
        this.add(s);
    }

    /*
        ATTENZIONE: i metodi pubblici isEmpty(), makeEmpty(), size(), 
        removeMax() sono ereditati dalla superclasse SortedContainer
    */
}