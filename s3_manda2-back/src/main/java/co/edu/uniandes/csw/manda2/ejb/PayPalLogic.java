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
 *
 * @author da.ramos
 */
@Stateless
public class PayPalLogic {
    
    private static final Logger LOGGER = Logger.getLogger(PayPalLogic.class.getName());
    
    @Inject
    PayPalPersistence payPalPersistence;
    
    public List<PayPalEntity> getPayPals(){
        LOGGER.info("Inicia proceso de consultar payPals");
        List<PayPalEntity> list = payPalPersistence.findAll();
        LOGGER.info("Termina proceso de consultar payPals");
        return list;
    }
    
    public PayPalEntity getPayPal(Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el payPal con id={0}", id);
        PayPalEntity paypal = payPalPersistence.find(id);
        if(paypal == null){
            LOGGER.log(Level.SEVERE, "El paypal con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina el proceso de consultar el paypal con id={0}", id);
        return paypal;
    }
    
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
        payPalPersistence.create(entity);
        LOGGER.info("Termina proceso de creación de paypal.");
        return entity;
    }
    
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
        PayPalEntity newEntity = payPalPersistence.update(entity);
        LOGGER.log(Level.INFO, "Inicia proceso de actualización de paypal con id={0}", entity.getId());
        return newEntity;
    }
    
    public void deletePayPal(Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de borrado de de paypal con id={0}", id);
        payPalPersistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrado de de paypal con id={0}", id);
    }
    
    private boolean validateNombreCliente( String nombreCliente ){
        return !(nombreCliente == null || nombreCliente.isEmpty());
    }
    
    private boolean validateLink( String link ){
        return !( link == null || link.isEmpty());
    }
}
