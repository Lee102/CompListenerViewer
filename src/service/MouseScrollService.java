/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MouseScrollDAO;
import entity.MouseScroll;
import java.util.Date;
import java.util.List;

/**
 * Service klasy MouseScrollDAO.
 *
 * @see MouseScrollDAO {@link MouseScrollDAO}
 * @author Łukasz Wojtas
 */
public class MouseScrollService {

    /**
     * Prywatne, statyczne i zainicjowane pole klasy MouseScrollDAO.
     */
    private static MouseScrollDAO mouseScrollDAO = new MouseScrollDAO();

    /**
     * Wywołanie metody getAll() klasy MouseScrollDAO oraz zarządzanie sesją i
     * transakcją.
     *
     * @return Wartość zwracana z metody klasy MouseScrollDAO.
     */
    public static List<MouseScroll> getAll() {
        try {
            mouseScrollDAO.setSession(SessionTransaction.openSession());
            List<MouseScroll> mouseScrollList = mouseScrollDAO.getAll();
            SessionTransaction.closeSession(mouseScrollDAO.getSession());
            return mouseScrollList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody delete(...) klasy MouseScrollDAO oraz zarządzanie sesją
     * i transakcją.
     *
     * @param mouseScroll Parametr do metody klasy MouseScrollDAO.
     */
    public static void delete(MouseScroll mouseScroll) {
        try {
            mouseScrollDAO.setSession(SessionTransaction.openSession());
            mouseScrollDAO.setTransaction(SessionTransaction.openTransaction(mouseScrollDAO.getSession()));
            mouseScrollDAO.delete(mouseScroll);
            SessionTransaction.closeTransaction(mouseScrollDAO.getTransaction());
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Wywołanie metody findById(...) klasy MouseScrollDAO oraz zarządzanie
     * sesją i transakcją.
     *
     * @param id Parametr do metody klasy MouseScrollDAO.
     * @return Wartość zwracana z metody klasy MouseScrollDAO.
     */
    public static MouseScroll findById(Integer id) {
        try {
            mouseScrollDAO.setSession(SessionTransaction.openSession());
            MouseScroll mouseScroll = mouseScrollDAO.findById(id);
            SessionTransaction.closeSession(mouseScrollDAO.getSession());
            return mouseScroll;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findByDirection(...) klasy MouseScrollDAO oraz
     * zarządzanie sesją i transakcją.
     *
     * @param direction Parametr do metody klasy MouseScrollDAO.
     * @return Wartość zwracana z metody klasy MouseScrollDAO.
     */
    public static List<MouseScroll> findByDirection(int direction) {
        try {
            mouseScrollDAO.setSession(SessionTransaction.openSession());
            List<MouseScroll> mouseScrollList = mouseScrollDAO.findByDirection(direction);
            SessionTransaction.closeSession(mouseScrollDAO.getSession());
            return mouseScrollList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findByTime(...) klasy MouseScrollDAO oraz zarządzanie
     * sesją i transakcją.
     *
     * @param time Parametr do metody klasy MouseScrollDAO.
     * @return Wartość zwracana z metody klasy MouseScrollDAO.
     */
    public static List<MouseScroll> findByTime(Date time) {
        try {
            mouseScrollDAO.setSession(SessionTransaction.openSession());
            List<MouseScroll> mouseScrollList = mouseScrollDAO.findByTime(time);
            SessionTransaction.closeSession(mouseScrollDAO.getSession());
            return mouseScrollList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findFromTime(...) klasy MouseScrollDAO oraz zarządzanie
     * sesją i transakcją.
     *
     * @param time Parametr do metody klasy MouseScrollDAO.
     * @return Wartość zwracana z metody klasy MouseScrollDAO.
     */
    public static List<MouseScroll> findFromTime(Date time) {
        try {
            mouseScrollDAO.setSession(SessionTransaction.openSession());
            List<MouseScroll> mouseScrollList = mouseScrollDAO.findFromTime(time);
            SessionTransaction.closeSession(mouseScrollDAO.getSession());
            return mouseScrollList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findToTime(...) klasy MouseScrollDAO oraz zarządzanie
     * sesją i transakcją.
     *
     * @param time Parametr do metody klasy MouseScrollDAO.
     * @return Wartość zwracana z metody klasy MouseScrollDAO.
     */
    public static List<MouseScroll> findToTime(Date time) {
        try {
            mouseScrollDAO.setSession(SessionTransaction.openSession());
            List<MouseScroll> mouseScrollList = mouseScrollDAO.findToTime(time);
            SessionTransaction.closeSession(mouseScrollDAO.getSession());
            return mouseScrollList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findBetweenTime(...) klasy MouseScrollDAO oraz
     * zarządzanie sesją i transakcją.
     *
     * @param timeMin Parametr do metody klasy MouseScrollDAO.
     * @param timeMax Parametr do metody klasy MouseScrollDAO.
     * @return Wartość zwracana z metody klasy MouseScrollDAO.
     */
    public static List<MouseScroll> findBetweenTime(Date timeMin, Date timeMax) {
        try {
            mouseScrollDAO.setSession(SessionTransaction.openSession());
            List<MouseScroll> mouseScrollList = mouseScrollDAO.findBetweenTime(timeMin, timeMax);
            SessionTransaction.closeSession(mouseScrollDAO.getSession());
            return mouseScrollList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

}
