/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 * ClienteDTO Objeto de transferencia de datos de Cliente. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
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
 *      "id": number,
 *      "nombre": string,
 *      "cedula": string,
 *      "fechaDeIngreso": date,
 *      "calificacion": double,
 *      "pagoAnticipado": boolean,
 *      "horasDeServicioSemanal": number
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
    private boolean pagoAnticipado;
    /**
     * numero que representa las horas de servicio que tiene un cliente semanalmente
     */
    private int horasDeServicioSemanal;
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
    public boolean isPagoAnticipado() {
        return pagoAnticipado;
    }

    /**
     * @param pagoAnticipado the pagoAnticipado to set
     */
    public void setPagoAnticipado(boolean pagoAnticipado) {
        this.pagoAnticipado = pagoAnticipado;
    }

    /**
     * @return the horasDeServicioSemanal
     */
    public int getHorasDeServicioSemanal() {
        return horasDeServicioSemanal;
    }

    /**
     * @param horasDeServicioSemanal the horasDeServicioSemanal to set
     */
    public void setHorasDeServicioSemanal(int horasDeServicioSemanal) {
        this.horasDeServicioSemanal = horasDeServicioSemanal;
    }

}
