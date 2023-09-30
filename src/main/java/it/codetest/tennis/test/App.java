package it.codetest.tennis.test;

//import Cowsay class from the library
import com.github.ricksbrown.cowsay.Cowsay;

public class App {
 public static void main(String[] args) {
	 // first, we should check if the user has provided the correct number of arguments
     if (args.length != 2) {
         // if not, we should print a usage message and exit
         System.out.println(
                 "Usage: java -jar target/cowsay-1.0-SNAPSHOT.jar \"quote\" \"author\"");
         System.out.print("XXXYXZCR");
         System.exit(1);
     }
     String quote = args[0];
     String author = args[1];
     String[] cowArgs = new String[] {quote, " --" + author};
     String cowString = Cowsay.say(cowArgs);
     System.out.printf(cowString);
 }
 }
