package Polifase;

/**
 *
 * @author Nahim Rosas
 */

import java.util.ArrayList;

public class Intercalacion
{
    ArrayList<Alumno> F0 = new ArrayList<>(); // Lista donde se colocaran los datos ya ordenados
    
    ArrayList<Alumno> F1 = new ArrayList<>(); // 
    ArrayList<Alumno> F2 = new ArrayList<>();
    
    ArrayList<String> Info1 = new ArrayList<>(); //  Informacion de referencia (apellido, nombre o numero de cuenta) para hacer el ordenamiento
    ArrayList<String> Info2 = new ArrayList<>();
    
    ArrayList<String> Bloques = new ArrayList<>(); //  Sub bloques generados para la intercalacion
    ArrayList<String> Bloque2 = new ArrayList<>();
    
    public ArrayList intercalar(ArrayList<Alumno> F1, ArrayList<Alumno> F2, ArrayList<String> Info1, ArrayList<String> Info2, int n, int tam)
    {
        int nprov = n, i = 0, j = 0, k = 0;
        
        if (n != tam)
        {
            
            for (int I = 0; I < tam; I = F0.size()) // Utilizando una version basada en Merge sort se intercalan los elementos de las listas en nuevos bloques crecientes de tamaño 
            {                                       // Estos bloques se intercalan entre los nuevos archivos auxiliares F1 y F2, implementando la recursion para que se haga de manera sucesiva hasta que
                while (i < nprov && j < nprov)      // El tamaño de los bloques (O en el caso base el bloque) sea igual al tamaño de la lista completa
                {
                    if (Info1.get(i).compareTo(Info2.get(j)) <= 0)
                    {
                        F0.add(k, F1.get(i));
                        Bloques.add(k, Info1.get(i));
                        i++;
                    }
                    else
                    {
                        F0.add(k, F2.get(j));
                        Bloques.add(k, Info2.get(j));
                        j++;
                    }
                    k++;
                }

                while (i < nprov)
                {
                    F0.add(k, F1.get(i));
                    Bloques.add(k, Info1.get(i));
                    i++;
                    k++;
                }

                while (j < nprov)
                {
                    F0.add(k, F2.get(j));
                    Bloques.add(k, Info2.get(j));
                    j++;
                    k++;
                }
                nprov += n;
            }
            n = n*2;
            
            int flag = 1, cont = 0, ContF1 = 0, ContF2 = 0;
            
            F1.clear();
            F2.clear();
            
            for (int l = 0; l <tam; l++)
            {
                if (flag == 1)
                {
                    F1.add(ContF1, F0.get(l));
                    Info1.add(ContF1, Bloques.get(l));
                    ContF1++;
                    cont++;
                }
                if (flag == -1)
                {
                    F2.add(ContF2, F0.get(l));
                    Info2.add(ContF2, Bloques.get(l));
                    ContF2++;
                    cont++;
                }

                if (cont == n)
                {
                    flag = flag * (-1);
                    cont = 0;
                }
            }
            
            F0 = intercalar(F1, F2, Info1, Info2, n, tam);
            
        }        
        else
        {
            return F0;
        }
        
        return F0;
    }
    
}
