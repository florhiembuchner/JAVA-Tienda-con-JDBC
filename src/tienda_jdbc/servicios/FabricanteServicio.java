/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_jdbc.servicios;

import tienda_jdbc.entidades.Fabricante;
import tienda_jdbc.persistencia.FabricanteDaoExt;

/**
 *
 * @author Flor Hiembuchner
 */
public class FabricanteServicio {
    
     private FabricanteDaoExt dao;

    public FabricanteServicio() {
        this.dao = new FabricanteDaoExt();
    }

    

    public void crearFabricante(Integer codigo, String nombre) throws Exception {
//falta mejorar

        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            
            if (codigo == null ) {
                throw new Exception("Debe indicar el codigo");
            }
           
            if (buscarFabricantePorCodigo(codigo) != null) {
                throw new Exception("Ya existe un producto con el codigo indicado " + codigo);
            }

            //Creamos el usuario
            Fabricante f= new Fabricante();
            f.setCodigo(codigo);
            f.setNombre(nombre);
            dao.guardarFabricante(f);
        } catch (Exception e) {
            throw e;
        }
    }
    
     public Fabricante buscarFabricantePorCodigo(Integer codigo) throws Exception {

        try {

            //Validamos
            if (codigo == null) {
                throw new Exception("Debe indicar el codigo");
            }

            Fabricante fabricante = dao.buscarFabricantePorCodigo(codigo);

            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }

    
}
