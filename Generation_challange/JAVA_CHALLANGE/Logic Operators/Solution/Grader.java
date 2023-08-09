import java.util.*;

public class Grader {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int score = sc.nextInt();
    if (score == 10 || score == 9) {
      System.out.println("Excellent ");
    } else {
      if (score > 5 && score <= 8) {
        System.out.println("Good");
      } else if (score > 3 && score <= 5) {
        System.out.println("insufficient");
      } else {
        System.out.println("Fail");
      }
    }
  }
}
