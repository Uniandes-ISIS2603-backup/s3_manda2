/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.logic;

import co.edu.uniandes.csw.manda2.ejb.ComprasEnTiendaLogic;
import co.edu.uniandes.csw.manda2.entities.ComprasEnTiendaEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
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
public class ComprasEnTiendaLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();
    
     @Inject
    private ComprasEnTiendaLogic comprasEnTiendaLogic;
     
     @PersistenceContext
    private EntityManager em;
     
     @Inject
    private UserTransaction utx;
     
    private List<ComprasEnTiendaEntity> data = new ArrayList<ComprasEnTiendaEntity>();
    
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ComprasEnTiendaEntity.class.getPackage())
                .addPackage(ComprasEnTiendaLogic.class.getPackage())
                .addPackage(ComprasEnTiendaPersistence.class.getPackage())
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
        em.createQuery("delete from ComprasEnTiendaEntity").executeUpdate();
    }

    /**
     * Inserta información a las tablas
     */
    private void insertData (){
        for (int i = 0; i < 3; i++) {
            ComprasEnTiendaEntity entity = factory.manufacturePojo(ComprasEnTiendaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    
    /**
     * Test del meotdo  crear una compra
     * @throws BusinessLogicException 
     */
    @Test
    public void createCompraTest() throws BusinessLogicException
    {
        ComprasEnTiendaEntity newEntity = factory.manufacturePojo(ComprasEnTiendaEntity.class);
        ComprasEnTiendaEntity result = comprasEnTiendaLogic.createCompra(newEntity);
        
        Assert.assertNotNull (result);
        
        ComprasEnTiendaEntity entity = em.find (ComprasEnTiendaEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getArticulo(), entity.getArticulo());
        Assert.assertEquals(newEntity.getCostoDeTransporte(), entity.getCostoDeTransporte());
        
   
    }
    /**
     * prueba borrar el metodo delete de una commpra
     */
    @Test
    public void deleteCompraTest() {
        ComprasEnTiendaEntity entity = data.get(0);
        comprasEnTiendaLogic.deleteCompra(entity.getId());
        ComprasEnTiendaEntity deleted = em.find(ComprasEnTiendaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
     public void getCompraTest(){
         ComprasEnTiendaEntity entity = data.get(0);
         ComprasEnTiendaEntity newEntity = comprasEnTiendaLogic.getCompra(entity.getId());
         Assert.assertNotNull (newEntity);
         Assert.assertEquals(newEntity.getCostoDeTransporte(), entity.getCostoDeTransporte());
         Assert.assertEquals(newEntity.getArticulo(), entity.getArticulo());
     }
     
    @Test 
    public void getComprasTest(){
        
    }
}
