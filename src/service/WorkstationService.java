/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.WorkstationDAO;
import entity.Workstation;
import java.util.List;

/**
 *
 * @author Łukasz Wojtas
 */
public class WorkstationService {
    
    private static WorkstationDAO workstationDAO = new WorkstationDAO();
    
    public static List<Workstation> getAll() {
        try {
            workstationDAO.setSession(SessionTransaction.openSession());
            List<Workstation> workstationList = workstationDAO.getAll();
            SessionTransaction.closeSession(workstationDAO.getSession());
            return workstationList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
    
    public static void delete(Workstation workstation) {
        try {
            workstationDAO.setSession(SessionTransaction.openSession());
            workstationDAO.setTransaction(SessionTransaction.openTransaction(workstationDAO.getSession()));
            workstationDAO.delete(workstation);
            SessionTransaction.closeTransaction(workstationDAO.getTransaction());
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public static Workstation findById(Integer id) {
        try {
            workstationDAO.setSession(SessionTransaction.openSession());
            Workstation workstation = workstationDAO.findById(id);
            SessionTransaction.closeSession(workstationDAO.getSession());
            return workstation;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
    
    public static List<Workstation> findByComputerName(String computerName) {
        try {
            workstationDAO.setSession(SessionTransaction.openSession());
            List<Workstation> workstationList = workstationDAO.findByComputerName(computerName);
            SessionTransaction.closeSession(workstationDAO.getSession());
            return workstationList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
    
    public static List<Workstation> findByUserDomain(String userDomain) {
        try {
            workstationDAO.setSession(SessionTransaction.openSession());
            List<Workstation> workstationList = workstationDAO.findByUserDomain(userDomain);
            SessionTransaction.closeSession(workstationDAO.getSession());
            return workstationList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
    
    public static List<Workstation> findByUserName(String userName) {
        try {
            workstationDAO.setSession(SessionTransaction.openSession());
            List<Workstation> workstationList = workstationDAO.findByUserName(userName);
            SessionTransaction.closeSession(workstationDAO.getSession());
            return workstationList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
    
    public static List<Workstation> findByMACAddress(String macAddress) {
        try {
            workstationDAO.setSession(SessionTransaction.openSession());
            List<Workstation> workstationList = workstationDAO.findByMACAddress(macAddress);
            SessionTransaction.closeSession(workstationDAO.getSession());
            return workstationList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
    
}
