/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.logic;

import co.edu.uniandes.csw.manda2.ejb.PayPalLogic;
import co.edu.uniandes.csw.manda2.entities.PayPalEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.PayPalPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
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
public class PayPalLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
     @Inject
     private PayPalLogic paypalLogic;
     
     @PersistenceContext
     private EntityManager em; 
     
     @Inject
     private UserTransaction utx;
     
     private List<PayPalEntity> data = new ArrayList<>();
     
     @Deployment
     public static JavaArchive createDeployment(){
          return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PayPalEntity.class.getPackage())
                .addPackage(PayPalLogic.class.getPackage())
                .addPackage(PayPalPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
     }
     
     @Before
     public void configTest(){
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
     }
     
     private void clearData(){
         em.createQuery("delete from PayPalEntity").executeUpdate();
     }
     
     private void insertData(){
         for( int i = 0; i < 3; i++){
             PayPalEntity entity = factory.manufacturePojo(PayPalEntity.class);
             em.persist(entity);
             data.add(entity);
         }
     }
     
     @Test
     public void createPayPalTest() throws BusinessLogicException{
         PayPalEntity newEntity = factory.manufacturePojo(PayPalEntity.class);
         PayPalEntity result = paypalLogic.createPayPal(newEntity);
         Assert.assertNotNull(result);
         PayPalEntity entity = em.find(PayPalEntity.class, result.getId());
         Assert.assertEquals( newEntity.getLinkPayPal(), entity.getLinkPayPal() );
         Assert.assertEquals( newEntity.getNombreCliente(), entity.getNombreCliente());
         
         try{
             paypalLogic.createPayPal(newEntity);
             Assert.fail();
         }catch( BusinessLogicException e){}
         try{
             newEntity.setNombreCliente("");
             paypalLogic.createPayPal(newEntity);
             Assert.fail();
         }catch(BusinessLogicException e){}
         try{
             newEntity.setNombreCliente(null);
             paypalLogic.createPayPal(newEntity);
             Assert.fail();
         }catch(BusinessLogicException e){}
         try{
             newEntity.setLinkPayPal("");
             paypalLogic.createPayPal(newEntity);
             Assert.fail();
         }catch(BusinessLogicException e){}
         try{
             newEntity.setLinkPayPal("");
             paypalLogic.createPayPal(newEntity);
             Assert.fail();
         }catch(BusinessLogicException e){}
     }
     
     @Test
    public void getPayPalsTest(){
        List<PayPalEntity> list = paypalLogic.getPayPals();
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
        PayPalEntity newEntity = paypalLogic.getPayPal(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getLinkPayPal(), newEntity.getLinkPayPal());
        Assert.assertEquals(entity.getNombreCliente(), newEntity.getNombreCliente());
    }
     
    @Test
    public void deletePayPalTest(){
        PayPalEntity entity = data.get(0);
        paypalLogic.deletePayPal(entity.getId());
        PayPalEntity deleted = em.find(PayPalEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updatePayPalTest(){
        PayPalEntity entity = data.get(0);
        PayPalEntity newEntity = factory.manufacturePojo(PayPalEntity.class);
        
        newEntity.setId(entity.getId());
        
        try{
            paypalLogic.updatePayPal(newEntity.getId(), newEntity);
        }catch(BusinessLogicException e){
            System.out.println(e.getMessage());
            Assert.fail();
        }
        
        PayPalEntity resp = em.find(PayPalEntity.class, entity.getId());
        
        Assert.assertEquals(newEntity.getNombreCliente(), resp.getNombreCliente());
        Assert.assertEquals(newEntity.getLinkPayPal(), resp.getLinkPayPal());
        
         try{
             newEntity.setNombreCliente("");
             paypalLogic.updatePayPal(newEntity.getId(), newEntity);
             Assert.fail();
         }catch(BusinessLogicException e){}
         try{
             newEntity.setNombreCliente(null);
             paypalLogic.updatePayPal(newEntity.getId(), newEntity);
             Assert.fail();
         }catch(BusinessLogicException e){}
         try{
             newEntity.setLinkPayPal("");
             paypalLogic.updatePayPal(newEntity.getId(), newEntity);
             Assert.fail();
         }catch(BusinessLogicException e){}
         try{
             newEntity.setLinkPayPal("");
             paypalLogic.updatePayPal(newEntity.getId(), newEntity);
             Assert.fail();
         }catch(BusinessLogicException e){}
         try{
            newEntity.setId(newEntity.getId()+1);
            paypalLogic.updatePayPal(newEntity.getId(), newEntity);
             Assert.fail();
         }catch(BusinessLogicException e){}
    }
}
