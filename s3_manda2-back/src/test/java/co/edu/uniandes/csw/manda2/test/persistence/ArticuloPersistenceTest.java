/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

import co.edu.uniandes.csw.manda2.entities.ArticuloEntity;
import co.edu.uniandes.csw.manda2.entities.ArticuloEntity;
import co.edu.uniandes.csw.manda2.entities.ArticuloEntity;
import co.edu.uniandes.csw.manda2.entities.ArticuloEntity;
import co.edu.uniandes.csw.manda2.entities.ArticuloEntity;
import co.edu.uniandes.csw.manda2.persistence.ArticuloPersistence;
import co.edu.uniandes.csw.manda2.persistence.ArticuloPersistence;
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
@RunWith (Arquillian.class)
public class ArticuloPersistenceTest {
     @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ArticuloEntity.class.getPackage())
                .addPackage(ArticuloPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml" );
    }
    
     @Inject
    private ArticuloPersistence ArticuloPersistence;
    
    @PersistenceContext
    private EntityManager em;
   
    
    @Inject
    UserTransaction utx;
    
    private List <ArticuloEntity> data= new ArrayList<>();
    
    @Test
    public void createArticuloTest(){
        PodamFactory factory = new PodamFactoryImpl();
        ArticuloEntity newEntity = factory.manufacturePojo(ArticuloEntity.class);
        ArticuloEntity result = ArticuloPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        ArticuloEntity entity = em.find(ArticuloEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getNombreArticulo(), entity.getNombreArticulo());
    }
     /**
     * Prueba para eliminar un artículo.
     *
     * 
     */
    @Test
    public void deleteArticuloTest() {
        ArticuloEntity entity = data.get(0);
        ArticuloPersistence.delete(entity.getId());
        ArticuloEntity deleted = em.find(ArticuloEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    private void insertData(){
        PodamFactory factory = new PodamFactoryImpl();
        for( int i = 0; i < 3; i++ ){
           ArticuloEntity articulo = factory.manufacturePojo(ArticuloEntity.class);
            
            em.persist(articulo);
            data.add(articulo);
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
        em.createQuery("delete from ArticuloEntity").executeUpdate();
    }
    
     @Test
    public void getArticulosTest(){
        List<ArticuloEntity> list = ArticuloPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for( ArticuloEntity entity : list ){
            boolean found = false;
            for( ArticuloEntity entity2 : data ){
                if (entity.getId().equals(entity2.getId())){
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getArticulotest(){
        ArticuloEntity entity = data.get(0);
        ArticuloEntity newEntity = ArticuloPersistence.find(entity.getId());
        
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getNombreArticulo(), entity.getNombreArticulo());
   
    }
    
      @Test
    public void updateArticuloTest(){
        ArticuloEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ArticuloEntity newEntity = factory.manufacturePojo(ArticuloEntity.class);
        
        newEntity.setId(entity.getId());
        
        ArticuloPersistence.update(newEntity);
        
        ArticuloEntity resp = em.find(ArticuloEntity.class, entity.getId());
        
        Assert.assertEquals(newEntity.getNombreArticulo(), resp.getNombreArticulo());
    
    
     
    }
}
