/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Window;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Łukasz Wojtas
 */
public class WindowDAO extends DAO implements WindowDAOInterface {

    @Override
    public List<Window> getAll() {
        Query query = getSession().createQuery("FROM Workstation");
        List<Window> windowList = query.list();
        return windowList;
    }

    @Override
    public void delete(Window window) {
        getSession().delete(window);
    }

    @Override
    public Window findById(Integer id) {
        Query query = getSession().createQuery("FROM Window WHERE id=:id").setParameter("id", id);
        Window window = (Window) query.uniqueResult();
        return window;
    }

    @Override
    public List<Window> findByStartDate(Date startDate) {
        Query query = getSession().createQuery("FROM Window WHERE start_date=:startDate").setParameter("startDate", startDate);
        List<Window> windowList = query.list();
        return windowList;
    }

    @Override
    public List<Window> findFromDate(Date date) {
        Query query = getSession().createQuery("FROM Window WHERE start_date>=:date").setParameter("date", date);
        List<Window> windowList = query.list();
        return windowList;
    }

    @Override
    public List<Window> findToDate(Date date) {
        Query query = getSession().createQuery("FROM Window WHERE start_date<=:date").setParameter("date", date);
        List<Window> windowList = query.list();
        return windowList;
    }

    @Override
    public List<Window> findBetweenDate(Date dateMin, Date dateMax) {
        Query query = getSession().createQuery("FROM Window WHERE start_date>=:dateMin AND start_date<=:dateMax").setParameter("dateMin", dateMin).setParameter("dateMax", dateMax);
        List<Window> windowList = query.list();
        return windowList;
    }

    @Override
    public List<Window> findByWindowTitle(String windowTitle) {
        Query query = getSession().createQuery("FROM Window WHERE window_title=:windowTitle").setParameter("windowTitle", windowTitle);
        List<Window> windowList = query.list();
        return windowList;
    }

}
