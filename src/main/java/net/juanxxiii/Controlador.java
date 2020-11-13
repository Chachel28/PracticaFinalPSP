package net.juanxxiii;

import net.juanxxiii.hilos.ConectorBBDD;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Controlador {
    public static void main(String[] args) {
        List<ConectorBBDD> hilos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int registros;
        int numHilos;
        do{
            do {
                System.out.println("Introduzca el numero de registros a insertar ( no puede ser menor a 1 )");
                registros = leerEntero(scanner);
            } while (registros < 1);
            do {
                System.out.println("Introduzca el numero de hilos ( no puede ser menor a 1 )");
                numHilos = leerEntero(scanner);
            } while (numHilos < 1);
            if (registros < numHilos) {
                System.out.println("No puede haber mas hilos que registros, como poco deben ser iguales");
            }
        }while(registros >= numHilos);
        int particion = registros / numHilos;
        int resto = registros % numHilos;
        for (int i = 0; i < numHilos; i++) {
            if(resto > 0 && i == numHilos-1) {
                hilos.add(new ConectorBBDD((particion * i) + 1, (particion * (i + 1)) + resto));
            }else {
                hilos.add(new ConectorBBDD((particion * i) + 1, (particion * (i + 1))));
            }
        }
        hilos.forEach(ConectorBBDD::start);
        for (ConectorBBDD hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException ignored) {
            }
        }
        System.out.println("Registros insertados");
    }

    private static int leerEntero(Scanner scanner) {
        int numero = -1;
        try {
            numero = scanner.nextInt();
        } catch (InputMismatchException ignored) {
            System.out.println("Valor introducido no válido");
        }finally {
            scanner.nextLine();
        }
        return numero;
    }
}
