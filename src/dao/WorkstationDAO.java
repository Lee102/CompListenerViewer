/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Workstation;
import java.util.List;
import org.hibernate.Query;

/**
 * Klasa DAO służąca do obsługi komunikacji z encją workstation w bazie danych.
 *
 * @author Łukasz Wojtas
 */
public class WorkstationDAO extends DAO implements WorkstationDAOInterface {

    /**
     * Wyszukanie wszystkich obiektów w bazie danych.
     *
     * @return Lista obiektów Workstation lub null.
     */
    @Override
    public List<Workstation> getAll() {
        Query query = getSession().createQuery("FROM Workstation");
        List<Workstation> workstationList = query.list();
        return workstationList;
    }

    /**
     * Usunięcie obiektu z bazy danych.
     *
     * @param workstation Obiekt do usunięcia.
     */
    @Override
    public void delete(Workstation workstation) {
        getSession().delete(workstation);
    }

    /**
     * Wyszukanie obiektu w bazie danych za pomocą parametru id.
     *
     * @param id Wartość parametru do wyszukiwania.
     * @return Obiekt Workstation lub null.
     */
    @Override
    public Workstation findById(Integer id) {
        Query query = getSession().createQuery("FROM Workstation WHERE id=:id").setParameter("id", id);
        Workstation workstation = (Workstation) query.uniqueResult();
        return workstation;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru computer_name.
     *
     * @param computerName Wartość parametru do wyszukiwania.
     * @return Lista obiektów Workstation lub null.
     */
    @Override
    public List<Workstation> findByComputerName(String computerName) {
        Query query = getSession().createQuery("FROM Workstation WHERE computer_name=:computerName").setParameter("computerName", computerName);
        List<Workstation> workstationList = query.list();
        return workstationList;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru user_domain.
     *
     * @param userDomain Wartość parametru do wyszukiwania.
     * @return Lista obiektów Workstation lub null.
     */
    @Override
    public List<Workstation> findByUserDomain(String userDomain) {
        Query query = getSession().createQuery("FROM Workstation WHERE user_domain=:userDomain").setParameter("userDomain", userDomain);
        List<Workstation> workstationList = query.list();
        return workstationList;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru user_name.
     *
     * @param userName Wartość parametru do wyszukiwania.
     * @return Lista obiektów Workstation lub null.
     */
    @Override
    public List<Workstation> findByUserName(String userName) {
        Query query = getSession().createQuery("FROM Workstation WHERE user_name=:userName").setParameter("userName", userName);
        List<Workstation> workstationList = query.list();
        return workstationList;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru mac_address.
     *
     * @param macAddress Wartość parametru do wyszukiwania.
     * @return Lista obiektów Workstation lub null.
     */
    @Override
    public List<Workstation> findByMACAddress(String macAddress) {
        Query query = getSession().createQuery("FROM Workstation WHERE mac_address=:macAddress").setParameter("macAddress", macAddress);
        List<Workstation> workstationList = query.list();
        return workstationList;
    }

    /**
     * Wyszukanie obiektu w bazie danych za pomocą wszystkich możliwych
     * parametrów.
     *
     * @param computerName Wartość parametru do wyszukiwania.
     * @param userDomain Wartość parametru do wyszukiwania.
     * @param userName Wartość parametru do wyszukiwania.
     * @param macAddress Wartość parametru do wyszukiwania.
     * @return Lista obiektów Workstation lub null.
     */
    @Override
    public List<Workstation> findByAll(String computerName, String userDomain, String userName, String macAddress) {
        Query query = getSession().createQuery("FROM Workstation WHERE computer_name LIKE :computerName AND user_domain LIKE :userDomain AND user_name LIKE :userName AND mac_address LIKE :macAddress").setParameter("computerName", "%" + computerName + "%").setParameter("userDomain", "%" + userDomain + "%").setParameter("userName", "%" + userName + "%").setParameter("macAddress", "%" + macAddress + "%");
        List<Workstation> workstationList = query.list();
        return workstationList;
    }

}
