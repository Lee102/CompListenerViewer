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
 *
 * @author Łukasz Wojtas
 */
public class MouseScrollService {

    private static MouseScrollDAO mouseScrollDAO = new MouseScrollDAO();

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
