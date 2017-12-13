import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class GUI extends JFrame implements ActionListener{

    public GUI(){
	this.setTitle("Temperature Conversion");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static double CtoF(double t){
	return t * 9.0 / 5.0 + 32;
    }

    public static double FtoC(double t){
	return (t - 32) * 5.0 / 9.0 
    }


    
    public static void main(String[] args){
	GUI g = new GUI();
	g.setVisible(true);
	//System.out.println(CtoF(110));
    	//System.out.println(FtoC(225));
    }
}
