package init;

import methods.integration.Simpson;

public class Main {

  public static void main(String... args) {

    new Thread(() -> {
      System.out.println("Simpson 3/8 => " + Simpson.calcularIntegral("(1+x^2)^(1/2)", "0", "1"));
    }).start();
  }
}
