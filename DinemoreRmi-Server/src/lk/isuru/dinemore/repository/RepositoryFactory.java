/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.isuru.dinemore.repository;

import lk.isuru.dinemore.repository.custom.impl.RecepRepositoryImpl;

/**
 *
 * @author ISURU UMAYANGA
 */
public class RepositoryFactory {
    public enum RepositoryTypes{
        BUNS
    }
    
    public static RepositoryFactory repositoryFactory;

    public RepositoryFactory() {
    }
    
    public static RepositoryFactory getInstance(){
        if (repositoryFactory == null) {
            repositoryFactory = new RepositoryFactory();
        }
        return repositoryFactory;
    }
    
    public SuperRepository getRepository(RepositoryTypes repositoryTypes){
        
       switch(repositoryTypes){
           case BUNS :
               return new RecepRepositoryImpl();
           default:
               return null;
       }
    }
}
