import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*author:Dipshil Agrawal*/
class custom_exceptions extends Exception
{	
	private String detail;
	custom_exceptions(String d) throws IOException, custom_exceptions
		{
			detail=d;
		}
	public String toString()
	{
		return detail;
	}
}
public class depth_first_search 
{
    int[] visited=new int[50];
    int[][] graph=new int[20][20];
    int vertices;
    int end=0;
void dfs(int a)
{
    int j;
    System.out.print((char)('A'+a)+" ");
    visited[a]=1;
    for(j=0;j<vertices;j++)
    {
        if(graph[a][j]==1 && visited[j]==0)
                 dfs(j);  
    }
    System.out.println();
}
public static void main(String args[]) throws custom_exceptions, IOException
{
	depth_first_search d1=new depth_first_search();
        System.out.println("\t\t\t\t\t\tWELCOME TO DEPTH FIRST SEARCH PROGRAM");
	BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	Scanner ini= new Scanner(System.in);
	System.out.print("Please enter the number of vertices you want: ");
	d1.vertices=ini.nextInt();
	int e,count=0;
	char v='A';
	d1.graph=new int[d1.vertices][d1.vertices];
	String[] E=new String[d1.vertices];
        for(int i=0;i<d1.vertices;i++)
	{
		d1.visited[i]=0;
	}
	
	System.out.println("Please enter the value of E in the G(V,E) graph matrix given below:");
	System.out.print("\t\t\t");
	for(int i=0;i<d1.vertices;i++)
	{
		System.out.print(" "+(char)(v+i));
	}
	System.out.println("");
	for(int i=0;i<d1.vertices;i++)
	{
		System.out.print("\t\t\t"+(char)(v+i));
		E=in.readLine().split(" ");
		for(int j=0;j<d1.vertices;j++)
		{
			e=Integer.parseInt(E[j]);
			if(e!=1&&e!=0)
				throw new custom_exceptions("Wrong entry in Edge:program terminated!!");
			else
				d1.graph[i][j]=e;
		}
	}
	System.out.println("Your Adjencency Matrix is: ");
	for(int i=0;i<d1.vertices;i++)
	{
		System.out.print((char)(v+i)+" ");
	}
	System.out.println("");
	for(int i=0;i<d1.vertices;i++)
	{
		for(int j=0;j<d1.vertices;j++)
		{
				System.out.print(d1.graph[i][j]+" ");
		}
		System.out.println("");
	}
        int current_vertex=2;
        while(d1.end==0)
        {
        System.out.print("Enter the starting vertex:");
        char c=ini.next().charAt(0);
        current_vertex=((int)c-65);
        System.out.println("The ORDER is(Left---->Right): ");
        d1.dfs(current_vertex);
        System.out.println("Do you want to see Variation of path:(Y/N): ");
        char a=ini.next().charAt(0);
        if(a=='N'||a=='n')
        {
            d1.end=1;
        }
        }
}
}

