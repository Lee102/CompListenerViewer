/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.WorkstationAdditionalData;
import java.util.List;

/**
 *
 * @author Łukasz Wojtas
 */
public interface WorkstationAdditionalDataDAOInterface {

    public List<WorkstationAdditionalData> getAll();

    public void delete(WorkstationAdditionalData workstationAdditionalData);

    public WorkstationAdditionalData findById(Integer id);

    public List<WorkstationAdditionalData> findByOsVersion(String osVersion);

    public List<WorkstationAdditionalData> findByOsArch(String osArch);

    public List<WorkstationAdditionalData> findByJavaVersion(String javaVersion);

    public List<WorkstationAdditionalData> findByProcId(String procId);

    public List<WorkstationAdditionalData> findByProcArch(String procArch);

    public List<WorkstationAdditionalData> findByProcCores(Integer procCores);

    public List<WorkstationAdditionalData> findByRamSize(Integer ramSize);

    public List<WorkstationAdditionalData> findByDiskSize(Integer diskSize);

}
