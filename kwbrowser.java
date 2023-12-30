import java.util.List;
import java.util.Map;

class Scratch {

  private final static Map<String, Integer> MAPPING = Map.ofEntries(Map.entry("0", 0),
      Map.entry("1", 1),
      Map.entry("2", 2),
      Map.entry("3", 3),
      Map.entry("4", 4),
      Map.entry("5", 5),
      Map.entry("6", 6),
      Map.entry("7", 7),
      Map.entry("8", 8),
      Map.entry("9", 9),
      Map.entry("X", 10),
      Map.entry("A", 11),
      Map.entry("B", 12),
      Map.entry("C", 13),
      Map.entry("D", 14),
      Map.entry("E", 15),
      Map.entry("F", 16),
      Map.entry("G", 17),
      Map.entry("H", 18),
      Map.entry("I", 19),
      Map.entry("J", 20),
      Map.entry("K", 21),
      Map.entry("L", 22),
      Map.entry("M", 23),
      Map.entry("N", 24),
      Map.entry("O", 25),
      Map.entry("P", 26),
      Map.entry("R", 27),
      Map.entry("S", 28),
      Map.entry("T", 29),
      Map.entry("U", 30),
      Map.entry("W", 31),
      Map.entry("Y", 32),
      Map.entry("Z", 33));

  private final static List<Integer> INITIAL = List.of(1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7);

  public static void main(String[] args) {
    final var control = 8;
    final var base = "WA4M";
    final var baseSum = sumOfLetters(base);
    var count = 0;
    for (var i = 0; i <= 99999999; i++) {
      final var number = String.format("%08d", i);
      final var numberSum = sumOfLetters(number);
      final var result = (baseSum + numberSum) % 10;
      if (result == control) {
        count++;
        System.out.println(number);
      }
    }
    System.out.println(count);
  }

  private static int sumOfLetters(String word) {
    var sum = 0;
    for (var i = 0; i < word.length(); i++) {
      sum += INITIAL.get(i) * MAPPING.get(Character.toString(word.charAt(i)));
    }
    return sum;
  }
}
