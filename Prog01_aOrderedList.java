//Hong Bin Li
//896235238
//2

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Prog01_aOrderedList {

    public Prog01_aOrderedList() throws FileNotFoundException {
    }

    public static void main(String[] args) {
        try {
            Scanner inputFileScanner = GetInputFile("Enter input filename: ");
        } catch (FileNotFoundException e) {

        }
    }

    aOrderedList orderedList= new aOrderedList();


    public static Scanner GetInputFile(String UserPrompt) throws FileNotFoundException {
        Scanner userInputScanner = new Scanner(System.in);
        String inputFileName;
        boolean validFileName;

        do {
            System.out.print(UserPrompt);
            inputFileName = userInputScanner.nextLine();
            File inputFile = new File(inputFileName);
            validFileName = inputFile.exists() && inputFile.isFile();

            if (!validFileName) {
                System.out.println("File specified <" + inputFileName + "> does not exist.");
                System.out.print("Would you like to continue? <Y/N> ");
                String continueChoice = userInputScanner.nextLine();

                if (continueChoice.equalsIgnoreCase("N")) {
                    throw new FileNotFoundException("User canceled program execution.");
                }
            }
        } while (!validFileName);

        return new Scanner(inputFileName);
    }
}

class Car {
    private String make;
    private int year;
    private int price;

    public Car(String Make, int Year, int Price) {
        make = Make;
        year = Year;
        price = Price;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public int compareTo(Car other){
        int carCompare = this.make.compareTo(other.make);

        if (carCompare != 0) {
            return carCompare;
        }

        return Integer.compare(this.year, other.year);
    }

    public String toString() {
        return "“Make: “ + make + “, Year : “ + year + “, Price: “ + price + “;”";
    }
}

class aOrderedList {
    private final int SIZEINCREMENTS = 20; //size of increments for increasing ordered list
    private Car[] oList; //the ordered list
    private int listSize; //the size of the ordered list
    private int numObjects; //the number of objects in the ordered list

    public aOrderedList() {
        numObjects = 0;
        listSize = SIZEINCREMENTS;
        oList = new Car[listSize];
    }

    public void add(Car newCar) {
        if (numObjects == listSize) {
            listSize += SIZEINCREMENTS;
            Car[] newOList = new Car[listSize];
            System.arraycopy(oList, 0, newOList, 0, numObjects);
            oList = newOList;
        }
        int i;
        for (i = numObjects - 1; i >= 0; i--) {
            if (newCar.compareTo(oList[i]) > 0) {
                break;
            }
            oList[i + 1] = oList[i];
        }
        oList[i + 1] = newCar;
        numObjects++;
    }

    public String toString() {
        if (numObjects == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < numObjects; i++) {
            result.append(oList[i]);
            if (i < numObjects - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}




