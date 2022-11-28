/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dvd_controller;

import Dvd_dao.Dvd_daoDaoException;
import Dvd_dao.Dvd_dao;
import Dvd_dao.Dvd_daoFileImpl;
import Dvd_dto.Dvd;
import Dvd_ui.Dvd_UserIOConsoleImpl;
import Dvd_ui.Dvd_view;
import java.util.List;

/**
 *
 * @author pisce
 */
public class Dvd_controller {
    
    private Dvd_view view;
    private Dvd_dao dao;
    
    public Dvd_controller(Dvd_dao dao, Dvd_view view) {
        this.dao = dao;
        this.view = view;
    }
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        addDvd();
                        break;
                    case 2:
                        deleteDvd();
                        break;
                    case 3:
                        editDvd();
                        break;
                    case 4:
                        displayDvd();
                        break;
                    case 5: 
                        searchDvd();
                        break;      
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
            }catch( Dvd_daoDaoException e){
            view.displayErrorMessage(e.getMessage());
            }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addDvd()throws Dvd_daoDaoException {
        view.displayCreateDvdBanner();
        Dvd currentDvd = view.addDvd();
        dao.addDvd(currentDvd.getTitle().toUpperCase(), currentDvd);
        view.displayCreateSuccessBanner();
    }
    
    private void displayDvd()throws Dvd_daoDaoException{
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.getAllDvd();
        view.displayDvdList(dvdList);
    }
    
    private void editDvd()throws Dvd_daoDaoException{
        view.displayEditMenuBanner();
        Dvd editedDvd = view.editDvd();
        dao.editDvd(editedDvd.getTitle().toUpperCase(), editedDvd);
        view.displayEditSuccessBanner();
    }
    
    private void deleteDvd()throws Dvd_daoDaoException{
        view.displayDeleteBanner();
        String title = view.getUserInput(); 
        Dvd deletedDvd = dao.deleteDvd(title);
        view.displayRemoveResult(deletedDvd);
    }
    
    private void searchDvd()throws Dvd_daoDaoException{
        view.searchDvdBanner();
        String title = view.getUserInput();
        Dvd dvd = dao.searchDvd(title);
        view.displaySearchDvd(dvd);
    }
    
    private void unknownCommand() {
    view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
    
   
}

