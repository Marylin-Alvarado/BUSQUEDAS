/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Marylin
 */
public class Libreria {

    private String seccion;
    private String nombre;
    private Integer Id ;
    private Integer Id_Libro;

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Integer getId_Libro() {
        return Id_Libro;
    }

    public void setId_Libro(Integer Id_Libro) {
        this.Id_Libro = Id_Libro;
    }
    

    @Override
    public String toString() {
        return "Libreria{" + "seccion=" + seccion + ", nombre=" + nombre + ", Id=" + Id + '}';
    }

    
}
