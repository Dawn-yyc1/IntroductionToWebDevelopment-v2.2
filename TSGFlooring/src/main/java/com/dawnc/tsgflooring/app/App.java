/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.tsgflooring.app;

import com.dawnc.tsgflooring.controller.TsgController;
import com.dawnc.tsgflooring.dao.InvalidInputException;
import com.dawnc.tsgflooring.dao.InvalidOrderDate;
import com.dawnc.tsgflooring.dao.OrderPersistenceException;
import com.dawnc.tsgflooring.dao.TsgDao;
import com.dawnc.tsgflooring.dao.TsgDaoException;
import com.dawnc.tsgflooring.dao.TsgDaoFileImpl;
import com.dawnc.tsgflooring.service.TsgService;
import com.dawnc.tsgflooring.service.TsgServiceImpl;
import com.dawnc.tsgflooring.ui.TsgView;
import com.dawnc.tsgflooring.ui.UserIO;
import com.dawnc.tsgflooring.ui.UserIOConsoleImpl;
import java.io.FileNotFoundException;

/**
 *
 * @author pisce
 */
public class App {
    public static void main(String[] args) throws TsgDaoException, InvalidInputException, FileNotFoundException, OrderPersistenceException, InvalidOrderDate {
            UserIO myIo = new UserIOConsoleImpl();
            TsgView myView = new TsgView(myIo);
            TsgDao myDao = new TsgDaoFileImpl();
            TsgService myService = new TsgServiceImpl(myDao);
            TsgController controller = new TsgController(myView, myService);
            controller.run();

//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Controller controller = ctx.getBean("controller", Controller.class);
//        controller.run();

    }    
}
