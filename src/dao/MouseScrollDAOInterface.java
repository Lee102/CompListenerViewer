/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.MouseScroll;
import java.util.Date;
import java.util.List;

/**
 * Interfejs klasy MouseScrollDAO.
 *
 * @author Łukasz Wojtas
 */
public interface MouseScrollDAOInterface {

    public List<MouseScroll> getAll();

    public void delete(MouseScroll mouseScroll);

    public MouseScroll findById(Integer id);

    public List<MouseScroll> findByDirection(int direction);

    public List<MouseScroll> findByTime(Date time);

    public List<MouseScroll> findFromTime(Date time);

    public List<MouseScroll> findToTime(Date time);

    public List<MouseScroll> findBetweenTime(Date timeMin, Date timeMax);

}
