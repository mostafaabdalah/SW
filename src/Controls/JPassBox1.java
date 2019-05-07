/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Mustafa Saad
 */
public class JPassBox1  extends JPasswordField{
    
    public JPassBox1(int size){
        super(size);
        setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        super.paintComponent(g);
        
    }
   
    @Override
    public void paintBorder(Graphics g){
         g.setColor(new Color(40, 169, 190));
         g.drawRoundRect(0, 0,getWidth()-1, getHeight()-1, 40, 40);
    }
}
