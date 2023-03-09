import java.io.File;
import java.io.IOException;

public class Main {
        public static void main(String[] args) throws IOException {
                VerbDirectory verbDirectory = new VerbDirectory();

                System.out.println("Index of abandon is " + verbDirectory.findVerbIndex("abandon") + ".");
                System.out.println("Index of abandoned is " + verbDirectory.findVerbIndex("abandoned") + ".");
                System.out.println("Index of enjoying is " + verbDirectory.findVerbIndex("enjoying") + ".");
                System.out.println("Index of notaverb is " + verbDirectory.findVerbIndex("notaverb") + ".");

                System.out.println("\nTop 5 verbs in each document: ");

                File file = new File(
                                "C:\\Users\\Maryam Azimli\\Desktop\\UNIVERSITY\\cs\\cs102\\labs\\lab2\\0.txt");
                System.out.print("\n0:");
                InputDocument inputDocument = new InputDocument(file, verbDirectory);
                File file1 = new File(
                                "C:\\Users\\Maryam Azimli\\Desktop\\UNIVERSITY\\cs\\cs102\\labs\\lab2\\1.txt");
                System.out.print("1:");
                InputDocument inputDocument1 = new InputDocument(file1, verbDirectory);
                File file2 = new File(
                                "C:\\Users\\Maryam Azimli\\Desktop\\UNIVERSITY\\cs\\cs102\\labs\\lab2\\2.txt");
                System.out.print("2:");
                InputDocument inputDocument2 = new InputDocument(file2, verbDirectory);
                File file3 = new File(
                                "C:\\Users\\Maryam Azimli\\Desktop\\UNIVERSITY\\cs\\cs102\\labs\\lab2\\3.txt");
                System.out.print("3:");
                InputDocument inputDocument3 = new InputDocument(file3, verbDirectory);
                File file4 = new File(
                                "C:\\Users\\Maryam Azimli\\Desktop\\UNIVERSITY\\cs\\cs102\\labs\\lab2\\4.txt");
                

                System.out.println("\n Dissimilaarity Matrix: ");
                System.out.printf("%s%5s%10s%10s%10s%10s%10s%10s", "N", "0 ", "1 ", "2 ", "3 ");

                InputDocument[] inputDocuments = { inputDocument, inputDocument1, inputDocument2, inputDocument3};
                System.out.println();
                for (int i = 0; i < 2; i++) {
                        for (int m = 2; m < 4; m++) {
                                System.out.printf("%10s", inputDocuments[i].calculateDissimilarity(inputDocuments[m]));
                        }
                        System.out.println("\n"+i);

                }
        }
}
