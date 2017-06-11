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
 *
 * @author Łukasz Wojtas
 */
public class WorkstationDAO extends DAO implements WorkstationDAOInterface {

    @Override
    public List<Workstation> getAll() {
        Query query = getSession().createQuery("FROM Workstation");
        List<Workstation> workstationList = query.list();
        return workstationList;
    }

    @Override
    public void delete(Workstation workstation) {
        getSession().delete(workstation);
    }

    @Override
    public Workstation findById(Integer id) {
        Query query = getSession().createQuery("FROM Workstation WHERE id=:id").setParameter("id", id);
        Workstation workstation = (Workstation) query.uniqueResult();
        return workstation;
    }

    @Override
    public List<Workstation> findByComputerName(String computerName) {
        Query query = getSession().createQuery("FROM Workstation WHERE computer_name=:computerName").setParameter("computerName", computerName);
        List<Workstation> workstationList = query.list();
        return workstationList;
    }

    @Override
    public List<Workstation> findByUserDomain(String userDomain) {
        Query query = getSession().createQuery("FROM Workstation WHERE user_domain=:userDomain").setParameter("userDomain", userDomain);
        List<Workstation> workstationList = query.list();
        return workstationList;
    }

    @Override
    public List<Workstation> findByUserName(String userName) {
        Query query = getSession().createQuery("FROM Workstation WHERE user_name=:userName").setParameter("userName", userName);
        List<Workstation> workstationList = query.list();
        return workstationList;
    }

    @Override
    public List<Workstation> findByMACAddress(String macAddress) {
        Query query = getSession().createQuery("FROM Workstation WHERE mac_address=:macAddress").setParameter("macAddress", macAddress);
        List<Workstation> workstationList = query.list();
        return workstationList;
    }

}
