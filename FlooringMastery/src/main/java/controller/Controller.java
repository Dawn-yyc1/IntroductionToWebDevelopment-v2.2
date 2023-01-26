/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.daoException;
import dto.Order;
import ui.view;
import java.util.List;
//import dao.dao;

/**
 *
 * @author pisce
 */
public class controller {
    
    private view view;
//    private dao dao;
    
//    public controller(dao dao, view view) {
//        this.dao = dao;
    public controller(view view){
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
                        displayOrder();
                        break;
                    case 2:
                        addOrder();
                        break;
                    case 3:
                        editOrder();
                        break;
                    case 4:
                        removeOrder();
                        break;
                    case 5:                       
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
            }catch( daoException e){
            view.displayErrorMessage(e.getMessage());
            }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addOrder()throws daoException {
        view.displayCreateOrderBanner();
        Order currentOrder = view.getOrderInfo();
//        dao.addOrder(currentOrder.getTitle().toUpperCase(), currentOrder);
        view.displayCreateSuccessBanner();
    }
    
    private void displayOrder()throws daoException{
        view.displayDisplayAllBanner();
//        List<Dvd> dvdList = dao.getAllDvd();
//        view.displayDvdList(dvdList);
    }
    
    private void editOrder()throws daoException{
        view.displayEditMenuBanner();
//        Dvd editedDvd = view.editDvd();
//        dao.editDvd(editedDvd.getTitle().toUpperCase(), editedDvd);
        view.displayEditSuccessBanner();
    }
    
    private void removeOrder()throws daoException{
        view.displayDeleteBanner();
//        String title = view.getUserInput(); 
//        Dvd deletedDvd = dao.deleteDvd(title);
//        view.displayRemoveResult(deletedDvd);
    }
    
//    private void searchDvd()throws daoException{
//        view.searchDvdBanner();
//        String title = view.getUserInput();
//        Dvd dvd = dao.searchDvd(title);
//        view.displaySearchDvd(dvd);
//    }
    
    private void unknownCommand() {
    view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
    
   
}

