package cn.sdu.edu.middleware.excise2_1.service;

import cn.sdu.edu.middleware.excise2_1.MyServer.MyServicePOA;

/**
 * This class is the implemetation object for your IDL interface.
 *
 * Let the Eclipse complete operations code by choosing 'Add unimplemented methods'.
 */
public class MyServiceServerImpl extends MyServicePOA {

    /**
     * Constructor for MyServiceServerImpl 
     */
    public MyServiceServerImpl() {
    }

    public void operation1(String msg) {
        System.out.println(msg);
    }
}
