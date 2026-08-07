import java.util.concurrent.ThreadLocalRandom;

public class Hangman {

    public static String randomWords(){
       String[] words = {"Jupiter", "Zeus", "Aphrodite", "Vénus", "Marth", "Lucina", "Mars", "Arès", "Hades",
                              "Pluton", "Anubis", "Ra", "Mercure", "Hermès", "Athéna", "Minerve", "Minerva", "Corrin",
                              "Byleth", "Bastet", "Thor", "Odin", "Grima", "Corren", "Casper", "Oscar", "Pill", "Halt",
                              "Treaty", "Oblige", "Seth", "Théménos", "Cyrus", "Hephaïstos", "Cupidon", "Zorro",
                              "Lefantôme", "Xana", "Harry", "Potter", "Tsuki", "Onyx", "Wellan", "Nashoba", "Aelita",
                              "Rhea", "Jaden", "Yugi", "Tincel", "Einstein", "Anankos", "Flamel", "Daraen", "Ike",
                              "Vulcain", "Demeter", "Ceres", "Bioninformatique", "Carter", "Sephiroth", "Owain", "Jack", 
                              "Harikeñ", "Catasfiore", "Vaan", "Balthier", "Agnès", "Casty", "Osvald", "Muriel",
                              "Anatiel", "Zéphilia", "Tamriel", "Wuunferth", "Yann", "Aucun", "Stole", "Arthur",
                              "Apollon", "Diane", "Artemis", "Dianthus", "Jedusort", "William", "Ulrich", "Joséphiroth"
                              , "Jim", "Morales", "Makoto", "Naegi", "Celica", "Yuri", "Moon", "Bernadetta", "Seiros",
                            "Mathilda", "Python", "Java","Aiosqlite","Fortuna","Monopoly", "Roleplay","Lancer"} ;
        int random = ThreadLocalRandom.current().nextInt(0, words.length);
        return words[random].toLowerCase();
    }

    

    public static void main(String[] args) {
        if( args.length > 0) throw new IllegalArgumentException(" pas d'arguments");
    }
}
