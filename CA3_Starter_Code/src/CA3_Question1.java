import java.util.Scanner;
import java.util.Stack;
public class CA3_Question1
{
    public static void main(String[] args)
    {
        Stack<Integer> driveway = new Stack<Integer>();
        Stack<Integer> street = new Stack<Integer>();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a number:(Positive to add a car, negative to retrieve a car, 0 to quit)");
        int input = keyboard.nextInt();

        while(input !=0)
        {
            if(input > 0)
            {
                driveway.push(input);
                printStack(driveway, street);
                System.out.println("Enter a number:(Positive to add a car, negative to retrieve a car, 0 to quit)");
                input = keyboard.nextInt();
            }
            else
            {
                int carToRetrieve = -input;
                boolean found = false;

                //if the driveway is not empty and the car to retrieve is not the last car in the driveway
                //move cars from driveway to the street until the car to retrieve is the last car in the driveway
                while(!driveway.isEmpty() && driveway.peek() != carToRetrieve)
                {
                    street.push(driveway.pop());
                    printStack(driveway, street);
                }

                //if the car to retrieve is not in the driveway, move cars from the street back to the driveway
                //remove the car to retrieve from the driveway
                if(!driveway.isEmpty() && driveway.peek() == carToRetrieve){
                    driveway.pop();
                    found = true;
                }

                //move cars from the street back to the driveway
                while(!street.isEmpty())
                {
                    driveway.push(street.pop());
                }

                if(!found)
                {
                    System.out.println(carToRetrieve + " is not in the driveway");
                }

                printStack(driveway, street);
                System.out.println("Enter a number:(Positive to add a car, negative to retrieve a car, 0 to quit)");
                input = keyboard.nextInt();
            }
        }
    }

    public static void printStack(Stack<Integer> d, Stack<Integer> s)
    {
        System.out.println("Driveway: " + d);
        System.out.println("Street: " + s);
    }
}
