package MezclaEquilibrada;

/**
 *
 * @author Armando Beristain
 */

import java.util.Iterator;
import java.util.ArrayList;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlgoritmosOrdenExtern {

    /*
         * numAlumnos toma un archivo con los nombres y número de cuenta de alumnos 
         * y regresa la cantidad de alumnos que se encuentran dentro del archivo
         * @author
         * @version 
         * @param f File es el archivo que se va a ordenar
     */
    public int numAlumnos(File f) {

        int numeroLineas = 0;
        String sCadena = "";

        try {
            if (f.exists()) {
                FileReader fr = new FileReader(f);
                BufferedReader bf = new BufferedReader(fr);
                try {
                    while ((sCadena = bf.readLine()) != null) {
                        numeroLineas++;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(AlgoritmosOrdenExtern.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(" No se encontro ");
        }

        return numeroLineas;
    }

    public String arrtoString(String[] a) {
        return a[0] + ", " + a[1] + ". " + a[3];
    }

    /*
 * mezcla Natural toma un archivo con los nombres y número de cuenta de alumnos 
 * hace uso de el método Mezcla Directa para ordenar sub bloques 
 * @author
 * @version 
 * @param file String nombre del archivo que se va ordenar 
 * @param tipo String tipo de ordenamiento que se hará por nombre, apellido o por N# de cuenta 
     */
    public void mezclaNatural(String file, String tipo) {

        ArrayList<String[]> a = new ArrayList<String[]>();  // arreglo que nos ayudara a visualizar la localización de cada alumno 
        // y para comparación en cuanto organización
        String aux[];                                           // arreglo auxiliar que nos permitirá comparar a un alumno
        String aux2[];                                          // arreglo auxiliar que nos permitira comparar a otro alumno

        try {
            File f = new File(file);                            // Abre un enlace con el archivo de alumnos a tratar             
            FileReader f0 = new FileReader(f);                  // FileReader nos ayudará para leer el arcivo con BufferedReader 
            BufferedReader br = new BufferedReader(f0);         // BufferedReader nos ayudara a leer nuestro archivo

            int izquierda = 0, izq = 0, derecha = numAlumnos(f), der = derecha;
            boolean ordenado = false;                           //  ordenado nos ayudara a entrar en un ciclo de ordenamiento 

            for (int i = 0; i < numAlumnos(f); i++) {                 // Se vacia la información de alumnos en un archivo, para su correcta localización 
                // Mediante indices 
                try {
                    a.add(i, br.readLine().split(", "));           // toma todo el renglon del alumnos y lo subdibide en un arreglo [noombr|apellido|N#cuenta]
                } catch (IOException ex) {                           //  En caso de no poder leer alertara al usuario 
                    System.out.println(" No se encontro el archivo auxiliar f para lectura");
                }
            }

            do {
                ordenado = true;
                izquierda = 0;
                while (izquierda < derecha) {
                    izq = izquierda;

                    aux = a.get(izq);                                  // aux es un arreglo auxiliar que tendra la siguiente estructura [nombre, apellido, N#cuenta]
                    aux2 = a.get(izq + 1);                               // aux2 tiene el mismo fin, ambos nos servirán para comparar ados alumno  s

                    switch (tipo) {

                        case "1":
                            while (izq < derecha && (int) aux[0].charAt(0) <= (int) aux2[0].charAt(0)) {  // Ordena el bloque izquierdo con un criterio de orden por nombre
                                izq++;
                            }
                            // aux[0] y charAt(0) indicanque se comparara el nombre a partir de su perimer letra
                            der = izq + 1;
                            aux = a.get(der);
                            aux2 = a.get(der + 1);
                            while (der == derecha - 1 || der < derecha && (int) aux[0].charAt(0) <= (int) aux2[0].charAt(0)) { // Ordena de igual manera el bloque derecho a partir de Bubble Sort
                                der++;
                            }
                            break;

                        case "2":
                            while (izq < derecha && (int) aux[1].charAt(0) <= (int) aux2[1].charAt(0)) {  // Ordena el bloque izquierdo con un criterio de orden por nombre
                                izq++;                                                                  // aux[0] y charAt(0) indicanque se comparara el nombre a partir de su perimer letra
                            }
                            der = izq + 1;
                            aux = a.get(der);
                            aux2 = a.get(der + 1);
                            while (der == derecha - 1 || der < derecha && (int) aux[1].charAt(0) <= (int) aux2[1].charAt(0)) { //Ordena de igual manera el bloque derecho a partir de Bubble Sort
                                der++;
                            }
                            break;

                        case "3":
                            while (izq < derecha && (int) aux[2].charAt(0) <= (int) aux2[2].charAt(0)) {  /// Ordena el bloque izquierdo con un criterio de orden por nombre
                                izq++;                                                                  // aux[0] y charAt(0) indicanque se comparara el nombre a partir de su perimer letra
                            }
                            der = izq + 1;
                            aux = a.get(der);
                            aux2 = a.get(der + 1);
                            while (der == derecha - 1 || der < derecha && (int) aux[2].charAt(0) <= (int) aux2[2].charAt(0)) {
                                der++;
                            }
                            break;
                    }
                    if (der <= derecha) {
                        mezlaDirecta(file, tipo);
                        ordenado = false;
                    }
                    izquierda = izq;
                }
            } while (!ordenado);
        } catch (Exception e) {                                 // En caso de no encontrar el archivo mandará un aviso 
            System.out.println(" NO se ha encontrado el archivo");
        }
    } // fin de Mezcla Natural

    /*
         * mezcla Directa es una uxiliar de Mezcla Equilibrada
         * toma un archivo (que es un bloque), con los nombres y número de cuenta de alumnos 
         * hace uso de dos archivos auxiliares para realizar el ordenamiento 
         * @author
         * @version 
         * @param file String nombre del archivo que se va ordenar 
         * @param tipo String tipo de ordenamiento que se hará por nombre, apellido o por N# de cuenta 
     */
    public void mezlaDirecta(String file, String tipo) {
        int i, j, k;
        // Cda alumno llevará la siguiente distribución [nombre|apellido|N#cuenta]
        String aux[];                                           // arreglo auxiliar que nos permitirá comparar a un alumno
        String aux2[];                                          // arreglo auxiliar que nos permitira comparar a otro alumno

        try {
            File f = new File(file);                              // Abrimos el archivo que se pretende ordenar 
            FileReader f0 = new FileReader(f);
            BufferedReader br = new BufferedReader(f0);           // Instciamos un objeto para poder leer nuestro archivo 
            File ordenado = new File("ordenado.txt");                   // Creamos nuestro archivo auxiliar del bloque derecho
            PrintWriter pr = new PrintWriter(ordenado);           // Regresa el archivo ordenado 

            if (numAlumnos(f) > 1) {                              // Si la lista es de 0 o 1 nos indica que la lista ya esta ordenada 
                int Elemizq = numAlumnos(f) / 2;                    // Definimos el numero de alumnos  bloque izquierdo
                int Elemder = numAlumnos(f) - Elemizq;             // Definimos el número de alumnos en el bloque derecho
                ArrayList<String[]> a1 = new ArrayList<String[]>(Elemizq);   // Lista que nos perimitira ver la localización de alumnos del bloque en F1
                ArrayList<String[]> a2 = new ArrayList<String[]>(Elemder);   // Lista que nos perimitira ver la localización de alumnos del bloque en F1
                ArrayList<String> a = new ArrayList<String>(numAlumnos(f));        // Lista que permitira ver la totalidad de alumnos en indices para comparación
                try {
                    File f1 = new File("f1.txt");                     // Creamos nuestro archivo auxiliar del bloque izquierdo 
                    f1.createNewFile();

                    File f2 = new File("f2.txt");                     // Creamos nuestro archivo auxiliar del bloque derecho
                    f2.createNewFile();

                    PrintWriter p2 = new PrintWriter(f2);             // Instanciamos un objeto para vaciar los alumnos del bloque izquierdo en f1
                    PrintWriter p1 = new PrintWriter(f1);             // Instanciamos un objeto para vaciar los alumnos del bloque derecho en f2

                    String temp = "";                                 // Haciendo los bloques izquierdos y derechos sobre los archivos auxillirares 

                    for (i = 1; i <= numAlumnos(f); i++) {               // Iteramos u for desde 1 hasta el número total de alumnos sobre el archivo a ordenar 
                        if (i <= Elemizq) {                             // hasta que se llegue al numero de alumnos en el bloque izuquierdo se almacenaran en f1 
                            try {
                                temp = br.readLine();
                            } catch (IOException ex) {                      // se leerá hasta el número de alumnos del bloque izquierdo
                                System.out.println("No se pudo leer el archivo original");
                            }
                            p1.println(temp);                           // se escribe sobre el archivo f1
                            a.add(temp);                                // se guarda sobre la lista izquierda para comparar cad alumno por indices
                        } else {
                            try {                                          // en caso de que se hayan almacenado los alumnos del bloque izquierdo , se almacenan los de la izquierda
                                temp = br.readLine();                       // se leerá hasta el número de alumnos del bloque izquierdo
                            } catch (IOException ex) {
                                System.out.println("No se pudo leer el archivo original");
                            }
                            p2.println(temp);                           // se escribe sobre el archivo f2
                            a.add(temp);                                // se guarda sobre la lista izquierda para comparar cad alumno por indices
                        }
                    }

                    br.close();                                       // cerramos nuestros objetos de escritura de los archivos y lectura del archivo original
                    p1.close();
                    p2.close();

                    try {
                        FileReader fr1 = new FileReader(f1);            // objetos para leer aarchivos 
                        FileReader fr2 = new FileReader(f1);

                        BufferedReader br2 = new BufferedReader(fr2);   // con BufferedReader podremos leer nuestros bloques dentro de nuestros archivos auxiliares
                        BufferedReader br1 = new BufferedReader(fr1);

                        for (i = 1; i <= numAlumnos(f1); i++) {
                            try {
                                a1.add(br1.readLine().split(", "));     // a1 nos sera de utilidad para identificar cada usuario con el siguiente formato [nombre,apellido,N#cuenta]                         
                            } catch (IOException ex) {
                                System.out.println(" No se encontro el archivo auxiliar f2 para lectura");
                            }
                        }

                        for (i = 1; i <= numAlumnos(f2); i++) {
                            try {
                                a2.add(br2.readLine().split(", "));     // a2 nos sera de utilidad para identificar cada usuario con el siguiente formato [nombre,apellido,N#cuenta]
                            } catch (IOException ex) {
                                System.out.println(" No se encontro el archivo auxiliar f2 para lectura");
                            }
                        }

                        br1.close();                                    // cerramos los objetos que nos ayudaron a leer los archivos auxiliares
                        br2.close();

                        i = 0;
                        j = 0;
                        k = 0;

                        while (numAlumnos(f1) != j && numAlumnos(f2) != k) {

                            aux = a1.get(j);
                            aux2 = a2.get(k);

                            switch (tipo) {

                                case "1":  // para ordenar apartir de apellido 
                                    if ((int) aux[0].charAt(0) < (int) aux2[0].charAt(0)) { // El indice de aux[0] indica la sección del nombre 
                                        a.set(i, arrtoString(a1.get(j)));                    // charAt(0) indica que se compara la primer letra 
                                        i++; // I = I+1 ;
                                        j++;
                                    } else {
                                        a.set(i, arrtoString(a2.get(k)));
                                        i++;
                                        k++;
                                    }
                                    break;

                                case "2":  // para ordenar apartir de Nombre 
                                    if ((int) aux[1].charAt(0) < (int) aux2[1].charAt(0)) { // El indice de aux[0] indica la sección del nombre
                                        a.set(i, arrtoString(a1.get(j)));                   // charAt(0) indica que se compara la primer letra 
                                        i++;
                                        j++;
                                    } else {
                                        a.set(i, arrtoString(a2.get(k)));
                                        i++;
                                        k++;
                                    }
                                    break;

                                case "3":  // para ordenar apartir de numero de cuenta 
                                    if ((int) aux[2].charAt(0) < (int) aux2[2].charAt(0)) { // El indice de aux[0] indica la sección del nombre
                                        a.set(i, arrtoString(a1.get(j)));                   // charAt(0) indica que se compara la primer letra 
                                        i++;
                                        j++;
                                    } else {
                                        a.set(i, arrtoString(a2.get(k)));
                                        i++;
                                        k++;
                                    }
                                    break;
                            }
                        }

                        while (a1.size() != j) {
                            a.set(i, arrtoString(a1.get(j)));
                            i++;
                            j++;
                        }

                        while (a2.size() != k) {
                            a.set(i, arrtoString(a2.get(k)));
                            i++;
                            k++;
                        }

                    } catch (FileNotFoundException ex) {
                        System.out.println("No se pudo encontrar: " + f1.getName() + " y " + f2.getName());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

                for (String var : a) {
                    pr.println(var);
                }

                pr.close();
            } // fin de if 

        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo del usuario");
        }
    } // fin de Mezla directa 
}
