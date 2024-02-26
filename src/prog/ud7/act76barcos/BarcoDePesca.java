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
        this.redes = new String[0];
    }

    @Override
    public String toString() {
        return super.toString() + ", redes: " + Arrays.toString(this.redes) + ", porcentaje de éxito en captura: " + this.porcentajeCaptura;
    }
    
    @Override
    public void realizarMantenimiento() {
        super.horasMantenimiento += 400;
    }

    public void anyadirNuevaRed(Red red) {
        String[] nuevaRedes = new String[this.redes.length + 1];
        System.arraycopy(this.redes, 0, nuevaRedes, 0, this.redes.length);
        nuevaRedes[nuevaRedes.length - 1] = red.toString();
        this.redes = nuevaRedes;
    }
    
    public void eliminarRed(Red red) {
        for (int i = 0; i < this.redes.length; i++) {
            if (this.redes[i].equals(red.toString())) {
                this.redes[i] = null;
            }
        }
    }
}
