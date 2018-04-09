/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.ArticuloEntity;
import co.edu.uniandes.csw.manda2.entities.ComprasEnTiendaEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.ComprasEnTiendaPersistence;
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
public class ComprasEnTiendaLogic {
    private static final Logger LOGGER = Logger.getLogger(ComprasEnTiendaLogic.class.getName());
    

    @Inject
    private ComprasEnTiendaPersistence persistence;
    
    
    /**
     * Devuelve las compras que hay en la base de datos
     * @return 
     */
    public List<ComprasEnTiendaEntity> getCompras (){
        LOGGER.info("Inicia proceso de consultar todas las compras");
        List<ComprasEnTiendaEntity> compras = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las compras");
        return compras;
    }
    
    /**
     * Buscar una compra por el id dado 
     * @param id el id de la compra a buscar    
     * @return La compra encontrada, si no se encuentra retorna null
     */
    public ComprasEnTiendaEntity getCompra (Long id ) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar compras con id={0}", id);
        ComprasEnTiendaEntity compras = persistence.find(id);
        if (compras == null) {
            LOGGER.log(Level.SEVERE, "Las compras con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar compras con id={0}", id);
        return compras;
    }
    
    
    /**
     * 
     * @param entity
     * @return 
     */
    public ComprasEnTiendaEntity createCompra(ComprasEnTiendaEntity entity ) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de compra");
        //if (!validateArticulo(entity.getArticulo()!= null)) {
        // throw new BusinessLogicException("El articulo no es valido");
        //}
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de compra");
        return entity;
    }
    
    
    public ComprasEnTiendaEntity updateCompra (Long id, ComprasEnTiendaEntity entity ) {
         LOGGER.log(Level.INFO, "Inicia proceso de actualizar una compra con id={0}", id);
        //if (!validateISBN(entity.getIsbn())) {
          //  throw new BusinessLogicException("El ISBN es inválido");
        //}
        ComprasEnTiendaEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar una compra con id={0}", entity.getId());
        return newEntity;
    }
    
    /**
     * Elimina la compra dada por el id 
     * @param id el id de la compra a eliminar
     */
    public void deleteCompra (Long id ){
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una compra con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar una compra con id={0}", id);
    }
    
    private boolean validateArticulo (ArticuloEntity articulo){
        return articulo != null ; 
    }
   
    

}
