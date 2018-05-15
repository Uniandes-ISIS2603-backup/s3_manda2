/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

import co.edu.uniandes.csw.manda2.entities.OrganizacionEntity;
import co.edu.uniandes.csw.manda2.entities.OrganizacionEntity;
import co.edu.uniandes.csw.manda2.persistence.OrganizacionPersistence;
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
 * @author cv.trujillo
 */
@RunWith(Arquillian.class)
public class OrganizacionPersistenceTest {
     @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(OrganizacionEntity.class.getPackage())
                .addPackage(OrganizacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml" );
    }
    
     @Inject
    private OrganizacionPersistence OrganizacionPersistence;
    
    @PersistenceContext
    private EntityManager em;
       
    
    
    @Inject
    UserTransaction utx;
    
    private List <OrganizacionEntity> data= new ArrayList<>();
    @Test
    public void createOrganizacionTest(){
        PodamFactory factory = new PodamFactoryImpl();
        OrganizacionEntity newEntity = factory.manufacturePojo(OrganizacionEntity.class);
        OrganizacionEntity result = OrganizacionPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        OrganizacionEntity entity = em.find(OrganizacionEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getCostoDuracion(), entity.getCostoDuracion());
        Assert.assertEquals(newEntity.getCostoTransporte(), entity.getCostoTransporte());

    }
    
     /**
     * Prueba para eliminar un artículo.
     *
     * 
     */
    @Test
    public void deleteOrganizacionTest() {
        OrganizacionEntity entity = data.get(0);
        OrganizacionPersistence.delete(entity.getId());
        OrganizacionEntity deleted = em.find(OrganizacionEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    private void insertData(){
        PodamFactory factory = new PodamFactoryImpl();
        for( int i = 0; i < 3; i++ ){
           OrganizacionEntity organizacion = factory.manufacturePojo(OrganizacionEntity.class);
            
            em.persist(organizacion);
            data.add(organizacion);
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
        em.createQuery("delete from OrganizacionEntity").executeUpdate();
    }
    
     @Test
    public void getOrganizacionsTest(){
        List<OrganizacionEntity> list = OrganizacionPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for( OrganizacionEntity entity : list ){
            boolean found = false;
            for( OrganizacionEntity entity2 : data ){
                if (entity.getId().equals(entity2.getId())){
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getOrganizaciontest(){
        OrganizacionEntity entity = data.get(0);
        OrganizacionEntity newEntity = OrganizacionPersistence.find(entity.getId());
        
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity, entity);
   
    }
    
      @Test
    public void updateOrganizacionTest(){
        OrganizacionEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        OrganizacionEntity newEntity = factory.manufacturePojo(OrganizacionEntity.class);
        
        newEntity.setId(entity.getId());
        
        OrganizacionPersistence.update(newEntity);
        
        OrganizacionEntity resp = em.find(OrganizacionEntity.class, entity.getId());
        
        Assert.assertEquals(newEntity, resp);
    
    
     
    }
}