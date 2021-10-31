package Menu;

import Polifase.Lectura;
import Polifase.Polifase;
import Polifase.Alumno;
import MezclaEquilibrada.AlgoritmosOrdenExtern;
import SimulacionRadix.Radix;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu
{
    public static void main(String[] args)
    {
        // Intanciamientos de objetos necesarios para leer datos de teclado
        Scanner sc = new Scanner(System.in);
        
        Lectura read = new Lectura();
        Polifase polifase = new Polifase();
        AlgoritmosOrdenExtern ord = new AlgoritmosOrdenExtern();
        Radix radix = new Radix();
        ArrayList<Alumno> alumnos;

        // Declaración de clave para entrar dentro del menu principal
        boolean entrar = true;
        
        String name;
        
        while (entrar) // Ciclo repetitivo para menu principal
        {
            System.out.println("\n\n");
            System.out.println("\t      ===============================================");
            System.out.println("\t      |*********************************************|");
            System.out.println("\t      |*|   Algoritmos de Ordenamiento Externo    |*|");
            System.out.println("\t      |*|            Proyecto 1                   |*|");
            System.out.println("\t      |*|                                         |*|");
            System.out.println("\t      |*********************************************|");
            System.out.println("\t      =============================================== \n\n");

            System.out.println("\t==============================================================");
            System.out.println("\t|************************************************************|");
            System.out.println("\t|*| Bienvenido!!, los Algoritmos de Ordenamiento son los   |*|");
            System.out.println("\t|*| siguinetes:                                            |*|");
            System.out.println("\t|*|                                                        |*|");
            System.out.println("\t|*|   1 ) Simulación de Método por Polifase.               |*|");
            System.out.println("\t|*|                                                        |*|");
            System.out.println("\t|*|   2 ) Simulación de Método por Mezcla equilibrada.     |*|");
            System.out.println("\t|*|                                                        |*|");
            System.out.println("\t|*|   3 ) Simulación de Radix.                             |*|");
            System.out.println("\t|*|                                                        |*|");
            System.out.println("\t|*|   4 ) Salir del programa.                              |*|");
            System.out.println("\t|*|                                                        |*|");
            System.out.println("\t|************************************************************|");
            System.out.println("\t============================================================== \n\n");

            System.out.println("   Ingrese por favor el numero de la accion que desea realizar ");
            System.out.print("\n\n Numero >>> ");
            String menu = sc.next();

            switch (menu)
            {
                case "1":   // Opción 1 : Método por Polifase

                    boolean entrar1 = true;
                    while (entrar1)
                    {
                        System.out.println("\n\n");
                        System.out.println("\t     ||>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>||");
                        System.out.println("\t     ||*|                                            |*||");
                        System.out.println("\t     ||*|     Simulación de Método por Polifase      |*||");
                        System.out.println("\t     ||*|                                            |*||");
                        System.out.println("\t     ||<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<||\n\n\t");

                        System.out.println("\t||>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>||");
                        System.out.println("\t||*| Con que criterio deseas ordenar el archivo?  |*||");
                        System.out.println("\t||*|                                              |*||");
                        System.out.println("\t||*|   1 ) Apellido.                              |*||");
                        System.out.println("\t||*|                                              |*||");
                        System.out.println("\t||*|   2 ) Nombre.                                |*||");
                        System.out.println("\t||*|                                              |*||");
                        System.out.println("\t||*|   3 ) Numero de cuenta.                      |*||");
                        System.out.println("\t||*|                                              |*||");
                        System.out.println("\t||*|   4 ) Salir del submenu.                     |*||");
                        System.out.println("\t||*|                                              |*||");
                        System.out.println("\t||<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<||\n\n");

                        System.out.print(" N# de criterio de ordenamiento >>> ");
                        int submenu1 = sc.nextInt();

                        switch (submenu1)
                        {
                            case 1:
                                System.out.println("\n\n  * Ordenamiento por apellido");

                                System.out.print("Ingrese el nombre del archivo a Ordenar: ");
                                name = sc.next();

                                alumnos = read.leerArchivo(name);
                                polifase.apellido(alumnos);

                                break;

                            case 2:
                                System.out.println("\n\n  * Ordenamiento por Nombre");
                                System.out.print("Ingrese el nombre del archivo a Ordenar: ");
                                name = sc.next();

                                alumnos = read.leerArchivo(name);
                                polifase.nombre(alumnos);
                                break;

                            case 3:
                                System.out.println("\n\n  * Ordenamiento por Numero de cuenta");
                                System.out.print("Ingrese el nombre del archivo a Ordenar: ");
                                name = sc.next();

                                alumnos = read.leerArchivo(name);
                                polifase.noCnt(alumnos);
                                break;

                            case 4:
                                System.out.println("\n\n  * Saliendo de Submenu1");
                                entrar1 = false;
                                break;

                            default:
                                System.out.println("\n\n  * Opcion no valida");
                                break;

                        }  // Cierre de llaves de switch submenu 1
                    }  // Cierre de llaves de While de submenu1

                    break;

                case "2":  // Opción 2 : Método por Mezcla equilibra

                    boolean entrar2 = true;
                    while (entrar2)
                    {
                        System.out.println("\n\n");
                        System.out.println("\t     ||>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>||");
                        System.out.println("\t     ||*|                                                     |*||");
                        System.out.println("\t     ||*|     Simulación de Método por Mezcla equilibra       |*||");
                        System.out.println("\t     ||*|                                                     |*||");
                        System.out.println("\t     ||<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<||\n\n\t");

                        System.out.println("\t||>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>||");
                        System.out.println("\t||*| Con que criterio deseas ordenar el archivo?  |*||");
                        System.out.println("\t||*|                                              |*||");
                        System.out.println("\t||*|   1 ) Apellido.                              |*||");
                        System.out.println("\t||*|                                              |*||");
                        System.out.println("\t||*|   2 ) Nombre.                                |*||");
                        System.out.println("\t||*|                                              |*||");
                        System.out.println("\t||*|   3 ) Numero de cuenta.                      |*||");
                        System.out.println("\t||*|                                              |*||");
                        System.out.println("\t||*|   4 ) Salir del submenu.                     |*||");
                        System.out.println("\t||*|                                              |*||");
                        System.out.println("\t||<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<||\n\n");

                        System.out.print(" N# de criterio de ordenamiento >>> ");
                        String submenu2 = sc.next();

                        switch (submenu2)
                        {
                            case "1":
                                System.out.println("\n\n  * Ordenamiento por apellido");
                                System.out.print("Ingrese el nombre del archivo a Ordenar: ");
                                name = sc.next();
                                
                                ord.mezlaDirecta(name, submenu2);

                                break;

                            case "2":
                                System.out.println("\n\n  * Ordenamiento por Nombre");
                                System.out.print("Ingrese el nombre del archivo a Ordenar: ");
                                name = sc.next();

                                ord.mezlaDirecta(name, submenu2);

                                break;

                            case "3":
                                System.out.println("\n\n  * Ordenamiento por Numero de cuenta");
                                System.out.print("Ingrese el nombre del archivo a Ordenar: ");
                                name = sc.next();

                                ord.mezlaDirecta(name, submenu2);

                                break;

                            case "4":
                                System.out.println("\n\n  * Saliendo de Submenu1");
                                entrar2 = false;
                                break;

                            default:
                                System.out.println("\n\n  * Opcion no valida");
                                break;

                        }  // Cierre de llaves de switch submenu 2
                    }  // Cierre de llaves de While de submenu2

                    break;

                case "3":   // Opción 3 : Simulación de Radix
                    boolean entrar3 = true;
                    while (entrar3)
                    {
                        System.out.println("\n\n");
                        System.out.println("\t     ||>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>||");
                        System.out.println("\t     ||*|                              |*||");
                        System.out.println("\t     ||*|     Simulación de Radix      |*||");
                        System.out.println("\t     ||*|                              |*||");
                        System.out.println("\t     ||<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<||\n\n\t");

                        System.out.println("\t||>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>||");
                        System.out.println("\t||*| Con que criterio deseas ordenar el archivo?  |*||");
                        System.out.println("\t||*|                                              |*||");
                        System.out.println("\t||*|   1 ) Apellido.                              |*||");
                        System.out.println("\t||*|                                              |*||");
                        System.out.println("\t||*|   2 ) Nombre.                                |*||");
                        System.out.println("\t||*|                                              |*||");
                        System.out.println("\t||*|   3 ) Numero de cuenta.                      |*||");
                        System.out.println("\t||*|                                              |*||");
                        System.out.println("\t||*|   4 ) Salir del submenu.                     |*||");
                        System.out.println("\t||*|                                              |*||");
                        System.out.println("\t||<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<||\n\n\t");

                        System.out.print(" N# de criterio de ordenamiento >>> ");
                        String submenu3 = sc.next();

                        switch (submenu3)
                        {
                            case "1":
                                System.out.println("\n\n  * Ordenamiento por apellido");
                                System.out.print("Ingrese el nombre del archivo a Ordenar: ");
                                name = sc.next();

                                radix.radixSort(name, submenu3);

                                break;

                            case "2":
                                System.out.println("\n\n  * Ordenamiento por Nombre");
                                System.out.print("Ingrese el nombre del archivo a Ordenar: ");
                                name = sc.next();

                                radix.radixSort(name, submenu3);

                                break;

                            case "3":
                                System.out.println("\n\n  * Ordenamiento por Numero de cuenta");
                                System.out.print("Ingrese el nombre del archivo a Ordenar: ");
                                name = sc.next();

                                radix.radixSort(name, submenu3);

                                break;

                            case "4":
                                System.out.println("\n\n  * Saliendo de Submenu1");
                                entrar3 = false;
                                break;

                            default:
                                System.out.println("\n\n  * Opcion no valida");
                                break;

                        }  // Cierre de llaves de switch submenu 3
                    }  // Cierre de llaves de While de submenu3

                    break;

                case "4":   // Opción 3 : Salir de programa

                    System.out.println("\n\n");
                    System.out.println("\t     ||>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>||");
                    System.out.println("\t     ||*|     Muchas gracias         |*||");
                    System.out.println("\t     ||*|        Saliendo ...        |*||");
                    System.out.println("\t     ||<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<||\n\n\t");

                    entrar = false; // esta instrucción detiene el ciclo while del menu

                    break;

                default:

                    System.out.println("\n\n");
                    System.out.println("\t     ||>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>||");
                    System.out.println("\t     ||*|  Lo lamentamos opción " + menu + " fuera del rango opciones  |*||");
                    System.out.println("\t     ||*|                Intente de nuevo !                  |*||");
                    System.out.println("\t     ||*|                                                    |*||");
                    System.out.println("\t     ||<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<||\n\n\t");

                    break;

            }  /// Cierre de While de Menu principal
        }
    }
}
