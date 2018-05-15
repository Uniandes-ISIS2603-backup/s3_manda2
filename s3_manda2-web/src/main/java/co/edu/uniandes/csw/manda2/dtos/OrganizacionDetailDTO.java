package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.OrganizacionEntity;
import co.edu.uniandes.csw.manda2.entities.ServicioEntity;

import java.util.ArrayList;
import java.util.List;

public class OrganizacionDetailDTO extends OrganizacionDTO {

    /**
     * Servicio por el que se realiza el Organizacion
     */
    private ServicioDTO servicio;

    /**
     *  de Organizacion para realizar la transaccion
     */
    private OrganizacionDTO Organizacion;

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de ciudad a partir de la cual se construye el
     * objeto
     */
    public OrganizacionDetailDTO (OrganizacionEntity entity){
        super(entity);

        if(entity !=  null){
            if(entity.getOrganizacion()!= null){
                this.Organizacion = new OrganizacionDTO(entity.getOrganizacion());
            }
        }


    }

    public OrganizacionDetailDTO()
    {
        super();
    }
    /**
     * Retorna el servicio relacionado al Organizacion.
     * @return servicio relacionado al Organizacion.
     */
    public ServicioDTO getServicio(){
        return servicio;
    }
    /**
     * Asigna el servicio por el que se realiza Organizacion.
     * @param pServicio servicio por el que se realiza Organizacion.
     */
    public void setServicio(ServicioDTO pServicio){
        this.servicio = pServicio;
    }

    /**
     * Retorna el  de Organizacion con el que se realiza el Organizacion.
     * @return  de Organizacion con el que se realiza el Organizacion.
     */
    public OrganizacionDTO getOrganizacion(){
        return Organizacion;
    }
    /**
     * Asigna el  de Organizacion con el que se realiza la transaccion.
     * @param pOrganizacion con el que se realiza el Organizacion.
     */
    public void setOrganizacion(OrganizacionDTO pOrganizacion){
        this.Organizacion = pOrganizacion;
    }
    /**
     * Transformar un DTO a un Entity
     *
     * @return La entidad construida a partir del DTO.
     */
    @Override
    public OrganizacionEntity toEntity() {
        OrganizacionEntity OrganizacionE = super.toEntity();
        if (Organizacion != null) {
            OrganizacionE.setOrganizacion(Organizacion.toEntity());
        }
        return OrganizacionE;
    }

}
