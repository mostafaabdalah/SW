/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import javax.swing.JButton;


/**
 *
 * @author Mustafa Saad
 */
public class JMyButton3  extends JButton{
    
    public JMyButton3(){
        setOpaque(false);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    @Override
    protected void paintComponent(Graphics g){
        g.setColor(new Color(239, 116, 83));
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        super.paintComponent(g);
        
    }
   
    @Override
    public void paintBorder(Graphics g){
         g.setColor(new Color(239, 116, 83));
         g.drawRoundRect(0, 0,getWidth()-1, getHeight()-1, 40, 40);
    }
}
