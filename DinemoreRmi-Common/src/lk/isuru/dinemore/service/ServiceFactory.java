/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.isuru.dinemore.service;

import java.rmi.Remote;

/**
 *
 * @author ISURU UMAYANGA
 */
public interface ServiceFactory extends Remote{
    public enum ServiceType{
        BUNS
    }
    public SuperService getService(ServiceType serviceType) throws Exception;
}
