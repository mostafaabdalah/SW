/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import eductionalcenterd.Tools;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author MustafaSaad
 */
public class C_Booking implements TheStandard {

    private int S_ID;
    private String C_Name;
    private double S_Payment;
    private double Reming;

    private void getReming() {
        String str = "select C_Cost from courses where C_Name ='" + C_Name + "'";
        String s = DB.JCDB.getTableData(str).Items[0][0].toString();
        double r = Double.parseDouble(s);
        Reming = r - S_Payment;
    }

    private void getRemingforupdate() {
        String str = "select Reming from c_booking where S_ID =" + S_ID;
        String s = DB.JCDB.getTableData(str).Items[0][0].toString();
        double r = Double.parseDouble(s);
        Reming = r - S_Payment;
    }
    private void getPaymentforupdate() {
        String str = "select S_Payment from c_booking where S_ID =" + S_ID;
        String s = DB.JCDB.getTableData(str).Items[0][0].toString();
        double r = Double.parseDouble(s);
        S_Payment = S_Payment +r;
    }

    private void updateReming() {
        Reming = Reming - S_Payment;
    }

    public int getS_ID() {
        return S_ID;
    }

    public void setS_ID(int S_ID) {
        this.S_ID = S_ID;
    }

    public String getC_Name() {
        return C_Name;
    }

    public void setC_Name(String C_Name) {
        this.C_Name = C_Name;
    }

    public double getS_Payment() {
        return S_Payment;
    }

    public void setS_Payment(double S_Payment) {
        this.S_Payment = S_Payment;
    }

    @Override
    public void Add() {
        getReming();
        String insert = "insert into c_booking values (" + S_ID + ","
                + "'" + C_Name + "',"
                + S_Payment + ","
                + Reming + ")";
        boolean isAdd = DB.JCDB.runNoQuery(insert);
        if (isAdd) {
            Tools.msgBox("Booking Is Added");
        }

    }

    @Override
    public void Update() {
        getRemingforupdate();
        getPaymentforupdate();
        String update = "update c_booking  set S_Payment="+S_Payment+","
                + "Reming = " + Reming
                + " where S_ID=" + S_ID;

        boolean isUpdate = DB.JCDB.runNoQuery(update);
        if (isUpdate) {
            Tools.msgBox("Booking Is Updated");
        }
    }

    @Override
    public void Delete() {
        String delete = "delete from c_booking where S_ID =" + S_ID;
        boolean isdeleted = DB.JCDB.runNoQuery(delete);
        if (isdeleted) {
            Tools.msgBox("Booking Is Deleted");
        }
    }

    @Override
    public String getAutoNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCost(JComboBox box) {
        String str = "select C_Cost  from courses where C_Name ='" + box.getSelectedItem().toString() + "'";
        return DB.JCDB.getTableData(str).Items[0][0].toString();
    }

    @Override
    public void getAllRows(JTable table) {
        DB.JCDB.FillJTable("c_booking_data", table);

    }

    @Override
    public void getOneRow(JTable table) {
        String str = "select * from c_booking_data where No=" + S_ID;
        DB.JCDB.FillJTable(str, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        DB.JCDB.FillJTable(statement, table);
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
