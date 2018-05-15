/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.ClienteEntity;

/**
 * ClienteDTO Objeto de transferencia de datos de Cliente. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor, ademas hereda la clase (@link UsuarioDTO), dirijase a ella para mas
 * informacion.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "nombre": string,
 *      "cedula": string,
 *      "fechaDeIngreso": date,
 *      "calificacion": double,
 *      "pagoAnticipado": boolean,
 *      "horasDeServicioSemanal": number
 *   }
 * </pre> Por ejemplo un cliente se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *      "id": 084156584,
 *      "nombre": "Nicolas Bello",
 *      "cedula": "1020839175",
 *      "fechaDeIngreso": 15/07/06,
 *      "calificacion": 5,
 *      "pagoAnticipado": false,
 *      "horasDeServicioSemanal": 20
 *   }
 *
 * </pre>
 *
 * @author na.caceres
 */
public class ClienteDTO extends UsuarioDTO {

    //Atributos
    /**
     * boolean que representa si un cliente tiene dinero en su billetera virtual
     */
    private Boolean pagoAnticipado;
    /**
     * numero que representa las horas de servicio que tiene un cliente
     * semanalmente
     */
    private Integer horasDeServicioSemanal;

    //Constructor
    /**
     * Constructor por defecto
     */
    public ClienteDTO() {
        super();
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param cliente: Es la entidad que se va a convertir a DTO
     */
    public ClienteDTO(ClienteEntity cliente) {
        super();
        if (cliente != null) {
            this.id = cliente.getId();
            this.nombre = cliente.getNombre();
            this.cedula = cliente.getCedula();
            this.fechaIngreso = cliente.getFechaIngreso();
            this.calificacion = cliente.getCalificacion();
            this.pagoAnticipado = cliente.isPagoAnticipado();
            this.horasDeServicioSemanal = cliente.getHorasDeServicioSemanal();
            this.login = cliente.getLogin();
        }
    }
    //Metodos

    /**
     * @return the pagoAnticipado
     */
    public Boolean isPagoAnticipado() {
        return pagoAnticipado;
    }

    /**
     * @param pagoAnticipado the pagoAnticipado to set
     */
    public void setPagoAnticipado(Boolean pagoAnticipado) {
        this.pagoAnticipado = pagoAnticipado;
    }

    /**
     * @return the horasDeServicioSemanal
     */
    public Integer getHorasDeServicioSemanal() {
        return horasDeServicioSemanal;
    }

    /**
     * @param horasDeServicioSemanal the horasDeServicioSemanal to set
     */
    public void setHorasDeServicioSemanal(Integer horasDeServicioSemanal) {
        this.horasDeServicioSemanal = horasDeServicioSemanal;
    }

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    @Override
    public ClienteEntity toEntity() {
        ClienteEntity entity = new ClienteEntity();
        entity.setId(this.id);
        entity.setNombre(this.nombre);
        entity.setCedula(this.cedula);
        entity.setFechaIngreso(this.fechaIngreso);
        entity.setCalificacion(this.calificacion);
        entity.setPagoAnticipado(this.pagoAnticipado);
        entity.setHorasDeServicioSemanal(this.horasDeServicioSemanal);
        entity.setLogin(this.login);
        return entity;
    }
}
