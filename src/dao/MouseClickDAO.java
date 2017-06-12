/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.MouseClick;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;

/**
 * Klasa DAO służąca do obsługi komunikacji z encją mouse_click w bazie danych.
 *
 * @author Łukasz Wojtas
 */
public class MouseClickDAO extends DAO implements MouseClickDAOInterface {

    /**
     * Wyszukanie wszystkich obiektów w bazie danych.
     *
     * @return Lista obiektów MouseClick lub null.
     */
    @Override
    public List<MouseClick> getAll() {
        Query query = getSession().createQuery("FROM MouseClick");
        List<MouseClick> mouseClickList = query.list();
        return mouseClickList;
    }

    /**
     * Usunięcie obiektu z bazy danych.
     *
     * @param mouseClick Obiekt do usunięcia.
     */
    @Override
    public void delete(MouseClick mouseClick) {
        getSession().delete(mouseClick);
    }

    /**
     * Wyszukanie obiektu w bazie danych za pomocą parametru id.
     *
     * @param id Wartość parametru do wyszukiwania.
     * @return Obiekt MouseClick lub null.
     */
    @Override
    public MouseClick findById(Integer id) {
        Query query = getSession().createQuery("FROM MouseClick WHERE id=:id").setParameter("id", id);
        MouseClick mouseClick = (MouseClick) query.uniqueResult();
        return mouseClick;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru button.
     *
     * @param button Wartość parametru do wyszukiwania.
     * @return Lista obiektów MouseClick lub null.
     */
    @Override
    public List<MouseClick> findByButton(int button) {
        Query query = getSession().createQuery("FROM MouseClick WHERE button=:button").setParameter("button", button);
        List<MouseClick> mouseClickList = query.list();
        return mouseClickList;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru x.
     *
     * @param x Wartość parametru do wyszukiwania.
     * @return Lista obiektów MouseClick lub null.
     */
    @Override
    public List<MouseClick> findByX(int x) {
        Query query = getSession().createQuery("FROM MouseClick WHERE x=:x").setParameter("x", x);
        List<MouseClick> mouseClickList = query.list();
        return mouseClickList;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru y.
     *
     * @param y Wartość parametru do wyszukiwania.
     * @return Lista obiektów MouseClick lub null.
     */
    @Override
    public List<MouseClick> findByY(int y) {
        Query query = getSession().createQuery("FROM MouseClick WHERE y=:y").setParameter("y", y);
        List<MouseClick> mouseClickList = query.list();
        return mouseClickList;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru time.
     *
     * @param time Wartość parametru do wyszukiwania.
     * @return Lista obiektów MouseClick lub null.
     */
    @Override
    public List<MouseClick> findByTime(Date time) {
        Query query = getSession().createQuery("FROM MouseClick WHERE time=:time").setParameter("time", time);
        List<MouseClick> mouseClickList = query.list();
        return mouseClickList;
    }

    /**
     * Wyszukanie obiektów w bazie danych gdzie time jest większy lub równy
     * parametrowi.
     *
     * @param time Wartość parametru do wyszukiwania.
     * @return Lista obiektów MouseClick lub null.
     */
    @Override
    public List<MouseClick> findFromTime(Date time) {
        Query query = getSession().createQuery("FROM MouseClick WHERE time>=:time").setParameter("time", time);
        List<MouseClick> mouseClickList = query.list();
        return mouseClickList;
    }

    /**
     * Wyszukanie obiektów w bazie danych gdzie time jest mniejszy lub równy
     * parametrowi.
     *
     * @param time Wartość parametru do wyszukiwania.
     * @return Lista obiektów MouseClick lub null.
     */
    @Override
    public List<MouseClick> findToTime(Date time) {
        Query query = getSession().createQuery("FROM MouseClick WHERE time<=:time").setParameter("time", time);
        List<MouseClick> mouseClickList = query.list();
        return mouseClickList;
    }

    /**
     * Wyszukanie obiektów w bazie danych gdzie time jest w zakresie pomiędzy
     * parametrami.
     *
     * @param timeMin Wartość parametru do wyszukiwania - dolna granica.
     * @param timeMax Wartość parametru do wyszukiwania - górna granica.
     * @return Lista obiektów MouseClick lub null.
     */
    @Override
    public List<MouseClick> findBetweenTime(Date timeMin, Date timeMax) {
        Query query = getSession().createQuery("FROM MouseClick WHERE time>=:timeMin AND time<=:timeMax").setParameter("timeMin", timeMin).setParameter("timeMax", timeMax);
        List<MouseClick> mouseClickList = query.list();
        return mouseClickList;
    }

}
