public class Main {
    public static void main(String[] args) {
        byte bytefr = 189;
        short shortfr = 23231;
        int integer = 123232333;
        long longfr = 111111;
        float floatfr = 1.3212f;
        double doublefr = 2.3213d;
        char charfr = 'q';
        boolean frornot = false;
        System.out.println(calculateSome(1, 2, 3, 4));
        System.out.println(isSumBiggerThanTwenty(9, 17));
        isNegative(-1);
        System.out.println(isNegativeRevert(-1));
        greetings("Andrew");
        isYearLeap(2002);
    }
  
  //2 задание  
  public static double calculateIt(double a, double b, double c, double d) {
          return a * ( b + ( c / d ) );
      }
  
  //3 задание
  public static boolean isItBiggerFrOrNot(double a, double b) {
          return a + b > 20;
      }
  
  //4 задание
  public static void isNegative(int value) {
          if (value >= 0) System.out.println("PositiveFr");
          else System.out.println("NegativeFr");
      }
  
  //5 задание
  public static boolean isNegativeRevert(int value) {
          return value < 0;
      }
  
  //6 задание
  public static void greetings(String name) {
          System.out.println("Hello, " + name + "!");
      }
   
  //7 задание
  public static void greetings(String name) {
        System.out.println("Hi, " + name + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
  
  //8 задание
  public static void isYearLeap (int year) {
        if ((year % 4 == 0 | year % 400 == 0) & year % 100 != 0) System.out.println("Этот год высокосный");
        else System.out.println("Явно мимо, год не высокосный :(");
    }
}
