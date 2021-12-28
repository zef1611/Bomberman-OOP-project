package com.mygdx.game.Tran;


import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MyLabel2 extends JLabel {
    MyLabel2(){
        ImageIcon image = new ImageIcon("Start.png");

        //JLabel label = new JLabel();
        this.setText("Choose a map");
        this.setIcon(image);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.TOP);
        this.setForeground(Color.BLACK);
        this.setFont(new Font("Algerian",Font.PLAIN,55));
        this.setIconTextGap(-90);
        /*label.setBackground(Color.green);
        label.setOpaque(true);*/
        this.setVerticalAlignment(JLabel.TOP);
        //this.setHorizontalAlignment(JLabel.CENTER);
        this.setBounds(0, 0, 1000, 600);

        
    }
}