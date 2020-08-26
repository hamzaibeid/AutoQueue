
package javaapplication14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class JavaApplication14 {

    
    public static void main(String[] args) throws IOException, InterruptedException {

        CarQueue queue = new CarQueue();
        int x;
        Scanner scan = new Scanner(System.in);
        do {

            System.out.println("*********************************");
            System.out.println(" 1 - add a new car to the queue");
            System.out.println(" 2 - print the queue");
            System.out.println(" 3 - remove a car from the queue");
            System.out.println("4- Empty The Queue");
            System.out.println("5- Auto Car Wash :");
            System.out.println("6- Auto Read file Queue : ");
            System.out.println("7- Get the front of the queue : ");
            System.out.println("0 - exit");
            x = scan.nextInt();
            
            
            switch (x) {
                case 1:
                    System.out.println("please enter a new car to the queue ");
                    String carQ = scan.next();
                    queue.CarenQueue(carQ);
                    break;

                case 2:
                    queue.Carprint();
                    break;

                case 3:
                    System.out.println("The Car that got out of the queue is:  " + queue.Cardequeue());
                    break;

                case 4:
                    queue.Carclear();
                    System.out.println("The queue is empty");
                    break;

                case 5:
                    System.out.println("Enter The car names : ");
                    scan.nextLine();
                    String name = scan.nextLine();
                    System.out.println("Enter The Washing duration(in Seconds): ");
                    long second = scan.nextLong();
                    scan.nextLine();
                    System.out.println("Hit enter !");
                    scan.nextLine();
                    autoQueue(name,second);
                    break;
                case 6:
                     try {
                    File myObj = new File("name.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        autoQueue(data,2);
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                     break;
                case 7:
                    System.out.println("front is : "+queue.CargetFront());
                    break;
            }

        } while (x != 0);

    }

    static void autoQueue(String cName,long second) throws InterruptedException {

        CarQueue lq = new CarQueue();
        TimeElapsed time = new TimeElapsed();
        String[] array;
        array = cName.split(" ");
        for (String array1 : array) {
            lq.CarenQueue(array1);
        
        }
        lq.Carprint();
            System.out.println("_______________________________");

        for (String name : array) {
            time.countTime(2);
            System.out.println("Washing : " + name);
            time.countTime(second);
            System.out.println("Finished : " + lq.Cardequeue());
            System.out.println("************************");
            time.countTime(2);
            lq.Carprint();
        }
    }

}
