/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.persistencia;

import java.util.Collection;
import java.util.List;
import libreria.entidades.Autor;

/**
 *
 * @author FlowUser
 */
public class AutorDAO extends DAO<Autor> {

    public AutorDAO() {
    }

    @Override
    public void guardar(Autor objeto) {
        super.guardar(objeto); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void eliminar(Autor objeto) {
        super.eliminar(objeto); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void editar(Autor objeto) {
        super.editar(objeto); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public boolean esNumerico(String cadena) {
        return super.esNumerico(cadena); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public Collection<Autor> listar() {
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a")
                .getResultList();
        desconectar();
        return autores;
    }

    public Autor buscarPorId(Integer id) {
       Autor autor = null;
        try{
        conectar();
       
        
//        autor = em.find(Autor.class, id);

//        String ID = String.valueOf(id);
        autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id LIKE :id")
                .setParameter("id", id.toString()).getSingleResult();

//        autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id = "+id).getSingleResult();
        desconectar();
       
        return autor;
        }catch(javax.persistence.NoResultException e){
            System.out.println("el autor no existe, crearlo desde el menu de Autores");
            autor = null;
            desconectar();
            return autor;
        }
   }

    public Autor modificarNombre(Integer id, String nombre) {

        Autor autorM = buscarPorId(id);
        autorM.setNombre(nombre);
        super.editar(autorM);
        return autorM;
    }

    public Autor bajaOAlta(Integer id, Boolean aob) {
        Autor autor = buscarPorId(id);
        autor.setAlta(aob);
        super.editar(autor);
        return autor;
    }
    public Autor  repetirAutor(String nom) {
        Autor autores = new Autor();
        conectar();
        try{
         autores = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
                .setParameter("nombre", nom).getSingleResult();
         return autores;
        }catch(Exception e){
             desconectar();
           
             return autores  = new Autor();
        }
       
       
    }
    public Collection<Autor> buscarPorNombre(String nom) {
        conectar();
        List<Autor> autores = (List<Autor>) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
                .setParameter("nombre", nom).getResultList();
        desconectar();
        return autores;
    }
}
