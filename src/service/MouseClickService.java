/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MouseClickDAO;
import entity.MouseClick;
import java.util.Date;
import java.util.List;

/**
 * Service klasy MouseClickDAO.
 *
 * @see MouseClickDAO {@link MouseClickDAO}
 * @author Łukasz Wojtas
 */
public class MouseClickService {

    /**
     * Prywatne, statyczne i zainicjowane pole klasy MouseClickDAO.
     */
    private static MouseClickDAO mouseClickDAO = new MouseClickDAO();

    /**
     * Wywołanie metody getAll() klasy MouseClickDAO oraz zarządzanie sesją i
     * transakcją.
     *
     * @return Wartość zwracana z metody klasy MouseClickDAO.
     */
    public static List<MouseClick> getAll() {
        try {
            mouseClickDAO.setSession(SessionTransaction.openSession());
            List<MouseClick> mouseClickList = mouseClickDAO.getAll();
            SessionTransaction.closeSession(mouseClickDAO.getSession());
            return mouseClickList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody delete(...) klasy MouseClickDAO oraz zarządzanie sesją i
     * transakcją.
     *
     * @param mouseClick Parametr do metody klasy MouseClickDAO.
     */
    public static void delete(MouseClick mouseClick) {
        try {
            mouseClickDAO.setSession(SessionTransaction.openSession());
            mouseClickDAO.setTransaction(SessionTransaction.openTransaction(mouseClickDAO.getSession()));
            mouseClickDAO.delete(mouseClick);
            SessionTransaction.closeTransaction(mouseClickDAO.getTransaction());
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Wywołanie metody findById(...) klasy MouseClickDAO oraz zarządzanie sesją
     * i transakcją.
     *
     * @param id Parametr do metody klasy MouseClickDAO.
     * @return Wartość zwracana z metody klasy MouseClickDAO.
     */
    public static MouseClick findById(Integer id) {
        try {
            mouseClickDAO.setSession(SessionTransaction.openSession());
            MouseClick mouseClick = mouseClickDAO.findById(id);
            SessionTransaction.closeSession(mouseClickDAO.getSession());
            return mouseClick;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findByButton(...) klasy MouseClickDAO oraz zarządzanie
     * sesją i transakcją.
     *
     * @param button Parametr do metody klasy MouseClickDAO.
     * @return Wartość zwracana z metody klasy MouseClickDAO.
     */
    public static List<MouseClick> findByButton(int button) {
        try {
            mouseClickDAO.setSession(SessionTransaction.openSession());
            List<MouseClick> mouseClickList = mouseClickDAO.findByButton(button);
            SessionTransaction.closeSession(mouseClickDAO.getSession());
            return mouseClickList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findByX(...) klasy MouseClickDAO oraz zarządzanie sesją
     * i transakcją.
     *
     * @param x Parametr do metody klasy MouseClickDAO.
     * @return Wartość zwracana z metody klasy MouseClickDAO.
     */
    public static List<MouseClick> findByX(int x) {
        try {
            mouseClickDAO.setSession(SessionTransaction.openSession());
            List<MouseClick> mouseClickList = mouseClickDAO.findByX(x);
            SessionTransaction.closeSession(mouseClickDAO.getSession());
            return mouseClickList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findByY(...) klasy MouseClickDAO oraz zarządzanie sesją
     * i transakcją.
     *
     * @param y Parametr do metody klasy MouseClickDAO.
     * @return Wartość zwracana z metody klasy MouseClickDAO.
     */
    public static List<MouseClick> findByY(int y) {
        try {
            mouseClickDAO.setSession(SessionTransaction.openSession());
            List<MouseClick> mouseClickList = mouseClickDAO.findByY(y);
            SessionTransaction.closeSession(mouseClickDAO.getSession());
            return mouseClickList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findByTime(...) klasy MouseClickDAO oraz zarządzanie
     * sesją i transakcją.
     *
     * @param time Parametr do metody klasy MouseClickDAO.
     * @return Wartość zwracana z metody klasy MouseClickDAO.
     */
    public static List<MouseClick> findByTime(Date time) {
        try {
            mouseClickDAO.setSession(SessionTransaction.openSession());
            List<MouseClick> mouseClickList = mouseClickDAO.findByTime(time);
            SessionTransaction.closeSession(mouseClickDAO.getSession());
            return mouseClickList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findFromTime(...) klasy MouseClickDAO oraz zarządzanie
     * sesją i transakcją.
     *
     * @param time Parametr do metody klasy MouseClickDAO.
     * @return Wartość zwracana z metody klasy MouseClickDAO.
     */
    public static List<MouseClick> findFromTime(Date time) {
        try {
            mouseClickDAO.setSession(SessionTransaction.openSession());
            List<MouseClick> mouseClickList = mouseClickDAO.findFromTime(time);
            SessionTransaction.closeSession(mouseClickDAO.getSession());
            return mouseClickList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findToTime(...) klasy MouseClickDAO oraz zarządzanie
     * sesją i transakcją.
     *
     * @param time Parametr do metody klasy MouseClickDAO.
     * @return Wartość zwracana z metody klasy MouseClickDAO.
     */
    public static List<MouseClick> findToTime(Date time) {
        try {
            mouseClickDAO.setSession(SessionTransaction.openSession());
            List<MouseClick> mouseClickList = mouseClickDAO.findToTime(time);
            SessionTransaction.closeSession(mouseClickDAO.getSession());
            return mouseClickList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findBetweenTime(...) klasy MouseClickDAO oraz
     * zarządzanie sesją i transakcją.
     *
     * @param timeMin Parametr do metody klasy MouseClickDAO.
     * @param timeMax Parametr do metody klasy MouseClickDAO.
     * @return Wartość zwracana z metody klasy MouseClickDAO.
     */
    public static List<MouseClick> findBetweenTime(Date timeMin, Date timeMax) {
        try {
            mouseClickDAO.setSession(SessionTransaction.openSession());
            List<MouseClick> mouseClickList = mouseClickDAO.findBetweenTime(timeMin, timeMax);
            SessionTransaction.closeSession(mouseClickDAO.getSession());
            return mouseClickList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

}
