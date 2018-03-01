/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.ClienteEntity;
import co.edu.uniandes.csw.manda2.persistence.ClientePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author na.caceres
 */
@Stateless
public class ClienteLogic {
    //Constantes
    private static final Logger LOGGER = Logger.getLogger(ClienteLogic.class.getName());
    //Atributos
    @Inject
    private ClientePersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
    /**
     * Devuelve todos los clientes que hay en la base de datos.
     * @return Lista de entidades de tipo cliente.
     */
    public List<ClienteEntity> getClientes() {
        LOGGER.info("Inicia proceso de consultar todas los clientes");
        List<ClienteEntity> clientes = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los clientes");
        return clientes;
    }
    /**
     * Busca un cliente por ID
     * @param id El id del cl  a buscar
     * @return El cliente encontrado, null si no lo encuentra.
     */
    public ClienteEntity getClienteCredito(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar cliente de credito con id={0}", id);
        ClienteEntity cliente = persistence.find(id);
        if (cliente == null) {
            LOGGER.log(Level.SEVERE, "La cliente con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar cliente con id={0}", id);
        return cliente;
    }
    /**
     * Eliminar una cliente
     * @param id El ID del cliente a eliminar
     */
    public void deleteCliente(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar cliente con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar cliente con id={0}", id);
    }
}
