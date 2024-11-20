import java.lang.*;

public class PigLatinTranslator
{
  public static Book translate(Book input)
  {
    Book translatedBook = new Book();

    // Add code here to populate translatedBook with a translation of the input book.
    // Current do-nothing code will return an empty book.,,,,,,
        
    return translatedBook;
  }

  public static String translate(String input)
  {
    // System.out.println("Translate String: '" + input + "'");

    // Replace this code to translate a string input.
    // The input to this function could be any English string. 
    // A sentence, paragraph, or a single word. 
    // It should call translateWord at least once.
    String result = translateWord(input);

    return result;
  }

  private static String translateWord(String input)
  {
    // System.out.println("translateWord: '" + input + "'");
    // Replace this code to correctly translate a single word.
    // Start here first!
    String result = input;
    if ((input == null) || (input.isBlank()) || (input.isEmpty())) {
      return result;
    }
    char first = input.charAt(0);
    if ((first == 'a') || (first == 'e') || (first == 'i') || (first == 'o') || (first == 'u')
    || (first == 'A') || (first == 'E') || (first == 'I') || (first == 'O') || (first == 'U')) {
      result += "ay";
    } else {
      for (int i = 1; i < input.length(); i++) {
        char letter = input.charAt(i);
        if ((letter == 'a') || (letter == 'e') || (letter == 'i') || (letter == 'o') || (letter == 'u')
            || (letter == 'A') || (letter == 'E') || (letter == 'I') || (letter == 'O') || (letter == 'U')) {
              result = input.substring(i) + input.substring(0,i) + "ay";
          }
      }
    }
    return result;
  }

  // Add additonal private methods here.
  // For example, I had one like this:
  // private static String capitalizeFirstLetter(String input)

}