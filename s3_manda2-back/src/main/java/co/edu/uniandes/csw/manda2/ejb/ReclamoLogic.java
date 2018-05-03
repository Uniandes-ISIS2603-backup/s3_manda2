/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.ReclamoEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.ReclamoPersistence;
import java.time.Clock;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author n.bello
 */
@Stateless
public class ReclamoLogic {
    // Constantes
    private static final Logger LOGGER = Logger.getLogger(ReclamoLogic.class.getName());
    //Atributos
    @Inject
    private ReclamoPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
    /**
     * Devuelve todos los reclamo que hay en la base de datos.
     * @return Lista de entidades de tipo reclamo.
     */
    public List<ReclamoEntity> getReclamos() {
        LOGGER.info("Inicia proceso de consultar todos los reclamos");
        List<ReclamoEntity> reclamos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los reclamos");
        return reclamos;
    }
    /**
     * Busca un reclamos por ID
     * @param id El id del reclamo a buscar
     * @return El reclamo encontrado, null si no lo encuentra.
     */
    public ReclamoEntity getReclamo(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar reclamo con id={0}", id);
        ReclamoEntity reclamo = persistence.find(id);
        if (reclamo == null) {
            LOGGER.log(Level.SEVERE, "El reclamo el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar reclamo"
                + " con id={0}", id);
        return reclamo;
    }
    /**
     * Busca un reclamos por numero
     * @param numero El id del reclamo a buscar
     * @return El reclamo encontrado, null si no lo encuentra.
     */
    /*public ReclamoEntity getReclamoByNumero(Integer numero) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar reclamo con id={0}", numero);
        ReclamoEntity reclamo = persistence.findByNumero(numero);
        if (reclamo == null) {
            LOGGER.log(Level.SEVERE, "El reclamo el numero {0} no existe", numero);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar reclamo"
                + " con numero={0}", numero);
        return reclamo;
    }
    */
    /**
     * Eliminar un reclamo
     * @param id El ID del reclamo a eliminar
     */
    public void deleteReclamo(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar reclamo con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar reclamo con id={0}", id);
    }
    /**
     * Guardar un nuevo reclamo
     * @param entity La entidad de tipo reclamo del nuevo reclamo a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException Si el reclamo no es valido 
     */
    public ReclamoEntity createReclamo(ReclamoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de un empleado");
        System.out.println(entity.getNumero());
        
        if(persistence.find(entity.getId())!= null)
        {
            throw new BusinessLogicException("No pueden existir dos reclamos con el mismo id");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de reclamo");
        return entity;
    }
    /**
     * Actualizar un reclamo por ID
     * @param id El ID del reclamo a actualizar
     * @param entity La entidad del reclamo con los cambios deseados
     * @return La entidad del reclamo luego de actualizarla
     * @throws BusinessLogicException Si el numero es nulos o estaban vacios o se intento cambiar el id.
     */
    public ReclamoEntity updateReclamo(Long id, ReclamoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar reclamo con id={0}", id);
        System.out.println("A");
        if(id != entity.getId())
        {
            throw new BusinessLogicException("No se puede cambiar el id del reclamo");
        }
        System.out.println("AA");
        ReclamoEntity newEntity = persistence.update(entity);
        System.out.println("AA");
        LOGGER.log(Level.INFO, "Termina proceso de actualizar reclamo con id={0}", entity.getId());
        return newEntity;
    }
    /**
     * Retorna true si el numero del reclamo es un string válido, false de lo contrario.
     * @param numero numero del reclamo
     * @return true si el numero del reclamo es un string válido, false de lo contrario.
     */
    private boolean validateNumero( Integer numero ){
        return (numero>0);
    }
    
    
}
