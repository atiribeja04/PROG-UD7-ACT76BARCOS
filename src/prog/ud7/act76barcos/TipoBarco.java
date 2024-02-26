/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud7.act76barcos;

/**
 *
 * @author batoi
 */
public enum TipoBarco {
    BARCO, BARCO_DE_GUERRA, BARCO_DE_PESCA;
    
    @Override
    public String toString() {
        switch (this) {
            case BARCO:
                return "Barco";
            case BARCO_DE_GUERRA:
                return "Barco de Guerra";
            case BARCO_DE_PESCA:
                return "Barco de Pesca";
            default:
                return "No especificado";
        }
    }
}
