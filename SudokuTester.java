public class SudokuTester
{
   public static void main(String[] args)
   {
      ///int[ROW][COL]
      Sudoku a = new Sudoku();
      /*a.printPuzzle();
      a.forceValue(5,0,9);
      a.forceValue(0,5,3);
      a.printPuzzle();
      System.out.println(a.checkRow(5,9));
      System.out.println(a.checkCol(5,3));
      System.out.println(a.checkCol(8,9));
      System.out.println(a.checkRow(8,0));
      a.setCheck(0,6,3);
      a.printPuzzle();
      a.setCheck(0,2,2);
      a.printPuzzle();
      */
 
      
      /*
       //TEST COMPLETE
      a.forceValue(0,0,5);
      a.forceValue(0,1,3);
      a.forceValue(0,4,7);
      a.forceValue(1,0,6);
      a.forceValue(1,3,1);
      a.forceValue(1,4,9);
      a.forceValue(1,5,5);
      a.forceValue(2,1,9);
      a.forceValue(2,2,8);
      a.forceValue(2,7,6);
      a.forceValue(3,0,8);
      a.forceValue(3,8,3);
      a.forceValue(3,4,6);
      a.forceValue(4,0,4);
      a.forceValue(4,3,8);
      a.forceValue(4,5,3);
      a.forceValue(4,8,1);
      a.forceValue(5,0,7);
      a.forceValue(5,4,2);
      a.forceValue(5,8,6);
      a.forceValue(6,1,6);
      a.forceValue(6,6,2);
      a.forceValue(6,7,8);
      a.forceValue(7,3,4);
      a.forceValue(7,4,1);
      a.forceValue(7,5,9);
      a.forceValue(7,8,5);
      a.forceValue(8,4,8);
      a.forceValue(8,7,7);
      a.forceValue(8,8,9);
      
      a.printPuzzle();
      for(int i = 0; i < 50; i++)
      {
         a.solve();
      }
      a.printPuzzle();
      */
      /*
      a.forceValue(0,1,8);
      a.forceValue(0,4,1);
      a.forceValue(0,7,2);
      a.forceValue(1,0,6);
      a.forceValue(1,3,3);
      a.forceValue(1,5,5);
      a.forceValue(1,8,1);
      a.forceValue(2,2,7);
      a.forceValue(2,6,4);
      a.forceValue(3,1,2);
      a.forceValue(3,3,1);
      a.forceValue(3,5,9);
      a.forceValue(3,7,5);
      a.forceValue(4,0,7);
      a.forceValue(4,8,6);
      a.forceValue(5,1,9);
      a.forceValue(5,3,6);
      a.forceValue(5,5,3);
      a.forceValue(5,7,4);
      a.forceValue(6,2,5);
      a.forceValue(6,6,3);
      a.forceValue(7,0,9);
      a.forceValue(7,3,2);
      a.forceValue(7,5,1);
      a.forceValue(7,8,8);
      a.forceValue(8,1,3);
      a.forceValue(8,4,6);
      a.forceValue(8,7,7);
      
      a.printPuzzle();
      /*for(int i = 0; i < 50; i++)
      {
         a.solve();
      }
      a.printPuzzle();
      for(int i = 0; i < 50; i++)
      {
         //a.solve();
         a.cubeSolve();
      }
      
      a.printPuzzle();*/
      
      SudokuGui b = new SudokuGui();
      
   }
}
