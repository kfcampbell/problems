import java.util.*;

public class ATaleOfThreeCities
{

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

 	// default public constructor
    public ATaleOfThreeCities()
    {
        System.out.println("test");
    }
    
    // helper method that returns distance between two points
    public double distance(int ax, int ay, int bx, int by)
    {
     	int absXDist = Math.abs(bx - ax);
        int absYDist = Math.abs(by - ay);
        
        int squaredXDist = absXDist*absXDist;
        int squaredYDist = absYDist*absYDist;
        
        return Math.sqrt(squaredXDist + squaredYDist);
    }
    
    public double connect(int[] ax, int[] ay, int[] bx, int[] by, int[] cx, int[] cy)
    {
     	// double ab[] = new double[ax.length*bx.length]; // stores possible bridge lengths between A and B
      //   double ac[] = new double[ax.length*cx.length]; // between A and C
      //   double bc[] = new double[bx.length*cx.length]; // between B and C

        double ab[] = new double[500]; // stores possible bridge lengths between A and B
        double ac[] = new double[500]; // between A and C
        double bc[] = new double[500]; // between B and C
        
        double dist = 0;
        int index = 0;
        
        // now find all the possible bridge lengths between A and B
        for(int i = 0; i < ax.length; i++)
        {
			for(int j = 0; j < bx.length; j++)
            {
             	dist = distance(ax[i], ay[i], bx[j], by[j]);
                ab[index] = dist;
                index++;
            }
        }
        
        // same for A and C
        for(int i = 0; i < ax.length; i++)
        {
			for(int j = 0; j < cx.length; j++)
            {
             	dist = distance(ax[i], ay[i], cx[j], cy[j]);
                ac[index] = dist;
                index++;
            }
        }
        
        // same for B and C
        for(int i = 0; i < bx.length; i++)
        {
			for(int j = 0; j < cx.length; j++)
            {
             	dist = distance(bx[i], by[i], cx[j], cy[j]);
                bc[index] = dist;
                index++;
            }
        }
        
        // now find the minimum two values for tunnels between two cities
        double tunnelA = ab[0];
        double tunnelB = ac[0];
        double tunnelC = bc[0];
        
        // find the minimum distance between cities A and B
        for(int i = 0; i < ab.length; i++)
        {
            if(ab[i] > tunnelA)
            {
        		tunnelA = ab[i];        
            }
        }
        
        // find the minimum distance between cities A and C
        for(int i = 0; i < ac.length; i++)
        {
            if(ac[i] > tunnelB)
            {
        		tunnelB = ac[i];        
            }
        }
        
        // find the minimum distance between cities B and C
        for(int i = 0; i < bc.length; i++)
        {
            if(bc[i] > tunnelC)
            {
        		tunnelC = bc[i];        
            }
        }
        
        // now return the sum of the lowest two distances
        if(tunnelA < tunnelB && tunnelB < tunnelC) // A < B < C => A+B
        {
            return(tunnelA + tunnelC);
        }
        
        if(tunnelA < tunnelB && tunnelB >= tunnelC) // A < C < B => A+C
        {
        	return(tunnelA + tunnelC);    
        }
        
        if(tunnelB < tunnelA && tunnelA < tunnelC) // B < A < C => B+A
        {
    		return(tunnelB + tunnelA);   
        }
        
        if(tunnelB < tunnelA && tunnelA >= tunnelC) // B < C < A => B+C
        {
    		return(tunnelB + tunnelC);        
        }
        
        if(tunnelC < tunnelB && tunnelB < tunnelA) // C < B < A => C+B
        {
        	return(tunnelC + tunnelB);    
        }
        
        if(tunnelC < tunnelB && tunnelB >= tunnelA) // C < A < B => C+A
        {
        	return(tunnelC + tunnelB);    
        }
        
        // should never happen
        return -1.0;
    }
}