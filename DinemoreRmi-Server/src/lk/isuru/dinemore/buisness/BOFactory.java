/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.isuru.dinemore.buisness;

import lk.isuru.dinemore.buisness.custom.impl.RecepBOImpl;

/**
 *
 * @author ISURU UMAYANGA
 */
public class BOFactory {
    public enum BOTypes{
        BUNS
    }
    
    private static BOFactory bOFactory;

    public BOFactory() {
    }
    
    public static BOFactory getInstance(){
        if (bOFactory == null) {
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }
    
    public SuperBO getBO(BOTypes bOTypes){
        switch(bOTypes){
            case BUNS: 
                return new RecepBOImpl();
            default: return null;
        }
    }
}
