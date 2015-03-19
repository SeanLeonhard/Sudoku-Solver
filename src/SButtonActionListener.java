import java.awt.event.*;
import javax.swing.*;

public class SButtonActionListener implements ActionListener
{
   private int[][] puzzle;
   private SButton button;
   
   private int row, col;
   private int[] selected;
   public JFrame frame;
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
      //puzzle[row][col] = selected[0];
     if(checkPoint(row,col,selected[0]))
     {
        puzzle[row][col] = selected[0];
        button.setText(selected[0] + "");
     }
     else
     {
         frame = new JFrame("Invalid Move");
         JOptionPane.showMessageDialog(frame,"That number cannot be placed there.");
     }
   }
   
   public boolean checkPoint(int row, int col, int a)
   {
      if(!checkRow(row,a))
      {
         return false;
      }
      if(!checkCol(col,a))
      {
         return false;
      }
      if(!checkCube(findCube(row,col),a))
      {
         return false;
      }
      return true;
     
   }
   
   boolean checkRow(int row, int a)
   {
      if(row>8)
      {
         return false;
      }
      for(int i = 0; i < 9; i++)
      {
         if(puzzle[row][i] == a)
         {
            return false;
         }
      }
      return true;
   }
   
   boolean checkCol(int col, int a)
   {
      if(col > 8)
      {
         return false;
      }
      for(int i = 0; i < 9; i++)
      {
         if(puzzle[i][col] == a)
         {
            return false;
         }
      }
      return true;
   }
   
   boolean checkCube(int cube, int a)
   {
      int[] check = new int[9];
      if(cube == 1)
      {
         check = new int[] {puzzle[0][0],puzzle[0][1],puzzle[0][2],puzzle[1][0],puzzle[1][1],puzzle[1][2],puzzle[2][0],puzzle[2][1],puzzle[2][2]};
      }
      if(cube == 2)
      {
         check = new int[] {puzzle[0][3],puzzle[1][3],puzzle[2][3],puzzle[0][4],puzzle[1][4],puzzle[2][4],puzzle[0][5],puzzle[1][5],puzzle[2][5]};
      }
      if(cube == 3)
      {
         check = new int[] {puzzle[0][6],puzzle[1][6],puzzle[2][6],puzzle[0][7],puzzle[1][7],puzzle[2][7],puzzle[0][8],puzzle[1][8],puzzle[2][8],};
      }
      if(cube == 4)
      {
         check = new int[] {puzzle[3][0],puzzle[3][1],puzzle[3][2],puzzle[4][0],puzzle[4][1],puzzle[4][2],puzzle[5][0],puzzle[5][1],puzzle[5][2]};
      }
      if(cube == 5)
      {
         check = new int[] {puzzle[3][3],puzzle[3][4],puzzle[3][5],puzzle[4][3],puzzle[4][4],puzzle[4][5],puzzle[5][3],puzzle[5][4],puzzle[5][5]};
      }
      if(cube == 6)
      {
         check = new int[] {puzzle[3][6],puzzle[3][7],puzzle[3][8],puzzle[4][6],puzzle[4][7],puzzle[4][8],puzzle[5][6],puzzle[5][7],puzzle[5][8]};
      }
      if(cube == 7)
      {
         check = new int[] {puzzle[6][0],puzzle[6][1],puzzle[6][2],puzzle[7][0],puzzle[7][1],puzzle[7][2],puzzle[8][0],puzzle[8][1],puzzle[8][2]};
      }
      if(cube == 8)
      {
         check = new int[] {puzzle[6][3],puzzle[6][4],puzzle[6][5],puzzle[7][3],puzzle[7][4],puzzle[7][5],puzzle[8][3],puzzle[8][4],puzzle[8][5]};
      }
      if(cube == 9)
      {
         check = new int[] {puzzle[6][6],puzzle[6][7],puzzle[6][8],puzzle[7][6],puzzle[7][7],puzzle[7][8],puzzle[8][6],puzzle[8][7],puzzle[8][8]};
      }
      
      for(int i = 0; i < 9; i++)
      {
         if(check[i] == a)
         {
            return false;
         }
      }
      return true;
   }
   
   int findCube(int row, int col)
   {  
      if(row > 5)
      {
         if(col > 5)
         {
            return 9;
         }
         else if (col > 2)
         {
            return 8;
         }
         else
         {
            return 7;
         }
      }
      else if(row > 2)
      {
         if ( col > 5)
         {
            return 6;
         }
         else if( col >2 )
         {
            return 5;
         }
         else
         {
            return 4;
         }
      }
      else
      {
         if(col > 5)
         {
            return 3;
         }
         else if( col >2 )
         {
            return 2;
         }
         else
         {
            return 1;
         }
      }
   }
   
   
}
