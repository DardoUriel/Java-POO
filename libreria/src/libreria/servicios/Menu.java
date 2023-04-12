/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.servicios;

import java.util.InputMismatchException;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;

/**
 *
 * @author FlowUser
 */
public class Menu {

    EditorialServicio es;
    AutorServicio as;
    LibroServicio ls;

    public Menu() {
        this.es = new EditorialServicio();
        this.as = new AutorServicio();
        this.ls = new LibroServicio();
    }

    public void menu() throws Exception {
        try {
            Boolean salir = false;
            Integer id;
            do {
                System.out.println("LIBRERIA");
                System.out.println("0) crear autores,Editoriales,Libros");
                System.out.println("1) AUTORES.");
                System.out.println("2) EDITORIALES");
                System.out.println("3) LIBROS");
                System.out.println("ingresar una opcion");
                int opcion = libreria.Libreria.l.nextInt();
                switch (opcion) {
                    case 0:
                        as.crearAutores();
                        es.crearEditoriales();
                        ls.crearLibros();
                        break;
                    case 1:
                        do {
                            menuAutores();
                            System.out.print("salir al menu? s/n: ");
                            String samenu = libreria.Libreria.l.next();
                            if (samenu.equalsIgnoreCase("s")) {
                                salir = true;
                            } else {
                                salir = false;
                            }

                        } while (salir == false);
                        break;
                    case 2:
                        do {
                            menuEditoriales();
                            System.out.print("salir al menu? s/n: ");
                            String semenu = libreria.Libreria.l.next();
                            if (semenu.equalsIgnoreCase("s")) {
                                salir = true;
                            } else {
                                salir = false;
                            }

                        } while (salir == false);
                        break;
                    case 3:
                        do {
                            menuLibro();
                            System.out.print("salir al menu? s/n: ");
                            String slmenu = libreria.Libreria.l.next();
                            if (slmenu.equalsIgnoreCase("s")) {
                                salir = true;
                            } else {
                                salir = false;
                            }

                        } while (salir == false);
                        break;
                    default:
                        System.out.println("la opcion es incorrecta");

                        break;
                }

                System.out.print("salir? s/n: ");
                String s = libreria.Libreria.l.next();
                if (s.equalsIgnoreCase("s")) {
                    salir = true;
                } else {
                    salir = false;
                }
            } while (salir == false);
        } catch (InputMismatchException j){
            System.out.println("la opcion ingresada no es valida"); 
        }catch (Exception e) {
            throw e;
        } 

    }

    public void menuAutores() {
        System.out.println("OPCIONES PARA AUTORES");
        System.out.println("1) Crear ");
        System.out.println("2) Dar de baja o alta ");
        System.out.println("3) Editar ");
        System.out.println("4) Listar");
        System.out.println("5) Eliminar Autor");
        System.out.println("6) Busqueda de un Autor por nombre");
        int op = libreria.Libreria.l.nextInt();
        switch (op) {
            case 1:
                as.crearAutor();
                break;
            case 2:
                as.darAltaOBajaAutor();
                break;
            case 3:
                as.modificarAutor();
                break;
            case 4:
                as.listarAutores();
                break;
            case 5:
                as.borrarAutoresPorId();
                break;
            case 6:
                as.buscarAutorPorNombre();
                break;
            default:
                System.out.println("ingrese una opcion valida");

        }
    }

    public void menuEditoriales() {
        System.out.println("OPCIONES PARA EDITORIALES");
        System.out.println("1) Crear ");
        System.out.println("2) Dar de baja o alta ");
        System.out.println("3) Editar ");
        System.out.println("4) Listar");
        System.out.println("5) Eliminar Editorial");
        int op = libreria.Libreria.l.nextInt();
        switch (op) {
            case 1:
                es.crearEditorial();
                break;
            case 2:
                es.darAltaOBajaEditorial();
                break;
            case 3:
                es.modificarNombreEditorial();
                break;
            case 4:
                es.listarEditoriales();
                break;
            case 5:
                es.borrarEditorialesPorId();
                break;
            default:
                System.out.println("ingrese una opcion valida");
                break;

        }
    }

    public void menuLibro() {
        System.out.println("OPCIONES PARA LIBROS");
        System.out.println("1) Crear ");
        System.out.println("2) Dar de baja o alta ");
        System.out.println("3) Editar ");
        System.out.println("4) Listar");
        System.out.println("5) Eliminar Libro");
        System.out.println("6) Buscar Libro por titulo");
        System.out.println("7) Buscar libro por ISBN");
        System.out.println("8) Buscar un libro/s por nombre del autor");
        System.out.println("9) Buscar un libro/s por nombre de la editorial");
        int op = libreria.Libreria.l.nextInt();
        switch (op) {
            case 1:
                ls.crearLibro();
                break;
            case 2:
                ls.darAltaOBaja();
                break;
            case 3:
                ls.editarLibro();
                break;
            case 4: 
                ls.listarLibros();
                break;
            case 5:
                ls.eliminarLibro();
                break;
            case 6:
                ls.buscarLibroPorTitulo();
                break;
            case 7: 
                ls.buscarLibroPorISBN();
                break;
            case 8:
                ls.buscarLibroPorAutor();
                break;
            case 9:
                ls.buscarLibroPorEditorial();
                break;
            default:
                System.out.println("opcion no valida");
        }

    }
}
