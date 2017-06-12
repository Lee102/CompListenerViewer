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
 * Service klasy WorkstationAdditionalDataDAO.
 *
 * @see WorkstationAdditionalDataDAO {@link WorkstationAdditionalDataDAO}
 * @author Łukasz Wojtas
 */
public class WorkstationAdditionalDataService {

    /**
     * Prywatne, statyczne i zainicjowane pole klasy
     * WorkstationAdditionalDataDAO.
     */
    private static WorkstationAdditionalDataDAO workstationAdditionalDataDAO = new WorkstationAdditionalDataDAO();

    /**
     * Wywołanie metody getAll() klasy WorkstationAdditionalDataDAO oraz
     * zarządzanie sesją i transakcją.
     *
     * @return Wartość zwracana z metody klasy WorkstationAdditionalDataDAO.
     */
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

    /**
     * Wywołanie metody delete(...) klasy WorkstationAdditionalDataDAO oraz
     * zarządzanie sesją i transakcją.
     *
     * @param workstationAdditionalData Parametr do metody klasy
     * WorkstationAdditionalDataDAO.
     */
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

    /**
     * Wywołanie metody findById(...) klasy WorkstationAdditionalDataDAO oraz
     * zarządzanie sesją i transakcją.
     *
     * @param id Parametr do metody klasy WorkstationAdditionalDataDAO.
     * @return Wartość zwracana z metody klasy WorkstationAdditionalDataDAO.
     */
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

    /**
     * Wywołanie metody findByOsVersion(...) klasy WorkstationAdditionalDataDAO
     * oraz zarządzanie sesją i transakcją.
     *
     * @param osVersion Parametr do metody klasy WorkstationAdditionalDataDAO.
     * @return Wartość zwracana z metody klasy WorkstationAdditionalDataDAO.
     */
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

    /**
     * Wywołanie metody findByOsArch(...) klasy WorkstationAdditionalDataDAO
     * oraz zarządzanie sesją i transakcją.
     *
     * @param osArch Parametr do metody klasy WorkstationAdditionalDataDAO.
     * @return Wartość zwracana z metody klasy WorkstationAdditionalDataDAO.
     */
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

    /**
     * Wywołanie metody findByJavaVersion(...) klasy
     * WorkstationAdditionalDataDAO oraz zarządzanie sesją i transakcją.
     *
     * @param javaVersion Parametr do metody klasy WorkstationAdditionalDataDAO.
     * @return Wartość zwracana z metody klasy WorkstationAdditionalDataDAO.
     */
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

    /**
     * Wywołanie metody findByProcId(...) klasy WorkstationAdditionalDataDAO
     * oraz zarządzanie sesją i transakcją.
     *
     * @param procId Parametr do metody klasy WorkstationAdditionalDataDAO.
     * @return Wartość zwracana z metody klasy WorkstationAdditionalDataDAO.
     */
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

    /**
     * Wywołanie metody findByProcArch(...) klasy WorkstationAdditionalDataDAO
     * oraz zarządzanie sesją i transakcją.
     *
     * @param procArch Parametr do metody klasy WorkstationAdditionalDataDAO.
     * @return Wartość zwracana z metody klasy WorkstationAdditionalDataDAO.
     */
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

    /**
     * Wywołanie metody findByProcCores(...) klasy WorkstationAdditionalDataDAO
     * oraz zarządzanie sesją i transakcją.
     *
     * @param procCores Parametr do metody klasy WorkstationAdditionalDataDAO.
     * @return Wartość zwracana z metody klasy WorkstationAdditionalDataDAO.
     */
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

    /**
     * Wywołanie metody findByRamSize(...) klasy WorkstationAdditionalDataDAO
     * oraz zarządzanie sesją i transakcją.
     *
     * @param ramSize Parametr do metody klasy WorkstationAdditionalDataDAO.
     * @return Wartość zwracana z metody klasy WorkstationAdditionalDataDAO.
     */
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

    /**
     * Wywołanie metody findByDiskSize(...) klasy WorkstationAdditionalDataDAO
     * oraz zarządzanie sesją i transakcją.
     *
     * @param diskSize Parametr do metody klasy WorkstationAdditionalDataDAO.
     * @return Wartość zwracana z metody klasy WorkstationAdditionalDataDAO.
     */
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
