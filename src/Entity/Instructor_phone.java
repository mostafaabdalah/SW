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
public class Instructor_phone implements TheStandard {

    private int T_ID;
    private String T_Phones;

    public int getT_ID() {
        return T_ID;
    }

    public void setT_ID(int T_ID) {
        this.T_ID = T_ID;
    }

    public String getT_Phones() {
        return T_Phones;
    }

    public void setT_Phones(String T_Phones) {
        this.T_Phones = T_Phones;
    }

    @Override
    public void Add() {
        String insert = "insert into Instructor_Phones values (" + T_ID + ",'"
                + T_Phones + "')";

        boolean isAdd = DB.JCDB.runNoQuery(insert);

    }

    @Override
    public void Update() {
        Tools.msgBox("Not WorKing Here!..");
    }

    @Override
    public void Delete() {
        String delete = "delete from Instructor_Phones where T_ID =" + T_ID + "and T_Phones='" + T_Phones + "'";
        boolean isdeleted = DB.JCDB.runNoQuery(delete);

    }

    public void DeleteByInstructor() {
        String delete = "delete from Instructor_Phones where T_ID =" + T_ID;
        boolean isdeleted = DB.JCDB.runNoQuery(delete);

    }

    @Override
    public String getAutoNumber() {
        Tools.msgBox("Not WorKing Here!..");
        return "";
    }

    @Override
    public void getAllRows(JTable table) {
        String strSelect = "select T_Phones from Instructor_Phones where T_ID=" + T_ID;
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
