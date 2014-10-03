import java.awt.event.*;
import javax.swing.*;

public class MButtonActionListener implements ActionListener
{
   
   private int value;
   private int[] selected;
   //private JLabel totalP;
   
   public MButtonActionListener(int[] s, int v)
   {
      super();
      selected = s;
      value = v;
   }
   
   public void actionPerformed(ActionEvent e)
   {
      selected[0] = value;
   }
   
   //totalP.setText("Current Power Available : " + totalPower);
}
