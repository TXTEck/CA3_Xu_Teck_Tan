import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 *  Name: Xu Teck Tan
 *  Class Group: SD2b
 */
public class CA3_Question6
{
    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {
        Queue<Share> blocks = new LinkedList<>();
        Scanner keyboard = new Scanner(System.in);
        double totalBought = 0;
        double totalSold = 0;
        String input = "";
        do {
            System.out.println("Enter buy, sell or quit: ");
            input = keyboard.nextLine();
            if(input.equalsIgnoreCase("buy")) {
                System.out.println("Enter buy quantity");
                int buyQuantity = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("Enter price bought");
                double price = keyboard.nextDouble();
                keyboard.nextLine();
                blocks.add(new Share(buyQuantity, price));
                totalBought += buyQuantity * price;
            }
            else if(input.equalsIgnoreCase("sell")) {
                System.out.println("Enter sell quantity");
                int sellQuantity = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("Enter price sold");
                double price = keyboard.nextDouble();
                keyboard.nextLine();
                if(blocks.isEmpty()) {
                    System.out.println("No shares to sell");
                } else {
                    Share block = blocks.poll();
                    if(block.getQuantity() < sellQuantity) {
                        System.out.println("Not enough shares to sell");
                        blocks.add(block);
                    } else {
                        System.out.println("Sold " + sellQuantity + " shares for " + price);
                        totalSold += sellQuantity * price;
                        if(block.getQuantity() > sellQuantity) {
                            block.setQuantity(block.getQuantity() - sellQuantity);
                            blocks.add(block);
                        }
                    }
                }
            }
        } while(!input.equalsIgnoreCase("quit"));

        System.out.println("Total gains: " + (totalSold - totalBought));
    }

}