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
 * Klasa DAO służąca do obsługi komunikacji z encją window w bazie danych.
 *
 * @author Łukasz Wojtas
 */
public class WindowDAO extends DAO implements WindowDAOInterface {

    /**
     * Wyszukanie wszystkich obiektów w bazie danych.
     *
     * @return Lista obiektów Window lub null.
     */
    @Override
    public List<Window> getAll() {
        Query query = getSession().createQuery("FROM Window");
        List<Window> windowList = query.list();
        return windowList;
    }

    /**
     * Usunięcie obiektu z bazy danych.
     *
     * @param window Obiekt do usunięcia.
     */
    @Override
    public void delete(Window window) {
        getSession().delete(window);
    }

    /**
     * Wyszukanie obiektu w bazie danych za pomocą parametru id.
     *
     * @param id Wartość parametru do wyszukiwania.
     * @return Obiekt Window lub null.
     */
    @Override
    public Window findById(Integer id) {
        Query query = getSession().createQuery("FROM Window WHERE id=:id").setParameter("id", id);
        Window window = (Window) query.uniqueResult();
        return window;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru window_title.
     *
     * @param windowTitle Wartość parametru do wyszukiwania.
     * @return Lista obiektów Window lub null.
     */
    @Override
    public List<Window> findByWindowTitle(String windowTitle) {
        Query query = getSession().createQuery("FROM Window WHERE window_title=:windowTitle").setParameter("windowTitle", windowTitle);
        List<Window> windowList = query.list();
        return windowList;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru start_date.
     *
     * @param startDate Wartość parametru do wyszukiwania.
     * @return Lista obiektów Window lub null.
     */
    @Override
    public List<Window> findByStartDate(Date startDate) {
        Query query = getSession().createQuery("FROM Window WHERE start_date=:startDate").setParameter("startDate", startDate);
        List<Window> windowList = query.list();
        return windowList;
    }

    /**
     * Wyszukanie obiektów w bazie danych gdzie start_date jest większy lub
     * równy parametrowi.
     *
     * @param date Wartość parametru do wyszukiwania.
     * @return Lista obiektów Window lub null.
     */
    @Override
    public List<Window> findFromDate(Date date) {
        Query query = getSession().createQuery("FROM Window WHERE start_date>=:date").setParameter("date", date);
        List<Window> windowList = query.list();
        return windowList;
    }

    /**
     * Wyszukanie obiektów w bazie danych gdzie start_date jest mniejszy lub
     * równy parametrowi.
     *
     * @param date Wartość parametru do wyszukiwania.
     * @return Lista obiektów Window lub null.
     */
    @Override
    public List<Window> findToDate(Date date) {
        Query query = getSession().createQuery("FROM Window WHERE start_date<=:date").setParameter("date", date);
        List<Window> windowList = query.list();
        return windowList;
    }

    /**
     * Wyszukanie obiektów w bazie danych gdzie start_date jest w zakresie
     * pomiędzy parametrami.
     *
     * @param dateMin Wartość parametru do wyszukiwania - dolna granica.
     * @param dateMax Wartość parametru do wyszukiwania - górna granica.
     * @return Lista obiektów Window lub null.
     */
    @Override
    public List<Window> findBetweenDate(Date dateMin, Date dateMax) {
        Query query = getSession().createQuery("FROM Window WHERE start_date>=:dateMin AND start_date<=:dateMax").setParameter("dateMin", dateMin).setParameter("dateMax", dateMax);
        List<Window> windowList = query.list();
        return windowList;
    }

    /**
     * Wyszukanie obiektu w bazie danych za pomocą wszystkich możliwych
     * parametrów.
     *
     * @param windowTitle Wartość parametru do wyszukiwania.
     * @param dateMin Wartość parametru do wyszukiwania - dolna granica.
     * @param dateMax Wartość parametru do wyszukiwania - górna granica.
     * @return
     */
    @Override
    public List<Window> findByAll(String windowTitle, Date dateMin, Date dateMax) {
        Query query;
        if (dateMax != null) {
            dateMax.setHours(23);
            dateMax.setMinutes(59);
            dateMax.setSeconds(59);
        }
        if (dateMin != null) {
            if (dateMax != null) {
                query = getSession().createQuery("FROM Window WHERE window_title LIKE :windowTitle AND start_date>=:dateMin AND start_date<=:dateMax").setParameter("windowTitle", "%" + windowTitle + "%").setParameter("dateMin", dateMin).setParameter("dateMax", dateMax);
            } else {
                query = getSession().createQuery("FROM Window WHERE window_title LIKE :windowTitle AND start_date>=:dateMin").setParameter("windowTitle", "%" + windowTitle + "%").setParameter("dateMin", dateMin);
            }
        } else if (dateMax != null) {
            query = getSession().createQuery("FROM Window WHERE window_title LIKE :windowTitle AND start_date<=:dateMax").setParameter("windowTitle", "%" + windowTitle + "%").setParameter("dateMax", dateMax);
        } else {
            query = getSession().createQuery("FROM Window WHERE window_title LIKE :windowTitle").setParameter("windowTitle", "%" + windowTitle + "%");
            
        }
        List<Window> windowList = query.list();
        return windowList;
    }
    
}
