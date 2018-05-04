/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

import co.edu.uniandes.csw.manda2.entities.ElementoBusquedaReservaEntity;
import co.edu.uniandes.csw.manda2.persistence.ElementoBusquedaReservaPersistence;
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
public class ElementoBusquedaReservaPersistenceTest {
     @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ElementoBusquedaReservaEntity.class.getPackage())
                .addPackage(ElementoBusquedaReservaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml" );
    }
    
     @Inject
    private ElementoBusquedaReservaPersistence ElementoBusquedaReservaPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    
    
    
    @Inject
    UserTransaction utx;
    
    private List <ElementoBusquedaReservaEntity> data= new ArrayList<>();
    @Test
    public void createeElementoReservaTest(){
        PodamFactory factory = new PodamFactoryImpl();
        ElementoBusquedaReservaEntity newEntity = factory.manufacturePojo(ElementoBusquedaReservaEntity.class);
        ElementoBusquedaReservaEntity result = ElementoBusquedaReservaPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        ElementoBusquedaReservaEntity entity = em.find(ElementoBusquedaReservaEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getNombreElementoBusquedaReserva(), entity.getNombreElementoBusquedaReserva());
    }
     /**
     * Prueba para eliminar un elemento búsqueda reserva.
     *
     * 
     */
    @Test
    public void deleteElementoBusquedaReservaTest() {
        ElementoBusquedaReservaEntity entity = data.get(0);
        ElementoBusquedaReservaPersistence.delete(entity.getId());
        ElementoBusquedaReservaEntity deleted = em.find(ElementoBusquedaReservaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    private void insertData(){
        PodamFactory factory = new PodamFactoryImpl();
        for( int i = 0; i < 3; i++ ){
           ElementoBusquedaReservaEntity elemento = factory.manufacturePojo(ElementoBusquedaReservaEntity.class);
            
            em.persist(elemento);
            data.add(elemento);
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
        em.createQuery("delete from ElementoBusquedaReservaEntity").executeUpdate();
    }
    
     @Test
    public void getElementoBusquedaReservasTest(){
        List<ElementoBusquedaReservaEntity> list = ElementoBusquedaReservaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for( ElementoBusquedaReservaEntity entity : list ){
            boolean found = false;
            for( ElementoBusquedaReservaEntity entity2 : data ){
                if (entity.getId().equals(entity2.getId())){
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getElementoBusquedaReservatest(){
        ElementoBusquedaReservaEntity entity = data.get(0);
        ElementoBusquedaReservaEntity newEntity = ElementoBusquedaReservaPersistence.find(entity.getId());
        
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getNombreElementoBusquedaReserva(), entity.getNombreElementoBusquedaReserva());
   
    }
    
      @Test
    public void updateElementoBusquedaReservaTest(){
        ElementoBusquedaReservaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ElementoBusquedaReservaEntity newEntity = factory.manufacturePojo(ElementoBusquedaReservaEntity.class);
        
        newEntity.setId(entity.getId());
        
        ElementoBusquedaReservaPersistence.update(newEntity);
        
        ElementoBusquedaReservaEntity resp = em.find(ElementoBusquedaReservaEntity.class, entity.getId());
        
        Assert.assertEquals(newEntity.getNombreElementoBusquedaReserva(), resp.getNombreElementoBusquedaReserva());
    
    
     
    }
}
