/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.test.persistence;

import co.edu.uniandes.csw.manda2.entities.ComprasEnTiendaEntity;
import co.edu.uniandes.csw.manda2.persistence.ComprasEnTiendaPersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

/**
 *
 * @author dv.gonzalez10
 */
@RunWith(Arquillian.class)
public class ComprasEnTiendaPersistenceTest {
    
    
    @Deployment
    public static JavaArchive createDeployement (){
         return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ComprasEnTiendaEntity.class.getPackage())
                .addPackage(ComprasEnTiendaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
               
        
    }
    
    
    @Inject
    private ComprasEnTiendaPersistence vueltasConDemoraEnOfcinaPersistence;
    
    @PersistenceContext
    private EntityManager em;
}
