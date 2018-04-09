/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.logic;

import co.edu.uniandes.csw.manda2.ejb.EntregasDeDocumentosLogic;
import co.edu.uniandes.csw.manda2.entities.EntregasDeDocumentosEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.EntregasDeDocumentosPersistence;
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
public class EntregasDeDocumentosLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private EntregasDeDocumentosLogic entregasDeDocumentosLogic;
     
    @PersistenceContext
    private EntityManager em;
     
    @Inject
    private UserTransaction utx;
     
    private List<EntregasDeDocumentosEntity> data = new ArrayList<EntregasDeDocumentosEntity>();
    
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EntregasDeDocumentosEntity.class.getPackage())
                .addPackage(EntregasDeDocumentosLogic.class.getPackage())
                .addPackage(EntregasDeDocumentosPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    
     @Before
    public void configTest() {
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

    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from BookEntity").executeUpdate();
        em.createQuery("delete from EditorialEntity").executeUpdate();
    }

    
    private void insertData (){
        for (int i = 0; i < 3; i++) {
            EntregasDeDocumentosEntity entity = factory.manufacturePojo(EntregasDeDocumentosEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
      public void createEntregaTest() throws BusinessLogicException
    {
        EntregasDeDocumentosEntity newEntity = factory.manufacturePojo(EntregasDeDocumentosEntity.class);
        EntregasDeDocumentosEntity result = entregasDeDocumentosLogic.createEntrega(newEntity);
        
        Assert.assertNotNull (result);
        
        EntregasDeDocumentosEntity entity = em.find (EntregasDeDocumentosEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getCostoDeTransporte(), entity.getCostoDeTransporte());
        Assert.assertEquals(newEntity.getPorcentajeExtra(), entity.getPorcentajeExtra()); 
   
    }
    
      
    @Test
     public void getEntregaTest(){
       // EntregasDeDocumentosEntity entity = data.get(0);
       // EntregasDeDocumentosEntity newEntity = entregasDeDocumentosLogic.getEntrega(entity.getId());
      //  Assert.assertNotNull (newEntity);
        
        //Assert.assertEquals(newEntity.getCostoDeTransporte(), entity.getCostoDeTransporte());
       // Assert.assertEquals(newEntity.getPorcentajeExtra(), entity.getPorcentajeExtra());
         
     }
     
   @Test
    public void deleteCompraTest() {
        //EntregasDeDocumentosEntity entity = data.get(0);
       // entregasDeDocumentosLogic.deleteEntrega(entity.getId());
       // EntregasDeDocumentosEntity deleted = em.find(EntregasDeDocumentosEntity.class, entity.getId());
       // Assert.assertNull(deleted);
    }
    
   // @Test
    //public void updateEntregaTest(){
      //  EntregasDeDocumentosEntity entity = data.get(0);
        //EntregasDeDocumentosEntity newEntity = factory.manufacturePojo(EntregasDeDocumentosEntity.class);
        
       // newEntity.setId(entity.getId());             
        
      
        //entregasDeDocumentosLogic.updateEntrega(newEntity.getId(), newEntity);
        
        
        //EntregasDeDocumentosEntity resp = em.find(EntregasDeDocumentosEntity.class, entity.getId());
        
       // Assert.assertEquals(newEntity.getCostoDeTransporte(), resp.getCostoDeTransporte());
       // Assert.assertEquals(newEntity.getPorcentajeExtra(), resp.getPorcentajeExtra());
    //}
}
