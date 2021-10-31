package SimulacionRadix;

/**
 *
 * @author Diego Blanco
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Radix {

    public int numAlumnos(File fil) throws FileNotFoundException {

        int numeroLineas = 0;
        String sCadena = "";
        if (fil.exists()) {
        } else {
            FileReader fr = new FileReader(fil);
            BufferedReader bf = new BufferedReader(fr);
            try {
                while ((sCadena = bf.readLine()) != null) {
                    numeroLineas++;
                }
            } catch (IOException ex) {
                Logger.getLogger(Radix.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return numeroLineas;
    }

    public String arrtoString(String[] a) {
        return a[0] + ", " + a[1] + ". " + a[3];
    }

    public void radixSort(String file, String tipo) {
        int i, j, k;
        ArrayList<String> a = new ArrayList<>();
        ArrayList<String[]> a1 = new ArrayList<>();
        ArrayList<String[]> a2 = new ArrayList<>();

        String aux[];
        String aux2[];

        try {
            File f = new File(file);
            FileReader f0 = new FileReader(f);
            BufferedReader br = new BufferedReader(f0);
            File ordenado = new File("ordenado.txt");
            PrintWriter pr = new PrintWriter(ordenado);

            if (numAlumnos(f) > 1) {

                try {

                    try {
                        FileReader fr1 = new FileReader(file);

                        try (BufferedReader br2 = new BufferedReader(fr1)) {

                            i = 0;
                            j = 0;
                            k = 0;

                            for (i = 0; numAlumnos(fr1) >= i; i++) {
                                try {
                                    a1.add(i, br.readLine().split(", "));
                                } catch (IOException ex) {
                                    System.out.println(" No se encontro el archivo auxiliar f2 para lectura");
                                }
                            }

                        }

                        while (a1.size() != j && a2.size() != k) {

                            aux = a1.get(j);
                            aux2 = a2.get(k);
                            switch (tipo) {

                                case "1":
                                    if ((int) aux[0].charAt(0) < (int) aux2[0].charAt(0)) {
                                        a.set(i, arrtoString(a1.get(j)));
                                        i++;
                                        j++;
                                    } else {
                                        a.set(i, arrtoString(a2.get(k)));
                                        i++;
                                        k++;
                                    }
                                    break;

                                case "2":  // para ordenar apartir de Nombre 
                                    if ((int) aux[1].charAt(0) < (int) aux2[1].charAt(0)) {
                                        a.set(i, arrtoString(a1.get(j)));
                                        i++;
                                        j++;
                                    } else {
                                        a.set(i, arrtoString(a2.get(k)));
                                        i++;
                                        k++;
                                    }
                                    break;

                                case "3":  // para ordenar apartir de numero de cuenta 
                                    if ((int) aux[2].charAt(0) < (int) aux2[2].charAt(0)) {
                                        a.set(i, arrtoString(a1.get(j)));
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

                        a.stream().forEach((var) -> {
                            pr.println(var);
                        });
                        pr.close();

                    } catch (FileNotFoundException ex) {
                        System.out.println("No se pudo encontrar: " + f.getName());
                    }
                } catch (Exception e) {
                    System.out.println("No se pudieron crear f ");
                }
            } // fin de if 

        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo del usuario");
        }
    } // fin de RadixSort

    private int numAlumnos(FileReader fr1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
