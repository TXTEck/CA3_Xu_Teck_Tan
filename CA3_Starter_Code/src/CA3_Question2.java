import java.util.Stack;
import java.util.Scanner;

public class CA3_Question2
{
    public static void main(String[] args)
    {
        int size = 10;
        int[][] area = new int[size][size];
        Scanner keyboard = new Scanner(System.in);


        System.out.println("Enter starting row (0 - 9)");
        int sRow = keyboard.nextInt();
        System.out.println("Enter starting column (0 - 9)");
        int sCol = keyboard.nextInt();

        Stack<Pair> fill = new Stack<Pair>();
        fill.push(new Pair(sRow, sCol));

        int startingNum = 1;
        while(!fill.isEmpty())
        {
            //Pop off the (row, column) pair from the top of the stack.
            Pair current = fill.pop();
            int cRow = current.row;
            int cCol = current.col;

            //If it has not yet been filled, fill the corresponding cell location with a number
            //1, 2, 3, and so on (this number is incremented at each step to show the order
            //in which the square is filled).
            if (cRow >= 0 && cRow < size && cCol >= 0 && cCol < size && area[cRow][cCol] == 0)
            {
                area[cRow][cCol] = startingNum++;

                //Push the coordinates of any unfilled neighbours in the north, east, south, or
                //west direction on the stack.
                fill.push(new Pair(cRow - 1, cCol)); // North
                fill.push(new Pair(cRow + 1, cCol)); // South
                fill.push(new Pair(cRow, cCol + 1)); // East
                fill.push(new Pair(cRow, cCol - 1)); // West
            }
        }

        //When you are done (i.e.z stack is empty), print the entire 2D array.
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                System.out.printf("%4d", area[i][j]);
            }
            System.out.println();
        }
    }
}
