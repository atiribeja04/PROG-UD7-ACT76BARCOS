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
    protected enum Tamano {
        PEQUENA, MEDIANA, GRANDE;
        
        @Override
        public String toString() {
            switch (this) {
                case PEQUENA:
                    return "pequeña";
                case MEDIANA:
                    return "mediana";
                case GRANDE:
                    return "grande";
                default:
                    return "ERROR";
            }
        }
    }
    
    protected enum Material {
        POLIAMIDA, POLIESTER, POLIETILENO; 
        
        @Override
        public String toString() {
            switch (this) {
                case POLIAMIDA:
                    return "poliamida";
                case POLIESTER:
                    return "poliéster";
                case POLIETILENO:
                    return "polietileno";
                default:
                    return "ERROR";
            }
        }
    }
    
    protected enum Tipo {
        PESCA_SPINNING, SUBMARINA, CARPFISHING;
        
        @Override
        public String toString() {
            switch (this) {
                case PESCA_SPINNING:
                    return "pesca spinning";
                case SUBMARINA:
                    return "pesca submarina";
                case CARPFISHING:
                    return "pesca carpfishing";
                default:
                    return "ERROR";
            }
        }
    }
    
    private Tamano tamano;
    private Material material;
    private Tipo tipo;
    
    public Red(Tamano tamano, Material material, Tipo tipo) {
        this.tamano = tamano;
        this.material = material;
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        return ("Red de tamaño " + this.tamano.toString() + " hecha de " + this.material.toString() + " para "+ this.tipo.toString());
    }
}
