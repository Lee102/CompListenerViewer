/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.WorkstationAdditionalData;
import java.util.List;
import org.hibernate.Query;

/**
 * Klasa DAO służąca do obsługi komunikacji z encją workstation_additional_data
 * w bazie danych.
 *
 * @author Łukasz Wojtas
 */
public class WorkstationAdditionalDataDAO extends DAO implements WorkstationAdditionalDataDAOInterface {

    /**
     * Wyszukanie wszystkich obiektów w bazie danych.
     *
     * @return Lista obiektów WorkstationAdditionalData lub null.
     */
    @Override
    public List<WorkstationAdditionalData> getAll() {
        Query query = getSession().createQuery("FROM WorkstationAdditionalData");
        List<WorkstationAdditionalData> workstationAdditionalDataList = query.list();
        return workstationAdditionalDataList;
    }

    /**
     * Usunięcie obiektu z bazy danych.
     *
     * @param workstationAdditionalData Obiekt do usunięcia.
     */
    @Override
    public void delete(WorkstationAdditionalData workstationAdditionalData) {
        getSession().delete(workstationAdditionalData);
    }

    /**
     * Wyszukanie obiektu w bazie danych za pomocą parametru id.
     *
     * @param id Wartość parametru do wyszukiwania.
     * @return Obiekt WorkstationAdditionalData lub null.
     */
    @Override
    public WorkstationAdditionalData findById(Integer id) {
        Query query = getSession().createQuery("FROM WorkstationAdditionalData WHERE id=:id").setParameter("id", id);
        WorkstationAdditionalData workstationAdditionalData = (WorkstationAdditionalData) query.uniqueResult();
        return workstationAdditionalData;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru os_version.
     *
     * @param osVersion Wartość parametru do wyszukiwania.
     * @return Lista obiektów WorkstationAdditionalData lub null.
     */
    @Override
    public List<WorkstationAdditionalData> findByOsVersion(String osVersion) {
        Query query = getSession().createQuery("FROM WorkstationAdditionalData WHERE os_version=:osVersion").setParameter("osVersion", osVersion);
        List<WorkstationAdditionalData> workstationAdditionalDataList = query.list();
        return workstationAdditionalDataList;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru os_arch.
     *
     * @param osArch Wartość parametru do wyszukiwania.
     * @return Lista obiektów WorkstationAdditionalData lub null.
     */
    @Override
    public List<WorkstationAdditionalData> findByOsArch(String osArch) {
        Query query = getSession().createQuery("FROM WorkstationAdditionalData WHERE os_arch=:osArch").setParameter("osArch", osArch);
        List<WorkstationAdditionalData> workstationAdditionalDataList = query.list();
        return workstationAdditionalDataList;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru java_version.
     *
     * @param javaVersion Wartość parametru do wyszukiwania.
     * @return Lista obiektów WorkstationAdditionalData lub null.
     */
    @Override
    public List<WorkstationAdditionalData> findByJavaVersion(String javaVersion) {
        Query query = getSession().createQuery("FROM WorkstationAdditionalData WHERE java_version=:javaVersion").setParameter("javaVersion", javaVersion);
        List<WorkstationAdditionalData> workstationAdditionalDataList = query.list();
        return workstationAdditionalDataList;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru proc_id.
     *
     * @param procId Wartość parametru do wyszukiwania.
     * @return Lista obiektów WorkstationAdditionalData lub null.
     */
    @Override
    public List<WorkstationAdditionalData> findByProcId(String procId) {
        Query query = getSession().createQuery("FROM WorkstationAdditionalData WHERE proc_id=:procId").setParameter("procId", procId);
        List<WorkstationAdditionalData> workstationAdditionalDataList = query.list();
        return workstationAdditionalDataList;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru proc_arch.
     *
     * @param procArch Wartość parametru do wyszukiwania.
     * @return Lista obiektów WorkstationAdditionalData lub null.
     */
    @Override
    public List<WorkstationAdditionalData> findByProcArch(String procArch) {
        Query query = getSession().createQuery("FROM WorkstationAdditionalData WHERE proc_arch=:procArch").setParameter("procArch", procArch);
        List<WorkstationAdditionalData> workstationAdditionalDataList = query.list();
        return workstationAdditionalDataList;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru proc_cores.
     *
     * @param procCores Wartość parametru do wyszukiwania.
     * @return Lista obiektów WorkstationAdditionalData lub null.
     */
    @Override
    public List<WorkstationAdditionalData> findByProcCores(Integer procCores) {
        Query query = getSession().createQuery("FROM WorkstationAdditionalData WHERE proc_cores=:procCores").setParameter("procCores", procCores);
        List<WorkstationAdditionalData> workstationAdditionalDataList = query.list();
        return workstationAdditionalDataList;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru ram_size.
     *
     * @param ramSize Wartość parametru do wyszukiwania.
     * @return Lista obiektów WorkstationAdditionalData lub null.
     */
    @Override
    public List<WorkstationAdditionalData> findByRamSize(Integer ramSize) {
        Query query = getSession().createQuery("FROM WorkstationAdditionalData WHERE ram_size=:ramSize").setParameter("ramSize", ramSize);
        List<WorkstationAdditionalData> workstationAdditionalDataList = query.list();
        return workstationAdditionalDataList;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru disk_size.
     *
     * @param diskSize Wartość parametru do wyszukiwania.
     * @return Lista obiektów WorkstationAdditionalData lub null.
     */
    @Override
    public List<WorkstationAdditionalData> findByDiskSize(Integer diskSize) {
        Query query = getSession().createQuery("FROM WorkstationAdditionalData WHERE disk_size=:diskSize").setParameter("diskSize", diskSize);
        List<WorkstationAdditionalData> workstationAdditionalDataList = query.list();
        return workstationAdditionalDataList;
    }

}
