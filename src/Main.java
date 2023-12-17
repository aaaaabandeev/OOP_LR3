import java.util.Random;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stackOne = makeRandomStack();
        Stack<Integer> stackTwo = makeRandomStack();

        System.out.println("ДО");
        System.out.format("stackOne: %s\n", stackOne);
        System.out.format("stackTwo: %s\n", stackTwo);
        System.out.println();

        swapStackContent(stackOne, stackTwo);

        System.out.println("ПОСЛЕ");
        System.out.format("stackOne: %s\n", stackOne);
        System.out.format("stackTwo: %s\n", stackTwo);
        System.out.println();

    }
    private static Stack<Integer> makeRandomStack() {
        Stack<Integer> stack = new Stack<>();
        Random rnd = new Random();
        int stackSize = rnd.nextInt(15) + 5;
        while (stackSize-- > 0) {
            stack.push(rnd.nextInt(100));
        }
        return stack;
    }

    private static void swapStackContent(Stack<Integer> stackOne, Stack<Integer> stackTwo) {
        Stack<Integer> stackOneBuff = new Stack<>();
        Stack<Integer> stackTwoBuff = new Stack<>();

        moveStackContentReverse(stackOne, stackOneBuff);
        moveStackContentReverse(stackTwo, stackTwoBuff);

        moveStackContentReverse(stackTwoBuff, stackOne);
        moveStackContentReverse(stackOneBuff, stackTwo);
    }

    private static void moveStackContentReverse(Stack<Integer> srcStack, Stack<Integer> destStack) {
        while(srcStack.size() > 0) {
            destStack.push(srcStack.pop());
        }
    }
}
