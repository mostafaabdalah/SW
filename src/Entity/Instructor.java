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
public class Instructor implements TheStandard {

    private int T_ID;
    private String T_Name;
    private String T_HisSpecialty;
    private String T_Address;

    public int getT_ID() {
        return T_ID;
    }

    public void setT_ID(int T_ID) {
        this.T_ID = T_ID;
    }

    public String getT_Name() {
        return T_Name;
    }

    public void setT_Name(String T_Name) {
        this.T_Name = T_Name;
    }

    public String getT_HisSpecialty() {
        return T_HisSpecialty;
    }

    public void setT_HisSpecialty(String T_HisSpecialty) {
        this.T_HisSpecialty = T_HisSpecialty;
    }

    public String getT_Address() {
        return T_Address;
    }

    public void setT_Address(String T_Address) {
        this.T_Address = T_Address;
    }

    @Override
    public void Add() {
        String insert = "insert into Instructor values (" + T_ID + ","
                + "'" + T_Name + "',"
                + "'" + T_HisSpecialty + "','"
                + T_Address + "')";
        boolean isAdd = DB.JCDB.runNoQuery(insert);
        if (isAdd) {
            Tools.msgBox("Instructor Is Added");
        }
    }

    @Override
    public void Update() {
        String update = "update Instructor  set "
                + "T_Name ='" + T_Name + "',"
                + "T_HisSpecialty ='" + T_HisSpecialty + "',"
                + "T_Address='" + T_Address + "'"
                + " where T_ID=" + T_ID;

        boolean isUpdate = DB.JCDB.runNoQuery(update);
        if (isUpdate) {
            Tools.msgBox("Instructor Is Updated");
        }
    }

    @Override
    public void Delete() {
        String delete = "delete from Instructor where T_ID =" + T_ID;;
        boolean isdeleted = DB.JCDB.runNoQuery(delete);
        if (isdeleted) {
            Tools.msgBox("Instructor Is Deleted");
        }
    }

    @Override
    public String getAutoNumber() {
        return DB.JCDB.getAutoNumber("Instructor", "T_ID");
    }

    @Override
    public void getAllRows(JTable table) {
        DB.JCDB.FillJTable("instructor_data", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String str = "select * from instructor_data where No=" + T_ID;
        DB.JCDB.FillJTable(str, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        DB.JCDB.FillJTable(statement, table);
    }

    @Override
    public String getValueByName(String Name) {
        String str = "select T_ID from Instructor where T_Name ='" + Name + "'";
        return (String) DB.JCDB.getTableData(str).Items[0][0].toString();
    }

    @Override
    public String getNameByValue(String Value) {
        String str = "select T_Name from Instructor where T_ID =" + Value;
        return DB.JCDB.getTableData(str).Items[0][0].toString();
    }

    
}
