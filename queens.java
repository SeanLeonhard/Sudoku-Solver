import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author Sean
 */
public class queens {
    
    
    public queens(String [] lines)
    {
        String[][] board = new String[8][8];
        
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scan = new Scanner(new File("data.in"));
        Scanner scan = new Scanner(System.in);
        String[] lines = new String[8];
        String[][] board = new String[8][8];
        int a = 0;
        while(scan.hasNext() && a < 8)
        {
            lines[a] = scan.next();
            if(lines[a].length() != 8 )
            {
                System.out.println("invalid");
                System.exit(0);
            }
            a++;
        }
        for(int j = 0; j < 8; j++)
        {
            for(int i = 0; i < 8; i++)
            {
                board[j][i] = lines[j].substring(i,i+1);
            }
        }
        int[] length = new int[8];
        int[] height = new int[8];
        int count = 0;
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(board[i][j].equals("*"))
                {
                    count++;
                    length[i] = length[i] + 1;
                    height[j] = height[j] + 1;
                    int counter = 1;
                    while( i-counter > -1 && j-counter > -1)
                    {   
                        if(board[i-counter][j-counter].equals("*"))
                        {   
                            System.out.println("invalid");
                            System.exit(0);
                        }
                        counter++;
                    }
                    counter = 1;
                    while( i+counter < 8 && j+counter < 8)
                    {
                        if(board[i+counter][j+counter].equals("*"))
                        {   
                            System.out.println("invalid");
                            System.exit(0);
                        }
                        counter++;
                    }
                    counter = 1;
                    while(i+counter < 8 && j-counter > -1)
                    {
                        if(board[i+counter][j-counter].equals("*"))
                        {
                            System.out.println("invalid");
                            System.exit(0);
                        }
                    }
                    counter = 1;
                    while(i-counter > -1 && j+counter <8)
                    {
                        if(board[i-counter][j+counter].equals("*"))
                        {
                            System.out.println("invalid");
                            System.exit(0);
                        }
                    }
                }
            }
        }
        if(count != 8)
        {
            return false;
        }
        for(int i = 0; i < 8; i++)
        {
            if(height[i] > 1 || length[i] > 1)
            {
                System.out.println("invalid");
                System.exit(0);
            }
        }
        
        
        System.out.println("valid");
        System.exit(0);
    }
}
