import java.lang.*;

public class PigLatinTranslator {
  public static Book translate(Book input) {
    Book translatedBook = new Book(input.getTitle());
    for (int i = 0; i < input.getLineCount(); i++) {
      String line = input.getLine(i);
      if (line == null || line.isEmpty()) {
        translatedBook.appendLine("");
      } else {
        translatedBook.appendLine(translate(line));
      }
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

  private static String translateWord(String input) {
    // if empty return input
    if ((input == null) || (input.isBlank()) || (input.isEmpty())) {
      return input;
    }
    // split sentence by space to get words, -1 gives each space as a word
    String[] inputsss = input.split(" ", -1);
    String result = "";
    for (int i = 0; i < inputsss.length; i++) {
      String r = "";
      // split the word by hypen, if no hyphen return original word
      String[] hyphen = inputsss[i].split("-", -1);
      // translate each word into pig latin
      for (int j = 0; j < hyphen.length; j++) {
        hyphen[j] = translateWordHelper(hyphen[j]);
      }
      inputsss[i] = String.join("-", hyphen);
    }
    result = String.join(" ", inputsss);
    return result;
  }

  private static String translateWordHelper(String input) {
    // this is for individual words, so you need to check if the individual word is
    // blank string
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
    if (input.contains(".")) {
      result = result.replace(".", "");
      result = result + ".";
    }
    return result;
  }

  // Add additonal private methods here.
  // For example, I had one like this:
  // private static String capitalizeFirstLetter(String input)

  // private method
  private static boolean isVowel(char chh) {
    if ("AEIOUaeiou".indexOf(chh) != -1) {
      return true;
    } else {
      return false;
    }
  }

}