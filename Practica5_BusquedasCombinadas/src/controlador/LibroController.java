/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.listas.Exepciones.EspacioException;
import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import controlador.listas.ListaEnlazada;
import modelo.Libro;
import modelo.enums.EnumTipoLibro;

/**
 *
 * @author Marylin
 */
public class LibroController {

    ListaEnlazada<Libro> ListaLibro;

    private Libro libro;
    private String nombre_libro;
    private String editorial;
    private String tipo;
    private String Autor;
    private EnumTipoLibro Tipo_libro;

    /**
     * Metodo para guardar la Venta
     *
     * @param venta
     * @return
     */
    public boolean guardarLibro(Libro libro) {
        if (estaLleno()) {
            return false;
        } else {
            getLibro();

//            getLibro()..agregar(libro);
            return true;
        }
    }
    
   
    /**
     * Metodo para verificar la posicion de sucursal y venta
     *
     * @return
     */
    public int verificarPosicion() {
        //  int pos = -1; // vacío
        //   int i = 0;
        //  for (Venta venta : getSucursal().getVentas()) {
        //       if (venta == null) {
        //   break;
        //    } else {
        //        pos = i;
        //    }
        //   i++;
        // }
        return 0;
    }

    /**
     * Metodo para ver si la lista esta llena
     *
     * @return
     */
    public boolean estaLleno() {
//        int tamanio = getLibro().tamanio();
//        int pos = verificarPosicion();
//        return tamanio <= pos + 1;
        return getLibro().getTipo().length() <= verificarPosicion() + 1;
    }

    /**
     * Metodo para verificar el Libro
     *
     *
     * @param posLibro
     * @return
     */
    public Boolean verificarLibro(Integer posLibro) {
        return null;

    }

    /**
     * Metodo librocontroller
     */
    public LibroController() {
        ListaLibro = new ListaEnlazada<>();

    }

    /**
     * Metodo get de libro
     *
     * @return
     */
    public Libro getLibro() {
        if (libro == null) {
            libro = new Libro();
        }
        return libro;
    }

    /**
     * Metodo set de Libro
     *
     * @param libro
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * Metodo de la lista enlazada de Libro de get libros
     *
     * @return
     */
    public ListaEnlazada<Libro> getLibros() {
        return ListaLibro;
    }

    /**
     * Metodo de la lista enlazada de libro de get libro
     *
     * @return
     */
    public ListaEnlazada<Libro> getListaLibro() {
        return ListaLibro;
    }

    /**
     * Metodo de set lista de Libro
     *
     * @param ListaLibro
     */
    public void setListaLibro(ListaEnlazada<Libro> ListaLibro) {
        this.ListaLibro = ListaLibro;
    }

    /**
     * Metodo para imprimir los meses
     *
     */
    public void imprimir() {
        for (EnumTipoLibro tipo : EnumTipoLibro.values()) {
            System.out.println(tipo.toString());
        }
    }

    /**
     * Metodo para registrar
     *
     * @return
     * @throws EspacioException
     * @throws NullException
     * @throws PosicionException
     */
    public boolean registrar() throws EspacioException, ListaVaciaException, PosicionNoEncontradaException {
        int pos = -1;
        int cont = -1;

        return true;
    }

}
