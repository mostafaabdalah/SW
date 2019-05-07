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
public class Student implements TheStandard {

    private int S_ID;
    private String S_Name;
    private String S_Age;
    private String S_Level;
    private String S_Address;

    public int getS_ID() {
        return S_ID;
    }

    public void setS_ID(int S_ID) {
        this.S_ID = S_ID;
    }

    public String getS_Name() {
        return S_Name;
    }

    public void setS_Name(String S_Name) {
        this.S_Name = S_Name;
    }

    public String getS_Age() {
        return S_Age;
    }

    public void setS_Age(String S_Age) {
        this.S_Age = S_Age;
    }

    public String getS_Level() {
        return S_Level;
    }

    public void setS_Level(String S_Level) {
        this.S_Level = S_Level;
    }

    public String getS_Address() {
        return S_Address;
    }

    public void setS_Address(String S_Address) {
        this.S_Address = S_Address;
    }

    @Override
    public void Add() {
        String insert = "insert into Student values (" + S_ID + ","
                + "'" + S_Name + "',"
                + "'" + S_Age + "','"
                + S_Level + "','" + S_Address + "')";
        boolean isAdd = DB.JCDB.runNoQuery(insert);
        if (isAdd) {
            Tools.msgBox("Student Is Added");
        }
    }

    @Override
    public void Update() {
        String update = "update Student  set "
                + "S_Name ='" + S_Name + "',"
                + "S_Age ='" + S_Age + "',"
                + "S_Level='" + S_Level + "',"
                + "S_Address='" + S_Address + "'"
                + " where S_ID=" + S_ID;

        boolean isUpdate = DB.JCDB.runNoQuery(update);
        if (isUpdate) {
            Tools.msgBox("Student Is Updated");
        }
    }

    @Override
    public void Delete() {
        String delete = "delete from Student  where S_ID =" + S_ID;;
        boolean isdeleted = DB.JCDB.runNoQuery(delete);
        if (isdeleted) {
            Tools.msgBox("Student Is Deleted");
        }

    }

    @Override
    public String getAutoNumber() {
        return DB.JCDB.getAutoNumber("Student", "S_ID");
    }

    @Override
    public void getAllRows(JTable table) {
        DB.JCDB.FillJTable("student_data", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String str = "select * from student_data where No=" + S_ID;
        DB.JCDB.FillJTable(str, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        DB.JCDB.FillJTable(statement, table);
    }

    @Override
    public String getValueByName(String Name) {
        String str = "select S_ID from Student where S_Name ='" + Name + "'";
        return (String) DB.JCDB.getTableData(str).Items[0][0].toString();
    }

    @Override
    public String getNameByValue(String Value) {
String str = "select S_Name from Student where S_ID ="+Value;
       return DB.JCDB.getTableData(str).Items[0][0].toString();
    }
    

}
