/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

import co.edu.uniandes.csw.manda2.entities.PSEEntity;
import co.edu.uniandes.csw.manda2.persistence.PSEPersistence;
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
 * @author na.caceres
 */
@RunWith(Arquillian.class)
public class PSEPersistenceTest {
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Editorial, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PSEEntity.class.getPackage())
                .addPackage(PSEPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    /**
     * Inyección de la dependencia a la clase EditorialPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private PSEPersistence PSEPersistence;

    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;
    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;

    /**
     * Configuración inicial de la prueba.
     *
     *
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
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
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }

    /**
     * lista que tiene los datos de prueba
     */
    private List<PSEEntity> data = new ArrayList<PSEEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            
            PSEEntity entity = factory.manufacturePojo(PSEEntity.class);

            em.persist(entity);
            
            data.add(entity);
        }
    }
    /**
     * Prueba para crear un Editorial.
     *
     *
     */
    @Test
    public void createPSETest() {
        PodamFactory factory = new PodamFactoryImpl();
        PSEEntity newEntity = factory.manufacturePojo(PSEEntity.class);
        PSEEntity result = PSEPersistence.create(newEntity);

        Assert.assertNotNull(result);

        PSEEntity entity = em.find(PSEEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }
     /**
     * Prueba para consultar la lista de PSEs.
     *
     * 
     */
    @Test
    public void getPSEsTest() {
        List<PSEEntity> list = PSEPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (PSEEntity ent : list) {
            boolean found = false;
            for (PSEEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    /**
     * Prueba para consultar un pse.
     *
     * 
     */
    @Test
    public void getPSETest() {
        PSEEntity entity = data.get(0);
        PSEEntity newEntity = PSEPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getLinkPse(), newEntity.getLinkPse());
    }
    /**
     * Prueba para consultar un pse.
     *
     * 
     */
    @Test
    public void getPSEByLinkTest() {
        PSEEntity entity = data.get(0);
        PSEEntity newEntity = PSEPersistence.findByLink(entity.getLinkPse());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getLinkPse(), newEntity.getLinkPse());
    }
    /**
     * Prueba para eliminar un pse.
     *
     * 
     */
    @Test
    public void deletePSETest() {
        PSEEntity entity = data.get(0);
        PSEPersistence.delete(entity.getId());
        PSEEntity deleted = em.find(PSEEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    /**
     * Prueba para actualizar un PSE.
     *
     * 
     */
    @Test
    public void updatePSETest() {
        PSEEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        PSEEntity newEntity = factory.manufacturePojo(PSEEntity.class);

        newEntity.setId(entity.getId());

        PSEPersistence.update(newEntity);

        PSEEntity resp = em.find(PSEEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getLinkPse(), resp.getLinkPse());
    }
}
