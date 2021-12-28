import javax.swing.JFrame;
/*import java.awt.Color;*/
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Starting_Screen extends JFrame implements ActionListener{
    JButton button;
    //JButton button2;

    Starting_Screen(){
        //JFrame frame = new JFrame();
        
        MyLabel1 myLabel1 = new MyLabel1();
        button = new JButton();
        button.setBounds(150, 350, 200, 75);    //chỉnh sau nhé huhu
        button.addActionListener(this);
        button.setText("Start");
        button.setFocusable(false);
        button.setFont(new Font("Comic Sans",Font.PLAIN,30));//thich thi chinh font chu lai
        button.setForeground(Color.black);
        button.setBackground(Color.white);

        /*button2 = new JButton();
        button2.setBounds(170, 450, 200, 75);
        button2.addActionListener(this);
        button2.setText("Setting");
        button2.setFocusable(false);
        button2.setFont(new Font("Comic Sans",Font.PLAIN,30));//thich thi chinh font chu lai
        button2.setForeground(Color.white);
        button2.setBackground(Color.green);*/
        
        this.setTitle("Bommerman");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(915,640);
        this.setVisible(true);
        this.setLayout(null);
        this.add(myLabel1);
        //this.pack();
        this.add(button);
        //this.add(button2);
        

        ImageIcon image = new ImageIcon("Bomberman_Logo.png"); //thay thành bomerman_icon.png
        this.setIconImage(image.getImage());
        /*this.getContentPane().setBackground(Color.green); //set color*/
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            this.dispose();
            Choosing_Screen myFrameScreen = new Choosing_Screen();
        }
        /*if(e.getSource()==button2){
            System.out.println("Poo2");*/
        }
        
    }


