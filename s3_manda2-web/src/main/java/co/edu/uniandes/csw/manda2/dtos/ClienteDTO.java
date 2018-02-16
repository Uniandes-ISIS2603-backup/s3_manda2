/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

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
 *      "nombre": Nicolas Bello,
 *      "cedula": 1020839175,
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
     * numero que representa las horas de servicio que tiene un cliente semanalmente
     */
    private Integer horasDeServicioSemanal;
    
    //Constructor
    /**
     * Constructor por defecto
     */
    public ClienteDTO() {
        super();
        pagoAnticipado = false;
        horasDeServicioSemanal = 0;
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

}
