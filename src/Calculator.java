import java.util.Stack;

public class Calculator {
	private double runningTotal;
	private Stack<Memento> undoStack;

	public Calculator() {
		this.runningTotal = 0;
		this.undoStack = new Stack<>();
	}
	
	public void add(double num1, double num2) {
        saveState();
        double result = num1+num2;
        runningTotal += result;
        System.out.println("Sum: " + result + "; Running Total: " + runningTotal);
    }

    public void subtract(double num1, double num2) {
        saveState();
        double result = num1-num2;
        runningTotal += result;
        System.out.println("Difference: " + result + "; Running Total: " + runningTotal);
    }

    public void multiply(double num1, double num2) {
        saveState();
        double result = num1*num2;
        runningTotal += result;
        System.out.println("Product: " + result + "; Running Total: " + runningTotal);
    }

    public void divide(double num1, double num2) {
        if (num1 == 0 || num2 ==0) {
            System.out.println("Cannot divide by zero.");
        } else {
            saveState();
            double result = num1/num2;
            runningTotal += result;
            System.out.println("Quotient: " + result + "; Running Total: " + runningTotal);
        }
    }

    private void saveState() {
    	undoStack.push(new Memento(runningTotal));  
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Memento memento = undoStack.pop();  
            runningTotal = memento.getCalTotal(); 
            System.out.println("Running Total: " + runningTotal);
        } else {
            System.out.println("nothing to undo.");
        }
    }

    public void clear() {
        runningTotal = 0;
        undoStack.clear();  
        System.out.println("Running Total: " + runningTotal);
    }

    public void exit() {
        System.out.println("Closing Calculator...");
        System.exit(0);
    }
}
