package Polifase;

/**
 *
 * @author Nahim Rosas
 */

import java.io.*;
import java.util.ArrayList;

public class Polifase                                        // Para el algoritmo de polifase se requerira el armado de bloques los cuales seran creados, ordenados e intercalados
{
    HeapSort Sort = new HeapSort();
    Intercalacion intercalacion = new Intercalacion(); 
    
    ArrayList<Alumno> F0 = new ArrayList<>(); // Lista donde se almacenara los datos del archivo ya ordenados
    ArrayList<Alumno> F1 = new ArrayList<>(); // Listas donde se almacenaran los bloques creados
    ArrayList<Alumno> F2 = new ArrayList<>(); // con toda la informacion contentiente en estos
    
    ArrayList<String> F1I = new ArrayList<>(); // Listas donde se almacenaran los bloques creados
    ArrayList<String> F2I = new ArrayList<>(); // solo con el elemento a ordenar (apellido, nombre o numero de cuenta)

    ArrayList<Alumno> Bloque1 = new ArrayList<>(); //Bloques creados con la informacion completa
    ArrayList<Alumno> Bloque2 = new ArrayList<>();

    ArrayList<String> Bloque1I = new ArrayList<>(); // Bloques creados con solo el elemento que se usara para su ordenamiento
    ArrayList<String> Bloque2I = new ArrayList<>();
    
    public int n = 25, validador = 0;
    
    public void apellido(ArrayList<Alumno> lista)
    {
        int flag = 1, cont = 0, tam2 = 0, cont2 = 0; // El atributo flag nos sirve para intercalar los bloques creados entre F1 y F2 conforme estos se vayan creando
        int tam = lista.size();
        
        for (int i = 0; i < tam; i++)                        // Se añaden cada uno de los elementos a los bloques hasta completar un numero n de lementos contenidos en estos
        {                                                    // o bien hasta que la lista original se quede sin elementos
            if (flag == 1)
            {
                Bloque1I.add(lista.get(i).getApellido());      
                Bloque1.add(lista.get(i));
                cont++;
                cont2++;
            }
            if (flag == -1)
            {
                Bloque2I.add(lista.get(i).getApellido());
                Bloque2.add(lista.get(i));
                cont++;
                cont2++;
            }

            if (cont == n || ((validador == 1) && (cont2+1 > tam2)))
            {
                validador = 0;
                if (flag == 1)
                {
                    int size = Bloque1.size();
                    Sort.sort(Bloque1, Bloque1I); // Los bloques se ordenan y se añaden a su respectivo "archivo" auxiliar
                    for (int j = 0; j < size; j++)
                    {
                        F1.add(Bloque1.get(j));
                        F1I.add(Bloque1I.get(j));
                    }
                    Bloque1.clear();
                    Bloque1I.clear();
                    if(cont2+n > tam)
                    {
                        validador = 1;
                        tam2 = tam-cont2;
                        cont2 = 0;
                    }
                }
                else
                {
                    int size = Bloque2.size();
                    Sort.sort(Bloque2, Bloque2I);
                    for (int j = 0; j < size; j++)
                    {
                        F2.add(Bloque2.get(j));
                        F2I.add(Bloque2I.get(j));
                    }
                    Bloque2.clear();
                    Bloque2I.clear();
                    if(cont2 + n > tam)
                    {
                        validador = 1;
                        tam2 = tam-cont2;
                        cont2 = 0;
                    }
                }
                flag = flag * (-1);
                cont = 0;
            }
        }
                
        F0 = intercalacion.intercalar(F1, F2, F1I, F2I, n, tam); // Los archivos auxiliares se pasan a la fucnion intercalacion
                                                                 //  para realizar el ordenamiento por intercalacion completo y se asignan a F0
        devolverArchivo(F0); // Este metodo crea el archivo de texto con los elementos ya ordenados
    }
    
    // Se hace exactamente lo mismo para Nombre y No. de cuenta con la diferencia de que solo se toma en cuenta su respectivo dato dentro del tipo de dato Alumno
    public void nombre(ArrayList<Alumno> lista)
    {
        int flag = 1, cont = 0, tam2 = 0, cont2 = 0;
        int tam = lista.size();
        
        for (int i = 0; i < tam; i++)
        {
            if (flag == 1)
            {
                Bloque1I.add(lista.get(i).getNombre());
                Bloque1.add(lista.get(i));
                cont++;
                cont2++;
            }
            if (flag == -1)
            {
                Bloque2I.add(lista.get(i).getNombre());
                Bloque2.add(lista.get(i));
                cont++;
                cont2++;
            }

            if (cont == n || ((validador == 1) && (cont2+1 > tam2)))
            {
                validador = 0;
                if (flag == 1)
                {
                    int size = Bloque1.size();
                    Sort.sort(Bloque1, Bloque1I);
                    for (int j = 0; j < size; j++)
                    {
                        F1.add(Bloque1.get(j));
                        F1I.add(Bloque1I.get(j));
                    }
                    Bloque1.clear();
                    Bloque1I.clear();
                    if(cont2+n > tam)
                    {
                        validador = 1;
                        tam2 = tam-cont2;
                        cont2 = 0;
                    }
                }
                else
                {
                    int size = Bloque2.size();
                    Sort.sort(Bloque2, Bloque2I);
                    for (int j = 0; j < size; j++)
                    {
                        F2.add(Bloque2.get(j));
                        F2I.add(Bloque2I.get(j));
                    }
                    Bloque2.clear();
                    Bloque2I.clear();
                    if(cont2 + n > tam)
                    {
                        validador = 1;
                        tam2 = tam-cont2;
                        cont2 = 0;
                    }
                }
                flag = flag * (-1);
                cont = 0;
            }
        }
                
        F0 = intercalacion.intercalar(F1, F2, F1I, F2I, n, tam);
        
        devolverArchivo(F0);
    }
    
    public void noCnt(ArrayList<Alumno> lista)
    {
        int flag = 1, cont = 0, tam2 = 0, cont2 = 0;
        int tam = lista.size();
        
        for (int i = 0; i < tam; i++)
        {
            if (flag == 1)
            {
                Bloque1I.add(lista.get(i).getNoCnt());
                Bloque1.add(lista.get(i));
                cont++;
                cont2++;
            }
            if (flag == -1)
            {
                Bloque2I.add(lista.get(i).getNoCnt());
                Bloque2.add(lista.get(i));
                cont++;
                cont2++;
            }

            if (cont == n || ((validador == 1) && (cont2+1 > tam2)))
            {
                validador = 0;
                if (flag == 1)
                {
                    int size = Bloque1.size();
                    Sort.sort(Bloque1, Bloque1I);
                    for (int j = 0; j < size; j++)
                    {
                        F1.add(Bloque1.get(j));
                        F1I.add(Bloque1I.get(j));
                    }
                    Bloque1.clear();
                    Bloque1I.clear();
                    if(cont2+n > tam)
                    {
                        validador = 1;
                        tam2 = tam-cont2;
                        cont2 = 0;
                    }
                }
                else
                {
                    int size = Bloque2.size();
                    Sort.sort(Bloque2, Bloque2I);
                    for (int j = 0; j < size; j++)
                    {
                        F2.add(Bloque2.get(j));
                        F2I.add(Bloque2I.get(j));
                    }
                    Bloque2.clear();
                    Bloque2I.clear();
                    if(cont2 + n > tam)
                    {
                        validador = 1;
                        tam2 = tam-cont2;
                        cont2 = 0;
                    }
                }
                flag = flag * (-1);
                cont = 0;
            }
        }
                
        F0 = intercalacion.intercalar(F1, F2, F1I, F2I, n, tam);
        
        devolverArchivo(F0);
    }
    
    public void devolverArchivo(ArrayList<Alumno> lista) // Crea archivo de texto con la lista de datos ya ordenada
    {
        //File archivo = new File("Registros ordenados.txt");
        try
        {
            PrintWriter print = new PrintWriter("Registros Ordenados.txt");
            for(int k=0; k<100; k++)
            {
                print.println(F0.get(k).getNombre() + ", " + F0.get(k).getApellido() + ", " + F0.get(k).getNoCnt());
            }
            print.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}