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
public class Course_Day implements TheStandard {

    private String C_Name;
    private String C_Days;

   
    public String getC_Name() {
        return C_Name;
    }

    public void setC_Name(String C_Name) {
        this.C_Name = C_Name;
    }

    public String getC_Days() {
        return C_Days;
    }

    public void setC_Days(String C_Days) {
        this.C_Days = C_Days;
    }


    @Override
    public void Add() {
        String insert = "insert into Courses_Days values ('" + C_Name + "','"
                + C_Days + "')";

        boolean isAdd = DB.JCDB.runNoQuery(insert);

    }

    @Override
    public void Update() {
        Tools.msgBox("Not WorKing Here!..");
    }

    @Override
    public void Delete() {
        String delete = "delete from Courses_Days where C_Name ='" + C_Name + "' and C_Days='" + C_Days + "'";
        boolean isdeleted = DB.JCDB.runNoQuery(delete);

    }

    public void DeleteByCourse() {
        String delete = "delete from Courses_Days where C_Name ='" + C_Name+"'";
        boolean isdeleted = DB.JCDB.runNoQuery(delete);

    }

    @Override
    public String getAutoNumber() {
        Tools.msgBox("Not WorKing Here!..");
        return "";
    }

    @Override
    public void getAllRows(JTable table) {
        String strSelect = "select C_Days from Courses_Days where C_Name='" + C_Name+"'";
        DB.JCDB.FillJTable(strSelect, table);
    }

    @Override
    public void getOneRow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getValueByName(String Name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNameByValue(String Value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
