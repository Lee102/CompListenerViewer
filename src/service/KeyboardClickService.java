/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.KeyboardClickDAO;
import entity.KeyboardClick;
import java.util.Date;
import java.util.List;

/**
 * Service klasy KeyboardClickDAO.
 *
 * @see KeyboardClickDAO {@link KeyboardClickDAO}
 * @author Łukasz Wojtas
 */
public class KeyboardClickService {

    /**
     * Prywatne, statyczne i zainicjowane pole klasy KeyboardClickDAO.
     */
    private static KeyboardClickDAO keyboardClickDAO = new KeyboardClickDAO();

    /**
     * Wywołanie metody getAll() klasy KeyboardClickDAO oraz zarządzanie sesją i
     * transakcją.
     *
     * @return Wartość zwracana z metody klasy KeyboardClickDAO.
     */
    public static List<KeyboardClick> getAll() {
        try {
            keyboardClickDAO.setSession(SessionTransaction.openSession());
            List<KeyboardClick> keyboardClickList = keyboardClickDAO.getAll();
            SessionTransaction.closeSession(keyboardClickDAO.getSession());
            return keyboardClickList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody delete(...) klasy KeyboardClickDAO oraz zarządzanie
     * sesją i transakcją.
     *
     * @param keyboardClick Parametr do metody klasy KeyboardClickDAO.
     */
    public static void delete(KeyboardClick keyboardClick) {
        try {
            keyboardClickDAO.setSession(SessionTransaction.openSession());
            keyboardClickDAO.setTransaction(SessionTransaction.openTransaction(keyboardClickDAO.getSession()));
            keyboardClickDAO.delete(keyboardClick);
            SessionTransaction.closeTransaction(keyboardClickDAO.getTransaction());
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Wywołanie metody findById(...) klasy KeyboardClickDAO oraz zarządzanie
     * sesją i transakcją.
     *
     * @param id Parametr do metody klasy KeyboardClickDAO.
     * @return Wartość zwracana z metody klasy KeyboardClickDAO.
     */
    public static KeyboardClick findById(Integer id) {
        try {
            keyboardClickDAO.setSession(SessionTransaction.openSession());
            KeyboardClick keyboardClick = keyboardClickDAO.findById(id);
            SessionTransaction.closeSession(keyboardClickDAO.getSession());
            return keyboardClick;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findByKeyText(...) klasy KeyboardClickDAO oraz
     * zarządzanie sesją i transakcją.
     *
     * @param keyText Parametr do metody klasy KeyboardClickDAO.
     * @return Wartość zwracana z metody klasy KeyboardClickDAO.
     */
    public static List<KeyboardClick> findByKeyText(String keyText) {
        try {
            keyboardClickDAO.setSession(SessionTransaction.openSession());
            List<KeyboardClick> keyboardClickList = keyboardClickDAO.findByKeyText(keyText);
            SessionTransaction.closeSession(keyboardClickDAO.getSession());
            return keyboardClickList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findByTime(...) klasy KeyboardClickDAO oraz zarządzanie
     * sesją i transakcją.
     *
     * @param time Parametr do metody klasy KeyboardClickDAO.
     * @return Wartość zwracana z metody klasy KeyboardClickDAO.
     */
    public static List<KeyboardClick> findByTime(Date time) {
        try {
            keyboardClickDAO.setSession(SessionTransaction.openSession());
            List<KeyboardClick> keyboardClickList = keyboardClickDAO.findByTime(time);
            SessionTransaction.closeSession(keyboardClickDAO.getSession());
            return keyboardClickList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findFromTime(...) klasy KeyboardClickDAO oraz
     * zarządzanie sesją i transakcją.
     *
     * @param time Parametr do metody klasy KeyboardClickDAO.
     * @return Wartość zwracana z metody klasy KeyboardClickDAO.
     */
    public static List<KeyboardClick> findFromTime(Date time) {
        try {
            keyboardClickDAO.setSession(SessionTransaction.openSession());
            List<KeyboardClick> keyboardClickList = keyboardClickDAO.findFromTime(time);
            SessionTransaction.closeSession(keyboardClickDAO.getSession());
            return keyboardClickList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findToTime(...) klasy KeyboardClickDAO oraz zarządzanie
     * sesją i transakcją.
     *
     * @param time Parametr do metody klasy KeyboardClickDAO.
     * @return Wartość zwracana z metody klasy KeyboardClickDAO.
     */
    public static List<KeyboardClick> findToTime(Date time) {
        try {
            keyboardClickDAO.setSession(SessionTransaction.openSession());
            List<KeyboardClick> keyboardClickList = keyboardClickDAO.findToTime(time);
            SessionTransaction.closeSession(keyboardClickDAO.getSession());
            return keyboardClickList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Wywołanie metody findBetweenTime(...) klasy KeyboardClickDAO oraz
     * zarządzanie sesją i transakcją.
     *
     * @param timeMin Parametr do metody klasy KeyboardClickDAO.
     * @param timeMax Parametr do metody klasy KeyboardClickDAO.
     * @return Wartość zwracana z metody klasy KeyboardClickDAO.
     */
    public static List<KeyboardClick> findBetweenTime(Date timeMin, Date timeMax) {
        try {
            keyboardClickDAO.setSession(SessionTransaction.openSession());
            List<KeyboardClick> keyboardClickList = keyboardClickDAO.findBetweenTime(timeMin, timeMax);
            SessionTransaction.closeSession(keyboardClickDAO.getSession());
            return keyboardClickList;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

}
