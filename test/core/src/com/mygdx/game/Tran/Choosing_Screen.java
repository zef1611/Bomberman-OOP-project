import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class Choosing_Screen extends JFrame implements ActionListener {
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton button10;

    Choosing_Screen(){
        MyLabel2 myLabel2 = new MyLabel2();

        button3 = new JButton();
        button3.setBounds(50, 150, 180, 105);    //chỉnh sau nhé huhu
        button3.addActionListener(this);
        button3.setText("Map 1");
        button3.setFocusable(false);
        button3.setFont(new Font("Algerian",Font.PLAIN,30));//thich thi chinh font chu lai
        button3.setForeground(Color.black);
        button3.setBackground(Color.white);

        button4 = new JButton();
        button4.setBounds(260, 150, 180, 105);    //chỉnh sau nhé huhu
        button4.addActionListener(this);
        button4.setText("Map 2");
        button4.setFocusable(false);
        button4.setFont(new Font("Algerian",Font.PLAIN,30));//thich thi chinh font chu lai
        button4.setForeground(Color.black);
        button4.setBackground(Color.white);

        button5 = new JButton();
        button5.setBounds(470, 150, 180, 105);    //chỉnh sau nhé huhu
        button5.addActionListener(this);
        button5.setText("Map 3");
        button5.setFocusable(false);
        button5.setFont(new Font("Algerian",Font.PLAIN,30));//thich thi chinh font chu lai
        button5.setForeground(Color.black);
        button5.setBackground(Color.white);

        button6 = new JButton();
        button6.setBounds(690, 150, 180, 105);    //chỉnh sau nhé huhu
        button6.addActionListener(this);
        button6.setText("Map 4");
        button6.setFocusable(false);
        button6.setFont(new Font("Algerian",Font.PLAIN,30));//thich thi chinh font chu lai
        button6.setForeground(Color.black);
        button6.setBackground(Color.white);

        button7 = new JButton();
        button7.setBounds(50, 350, 180, 105);    //chỉnh sau nhé huhu
        button7.addActionListener(this);
        button7.setText("Map 5");
        button7.setFocusable(false);
        button7.setFont(new Font("Algerian",Font.PLAIN,30));//thich thi chinh font chu lai
        button7.setForeground(Color.black);
        button7.setBackground(Color.white);

        button8 = new JButton();
        button8.setBounds(260, 350, 180, 105);    //chỉnh sau nhé huhu
        button8.addActionListener(this);
        button8.setText("Map 6");
        button8.setFocusable(false);
        button8.setFont(new Font("Algerian",Font.PLAIN,30));//thich thi chinh font chu lai
        button8.setForeground(Color.black);
        button8.setBackground(Color.white);

        button9 = new JButton();
        button9.setBounds(470, 350, 180, 105);    //chỉnh sau nhé huhu
        button9.addActionListener(this);
        button9.setText("Map 7");
        button9.setFocusable(false);
        button9.setFont(new Font("Algerian",Font.PLAIN,30));//thich thi chinh font chu lai
        button9.setForeground(Color.black);
        button9.setBackground(Color.white);

        button10 = new JButton();
        button10.setBounds(680, 350, 180, 105);    //chỉnh sau nhé huhu
        button10.addActionListener(this);
        button10.setText("Map 8");
        button10.setFocusable(false);
        button10.setFont(new Font("Algerian",Font.PLAIN,30));//thich thi chinh font chu lai
        button10.setForeground(Color.black);
        button10.setBackground(Color.white);

        
        this.setTitle("Bommerman");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(915,640);
        this.setVisible(true);
        this.setLayout(null);
        this.add(myLabel2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(button7);
        this.add(button8);
        this.add(button9);
        this.add(button10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}