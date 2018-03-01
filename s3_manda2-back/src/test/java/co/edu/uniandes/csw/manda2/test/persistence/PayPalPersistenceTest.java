/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

import co.edu.uniandes.csw.manda2.entities.PayPalEntity;
import co.edu.uniandes.csw.manda2.persistence.PayPalPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author da.ramos
 */
@RunWith(Arquillian.class)
public class PayPalPersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PayPalEntity.class.getPackage())
                .addPackage(PayPalPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private PayPalPersistence payPalPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    @Before
    public void configTest(){
        try{
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        }catch (Exception e){
            e.printStackTrace();
            try{
                utx.rollback();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }
    
    private void clearData(){
        em.createQuery("delete from PayPalEntity").executeUpdate();
    }
    
    private List<PayPalEntity> data = new ArrayList<>();
    
    private void insertData(){
        PodamFactory factory = new PodamFactoryImpl();
        for( int i = 0; i < 3; i++ ){
            PayPalEntity payPal = factory.manufacturePojo(PayPalEntity.class);
            
            em.persist(payPal);
            data.add(payPal);
        }
    }
    
    @Test
    public void createPayPalTest(){
        PodamFactory factory = new PodamFactoryImpl();
        PayPalEntity newEntity = factory.manufacturePojo(PayPalEntity.class);
        PayPalEntity result = payPalPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        PayPalEntity entity = em.find(PayPalEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getLinkPayPal(), entity.getLinkPayPal());
        Assert.assertEquals(newEntity.getNombreCliente(), result.getNombreCliente());
    }
    
    @Test
    public void getPayPalsTest(){
        List<PayPalEntity> list = payPalPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for( PayPalEntity entity : list ){
            boolean found = false;
            for( PayPalEntity entity2 : data ){
                if (entity.getId().equals(entity2.getId())){
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getPayPaltest(){
        PayPalEntity entity = data.get(0);
        PayPalEntity newEntity = payPalPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getLinkPayPal(), newEntity.getLinkPayPal());
        Assert.assertEquals(entity.getNombreCliente(), newEntity.getNombreCliente());
    }
    
    @Test
    public void deletePayPalTest(){
        PayPalEntity entity = data.get(0);
        payPalPersistence.delete(entity.getId());
        PayPalEntity deleted = em.find(PayPalEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updatePayPalTest(){
        PayPalEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        PayPalEntity newEntity = factory.manufacturePojo(PayPalEntity.class);
        
        newEntity.setId(entity.getId());
        
        payPalPersistence.update(newEntity);
        
        PayPalEntity resp = em.find(PayPalEntity.class, entity.getId());
        
        Assert.assertEquals(newEntity.getNombreCliente(), entity.getNombreCliente());
        Assert.assertEquals(newEntity.getLinkPayPal(), entity.getLinkPayPal());
    }
}
