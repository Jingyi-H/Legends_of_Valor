import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

// Utils class for parsing
public class AskInput {
    private static final int MIN = -99999;
    private static HeroFactory heroFactory = new HeroFactory();

    // ask player to input an integer with required boundary
    public static int askInt(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Please enter the number (%d ~ %d): ", min, max);
        int x = MIN;
        while (x > max || x < min) {
            String r = scanner.next();
            try {
                x = Integer.parseInt(r);
                if (x > max || x < min) {
                    System.out.println("Invalid input, please enter a valid integer!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid integer!");
            }

        }
        return x;
    }

    // ask player to select heroes
    public static Hero askHero(int i) {
        System.out.println(">>>>>> " + "Please select hero " + i + " >>>>>>");
        Hero h = heroFactory.getHero();
        System.out.println();
        return h;
    }

    // inquire yes/no of prompt questions
    public static boolean inquireYN(String promptMsg) {
        System.out.print(promptMsg + " (y/n)  ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        while (answer.length() != 1 || !(answer.equals("y") || answer.equals("n"))) {
            answer = scanner.nextLine();
            if (answer.length() != 1 || !(answer.equals("y") || answer.equals("n"))) {
                System.out.println("Invalid input, please enter as required!");
            }
        }
        boolean yes = false;
        if (answer.toLowerCase().equals("y")) {
            yes = true;
        }
        return yes;
    }

    // File parsing method
    public static ArrayList<ArrayList<String>> read(String filename) {
        String delimAlias = "/";
        String delimData = "\\s+";
        String file = System.getProperty("user.dir") + "/ConfigFiles/" + filename;
        List<String> lines = Collections.emptyList();
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        try {
            lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
            List<String> aliasList = new ArrayList<String>(Arrays.asList(lines.get(0).split(delimAlias)));
            //System.out.println(aliasList);
            for (int i = 1; i < lines.size(); i++) {    // skip the first line of alias
                ArrayList<String> attriList = new ArrayList<String>(Arrays.asList(lines.get(i).split(delimData)));
                if (attriList.size() > 0 && !attriList.get(0).equals("")) {
                    result.add(attriList);
                }
            }
        }
        catch (IOException e) {
            System.out.println("ERROR (DataReader): File " + filename + " not found.");
            e.printStackTrace();
        }
        return result;
    }

    //Ask which item to purchase in market menu
    public static int askpurchase() {
        System.out.println("(enter item, or, 30 -- to sell, 31 -- to quit)");
        int choice = 0;
        while(true) {
            try {
                Scanner file = new Scanner(System.in);
                choice = file.nextInt();
                while(choice<0 || choice>31) {
                    System.out.println("(Error Purchase)You have to input a number between 0 - 31, enter again:");
                    choice = file.nextInt();
                }
                break;
            }catch(InputMismatchException|NumberFormatException ex){
                System.out.println("(Error Purchase)You have to input a number between 0 - 31, enter again:");
            }
        }
        return choice;
    }


    //Ask sell option
    public static int askSell() {
        int choice = 0;
        while(true) {
            try {
                Scanner file = new Scanner(System.in);
                choice = file.nextInt();
                while(choice<1 || choice>5) {
                    System.out.println("Wrong Input, enter the correct one again:");
                    choice = file.nextInt();
                }
                break;
            }catch(InputMismatchException|NumberFormatException ex){
                System.out.println("Wrong Input, enter the correct one again:");
            }
        }
        return choice;
    }

    //Ask Battle move
    public static int askBattleMove() {
        System.out.println("(0 -- Attack, 1 -- Using Spell, 2 -- Using Potion, 3 -- Changing Equipment)");
        int choice = 0;
        while(true) {
            try {
                Scanner file = new Scanner(System.in);
                choice = file.nextInt();
                while(choice<0 || choice>3) {
                    System.out.println("(Error Battle)You have to input a number between 0 - 3, enter again:");
                    choice = file.nextInt();
                }
                break;
            }catch(InputMismatchException|NumberFormatException ex){
                System.out.println("(Error Battle)You have to input a number between 0 - 3, enter again:");
            }
        }
        return choice;
    }

    //Ask move on the map
    public static String askMove() {
        System.out.println("Select your move:");
        System.out.println("(w -- up, s -- down, a -- left, d -- right, i -- inventory, t -- teleport, q -- exit Game)");
        String choice = "";
        while(true) {
            Scanner file = new Scanner(System.in);
            choice = file.nextLine().toLowerCase();
            while(!(choice.equals("w"))&&!(choice.equals("a"))&&!(choice.equals("s"))&&!(choice.equals("d"))&&!(choice.equals("i"))&&!(choice.equals("t"))&&!(choice.equals("q"))) {
                System.out.println("(Error A07)You have to input 'w', or 'a', or 's', or 'd', or 'i', or 't', or 'q'");
                choice = file.nextLine();
            }
            break;
        }
        return choice;

    }

    // Ask coordinates that the player wants selected hero to teleport to
    public static int[] askCoordinates(int lower, int upper) {
        // TODO:
        System.out.println("You can only teleport to either beside or behind the hero you want to assist.");
        System.out.print("Enter the coordinates you want to teleport to: (e.g. 1 2)");
        Scanner in = new Scanner(System.in);
        int[] coord = new int[2];
        int count = 0;
        while (count < 2) {
            while (!in.hasNextInt()) {
                System.out.println("Please enter "+ 2 +" integers.");
                in.next();
            }
            int input = in.nextInt();
            coord[count] = input;
            count++;
            if (count == 2) {
                for (int i = 0; i < 2; i++) {
                    if (coord[i] >= upper) {
                        System.out.println("Please enter positive integers within "+ upper +".");
                        count = 0;
                        break;
                    }
                    else if (coord[i] < lower) {
                        System.out.println("Please enter positive integers no less than "+ lower +".");
                        count = 0;
                        break;
                    }
                }
            }
        }
        return coord;
    }


}
