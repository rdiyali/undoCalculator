import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
			    System.out.print("Input: ");
			    String input = scanner.nextLine().trim();

			    if (input.equalsIgnoreCase("UNDO")) {
			        calc.undo();
			    } else if (input.equalsIgnoreCase("CLEAR")) {
			        calc.clear();
			    } else if (input.equalsIgnoreCase("EXIT")) {
			        calc.exit();
			    } else {
			        String[] parts = input.split(" ");
			        if (parts.length == 3) {
			            try {
			                double firstNum = Double.parseDouble(parts[0]);
			                String operation = parts[1];
			                double secondNum = Double.parseDouble(parts[2]);

			                switch (operation) {
			                    case "+":
			                        calc.add(firstNum, secondNum);
			                        break;
			                    case "-":
			                        calc.subtract(firstNum, secondNum);
			                        break;
			                    case "*":
			                        calc.multiply(firstNum, secondNum);
			                        break;
			                    case "/":
			                        calc.divide(firstNum, secondNum);
			                        break;
			                    default:
			                        System.out.println("Invalid operator. Use +, -, *, or /.");
			                }
			            } catch (NumberFormatException e) {
			                System.out.println("Invalid number format.");
			            }
			        } else {
			            System.out.println("Invalid input");
			        }
			    }
			}
		}
    }
}
