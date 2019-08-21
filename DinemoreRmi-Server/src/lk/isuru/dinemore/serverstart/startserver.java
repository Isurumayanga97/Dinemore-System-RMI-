/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.isuru.dinemore.serverstart;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.isuru.dinemore.service.impl.ServiceFactoryImpl;

/**
 *
 * @author ISURU UMAYANGA
 */
public class startserver {
     public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(5150);
            registry.rebind("POS", ServiceFactoryImpl.getInstance());
            System.out.println("Server Has Been Strated Successfully");
        } catch (Exception ex) {
            Logger.getLogger(startserver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
