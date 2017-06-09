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
 *
 * @author Łukasz Wojtas
 */
public class KeyboardClickDAO extends DAO implements KeyboardClickDAOInterface {

    @Override
    public List<KeyboardClick> getAll() {
        Query query = getSession().createQuery("FROM KeyboardClick");
        List<KeyboardClick> keyboardClickList = query.list();
        return keyboardClickList;
    }

    @Override
    public void delete(KeyboardClick keyboardClick) {
        getSession().delete(keyboardClick);
    }

    @Override
    public KeyboardClick findById(Integer id) {
        Query query = getSession().createQuery("FROM KeyboardClick WHERE id=:id").setParameter("id", id);
        KeyboardClick keyboardClick = (KeyboardClick) query.uniqueResult();
        return keyboardClick;
    }

    @Override
    public List<KeyboardClick> findByKeyText(String keyText) {
        Query query = getSession().createQuery("FROM KeyboardClick WHERE key_text=:keyText").setParameter("keyText", keyText);
        List<KeyboardClick> keyboardClickList = query.list();
        return keyboardClickList;
    }

    @Override
    public List<KeyboardClick> findByTime(Date time) {
        Query query = getSession().createQuery("FROM KeyboardClick WHERE time=:time").setParameter("time", time);
        List<KeyboardClick> keyboardClickList = query.list();
        return keyboardClickList;
    }

    @Override
    public List<KeyboardClick> findFromTime(Date time) {
        Query query = getSession().createQuery("FROM KeyboardClick WHERE time>=:time").setParameter("time", time);
        List<KeyboardClick> keyboardClickList = query.list();
        return keyboardClickList;
    }

    @Override
    public List<KeyboardClick> findToTime(Date time) {
        Query query = getSession().createQuery("FROM KeyboardClick WHERE time<=:time").setParameter("time", time);
        List<KeyboardClick> keyboardClickList = query.list();
        return keyboardClickList;
    }

    @Override
    public List<KeyboardClick> findBetweenTime(Date timeMin, Date timeMax) {
        Query query = getSession().createQuery("FROM KeyboardClick WHERE time>=:timeMin AND time<=:timeMax").setParameter("timeMin", timeMin).setParameter("timeMax", timeMax);
        List<KeyboardClick> keyboardClickList = query.list();
        return keyboardClickList;
    }

}
