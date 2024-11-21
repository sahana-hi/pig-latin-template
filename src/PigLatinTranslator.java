import java.lang.*;

public class PigLatinTranslator {
  public static Book translate(Book input) {
    Book translatedBook = new Book();
    for (int i = 0; i < input.getLineCount(); i++) {
      String line = input.getLine(i);
     if (line == null || line.isEmpty()) {
       translatedBook.appendLine("");
     } else {
       translatedBook.appendLine(translate(line));
     }
    // Add code here to populate translatedBook with a translation of the input
    // book.
    // Current do-nothing code will return an empty book.,,,,,,
    }
    return translatedBook;
  }

  public static String translate(String input) {
    // System.out.println("Translate String: '" + input + "'");

    // Replace this code to translate a string input.
    // The input to this function could be any English string.
    // A sentence, paragraph, or a single word.
    // It should call translateWord at least once.
    String result = translateWord(input);

    return result;
  }

  public static boolean isVowel(char chh) {
    if ("AEIOUaeiou".indexOf(chh) != -1) {
      return true;
    } else {
      return false;
    }
  }

  private static String translateWord(String input) {
    // this method is for whole sentences (multiple words)
    String result = input;
    // for empty input string, just return the string
    if ((input == null) || (input.isBlank()) || (input.isEmpty())) {
      return result;
    }
    // split input string by - or " " to get separate strings and storing it in an array
    String[] inputs = input.split("[- ]");
    // create an array with length of strings from inputs
    String[] outputs = new String[inputs.length];
    // for each input string, call translate helper method to translate into pig latin
    // Store output in the outputs array at corresponding indices
    for (int i = 0; i < inputs.length; i++) {
      outputs[i] = translateWordHelper(inputs[i]);
    }

    // Outputs array now has list of pig latin words and combines them and stores in result
    // if input has a -, combine with -; if input has " ", combine with " "
    // if no delimiter, combine outputs with empty string
    if (input.contains("-")) {    
      result = String.join("-", outputs);
      return result;
    } else if (input.contains(" ")) {
      result = String.join(" ", outputs);
      return result;
    } else {
      result = String.join("", outputs);
      return result;
    }
  }

  private static String translateWordHelper(String input) {
    // this is for individual words, so you need to check if the individual word is blank string
    if ((input == null) || (input.isBlank()) || (input.isEmpty())) {
      return input;
    }
    String result = input;
    char first = input.charAt(0);
    if (isVowel(first)) {
      result += "ay";
    } else {
      for (int i = 1; i < input.length(); i++) {
        char letter = input.charAt(i);
        if (isVowel(letter)) {
          String begin = input.substring(0, i);
          String next = input.substring(i);
          if (Character.isUpperCase(begin.charAt(0))) {
            begin = begin.substring(0, 1).toLowerCase() + begin.substring(1);
            next = next.substring(0, 1).toUpperCase() + next.substring(1);
          }
          result = next + begin + "ay";
          break;
        }
      }
    }
    // move the dot to the end
    if (result.contains(".")) {
      result = result.replace(".", "");
      result = result + ".";
    }
    return result;
  }

  // Add additonal private methods here.
  // For example, I had one like this:
  // private static String capitalizeFirstLetter(String input)

}