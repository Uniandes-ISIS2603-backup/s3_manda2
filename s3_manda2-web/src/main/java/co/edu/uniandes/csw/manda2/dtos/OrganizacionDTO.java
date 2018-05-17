/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.OrganizacionEntity;
import co.edu.uniandes.csw.manda2.entities.ServicioEntity;

/**
 * OrganizacionDTO Servicios de tipo organización. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * <p>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "nombre": String,
 *       "puntoDeEncuentro": String,
 *       "puntoDeRealizacion": String,
 *       "calificacion":Double,
 *       "descripcion": String,
 *       "estado": String,
 *      "costoTransporte": double,
 *      "costoDuracion": double,
 *      "costo":double,
 *
 *      "desplazamiento": Boolean
 *
 *   }
 * </pre> Por ejemplo un servicio de tipo organizacion se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *  "nombre": "Concierto Justin B",
 * "puntoDeEncuentro": "Calle 134#29-93",
 * "puntoDeRealizacion": "Calle 127#69-02",
 * "calificacion": 5,
 * "descripcion": "Quiero una reserva vip",
 * "estado": "En desarrollo",
 * "costoTransporte":25.000,
 * "costoDuracion": 65.000,
 * "costo":100.000,
 * "desplazamiento": true
 *
 *   }
 *
 * </pre>
 *
 * @author cvtrujillo
 */
public class OrganizacionDTO extends ServicioDetailDTO {

    public OrganizacionDTO() {
        //Constructor vacio
    }
    
    public OrganizacionDTO(OrganizacionEntity entityServicio) {
        super();
        if (entityServicio != null) {
            this.nombre = entityServicio.getNombre();
            this.costo = entityServicio.getCosto();
            this.puntoDeEncuentro = entityServicio.getPuntoDeEncuentro();
            this.puntoDeRealizacion = entityServicio.getPuntoDeRealizacion();
            this.calificacion = entityServicio.getCalificacion();
            this.descripcion = entityServicio.getDescripcion();
            this.estado = entityServicio.getEstado();
            this.id = entityServicio.getId();
            this.costoDeDuracion = entityServicio.getCostoDuracion();
            this.costoDeTransporte = entityServicio.getCostoTransporte();
            this.desplazamiento=entityServicio.getDesplazamiento();
            if(entityServicio.getCliente()!=null){
                this.cliente = new ClienteDTO(entityServicio.getCliente());
            }
            if(entityServicio.getEmpleado()!=null){
                this.empleado = new EmpleadoDTO(entityServicio.getEmpleado());
            }
        }
    }

    /**
     * Costo del transporte para hacer el mandado de éste tipo
     */
    protected Double costoDeTransporte;

    /**
     * Costo que se le cobra al usuario, por la duración que se tiene
     * al hacer el servicio.
     */
    protected Double costoDeDuracion;

    /**
     * Representa si es necesario el desplazamiento de uno de nuestros trabajadores
     * con el fin de cumplir con la diligencia. 0
     */
    protected Boolean desplazamiento;

    /**
     * Retorna el costo del transporte del servicio
     *
     * @return costoDeTransporte el costo del transporte.
     */
    public Double getCostoTransporte() {
        return costoDeTransporte;
    }

    /**
     * Retorna el costo de la duración del servicio
     *
     * @return costoDeDuracion retorna el costo de la duracion.
     */
    public Double getCostoDuracion() {
        return costoDeDuracion;
    }

    /**
     * Establecer el costo del trasnporte a cobrar
     *
     * @param costoDeTransporte el costo del transporte
     */
    public void setCostoTransporte(Double costoDeTransporte) {
        this.costoDeTransporte = costoDeTransporte;
    }

    /**
     * Establecer el costo del desplazamiento del servicio
     *
     * @param costoDeDuracion el costo por la duracion.
     */
    public void setCostoDuracion(Double costoDeDuracion) {
        this.costoDeDuracion = costoDeDuracion;
    }

    /**
     * Verifica si el sericio requiere de un desplazamiento
     *
     * @return desplazamiento true si desplazo, false lo contrario
     */
    public Boolean isDesplazamiento() {
        return desplazamiento;
    }

    /**
     * Establecer el desplazamiento, en caso de ser requerido
     *
     * @param desplazamiento a recorer
     */
    public void setDesplazamiento(Boolean desplazamiento) {
        this.desplazamiento = desplazamiento;
    }

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    @Override
    public OrganizacionEntity toEntity() {
        OrganizacionEntity entity = new OrganizacionEntity();
        entity.setId(this.id);
        entity.setNombre(this.nombre);
        entity.setPuntoDeEncuentro(this.puntoDeEncuentro);
        entity.setPuntoDeRealizacion(this.puntoDeRealizacion);
        entity.setCalificacion(this.calificacion);
        entity.setDescripcion(this.descripcion);
        entity.setEstado(this.estado);
        entity.setCostoDuracion(this.costoDeDuracion);
        entity.setCostoTransporte(this.costoDeTransporte);
        entity.setCosto(this.costo);
        entity.setDesplazamiento(this.desplazamiento);
        return entity;
    }
}
