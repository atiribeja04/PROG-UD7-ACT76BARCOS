/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud7.act76barcos;

/**
 *
 * @author batoi
 */

public class TestBarco {

    public static void main(String[] args) {
        Barco barco1 = new Barco(TipoBarco.BARCO, "La molinera", "XXXX", 2005, new Data());
        BarcoDeGuerra barco2 = new BarcoDeGuerra("Arrasator", "YYYYY", 2017, new Data(), 0, 5, "Lanza torpedos", null);
        BarcoDePesca barco3 = new BarcoDePesca("Faenero", "ZZZZZ", 2001, new Data(), 100, 40);

        System.out.println(barco1.toString());
        System.out.println(barco2.toString());
        System.out.println(barco3.toString());

        barco1.realizarMantenimiento();
        barco2.realizarMantenimiento();
        barco2.realizarMantenimiento();
        barco3.realizarMantenimiento();
        barco3.realizarMantenimiento();

        System.out.println(barco1.toString());
        System.out.println(barco2.toString());
        System.out.println(barco3.toString());

        Red red1 = new Red(Red.Tamano.MEDIANA, Red.Material.POLIAMIDA, Red.Tipo.CARPFISHING);
        Red red2 = new Red(Red.Tamano.PEQUENA, Red.Material.POLIESTER, Red.Tipo.SUBMARINA);
        barco3.anyadirNuevaRed(red1);
        barco3.anyadirNuevaRed(red2);
        barco2.anyadirArmamento(new String[]{"Misil de Crucero", "Misil de Crucero", "Cañon", "Cañon"});

        System.out.println(barco2.toString());
        System.out.println(barco3.toString());

        barco3.eliminarRed(red1);

        System.out.println(barco3.toString());

        System.out.println("------ Comprobación de tripulantes -------");
        System.out.printf("Tripulantes máximos actuales: %d\n", barco2.getTripulacionMaxima());
        System.out.printf("Tripulantes actuales: %d\n", barco2.getTripulacionActual());
        System.out.println("Añadimos diez tripulantes:");
        barco2.aumentarTripulantes(10);
        System.out.printf("Ahora los tripulantes actuales son: %d\n", barco2.getTripulacionActual());
        System.out.println("Añadimos el máximo en 20 tripulantes...");
        barco2.aumentarMaximoDeTripulantes(20);
        System.out.println("Añadimos 10 tripulantes y mostramos los tripulantes actuales:");
        barco2.aumentarTripulantes(10);
        System.out.println(barco2.getTripulacionActual());
    }
}

