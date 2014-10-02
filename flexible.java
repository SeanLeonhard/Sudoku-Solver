import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Sean
 */
public class flexible 
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        ArrayList spaces = new ArrayList();
        int width = scan.nextInt();
        int partitions = scan.nextInt();
        int[] office = new int[partitions+2];
        for(int i = 1; i < partitions+1; i++)
        {
            office[i] = scan.nextInt();
        }
        office[0] = 0;
        office[partitions+1] = width;
        for(int i = 0; i < office.length; i++)
        {
            for(int j = i+1; j < office.length; j++)
            {
                spaces.add(office[j] - office[i]);
            }
        }
        Collections.sort(spaces);
        for(int i = 0; i < spaces.size()-1; i++)
        {
            if(spaces.get(i) == spaces.get(i+1))
            {
                spaces.remove(i);
                i = i -1;
            }
        }
        for(int i = 0; i < spaces.size(); i++)
        {
            System.out.print(spaces.get(i)+ " ") ;
        }
    }
}
