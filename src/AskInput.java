import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class AskInput {
    private static final int MIN = -99999;
    private static HeroFactory heroFactory = new HeroFactory();

    public static int askInt(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Please enter the number (%d ~ %d): ", min, max);
        int x = MIN;
        while (x > max || x < min) {
            String r = scanner.next();
            try {
                x = Integer.parseInt(r);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid integer!");
            }

            if (x > max || x < min) {
                System.out.println("Invalid input, please enter a valid integer!");
            }

        }
        return x;
    }

    public static Hero askHero() {
        Hero h = heroFactory.getHero();
        return h;
    }

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

    public static ArrayList<ArrayList<String>> read(String filename) {
        String delimAlias = "/";
        String delimData = "\\s+";
        String file = System.getProperty("user.dir") + "/src/ConfigFiles/" + filename;
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
        System.out.println("(enter item code to purchase or 30 to quit)");
        int choice = 0;
        while(true) {
            try {
                Scanner file = new Scanner(System.in);
                choice = file.nextInt();
                while(choice<0 || choice>30) {
                    System.out.println("(Error Purchase)You have to input a number between 0 - 30, enter again:");
                    choice = file.nextInt();
                }
                break;
            }catch(InputMismatchException|NumberFormatException ex){
                System.out.println("(Error Purchase)You have to input a number between 0 - 30, enter again:");
            }
        }
        return choice;
    }



}
