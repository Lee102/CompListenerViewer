/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.KeyboardClick;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;

/**
 * Klasa DAO służąca do obsługi komunikacji z encją keyboard_click w bazie
 * danych.
 *
 * @author Łukasz Wojtas
 */
public class KeyboardClickDAO extends DAO implements KeyboardClickDAOInterface {

    /**
     * Wyszukanie wszystkich obiektów w bazie danych.
     *
     * @return Lista obiektów KeyboardClick lub null.
     */
    @Override
    public List<KeyboardClick> getAll() {
        Query query = getSession().createQuery("FROM KeyboardClick");
        List<KeyboardClick> keyboardClickList = query.list();
        return keyboardClickList;
    }

    /**
     * Usunięcie obiektu z bazy danych.
     *
     * @param keyboardClick Obiekt do usunięcia.
     */
    @Override
    public void delete(KeyboardClick keyboardClick) {
        getSession().delete(keyboardClick);
    }

    /**
     * Wyszukanie obiektu w bazie danych za pomocą parametru id.
     *
     * @param id Wartość parametru do wyszukiwania.
     * @return Obiekt KeyboardClick lub null.
     */
    @Override
    public KeyboardClick findById(Integer id) {
        Query query = getSession().createQuery("FROM KeyboardClick WHERE id=:id").setParameter("id", id);
        KeyboardClick keyboardClick = (KeyboardClick) query.uniqueResult();
        return keyboardClick;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru key_text.
     *
     * @param keyText Wartość parametru do wyszukiwania.
     * @return Lista obiektów KeyboardClick lub null.
     */
    @Override
    public List<KeyboardClick> findByKeyText(String keyText) {
        Query query = getSession().createQuery("FROM KeyboardClick WHERE key_text=:keyText").setParameter("keyText", keyText);
        List<KeyboardClick> keyboardClickList = query.list();
        return keyboardClickList;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru time.
     *
     * @param time Wartość parametru do wyszukiwania.
     * @return Lista obiektów KeyboardClick lub null.
     */
    @Override
    public List<KeyboardClick> findByTime(Date time) {
        Query query = getSession().createQuery("FROM KeyboardClick WHERE time=:time").setParameter("time", time);
        List<KeyboardClick> keyboardClickList = query.list();
        return keyboardClickList;
    }

    /**
     * Wyszukanie obiektów w bazie danych gdzie time jest większy lub równy
     * parametrowi.
     *
     * @param time Wartość parametru do wyszukiwania.
     * @return Lista obiektów KeyboardClick lub null.
     */
    @Override
    public List<KeyboardClick> findFromTime(Date time) {
        Query query = getSession().createQuery("FROM KeyboardClick WHERE time>=:time").setParameter("time", time);
        List<KeyboardClick> keyboardClickList = query.list();
        return keyboardClickList;
    }

    /**
     * Wyszukanie obiektów w bazie danych gdzie time jest mniejszy lub równy
     * parametrowi.
     *
     * @param time Wartość parametru do wyszukiwania.
     * @return Lista obiektów KeyboardClick lub null.
     */
    @Override
    public List<KeyboardClick> findToTime(Date time) {
        Query query = getSession().createQuery("FROM KeyboardClick WHERE time<=:time").setParameter("time", time);
        List<KeyboardClick> keyboardClickList = query.list();
        return keyboardClickList;
    }

    /**
     * Wyszukanie obiektów w bazie danych gdzie time jest w zakresie pomiędzy
     * parametrami.
     *
     * @param timeMin Wartość parametru do wyszukiwania - dolna granica.
     * @param timeMax Wartość parametru do wyszukiwania - górna granica.
     * @return Lista obiektów KeyboardClick lub null.
     */
    @Override
    public List<KeyboardClick> findBetweenTime(Date timeMin, Date timeMax) {
        Query query = getSession().createQuery("FROM KeyboardClick WHERE time>=:timeMin AND time<=:timeMax").setParameter("timeMin", timeMin).setParameter("timeMax", timeMax);
        List<KeyboardClick> keyboardClickList = query.list();
        return keyboardClickList;
    }

}
