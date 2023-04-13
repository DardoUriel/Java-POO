/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.servicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

import libreria.persistencia.LibroDAO;

/**
 *
 * @author FlowUser
 */
public class LibroServicio {

    LibroDAO dao = new LibroDAO();
    ArrayList<Long> listaISBN = new ArrayList<>();
    AutorServicio as = new AutorServicio();
    EditorialServicio es = new EditorialServicio();

    public LibroServicio() {
    }

    public void crearLibros() throws Exception {
        try {
            Libro libro1 = new Libro();
            libro1.setIsbn(crearISBN());
            libro1.setTitulo("El Quijote");
            libro1.setAnio(1605);
            libro1.setAlta(true);
            libro1.setEjemplares(1);
            libro1.setEjemplaresPrestados(0);
            libro1.setEjemplaresRestantes(1);
            Editorial editorial1 = dao.buscarEditorialPorId(1);
            libro1.setEditorial(editorial1);
            Autor autor1 = dao.buscarAutorPorId(1);
            libro1.setAutor(autor1);

            dao.guardar(libro1);

            Libro libro2 = new Libro();
            libro2.setIsbn(crearISBN());
            libro2.setTitulo("Muerte en el Nilo");
            libro2.setAnio(1937);
            libro2.setAlta(true);
            libro2.setEjemplares(1);
            libro2.setEjemplaresPrestados(0);
            libro2.setEjemplaresRestantes(1);
            Editorial editorial2 = dao.buscarEditorialPorId(2);
            libro2.setEditorial(editorial2);
            Autor autor2 = dao.buscarAutorPorId(2);
            libro2.setAutor(autor2);

            dao.guardar(libro2);

            Libro libro3 = new Libro();
            libro3.setIsbn(crearISBN());
            libro3.setTitulo("Cuento de Navidad");
            libro3.setAnio(1999);
            libro3.setAlta(true);
            libro3.setEjemplares(1);
            libro3.setEjemplaresPrestados(0);
            libro3.setEjemplaresRestantes(1);
            Editorial editorial3 = dao.buscarEditorialPorId(3);
            libro3.setEditorial(editorial3);
            Autor autor3 = dao.buscarAutorPorId(3);
            libro3.setAutor(autor3);

            dao.guardar(libro3);

            Libro libro4 = new Libro();
            libro4.setIsbn(crearISBN());
            libro4.setTitulo("Los miserables");
            libro4.setAnio(1862);
            libro4.setAlta(true);
            libro4.setEjemplares(1);
            libro4.setEjemplaresPrestados(0);
            libro4.setEjemplaresRestantes(1);
            Editorial editorial4 = dao.buscarEditorialPorId(4);
            libro4.setEditorial(editorial4);
            Autor autor4 = dao.buscarAutorPorId(4);
            libro4.setAutor(autor4);

            dao.guardar(libro4);

        } catch (Exception e) {
            throw e;
        }
    }

    public void crearLibro() {
        Libro libro = new Libro();
        libro.setIsbn(crearISBN());
        System.out.print("Titulo del Libro: ");
        libro.setTitulo(libreria.Libreria.l.next());
        System.out.println("Año de lanzamiento:");
        libro.setAnio(libreria.Libreria.l.nextInt());
        libro.setAlta(true);
        libro.setEjemplares(1);
        libro.setEjemplaresPrestados(0);
        libro.setEjemplaresRestantes(1);
        System.out.println("SELECCIONAR AUTOR");
        as.listarAutores();
        libro.setAutor(as.buscarAutorPorId(libreria.Libreria.l.nextInt()));
        System.out.println("SELECCIONAR EDITORIAL");
        es.listarEditoriales();
        libro.setEditorial(es.buscarPorId(libreria.Libreria.l.nextInt()));
        Libro libroValidacion = dao.libroRepetido(libro.getTitulo());
        if (libro.getTitulo().equalsIgnoreCase(libroValidacion.getTitulo())) {
            System.out.println("ya existe un libro con el titulo "+ libro.getTitulo());
        }else{
             dao.guardar(libro);
             System.out.println( libro.getTitulo()+ " guardado");
        }
        

    }

    public void listarLibros() {
        Collection<Libro> libros = dao.listar();
        System.out.println("LIBROS ACTUALES");
        for (Libro l : libros) {
            System.out.println(l.toString());
            System.out.println("");
        }
    }

    public long crearISBN() {
        boolean repetido = true;
        long isbn = 0;
        do {
            if (listaISBN.isEmpty()) {
                isbn = (long) (Math.random() * 10000000);
                listaISBN.add(isbn);
                repetido = true;
            } else {
                isbn = (long) (Math.random() * 10000000);
                for (int i = 0; i < listaISBN.size(); i++) {
                    if (listaISBN.get(i) == isbn) {
                        repetido = false;
                        break;
                    }
                }
                if (repetido == false) {
                    break;
                } else {
                    listaISBN.add(isbn);
                    repetido = true;
                }
            }

        } while (repetido == false);

        return isbn;
    }

    public void darAltaOBaja() {
        Libro libroBOA = new Libro();
        listarLibros();
        System.out.println("id Libro:");
        Integer id = libreria.Libreria.l.nextInt();
        System.out.println("Indicar cambio a) dar de alta b) dar de baja");
        String cambio = libreria.Libreria.l.next();
        switch (cambio.toLowerCase()) {
            case "a":
                libroBOA = dao.altaOBaja(id, true);
                break;
            case "b":
                libroBOA = dao.altaOBaja(id, false);
                break;
            default:
                System.out.println("la opcion ingresada no es valida");

        }
        System.out.println("Libro modificada a : " + libroBOA.toString());
    }

    public void editarLibro() {
        listarLibros();
        System.out.print("Id del Libro :");
        Integer id = libreria.Libreria.l.nextInt();
        Libro libro = dao.buscarPorId(id);
        System.out.print("Nuevo Titulo del Libro: ");
        libro.setTitulo(libreria.Libreria.l.next());
        System.out.println("Año de lanzamiento:");
        libro.setAnio(libreria.Libreria.l.nextInt());
        System.out.println("SELECCIONAR AUTOR");
        as.listarAutores();
        libro.setAutor(as.buscarAutorPorId(libreria.Libreria.l.nextInt()));
        System.out.println("SELECCIONAR EDITORIAL");
        es.listarEditoriales();
        libro.setEditorial(es.buscarPorId(libreria.Libreria.l.nextInt()));
        dao.editar(libro);
        System.out.println("Libro modificado a :" + dao.buscarPorId(id));
    }

    public void eliminarLibro() {
        listarLibros();
        System.out.println("Id del Libro :");
        Integer id = libreria.Libreria.l.nextInt();
        dao.eliminar(dao.buscarPorId(id));
    }

    public void buscarLibroPorTitulo() {
        boolean salir = false;
        Collection<Libro> librosEncontrados = new ArrayList();
        String titulo;
        do {

            System.out.print("Titulo del Libro :");
            titulo = libreria.Libreria.l.next();
            if (titulo.isEmpty()) {
                System.out.println("debe ingresar un nombre ");
            } else if (dao.esNumerico(titulo) == true) {
                System.out.println("no se puede ingresar numeros o simbolos");
            } else if (dao.buscarLibroPorTitulo(titulo).isEmpty()) {
                System.out.println("el nombre ingresado no se encuentra en la lista de Autores registrados");
            } else {
                librosEncontrados = dao.buscarLibroPorTitulo(titulo);
                salir = true;
            }
        } while (salir == false);
        System.out.println("Libros encontrados con el titulo " + titulo);
        for (Libro libros : librosEncontrados) {
            System.out.println(libros.toString());
        }
    }

    public void buscarLibroPorISBN() {/* despues como mejora el isbn no se genera 
        con un random de 4 dig y se ingresa y para validar q se ingrese correcto se le cuentan los caracteres*/
        try {
            boolean salir = false;
            Collection<Libro> librosEncontrados = new ArrayList();
            System.out.print("ISBN del Libro:");
            Integer isbn = libreria.Libreria.l.nextInt();/*java.util.InputMismatchException*/

            do {

                if (dao.buscarPorISBN(isbn).isEmpty()) {
                    System.out.println("no se encontraron libros con el isbn " + isbn);
                    System.out.print("ISBN del Libro:");
                    isbn = libreria.Libreria.l.nextInt();
                } else {

                    librosEncontrados = dao.buscarPorISBN(isbn);
                    salir = true;
                }
            } while (salir == false);
            System.out.println("libros encontrados con el isbn " + isbn);
            for (Libro libros : librosEncontrados) {
                System.out.println(libros.toString());
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("el valor ingresado es invalido");
        }
    }
    public void buscarLibroPorEditorial(){
        Collection<Libro> librosEncontrados = new ArrayList();
        boolean salir = false;
        String editorial;
        do{
        es.listarEditoriales();
        System.out.println("Editorial del Libro :");
        editorial = libreria.Libreria.l.next();
        if (editorial.isEmpty()) {
            System.out.println("debe ingresar una editorial");
        }else if(dao.esNumerico(editorial) == true){
            System.out.println("no se puede ingresar numeros o simbolos");
        }else if (dao.buscarPorEditorial(editorial).isEmpty()){
            System.out.println("no se encontraron libros con la editorial "+ editorial);
        }else{
          librosEncontrados =  dao.buscarPorEditorial(editorial);
          salir =true;
        }
        }while(salir == false);
        
        System.out.println("libros encontrados con la editorial "+ editorial);
        for (Libro libro : librosEncontrados) {
            System.out.println(libro.toString());
        }
    }
     public void buscarLibroPorAutor(){
        Collection<Libro> librosEncontrados = new ArrayList();
        boolean salir = false;
        String autor;
        do{
        as.listarAutores();
        System.out.println("Autor del Libro :");
        autor = libreria.Libreria.l.next();
        if (autor.isEmpty()) {
            System.out.println("debe ingresar un autor");
        }else if(dao.esNumerico(autor) == true){
            System.out.println("no se puede ingresar numeros o simbolos");
        }else if (dao.buscarPorAutor(autor).isEmpty()){
            System.out.println("no se encontraron libros con el autor "+ autor);
        }else{
          librosEncontrados =  dao.buscarPorAutor(autor);
          salir =true;
        }
        }while(salir == false);
        
        System.out.println("libros encontrados con el autor "+ autor);
        for (Libro libro : librosEncontrados) {
            System.out.println(libro.toString());
        }
    }
}
/*
El Quijote 
Muerte en el Nilo
Cuento de Navidad
Los miserables
 */
