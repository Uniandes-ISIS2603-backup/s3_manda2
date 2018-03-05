/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;
import co.edu.uniandes.csw.manda2.entities.VueltasConDemoraEnOficinaEntity;
import co.edu.uniandes.csw.manda2.persistence.VueltasConDemoraEnOficinaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author dv.gonzalez10
 */

@Stateless
public class VueltasConDemoraEnOficinaLogic {
    private static final Logger LOGGER = Logger.getLogger(ComprasEnTiendaLogic.class.getName());
    
    @Inject
    private VueltasConDemoraEnOficinaPersistence persistence;
    
    
    /**
     * Devuelve las compras que hay en la base de datos
     * @return 
     */
    public List<VueltasConDemoraEnOficinaEntity> getVueltas (){
        LOGGER.info("Inicia proceso de consultar todas las vueltas");
        List<VueltasConDemoraEnOficinaEntity> vueltas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las vueltas");
        return vueltas;
    }
    
    /**
     * Buscar un libro por el id dado 
     * @param id el id de la compra a buscar    
     * @return La compra encontrada, si no se encuentra retorna null
     */
    public VueltasConDemoraEnOficinaEntity getVuelta (Long id ) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar vuelta con id={0}", id);
        VueltasConDemoraEnOficinaEntity vuelta = persistence.find(id);
        if (vuelta == null) {
            LOGGER.log(Level.SEVERE, "Las vuelta con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar la vuelta con id={0}", id);
        return vuelta;
    }
    
    
    /**
     * 
     * @param entity
     * @return 
     */
    public VueltasConDemoraEnOficinaEntity createVuelta (VueltasConDemoraEnOficinaEntity entity ) {
        LOGGER.info("Inicia proceso de creación de vuelta");
       // if (!validateISBN(entity.getIsbn())) {
         //   throw new BusinessLogicException("El ISBN es inválido");
        //}
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de vuelta");
        return entity;
    }
    
    /**
     * 
     * @param id
     * @param entity
     * @return 
     */
    public VueltasConDemoraEnOficinaEntity updateVuelta (Long id, VueltasConDemoraEnOficinaEntity entity ) {
         LOGGER.log(Level.INFO, "Inicia proceso de actualizar una vuelta con id={0}", id);
        //if (!validateISBN(entity.getIsbn())) {
          //  throw new BusinessLogicException("El ISBN es inválido");
        //}
        VueltasConDemoraEnOficinaEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar una vuelta con id={0}", entity.getId());
        return newEntity;
    }
    
    /**
     * Elimina la Vuelta dada por el id 
     * @param id el id de la Vuelta a eliminar
     */
    public void deleteVuelta (Long id ){
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una vuelta con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar una vuelta con id={0}", id);
    }
    
    
    
}
