import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class VerbDirectory {
    public static Verb[] verbArray;
    
    public VerbDirectory() throws IOException{
        processDictionary();
    }

    public static void processDictionary() throws IOException {
        verbArray = new Verb[6710];
        int u = 0;
        File file = new File(
                "C:\\Users\\Maryam Azimli\\Desktop\\UNIVERSITY\\cs\\cs102\\labs\\lab2\\verbs-dictionaries.txt");
        StringTokenizer st = new StringTokenizer("file");
        Scanner sc = new Scanner(file, "UTF-8");

        while (sc.hasNextLine() && u < 6710) {

                String tneLine = sc.nextLine();
                st = new StringTokenizer(tneLine, "\t");
                String[] ooo = new String[5];
                for (int i = 0; st.hasMoreTokens(); i++) {
                    ooo[i] = st.nextToken();
                }
            
                String one = ooo[0];
                String two = ooo[1];
                String three = ooo[2];
                String four = ooo[3];
                String five = ooo[4];
                Verb verb = new Verb(one, two, three, four, five);
                verbArray[u] = verb;
                u++;
            //System.out.println(u);
        }
    }

    public int findVerbIndex(String word) {
        for (int i = 0; i < verbArray.length; i++) {
            boolean onne = verbArray[i].check(word);
            if (onne == true)
                return i;
        }
        return -1;
    }
    
    public String CallingBaseForm(int index) {
        return verbArray[index].baseForm;
    }

    public static void main(String[] args) throws IOException  {
        VerbDirectory verbDirectory = new VerbDirectory();
        System.out.println(verbDirectory.findVerbIndex("say"));
        
    }


}
