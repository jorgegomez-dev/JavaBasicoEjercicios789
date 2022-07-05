package ejercicio9;
import java.io.*;
import java.util.*;

        /* 9. Consigna:
              Sorpréndenos creando un programa de tu elección que utilice InputStream, PrintStream,
              excepciones, un HashMap y un ArrayList, LinkedList o array */


        /* Explicacion del programa propuesto:
           1. Recibimos un .txt con nombre y apellido de alumnos inscriptos en una linea separados por ", ".
           2. Usaremos ese .txt para crear una lista de alumnos ordenada alfabeticamente para el docente.
           3. Luego les asignaremos un id a cada uno, que sera un codigo de identificacion unico interno.
           4. Finalmente guardaremos esa lista en nuevo .txt. */

public class Main {
    public static void main(String[] args) {

        try {
            InputStream fileIn = new FileInputStream("src/ejercicio9/fileInAlumnos.txt");
            try {
                int dataTemp = fileIn.read();
                StringBuilder namesFileIn = new StringBuilder();
                while(dataTemp != -1) {
                    namesFileIn.append(Character.toString(dataTemp));
                    dataTemp = fileIn.read();
                }

                ArrayList<String> namesArray = new ArrayList<>(List.of(namesFileIn.toString().split(", ")));
                Collections.sort(namesArray);

                HashMap<Integer, String> namesMap = new HashMap<>();
                for(int i = 0; i < namesArray.size(); i++){
                    namesMap.put(i, namesArray.get(i));
                }

                PrintStream fileOut = new PrintStream("src/ejercicio9/fileOutAlumnos.txt");
                for(Map.Entry<Integer, String> e : namesMap.entrySet()){
                    fileOut.println("Id:" + e.getKey() + " | " + "Name: " + e.getValue());
                }
                System.out.println("File successfully written!!");

                } catch (IOException ex) {
                System.out.println("Error!!: " + ex.getMessage());
            }

            } catch (IOException e) {
                System.out.println("The file can´t be read: " + e.getMessage());
        }
    }
}
