/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

import co.edu.uniandes.csw.manda2.entities.MedioPagoEntity;
import co.edu.uniandes.csw.manda2.persistence.MedioPagoPersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Assert;
import org.junit.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author m.moreno
 */
public class MedioPagoPersistenceTest {
       
    
    @Inject
    private MedioPagoPersistence medioPagoPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Test
    public void createServicioTest(){
        PodamFactory factory = new PodamFactoryImpl();
        MedioPagoEntity newEntity = factory.manufacturePojo(MedioPagoEntity.class);
        MedioPagoEntity result = medioPagoPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        MedioPagoEntity entity = em.find(MedioPagoEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getId(), entity.getId());
    } 
}
