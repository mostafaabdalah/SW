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
public class Course implements TheStandard {

    private String C_Name;
    private String C_Cost;
    private int C_Studet_No;
    private String C_Time;
    private String C_Start;
    private String C_End;
    private String C_Clock;
    private String L_ID;
    private int T_ID;

    public String getC_Name() {
        return C_Name;
    }

    public void setC_Name(String C_Name) {
        this.C_Name = C_Name;
    }

    public String getC_Cost() {
        return C_Cost;
    }

    public void setC_Cost(String C_Cost) {
        this.C_Cost = C_Cost;
    }

    public int getC_Studet_No() {
        return C_Studet_No;
    }

    public void setC_Studet_No(int C_Studet_No) {
        this.C_Studet_No = C_Studet_No;
    }

    public String getC_Time() {
        return C_Time;
    }

    public void setC_Time(String C_Time) {
        this.C_Time = C_Time;
    }

    public String getC_Start() {
        return C_Start;
    }

    public void setC_Start(String C_Start) {
        this.C_Start = C_Start;
    }

    public String getC_End() {
        return C_End;
    }

    public void setC_End(String C_End) {
        this.C_End = C_End;
    }

    public String getC_Clock() {
        return C_Clock;
    }

    public void setC_Clock(String C_Clock) {
        this.C_Clock = C_Clock;
    }

    public String getL_ID() {
        return L_ID;
    }

    public void setL_ID(String L_ID) {
        this.L_ID = L_ID;
    }

    public int getT_ID() {
        return T_ID;
    }

    public void setT_ID(int T_ID) {
        this.T_ID = T_ID;
    }

    @Override
    public void Add() {
        String insert = "insert into Courses values ('" + C_Name + "'"
                + ",'" + C_Cost + "',"
                + C_Studet_No + ","
                + "'" + C_Time + "','" + C_Start + "',"
                + "'" + C_End + "','" + C_Clock + "','" + L_ID + "'," + T_ID
                + ")";
        boolean isAdd = DB.JCDB.runNoQuery(insert);
        if (isAdd) {
            Tools.msgBox("Course Is Added");
        }
    }

    @Override
    public void Update() {

        String update = "update Courses  set "
                + "C_Cost ='" + C_Cost + "',"
                + "C_Studet_No =" + C_Studet_No + ","
                + "C_Time='" + C_Time + "',"
                + "C_Start='" + C_Start + "',"
                + "C_End='" + C_End + "'," + "C_Clock='" + C_Clock + "', L_ID='" + L_ID + "',T_ID='" + T_ID
                + "' where C_Name='" + C_Name + "'";

        boolean isUpdate = DB.JCDB.runNoQuery(update);
        if (isUpdate) {
            Tools.msgBox("Course Is Updated");
        }
    }

    @Override
    public void Delete() {
        String delete = "delete from Courses  where C_Name ='" + C_Name + "'";
        boolean isdeleted = DB.JCDB.runNoQuery(delete);
        if (isdeleted) {
            Tools.msgBox("Course Is Deleted");
        }
    }

    @Override
    public String getAutoNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getAllRows(JTable table) {
        DB.JCDB.FillJTable("courses_data", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String str = "select * from courses_data where Name  ='" + C_Name + "'";
        DB.JCDB.FillJTable(str, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        DB.JCDB.FillJTable(statement, table);
    }

    @Override
    public String getValueByName(String Name) {

        return "";
    }

    @Override
    public String getNameByValue(String Value) {
    return "";
    }

    public String getstunoByName(String Name) {

        String str = "select C_Studet_No from courses where C_Name ='"+Name+"'";
        return DB.JCDB.getTableData(str).Items[0][0].toString();
    }


}
