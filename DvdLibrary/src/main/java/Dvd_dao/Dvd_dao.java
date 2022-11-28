/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dvd_dao;

import Dvd_dto.Dvd;
import java.util.List;

/**
 *
 * @author pisce
 */
public interface Dvd_dao {
   
   /**
    * 
    * @param title
    * @param dvd
    * @return creates new dvd entry
    * @throws Dvd_daoDaoException 
    */ 
   Dvd addDvd(String title, Dvd dvd)
       throws Dvd_daoDaoException;
   
   /**
    * 
    * @return all dvds in library
    * @throws Dvd_daoDaoException 
    */
   List<Dvd> getAllDvd()
       throws Dvd_daoDaoException; //menu # 4 display Dvd
   
   /**
    * 
    * @param title
    * @return removes dvd by title
    * @throws Dvd_daoDaoException 
    */
   Dvd deleteDvd(String title)
       throws Dvd_daoDaoException;
   
   /**
    * 
    * @param title
    * @return dvd by title
    * @throws Dvd_daoDaoException 
    */
   Dvd searchDvd(String title)
       throws Dvd_daoDaoException;
   
   /*
   *
   *@param title
   *@parm dvd
   *@return  edited dvd 
   *
   */
   Dvd editDvd(String title, Dvd dvd)
       throws Dvd_daoDaoException;

    
}
