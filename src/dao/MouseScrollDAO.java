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
 *
 * @author Łukasz Wojtas
 */
public class MouseScrollDAO extends DAO implements MouseScrollDAOInterface {

    @Override
    public List<MouseScroll> getAll() {
        Query query = getSession().createQuery("FROM MouseScroll");
        List<MouseScroll> mouseScrollList = query.list();
        return mouseScrollList;
    }

    @Override
    public void delete(MouseScroll mouseScroll) {
        getSession().delete(mouseScroll);
    }

    @Override
    public MouseScroll findById(Integer id) {
        Query query = getSession().createQuery("FROM MouseScroll WHERE id=:id").setParameter("id", id);
        MouseScroll mouseScroll = (MouseScroll) query.uniqueResult();
        return mouseScroll;
    }

    @Override
    public List<MouseScroll> findByDirection(int direction) {
        Query query = getSession().createQuery("FROM MouseScroll WHERE direction=:direction").setParameter("direction", direction);
        List<MouseScroll> mouseScrollList = query.list();
        return mouseScrollList;
    }

    @Override
    public List<MouseScroll> findByTime(Date time) {
        Query query = getSession().createQuery("FROM MouseScroll WHERE time=:time").setParameter("time", time);
        List<MouseScroll> mouseScrollList = query.list();
        return mouseScrollList;
    }

    @Override
    public List<MouseScroll> findFromTime(Date time) {
        Query query = getSession().createQuery("FROM MouseScroll WHERE time>=:time").setParameter("time", time);
        List<MouseScroll> mouseScrollList = query.list();
        return mouseScrollList;
    }

    @Override
    public List<MouseScroll> findToTime(Date time) {
        Query query = getSession().createQuery("FROM MouseScroll WHERE time<=:time").setParameter("time", time);
        List<MouseScroll> mouseScrollList = query.list();
        return mouseScrollList;
    }

    @Override
    public List<MouseScroll> findBetweenTime(Date timeMin, Date timeMax) {
        Query query = getSession().createQuery("FROM MouseScroll WHERE time>=:timeMin AND time<=:timeMax").setParameter("timeMin", timeMin).setParameter("timeMax", timeMax);
        List<MouseScroll> mouseScrollList = query.list();
        return mouseScrollList;
    }

}
