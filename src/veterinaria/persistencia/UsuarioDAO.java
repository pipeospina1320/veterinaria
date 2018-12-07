/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria.persistencia;

import entidades.UsuarioEn;

public class UsuarioDAO {
    
    public UsuarioDAO() {
    }
    
    public boolean guardarUsuario(UsuarioEn us) {
        boolean result = true;
//        result = UsuarioHelper.anadirArchivo(us);
        return result;
    }
    
    public UsuarioEn buscarUsuario(String doc) {
        UsuarioEn us = UsuarioHelper.buscar(doc);
        
        return us;
    }
}
