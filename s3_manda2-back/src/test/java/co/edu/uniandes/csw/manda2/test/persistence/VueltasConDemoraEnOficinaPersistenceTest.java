/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

import co.edu.uniandes.csw.manda2.ejb.VueltasConDemoraEnOficinaLogic;
import co.edu.uniandes.csw.manda2.entities.VueltasConDemoraEnOficinaEntity;
import co.edu.uniandes.csw.manda2.persistence.VueltasConDemoraEnOficinaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
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
 * @author dv.gonzalez10
 */
@RunWith(Arquillian.class)
public class VueltasConDemoraEnOficinaPersistenceTest {
    @Deployment
    public static JavaArchive createDeployement (){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(VueltasConDemoraEnOficinaEntity.class.getPackage())
                .addPackage(VueltasConDemoraEnOficinaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
               
    }
    
    
    @Inject
    private VueltasConDemoraEnOficinaPersistence vueltasConDemoraEnOfcinaPersistence;
    
    //@Inject
    //private VueltasConDemoraEnOficinaLogic vueltasLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    private List<VueltasConDemoraEnOficinaEntity> data = new ArrayList<VueltasConDemoraEnOficinaEntity>();
    
    
    
    
    /**
     * Limpia las tablas que están implicadas en la prueba
     */
     private void clearData() {
        em.createQuery("delete from VueltasConDemoraEnOficinaEntity").executeUpdate();
    }
     
     
     /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     *
     * 
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            VueltasConDemoraEnOficinaEntity entity = factory.manufacturePojo(VueltasConDemoraEnOficinaEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
    }
     
     
    /**
     * 
     * @throws NotSupportedException
     * @throws SystemException 
     */

    @Before
    public void configTest(){
        try{
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
    
    //Tests
    
    @Test
     public void createServicioTest(){
        PodamFactory factory = new PodamFactoryImpl();
        VueltasConDemoraEnOficinaEntity newEntity = factory.manufacturePojo(VueltasConDemoraEnOficinaEntity.class);
        VueltasConDemoraEnOficinaEntity result = vueltasConDemoraEnOfcinaPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        VueltasConDemoraEnOficinaEntity entity = em.find(VueltasConDemoraEnOficinaEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getCostoDuracion(), entity.getCostoDuracion());
        Assert.assertEquals(newEntity.getCostoDeTransporte(), entity.getCostoDeTransporte());
    }
    
     @Test
     public void getVueltaTest(){
         VueltasConDemoraEnOficinaEntity entity = data.get(0);
         VueltasConDemoraEnOficinaEntity newEntity = vueltasConDemoraEnOfcinaPersistence.find(entity.getId());
         Assert.assertNotNull (newEntity);
         Assert.assertEquals(newEntity.getCostoDeTransporte(), entity.getCostoDeTransporte());
         Assert.assertEquals(newEntity.getCostoDuracion(), entity.getCostoDuracion());
     }
    
     // @Test
  // public void getVueltasTest() {
    //    List<VueltasConDemoraEnOficinaEntity> list = vueltasLogic.getVueltas();
      //  Assert.assertEquals(data.size(), list.size());
        //for (VueltasConDemoraEnOficinaEntity entity : list) {
          //  boolean found = false;
            //for (VueltasConDemoraEnOficinaEntity storedEntity : data) {
              //  if (entity.getId().equals(storedEntity.getId())) {
                //    found = true;
                //}
            //}
            //Assert.assertTrue(found);
       // }
    //}
     
     
     @Test
    public void deleteVueltaTest(){
        VueltasConDemoraEnOficinaEntity entity = data.get(0);
        vueltasConDemoraEnOfcinaPersistence.delete(entity.getId());
        VueltasConDemoraEnOficinaEntity deleted = em.find(VueltasConDemoraEnOficinaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updatePayPalTest(){
        VueltasConDemoraEnOficinaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        VueltasConDemoraEnOficinaEntity newEntity = factory.manufacturePojo(VueltasConDemoraEnOficinaEntity.class);
        
        newEntity.setId(entity.getId());
        
        vueltasConDemoraEnOfcinaPersistence.update(newEntity);
        
        VueltasConDemoraEnOficinaEntity resp = em.find(VueltasConDemoraEnOficinaEntity.class, entity.getId());
        
        Assert.assertEquals(newEntity.getCostoDeTransporte(), resp.getCostoDeTransporte());
        Assert.assertEquals(newEntity.getCostoDuracion(), resp.getCostoDuracion());
    }
}
