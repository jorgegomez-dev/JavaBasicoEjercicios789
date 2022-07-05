package ejercicios0a8;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        // 0. Ingreso de una cadena para aplicar el metodo "reverse".
        Scanner in = new Scanner(System.in);
        System.out.println("------------------------------------------");
        System.out.println("#0. Ingrese la cadena a invertir: ");
        String text = in.nextLine();
        in.close();
        text = reverse(text);
        System.out.println("String reversed: " + text);

        // 1. Crea un array unidimensional de Strings y recórrelo, mostrando únicamente sus valores.
        System.out.println("------------------------------------------");
        System.out.println("#1. Array Unidimensional de Strings");
        String[] words = new String[4];
        words[0] = "Hello";
        words[1] = "World";
        words[2] = "in";
        words[3] = "OpenBootCamp";
        for (String word : words) {
            System.out.println(word);
        }

        // 2. Crea un array bidimensional de enteros y recórrelo, mostrando la posición y el valor de cada elemento
        // en ambas dimensiones.
        System.out.println("------------------------------------------");
        System.out.println("#2. Array Bidimensional de enteros");
        int[][] intNumbers = new int[2][3];
        intNumbers[0][0] = 1;
        intNumbers[0][1] = 2;
        intNumbers[0][2] = 3;
        intNumbers[1][0] = 4;
        intNumbers[1][1] = 5;
        intNumbers[1][2] = 6;

        for (int i = 0; i < intNumbers.length; i++) {
            for (int j = 0; j <= intNumbers.length; j++) {
                System.out.println("Posicion " + i + "," + j + ": Value: " + intNumbers[i][j]);
            }
        }

        // 3. Crea un "Vector" del tipo de dato que prefieras, y añádele 5 elementos.
        // Elimina el 2o y 3er elemento y muestra el resultado final.
        System.out.println("------------------------------------------");
        System.out.println("#3. Vector");
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        vector.remove(2);
        vector.remove(1);
        System.out.println(vector);

        // 4. Indica cuál es el problema de utilizar un Vector con la capacidad por defecto si
        // tuviésemos 1000 elementos para ser añadidos al mismo.

        //         4. Respuesta: que cada vez que el vector aplique un resize para aumentar la capacidad
        //            se genera una copia de los elementos que ya tenemos en ese array y se agregan a un
        //            nuevo array. Ello genera un costo enorme de recursos por cada vez que se amplia el
        //            vector, ya que duplica los elementos existentes.
        //            Lo mejor seria iniciar con una initialCapacidad cercana a la que vamos a necesitar
        //            o si ello no es posible, entonces


        // 5. Crea un ArrayList de tipo String, con 4 elementos. Cópialo en una LinkedList.
        // Recorre ambos mostrando únicamente el valor de cada elemento.
        System.out.println("------------------------------------------");
        System.out.println("#5. ArrayList de tipo String + LinkedList");
        ArrayList<String> listArray = new ArrayList<>();
        listArray.add("String 1");
        listArray.add("String 2");
        listArray.add("String 3");
        listArray.add("String 4");
        LinkedList<ArrayList> listLinked = new LinkedList<>();
        listLinked.add(listArray);

        System.out.println("Elementos ArrayList: ");
        for (Object element : listArray.toArray()) {
            System.out.println(element.toString());
        }

        System.out.print("Elementos LinkedList: ");
        for (Object element : listLinked.toArray()) {
            System.out.println(element.toString());
        }

        // 6. Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con elementos 1..10.
        // A continuación, con otro bucle, recórrelo y elimina los numeros pares.
        // Por último, vuelve a recorrerlo y muestra el ArrayList final.
        // Si te atreves, puedes hacerlo en menos pasos, siempre y cuando cumplas el primer "for" de relleno.
        System.out.println("------------------------------------------");
        System.out.println("#6. ArrayList de tipo int");
        ArrayList<Integer> listInteger = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            listInteger.add(i);
        }
        System.out.println("Complete List: " + listInteger);
        for (int i = 1; i <= listInteger.size(); i++) {
            if (listInteger.get(i) % 2 == 0) {
               listInteger.remove(i);
            }
        }
        System.out.println("List without even numbers: " + listInteger);

        // 7. Crea una función DividePorCero. Esta, debe generar una excepción ("throws") a su llamante del tipo ArithmeticException
        // que será capturada por su llamante (desde "main", por ejemplo). Si se dispara la excepción, mostraremos el mensaje "Esto no puede hacerse".
        // Finalmente, mostraremos en cualquier caso: "Demo de código".
        System.out.println("------------------------------------------");
        System.out.println("#7. Funcion dividePorCero + Exceptions");
        double dividendo = 5;
        double divisor = 2;
        try {
            double resultado = dividePorCero(dividendo,divisor);
            System.out.println("El resultado de la division es: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Esto no puede hacerse. " + e);
        } finally {
            System.out.println("Demo de codigo");
        }

        // 8. Utilizando InputStream y PrintStream, crea una función que reciba dos parámetros: "ficheroOriginal" y "fileOut".
        // La tarea de la función será realizar la copia del fichero dado en el parámetro "fileIn" al fichero
        // dado en "fileOut".
        System.out.println("------------------------------------------");
        System.out.println("#8. Funcion InputStream + PrintStream");
        try {
            InputStream fileIn = new FileInputStream("src/ejercicios0a8/ficheroOriginal");
            byte[] datos = fileIn.readAllBytes();

            PrintStream fileOut = new PrintStream("src/ejercicios0a8/ficheroCopia.txt");
            fileOut.write(datos);
            System.out.println("File successfully copied");

        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
            throw new RuntimeException(e);
        }

        // 9. Sorpréndenos creando un programa de tu elección que utilice InputStream, PrintStream,
        // excepciones, un HashMap y un ArrayList, LinkedList o array.

    }

    // 0. Metodo que recibe un String y devuelve una cadena al reves.
    public static String reverse (String text) {

        StringBuilder textReversed = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            char textTemp = text.charAt(i);
            textReversed.append(textTemp);
        }
        return textReversed.toString();
    }

    // 7. Funcion dividePorCero.
    public static double dividePorCero(double a, double b) {
        return a/b;
    }

}