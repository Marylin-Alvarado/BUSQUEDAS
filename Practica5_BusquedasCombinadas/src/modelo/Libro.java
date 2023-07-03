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
public class Libro {

    private Integer Id;
    private String nombre_libro;
    private String editorial;
    private String tipo;
    private String Autor;
    private Integer Id_Libreria;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public Integer getId_Libreria() {
        return Id_Libreria;
    }

    public void setId_Libreria(Integer Id_Libreria) {
        this.Id_Libreria = Id_Libreria;
    }

    @Override
    public String toString() {
        return "Libro{" + "Id=" + Id + ", nombre_libro=" + nombre_libro + ", editorial=" + editorial + ", tipo=" + tipo + ", Id_Libreria=" + Id_Libreria + '}';
    }

}
