/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import eductionalcenterd.Tools;
import eductionalcenterd.Tools.Table;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MustafaSaad
 */
public class JCDB {

    private static String url = " ";
    private static Connection con;
    //public static String db_name = "";

    private static void setURL() {
        url = "JDBC:mysql://localhost:3306/DreamsC"
                + "?useUnicode=true&characterEncoding=utf-8";
    }

    private static void setConnection() {
        try {
            setURL();
            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException ex) {
            Tools.msgBox(ex.getMessage());
        }
    }

    public static boolean CheckUserAndPassword(String U, String P) {
        try {
            setConnection();
            Statement st = con.createStatement();
            String strCheck = "Select  *  from users where userName ='" + U + "' and Password='" + P + "'";
            st.executeQuery(strCheck);
            while (st.getResultSet().next()) {
                con.close();
                return true;
            }
            con.close();

        } catch (SQLException ex) {
            Tools.msgBox(ex.getMessage());

        }
        return false;

    }

    public static boolean runNoQuery(String sqstatement) {
        try {
            setConnection();
            Statement stmt = con.createStatement();
            stmt.execute(sqstatement);
            con.close();
            return true;
        } catch (SQLException ex) {
            Tools.msgBox(ex.getMessage());
            return false;

        }

    }

    public static boolean ToGetConfirm(String sqstatement) {
        try {
            setConnection();
            Statement stmt = con.createStatement();
            stmt.executeQuery(sqstatement);
            con.close();
            return true;
        } catch (SQLException ex) {
            Tools.msgBox(ex.getMessage());
            return false;

        }

    }

    public static String getAutoNumber(String tableName, String columnName) {

        try {
            setConnection();
            Statement st = con.createStatement();
            String strAuto = "Select max(" + columnName + ")"
                    + "+1 as AutoNum" + " from " + tableName;
            st.executeQuery(strAuto);
            String num = "";
            while (st.getResultSet().next()) {
                num = st.getResultSet().getString("AutoNum");
            }
            con.close();
            if (num == null || "".equals(num)) {
                return "1";
            } else {
                return num;
            }
        } catch (SQLException ex) {
            Tools.msgBox(ex.getMessage());
            return "0";
        }

    }

    public static Table getTableData(String statement) {
        Tools t = new Tools();
        try {
            setConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(statement);

            ResultSetMetaData rsmd = rs.getMetaData();
            int c = rsmd.getColumnCount();

            Table table = t.new Table(c);

            while (rs.next()) {
                Object r[] = new Object[c];

                for (int i = 0; i < c; i++) {
                    r[i] = rs.getString(i + 1);
                }
                table.addNewRow(r);
            }
            con.close();
            return table;

        } catch (SQLException ex) {
            Tools.msgBox(ex.getMessage());
            return t.new Table(0);
        }
    }

    public static void FillCombo(String tablename, String columnname, JComboBox box) {

        try {
            setConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select " + columnname + " from " + tablename);
            rs.last();
            int r = rs.getRow();
            rs.beforeFirst();

            String value[] = new String[r];
            int i = 0;
            while (rs.next()) {
                value[i] = rs.getString(1);
                i++;
            }
            con.close();
            box.setModel(new DefaultComboBoxModel(value));

        } catch (SQLException ex) {
            Tools.msgBox(ex.getMessage());
        }
    }

    public static void FillCombo(String tablename, String columnname1, String columnname2, JComboBox box) {

        try {
            setConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select " + columnname1 + "," + columnname2 + " from " + tablename);
            rs.last();
            int r = rs.getRow();
            rs.beforeFirst();

            String value1[] = new String[r];
            
            int i = 0;
            while (rs.next()) {
                value1[i] = rs.getString(1) +"-"+ rs.getString(2);
                i++;
            }
            con.close();
            box.setModel(new DefaultComboBoxModel(value1));

        } catch (SQLException ex) {
            Tools.msgBox(ex.getMessage());
        }
    }

    public static void FillJTable(String tablenameorselectstatement, JTable table) {
        try {
            setConnection();
            Statement st = con.createStatement();
            ResultSet rs;
            String strSelect;
            if ("select ".equals(tablenameorselectstatement.substring(0, 7).toLowerCase())) {
                strSelect = tablenameorselectstatement;
            } else {
                strSelect = "select * from " + tablenameorselectstatement;
            }

            rs = st.executeQuery(strSelect);
            ResultSetMetaData rsmd = rs.getMetaData();
            int c = rsmd.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Vector row = new Vector();

            model.setRowCount(0);

            while (rs.next()) {
                row = new Vector(c);

                for (int i = 1; i <= c; i++) {
                    row.add(rs.getString(i));
                }
                model.addRow(row);
            }
            if (table.getColumnCount() != c) {
                Tools.msgBox("Columns Not equality\n");
            }
            con.close();

        } catch (SQLException ex) {
            Tools.msgBox(ex.getMessage());
        }
    }

}
