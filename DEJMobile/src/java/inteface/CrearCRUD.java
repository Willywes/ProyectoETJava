/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inteface;

import java.util.List;

/**
 *
 * @author Willywes
 * @param <Objeto>
 */
public interface CrearCRUD <Objeto> {
    
    ////////////////////////////////////////////
    //  CRUD!!!
    ////////////////////////////////////////////
    
    public boolean create(Objeto o);
    public boolean delete(Object key);
    public boolean update(Objeto o);
    public Objeto read(Object key);
    public List<Objeto> readAll();
}
