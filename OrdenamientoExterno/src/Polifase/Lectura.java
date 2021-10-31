package Polifase;

/**
 *
 * @author Nahim Rosas
 */

import java.io.*;
import java.util.ArrayList;

public class Lectura
{
    ArrayList<Alumno> alumnos = new ArrayList<>();

    /*
        brief: leerArchivo() lee los elementos contenidos en un archivo de texto.
        param: nombre del archivo a leer return: Lista que contiene en cada
        indice a un alumno
    */
    public ArrayList leerArchivo(String nombreArchivo)
    {
        try
        {
            FileReader archivoLeer = new FileReader(nombreArchivo); // Verifica si el archivo se encuentra dentro del directorio del proyecto
            BufferedReader linea = new BufferedReader(archivoLeer); // Buffered nos será de utilidad para leer nuestro archivo
            
            String cad, Apellido, Nombre, NoCnt;
            int tamCad, coma1 = 0, coma2 = 0;
            
            for (int i = 0; i<100; i++) // Leera el numero de lineas existentes en el archivo
            {
                try
                {
                    cad = linea.readLine(); // Se coloca la linea leida en una cadena provisional para posteriormente registrar la posicion de las comas existentes en esta linea.
                    tamCad = cad.length();
                    
                    int cont = 0, j = 0;
                    do
                    {
                        if ( cad.charAt(j) == ',' && cont == 0 )
                        {
                            cont ++;
                            coma1 = j;
                        }
                        else
                        {
                            if (cad.charAt(j) == ',' && cont == 1 )
                            {
                                cont++;
                                coma2 = j;
                            }
                        }
                        j++;
                    } while (cont != 2);
                    
                    /* Utilizando la posicion de las comas como referencia, se pasara la posicion exacta de el inicio y final de las subcadenas definidas por estas comas,
                       se añadiran a variables temporales de tipo String y se creara un nuevo objeto de tipo alumno con estos datos, elemento que se añadira a la lista */
                    
                    Apellido = cad.substring(coma1+2, coma2); 
                    Nombre = cad.substring(0, coma1);
                    NoCnt = cad.substring(coma2+2, tamCad);
                    
                    Alumno alumno = new Alumno(Apellido, Nombre, NoCnt);
                    alumnos.add(alumno); // lee cada "renglon" o alumno dentro de la lista 
                }
                catch (IOException ex) // En cao de que el archivo este vacío mostrara un avisp 
                {
                    System.out.println("\n\n Lo lamento, no se encontraron alumnos dentro del archivo ' " + nombreArchivo + " ' \n\n");
                }
            }
            
            // Ya que se hicieron los lecturas pertinentes al archiv cerramos las entradas 
            try
            {
                archivoLeer.close();
                linea.close();
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("\n\n Lo lamento, el archivo no pudo ser encontrado en el directorio :("); // En caso de no encontrarlo, manda aviso a usuario
        }

        // regresamos la lista que contiene a los alumnos 
        return alumnos;
    }
}
