/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.TarjetaCreditoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author na.caceres
 */
@Stateless
public class TarjetaCreditoLogic {
    //Constantes
    private static final Logger LOGGER = Logger.getLogger(TarjetaCreditoLogic.class.getName());
    //Atributos
    @Inject
    private TarjetaCreditoPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
    /**
     * Devuelve todos las tarjetas de credito que hay en la base de datos.
     * @return Lista de entidades de tipo TarjetaCredito.
     */
    public List<TarjetaCreditoEntity> getTarjetasCreditos() {
        LOGGER.info("Inicia proceso de consultar todas las tarjetas de credito");
        List<TarjetaCreditoEntity> tarjetas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos las tarjetas de credito");
        return tarjetas;
    }
    /**
     * Busca una tarjeta por ID
     * @param id El id de la tarjeta  a buscar
     * @return La tarjeta encontrada, null si no lo encuentra.
     */
    public TarjetaCreditoEntity getTarjetaCredito(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar tarjeta de credito con id={0}", id);
        TarjetaCreditoEntity tarjeta = persistence.find(id);
        if (tarjeta == null) {
            LOGGER.log(Level.SEVERE, "La tarjeta con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar tarjeta con id={0}", id);
        return tarjeta;
    }
    /**
     * Eliminar una TarjetaCredito
     * @param id El ID de la tarjeta a eliminar
     */
    public void deleteTarjetaCredito(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar tarjeta de credito con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar tarjeta de credito con id={0}", id);
    }
    /**
     * Guardar una nueva tarjeta de credito
     * @param entity La entidad de tipo TarjetaCredtio de la nueva tarjeta de credito a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException Si el nombre o el link son nulos o estaban vacios. 
     */
    public TarjetaCreditoEntity createTarjetaCredito(TarjetaCreditoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de la tarjeta de credito");
        if (!validateNombreCliente(entity.getNombreCliente())||!validateNum(entity.getNumeroTarjeta())) {
            throw new BusinessLogicException("El nombre no puede ser vacio, o el numero de la tarjeta  no es valido");
        }
        if(getTarjetaCredito(entity.getId())!= null)
        {
            throw new BusinessLogicException("No pueden existir dos tarjetas con el mismo id");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de la tarjeta de credito");
        return entity;
    }
    /**
     * Actualizar una tarjeta de credito por ID
     * @param id El ID de la tarjeta de credito a actualizar
     * @param entity La entidad de la tarjeta de credito con los cambios deseados
     * @return La entidad de la tarjeta de credito luego de actualizarla
     * @throws BusinessLogicException Si el 
     */
    public TarjetaCreditoEntity updateTarjetaCredito(Long id, TarjetaCreditoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar tarjeta de credito con id={0}", id);
        if (!validateNombreCliente(entity.getNombreCliente())||!validateNum(entity.getNumeroTarjeta())) {
            throw new BusinessLogicException("El nombre no puede ser vacio, o el numero de la tarjeta  no es valido");
        }
        if(entity.getId() != id)
        {
            throw new BusinessLogicException("No se puede cambiar el id de la tarjeta de credito");
        }
        
        TarjetaCreditoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar tarjeta de credito con id={0}", entity.getId());
        return newEntity;
    }
    /**
     * Retorna true si el nombre del cliente es un string válido, false de lo contrario.
     * @param nombreCliente nombre del cliente
     * @return true si el nombre del cliente es un string válido, false de lo contrario.
     */
    private boolean validateNombreCliente( String nombreCliente ){
        return (nombreCliente != null && !nombreCliente.isEmpty());
    }
    
     /**
     * Retorna true si el numero de la tarjeta es un numero válido, false de lo contrario.
     * @param num num de la tarjeta de credito
     * @return true si el numero de la tarjeta es un nuemero valifoo, false de lo contrario.
     */
    private boolean validateNum( String num ){
        return num.length()<=18;
    }
}
