/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud7.act76barcos;

/**
 *
 * @author batoi
 */
public class Red {
    protected enum tamano {
        pequeña, mediana, grande;
    }
    protected enum material {
        poliamida, poliéster, polietileno; 
    }
    protected enum tipo {
        PESCA_SPINNING, SUBMARINA, CARPFISHING;
        
        @Override
        public String toString() {
            switch (this) {
                case PESCA_SPINNING:
                    return "pesca spinning";
                case SUBMARINA:
                    return "submarina";
                case CARPFISHING:
                    return "carpfishing";
                default:
                    return "ERROR";
            }
        }
    }
}
