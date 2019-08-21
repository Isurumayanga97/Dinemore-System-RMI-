/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.isuru.dinemore.proxy;

import java.rmi.Naming;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.isuru.dinemore.service.ServiceFactory;
import lk.isuru.dinemore.service.ServiceFactory.ServiceType;
import lk.isuru.dinemore.service.SuperService;
import lk.isuru.dinemore.service.custom.RecepService;

/**
 *
 * @author ISURU UMAYANGA
 */
public class ProxyHandler implements ServiceFactory{
    private static ProxyHandler proxyHandler;
    private RecepService recepService;
    private ServiceFactory serviceFactory;

    
    public ProxyHandler() {
        try {
            serviceFactory = (ServiceFactory) 
                    Naming.lookup("rmi://localhost:5150/POS");
            recepService = (RecepService) 
                    serviceFactory.getService(ServiceType.BUNS);
            
        } catch (Exception ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ProxyHandler getInstance(){
        if (proxyHandler == null) {
            proxyHandler = new ProxyHandler();
        }
        return proxyHandler;
    }

    @Override
    public SuperService getService(ServiceType serviceType) throws Exception {
         switch(serviceType){
            case BUNS: return recepService;
            default: return null;
        }   
    }
    
}
