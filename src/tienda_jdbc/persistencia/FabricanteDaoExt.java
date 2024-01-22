/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_jdbc.persistencia;

import tienda_jdbc.entidades.Fabricante;

/**
 *
 * @author Flor Hiembuchner
 */
public class FabricanteDaoExt extends DAO{
    
    //Guardar
    public void guardarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el Fabricante");
            }

            String sql = "INSERT INTO fabricante (codigo,nombre)"
                    + "VALUES ( '" + fabricante.getCodigo() + "' , '" + fabricante.getNombre() + "' );";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    
    public Fabricante buscarFabricantePorCodigo(Integer cod) throws Exception {
        try {
            String sql = "SELECT * FROM fabricante"
                    + " WHERE codigo = '" + cod+ "'";

            consultarBase(sql);

            Fabricante f = null;
            while (resultado.next()) {
                f = new Fabricante();
                f.setCodigo(resultado.getInt(1));
                f.setNombre(resultado.getString(2));
            }
            desconectarBase();
            return f;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
}
