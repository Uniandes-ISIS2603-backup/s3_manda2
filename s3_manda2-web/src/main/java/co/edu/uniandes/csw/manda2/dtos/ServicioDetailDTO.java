/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 * Clase que representa un servicio de la aplicación en detalle.
 * @author da.ramos
 */
public abstract class ServicioDetailDTO extends ServicioDTO{

    /**
     * Constructor del servicio.
     * @param pago pago asociado al servicio
     * @param cliente cliente asociado al servicio
     * @param empleado empleado asociado al servicio
     * @param id id del servicio
     * @param nombre noombre del servicio
     * @param costo costo del servicio
     * @param puntoDeEncuentro punto de encuentro del cliente y empleado
     * @param puntoDeRealizacion punto de realizacion del servicio
     * @param exitoDiligencia indica si la diligencia tuvo o no éxito
     * @param calificacion calificación del servicio.
     * @param descripcion descripción del servicio.
     */
    public ServicioDetailDTO(PagoDTO pago, ClienteDTO cliente, EmpleadoDTO empleado, long id, String nombre, double costo, String puntoDeEncuentro, String puntoDeRealizacion, boolean exitoDiligencia, double calificacion, String descripcion) {
        super(id, nombre, costo, puntoDeEncuentro, puntoDeRealizacion, exitoDiligencia, calificacion, descripcion);
        this.pago = pago;
        this.cliente = cliente;
        this.empleado = empleado;
    }
    
    /**
     * Pago asociado al servicio.
     */
    private PagoDTO pago;
    
    /**
     * Cliente que pide el servicio.
     */
    private ClienteDTO cliente;
    
    /**
     * Empleado que realiza el servicio.
     */
    private EmpleadoDTO empleado;

    /**
     * Retorna el pago del servicio.
     * @return Pago del servicio.
     */
    public PagoDTO getPago() {
        return pago;
    }

    /**
     * Asigna el pago del servicio al dado por parámetro.
     * @param pago Nuevo pago del servicio.
     */
    public void setPago(PagoDTO pago) {
        this.pago = pago;
    }

    /**
     * Retorna el cliente que pide el servicio.
     * @return Cliente que pide el servicio.
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * Asigna el cliente que pide el servicio al dado por parámetro.
     * @param cliente Nuevo cliente que pide el servicio.
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    /**
     * Retorna el empleado que realiza el servicio.
     * @return Empleado que realiza el servicio.
     */
    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    /**
     * Asigna el empleado que realiza el servicio al dado por parámetro.
     * @param empleado Nuevo empleado que realiza el servicio.
     */
    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }
}
