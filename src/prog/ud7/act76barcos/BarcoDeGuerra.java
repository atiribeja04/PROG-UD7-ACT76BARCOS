/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud7.act76barcos;

import java.util.Arrays;

/**
 *
 * @author batoi
 */
public class BarcoDeGuerra extends Barco {
    private String[] armamento;
    private int tripulacionMaxima;
    private int tripulacionActual;
    
    public BarcoDeGuerra(String nombre, String matricula, int anyoConstruccion, Data fecha_compra, int tripulacionActual, int tripulacionMaxima, String[] armamento) {
        super(TipoBarco.BARCO_DE_GUERRA, nombre, matricula, anyoConstruccion, fecha_compra);
        this.tripulacionActual = tripulacionActual;
        this.tripulacionMaxima = tripulacionMaxima;
        this.armamento = armamento;
        
        if (this.tripulacionActual > this.tripulacionMaxima) {
            this.tripulacionActual = this.tripulacionMaxima;
        }
    }
    @Override
    public void realizarMantenimiento() {
        super.horasMantenimiento += 200;
    }
    
    public void aumentarTripulantes (int aumento) {
        if ((this.tripulacionActual + aumento) < tripulacionMaxima) {
            this.tripulacionActual += aumento;
        }
    }
    
    public void aumentarMaximoDeTripulantes(int aumento) {
        this.tripulacionMaxima+= aumento;
    }
    
    public void anyadirArmamento(String[] armamentoNuevo) {
    String[] armamentoActualizado = new String[this.armamento.length + armamentoNuevo.length];
    for (int i = 0; i < this.armamento.length; i++) {
        armamentoActualizado[i] = this.armamento[i];
    }
    
        for (int i = 0; i < (armamentoNuevo.length); i++) {
                for (int j = 0; j < this.armamento.length; j++) {
                    if (!this.armamento[j].equals(armamentoNuevo[i])) {
                        armamentoActualizado[this.armamento.length + 1] = armamentoNuevo[i];
                    }
                }
        }
        this.armamento = armamentoActualizado;
    }

    @Override
    public String toString() {
        return super.toString() + ", armas a bordo: " + Arrays.toString(this.armamento) + ", número de tripulantes: " + this.tripulacionActual; 
    }
    
    
    
}
