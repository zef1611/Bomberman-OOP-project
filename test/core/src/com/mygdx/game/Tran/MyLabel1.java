import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MyLabel1 extends JLabel {
    MyLabel1(){
        ImageIcon image = new ImageIcon("Start.png");

        //JLabel label = new JLabel();
        //this.setText("Bommerman ahihi");
        this.setIcon(image);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.CENTER);
        //this.setForeground(Color.GREEN);
        this.setFont(new Font("MV Boli",Font.PLAIN,40));
        this.setIconTextGap(0);
        /*label.setBackground(Color.green);
        label.setOpaque(true);*/
        this.setVerticalAlignment(JLabel.CENTER);
        //this.setHorizontalAlignment(JLabel.CENTER);
        this.setBounds(0, 0, 1000, 600);
        
        
    }
}