import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> list = new ArrayList();
    public static void displayList(){
        System.out.println("\n++++++++++++++++++++++++++++++++++++++++");
        if (list.size() != 0) {
            for (int i = 0; i <list.size(); i++) {
                System.out.printf("%3d%35s\n", i+1, list.get(i));
            }
        }
        else {
            System.out.println("+++           List is Empty          +++");
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        final String menu = "A - Add, D - Delete, P - Print, Q - Quit";
        boolean quitResponse;
        do {
            displayList();
            String cmd = SafeInput.getRegExString(in, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();
            switch (cmd) {
                case "A":
                    String item = SafeInput.getNonZeroLenString(in, "Enter an item: ");
                    list.add(item);
                    break;
                case "D":
                    int deleteItem = SafeInput.getRangedInt(in,"Select the item number to delete:", 1, list.size());
                    deleteItem--;
                    list.remove(deleteItem);
                    break;
                case "P":
                    break;
                case "Q":
                    quitResponse = SafeInput.getYNConfirm(in,"Are you sure you want to quit?");
                    if (quitResponse) {
                        System.exit(0);
                    }
                    break;
            }
        }
        while (!done);

    }
}