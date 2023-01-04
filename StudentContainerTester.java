import java.io.*;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class StudentContainerTester
{
    public static void main(String[] args) throws IOException
    {   if (args.length != 2)
        {
         System.out.println("uso: $java StudentContainerTester inFile outFile");
         return;
        }

        StudentContainer archivio = new StudentContainer(args[0]);

        PrintWriter writer = new PrintWriter(args[1]);
        while (!archivio.isEmpty())
            writer.println(archivio.removeMax());
        writer.close();
    }
}
