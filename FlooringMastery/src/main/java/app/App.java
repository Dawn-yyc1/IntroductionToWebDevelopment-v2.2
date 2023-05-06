/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.Controller;
import dao.daoException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author pisce
 */
public class App {

    public static void main(String[] args) throws daoException {
//        userIO myIo = new userIOConsoleImpl();
//        view myView = new view(myIo);
//        dao myDao = new daoFileImpl();
//        controller controller = new controller(myDao, myView);
//        controller.run();

    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    Controller controller = ctx.getBean("controller", Controller.class);
    controller.run();


    }
}
