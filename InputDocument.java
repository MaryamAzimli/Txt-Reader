import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputDocument {
    public int[] wordOccurences = new int[6710];
    double[] frequencies = new double[6710];
    int total;

    public InputDocument(File file, VerbDirectory t) throws IOException {
        
        theTexts(file, t);
        printtop5(1, t);
    }

    public InputDocument(VerbDirectory t, InputDocument therDocument) {
        calculateDissimilarity(therDocument);
}
    public void theTexts(File a, VerbDirectory t) throws IOException {
        Scanner sc = new Scanner(a, "UTF-8");
        StringTokenizer st = new StringTokenizer("file");

        while (sc.hasNextLine()) {

            String tneLine = sc.nextLine();
            st = new StringTokenizer(tneLine, "\t.;:''/=-?! ");

            String[] ooo = new String[st.countTokens()];
            int yesInARow = 0;
            for (int i = 0; st.hasMoreTokens(); i++) {
                ooo[i] = st.nextToken();
            }
            for (int i = 0; i < ooo.length; i++) {

                if (t.findVerbIndex(ooo[i]) != -1) {
                    int index = t.findVerbIndex(ooo[i]);
                    yesInARow = wordOccurences[index];
                    yesInARow++;
                    wordOccurences[index] = yesInARow;
                    total++;
                } else
                    yesInARow = 0;
            }
        }
        // System.out.println(wordOccurences[5128]);
        sc.close();
    }

    public void printtop5(int numberOfTexts, VerbDirectory t) {
        int firstMAx = 0;
        int secondMax = 0;
        int thirdMAx = 0;
        int fourthmax = 0;
        int fifthmax = 0;
        int[] theIndex = new int[5];
        for (int i = 0; i < 6710; i++) {
            if (wordOccurences[i] > firstMAx) {
                firstMAx = wordOccurences[i];
                theIndex[0] = i;
            }

            else if (wordOccurences[i] < firstMAx && wordOccurences[i] >= secondMax) {
                secondMax = wordOccurences[i];
                theIndex[1] = i;
            }

            else if (wordOccurences[i] < secondMax && wordOccurences[i] >= thirdMAx) {
                thirdMAx = wordOccurences[i];
                theIndex[2] = i;
            }

            else if (wordOccurences[i] < thirdMAx && wordOccurences[i] >= fourthmax) {
                fourthmax = wordOccurences[i];
                theIndex[3] = i;
            }

            else if (wordOccurences[i] < fourthmax && wordOccurences[i] >= fifthmax) {
                fifthmax = wordOccurences[i];
                theIndex[4] = i;
            }
        }
        for (int i = 0; i < numberOfTexts; i++) {

            System.out.println("'" + t.CallingBaseForm(theIndex[0]) + "': " + firstMAx + ", " + "'"
                    + t.CallingBaseForm(theIndex[1]) + "': " + secondMax + ", " +
                    "'" + t.CallingBaseForm(theIndex[2]) + "': " + thirdMAx + ", " + "'"
                    + t.CallingBaseForm(theIndex[3]) + "': " + fourthmax + ", " +
                    "'" + t.CallingBaseForm(theIndex[4]) + "': " + fifthmax);
        }
    }

    public double getFrequency(int verbIndex) {
        double frequency = 0;
        frequency = ((double) (wordOccurences[verbIndex]) / (double) (total));
        System.out.println(frequency);
        return frequency;

    }

    public void CalculateAllFrequency() {
        for (int i = 0; i < 6710; i++) {
            frequencies[i] = getFrequency(i);
        }
        
    }

    public double calculateDissimilarity(InputDocument otherDocument) {

        otherDocument.CalculateAllFrequency();
        double yes = 0;
      /*   for(int i =0;i<frequencies.length; i++){
            System.out.println(frequencies[i]);
        } */
        for (int i = 0; i < 6710; i++) {
            yes = Math.abs((double) (this.frequencies[i] - otherDocument.frequencies[i]));
        }
        return yes;
    }
    
    public static void main(String[] args) throws IOException {
        File file = new File(
                "C:\\Users\\Maryam Azimli\\Desktop\\UNIVERSITY\\cs\\cs102\\labs\\lab2\\0.txt");
        VerbDirectory verbDirectory = new VerbDirectory();
        InputDocument one = new InputDocument(file, verbDirectory);
        
        File file2 = new File(
                "C:\\Users\\Maryam Azimli\\Desktop\\UNIVERSITY\\cs\\cs102\\labs\\lab2\\1.txt");
        InputDocument inputDocument2 = new InputDocument(file2, verbDirectory);

        for (int i = 0; i < 2; i++) {
            for (int m = 0; m < 2;m++){
            System.out.println(one.calculateDissimilarity(inputDocument2));
        }
        }

    }
    
}
