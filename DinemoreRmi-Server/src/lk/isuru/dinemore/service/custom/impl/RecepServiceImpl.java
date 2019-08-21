/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.isuru.dinemore.service.custom.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.isuru.dinemore.buisness.BOFactory;
import lk.isuru.dinemore.buisness.custom.RecepBO;
import lk.isuru.dinemore.dto.RecepDTO;
import lk.isuru.dinemore.observer.Observer;
import lk.isuru.dinemore.observer.Subject;
import lk.isuru.dinemore.service.custom.RecepService;

/**
 *
 * @author ISURU UMAYANGA
 */
public class RecepServiceImpl extends UnicastRemoteObject implements RecepService,Subject{

    private RecepBO recepBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();

    public RecepServiceImpl()throws Exception{
        recepBO = (RecepBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.BUNS);
    }
    
    
    
    @Override
    public boolean placeOrder(RecepDTO recepDTO) throws Exception {
        boolean placeOrder = recepBO.placeOrder(recepDTO);
        notifyObservers();
        return placeOrder;
    }

    @Override
    public boolean deleteOrder(String oid) throws Exception {
        boolean deleteCustomer = recepBO.deleteOrder(oid);
        notifyObservers();
        return deleteCustomer;  
    }

    @Override
    public RecepDTO searchOrder(String oid) throws Exception {
        return recepBO.searchOrder(oid);
    }

    @Override
    public boolean updateStatus(RecepDTO recepDTO) throws Exception {
        boolean updateCustomer = recepBO.updateStatus(recepDTO);
        notifyObservers();
        return updateCustomer;
    }

    @Override
    public List<RecepDTO> getAllOrder() throws Exception {
        return recepBO.getAllOrder();
    }

    @Override
    public void registerObserver(Observer observer) throws Exception {
        alObservers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws Exception {
       alObservers.remove(observer);
    }

    @Override
    public void notifyObservers() throws Exception {
        new Thread(()->{
            for (Observer observer : alObservers) {
                try {
                    observer.updateObservers();
                } catch (Exception ex) {
                    Logger.getLogger(RecepServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();   
    }
}
