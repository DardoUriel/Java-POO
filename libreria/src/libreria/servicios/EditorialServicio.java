/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.servicios;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

/**
 *
 * @author FlowUser
 */
public class EditorialServicio {

    private final EditorialDAO dao;

    public EditorialServicio() {
        this.dao = new EditorialDAO();
    }
    
    public void crearEditoriales() {
        
        try {
            Editorial editorial1 = new Editorial();
            editorial1.setNombre("Porrúa S.A. de C.V.");
            editorial1.setAlta(true);
            
            dao.guardar(editorial1);
            
            Editorial editorial2 = new Editorial();
            editorial2.setNombre("Collins Crime Club");
            editorial2.setAlta(true);
            
            dao.guardar(editorial2);
            
            Editorial editorial3 = new Editorial();
            editorial3.setNombre("Punto de Encuentro.");
            editorial3.setAlta(true);
            
            dao.guardar(editorial3);
            Editorial editorial4 = new Editorial();
            editorial4.setNombre("A. Lacroix, Verboeckhoven & Ce. Bruselas, Bélgica");
            editorial4.setAlta(true);
            
            dao.guardar(editorial4);
            
        } catch (Exception e) {
            throw e;
        }
    }

    public void crearEditorial() {
        Editorial editorial1 = new Editorial();
        System.out.print("Nombre de la Editorial: ");
        editorial1.setNombre(libreria.Libreria.l.next());
        editorial1.setAlta(true);
        Editorial editorialConfirmacion = dao.repetirEditorial(editorial1.getNombre());
        if (editorial1.getNombre().equalsIgnoreCase(editorialConfirmacion.getNombre())) {
            System.out.println("ya existe una editorial con el nombre "+editorial1.getNombre());
        } else {
            dao.guardar(editorial1);
            System.out.println("Editorial creada : "+ editorial1);
        }
        
        
        
    }

    public void listarEditoriales() {
        Collection<Editorial> editoriales = dao.listar();
        System.out.println("EDITORIALES ACTUALES");
        for (Editorial e : editoriales) {
            System.out.println(e.toString());
        }
    }
  public Editorial buscarPorId(Integer id) {
        
        Editorial editorial = dao.buscarPorId(id);
        return editorial;
    }
      public void darAltaOBajaEditorial() {
        Editorial editorialBOA = new Editorial();
        listarEditoriales();
        System.out.println("id Editorial:");
        Integer id = libreria.Libreria.l.nextInt();
        System.out.println("Indicar cambio a) dar de alta b) dar de baja");
        String cambio = libreria.Libreria.l.next();
        switch (cambio.toLowerCase()) {
            case "a":
                editorialBOA = dao.bajaOAlta(id, true);
                break;
            case "b":
                editorialBOA = dao.bajaOAlta(id, false);
                break;
            default:
                System.out.println("la opcion ingresada no es valida");
                
        }
        System.out.println("Editorial modificada a : "+ editorialBOA.toString());
       
    }
//
    public void modificarNombreEditorial(){
        listarEditoriales();
        System.out.print("Id Editorial :");
        Integer id = libreria.Libreria.l.nextInt();
        Editorial editorialM = dao.buscarPorId(id);
        System.out.print("Nuevo nombre de la Editorial: ");
        String nombre = libreria.Libreria.l.next();
        editorialM.setNombre(nombre);
         editorialM = dao.modificarNombre(id, nombre);
        System.out.println("Editorial modificada a : "+ editorialM);
    };
    
    public void borrarEditorialesPorId() {
       listarEditoriales();
        System.out.println("Id Editorial: ");
        Integer id = libreria.Libreria.l.nextInt();
        Editorial e = dao.buscarPorId(id);
        dao.eliminar(e);
        System.out.println("Autor "+e.toString()+" eliminado");
    }
}
/*
Porrúa S.A. de C.V.
Collins Crime Club
Punto de Encuentro
A. Lacroix, Verboeckhoven & Ce. Bruselas, Bélgica.
 */
