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
        String[] armamento = {"Lanza", "Cañon"};
        Data fecha_construccion = new Data();
        BarcoDeGuerra barco1 = new BarcoDeGuerra("Paco", "111111", 1992, fecha_construccion, 200, 300, armamento);
        String[] arm2 = {"Lanza", "Harpón"};
        System.out.println(barco1.toString());
        barco1.anyadirArmamento(arm2);
        System.out.println(barco1.toString());
    }

}
