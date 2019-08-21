/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.isuru.dinemore.observer;

import java.rmi.Remote;

/**
 *
 * @author ISURU UMAYANGA
 */
public interface Observer extends Remote{
    public void updateObservers() throws Exception;
}
