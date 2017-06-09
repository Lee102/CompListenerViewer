/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.KeyboardClick;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Łukasz Wojtas
 */
public interface KeyboardClickDAOInterface {

    public List<KeyboardClick> getAll();

    public void delete(KeyboardClick keyboardClick);

    public KeyboardClick findById(Integer id);

    public List<KeyboardClick> findByKeyText(String keyText);

    public List<KeyboardClick> findByTime(Date time);

    public List<KeyboardClick> findFromTime(Date time);

    public List<KeyboardClick> findToTime(Date time);

    public List<KeyboardClick> findBetweenTime(Date timeMin, Date timeMax);

}
