/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.isuru.dinemore.controller;

import java.util.List;
import lk.isuru.dinemore.dto.RecepDTO;
import lk.isuru.dinemore.proxy.ProxyHandler;
import lk.isuru.dinemore.service.ServiceFactory;
import lk.isuru.dinemore.service.custom.RecepService;

/**
 *
 * @author ISURU UMAYANGA
 */
public class ChefController {
    
      public static boolean updateCustomer(RecepDTO recepDTO) throws Exception{
          RecepService orderService = (RecepService) ProxyHandler.getInstance()
                        .getService(ServiceFactory.ServiceType.BUNS);
        return orderService.updateStatus(recepDTO);
    }
     
     public static List<RecepDTO> getAllCustomers() throws Exception{
        RecepService orderService = (RecepService) ProxyHandler.getInstance()
                        .getService(ServiceFactory.ServiceType.BUNS);
        return orderService.getAllOrder();
    }
}
