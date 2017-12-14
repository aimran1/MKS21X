import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUI extends JFrame implements ActionListener{

  private Container pane;
  private JButton b,b2;
  private ButtonGroup bg = new ButtonGroup();
  // private JCheckBox cf,fc;
  private JRadioButton cf,fc;
  private JTextField t;

  public void actionPerformed(ActionEvent e){
    String s = e.getActionCommand();
    System.out.println(s);
    if (s.equals("Convert")){
      if(cf.isSelected()){
        t.setText(CtoF(Double.parseDouble(t.getText())) + "");
      }
      else if(fc.isSelected()){
        t.setText(FtoC(Double.parseDouble(t.getText())) + "");
      }
      else {
        t.setText("Enter A Number and Select a Conversion");
      }
    }
    if (s.equals("Clear")){
      t.setText("");
    }
  }

  public GUI(){
    this.setTitle("Temperature Conversion");
    this.setSize(600,400);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new FlowLayout());
    b = new JButton("Convert");
    b2 = new JButton("Clear");
    // cf = new JCheckBox("Celsius to Fahrenheit");
    // fc = new JCheckBox("Fahrenheit to Celsius");
    cf = new JRadioButton("Celsius to Fahrenheit");
    fc = new JRadioButton("Fahrenheit to Celsius");
    bg.add(cf);
    bg.add(fc);
    t = new JTextField(20);

    b.addActionListener(this);
    b2.addActionListener(this);
    cf.addActionListener(this);
    fc.addActionListener(this);
    t.addActionListener(this);

    pane.add(t);
    pane.add(cf);
    pane.add(fc);
    pane.add(b);
    pane.add(b2);
  }

  public static double CtoF(double t){
    return t * 9.0 / 5.0 + 32;
  }

  public static double FtoC(double t){
    return (t - 32) * 5.0 / 9.0 ;
      }

  public static void main(String[] args){
    GUI g = new GUI();
    g.setVisible(true);
  }
}
