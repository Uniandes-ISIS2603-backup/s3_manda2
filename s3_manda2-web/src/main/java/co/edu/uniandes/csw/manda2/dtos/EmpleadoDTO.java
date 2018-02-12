/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 *
 * @author n.bello
 */
public class EmpleadoDTO implements UsuarioDTO{
    //ATRIBUTOS
    /**
     * Atributo que identifica a un empleado
     */
    private String identificacion;
    /**
     * Atributo que muestra la foto del empleado
     */
    private ArticuloDTO  foto;
    /**
     * Atributo quemuestra la EPS a la que esta afiliado el empleado
     */
    private String EPS;
    //CONSTRUCTOR
    /**
     * Genera un empleado
     * @param pIdentificacion
     * @param pFoto
     * @param pEPS 
     */
    public EmpleadoDTO(String pIdentificacion,ArticuloDTO pFoto, String pEPS)
    {
        identificacion = pIdentificacion;
        foto = pFoto;
        EPS = pEPS;
    }
    //METODOS
     /**
     * retorna la identificacion del empleado
     * @return identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }
    /**
     * asigna la identificacion al empleado 
     * @param identificacion
     **/
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    /**
     * retorna la foto del empleado
     * @return foto
     */
    public ArticuloDTO getFoto() {
        return foto;
    }
     /**
     * asigna la foto al empleado 
     * @param foto
     **/
    public void setFoto(ArticuloDTO foto) {
        this.foto = foto;
    }
    /**
     * retorna la EPS del empleado
     * @return EPS
     */
    public String getEPS() {
        return EPS;
    }
     /**
     * asigna la EPS al empleado 
     * @param EPS
     **/
    public void setEPS(String EPS) {
        this.EPS = EPS;
    }
    
}
