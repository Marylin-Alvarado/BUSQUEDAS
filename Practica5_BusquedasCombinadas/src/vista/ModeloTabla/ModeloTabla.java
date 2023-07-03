/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ModeloTabla;

import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Libro;

/**
 *
 * @author Marylin
 */
public class ModeloTabla extends AbstractTableModel {

    ListaEnlazada<Libro> lista = new ListaEnlazada();

    public ListaEnlazada<Libro> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Libro> lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return lista.getTamanio();
    }

    @Override
    public String getColumnName(int i) {

        switch (i) {
            case 0:
                return "Nombre_libro";
            case 1:
                return "editorial";
            case 2:
                return "tipo";
            case 3:
                return "Autor";

            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Libro lb = null;
        try {
            lb = lista.obtener(i);

        } catch (ListaVaciaException ex) {
            System.out.println(ex);
        } catch (PosicionNoEncontradaException ex) {
            System.out.println(ex);
        }
        switch (i1) {
            case 0:
                return (lb != null) ? lb.getNombre_libro() : "NO DEFINIDO";
            case 1:
                return (lb != null) ? lb.getEditorial() : "NO DEFINIDO";
            case 2:
                return (lb != null) ? lb.getTipo() : "NO DEFINIDO";
            case 3:
                return (lb != null) ? lb.getAutor(): "NO DEFINIDO";
            default:
                return null;
        }

    }
}
