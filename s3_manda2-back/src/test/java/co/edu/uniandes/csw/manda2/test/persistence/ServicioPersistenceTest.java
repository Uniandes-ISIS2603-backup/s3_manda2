/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;


import co.edu.uniandes.csw.manda2.entities.ServicioEntity;
import co.edu.uniandes.csw.manda2.persistence.ServicioPersistence;
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
public class ServicioPersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ServicioEntity.class.getPackage())
                .addPackage(ServicioPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml" )
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private ServicioPersistence servicioPersistence;
    
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
        em.createQuery("delete from ServicioEntity").executeUpdate();
    }
    
    private void insertData(){
        PodamFactory factory = new PodamFactoryImpl();
        for( int i = 0; i < 3; i++ ){
            ServicioEntity payPal = factory.manufacturePojo(ServicioEntity.class);
            
            em.persist(payPal);
            data.add(payPal);
        }
    }
    
    private List<ServicioEntity> data = new ArrayList<>();
    
    @Test
    public void createServicioTest(){
        PodamFactory factory = new PodamFactoryImpl();
        ServicioEntity newEntity = factory.manufacturePojo(ServicioEntity.class);
        ServicioEntity result = servicioPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        ServicioEntity entity = em.find(ServicioEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getCalificacion(), entity.getCalificacion());
        Assert.assertEquals(newEntity.getCosto(), entity.getCosto());
        Assert.assertEquals(newEntity.getDescripcion(), entity.getDescripcion());
        Assert.assertEquals(newEntity.getPuntoDeEncuentro(), entity.getPuntoDeEncuentro());
        Assert.assertEquals(newEntity.getPuntoDeRealizacion(), entity.getPuntoDeRealizacion());
    }
    
    @Test
    public void getServiciosTest(){
        List<ServicioEntity> list = servicioPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for( ServicioEntity entity : list ){
            boolean found = false;
            for( ServicioEntity entity2 : data ){
                if (entity.getId().equals(entity2.getId())){
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getServiciotest(){
        ServicioEntity entity = data.get(0);
        ServicioEntity newEntity = servicioPersistence.find(entity.getId());
        
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getCalificacion(), entity.getCalificacion());
        Assert.assertEquals(newEntity.getCosto(), entity.getCosto());
        Assert.assertEquals(newEntity.getDescripcion(), entity.getDescripcion());
        Assert.assertEquals(newEntity.getPuntoDeEncuentro(), entity.getPuntoDeEncuentro());
        Assert.assertEquals(newEntity.getPuntoDeRealizacion(), entity.getPuntoDeRealizacion());
    }
    
    @Test
    public void deleteServicioTest(){
        ServicioEntity entity = data.get(0);
        servicioPersistence.delete(entity.getId());
        ServicioEntity deleted = em.find(ServicioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updateServicioTest(){
        ServicioEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ServicioEntity newEntity = factory.manufacturePojo(ServicioEntity.class);
        
        newEntity.setId(entity.getId());
        
        servicioPersistence.update(newEntity);
        
        ServicioEntity resp = em.find(ServicioEntity.class, entity.getId());
        
        Assert.assertEquals(newEntity.getCalificacion(), resp.getCalificacion());
        Assert.assertEquals(newEntity.getCosto(), resp.getCosto());
        Assert.assertEquals(newEntity.getDescripcion(), resp.getDescripcion());
        Assert.assertEquals(newEntity.getPuntoDeEncuentro(), resp.getPuntoDeEncuentro());
        Assert.assertEquals(newEntity.getPuntoDeRealizacion(), resp.getPuntoDeRealizacion());
    }
}
