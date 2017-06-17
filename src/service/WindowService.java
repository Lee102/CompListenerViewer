/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.WindowDAO;
import entity.Window;
import java.util.Date;
import java.util.List;

/**
 * Service klasy WindowDAO.
 *
 * @see WindowDAO {@link WindowDAO}
 * @author Łukasz Wojtas
 */
public class WindowService {

    /**
     * Prywatne, statyczne i zainicjowane pole klasy WindowDAO.
     */
    private static WindowDAO windowDAO = new WindowDAO();

    /**
     * Wywołanie metody getAll() klasy WindowDAO oraz zarządzanie sesją i
     * transakcją.
     *
     * @return Wartość zwracana z metody klasy WindowDAO.
     */
    public static List<Window> getAll() {
        try {
            windowDAO.setSession(SessionTransaction.openSession());
            List<Window> windowList = windowDAO.getAll();
            SessionTransaction.closeSession(windowDAO.getSession());
            return windowList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody delete(...) klasy WindowDAO oraz zarządzanie sesją i
     * transakcją.
     *
     * @param window Parametr do metody klasy WindowDAO.
     */
    public static void delete(Window window) {
        try {
            windowDAO.setSession(SessionTransaction.openSession());
            windowDAO.setTransaction(SessionTransaction.openTransaction(windowDAO.getSession()));
            windowDAO.delete(window);
            SessionTransaction.closeTransaction(windowDAO.getTransaction());
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Wywołanie metody findById(...) klasy WindowDAO oraz zarządzanie sesją i
     * transakcją.
     *
     * @param id Parametr do metody klasy WindowDAO.
     * @return Wartość zwracana z metody klasy WindowDAO.
     */
    public static Window findById(Integer id) {
        try {
            windowDAO.setSession(SessionTransaction.openSession());
            Window window = windowDAO.findById(id);
            SessionTransaction.closeSession(windowDAO.getSession());
            return window;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findByWindowTitle(...) klasy WindowDAO oraz zarządzanie
     * sesją i transakcją.
     *
     * @param windowTitle Parametr do metody klasy WindowDAO.
     * @return Wartość zwracana z metody klasy WindowDAO.
     */
    public static List<Window> findByWindowTitle(String windowTitle) {
        try {
            windowDAO.setSession(SessionTransaction.openSession());
            List<Window> windowList = windowDAO.findByWindowTitle(windowTitle);
            SessionTransaction.closeSession(windowDAO.getSession());
            return windowList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findByStartDate(...) klasy WindowDAO oraz zarządzanie
     * sesją i transakcją.
     *
     * @param startDate Parametr do metody klasy WindowDAO.
     * @return Wartość zwracana z metody klasy WindowDAO.
     */
    public static List<Window> findByStartDate(Date startDate) {
        try {
            windowDAO.setSession(SessionTransaction.openSession());
            List<Window> windowList = windowDAO.findByStartDate(startDate);
            SessionTransaction.closeSession(windowDAO.getSession());
            return windowList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findFromDate(...) klasy WindowDAO oraz zarządzanie sesją
     * i transakcją.
     *
     * @param date Parametr do metody klasy WindowDAO.
     * @return Wartość zwracana z metody klasy WindowDAO.
     */
    public static List<Window> findFromDate(Date date) {
        try {
            windowDAO.setSession(SessionTransaction.openSession());
            List<Window> windowList = windowDAO.findFromDate(date);
            SessionTransaction.closeSession(windowDAO.getSession());
            return windowList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findToDate(...) klasy WindowDAO oraz zarządzanie sesją i
     * transakcją.
     *
     * @param date Parametr do metody klasy WindowDAO.
     * @return Wartość zwracana z metody klasy WindowDAO.
     */
    public static List<Window> findToDate(Date date) {
        try {
            windowDAO.setSession(SessionTransaction.openSession());
            List<Window> windowList = windowDAO.findToDate(date);
            SessionTransaction.closeSession(windowDAO.getSession());
            return windowList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findBetweenDate(...) klasy WindowDAO oraz zarządzanie
     * sesją i transakcją.
     *
     * @param dateMin Parametr do metody klasy WindowDAO.
     * @param dateMax Parametr do metody klasy WindowDAO.
     * @return Wartość zwracana z metody klasy WindowDAO.
     */
    public static List<Window> findBetweenDate(Date dateMin, Date dateMax) {
        try {
            windowDAO.setSession(SessionTransaction.openSession());
            List<Window> windowList = windowDAO.findBetweenDate(dateMin, dateMax);
            SessionTransaction.closeSession(windowDAO.getSession());
            return windowList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
    
    public static List<Window> findByAll(String windowTitle, Date dateMin, Date dateMax) {
        try {
            windowDAO.setSession(SessionTransaction.openSession());
            List<Window> windowList = windowDAO.findByAll(windowTitle, dateMin, dateMax);
            SessionTransaction.closeSession(windowDAO.getSession());
            return windowList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

}
