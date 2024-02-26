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
                return "BARCO";
            case BARCO_DE_GUERRA:
                return "BARCO DE GUERRA";
            case BARCO_DE_PESCA:
                return "BARCO DE PESCA";
            default:
                return "No especificado";
        }
    }
}
