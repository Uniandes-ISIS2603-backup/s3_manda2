/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

import co.edu.uniandes.csw.manda2.entities.EntregasDeDocumentosEntity;
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
public class EntregasDeDocumentosPersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployment (){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EntregasDeDocumentosEntity.class.getPackage())
                .addPackage(EntregasDeDocumentosPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    
    @Inject
    private EntregasDeDocumentosPersistence entregasDeDocumentosPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    
    @Inject
    UserTransaction utx;
    
        private List<EntregasDeDocumentosEntity> data = new ArrayList<EntregasDeDocumentosEntity>();
    
    
     /**
     * Limpia las tablas que están implicadas en la prueba
     */
     private void clearData() {
        em.createQuery("delete from EntregasDeDocumentosEntity").executeUpdate();
    }
     
     private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            EntregasDeDocumentosEntity entity = factory.manufacturePojo(EntregasDeDocumentosEntity.class);
            
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
     public void createServicioTest(){
        PodamFactory factory = new PodamFactoryImpl();
        EntregasDeDocumentosEntity newEntity = factory.manufacturePojo(EntregasDeDocumentosEntity.class);
        EntregasDeDocumentosEntity result = entregasDeDocumentosPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        EntregasDeDocumentosEntity entity = em.find(EntregasDeDocumentosEntity.class, result.getId());
        
         Assert.assertEquals(newEntity.getCostoDeTransporte(), entity.getCostoDeTransporte());
          Assert.assertEquals(newEntity.getPorcentajeExtra(), entity.getPorcentajeExtra());
    }
}
