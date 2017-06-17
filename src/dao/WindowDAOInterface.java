/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Window;
import java.util.Date;
import java.util.List;

/**
 * Interfejs klasy WindowDAO.
 *
 * @author Łukasz Wojtas
 */
public interface WindowDAOInterface {

    public List<Window> getAll();

    public void delete(Window window);

    public Window findById(Integer id);

    public List<Window> findByWindowTitle(String windowTitle);

    public List<Window> findByStartDate(Date startDate);

    public List<Window> findFromDate(Date date);

    public List<Window> findToDate(Date date);

    public List<Window> findBetweenDate(Date dateMin, Date dateMax);

    public List<Window> findByAll(String windowTitle, Date dateMin, Date dateMax);

}
