/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.MouseClick;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Łukasz Wojtas
 */
public interface MouseClickDAOInterface {

    public List<MouseClick> getAll();

    public void delete(MouseClick mouseClick);

    public MouseClick findById(Integer id);

    public List<MouseClick> findByButton(int button);

    public List<MouseClick> findByX(int x);

    public List<MouseClick> findByY(int y);

    public List<MouseClick> findByTime(Date time);

    public List<MouseClick> findFromTime(Date time);

    public List<MouseClick> findToTime(Date time);

    public List<MouseClick> findBetweenTime(Date timeMin, Date timeMax);

}
