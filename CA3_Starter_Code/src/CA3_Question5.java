/**
 *  Name: Xu Teck Tan
 *  Class Group: SD2b
 */
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
public class CA3_Question5
{
    public static Queue<String> takeOffQueue = new PriorityQueue<>();
    public static Queue<String> landingQueue = new PriorityQueue<>();

    public static void takeoff(String flightSymbol)
    {
        takeOffQueue.add(flightSymbol);
        System.out.println(flightSymbol + " added to takeoff Queue");
    }

    public static void land(String flightSymbol)
    {
        landingQueue.add(flightSymbol);
        System.out.println(flightSymbol + " added to landing Queue");
    }

    public static void next()
    {
        if(!landingQueue.isEmpty())
        {
            System.out.println(landingQueue.poll() + " has landed");
        }
        else if (!takeOffQueue.isEmpty())
        {
            System.out.println(takeOffQueue.poll() + " has taken off");
        }
        else
        {
            System.out.println("No planes are the queue");
        }
    }
    public static void main(String[] args)
    {
        takeoff( "Flight-100"); // is queued
        takeoff("Flight-220"); // is queued
        land("Flight-320"); // is queued
        next();
        next();
        next();
        next();
    }

}
