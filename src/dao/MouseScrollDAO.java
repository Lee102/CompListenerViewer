/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.MouseScroll;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;

/**
 * Klasa DAO służąca do obsługi komunikacji z encją mouse_scroll w bazie danych.
 *
 * @author Łukasz Wojtas
 */
public class MouseScrollDAO extends DAO implements MouseScrollDAOInterface {

    /**
     * Wyszukanie wszystkich obiektów w bazie danych.
     *
     * @return Lista obiektów MouseScroll lub null.
     */
    @Override
    public List<MouseScroll> getAll() {
        Query query = getSession().createQuery("FROM MouseScroll");
        List<MouseScroll> mouseScrollList = query.list();
        return mouseScrollList;
    }

    /**
     * Usunięcie obiektu z bazy danych.
     *
     * @param mouseScroll Obiekt do usunięcia.
     */
    @Override
    public void delete(MouseScroll mouseScroll) {
        getSession().delete(mouseScroll);
    }

    /**
     * Wyszukanie obiektu w bazie danych za pomocą parametru id.
     *
     * @param id Wartość parametru do wyszukiwania.
     * @return Obiekt MouseScroll lub null.
     */
    @Override
    public MouseScroll findById(Integer id) {
        Query query = getSession().createQuery("FROM MouseScroll WHERE id=:id").setParameter("id", id);
        MouseScroll mouseScroll = (MouseScroll) query.uniqueResult();
        return mouseScroll;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru direction.
     *
     * @param direction Wartość parametru do wyszukiwania.
     * @return Lista obiektów MouseScroll lub null.
     */
    @Override
    public List<MouseScroll> findByDirection(int direction) {
        Query query = getSession().createQuery("FROM MouseScroll WHERE direction=:direction").setParameter("direction", direction);
        List<MouseScroll> mouseScrollList = query.list();
        return mouseScrollList;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru time.
     *
     * @param time Wartość parametru do wyszukiwania.
     * @return Lista obiektów MouseScroll lub null.
     */
    @Override
    public List<MouseScroll> findByTime(Date time) {
        Query query = getSession().createQuery("FROM MouseScroll WHERE time=:time").setParameter("time", time);
        List<MouseScroll> mouseScrollList = query.list();
        return mouseScrollList;
    }

    /**
     * Wyszukanie obiektów w bazie danych gdzie time jest większy lub równy
     * parametrowi.
     *
     * @param time Wartość parametru do wyszukiwania.
     * @return Lista obiektów MouseScroll lub null.
     */
    @Override
    public List<MouseScroll> findFromTime(Date time) {
        Query query = getSession().createQuery("FROM MouseScroll WHERE time>=:time").setParameter("time", time);
        List<MouseScroll> mouseScrollList = query.list();
        return mouseScrollList;
    }

    /**
     * Wyszukanie obiektów w bazie danych gdzie time jest mniejszy lub równy
     * parametrowi.
     *
     * @param time Wartość parametru do wyszukiwania.
     * @return Lista obiektów MouseScroll lub null.
     */
    @Override
    public List<MouseScroll> findToTime(Date time) {
        Query query = getSession().createQuery("FROM MouseScroll WHERE time<=:time").setParameter("time", time);
        List<MouseScroll> mouseScrollList = query.list();
        return mouseScrollList;
    }

    /**
     * Wyszukanie obiektów w bazie danych gdzie time jest w zakresie pomiędzy
     * parametrami.
     *
     * @param timeMin Wartość parametru do wyszukiwania - dolna granica.
     * @param timeMax Wartość parametru do wyszukiwania - górna granica.
     * @return Lista obiektów MouseScroll lub null.
     */
    @Override
    public List<MouseScroll> findBetweenTime(Date timeMin, Date timeMax) {
        Query query = getSession().createQuery("FROM MouseScroll WHERE time>=:timeMin AND time<=:timeMax").setParameter("timeMin", timeMin).setParameter("timeMax", timeMax);
        List<MouseScroll> mouseScrollList = query.list();
        return mouseScrollList;
    }

}
