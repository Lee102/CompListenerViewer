/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.WorkstationAdditionalDataDAO;
import entity.WorkstationAdditionalData;
import java.util.List;

/**
 *
 * @author Łukasz Wojtas
 */
public class WorkstationAdditionalDataService {

    private static WorkstationAdditionalDataDAO workstationAdditionalDataDAO = new WorkstationAdditionalDataDAO();

    public static List<WorkstationAdditionalData> getAll() {
        try {
            workstationAdditionalDataDAO.setSession(SessionTransaction.openSession());
            List<WorkstationAdditionalData> workstationAdditionalDataList = workstationAdditionalDataDAO.getAll();
            SessionTransaction.closeSession(workstationAdditionalDataDAO.getSession());
            return workstationAdditionalDataList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static void delete(WorkstationAdditionalData workstationAdditionalData) {
        try {
            workstationAdditionalDataDAO.setSession(SessionTransaction.openSession());
            workstationAdditionalDataDAO.setTransaction(SessionTransaction.openTransaction(workstationAdditionalDataDAO.getSession()));
            workstationAdditionalDataDAO.delete(workstationAdditionalData);
            SessionTransaction.closeTransaction(workstationAdditionalDataDAO.getTransaction());
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static WorkstationAdditionalData findById(Integer id) {
        try {
            workstationAdditionalDataDAO.setSession(SessionTransaction.openSession());
            WorkstationAdditionalData workstationAdditionalData = workstationAdditionalDataDAO.findById(id);
            SessionTransaction.closeSession(workstationAdditionalDataDAO.getSession());
            return workstationAdditionalData;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static List<WorkstationAdditionalData> findByOsVersion(String osVersion) {
        try {
            workstationAdditionalDataDAO.setSession(SessionTransaction.openSession());
            List<WorkstationAdditionalData> workstationAdditionalData = workstationAdditionalDataDAO.findByOsVersion(osVersion);
            SessionTransaction.closeSession(workstationAdditionalDataDAO.getSession());
            return workstationAdditionalData;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static List<WorkstationAdditionalData> findByOsArch(String osArch) {
        try {
            workstationAdditionalDataDAO.setSession(SessionTransaction.openSession());
            List<WorkstationAdditionalData> workstationAdditionalData = workstationAdditionalDataDAO.findByOsArch(osArch);
            SessionTransaction.closeSession(workstationAdditionalDataDAO.getSession());
            return workstationAdditionalData;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static List<WorkstationAdditionalData> findByJavaVersion(String javaVersion) {
        try {
            workstationAdditionalDataDAO.setSession(SessionTransaction.openSession());
            List<WorkstationAdditionalData> workstationAdditionalData = workstationAdditionalDataDAO.findByJavaVersion(javaVersion);
            SessionTransaction.closeSession(workstationAdditionalDataDAO.getSession());
            return workstationAdditionalData;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static List<WorkstationAdditionalData> findByProcId(String procId) {
        try {
            workstationAdditionalDataDAO.setSession(SessionTransaction.openSession());
            List<WorkstationAdditionalData> workstationAdditionalData = workstationAdditionalDataDAO.findByProcId(procId);
            SessionTransaction.closeSession(workstationAdditionalDataDAO.getSession());
            return workstationAdditionalData;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static List<WorkstationAdditionalData> findByProcArch(String procArch) {
        try {
            workstationAdditionalDataDAO.setSession(SessionTransaction.openSession());
            List<WorkstationAdditionalData> workstationAdditionalData = workstationAdditionalDataDAO.findByProcArch(procArch);
            SessionTransaction.closeSession(workstationAdditionalDataDAO.getSession());
            return workstationAdditionalData;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static List<WorkstationAdditionalData> findByProcCores(Integer procCores) {
        try {
            workstationAdditionalDataDAO.setSession(SessionTransaction.openSession());
            List<WorkstationAdditionalData> workstationAdditionalData = workstationAdditionalDataDAO.findByProcCores(procCores);
            SessionTransaction.closeSession(workstationAdditionalDataDAO.getSession());
            return workstationAdditionalData;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static List<WorkstationAdditionalData> findByRamSize(Integer ramSize) {
        try {
            workstationAdditionalDataDAO.setSession(SessionTransaction.openSession());
            List<WorkstationAdditionalData> workstationAdditionalData = workstationAdditionalDataDAO.findByRamSize(ramSize);
            SessionTransaction.closeSession(workstationAdditionalDataDAO.getSession());
            return workstationAdditionalData;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static List<WorkstationAdditionalData> findByDiskSize(Integer diskSize) {
        try {
            workstationAdditionalDataDAO.setSession(SessionTransaction.openSession());
            List<WorkstationAdditionalData> workstationAdditionalData = workstationAdditionalDataDAO.findByDiskSize(diskSize);
            SessionTransaction.closeSession(workstationAdditionalDataDAO.getSession());
            return workstationAdditionalData;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

}
