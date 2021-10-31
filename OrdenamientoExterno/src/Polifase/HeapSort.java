package Polifase;

/**
 *
 * @author Nahim Rosas
 */

import java.io.*;
import java.util.ArrayList;

public class HeapSort
{
    static void sort(ArrayList<Alumno> lista, ArrayList<String> listaAp)
    {
        buildHeap(lista, listaAp);
        for (int i = lista.size() - 1; i >= 1; i--)
        {
            Alumno temp = lista.get(0);
            String temp1 = listaAp.get(0);
            
            lista.set(0, lista.get(i));
            listaAp.set(0, listaAp.get(i));
            
            lista.set(i, temp);
            listaAp.set(i, temp1);
            heapify(lista, listaAp, i, 0);
        }
    }
    
    static void buildHeap(ArrayList<Alumno> lista, ArrayList<String> listaAp)
    {
        for (int i = lista.size() / 2 - 1; i >= 0; i--)
        {
            heapify(lista, listaAp, lista.size(), i);
        }
    }
    
    static void heapify(ArrayList<Alumno> lista, ArrayList<String> listaAp, int n, int i)
    {
        int max, child;
        child = 2 * i + 1;
        max = i;
        if (child < n)
        {
            if ( (listaAp.get(child)).compareTo((listaAp.get(max))) > 0)
            {
                max = child;
            }
        }
        if (child + 1 < n)
        {
            if ( (listaAp.get(child + 1)).compareTo((listaAp.get(max))) > 0)
            {
                max = child + 1;
            }
        }
        if (max != i)
        {
            Alumno temp = lista.get(i);
            String temp1 = listaAp.get(i);
            
            lista.set(i, lista.get(max));
            listaAp.set(i, listaAp.get(max));
            
            lista.set(max, temp);
            listaAp.set(max, temp1);
            heapify(lista, listaAp, n, max);
        }
    }
}
