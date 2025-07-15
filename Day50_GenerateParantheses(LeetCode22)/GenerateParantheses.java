import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses
{
    public static void VP(int n,int numOpen,String current,ArrayList<String> output)
    {
        if(current.length()==2*n)
        {
            output.add(current);
            return;
        }
        if(numOpen<n) VP(n,numOpen+1,current+"(",output);
        if(current.length()-numOpen<numOpen) VP(n,numOpen,current+")",output);
    }
    public List<String> generateParenthesis(int n) 
    {
        ArrayList<String> output = new ArrayList<String>();
        VP(n,0,"",output);
        return output;
    }
    public static void main(String[] args)
    {
        GenerateParantheses gp=new GenerateParantheses();
        System.out.println("2 parantheses "+gp.generateParenthesis(2));
        System.out.println("3 parantheses "+gp.generateParenthesis(3));
    }
}
