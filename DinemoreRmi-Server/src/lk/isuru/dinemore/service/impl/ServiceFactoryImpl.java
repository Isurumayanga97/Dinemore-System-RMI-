/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.isuru.dinemore.service.impl;

import java.rmi.server.UnicastRemoteObject;
import lk.isuru.dinemore.service.ServiceFactory;
import lk.isuru.dinemore.service.SuperService;
import lk.isuru.dinemore.service.custom.impl.RecepServiceImpl;

/**
 *
 * @author ISURU UMAYANGA
 */
public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory{

   private static ServiceFactory serviceFactory;
  

    public ServiceFactoryImpl()throws Exception{
    }
     public static ServiceFactory getInstance() throws Exception{
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactoryImpl();
        }
        return serviceFactory;
    }
    
    
    @Override
    public SuperService getService(ServiceType serviceType) throws Exception {
       switch(serviceType){
            case BUNS:
                return new RecepServiceImpl();
            default: return null;
        } 
    }
    
}
