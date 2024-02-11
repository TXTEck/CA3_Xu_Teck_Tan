import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
/**
 *  Name: Xu Teck Tan
 *  Class Group: SD2b
 */
public class CA3_Question7
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
        Map<String, Queue<Share>> shareMap = new HashMap<>();
        Scanner keyboard = new Scanner(System.in);
        String command = "";
        do {
            System.out.println("Enter buy, sell or quit: ");
            command = keyboard.nextLine();
            if(command.equalsIgnoreCase("buy")) {
                System.out.println("Enter share symbol");
                String symbol = keyboard.nextLine();
                keyboard.nextLine();

                System.out.println("Enter buy quantity");
                int buyQuantity = keyboard.nextInt();
                keyboard.nextLine();

                System.out.println("Enter price bought");
                double price = keyboard.nextDouble();
                keyboard.nextLine();

                Share newShare = new Share(buyQuantity, price);
                if (!shareMap.containsKey(symbol)) {
                    shareMap.put(symbol, new LinkedList<>());
                }
                shareMap.get(symbol).add(newShare);
            }
            else if(command.equalsIgnoreCase("sell")) {

                System.out.println("Enter share symbol");
                String symbol = keyboard.nextLine();
                keyboard.nextLine();

                System.out.println("Enter sell quantity");
                int sellQuantity = keyboard.nextInt();
                keyboard.nextLine();

                System.out.println("Enter price sold");
                double price = keyboard.nextDouble();
                keyboard.nextLine();

                Queue<Share> shares = shareMap.get(symbol);
                if(shares.isEmpty()) {
                    System.out.println("No shares to sell for this symbol");
                }
                else {
                    Share block = shares.peek();
                    if(block.getQuantity() < sellQuantity) {
                        System.out.println("Not enough shares to sell");
                        shares.add(block);
                    }
                    else {
                        System.out.println("Sold " + sellQuantity + " shares for " + price);

                        if(block.getQuantity() > sellQuantity) {
                            block.setQuantity(block.getQuantity() - sellQuantity);
                            shares.add(block);
                        }
                    }
                }
            }
        } while(!command.equalsIgnoreCase("quit"));
    }

}