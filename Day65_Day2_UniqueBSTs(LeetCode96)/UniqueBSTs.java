public class UniqueBSTs
{
    public static long binomialCoeff(int n, int k) 
    {
        if (k > n - k) 
        {
            k = n - k;
        }
        long res = 1;        
        for (int i = 0; i < k; ++i) 
        {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }
    public int numTrees(int n) 
    {
        long c = binomialCoeff(2 * n, n);
        // Return the nth Catalan number
        return (int)(c / (n + 1));   
    }
    public static void main(String[] args)
    {
        UniqueBSTs u = new UniqueBSTs();
        System.out.println("The number of trees for n = 3 is "+u.numTrees(3));
        System.out.println("The number of trees for n = 2 is "+u.numTrees(3));
        
    }
}
