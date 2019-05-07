package eductionalcenterd;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Tools {

    public static void msgBox(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static boolean ConfirmMessage(String message){
        int msgC = JOptionPane.showConfirmDialog(null, message);
        if(msgC == JOptionPane.YES_OPTION){
            return true;
        }else{
            return false;
        }
    }
    public static void CreateFolder(String folderName, String path) {

        File f = new File(path + "/" + folderName);
        f.mkdir();
    }

    public static void CreateFolder(String folderName) {

        File f = new File(folderName);
        f.mkdir();
    }

    public static void OpenForm(JFrame form ,String title) {

        try {
            form.setLocationRelativeTo(null);
            Image img = ImageIO.read(Tools.class.getResource("/Icons/Cicon.png"));
            form.setIconImage(img);
            form.setDefaultCloseOperation(2);
            form.getContentPane().setBackground(Color.WHITE);
            form.setTitle(title);
            form.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    

    public static void ClearTexts(Container form) {
        for (Component c : form.getComponents()) {
            if (c instanceof JTextField) {
                JTextField txt = (JTextField) c;
                txt.setText(" ");
            } else if (c instanceof Container) {
                ClearTexts((Container) c);
            }
        }

    }

    public static void CreateEmptyFile(String FileName) {
        try {
            File f = new File(FileName);
            f.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void CreatFile(String FileName, Object[] data) {
        try {
            PrintWriter p = new PrintWriter(FileName);
            for (Object object : data) {
                p.println(object);
            }
            p.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Object InputBox(String Title) {
        Object obj = JOptionPane.showInputDialog(Title);
        return obj;
    }

    public static String getNumber(String str) {
        String s = " ";
        String number = "0123456789";

        for (char c : str.toCharArray()) {
            for (char d : number.toCharArray()) {
                if (c == d) {
                    s += d;
                }
            }

        }
        return s;

    }

    public static int getNumberToInt(String str) {
        String s = " ";
        String number = "0123456789";

        for (char c : str.toCharArray()) {
            for (char d : number.toCharArray()) {
                if (c == d) {
                    s += c;
                }
            }

        }
        return Integer.parseInt(s);

    }

    public static String removeNumber(String str) {
        String s = " ";

        for (char c : str.toCharArray()) {
            if (!(c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0')) {
                s += c;
            }

        }
        return s;

    }

    public static void CreateMultiEmptyFile(String[] FileNames) {

        for (String FileName : FileNames) {
            CreateEmptyFile(FileName + ".TxT");
        }
    }

    public static void CreateMultiFile(String FileName[], Object alldata[][]) {

        int x = 0;
        for (Object[] objects : alldata) {

            CreatFile(FileName[x] + ".TXT", objects);

            x++;
        }

    }

    public static void PrintScreen(String ImageName) {
        try {
            Robot r = new Robot();
            Rectangle Rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage b = r.createScreenCapture(Rec);
            ImageIO.write(b, "jpg", new File(ImageName + ".jpg"));
        } catch (Exception ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void PrintScreen(String ImageName, JFrame form) {
        try {
            form.setState(1);
            Robot r = new Robot();
            Rectangle Rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage b = r.createScreenCapture(Rec);
            ImageIO.write(b, "jpg", new File(ImageName + ".jpg"));
            form.setState(0);
        } catch (Exception ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static class StringTools {

        String text;
        private String str;
        String[] texts;
        String str2;

        public StringTools(String text) {
            this.text = text;
        }

        public StringTools(String texts[]) {
            this.texts = texts;
            str2 = " ";
        }

        public void PrintCharByChar() {
            for (char c : text.toCharArray()) {
                System.out.println(c);
            }
        }

        public void PrintCharByCharInverse() {
            StringBuilder sd = new StringBuilder(text);
            str = sd.reverse().toString();
            for (char ch : str.toCharArray()) {
                System.out.println(ch);
            }
        }

        public void PrintitemOfArray() {
            for (String text1 : texts) {
                System.out.println(text1);
            }
        }

        public String getStringArrayElemnt() {

            for (String text1 : texts) {
                str2 += text1 + ";";
            }
            return str2;
        }

    }

    public class Table {

        public int Columns;
        public Object Items[][];

        public Table(int Columns) {
            this.Columns = Columns;
            Items = new Object[0][Columns];
        }

        /* public Object [ ][ ] ReFull(Object Temp [ ][ ] , Object NewItem [ ][ ],Object NewR[])
    {
        for (int i = 0; i < Temp.length; i++) {
            for (int j = 0; j <Temp[i].length; j++) {
                 NewItem[i][j] =Temp[i][j];
                 if(i == Temp.length-1)
                 {
                     NewItem[i][j] = NewR[j];
                 }
            }
        }
        return NewItem;
    }
         */
        public void addNewRow(Object NewR[]) {
            Object Temp[][] = Items;
            Items = new Object[Items.length + 1][Columns];
            // ReFull(Temp, Items,NewR);
            for (int i = 0; i < Temp.length; i++) {
                Items[i] = Temp[i];

            }
            Items[Items.length - 1] = NewR;
        }

        public void PrintItems() {

            for (Object[] Item : Items) {
                for (Object object : Item) {
                    System.out.print(object + ":");
                }
                System.out.println("");
            }

        }

        public void editRow(int RIndex, int CIndex, Object newData) {
            Items[RIndex][CIndex] = newData;
        }

        public void delRow(int r) {
            Object temp[][] = Items;
            Items = new Object[Items.length - 1][Columns];
            int i = 0;
            int x = 0;
            for (i = 0; i < temp.length; i++) {

                if (i != r) {

                    Items[x] = temp[i];
                    x++;

                }

            }

        }

        public Object getValue(int r, int c) {
            return Items[r][c];
        }

        public Object[] getRow(int r) {
            return Items[r];
        }
    }

    
}
