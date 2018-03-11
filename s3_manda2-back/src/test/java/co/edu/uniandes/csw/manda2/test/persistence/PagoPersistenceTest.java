/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

import co.edu.uniandes.csw.manda2.entities.PagoEntity;
import co.edu.uniandes.csw.manda2.persistence.PagoPersistence;
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
 * @author m.moreno
 */
@RunWith(Arquillian.class)
public class PagoPersistenceTest {
    
     /**
 +     *
 +     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
 +     * embebido. El jar contiene las clases de Editorial, el descriptor de la
 +     * base de datos y el archivo beans.xml para resolver la inyecciÃ³n de
 +     * dependencias.
 +     */
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PagoEntity.class.getPackage())
                .addPackage(PagoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    
    @Inject
    private PagoPersistence pagoPersistence;
     /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los mÃ©todos que se estÃ¡n probando.
     */
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
      /**
     * ConfiguraciÃ³n inicial de la prueba.
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
     * Limpia las tablas que estÃ¡n implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from EditorialEntity").executeUpdate();
    }

    /**
     * lista que tiene los datos de prueba
     */
    private List<PagoEntity> data = new ArrayList<PagoEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            
            PagoEntity entity = factory.manufacturePojo(PagoEntity.class);

            em.persist(entity);
            
            data.add(entity);
        }
    }

    
  /**
     * Prueba para crear un Pago.
     *
     *
     */
    @Test
    public void createPagoTest() {
        PodamFactory factory = new PodamFactoryImpl();
        PagoEntity newEntity = factory.manufacturePojo(PagoEntity.class);
        PagoEntity result = pagoPersistence.create(newEntity);

        Assert.assertNotNull(result);

        PagoEntity entity = em.find(PagoEntity.class, result.getId());

        Assert.assertEquals(newEntity.getId(), entity.getId());
    }
    /**
     * Prueba para consultar la lista de Pagos.
     *
     * 
     */
    @Test
    public void getPagosTest() {
        List<PagoEntity> list = pagoPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (PagoEntity ent : list) {
            boolean found = false;
            for (PagoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    /**
     * Prueba para consultar un Pago.
     *
     * 
     */
//    @Test
//    public void getPagoTest() {
//        PagoEntity newEntity = data.get(0);
//        PagoEntity resp= pagoPersistence.find(newEntity.getId());
//        Assert.assertNotNull(newEntity);
//        Assert.assertEquals(newEntity.getId(), resp.getId());
//        Assert.assertEquals(newEntity.getFecha(), resp.getFecha());
//        Assert.assertEquals(newEntity.getEstadoTransaccion(), resp.getEstadoTransaccion());
//    }
//   
//    /**
//     * Prueba para eliminar un Pago.
//     *
//     * 
//     */
//    @Test
//    public void deletePagoTest() {
//        PagoEntity entity = data.get(0);
//        pagoPersistence.delete(entity.getId());
//        PagoEntity deleted = em.find(PagoEntity.class, entity.getId());
//        Assert.assertNull(deleted);
//    }
//    /**
//     * Prueba para actualizar un Pago.
//     *
//     * 
//     */
//    @Test
//    public void updatePagoTest() {
//        PagoEntity entity = data.get(0);
//        PodamFactory factory = new PodamFactoryImpl();
//        PagoEntity newEntity = factory.manufacturePojo(PagoEntity.class);
//
//        newEntity.setId(entity.getId());
//
//        pagoPersistence.update(newEntity);
//
//        PagoEntity resp = em.find(PagoEntity.class, entity.getId());
//
//        Assert.assertEquals(newEntity.getId(), resp.getId());
//        Assert.assertEquals(newEntity.getFecha(), resp.getFecha());
//        Assert.assertEquals(newEntity.getEstadoTransaccion(), resp.getEstadoTransaccion());
//    }
}

