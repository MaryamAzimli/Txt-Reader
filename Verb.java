public class Verb {

    
    public String baseForm;
    public String[] otherForms;
    public static int index = 0;

    public Verb(String base, String firstForm, String secondForm, String thirdForm, String fourthForm) {

        this.baseForm = base;

        otherForms = new String[4];
        otherForms[0] = firstForm;
        otherForms[1] = secondForm;
        otherForms[2] = thirdForm;
        otherForms[3] = fourthForm;
    }

    public void output() {
        System.out.println(baseForm);
        System.out.println(otherForms[0]);
        System.out.println(otherForms[1]);
        System.out.println(otherForms[2]);
        System.out.println(otherForms[3]);
    }

    public boolean check(String word) {
        int yes = 0;
        for (int i = 0; i < 5; i++) {
                
                if (word.equals(baseForm)&&yes==0) {
                    yes++;
                } else if ((i != 4 && word.equals(otherForms[i]))) {
                    yes++;
                
            }
            }
        if (yes != 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Verb verb = new Verb("have", "has", "null", "null", "null");
        System.out.println(verb.check("one"));
        
    } 
}

