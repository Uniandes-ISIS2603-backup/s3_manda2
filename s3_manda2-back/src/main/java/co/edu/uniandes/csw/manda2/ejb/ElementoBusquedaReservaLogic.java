/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.ElementoBusquedaReservaEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.ElementoBusquedaReservaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author cv.trujillo
 */
@Stateless
public class ElementoBusquedaReservaLogic  {
     //Constantes
    private static final Logger LOGGER = Logger.getLogger(ElementoBusquedaReservaLogic.class.getName());
    //Atributos
    @Inject
    private ElementoBusquedaReservaPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
    /**
     * Devuelve todos los pses que hay en la base de datos.
     * @return Lista de entidades de tipo pse.
     */
    public List<ElementoBusquedaReservaEntity> getElementoBusquedaReservas() {
        LOGGER.info("Inicia proceso de consultar todos los pses");
        List<ElementoBusquedaReservaEntity> pses = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los pses");
        return pses;
    }
    /**
     * Busca un pse por ID
     * @param id El id del pse a buscar
     * @return El pse encontrado, null si no lo encuentra.
     */
    public ElementoBusquedaReservaEntity getElementoBusquedaReserva(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar pse con id={0}", id);
        ElementoBusquedaReservaEntity pse = persistence.find(id);
        if (pse == null) {
            LOGGER.log(Level.SEVERE, "El pse con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar pse"
                + " con id={0}", id);
        return pse;
    }
    /**
     * Eliminar un ElementoBusquedaReserva
     * @param id El ID del pse a eliminar
     */
    public void deleteElementoBusquedaReserva(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar pse con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar pse con id={0}", id);
    }
    /**
     * Guardar un nuevo ElementoBusquedaReserva
     * @param entity La entidad de tipo pse del nuevo pse a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException Si el nombre o el nombre son nulos o estaban vacios. 
     */
    public ElementoBusquedaReservaEntity createElementoBusquedaReserva(ElementoBusquedaReservaEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación del pse");
        if (!validateNombre(entity.getNombreElementoBusquedaReserva())) {
            throw new BusinessLogicException("El nombre o el nombre no pueden ser vacios");
        }
        if(persistence.find(entity.getId())!= null)
        {
            throw new BusinessLogicException("No pueden existir dos pses con el mismo id");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de pse");
        return entity;
    }
    /**
     * Actualizar un pse por ID
     * @param id El ID del pse a actualizar
     * @param entity La entidad del pse con los cambios deseados
     * @return La entidad del pse luego de actualizarla
     * @throws BusinessLogicException Si el nombre o el nombre son nulos o estaban vacios o se intento cambiar el id.
     */
    public ElementoBusquedaReservaEntity updateElementoBusquedaReserva(Long id, ElementoBusquedaReservaEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar pse con id={0}", id);
        if (!validateNombre(entity.getNombreElementoBusquedaReserva())) {
            throw new BusinessLogicException("El nombre o el nombre no pueden ser vacios");
        }
        if(id!= entity.getId())
        {
            throw new BusinessLogicException("No se puede cambiar el id del pse");
        }
        ElementoBusquedaReservaEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar pse con id={0}", entity.getId());
        return newEntity;
    }

     /**
     * Retorna true si el nombre del paypal es un string válido, false de lo contrario.
     * @param nombre nombre del paypal
     * @return true si el nombre del pse es un string válido, false de lo contrario.
     */
    private boolean validateNombre( String nombre ){
        return ( nombre != null && !nombre.isEmpty());
    }
}