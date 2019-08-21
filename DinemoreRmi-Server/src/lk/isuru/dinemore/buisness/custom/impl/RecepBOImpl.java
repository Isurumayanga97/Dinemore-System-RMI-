/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.isuru.dinemore.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.isuru.dinemore.buisness.custom.RecepBO;
import lk.isuru.dinemore.dto.RecepDTO;
import lk.isuru.dinemore.entity.Reception;
import lk.isuru.dinemore.repository.RepositoryFactory;
import lk.isuru.dinemore.repository.custom.RecepRepository;
import lk.isuru.dinemore.resourse.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ISURU UMAYANGA
 */
public class RecepBOImpl implements RecepBO{
   
    private RecepRepository recepRepository;

    public RecepBOImpl() {
        recepRepository = (RecepRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.BUNS);
    }

    @Override
    public boolean placeOrder(RecepDTO recepDTO) throws Exception {
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            recepRepository.setSesstion(session);
            session.beginTransaction();
            Reception order = new Reception(
                    recepDTO.getOid(),
                    recepDTO.getRid(),
                    recepDTO.getDate(),
                    recepDTO.getTime(),
                    recepDTO.getCid(),
                    recepDTO.getTpNo(),
                    recepDTO.getQty(),
                    recepDTO.getStatus()
            );
            boolean result = recepRepository.save(order);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean deleteOrder(String oid) throws Exception {
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            recepRepository.setSesstion(session);
            session.beginTransaction();
            Reception orders = recepRepository.findByID(oid);
            boolean result = false;
            if (orders != null) {
                result = recepRepository.delete(orders);
            }
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public RecepDTO searchOrder(String oid) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateStatus(RecepDTO recepDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            recepRepository.setSesstion(session);
            session.beginTransaction();
            Reception orders = new Reception(
                    recepDTO.getOid(),
                    recepDTO.getRid(),
                    recepDTO.getDate(),
                    recepDTO.getTime(),
                    recepDTO.getCid(),
                    recepDTO.getTpNo(),
                    recepDTO.getQty(),
                    recepDTO.getStatus()
            );
            boolean result = recepRepository.update(orders);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public List<RecepDTO> getAllOrder() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            recepRepository.setSesstion(session);
            session.beginTransaction();
            List<Reception> orderses = recepRepository.findAll();
            session.getTransaction().commit();
            if (orderses != null) {
                System.out.println("Not Null");
                List<RecepDTO> alorder = new ArrayList<>();
                for (Reception orders : orderses) {
                    RecepDTO orderDTO = new RecepDTO(
                            orders.getOid(),
                            orders.getRid(),
                            orders.getDate(),
                            orders.getTime(),
                            orders.getCid(),
                            orders.getTpNo(),
                            orders.getQty(),
                            orders.getStatus()
                    );

                    System.out.println("Hello :" + orders.getOid());
                    alorder.add(orderDTO);
                }
                return alorder;
            } else {
                return null;
            }
        }
    }
    
    
}
