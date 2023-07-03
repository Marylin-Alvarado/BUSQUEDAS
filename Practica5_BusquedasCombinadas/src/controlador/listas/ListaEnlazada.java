/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.listas;

import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import utilidades.Utilidades;

/**
 *
 * @author Marylin
 */
public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;
    private Integer tamanio;
    private Integer size = 0;
    public static Integer DESCENDENTE = 1;
    public static Integer ASCENDENTE = 2;

    public ListaEnlazada() {
        cabecera = null;
        tamanio = 0;
    }

    public Boolean estaVacia() {
        return cabecera == null;
    }
    
     public void modificar(E info, Integer pos) throws PosicionNoEncontradaException {
        if (!estaVacia()) {
            insertar(info);
        } else if (pos >= 0 && pos < size) {
            if (pos == 0) {
                cabecera.setDato(info);
            } else {
                NodoLista<E> aux = cabecera;
                for (int i = 0; i < pos; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setDato(info);
            }
        } else {
            throw new PosicionNoEncontradaException();
        }
    }

    public void insertar(E dato) {
        NodoLista<E> nodo = new NodoLista<>(dato, null);

        if (estaVacia()) {
            this.cabecera = nodo;
        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);

        }

        tamanio++;
    }

    public void imprimir() {
        System.out.println("Lista Enlazada");
        NodoLista<E> aux = cabecera;
        while (aux != null) {
            System.out.println(aux.getDato().toString() + "\t");
            aux = aux.getSiguiente();
        }
    }

    public void update(Integer pos, E dato) throws ListaVaciaException, PosicionNoEncontradaException {
        if (estaVacia()) {
            throw new ListaVaciaException();
        } else {
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getDato();

                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    aux.setDato(dato);
                    
                }
            } else {
                throw new PosicionNoEncontradaException();
            }
        }

    }

    public void insertarCabecera(E dato) {
        if (estaVacia()) {
            insertar(dato);
        } else {
            NodoLista<E> nodo = new NodoLista<>(dato, null);
            nodo.setSiguiente(cabecera);
            cabecera = nodo;
            tamanio++;
        }
    }

    public void insertarPosicion(E dato, Integer pos) throws PosicionNoEncontradaException {
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < tamanio) {
            if (pos == 0) {
                insertar(dato);
            } else {
                NodoLista<E> nodo = new NodoLista<>(dato, null);
                NodoLista<E> aux = cabecera;
                for (int i = 0; i < (pos - 1); i++) {
                    aux = aux.getSiguiente();
                }
                NodoLista<E> siguiente = aux.getSiguiente();
                aux.setSiguiente(nodo);
                nodo.setSiguiente(siguiente);
                tamanio++;
            }
            //}else if(pos == tamanio){
            //insertar(dato);
        } else {
            throw new PosicionNoEncontradaException();
        }
    }

    public void modificarPosicion(E dato, Integer pos) throws PosicionNoEncontradaException {
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size) {
            if (pos == 0) {
                cabecera.setDato(dato);
            } else {

                NodoLista<E> aux = cabecera;

                for (int i = 0; i < pos; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setDato(dato);
            }

        } else {
            throw new PosicionNoEncontradaException();
        }
    }

    public E eliminar(Integer pos) throws ListaVaciaException, PosicionNoEncontradaException {
        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                    cabecera = cabecera.getSiguiente();
                    size--;

                } else {
                    NodoLista<E> aux = cabecera;

                    for (int i = 0; i < pos - 1; i++) {
                        aux = aux.getSiguiente();
                    }

                    dato = aux.getDato();
                    NodoLista<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    size--;
                }

            } else {
                throw new PosicionNoEncontradaException();
            }
            return dato;
        } else {
            throw new ListaVaciaException();
        }

    }

    public E obtener(Integer pos) throws ListaVaciaException, PosicionNoEncontradaException {

        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < tamanio) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }
            } else {
                throw new PosicionNoEncontradaException();
            }
            return dato;
        } else {
            throw new ListaVaciaException();
        }

        //return dato;
    }

    public E eliminarPosicion(Integer pos) throws ListaVaciaException, PosicionNoEncontradaException {
        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < tamanio) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                    cabecera = cabecera.getSiguiente();
                    this.tamanio--;
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                    NodoLista<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    tamanio--;
                }
            } else {
                throw new PosicionNoEncontradaException();
            }
            return dato;
        } else {
            throw new ListaVaciaException();
        }
    }

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public Integer getTamanio() {
        //this.tamanio = tamanio();
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    public Integer size() {

        return size;
    }

    public Integer getSize() {
        return size();
    }

    public E[] toArray() {
        //Class<E> clazz=(Class<E>) ;
        E[] matriz = null;
        if (this.tamanio > 0) {
            matriz = (E[]) Array.newInstance(cabecera.getDato().getClass(), this.tamanio);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < this.tamanio; i++) {
                matriz[i] = aux.getDato();
                aux = aux.getSiguiente();
            }
        }
        return matriz;
    }

    public ListaEnlazada<E> toList(E[] array) {
        this.vaciar();
        for (int i = 0; i < array.length; i++) {
            insertar(array[i]);
        }
        return this;
    }

    public void vaciar() {
        this.cabecera = null;
        setTamanio(0);
    }

    private void intercambio(int j, Object[] matriz, Object auxJ, Object auxJ1, Integer tipoOrdenacion) {
        Class clazz = auxJ.getClass();
        Object a = matriz[j];
        Object b = matriz[j + 1];
        if (Utilidades.isNumber(clazz)) {
            if (tipoOrdenacion == DESCENDENTE) {
                if (((Number) auxJ).doubleValue() < ((Number) auxJ1).doubleValue()) {
                    matriz[j] = b;
                    matriz[j + 1] = a;
                }
            } else {
                if (((Number) auxJ).doubleValue() > ((Number) auxJ1).doubleValue()) {
                    matriz[j] = b;
                    matriz[j + 1] = a;
                }
            }
        }
        if (tipoOrdenacion == DESCENDENTE) {
            if (Utilidades.isString(clazz)) {
                if (auxJ.toString().toLowerCase().compareTo(auxJ1.toString().toLowerCase()) < 0) {
                    matriz[j] = b;
                    matriz[j + 1] = a;
                }
            }
        } else {
            if (Utilidades.isString(clazz)) {
                if (auxJ.toString().toLowerCase().compareTo(auxJ1.toString().toLowerCase()) > 0) {
                    matriz[j] = b;
                    matriz[j + 1] = a;
                }
            }
        }
    }

    private void intercambioObjeto(int j, Object[] matriz, Class clazz, Integer tipoOrdenacion, String atributo) throws IllegalArgumentException, IllegalAccessException {
        Object auxJ = matriz[j];
        Object auxJ1 = matriz[j + 1];
        Field field = Utilidades.obtenerAtributos(clazz, atributo);
        if (field == null) {

        }
        field.setAccessible(true);
        Object a = field.get(auxJ);
        Object b = field.get(auxJ1);
        intercambio(j, matriz, a, b, tipoOrdenacion);
    }

    public ListaEnlazada llenarListaConDatos(Integer cantidadDeDatos, Class tipoDeDato) {
        vaciar();
        Class clazz = tipoDeDato;

        if (Utilidades.isNumber(clazz)) {
            if (tipoDeDato.getSimpleName().equalsIgnoreCase("Float")) {
                if (this.getTamanio() < cantidadDeDatos) {
                    for (int i = 0; i < cantidadDeDatos; i++) {
                        Float random = (float) Math.random();
                        this.insertar((E) random);
                    }
                }
            }
            if (tipoDeDato.getSimpleName().equalsIgnoreCase("Integer")) {
                if (this.getTamanio() < cantidadDeDatos) {
                    for (int i = 0; i < cantidadDeDatos; i++) {
                        Integer random = (int) Math.random();
                        this.insertar((E) random);
                    }
                }
            }
        }
        if (Utilidades.isString(clazz)) {
            String serie = "AEIOUaeiouBCDFGHIJKLMN";
            String random = "";
            for (int j = 0; j < cantidadDeDatos; j++) {
                for (int i = 0; i < 8; i++) {
                    int max = 8;
                    int min = 1;
                    int rango = max - min + 1;
                    int indice = (int) (Math.random() * rango) + min;
                    char rand = serie.charAt(indice);
                    random = random + rand;
                }
                this.insertar((E) random);
                random = "";
            }
        }
        return this;
    }

    public void quicksortAscendente() {
        Object[] arreglo = this.toArray();
        arreglo = OrdenamientoquicksortAscendente(arreglo, 0, arreglo.length - 1);
        this.toList((E[]) arreglo);
    }

    public void quicksortDescendente() {
        Object[] arreglo = this.toArray();
        arreglo = OrdenamientoquicksortDescendente(arreglo, 0, arreglo.length - 1);
        this.toList((E[]) arreglo);
    }

    private Object[] OrdenamientoquicksortAscendente(Object[] arreglo, int primero, int ultimo) {
        Class clazz = null;
        int iterador1 = primero;
        int iterador2 = ultimo;
        Object pivote = arreglo[(primero + ultimo) / 2];
        if (tamanio > 0) {
            clazz = cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            if (isObject) {
            } else {
                if (Utilidades.isNumber(clazz)) {
                    while (iterador1 <= iterador2) {
                        while (((Number) arreglo[iterador1]).doubleValue() < ((Number) pivote).doubleValue()) {
                            iterador1 = iterador1 + 1;
                        }
                        while (((Number) arreglo[iterador2]).doubleValue() > ((Number) pivote).doubleValue()) {
                            iterador2 = iterador2 - 1;
                        }
                        if (iterador1 <= iterador2) {
                            Object aux = arreglo[iterador1];
                            arreglo[iterador1] = arreglo[iterador2];
                            arreglo[iterador2] = aux;
                            iterador1 = iterador1 + 1;
                            iterador2 = iterador2 - 1;
                        }
                    }
                    if (primero < iterador2) {
                        OrdenamientoquicksortAscendente(arreglo, primero, iterador2);
                    }
                    if (iterador1 < ultimo) {
                        OrdenamientoquicksortAscendente(arreglo, iterador1, ultimo);
                    }
                }
                if (Utilidades.isString(clazz)) {
                    while (iterador1 <= iterador2) {
                        while (arreglo[iterador1].toString().toLowerCase().compareTo(pivote.toString().toLowerCase()) > 0) {
                            iterador1 = iterador1 + 1;
                        }
                        while (arreglo[iterador2].toString().toLowerCase().compareTo(pivote.toString().toLowerCase()) < 0) {
                            iterador2 = iterador2 - 1;
                        }
                        if (iterador1 <= iterador2) {
                            Object aux = arreglo[iterador1];
                            arreglo[iterador1] = arreglo[iterador2];
                            arreglo[iterador2] = aux;
                            iterador1 = iterador1 + 1;
                            iterador2 = iterador2 - 1;
                        }
                    }
                    if (primero < iterador2) {
                        OrdenamientoquicksortAscendente(arreglo, primero, iterador2);
                    }
                    if (iterador1 < ultimo) {
                        OrdenamientoquicksortAscendente(arreglo, iterador1, ultimo);
                    }
                }
            }

        }
        return arreglo;
    }

    private Object[] OrdenamientoquicksortDescendente(Object[] arreglo, int primero, int ultimo) {
        Class clazz = null;
        int iterador1 = primero;
        int iterador2 = ultimo;
        Object pivote = arreglo[(primero + ultimo) / 2];
        if (tamanio > 0) {
            clazz = cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            if (isObject) {
            } else {
                if (Utilidades.isNumber(clazz)) {
                    while (iterador1 <= iterador2) {
                        while (((Number) arreglo[iterador1]).doubleValue() > ((Number) pivote).doubleValue()) {
                            iterador1 = iterador1 + 1;
                        }
                        while (((Number) arreglo[iterador2]).doubleValue() < ((Number) pivote).doubleValue()) {
                            iterador2 = iterador2 - 1;
                        }
                        if (iterador1 <= iterador2) {
                            Object aux = arreglo[iterador1];
                            arreglo[iterador1] = arreglo[iterador2];
                            arreglo[iterador2] = aux;
                            iterador1 = iterador1 + 1;
                            iterador2 = iterador2 - 1;
                        }
                    }
                    if (primero < iterador2) {
                        OrdenamientoquicksortDescendente(arreglo, primero, iterador2);
                    }
                    if (iterador1 < ultimo) {
                        OrdenamientoquicksortDescendente(arreglo, iterador1, ultimo);
                    }
                }
                if (Utilidades.isString(clazz)) {
                    while (iterador1 <= iterador2) {
                        while (arreglo[iterador1].toString().toLowerCase().compareTo(pivote.toString().toLowerCase()) < 0) {
                            iterador1 = iterador1 + 1;
                        }
                        while (arreglo[iterador2].toString().toLowerCase().compareTo(pivote.toString().toLowerCase()) > 0) {
                            iterador2 = iterador2 - 1;
                        }
                        if (iterador1 <= iterador2) {
                            Object aux = arreglo[iterador1];
                            arreglo[iterador1] = arreglo[iterador2];
                            arreglo[iterador2] = aux;
                            iterador1 = iterador1 + 1;
                            iterador2 = iterador2 - 1;
                        }
                    }
                    if (primero < iterador2) {
                        OrdenamientoquicksortDescendente(arreglo, primero, iterador2);
                    }
                    if (iterador1 < ultimo) {
                        OrdenamientoquicksortDescendente(arreglo, iterador1, ultimo);
                    }
                }
            }

        }
        return arreglo;
    }

    public void ordenamientoDeObjetos(Class clazz, Integer tipoOrdenamiento, String atributo) throws IllegalArgumentException, IllegalAccessException {
        Object[] arreglo = this.toArray();
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (Utilidades.isObject(clazz)) {
                    intercambioObjeto(j, arreglo, clazz, tipoOrdenamiento, atributo);
                }
            }
        }
        this.toList((E[]) arreglo);
    }

    public static int busquedaBinaria(ListaEnlazada<Object> elementos, int l, int r, Object x) {
        try {
            if (r >= l) {
                int mitad = l + (r - l) / 2;

                if (elementos.obtener(mitad).equals(x)) {
                    return mitad;
                }

                if (((Comparable<Object>) elementos.obtener(mitad)).compareTo(x) > 0) {
                    return busquedaBinaria(elementos, l, mitad - 1, x);
                }

                return busquedaBinaria(elementos, mitad + 1, r, x);
            }
        } catch (Exception e) {
        }

        return -1;
    }

    static Integer busquedaSecuencial(ListaEnlazada<Object> data, Object valor) {
        Integer pos = null;
        try {
            for (int i = 0; i < data.size(); i++) {
                if (valor.equals(data.obtener(i))) {
                    pos = i;
                    break;
                }
            }
        } catch (Exception e) {
        }

        return pos;
    }

    // Búsqueda combinada busqueda binaria y lineal
    public static Integer busquedaCombina(ListaEnlazada<Object> data, Object valor) {
        // Primero, intentamos la búsqueda binaria
        int resultadoBinario = busquedaBinaria(data, 0, data.size() - 1, valor);
        if (resultadoBinario != -1) {
            return resultadoBinario;
        }

        // Si no se encontró utilizando búsqueda binaria, intentamos la búsqueda lineal
        return busquedaSecuencial(data, valor);
    }

}
