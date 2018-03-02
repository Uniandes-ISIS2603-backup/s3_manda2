/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.PayPalEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.PayPalPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Clase que implementa la conexión con la persistencia de la entidad paypal.
 * @author da.ramos
 */
@Stateless
public class PayPalLogic {
    
    private static final Logger LOGGER = Logger.getLogger(PayPalLogic.class.getName());
    
    @Inject
    PayPalPersistence payPalPersistence;
    
    /**
     * Retorna todos los paypals de la base de datos.
     * @return todos los paypals de la base de datos.
     */
    public List<PayPalEntity> getPayPals(){
        LOGGER.info("Inicia proceso de consultar payPals");
        List<PayPalEntity> list = payPalPersistence.findAll();
        LOGGER.info("Termina proceso de consultar payPals");
        return list;
    }
    
    /**
     * Retorna el paypal con el id dado por parámetro.
     * @param id id del paypal
     * @return paypal con el id dado por parámetro
     */
    public PayPalEntity getPayPal(Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el payPal con id={0}", id);
        PayPalEntity paypal = payPalPersistence.find(id);
        if(paypal == null){
            LOGGER.log(Level.SEVERE, "El paypal con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina el proceso de consultar el paypal con id={0}", id);
        return paypal;
    }
    
    /**
     * Guarda un nuevo paypal 
     * @param entity entidad del paypal 
     * @return paypal guardado
     * @throws BusinessLogicException si el nombre del cliente o el link del paypal no son strins válidos
     */
    public PayPalEntity createPayPal( PayPalEntity entity ) throws BusinessLogicException{
        LOGGER.info("Inicia proceso de creación de paypal");
        String nombreCliente = entity.getNombreCliente();
        String link = entity.getLinkPayPal();
        
        if( !validateNombreCliente(nombreCliente) ){
            throw new BusinessLogicException("El nombre del cliente no es válido.");
        }
        else if( !validateLink(link) ){
            throw new BusinessLogicException("El link no es válido");
        }
        else if( payPalPersistence.find(entity.getId()) != null ){
            throw new BusinessLogicException("Ya hay un PayPal con el id dado");
        }
        payPalPersistence.create(entity);
        LOGGER.info("Termina proceso de creación de paypal.");
        return entity;
    }
    
    /**
     * Actualiza la información del paypal con el id dado
     * @param id id del paypal 
     * @param entity entidad del nuevo paypal
     * @return paypal actualizado 
     * @throws BusinessLogicException si el nombre del cliente o el link del paypal no son strins válidos
     */
    public PayPalEntity updatePayPal(Long id, PayPalEntity entity) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de actualización de paypal con id={0}", id);
        String nombreCliente = entity.getNombreCliente();
        String link = entity.getLinkPayPal();
        
        if( !validateNombreCliente(nombreCliente) ){
            throw new BusinessLogicException("El nombre del cliente no es válido.");
        }
        else if( !validateLink(link) ){
            throw new BusinessLogicException("El link no es válido");
        }
        else if( entity.getId().equals(id) ){
            throw new BusinessLogicException("El id del paypal no debe cambiar");
        }
        PayPalEntity newEntity = payPalPersistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualización de paypal con id={0}", entity.getId());
        return newEntity;
    }
    
    /**
     * Elimina el paypal con el id dado
     * @param id id del paypal
     */
    public void deletePayPal(Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de borrado de de paypal con id={0}", id);
        payPalPersistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrado de de paypal con id={0}", id);
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
     * Retorna true si el link del paypal es un string válido, false de lo contrario.
     * @param link link del paypal
     * @return true si el link del paypal es un string válido, false de lo contrario.
     */
    private boolean validateLink( String link ){
        return ( link != null && !link.isEmpty());
    }
}
