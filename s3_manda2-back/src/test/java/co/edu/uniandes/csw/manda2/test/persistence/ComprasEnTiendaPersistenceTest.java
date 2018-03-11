/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

import co.edu.uniandes.csw.manda2.ejb.ComprasEnTiendaLogic;
import co.edu.uniandes.csw.manda2.entities.ComprasEnTiendaEntity;
import co.edu.uniandes.csw.manda2.persistence.ComprasEnTiendaPersistence;
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
 * @author dv.gonzalez10
 */
@RunWith(Arquillian.class)
public class ComprasEnTiendaPersistenceTest {
    PodamFactory factory = new PodamFactoryImpl();
    
    @Deployment
    public static JavaArchive createDeployement (){
         return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ComprasEnTiendaEntity.class.getPackage())
                .addPackage(ComprasEnTiendaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
               
        
    }
    
    
    @Inject
    private ComprasEnTiendaPersistence comprasEnTiendaPersistence;
    
   // @Inject
    //private ComprasEnTiendaLogic comprasLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    
    private List<ComprasEnTiendaEntity> data = new ArrayList<ComprasEnTiendaEntity>();
    
    
     /**
     * Limpia las tablas que están implicadas en la prueba
     */
     private void clearData() {
        em.createQuery("delete from ComprasEnTiendaEntity").executeUpdate();
    }
    
     private void insertData() {
        
        for (int i = 0; i < 3; i++) {
            ComprasEnTiendaEntity entity = factory.manufacturePojo(ComprasEnTiendaEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
    }
     
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
    
    
    @Test
     public void createCompraTest(){
        PodamFactory factory = new PodamFactoryImpl();
        ComprasEnTiendaEntity newEntity = factory.manufacturePojo(ComprasEnTiendaEntity.class);
        ComprasEnTiendaEntity result = comprasEnTiendaPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        ComprasEnTiendaEntity entity = em.find(ComprasEnTiendaEntity.class, result.getId());
        
        
        Assert.assertEquals(newEntity.getCostoDeTransporte(), entity.getCostoDeTransporte());
        Assert.assertEquals(newEntity.getArticulo(), entity.getArticulo());
        
    }
     
     @Test
     public void getCompraTest(){
         ComprasEnTiendaEntity entity = data.get(0);
         ComprasEnTiendaEntity newEntity = comprasEnTiendaPersistence.find(entity.getId());
         Assert.assertNotNull (newEntity);
         Assert.assertEquals(newEntity.getCostoDeTransporte(), entity.getCostoDeTransporte());
         Assert.assertEquals(newEntity.getArticulo(), entity.getArticulo());
     }
    
     
     @Test
     public void getComprasTest() {
        List<ComprasEnTiendaEntity> list = comprasEnTiendaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ComprasEnTiendaEntity entity : list) {
            boolean found = false;
            for (ComprasEnTiendaEntity storedEntity : data) {
              if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
     
     @Test
    public void deleteCompraTest(){
        ComprasEnTiendaEntity entity = data.get(0);
        comprasEnTiendaPersistence.delete(entity.getId());
        ComprasEnTiendaEntity deleted = em.find(ComprasEnTiendaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updatePayPalTest(){
        ComprasEnTiendaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ComprasEnTiendaEntity newEntity = factory.manufacturePojo(ComprasEnTiendaEntity.class);
        
        newEntity.setId(entity.getId());
        
        comprasEnTiendaPersistence.update(newEntity);
        
        ComprasEnTiendaEntity resp = em.find(ComprasEnTiendaEntity.class, entity.getId());
        
        Assert.assertEquals(newEntity.getArticulo(), resp.getArticulo());
        Assert.assertEquals(newEntity.getCostoDeTransporte(), resp.getCostoDeTransporte());
    }
}