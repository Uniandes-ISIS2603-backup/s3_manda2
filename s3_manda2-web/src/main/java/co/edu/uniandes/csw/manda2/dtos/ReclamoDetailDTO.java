/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.ReclamoEntity;

/**
 *Clase que representa el reclamo. 
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "mensaje": string, 
 *      "numero": number,
 *      "id": number,
 *      "empleado": [
 *          "nombre": string, 
 *          "cedula": string,
 *          "fechaingreso": date,
 *          "calificacion": double,
 *          "id": number,
 *          "identificacion": string,
 *          "foto": string,
 *          "eps: string],
 *      "servicio": [ 
 *          "costoDeDuracion": Double,
 *          "costoDeTransporte": Double,
 *          "porcentajeExtra": Double,
 *          "pago": PagoDTO,
 *          "cliente": ClienteDTO,
 *          "empleado": Empleado DTO,
 *          "id": Long,
 *          "nombre": String,
 *          "costo": Double,
 *          "puntoDeEncuentro": String,
 *          "puntoDeRealizacion": String,
 *          "puntoDeRealizacion": String,
 *          "exitoDiligencia": Boolean,
 *          "calification": Double,
 *          "descripcion": String,]
 * }
 * </pre>
 * Por ejemplo reclamo se representa así:<br>
 * 
 * <pre>
 *      "mensaje": "El servicio se demoro mucho", 
 *      "numero": 1,
 *      "id": 1
 *      "empleado" :[
 *          "nombre": "nicolas_caceres", 
 *          "cedula": "1014563321",
 *          "fechaingreso": date,
 *          "calificacion": 5.0,
 *          "id": 001,
 *          "identificacion": "nicolascaceres001",
 *          "foto": "nicolascaceres.jpg",
 *          "eps: "millossaludprepagada"],
 *      "servicio" :[ 
 *          "costoDeTransporte": 10.000,
 *          "pago": PagoDTO,
 *          "cliente": pedro,
 *          "empleado": Empleado1,
 *          "id": 345,
 *          "nombre": compra1,
 *          "costo": 30.000,
 *          "puntoDeEncuentro":calle 44,
 *          "puntoDeRealizacion": Exito ,
 *          "exitoDiligencia": true,
 *          "calification": 5,
 *          "descripcion": estuvo bien ]
 *      
 * </pre>
 * @author n.bello
 */
public class ReclamoDetailDTO extends ReclamoDTO {
    
    //ATRIBUTOS
    /**
     * Atributo que representa el empleado conectado con el reclamo
     */
    private EmpleadoDTO empleado;
    /**
     * Atributo que representa el servicio conectado con el reclamo
     */
    private ServicioDTO servicio;
    
    //CONSTRUCTOR
    
    /**
     * se general el reclamo 
     */
    public ReclamoDetailDTO()
    {
        super();
        empleado = null;
        servicio = null;
    }

    public ReclamoDetailDTO(ReclamoEntity entity) {
        super(entity);
        empleado = null;
        servicio = null;
    }
    
    //METODOS
    
    /**
     * retorna al empleado del reclamo
     * @return empleado del cual se hace el reclamo
     */
    public EmpleadoDTO getEmpleado() {
        return empleado;
    }
    /**
     * asigna empleado al reclamo
     * @param empleado el empleado del cual se hace el reclamo
     */
    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }
    /**
     * retorna el servicio del reclamo  
     * @return servicio se retorna el servicio del cual se hace el reclamo
     */
    public ServicioDTO getServicio() {
        return servicio;
    }
    /**
     * asigna el servicio al reclamo
     * @param servicio se asigna el servicio al cual se le hace el reclamo
     */
    public void setServicio(ServicioDTO servicio) {
        this.servicio = servicio;
    }
    
}
