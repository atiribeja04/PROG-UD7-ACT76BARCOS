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

    public BarcoDeGuerra(String nombre, String matricula, int anyoConstruccion, Data fecha_compra, int tripulacionActual, int tripulacionMaxima, String arma1, String arma2) {
        super(TipoBarco.BARCO_DE_GUERRA, nombre, matricula, anyoConstruccion, fecha_compra);
        this.tripulacionActual = tripulacionActual;
        this.tripulacionMaxima = tripulacionMaxima;

        if (arma1 == null && arma2 == null) {
            this.armamento = new String[0];
        } else if (arma1 == null || arma2 == null) {
            this.armamento = new String[1];
            this.armamento[0] = (arma1 != null) ? arma1 : arma2;
        } else if (arma1.equals(arma2)) {
            this.armamento = new String[1];
            this.armamento[0] = arma1;
        } else {
            this.armamento = new String[2];
            this.armamento[0] = arma1;
            this.armamento[1] = arma2;
        }

        if (this.tripulacionActual > this.tripulacionMaxima) {
            this.tripulacionActual = this.tripulacionMaxima;
        }
    }

    public BarcoDeGuerra(String nombre, String matricula, int anyoConstruccion, Data fecha_compra, int tripulacionActual, int tripulacionMaxima, String arma1, String arma2, String arma3) {
        super(TipoBarco.BARCO_DE_GUERRA, nombre, matricula, anyoConstruccion, fecha_compra);
        this.tripulacionActual = tripulacionActual;
        this.tripulacionMaxima = tripulacionMaxima;

        this.armamento = new String[3];
        int indice = 0;

        if (arma1 != null && !arma1.equals(arma2) && !arma1.equals(arma3)) {
            this.armamento[indice++] = arma1;
        }
        if (arma2 != null && !arma2.equals(arma1) && !arma2.equals(arma3)) {
            this.armamento[indice++] = arma2;
        }
        if (arma3 != null && !arma3.equals(arma1) && !arma3.equals(arma2)) {
            this.armamento[indice++] = arma3;
        }

        if (indice < 3) {
            String[] aux = new String[indice];
            System.arraycopy(this.armamento, 0, aux, 0, indice);
            this.armamento = aux;
        }

        if (this.tripulacionActual > this.tripulacionMaxima) {
            this.tripulacionActual = this.tripulacionMaxima;
        }
    }

    @Override
    public void realizarMantenimiento() {
        super.horasMantenimiento += 300;
    }

    public void aumentarTripulantes(int aumento) {
        if ((this.tripulacionActual + aumento) < tripulacionMaxima) {
            this.tripulacionActual += aumento;
        } else {
            this.tripulacionActual = this.tripulacionMaxima;
        }
    }

    public void aumentarMaximoDeTripulantes(int aumento) {
        this.tripulacionMaxima += aumento;
    }

   public void anyadirArmamento(String[] armamentoNuevo) {
    String[] armamentoActualizado = new String[this.armamento.length + armamentoNuevo.length];
    for (int i = 0; i < this.armamento.length; i++) {
        armamentoActualizado[i] = this.armamento[i];
    }

    int indice = this.armamento.length;

    for (int i = 0; i < armamentoNuevo.length; i++) {
        boolean existe = false;
        for (int j = 0; j < armamentoActualizado.length; j++) {
            if (armamentoNuevo[i].equals(armamentoActualizado[j])) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            armamentoActualizado[indice++] = armamentoNuevo[i];
        }
    }

    this.armamento = Arrays.copyOf(armamentoActualizado, indice);
}


    @Override
    public String toString() {
        return super.toString() + ", armas a bordo: " + Arrays.toString(this.armamento) + ", número de tripulantes: " + this.tripulacionActual;
    }

    public int getTripulacionMaxima() {
        return tripulacionMaxima;
    }

    public int getTripulacionActual() {
        return tripulacionActual;
    }

}
