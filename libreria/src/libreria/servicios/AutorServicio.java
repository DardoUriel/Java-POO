/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.servicios;

import java.util.ArrayList;
import java.util.Collection;
import libreria.Libreria;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

/**
 *
 * @author FlowUser
 */
public class AutorServicio {

    private final AutorDAO dao;

    public AutorServicio() {
        this.dao = new AutorDAO();
    }

    public void crearAutores() throws Exception {

        try {

            Autor autor1 = new Autor();
            autor1.setNombre("Miguel de Cervantes");
            autor1.setAlta(true);

            dao.guardar(autor1);

            Autor autor2 = new Autor();
            autor2.setNombre("Agatha Chistie");
            autor2.setAlta(true);

            dao.guardar(autor2);
            Autor autor3 = new Autor();
            autor3.setNombre("Charles Dickens");
            autor3.setAlta(true);

            dao.guardar(autor3);
            Autor autor4 = new Autor();
            autor4.setNombre("Federico García Lorca");
            autor4.setAlta(true);

            dao.guardar(autor4);
        } catch (Exception e) {
            throw e;
        }

    }

    public void crearAutor() {
        Autor autor = new Autor();
        System.out.println("Nombre del Autor: ");
        autor.setNombre(Libreria.l.next());
        autor.setAlta(true);
        Autor autorvalidacion = dao.repetirAutor(autor.getNombre());
        if (autor.getNombre().equalsIgnoreCase(autorvalidacion.getNombre())) {
            System.out.println("el autor con nombre "+ autor.getNombre()+" ya existe");
        } else {
           dao.guardar(autor); 
         System.out.println("Autor creado: " + autor);
        }
        

    }

    public void listarAutores() {
        System.out.println("AUTORES ACTUALES");
        Collection<Autor> autores = dao.listar();
        for (Autor autore : autores) {
            System.out.println(autore.toString());
        }
    }

    public Autor buscarAutorPorId(Integer id) {

        Autor autor = dao.buscarPorId(id);
        return autor;
    }

    public void darAltaOBajaAutor() {
        Autor autorBOA = new Autor();
        listarAutores();
        System.out.println("id Autor:");
        Integer id = libreria.Libreria.l.nextInt();
        System.out.println("Indicar cambio a) dar de alta b) dar de baja");
        String cambio = libreria.Libreria.l.next();
        switch (cambio.toLowerCase()) {
            case "a":
                autorBOA = dao.bajaOAlta(id, true);
                break;
            case "b":
                autorBOA = dao.bajaOAlta(id, false);
                break;
            default:
                System.out.println("la opcion ingresada no es valida");

        }
        System.out.println("Autor modificado a : " + autorBOA.toString());

    }

    public void modificarAutor() {
        Autor autorM = new Autor();
        listarAutores();
        System.out.println("Id Autor :");
        Integer id = libreria.Libreria.l.nextInt();
        System.out.print("Nuevo nombre del Autor: ");
        String nombre = libreria.Libreria.l.next();
        autorM = dao.modificarNombre(id, nombre);
        System.out.println("Autor modificado a : " + autorM);
    }

    public void borrarAutoresPorId() {
        listarAutores();
        System.out.println("Id Autor: ");
        Integer id = libreria.Libreria.l.nextInt();
        Autor autor = dao.buscarPorId(id);
        dao.eliminar(autor);
        System.out.println("Autor " + autor.toString() + " eliminado");
    }

    public void buscarAutorPorNombre() {
        boolean salir = false;
        Collection<Autor> autoresEncontrados = new ArrayList();
        String nombre;
        do {

            System.out.print("Nombre del Autor :");
            nombre = libreria.Libreria.l.next();
            if (nombre.isEmpty()) {
                System.out.println("debe ingresar un nombre ");
            } else if (dao.esNumerico(nombre) == true) {
                System.out.println("no se puede ingresar numeros o simbolos");
            }else if(dao.buscarPorNombre(nombre).isEmpty()){
                System.out.println("el nombre ingresado no se encuentra en la lista de Autores registrados");
            }else{
             autoresEncontrados = dao.buscarPorNombre(nombre);                        
             salir= true;
            }
        } while (salir == false);
        System.out.println("Autores encontrados con el nombre "+ nombre);
        for (Autor autoresEncontrado : autoresEncontrados) {
            System.out.println(autoresEncontrado.toString());
        }
    }

    

}
