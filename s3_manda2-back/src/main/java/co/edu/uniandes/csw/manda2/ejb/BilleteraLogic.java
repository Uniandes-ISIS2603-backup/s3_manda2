/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.BilleteraEntity;
import co.edu.uniandes.csw.manda2.entities.BilleteraEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.BilleteraPersistence;
import co.edu.uniandes.csw.manda2.persistence.BilleteraPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author m.moreno
 */
@Stateless
public class BilleteraLogic {
    
    private static final Logger LOGGER = Logger.getLogger(BilleteraLogic.class.getName());

    @Inject
    private BilleteraPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
//

    public List<BilleteraEntity> getBilleteras() {
        LOGGER.info("Inicia proceso de consultar todas las billeteras");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<BilleteraEntity> editorials = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las billeteras");
        return editorials;
    }

    public BilleteraEntity getBilletera(Long id) {
        return persistence.find(id);
    }


    
    public void deleteBilletera(BilleteraEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar billetera con id={0}", entity.getId());    
        persistence.delete(entity);
        LOGGER.log(Level.INFO, "Termina proceso de borrar billetera con id={0}", entity.getId());
    }
    
    
//    public BilleteraEntity createBilletera(BilleteraEntity entity) throws BusinessLogicException {
//        LOGGER.info("Inicia proceso de creación de Billetera");
//        // Verifica la regla de negocio que dice que no puede haber dos cities con el mismo nombre
//        if (persistence.findByName(entity.getName()) != null) {
//            throw new BusinessLogicException("Ya existe una Ciudad con el nombre \"" + entity.getName() + "\"");
//        }
//        // Invoca la persistencia para crear la Billetera
//        persistence.create(entity);
//        LOGGER.info("Termina proceso de creación de Billetera");
//        return entity;
//    }
    //    public BilleteraEntity updateBilletera(BilleteraEntity entity) throws BusinessLogicException  {
//        if (persistence.findByName(entity.getName()) != null) {
//            throw new BusinessLogicException("Ya existe una Ciudad con el nombre \"" + entity.getName() + "\"");
//        }
//        return persistence.update(entity);
//    }
}
