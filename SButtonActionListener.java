import java.awt.event.*;
import javax.swing.*;

public class SButtonActionListener implements ActionListener
{
   private int[][] puzzle;
   private SButton button;
   
   private int row, col;
   private int[] selected;
   //private JLabel totalP;
   
   public SButtonActionListener(int[][] p, int r, int c, int[] s, SButton a)
   {
      super();
      puzzle = p;
      row = r;
      col = c;
      selected = s;
      button = a;
   }
   
   public void actionPerformed(ActionEvent e)
   {
      puzzle[row][col] = selected[0];
      button.setText(selected[0] + "");
   }
   
   //totalP.setText("Current Power Available : " + totalPower);
}
