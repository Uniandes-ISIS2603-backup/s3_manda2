/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

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
        PodamFactory factory = new PodamFactoryImpl();
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
     public void createServicioTest(){
        PodamFactory factory = new PodamFactoryImpl();
        ComprasEnTiendaEntity newEntity = factory.manufacturePojo(ComprasEnTiendaEntity.class);
        ComprasEnTiendaEntity result = comprasEnTiendaPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        ComprasEnTiendaEntity entity = em.find(ComprasEnTiendaEntity.class, result.getId());
        
        
        Assert.assertEquals(newEntity.getCostoDeTransporte(), entity.getCostoDeTransporte());
        
    }
}