/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud7.act76barcos;

/**
 *
 * @author batoi
 */
public class Barco {
   protected TipoBarco tipo;
   protected String nombre;
   protected String matricula;
   protected int anyoConstruccion;
   protected Data fecha_compra;
   protected int horasMantenimiento;

    public Barco(TipoBarco tipo, String nombre, String matricula, int anyoConstruccion, Data fecha_compra) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.matricula = matricula;
        this.anyoConstruccion = anyoConstruccion;
        this.fecha_compra = fecha_compra;
        this.horasMantenimiento = 0;
    }
    
    @Override
    public String toString() {
        return ("Tipo de barco: " + this.tipo + ", nombre: " + this.nombre + ", matricula: " + this.matricula + ", año de construcción: " + this.anyoConstruccion + ", horas de mantenimiento: " + this.horasMantenimiento);
    }
    
    public void realizarMantenimiento() {
        this.horasMantenimiento += 100;
    }
}
