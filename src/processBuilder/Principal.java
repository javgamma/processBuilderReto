/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package processBuilder;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author javmir
 */
public class Principal {

    public static void main(String[] args) throws InterruptedException, IOException {

        /*Usaré un try with resources para no agregar el bloque finally con el scanner.close()*/
        try ( Scanner scanner = new Scanner(System.in)) {
            System.out.println("Introduce la ruta del archivo o programa que quieres abrir");
            String ruta = scanner.nextLine();

            /**
             * Si queremos abrir el archivo en Mac ponemos el siguiente código:
             */
            ProcessBuilder pb = new ProcessBuilder("open", ruta);

            /*Si queremos abrir una aplicacion como Calculator, Cheez,App Store en este caso el codigo es:*/
            //ProcessBuilder pb = new ProcessBuilder("open","-a",ruta);
            System.out.println("¿Cuántos segundos quieres que tarde en inicializar el programa?");
            int tiempo = scanner.nextInt();

            /* Si queremos ejecutar en Windows el código sería:
            ProcessBuilder pb = new ProcessBuilder(ruta);
             */
            // Hacer que el hilo principal duerma el tiempo que nos diga el usuario
            System.out.println("Esperando "+tiempo+" segundos");
            Thread.sleep(tiempo * 1000); // Convertir segundos a milisegundos
            

            // Iniciar el proceso
            pb.start();
            System.out.println("PROGRAMA LANZADO");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
