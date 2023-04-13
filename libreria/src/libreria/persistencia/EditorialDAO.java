/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.persistencia;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;

/**
 *
 * @author FlowUser
 */
public class EditorialDAO extends DAO<Editorial> {

    EntityManager em = Persistence.createEntityManagerFactory("libreriaPU").createEntityManager();

    @Override
    public void guardar(Editorial objeto) {
        super.guardar(objeto); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void editar(Editorial objeto) {
        super.editar(objeto); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void eliminar(Editorial objeto) {
        super.eliminar(objeto); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public Collection<Editorial> listar() {
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e")
                .getResultList();
        desconectar();
        return editoriales;
    }
     public Editorial buscarPorId(Integer id) {
        conectar();
        Editorial editorial = em.find(Editorial.class, id);
        desconectar();
        return editorial;
    }

    public Editorial bajaOAlta(Integer id, Boolean aob) {
        Editorial editorial = buscarPorId(id);
        editorial.setAlta(aob);
        super.editar(editorial);
        return editorial;
    }
    public Editorial modificarNombre(Integer id,String nombre) {        
        Editorial editorialM = buscarPorId(id);
        editorialM.setNombre(nombre);
        super.editar(editorialM);
        return editorialM;            
    }
    /*validacion para no repetir autores*/
    public Editorial repetirEditorial(String nombre){
        Editorial editorialEncontrada = new Editorial();
        conectar();
        try {
             editorialEncontrada = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre")
            .setParameter("nombre", nombre).getSingleResult();
            return editorialEncontrada;
        } catch (Exception e) {
           
            return editorialEncontrada = new Editorial();                   
        }
    }
}
