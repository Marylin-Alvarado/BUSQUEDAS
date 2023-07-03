/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorDao;

import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import controlador.listas.ListaEnlazada;
import java.io.IOException;
import modelo.Libro;

/**
 *
 * @author Marylin
 */
public class LibroDao extends AdaptadorDao {

//    private Libro libro;
//
//    public LibroDao() {
//        super(Libro.class);
//    }
//
//    public Libro getLibro() {
//        if (libro == null){
//            libro = new Libro();
//        }
//        return libro;
//    }
//
//    public void setPersona(Libro libro) {
//        this.libro = libro;
//    }
//
//    public boolean guardar() throws Exception {
//        this.libro.setId(generarId());
//        guardar(this.libro);
//        return true;
//    }
//
//    public boolean modificar(Integer pos) throws Exception {
//        modificar(this.libro, pos);
//        return true;
//    }
//    
//    
////    public boolean modificar(E dato, Integer pos) throws Exception{
////        try {
////            lista.modificarDato(pos, dato);
////            return true;
////        } catch (Exception e) {
////            System.out.println(e);
////        }
////        return false;
////    }
//    
//    private Integer generarId(){
//        return 0;
//    }
    private Libro libro;

    public LibroDao() {
        super(Libro.class);
    }

    public Libro getLibro() {
        if (this.libro == null) {
            this.libro = new Libro();
        }
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void guardar() throws IOException {
        libro.setId(generateID());
        this.guardar(libro);
    }

    public void modificar(Integer pos) throws ListaVaciaException, PosicionNoEncontradaException, IOException {
        this.modificar(libro, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }

    public ListaEnlazada<Libro> buscar(String dato) throws ListaVaciaException, PosicionNoEncontradaException {
        ListaEnlazada<Libro> lista = listar();
        try {

            quicksortNombre(lista, 0, lista.size() - 1);

            System.out.println("JUMAAAA");

        } catch (Exception e) {
        }
//        return search(lista, dato);
        return binarySearchNombre(lista,dato);

    }

    /**
     * Metodo Quicksort de nombre libro
     *
     * @param lista
     * @param izquierda
     * @param derecha
     * @return
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException
     */
    public ListaEnlazada<Libro> quicksortNombre(ListaEnlazada<Libro> lista, int izquierda, int derecha) throws ListaVaciaException, PosicionNoEncontradaException {
        
        if (izquierda < derecha) {
            int indicePivote = particionNombres(lista, izquierda, derecha);
            quicksortNombre(lista, izquierda, indicePivote - 1);
            quicksortNombre(lista, indicePivote + 1, derecha);
        }
        return lista;
    }

    private int particionNombres(ListaEnlazada<Libro> lista, int izquierda, int derecha) throws ListaVaciaException, PosicionNoEncontradaException {
        Libro pivote = lista.obtener(derecha);
        int indicePivote = izquierda;

        for (int i = izquierda; i < derecha; i++) {
            if (lista.obtener(i).getNombre_libro().compareToIgnoreCase(pivote.getNombre_libro()) < 0) {

                Libro temp = lista.obtener(indicePivote);
                lista.modificar(lista.obtener(i), indicePivote);
                lista.modificar(temp, i);
                indicePivote++;
            }
        }

        Libro temp = lista.obtener(indicePivote);
        lista.modificar(lista.obtener(derecha), indicePivote);
        lista.modificar(temp, derecha);

        return indicePivote;
    }

    /**
     * Metodo Quicksort para editorial
     *
     * @param lista
     * @param izquierda
     * @param derecha
     * @return
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException
     */
    public ListaEnlazada<Libro> quicksortEditorial(ListaEnlazada<Libro> lista, int izquierda, int derecha) throws ListaVaciaException, PosicionNoEncontradaException {
        if (izquierda < derecha) {
            int indicePivote = particionNombres(lista, izquierda, derecha);
            quicksortNombre(lista, izquierda, indicePivote - 1);
            quicksortNombre(lista, indicePivote + 1, derecha);
        }
        return lista;
    }

    private int particionEditoriales(ListaEnlazada<Libro> lista, int izquierda, int derecha) throws ListaVaciaException, PosicionNoEncontradaException {
        Libro pivote = lista.obtener(derecha);
        int indicePivote = izquierda;

        for (int i = izquierda; i < derecha; i++) {
            if (lista.obtener(i).getEditorial().compareToIgnoreCase(pivote.getEditorial()) < 0) {

                Libro temp = lista.obtener(indicePivote);
                lista.modificar(lista.obtener(i), indicePivote);
                lista.modificar(temp, i);
                indicePivote++;
            }
        }

        Libro temp = lista.obtener(indicePivote);
        lista.modificar(lista.obtener(derecha), indicePivote);
        lista.modificar(temp, derecha);

        return indicePivote;
    }

    /**
     * Metodo Quicksort para Autor
     *
     * @param lista
     * @param izquierda
     * @param derecha
     * @return
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException
     */
    public ListaEnlazada<Libro> quicksortAutor(ListaEnlazada<Libro> lista, int izquierda, int derecha) throws ListaVaciaException, PosicionNoEncontradaException {
        if (izquierda < derecha) {
            int indicePivote = particionNombres(lista, izquierda, derecha);
            quicksortNombre(lista, izquierda, indicePivote - 1);
            quicksortNombre(lista, indicePivote + 1, derecha);
        }
        return lista;
    }

    private int particionAutores(ListaEnlazada<Libro> lista, int izquierda, int derecha) throws ListaVaciaException, PosicionNoEncontradaException {
        Libro pivote = lista.obtener(derecha);
        int indicePivote = izquierda;

        for (int i = izquierda; i < derecha; i++) {
            if (lista.obtener(i).getAutor().compareToIgnoreCase(pivote.getAutor()) < 0) {

                Libro temp = lista.obtener(indicePivote);
                lista.modificar(lista.obtener(i), indicePivote);
                lista.modificar(temp, i);
                indicePivote++;
            }
        }

        Libro temp = lista.obtener(indicePivote);
        lista.modificar(lista.obtener(derecha), indicePivote);
        lista.modificar(temp, derecha);

        return indicePivote;
    }

    /**
     * Metodo Quicksort para Tipo
     *
     * @param lista
     * @param izquierda
     * @param derecha
     * @return
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException
     */
    public ListaEnlazada<Libro> quicksortTipo(ListaEnlazada<Libro> lista, int izquierda, int derecha) throws ListaVaciaException, PosicionNoEncontradaException {
        if (izquierda < derecha) {
            int indicePivote = particionNombres(lista, izquierda, derecha);
            quicksortNombre(lista, izquierda, indicePivote - 1);
            quicksortNombre(lista, indicePivote + 1, derecha);
        }
        return lista;
    }

    private int particionTipos(ListaEnlazada<Libro> lista, int izquierda, int derecha) throws ListaVaciaException, PosicionNoEncontradaException {
        Libro pivote = lista.obtener(derecha);
        int indicePivote = izquierda;

        for (int i = izquierda; i < derecha; i++) {
            if (lista.obtener(i).getTipo().compareToIgnoreCase(pivote.getTipo()) < 0) {

                Libro temp = lista.obtener(indicePivote);
                lista.modificar(lista.obtener(i), indicePivote);
                lista.modificar(temp, i);
                indicePivote++;
            }
        }

        Libro temp = lista.obtener(indicePivote);
        lista.modificar(lista.obtener(derecha), indicePivote);
        lista.modificar(temp, derecha);

        return indicePivote;
    }

    public ListaEnlazada<Libro> binarySearchNombre(ListaEnlazada<Libro> lista, String target) {

        Libro[] arr = lista.toArray();
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].getNombre_libro().equals(target)) {
                ListaEnlazada<Libro> resultado = new ListaEnlazada<>();
                resultado.insertar(arr[mid]);
                return resultado;
            } else if (arr[mid].getNombre_libro().compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return lista; // Si el elemento no se encuentra en la lista
    }

    public ListaEnlazada<Libro> BusquedabinaryAutor(ListaEnlazada<Libro> lista, String target) {

        Libro[] arr = lista.toArray();
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].getAutor().equals(target)) {
                ListaEnlazada<Libro> resultado = new ListaEnlazada<>();
                resultado.insertar(arr[mid]);
                return resultado;
            } else if (arr[mid].getAutor().compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return lista; // Si el elemento no se encuentra en la lista
    }

    public ListaEnlazada<Libro> BusquedabinaryEditorial(ListaEnlazada<Libro> lista, String target) {

        Libro[] arr = lista.toArray();
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].getEditorial().equals(target)) {
                ListaEnlazada<Libro> resultado = new ListaEnlazada<>();
                resultado.insertar(arr[mid]);
                return resultado;
            } else if (arr[mid].getEditorial().compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return lista; // Si el elemento no se encuentra en la lista
    }

    public ListaEnlazada<Libro> BusquedabinaryTipo(ListaEnlazada<Libro> lista, String target) {

        Libro[] arr = lista.toArray();
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].getTipo().equals(target)) {
                ListaEnlazada<Libro> resultado = new ListaEnlazada<>();
                resultado.insertar(arr[mid]);
                return resultado;
            } else if (arr[mid].getTipo().compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return lista; // Si el elemento no se encuentra en la lista
    }

//    public ListaEnlazada<Libro> busquedaSecuencial(ListaEnlazada<Libro> lista, String target) {
//        Libro[] arr = lista.toArray();
//        int n = arr.length;
//
//        for (int i = 0; i < n; i++) {
//            if (arr[i].getNombre_libro().equals(target)) {
//                ListaEnlazada<Libro> resultado = new ListaEnlazada<>();
//                resultado.insertar(arr[i]);
//                return resultado;
//            } else if (arr[i].getNombre_libro().compareTo(target) > 0) {
//                // Si el elemento actual es mayor que el objetivo, significa que el objetivo no está en la lista
//                break;
//            }
//        }
//
//        return lista; // El elemento no se encuentra en la lista
//    }
    /**}
     * Metodo Lineal
     * @param lista
     * @param target
     * @return 
     */
    public ListaEnlazada<Libro> search(ListaEnlazada<Libro> lista, String target) {
        Libro[] arr = lista.toArray();
        ListaEnlazada<Libro> resultado = new ListaEnlazada<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getNombre_libro().equals(target)) {
                resultado.insertar(arr[i]);
            }
        }
        return resultado;
    }

    public ListaEnlazada<Libro> searchBinarySecuencialNombre(ListaEnlazada<Libro> lista, String target) {
        Libro[] arr = lista.toArray();
        ListaEnlazada<Libro> resultado = new ListaEnlazada<>();

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].getNombre_libro().equals(target)) {
                resultado.insertar(arr[mid]);

                // Buscar hacia la izquierda y agregar coincidencias adicionales
                int left = mid - 1;
                while (left >= 0 && arr[left].getNombre_libro().equals(target)) {
                    resultado.insertar(arr[left]);
                    left--;
                }

                // Buscar hacia la derecha y agregar coincidencias adicionales
                int right = mid + 1;
                while (right < arr.length && arr[right].getNombre_libro().equals(target)) {
                    resultado.insertar(arr[right]);
                    right++;
                }

                return resultado;
            } else if (arr[mid].getNombre_libro().compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return resultado; // Si el elemento no se encuentra en la lista
    }

    public ListaEnlazada<Libro> searchBinarySecuencialTipo(ListaEnlazada<Libro> lista, String target) {
        Libro[] arr = lista.toArray();
        ListaEnlazada<Libro> resultado = new ListaEnlazada<>();

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].getTipo().equals(target)) {
                resultado.insertar(arr[mid]);

                // Buscar hacia la izquierda y agregar coincidencias adicionales
                int left = mid - 1;
                while (left >= 0 && arr[left].getTipo().equals(target)) {
                    resultado.insertar(arr[left]);
                    left--;
                }

                // Buscar hacia la derecha y agregar coincidencias adicionales
                int right = mid + 1;
                while (right < arr.length && arr[right].getTipo().equals(target)) {
                    resultado.insertar(arr[right]);
                    right++;
                }

                return resultado;
            } else if (arr[mid].getTipo().compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return resultado; // Si el elemento no se encuentra en la lista
    }

    public ListaEnlazada<Libro> searchBinarySecuencialAutor(ListaEnlazada<Libro> lista, String target) {
        Libro[] arr = lista.toArray();
        ListaEnlazada<Libro> resultado = new ListaEnlazada<>();

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].getAutor().equals(target)) {
                resultado.insertar(arr[mid]);

                // Buscar hacia la izquierda y agregar coincidencias adicionales
                int left = mid - 1;
                while (left >= 0 && arr[left].getAutor().equals(target)) {
                    resultado.insertar(arr[left]);
                    left--;
                }

                // Buscar hacia la derecha y agregar coincidencias adicionales
                int right = mid + 1;
                while (right < arr.length && arr[right].getAutor().equals(target)) {
                    resultado.insertar(arr[right]);
                    right++;
                }

                return resultado;
            } else if (arr[mid].getAutor().compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return resultado; // Si el elemento no se encuentra en la lista
    }

    public ListaEnlazada<Libro> searchBinarySecuencialEditorial(ListaEnlazada<Libro> lista, String target) {
        Libro[] arr = lista.toArray();
        ListaEnlazada<Libro> resultado = new ListaEnlazada<>();

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].getEditorial().equals(target)) {
                resultado.insertar(arr[mid]);

                // Buscar hacia la izquierda y agregar coincidencias adicionales
                int left = mid - 1;
                while (left >= 0 && arr[left].getEditorial().equals(target)) {
                    resultado.insertar(arr[left]);
                    left--;
                }

                // Buscar hacia la derecha y agregar coincidencias adicionales
                int right = mid + 1;
                while (right < arr.length && arr[right].getEditorial().equals(target)) {
                    resultado.insertar(arr[right]);
                    right++;
                }

                return resultado;
            } else if (arr[mid].getEditorial().compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return resultado; // Si el elemento no se encuentra en la lista
    }

}
