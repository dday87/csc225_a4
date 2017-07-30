import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * BackPainAnaylyzer demonstrates the use of a binary decision tree to 
 * diagnose back pain.
 */
public class PsychosisDecisionTree
{
    /**
     *  Asks questions of the user to diagnose a medical problem.
     */
    public static void main (String[] args) throws FileNotFoundException
    {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Please enter your first and last name.");
    	String name = scan.nextLine();
   	System.out.println("Please fill in your gender.(male or female)");
      	String myGender;
    	if(scan.nextLine().equalsIgnoreCase("male"))
    	{
    			myGender = "Mr. ";
       	}
    	else	
    	{
    		myGender = "Mrs. ";
    	}
        System.out.println ("Take a seat " + myGender + name);

        DecisionTree expert = new DecisionTree("input1");
        expert.evaluate();
      }
}
