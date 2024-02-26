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
public class BarcoDePesca extends Barco {
    private int capacidadDeCarga;
    private String[] redes;
    private int porcentajeCaptura;
    
     public BarcoDePesca(String nombre, String matricula, int anyoConstruccion, Data fecha_compra, int capacidadDeCarga, int porcentajeCaptura) {
        super(TipoBarco.BARCO_DE_PESCA, nombre, matricula, anyoConstruccion, fecha_compra);
        this.capacidadDeCarga = capacidadDeCarga;
        this.porcentajeCaptura = porcentajeCaptura;
        this.redes = null;
    }

    @Override
    public String toString() {
        return super.toString() + ", redes: " + Arrays.toString(this.redes) + ", porcentaje de éxito en captura: " + this.porcentajeCaptura;
    }
    
    public void anyadirNuevaRed(String red) {
        
    }
     
    
}
