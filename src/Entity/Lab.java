/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import eductionalcenterd.Tools;
import javax.swing.JTable;

/**
 *
 * @author MustafaSaad
 */
public class Lab implements TheStandard {

    private String L_ID;
    private String L_Name;

    public String getL_ID() {
        return L_ID;
    }

    public void setL_ID(String L_ID) {
        this.L_ID = L_ID;
    }

    public String getL_Name() {
        return L_Name;
    }

    public void setL_Name(String L_Name) {
        this.L_Name = L_Name;
    }

    @Override
    public void Add() {
        String insert = "insert into Labs values (" + L_ID + ","
                + "'" + L_Name + "')";
        boolean isAdd = DB.JCDB.runNoQuery(insert);
        if (isAdd) {
            Tools.msgBox("Lab Is Added");
        }
    }

    @Override
    public void Update() {
        String update = "update Labs  set "
                + "L_Name ='" + L_Name + "'"
                + " where L_ID='" + L_ID+"'";

        boolean isUpdate = DB.JCDB.runNoQuery(update);
        if (isUpdate) {
            Tools.msgBox("Lab Is Updated");
        }
    }

     public void Update2(String name) {
        String update = "update Labs  set "
                + "L_Name ='" + name + "'"
                + " where L_ID='" + L_ID+"'";

        boolean isUpdate = DB.JCDB.runNoQuery(update);
       
    }
    @Override
    public void Delete() {
        Update2("Is Busy");
    }

    @Override
    public String getAutoNumber() {
        return DB.JCDB.getAutoNumber("Labs", "L_ID");
    }

    @Override
    public void getAllRows(JTable table) {
        DB.JCDB.FillJTable("labs_data", table);

    }

    @Override
    public void getOneRow(JTable table) {
        String str = "select * from labs_data where Lab_No ='" + L_ID+"'";
        DB.JCDB.FillJTable(str, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        DB.JCDB.FillJTable(statement, table);
    }

    @Override
    public String getValueByName(String Name) {
       String str = "select L_ID from Labs where L_Name ='" + Name + "'";
        return (String) DB.JCDB.getTableData(str).Items[0][0].toString();
    }

    @Override
    public String getNameByValue(String Value) {
        return "";
    }

}
