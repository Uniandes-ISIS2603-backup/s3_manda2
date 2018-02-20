/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

import co.edu.uniandes.csw.manda2.entities.BilleteraEntity;
import co.edu.uniandes.csw.manda2.persistence.BilleteraPersistence;
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
public class BilleteraPersistenceTest {
        
    
    @Inject
    private BilleteraPersistence billeteraPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Test
    public void createServicioTest(){
        PodamFactory factory = new PodamFactoryImpl();
        BilleteraEntity newEntity = factory.manufacturePojo(BilleteraEntity.class);
        BilleteraEntity result = billeteraPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        BilleteraEntity entity = em.find(BilleteraEntity.class, result.getSaldo());
        
        Assert.assertEquals(newEntity.getSaldo(), entity.getSaldo());
    }
}
