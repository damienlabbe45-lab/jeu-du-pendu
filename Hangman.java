import java.util.Arrays;
import java.util.Scanner;
import java.security.SecureRandom;
import java.util.Random;

public class Hangman {

    public static String inputString(Scanner input){
        System.out.println("Veuillez choisir un caractère");
        return input.nextLine().toLowerCase();
    }

    public static char inputChoice(Scanner input){
        String letter = inputString(input);

        while(letter.length() != 1)letter =inputString(input);

        return letter.toCharArray()[0];
    }

    public static String randomWords(){
       String[] words = {"Jupiter", "Zeus", "Aphrodite", "Vénus", "Marth", "Lucina", "Mars", "Arès", "Hades",
                              "Pluton", "Anubis", "Ra", "Mercure", "Hermès", "Athéna", "Minerve", "Minerva", "Corrin",
                              "Byleth", "Bastet", "Thor", "Odin", "Grima", "Corren", "Casper", "Oscar", "Pill", "Halt",
                              "Treaty", "Oblige", "Seth", "Théménos", "Cyrus", "Hephaïstos", "Cupidon", "Zorro",
                              "Lefantôme", "Xana", "Harry", "Potter", "Tsuki", "Onyx", "Wellan", "Nashoba", "Aelita",
                              "Rhea", "Jaden", "Yugi", "Tincel", "Einstein", "Anankos", "Flamel", "Daraen", "Ike",
                              "Vulcain", "Demeter", "Ceres", "Bioinformatique", "Carter", "Sephiroth", "Owain", "Jack", 
                              "Harikeñ", "Catasfiore", "Vaan", "Balthier", "Agnès", "Casty", "Osvald", "Muriel",
                              "Anatiel", "Zéphilia", "Tamriel", "Wuunferth", "Yann", "Aucun", "Stole", "Arthur",
                              "Apollon", "Diane", "Artemis", "Dianthus", "Jedusort", "William", "Ulrich", "Joséphiroth"
                              , "Jim", "Morales", "Makoto", "Naegi", "Celica", "Yuri", "Moon", "Bernadetta", "Seiros",
                            "Mathilda", "Python", "Java","Aiosqlite","Fortuna","Monopoly", "Roleplay","Lancer","Dévelopeur"} ;
        Random rand = new SecureRandom();
        int random = rand.nextInt(words.length);
        return words[random].toLowerCase();
    }

    public static int[] findIndexs(char letter, String word){
        int number = 0;
        int index = 0;
        int[] indexs = new int[word.length()];
        Arrays.fill(indexs,-20);

        for(char letters:word.toCharArray()){
            if(letter == letters){
                indexs[index] = number;
                index++;
            }
                number++;
        }

        return indexs;
    }

    public static void hang(Scanner input){
       String word = randomWords();
       char[] letters = new char[word.length()];
       Arrays.fill(letters, '_');
       int error = 0;
       int NUMBERMAX = 15;
       char[] notWords = new char[NUMBERMAX];
       while(!word.equals(new String(letters)) && error < NUMBERMAX){
        System.out.println("voici la liste des lettres que vous avez proposés qui ne sont pas dans le mot "+ Arrays.toString(notWords));
        System.out.println(new String(letters));
        char letter = inputChoice(input);

        if(word.contains("" + letter)){
            int [] numbers = findIndexs(letter, word);
            for(int number: numbers){
                if(number != -20){
                    letters[number] = letter;
                }
            }

        }else{
            notWords[error] = letter;
            error++;

        System.out.println("il vous reste "+ (NUMBERMAX - error));
        }

       }

       if(error ==NUMBERMAX)System.out.println("Vous avez perdu et pendu à un poteau après avoir été couvert de gudron et de plumes.... \nil fallait" +
        " trouver le mot " + word.substring(0,1).toUpperCase()+word.substring(1)
       ) ;

       else System.out.println("Vous avez gagné avec " + error + " erreurs !!!!!!!! \n Vous avez trouvé le mot " + 
       word.substring(0,1).toUpperCase()+word.substring(1));
    }

    public static void main(String[] args) {
        if( args.length > 0) throw new IllegalArgumentException(" pas d'arguments");
        Scanner input = new Scanner(System.in, System.getProperty("sun.stdin.encoding","CP850"));
        hang(input);
        input.close();
        System.out.println("Merci d'avoir joué");
    }
}
