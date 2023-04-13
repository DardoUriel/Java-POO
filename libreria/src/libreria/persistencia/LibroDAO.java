/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.servicios.LibroServicio;

/**
 *
 * @author FlowUser
 */
public class LibroDAO extends DAO<Libro> {

    EntityManager em = Persistence.createEntityManagerFactory("libreriaPU").createEntityManager();

    public LibroDAO() {
    }

    @Override
    public void editar(Libro objeto) {
        super.editar(objeto); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void guardar(Libro objeto) {
        super.guardar(objeto); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void eliminar(Libro objeto) {
        super.eliminar(objeto); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public boolean esNumerico(String cadena) {
        return super.esNumerico(cadena); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public Libro buscarPorId(Integer id) {
        conectar();
        Libro libro = em.find(Libro.class, id);
        desconectar();
        return libro;
    }

    public Autor buscarAutorPorId(Integer id) {
        conectar();
        Autor autor = em.find(Autor.class, id);
        desconectar();
        return autor;
    }

    public Editorial buscarEditorialPorId(Integer id) {
        conectar();
        Editorial editorial = em.find(Editorial.class, id);
        desconectar();
        return editorial;
    }

    public Collection<Libro> listar() {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l")
                .getResultList();
        desconectar();
        return libros;
    }

    public Libro altaOBaja(Integer id, Boolean AOB) {
        Libro libro = buscarPorId(id);
        libro.setAlta(AOB);
        super.editar(libro);
        return libro;
    }

    public Collection<Libro> buscarLibroPorTitulo(String titulo) {
        conectar();
        List<Libro> librosEncontrados = new ArrayList<>();
        librosEncontrados = em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo")
                .setParameter("titulo", titulo).getResultList();
        return librosEncontrados;
    }

    public Libro libroRepetido(String titulo) {
        Libro librosEncontrados = new Libro();
        try {
            conectar();
            
            librosEncontrados = (Libro)em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo")
                    .setParameter("titulo", titulo).getSingleResult();
            return librosEncontrados;
        } catch (Exception e) {
           
            return  librosEncontrados = new Libro();
        }

    }

    public Collection<Libro> buscarPorISBN(Integer isbn) {
        conectar();
        List<Libro> librosEncontrados = (List<Libro>) em.createQuery("SELECT l FROM Libro l WHERE l. LIKE :isbn")
                .setParameter("isbn", isbn.toString()).getResultList();
        desconectar();
        return librosEncontrados;
    }

    public Collection<Libro> buscarPorEditorial(String editorial) {
        editorial = editorial.toLowerCase();
        conectar();

        List<Libro> librosEncontrados = (List<Libro>) em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre LIKE :editorial")
                .setParameter("editorial", editorial).getResultList();
        desconectar();
        return librosEncontrados;
    }

    public Collection<Libro> buscarPorAutor(String autor) {
        autor = autor.toLowerCase();
        conectar();
        List<Libro> librosEncontrados = (List<Libro>) em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :autor")
                .setParameter("autor", autor).getResultList();
        desconectar();
        return librosEncontrados;
    }
}
