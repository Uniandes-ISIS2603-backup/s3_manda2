/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 *Clase que representa el reclamo. 
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "mensaje": string, 
 *      "numero": number,
 *      "id": number,
 *      "empleado": "EmpleadoDTO",
 *      "servicio": "ServicioDTO"  
 * }
 * </pre>
 * Por ejemplo reclamo se representa así:<br>
 * 
 * <pre>
 *   {
 *      ""mensaje": "El servicio se demoro mucho", 
 *      "numero": 001,
 *      "id": 001,
 *      "empleado"[{ "nombre": "nicolas_caceres", 
 *      "cedula": "1014563321",
 *      "fechaingreso": date,
 *      "calificacion": 5.0,
 *      "id": 001,
 *      "identificacion": "nicolascaceres001",
 *      "foto": "nicolascaceres.jpg",
 *      "eps: "millossaludprepagada"]},
 *      "servicio": [{{"costoduracion": 15000, "costodetransporte": 25000, "pago": "paypal", 
 *      "cliente"[{"id": 001,
 *      "nombre": nicolascaceres,
 *      "cedula": 2104565210,
 *      "fechaDeIngreso": Mayo 21,2017,
 *      "calificacion": 5.0,
 *      "pagoAnticipado": false,
 *      "horasDeServicioSemanal": 5}],
 *      "id":100, "puntodeencuentro": "usaquen", "puntoderealizacion": "usaquen",
 *      "exitodiligencia": true,
 *      "calificacion":5.0, "descripcion": "entregar documentos"}]
 *   }
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
