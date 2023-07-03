/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.utilidades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import controlador.listas.ListaEnlazada;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Libro;
import modelo.enums.EnumBusqueda;
import modelo.enums.EnumOrdenacion;
import modelo.enums.EnumTipoLibro;

/**
 *
 * @author Marylin
 */
public class utilidades {

    /**
     * Metodo para cargar las busquedas que se encuentran dentro de un enum en
     * un JComboBox
     *
     * @param cbx
     * @return
     */
    public static JComboBox cargarComboBusqueda(JComboBox combo) {
        combo.removeAllItems();
        for (EnumBusqueda Metodo : EnumBusqueda.values()) {
            combo.addItem(Metodo);
        }
        return combo;
    }
    
        /**
     * Metodo para cargar ordenamiento que se encuentran dentro de un enum en
     * un JComboBox
     *
     * @param cbx
     * @return
     */
    public static JComboBox cargarComboQuickSort(JComboBox combo) {
        combo.removeAllItems();
        for (EnumOrdenacion Metodo : EnumOrdenacion.values()) {
            combo.addItem(Metodo);
        }
        return combo;
    }

    /**
     * Metodo para cargar las caracteristicas de libro que se encuentran dentro
     * de un enum en un JComboBox
     *
     * @param cbx
     * @return
     */
    public static JComboBox cargarComboCaracteristica(JComboBox combo) {
        combo.removeAllItems();
        for (EnumTipoLibro Metodo : EnumTipoLibro.values()) {
            combo.addItem(Metodo);
        }
        return combo;
    }

    /**
     * Metodo para permitir solo mun txt
     *
     * @param txt
     */
    public static void permitirSoloNumTxt(JTextField txt) {
        txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

    /**
     * Metodo para limitar el tamaño de txt
     *
     * @param txt
     * @param tamanio
     */
    public static void limitarTamanioTxt(JTextField txt, Integer tamanio) {
        txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (txt.getText().length() >= tamanio) {
                    e.consume();
                    JOptionPane.showMessageDialog(txt, "Solo se permiten " + tamanio + " caracteres");
                }
            }
        });
    }

    /**
     * Metodo para guardar un tipo de dato Libro dentro de un archivo JSON
     *
     * @param asignatura
     */
    public static void guardarLibro(Libro libro) {
        ListaEnlazada<Libro> lista = listarLibro();
        lista.insertar(libro);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try (PrintWriter pw = new PrintWriter(new File("libro.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }

    /**
     * Metodo para modificar un tipo de dato libro dentro de un archivo JSON
     *
     * @param docente
     * @param posicion
     * @throws PosicionNoEncontradaException
     */
    public static void modificarLibro(Libro libro, Integer posicion) throws PosicionNoEncontradaException {
        ListaEnlazada<Libro> lista = listarLibro();
        lista.modificarPosicion(libro, posicion);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try (PrintWriter pw = new PrintWriter(new File("modificadolibro.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }

    public static ListaEnlazada<Libro> listarLibro() {
        ListaEnlazada<Libro> lista = new ListaEnlazada<>();
        String json = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("libros.json"));
            String linea;
            while ((linea = br.readLine()) != null) {
                json += linea;
            }
            br.close();
//            Persona[] arrayLista = new Gson().fromJson(json, Persona[].class);
            Type tipoLista = new TypeToken<ListaEnlazada<Libro>>() {
            }.getType();
//            System.out.println("Tipolist " + tipoLista);
//            List a = stringToArray(json, Persona[].class);
            lista = new Gson().fromJson(json, tipoLista);

        } catch (Exception e) {
            System.out.println("Error en utilidades del metodo listar: " + e);
        }
        return lista;
    }
    
    /**
     * Eliinar Asignatura
     */
    public static void eliminarLibro(Integer posicion) throws PosicionNoEncontradaException, ListaVaciaException {
        ListaEnlazada<Libro> lista = listarLibro();
        lista.eliminar(posicion);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try (PrintWriter pw = new PrintWriter(new File("asignaturas.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }

}
