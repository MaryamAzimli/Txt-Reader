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
                System.out.print("4:");
                InputDocument inputDocument4 = new InputDocument(file4, verbDirectory);
                File file5 = new File(
                                "C:\\Users\\Maryam Azimli\\Desktop\\UNIVERSITY\\cs\\cs102\\labs\\lab2\\5.txt");
                System.out.print("5:");
                InputDocument inputDocument5 = new InputDocument(file5, verbDirectory);
                File file6 = new File(
                                "C:\\Users\\Maryam Azimli\\Desktop\\UNIVERSITY\\cs\\cs102\\labs\\lab2\\6.txt");
                System.out.print("6:");
                InputDocument inputDocument6 = new InputDocument(file6, verbDirectory);
                File file7 = new File(
                                "C:\\Users\\Maryam Azimli\\Desktop\\UNIVERSITY\\cs\\cs102\\labs\\lab2\\7.txt");
                System.out.print("7:");
                InputDocument inputDocument7 = new InputDocument(file7, verbDirectory);
                File file8 = new File(
                                "C:\\Users\\Maryam Azimli\\Desktop\\UNIVERSITY\\cs\\cs102\\labs\\lab2\\8.txt");
                System.out.print("8:");
                InputDocument inputDocument8 = new InputDocument(file8, verbDirectory);
                File file9 = new File(
                                "C:\\Users\\Maryam Azimli\\Desktop\\UNIVERSITY\\cs\\cs102\\labs\\lab2\\9.txt");
                System.out.print("9:");
                InputDocument inputDocument9 = new InputDocument(file9, verbDirectory);

                System.out.println("\n Dissimilaarity Matrix: ");
                System.out.printf("%s%5s%10s%10s%10s%10s%10s%10s%10s%10s%10s", "N", "0 ", "1 ", "2 ", "3 ", "4 ", "5 ",
                                "6 ", "7 ", "8 ",
                                "9");

                InputDocument[] inputDocuments = { inputDocument, inputDocument1, inputDocument2, inputDocument3,
                                inputDocument4,
                                inputDocument5, inputDocument6, inputDocument7, inputDocument8, inputDocument9 };
                System.out.println();
                for (int i = 0; i < 2; i++) {
                        for (int m = 2; m < 10; m++) {
                                System.out.printf("%10s", inputDocuments[i].calculateDissimilarity(inputDocuments[m]));
                        }
                        System.out.println("\n"+i);

                }
        }
}