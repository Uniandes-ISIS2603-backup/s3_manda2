/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

import co.edu.uniandes.csw.manda2.entities.OrganizacionEntity;
import co.edu.uniandes.csw.manda2.entities.OrganizacionEntity;
import co.edu.uniandes.csw.manda2.persistence.OrganizacionPersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
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
    
    @Inject
    private OrganizacionPersistence organizacionPersistance;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    /**
     * Pruba para crear un servicio de tipo Organización
     * */
    @Test
    public void createOrganizacionTest()
    {
       PodamFactory factory = new PodamFactoryImpl();
        OrganizacionEntity newEntity = factory.manufacturePojo(OrganizacionEntity.class);
        OrganizacionEntity result = organizacionPersistance.create(newEntity);
        //HASTA AQUÍ SOLO LO HE LLAMADO PARA QUE SE CREE, el verde indica que es mi metodo

        Assert.assertNotNull(result);

        OrganizacionEntity entity = em.find(OrganizacionEntity.class, result.getCostoDuracion());
        
        //le pido que me de el registro

        Assert.assertEquals(newEntity.getCostoDuracion(), entity.getCostoDuracion());
     
    }
}