/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.logic;

import co.edu.uniandes.csw.manda2.ejb.OrganizacionLogic;
import co.edu.uniandes.csw.manda2.entities.OrganizacionEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
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
import static org.junit.Assert.fail;
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
public class OrganizacionLogicTest {
   
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private OrganizacionLogic organizacionLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<OrganizacionEntity> data = new ArrayList<OrganizacionEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(OrganizacionEntity.class.getPackage())
                .addPackage(OrganizacionLogic.class.getPackage())
                .addPackage(OrganizacionPersistence.class.getPackage())
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
        em.createQuery("delete from OrganizacionEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            OrganizacionEntity entity = factory.manufacturePojo(OrganizacionEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un Organizacion
     *
     *
     */
    @Test
    public void createOrganizacionTest() throws BusinessLogicException {
        OrganizacionEntity newEntity = factory.manufacturePojo(OrganizacionEntity.class);
        OrganizacionEntity result = organizacionLogic.createOrganizacion(newEntity);
        Assert.assertNotNull(result);
        OrganizacionEntity entity = em.find(OrganizacionEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        try {
            organizacionLogic.createOrganizacion(newEntity);
           
        } catch (BusinessLogicException e) {

        }
       
    }

    /**
     * Prueba para actualizar un Organizacion
     *
     *
     */
    @Test
    public void updateOrganizacionTest() throws BusinessLogicException {
        OrganizacionEntity entity = data.get(0);
        OrganizacionEntity pojoEntity = factory.manufacturePojo(OrganizacionEntity.class);

        pojoEntity.setId(entity.getId());

        organizacionLogic.updateOrganizacion( pojoEntity);

        OrganizacionEntity resp = em.find(OrganizacionEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        try {
            organizacionLogic.updateOrganizacion( data.get(1));
            
        } catch (BusinessLogicException e) {

        }
      
    }

    /**
     * Prueba para eliminar un Organizacion
     *
     *
     */
    @Test
    public void deleteOrganizacionTest() {
        OrganizacionEntity entity = data.get(0);
        organizacionLogic.deleteOrganizacion(entity.getId());
        OrganizacionEntity deleted = em.find(OrganizacionEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    /**
     * Prueba para consultar la lista de Organizaciones
     *
     *
     */
    @Test
    public void getOrganizacionesTest() {
        List<OrganizacionEntity> list = organizacionLogic.getOrganizaciones();
        Assert.assertEquals(data.size(), list.size());
        for (OrganizacionEntity entity : list) {
            boolean found = false;
            for (OrganizacionEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Organizacion
     *
     *
     */
    @Test
    public void getOrganizacionTest() {
        OrganizacionEntity entity = data.get(0);
        OrganizacionEntity resultEntity = organizacionLogic.getOrganizacion(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
    } 
}
