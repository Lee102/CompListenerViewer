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
 *
 * @author Łukasz Wojtas
 */
public class KeyboardClickService {

    private static KeyboardClickDAO keyboardClickDAO = new KeyboardClickDAO();

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
