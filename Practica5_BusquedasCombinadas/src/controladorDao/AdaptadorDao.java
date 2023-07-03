/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorDao;

import com.thoughtworks.xstream.io.StreamException;
import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import controlador.listas.ListaEnlazada;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author Marylin
 */
public class AdaptadorDao<T> implements InterfazDao<T> {

    private Conexion conexion;
    private Class clazz;
    private String url;
    public static Integer ASCENDENTE = 0;
    public static Integer DESCENDENTE = 1;

    public AdaptadorDao(Class clazz) {
        this.conexion = new Conexion();
        this.clazz = clazz;
        this.url = Conexion.URL + clazz.getSimpleName().toLowerCase() + ".json";
    }

    @Override
    public void guardar(T obj) throws IOException {
        ListaEnlazada<T> lista = listar();
        lista.insertar(obj);
        conexion.getXstream().alias(lista.getClass().getName(), ListaEnlazada.class);
        conexion.getXstream().toXML(lista, new FileWriter(url));
    }

    @Override
    public void modificar(T obj, Integer pos) throws ListaVaciaException, PosicionNoEncontradaException, IOException {
        ListaEnlazada<T> lista = listar();
        lista.update(pos, obj);
//        lista.update(obj, pos);
        conexion.getXstream().alias(lista.getClass().getName(), ListaEnlazada.class);
        conexion.getXstream().toXML(lista, new FileWriter(url));
    }

    @Override
    public ListaEnlazada<T> listar() {
        ListaEnlazada<T> lista = new ListaEnlazada<>();
        try {
            //ListaEnlazada<T> lista = (ListaEnlazada<T>)conexion.getXstream().fromXML(new FileReader(url));
            lista = (ListaEnlazada<T>) conexion.getXstream().fromXML(new File(url));
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }

    @Override
    public T obtener(Integer id) {
        T obj = null;
        ListaEnlazada<T> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            try {
                T dato = lista.obtener(i);
                if (id.intValue() == ((Integer) getValueField(dato)).intValue()) {
                    obj = dato;
                }
            } catch (Exception e) {
                System.out.println("Error en metodo " + e);
            }
        }
        return obj;
    }

    public Integer generarId() {
        return listar().size() + 1;
    }

    private Object getValueField(T dato) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method metodo = null;
        for (Method aux : this.clazz.getDeclaredMethods()) {
            if (aux.getName().toLowerCase().equalsIgnoreCase("getId")) {
                metodo = aux;
            }
        }

        if (metodo == null) {
            for (Method aux : this.clazz.getSuperclass().getDeclaredMethods()) {
                if (aux.getName().toLowerCase().equalsIgnoreCase("getId")) {
                    metodo = aux;
                }
            }
        }
        return metodo.invoke(dato);
    }
}
