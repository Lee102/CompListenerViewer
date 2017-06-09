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
 *
 * @author Łukasz Wojtas
 */
public class MouseClickService {

    private static MouseClickDAO mouseClickDAO = new MouseClickDAO();

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
