import java.io.*;

/**
 * BackPainAnaylyzer demonstrates the use of a binary decision tree to 
 * diagnose back pain.
 */
public class BackPainAnalyzer
{
    /**
     *  Asks questions of the user to diagnose a medical problem.
     */
    public static void main (String[] args) throws FileNotFoundException
    {
        System.out.println ("So, you're having back pain.");

        DecisionTree expert = new DecisionTree("input.txt");
//      DecisionTree expert = new DecisionTree("input2.txt");		// Uncomment this line and comment out the line before to test the balanceTree()
        expert.evaluate();
// This method doesn't appear to be working properly
//      expert.balanceTree();
//      expert.evaluate();

    }
}
