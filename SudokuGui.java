import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SudokuGui
{
   private int[][] puzzle;
   private int[][] cubes;
   private int[] selected;
   
   private JFrame frame;
   private JPanel panel;
   private JPanel panel2;
   private JPanel panel3;
   private JPanel panelDisplay;
   private SButton[][] puzzleButton;
   private SButton[][] menuButton;
   private JButton solveStep;
   private JButton solve;
   private JButton clear;
   private GridBagConstraints c;
   private GridBagConstraints d;
   private GridBagConstraints e;
   
   public SudokuGui()
   {    
      puzzle = new int[9][9];
      cubes = new int[9][9];
      selected = new int[1];
       forceValue(0,0,5);
       forceValue(0,1,3);
       forceValue(0,4,7);
       forceValue(1,0,6);
       forceValue(1,3,1);
       forceValue(1,4,9);
       forceValue(1,5,5);
       forceValue(2,1,9);
       forceValue(2,2,8);
       forceValue(2,7,6);
       forceValue(3,0,8);
       forceValue(3,8,3);
       forceValue(3,4,6);
       forceValue(4,0,4);
       forceValue(4,3,8);
       forceValue(4,5,3);
       forceValue(4,8,1);
       forceValue(5,0,7);
       forceValue(5,4,2);
       forceValue(5,8,6);
       forceValue(6,1,6);
       forceValue(6,6,2);
       forceValue(6,7,8);
       forceValue(7,3,4);
       forceValue(7,4,1);
       forceValue(7,5,9);
       forceValue(7,8,5);
       forceValue(8,4,8);
       forceValue(8,7,7);
       forceValue(8,8,9);
      
      selected[0] = 0;
      intialize();
      solveStep = new JButton("Step");
      solve = new JButton("Solve");
      clear = new JButton("Clear");
      puzzleButton = new SButton[9][9];
      menuButton = new SButton[3][3];
      for(int i = 0; i < 9; i++)
      {
         for(int j = 0; j < 9; j++)
         {
            puzzleButton[i][j] = new SButton(puzzle[i][j] + "");
         }
      }
      for(int i = 0; i < 3; i++)
      {
         for(int j = 0; j < 3; j++)
         {
            menuButton[i][j] = new SButton(((i+1) + j*3) + "");
         }
      }
      initGui();
      initButtons();
   }
   
   public void initGui()
   {
      frame = new JFrame("Sean's Sudoku Solver");
      frame.setSize(900,900);
      frame.getContentPane();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      panel = new JPanel(new GridBagLayout());
      panel.setBackground(Color.WHITE);
      c = new GridBagConstraints();
      c.insets = new Insets(10, 10, 10, 10);
      
      panel2 = new JPanel(new GridBagLayout());
      panel2.setBackground(Color.BLACK);
      d = new GridBagConstraints();
      d.insets = new Insets(5, 5, 5, 5);
      
      panel3 = new JPanel(new GridBagLayout());
      panel3.setBackground(Color.BLACK);
      e = new GridBagConstraints();
      e.insets = new Insets(30,30,30,30);
      
      
      frame.add(panel, BorderLayout.CENTER);
      frame.add(panel2, BorderLayout.SOUTH);
      frame.add(panel3, BorderLayout.NORTH);
   }
   
   public void initButtons()
   {
      for(int i = 0; i < 9; i++)
      {
         c.gridy = i;
         for(int j = 0; j < 9; j++)
         {
            c.gridx = j;
            //puzzleButton[i][j] = new SButton(puzzle[i][j] + "");
            puzzleButton[i][j].addActionListener(new SButtonActionListener(puzzle, i, j, selected, puzzleButton[i][j]));
            panel.add(puzzleButton[i][j],c);
         }
      }
      
      for(int i = 0; i < 3; i++)
      {
         d.gridy = i;
         for(int j = 0; j < 3; j++)
         {
            d.gridx = j;
            menuButton[i][j].addActionListener(new MButtonActionListener(selected,((i+1) + j*3)));
            panel2.add(menuButton[i][j],d); 
         }
      }
      
      e.gridx = -30;
      solveStep.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            solve();
            updateButtons();
         }
      });
      panel3.add(solveStep,e);
      
      e.gridx = 30;
      solve.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            while(!isComplete())
            {
               solve();
            }
            updateButtons();
         }
      });
      panel3.add(solve,e);
      
      e.gridx = 0;
      clear.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            for(int i = 0; i < 9; i++)
            {
               for(int j = 0; j < 9; j++)
               {
                  puzzle[i][j] = 0;
               }
            }
            updateButtons();
         }
      });
      panel3.add(clear, e);
      
      
      frame.setVisible(true);
   }
   
   public void intialize()
   {
      int[][] puzzle = new int[9][9];
      for(int i = 0; i < 9; i++)
      {
         for(int j = 0; j < 9; j++)
         {
            puzzle[i][j] = 0;
         }    
      }
   }
   
   public void updateButtons()
   {
      for(int i = 0; i < 9; i++)
      {
         for(int j = 0; j < 9; j++)
         {
            puzzleButton[i][j].setText(puzzle[i][j] + "");
         }
      }
   }
   
   public void updateCubes()
   {
      cubes[0] = new int[] {puzzle[0][0],puzzle[0][1],puzzle[0][2],puzzle[1][0],puzzle[1][1],puzzle[1][2],puzzle[2][0],puzzle[2][1],puzzle[2][2]};
      cubes[1] = new int[] {puzzle[0][3],puzzle[0][4],puzzle[0][5],puzzle[1][3],puzzle[1][4],puzzle[1][5],puzzle[2][3],puzzle[2][4],puzzle[2][5]};
      cubes[2] = new int[] {puzzle[0][6],puzzle[0][7],puzzle[0][8],puzzle[1][6],puzzle[1][7],puzzle[1][8],puzzle[2][6],puzzle[2][7],puzzle[2][8]};      
      cubes[3] = new int[] {puzzle[3][0],puzzle[3][1],puzzle[3][2],puzzle[4][0],puzzle[4][1],puzzle[4][2],puzzle[5][0],puzzle[5][1],puzzle[5][2]};      
      cubes[4] = new int[] {puzzle[3][3],puzzle[3][4],puzzle[3][5],puzzle[4][3],puzzle[4][4],puzzle[4][5],puzzle[5][3],puzzle[5][4],puzzle[5][5]};
      cubes[5] = new int[] {puzzle[3][6],puzzle[3][7],puzzle[3][8],puzzle[4][6],puzzle[4][7],puzzle[4][8],puzzle[5][6],puzzle[5][7],puzzle[5][8]};      
      cubes[6] = new int[] {puzzle[6][0],puzzle[6][1],puzzle[6][2],puzzle[7][0],puzzle[7][1],puzzle[7][2],puzzle[8][0],puzzle[8][1],puzzle[8][2]};      
      cubes[7] = new int[] {puzzle[6][3],puzzle[6][4],puzzle[6][5],puzzle[7][3],puzzle[7][4],puzzle[7][5],puzzle[8][3],puzzle[8][4],puzzle[8][5]};
      cubes[8] = new int[] {puzzle[6][6],puzzle[6][7],puzzle[6][8],puzzle[7][6],puzzle[7][7],puzzle[7][8],puzzle[8][6],puzzle[8][7],puzzle[8][8]};
   }
   
   public void updateRowAndCol()
   {
      for(int i = 0; i < 9; i++)
      {
         for(int j = 0; j < 9; j++)
         {
            puzzle[i][j] = cubes[((i/3*3)+j/3)][i%3*3 + j%3];
         }
      }
   }
   
   public void solve()
   {
      for(int i = 0; i < 9; i++)
      {
         for(int j = 0; j < 9; j++)
         {
            int possibles = 0;
            String possibilities = "";
            for(int d = 1; d < 10; d++)
            {
               if(checkPoint(i,j,d))
               {
                  possibilities += d + "";
                  possibles++; 
               }
            }
            if(possibles == 1 && puzzle[i][j] == 0)
            {
               puzzle[i][j] = Integer.parseInt(possibilities);
               updateCubes();
            }
         }
      }
   }
   
   /*
   *  Use an array to go through each cube, then another array to go through each place in each cube. then if the place is empty go through 1-9 to check and see if 
   */
   public void cubeSolve()
   {   
      updateCubes();
      for(int i = 0; i < 9; i++)
      {
         String[] possibilities = {"","","","","","","","",""};
         for(int j = 0; j < 9; j++)
         {
            int a[] = getRowAndCol(i,j+1);
            for(int x = 1; x < 10; x++)
            {
               //System.out.println((puzzle[a[0]][a[1]] == 0) + " " + checkPoint(a[0],a[1], x) + " " + a[0] + " " + a[1] + " " + i + " " + j + " " + x);
               if(puzzle[a[0]][a[1]] == 0 && checkPoint(a[0],a[1], x))
               {
                  possibilities[j] = possibilities[j] + "" + x + "";
                  //System.out.println(possibilities[j] + " " + a[0] + " " + a[1]);
               }
            }
         }
         for(int j = 0; j < 9; j++)
         {  
            String outruled = "";
            if(possibilities[j].length() > 0)
            {
               for(int x = 0; x < possibilities[j].length(); x++)
               {
                  if(outruled.contains(possibilities[j].substring(x,x+1)))
                  {
                     possibilities[j] = possibilities[j].substring(0,x)+possibilities[j].substring(x+1,possibilities[j].length());
                     //System.out.println(possibilities[j]);
                  }
                  else
                  {
                     for(int y = 0; y < 9; y++)
                     {
                        if(j != y)
                        {
                           
                              if(x < possibilities[j].length())
                              {
                                 if(possibilities[y].contains(possibilities[j].substring(x,x+1)))
                                 {
                                    outruled = outruled + possibilities[j].substring(x,x+1);
                                    //System.out.println(outruled + " " + y + " " + j);
                                    if(possibilities[y].indexOf(possibilities[j].substring(x,x+1)) > possibilities[y].length())
                                    {
                                       possibilities[y] = possibilities[y].substring(0,possibilities[y].length()-1);
                                    }
                                    else
                                    { 
                                       possibilities[y] = possibilities[y].substring(0,possibilities[y].indexOf(possibilities[j].substring(x,x+1))) + possibilities[y].substring(possibilities[y].indexOf(possibilities[j].substring(x,x+1))+1,possibilities[y].length());
                                    }
                                    possibilities[j] = possibilities[j].substring(0,x)+possibilities[j].substring(x+1,possibilities[j].length());
                                    
                                    //System.out.println(possibilities[j]);
                                 }
                              }
                           
                        }
                     }
                  }
               }
            }
            if(possibilities[j].length() == 1 && cubes[i][j] == 0)
            {
               //System.out.println(possibilities[j]);
               int b[] = getRowAndCol(i,j+1);
               if(checkPoint(b[0],b[1],Integer.parseInt(possibilities[j])))
               {
                  //System.out.println(checkPoint(b[0],b[1],Integer.parseInt(possibilities[j])) + " " + b[0] + " " + b[1] + " " + i + " " + j + " " + Integer.parseInt(possibilities[j]));
                  puzzle[b[0]][b[1]] = Integer.parseInt(possibilities[j]);
                  updateCubes();
               }
            }
            //updateRowAndCol();
         }
      }
   }
   
   
   public boolean isComplete()
   {
      for(int i = 0; i < 9; i ++)
      {
         for(int j = 0; j < 9; j++)
         {
            if(puzzle[i][j] == 0)
            {
               return false;
            }
         }
      }
      return true;
   }
   
   public void forceValue(int a, int b, int c)
   {
      puzzle[a][b] = c;
   }
   
   public void cubeForce(int a, int b, int c)
   {
      cubes[a][b] = c;
   }
   
   public void setCheck(int a, int b, int c)
   {
      if(a < 9 && b < 9)
      {
         if(checkPoint(a,b,c))
         {
            puzzle[a][b] = c;
         }
         else
         {
            System.out.println("Error: not a valid point, please try again.");
         }
      }
      else
      {
         System.out.println("Error: grid point input out of bounds.");
      }
   }
   
   public void printPuzzle()
   {
      System.out.println("");
      for(int i = 0; i < 9; i++)
      {
         for(int j = 0; j < 9; j++)
         {
            System.out.print(puzzle[i][j]);
            if(j == 2 || j == 5)
            {
               System.out.print("|");
            }
         }
         System.out.println(" ");
         if(i == 2 || i == 5)
         {
            System.out.println("------------");
         }
      }
      System.out.println("");
   }
   
   public boolean checkRow(int row, int a)
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
   
   public boolean checkCol(int col, int a)
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
   
   public boolean checkCube(int cube, int a)
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
   
   public int[] getRowAndCol(int cube, int place)
   {
      int[] r = new int[2];
      //row <then> col
      if(cube <= 3)
      {
         if(place < 4)
         {
            r[0] = 0;
         }
         else if(place < 7)
         {
            r[0] = 1;
         }
         else
         {
            r[0] = 2;
         }
         if(place%3 == 1)
         {
            r[1] = 0;
         }
         else if(place%3 == 2)
         {
            r[1] = 1;
         }
         else
         {
            r[1] = 2;
         }
      }
      else if(cube <= 6)
      {
         if(place < 4)
         {
            r[0] = 3;
         }
         else if(place < 7)
         {
            r[0] = 4;
         }
         else
         {
            r[0] = 5;
         }
         if(place%3 == 1)
         {
            r[1] = 3;
         }
         else if(place%3 == 2)
         {
            r[1] = 4;
         }
         else
         {
            r[1] = 5;
         }
         return r;
      }
      else
      {
         if(place < 4)
         {
            r[0] = 6;
         }
         else if(place < 7)
         {
            r[0] = 7;
         }
         else
         {
            r[0] = 8;
         }
         if(place%3 == 1)
         {
            r[1] = 6;
         }
         else if(place%3 == 2)
         {
            r[1] = 7;
         }
         else
         {
            r[1] = 8;
         }
      }
      return r;
   }
   
   public int findCube(int row, int col)
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
   
   public int[][] returnPuzzle()
   {
      return puzzle;
   }
}

/*                                  Trash Code
   public void cubeSolve()
   {
      updateCubes();
      int[] temp = new int[9];
      int[] unfound = new int[9];
      int[][] possible = new int[9][9];
      int[] rcs = new int[2];//Row Column Storage
      ArrayList<int> holder = new ArrayList<int>();
      for(int i = 0; i < 9; i++)
      {
         unfound = new int[] {1,2,3,4,5,6,7,8,9};
         for(int x = 0; x < 9; x++)
         {
            possible[x] = new int[] {1,2,3,4,5,6,7,8,9};
         }
         temp = cubes[i];//temp holds cubes' puzzle[][] values
         for(int j = 0; j < 9; j++)
         {
            unfound[temp[j]] = 0;
         }
         for(int j = 0; j < 9; j++)
         {
            if(unfound[j] != 0)
            {
               holder.add(unfound[j]);
            }
         }
         for(int j = 0; j < holder.size();j++)
         {
            for(int x = 1; x < 10; x++)
            {
               rcs = getRowAndCol(i,x)
               if(checkPoint(rcs[0],rcs[1],holder.get(j)))
               {
                  possible[i][j] = 
               }
            }
         }
      }
   }
    
      unfound = unfound.substring(0,unfound.instanceOf(temp[j] + "")) + unfound.substring(unfound.instanceOf(temp[j] + "")+1,unfound.length());
   */
