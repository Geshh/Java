import java.io.*;
import java.util.Collections;
import java.util.Vector;
import java.util.Scanner;

public class GPS {

  public static Vector<Integer> getGasStations(int tripDistance, int tankSize, Vector<Integer> gasStations) {
    
    Vector<Integer> shortPath = new Vector<Integer>();
  
    int fuel=tankSize;


    if(gasStations.get(0)>tankSize || (tripDistance - gasStations.lastElement()) > tankSize) {
      return shortPath;
    }

    for(int i=0;i<gasStations.size();i++) {
      System.out.println("Going into cycle for the " + i + "th time");


          if(shortPath.isEmpty()) {
            if(fuel>gasStations.get(i)) {
              fuel-=gasStations.get(i);
            } else {
              shortPath.add(gasStations.get(i));
              fuel=tankSize;
            }
          } else {
            int temp=gasStations.get(i) - shortPath.lastElement();
            if(fuel>temp) {
              fuel-=temp;
            } else {
              shortPath.add(gasStations.get(i-1));
              fuel=tankSize;
            }
          }
        }
      shortPath.add(gasStations.lastElement());
      return shortPath;
    }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter trip distance : ");
    int tripDistance = scanner.nextInt();
    
    System.out.print("Enter tank size : ");
    int tankSize = scanner.nextInt();

    System.out.print("Enter gas stations count : ");
    int gasStationsCount = scanner.nextInt();
    
    Vector<Integer> gasStations = new Vector<Integer>();

    for (int i = 0; i < gasStationsCount; i++) {
      System.out.print("Enter distance between Sofia and current gas Station " + (i+1) + " : ");
      gasStations.add(scanner.nextInt());
    }

    Collections.sort(gasStations);


    Vector<Integer> result = getGasStations(tripDistance, tankSize, gasStations);

    System.out.println("You should stop at: ");
    for (int i = 0; i < result.size(); i++) {
        System.out.println(result.get(i) + "km");
    }

  }
}