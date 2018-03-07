/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.logic;

import co.edu.uniandes.csw.manda2.ejb.ArticuloLogic;
import co.edu.uniandes.csw.manda2.entities.ArticuloEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
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
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @Articulo cv.trujillo
 */
@RunWith(Arquillian.class)
public class ArticuloLogicTest {

    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private ArticuloLogic articuloLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<ArticuloEntity> data = new ArrayList<ArticuloEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ArticuloEntity.class.getPackage())
                .addPackage(ArticuloLogic.class.getPackage())
                .addPackage(ArticuloPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
     *
     *
     */
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
        em.createQuery("delete from ArticuloEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ArticuloEntity entity = factory.manufacturePojo(ArticuloEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un Articulo
     *
     *
     */
    @Test
    public void createArticuloTest() throws BusinessLogicException {
        ArticuloEntity newEntity = factory.manufacturePojo(ArticuloEntity.class);
        ArticuloEntity result = articuloLogic.createArticulo(newEntity);
        Assert.assertNotNull(result);
        ArticuloEntity entity = em.find(ArticuloEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getNombreArticulo(), entity.getNombreArticulo());
        try {
            articuloLogic.createArticulo(newEntity);
          
        } catch (BusinessLogicException e) {

        }
        try {
            ArticuloEntity newEntity2 = factory.manufacturePojo(ArticuloEntity.class);
            newEntity2.setNombreArticulo(null);
            articuloLogic.createArticulo(newEntity2);
            fail();
        } catch (BusinessLogicException e) {

        }
        
    }

    /**
     * Prueba para actualizar un Pse
     *
     *
     */
    @Test
    public void updateArticuloTest() throws BusinessLogicException {
        ArticuloEntity entity = data.get(0);
        ArticuloEntity pojoEntity = factory.manufacturePojo(ArticuloEntity.class);

        pojoEntity.setId(entity.getId());

        articuloLogic.updateArticulo(pojoEntity.getId(), pojoEntity);

        ArticuloEntity resp = em.find(ArticuloEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNombreArticulo(), resp.getNombreArticulo());
        try {
            articuloLogic.updateArticulo(pojoEntity.getId(), data.get(1));
            fail();
        } catch (BusinessLogicException e) {

        }
        try {

            pojoEntity.setNombreArticulo(null);
            articuloLogic.updateArticulo(pojoEntity.getId(), pojoEntity);
            fail();
        } catch (BusinessLogicException e) {

        }
        try {
            pojoEntity.setNombreArticulo("Pera");
            articuloLogic.updateArticulo(pojoEntity.getId(), pojoEntity);
         
        } catch (BusinessLogicException e) {

        }
    }

    /**
     * Prueba para eliminar un Pse
     *
     *
     */
    @Test
    public void deleteArticuloTest() {
        ArticuloEntity entity = data.get(0);
        articuloLogic.deleteArticulo(entity.getId());
        ArticuloEntity deleted = em.find(ArticuloEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    /**
     * Prueba para consultar la lista de Pses
     *
     *
     */
    @Test
    public void getArticulosTest() {
        List<ArticuloEntity> list = articuloLogic.getArticulos();
        Assert.assertEquals(data.size(), list.size());
        for (ArticuloEntity entity : list) {
            boolean found = false;
            for (ArticuloEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Articulo
     *
     *
     */
    @Test
    public void getArticuloTest() {
        ArticuloEntity entity = data.get(0);
        ArticuloEntity resultEntity = articuloLogic.getArticulo(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getNombreArticulo(), resultEntity.getNombreArticulo());
    }
    
}
