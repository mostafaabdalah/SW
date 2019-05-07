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
public class Student_phone implements TheStandard {

    private int S_ID;
    private String S_Phones;

    public int getS_ID() {
        return S_ID;
    }

    public void setS_ID(int S_ID) {
        this.S_ID = S_ID;
    }

    public String getS_Phones() {
        return S_Phones;
    }

    public void setS_Phones(String S_Phones) {
        this.S_Phones = S_Phones;
    }

    @Override
    public void Add() {
        String insert = "insert into student_phones values (" + S_ID + ",'"
                + S_Phones + "')";

        boolean isAdd = DB.JCDB.runNoQuery(insert);

    }

    @Override
    public void Update() {
        Tools.msgBox("Not WorKing Here!..");
    }

    @Override
    public void Delete() {
        String delete = "delete from student_phones where S_ID =" + S_ID + "and S_Phones='" + S_Phones + "'";
        boolean isdeleted = DB.JCDB.runNoQuery(delete);

    }

    public void DeleteByStudent() {
        String delete = "delete from student_phones where S_ID =" + S_ID;
        boolean isdeleted = DB.JCDB.runNoQuery(delete);

    }

    @Override
    public String getAutoNumber() {
        Tools.msgBox("Not WorKing Here!..");
        return "";
    }

    @Override
    public void getAllRows(JTable table) {
        String strSelect = "select S_Phones from student_phones where S_ID=" + S_ID;
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
