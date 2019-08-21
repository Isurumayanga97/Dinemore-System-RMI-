/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.isuru.dinemore.service.custom;

import java.util.List;
import lk.isuru.dinemore.dto.RecepDTO;
import lk.isuru.dinemore.service.SuperService;

/**
 *
 * @author ISURU UMAYANGA
 */
public interface RecepService extends SuperService{
   public boolean placeOrder(RecepDTO recepDTO)throws Exception;
   
    public boolean deleteOrder(String oid) throws Exception;
    
    public RecepDTO searchOrder(String oid) throws Exception;
    
    public boolean updateStatus(RecepDTO recepDTO) throws Exception;
    
    public List<RecepDTO> getAllOrder() throws Exception;
}
