/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.listas;

import javax.xml.bind.annotation.XmlAnyElement;

/**
 *
 * @author Marylin
 */
public class NodoLista<E> {

    private E dato;
    private NodoLista<E> siguiente;

    public NodoLista() {
        this.dato = null;
        this.siguiente = null;
    }

    public NodoLista(E dato, NodoLista<E> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    @XmlAnyElement(lax = true)
    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    //@XmlElement
    public NodoLista<E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista<E> siguiente) {
        this.siguiente = siguiente;
    }

}
