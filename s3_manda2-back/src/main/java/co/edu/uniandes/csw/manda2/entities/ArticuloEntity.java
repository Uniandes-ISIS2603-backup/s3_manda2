/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author cv.trujillo
 */
@Entity
@PrimaryKeyJoinColumn( referencedColumnName = "id" )
public class ArticuloEntity extends ComprasEnTiendaEntity implements Serializable {
    

    private String rutaImagen;
    /**
     * Nombre del articulo
     * */
    private String nombreArticulo;
      
     // @OneToMany
   // private ArticuloEntity articulo;
    
    /**
     * El precio del articulo
     * */
    private Double precio;
    
    /**
     * Obtener la ruta de la imagen del articulo
     * @return ruta de la imagen
     * */
    public String getRutaImagen()
    {
        return rutaImagen;
    }
    /**
     * Obtener el nombre del articulo
     * @return nombre
     * */
    
    public String getNombreArticulo()
    {
        return nombreArticulo;
    }
    
    /**
     * Obtener el precio del articulo
     * @return precio
     * */
    public Double getPrecio()
    {
        return precio;
    }
    /**
     * Establecer la ruta de la imagen del articulo
     * @param rutaIm nueva ruta 
     * */
    
    public void setRutaImagen(String rutaIm)
    {
        this.rutaImagen=rutaIm;
    }
    
    /**
     *  Establecer  el nombre del articulo
     * @param pNombre nuevo nombre
     * */
    public void setNombreArticulo(String pNombre)
    {
      this.nombreArticulo=pNombre;  
    }
    
    /**
     *  Establecer el precio del articulo
     * @param pPrecio nuevo precio
     * */
    public void setPrecio(Double pPrecio)
    {
        this.precio=pPrecio;
    }
}
