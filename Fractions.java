import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sean
 */
public class Fractions {
    
    public static void main(String[] args)
    {
        ArrayList<String> folder = new ArrayList();
        Scanner scan = new Scanner(System.in);
        String temp = "";
        boolean a = true;
        while(a)
        {
            temp = scan.nextLine();
            if(temp.equals("0 0"))
            {
                a = false;
            }
            else
            {
                folder.add(temp);    
            }
        }
        
        int[][] fractions = new int[folder.size()][2];
        for(int i = 0; i < folder.size(); i++)
        {
            fractions[i][0] = Integer.parseInt(folder.get(i).substring(0,folder.get(i).indexOf(" ")));
            fractions[i][1] = Integer.parseInt(folder.get(i).substring(folder.get(i).indexOf(" ")+1,folder.get(i).length()));
            System.out.println(fractions[i][0] / fractions[i][1] + " " + fractions[i][0]%fractions[i][1] + " / " + fractions[i][1]);
        }    
    }
}
