/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.dvdlibrary;

import Dvd_controller.Dvd_controller;
import Dvd_dao.Dvd_dao;
import Dvd_dao.Dvd_daoDaoException;
import Dvd_dao.Dvd_daoFileImpl;
import Dvd_ui.Dvd_UserIO;
import Dvd_ui.Dvd_UserIOConsoleImpl;
import Dvd_ui.Dvd_view;

/**
 *
 * @author pisce
 */
public class App {

    public static void main(String[] args) throws Dvd_daoDaoException {
        Dvd_UserIO myIo = new Dvd_UserIOConsoleImpl();
        Dvd_view myView = new Dvd_view(myIo);
        Dvd_dao myDao = new Dvd_daoFileImpl();
        Dvd_controller controller = new Dvd_controller(myDao, myView);
        controller.run();
    }
}
