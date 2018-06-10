package n_queensgame;

// Placing n non-attacking queens on an n × n ChessBoard
// Author    :   Nishant Khanorkar

// Personal System Statistics : 
/*

Time required for 1(st) solution with all calculations :
for n=30 :  12  seconds
for n=31 :  3   seconds
for n=32 :  20  seconds
for n=33 :  34  seconds
for n=34 :  566 seconds
for n=35 :  57  seconds

*/

import static java.lang.System.exit;
import java.util.Scanner;

public class N_queensGame 
{
    static int n=12,pos[],count=1;
    static boolean occupied[];
    
    //n             -> Size of Board = n x n (n queens)
    //pos[a]=b      -> Queen is placed at Board[b][a] 
    //occupied[a]   -> If a(th) row contains any Queen
    //count         -> Solution Number
    
    public static void main(String[] args) 
    {
        Scanner ob=new Scanner(System.in);
        /*
        System.out.print("Enter no.of Queens : ");
        n=ob.nextInt();
        */
        pos=new int[n];
        occupied=new boolean[n];
        for(int k=0;k<n;k++)
            occupied[k]=false;
        if(n>0 && !(2<=n && n<=3))
            backtrack(0);
    }

    private static void backtrack(int j) 
    {
        if(j<n)
            OK: for(int k=0;k<n;k++)
            {
                if(!occupied[k])
                {
                    for(int i=0;i<j;i++)
                        if(Math.abs(pos[i]-k) == j-i)
                            continue OK;
                    pos[j]=k;
                    occupied[k]=true;
                    backtrack(j+1);
                    occupied[k]=false;
                }
            }
        else
        {
            System.out.print("\nFormation No. "+count+" :\n");
            count++;
            for(int i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                    if(pos[j]==i)
                        System.out.print("+  ");
                    else
                        System.out.print("-  ");
                System.out.println();
            }
            // Uncomment the line below for just 1st solution
            // exit(0);
        }
    }
}
