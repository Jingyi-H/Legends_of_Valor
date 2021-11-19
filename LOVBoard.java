import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class LOVBoard {
    private Cell[][] cells;
    private HashMap<Hero, int[]> heros;
    private HashMap<Monster, int[]> monsters;
    private LOVWindow window;

    // constructors
    public LOVBoard(int rows, int cols) {
        this.cells = new Cell[rows][cols];
    }

    public LOVBoard(int dim) {
        this(dim,dim);
    }

    public LOVBoard() {
        this(8);
        // Init nexus cells
        for (int i= 0; i < 8; i++) {
            this.cells[0][i] = new NexusCell();
            this.cells[7][i] = new NexusCell();
        }
        // Init inaccessible cells
        for (int i = 0; i < 8; i++) {
            this.cells[i][2] = new InaccessibleCell();
            this.cells[i][5] = new InaccessibleCell();
        }
        // Add Plain Cell / Bush Cell / Cave Cell / Koulou Cell
        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                if (j != 2 && j != 5) {
                    int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
                    int random = ThreadLocalRandom.current().nextInt(1, 5);
                    switch (random) {
                        case 1: this.cells[i][j] = new PlainCell(); break;
                        case 2: this.cells[i][j] = new BushCell();  break;
                        case 3: this.cells[i][j] = new CaveCell();  break;
                        case 4: this.cells[i][j] = new KoulouCell();break;
                    }
                }
            }
        }
        this.window = new LOVWindow();
    }

    // getters
    public Cell[][] getCells() {
        return cells;
    }

    public int[] getPos(Hero hero) {
        return this.heros.get(hero);
    }

    public int[] getPos(Monster monster) {
        return this.monsters.get(monster);
    }

    public ArrayList<Monster> getMonsters() {
        ArrayList<Monster> output = new ArrayList<>();
        for (Monster monster : this.monsters.keySet()) {
            output.add(monster);
        }
        return output;
    }

    // setters
    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public void setCell(int row, int col, Cell cell) {
        this.cells[row-1][col-1] = cell;
    }

    // others
    public void print() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                window.drawCell(i+1, j+1, this.cells[i][j].getMarker());
            }
        }
        for (Hero hero : this.heros.keySet()) {
            int[] pos = this.heros.get(hero);
            ArrayList<String> marker = new ArrayList<>();
            marker.add(" xx ");
            marker.add("    ");
            window.drawCell(pos[0]+1, pos[1]+1, marker);
        }
        for (Monster monster : this.monsters.keySet()) {
            int[] pos = this.monsters.get(monster);
            ArrayList<String> marker = new ArrayList<>();
            marker.add(" oo ");
            marker.add("    ");
            window.drawCell(pos[0]+1, pos[1]+1, marker);
        }
        window.display();
    }

    public void addCharacter(Hero hero) {
        int num = this.heros.size();
        int[] pos = {7, num*3};
        this.heros.put(hero, pos);
    }

    public void addCharacter(Monster monster) {
        int num = this.monsters.size();
        int[] pos = {0, num*3};
        this.monsters.put(monster, pos);
    }

    public void move(Monster monster) {
        int pos[] = this.monsters.get(monster);
        int row = pos[0];
        int col = pos[1];
        int newpos[] = {row+1, col};
        this.monsters.replace(monster, newpos);
    }

    public boolean checkMovable(Hero hero, String direction) {
        int[] pos = this.heros.get(hero);
        int[] posChange = directionParser(direction);
        int row = pos[0] + posChange[0];
        int col = pos[1] + posChange[1];
        if (row < 0 || row > 7) return false;       // out of bound
        if (col < 0 || col > 7) return false;       // out of bound
        if (col == 2 || col == 5) return false;     // steps on inaccessible cells
        int[] newpos = {row, col};
        this.heros.replace(hero, newpos);
        return true;                                // return true and update hero pos
    }

    public int checkEvent(Hero hero) {
        int[] pos = this.heros.get(hero);
        if (pos[0] == 7) return 0;          // at nexus, trigger purchase event
        for (Monster monster : this.monsters.keySet()) {
            if (checkNeighbor(hero, monster)) return 1;     // hero monster neighboring, trigger battle event
        }
        return 2;                           // no event;
    }

    public int checkEvent(Monster monster) {
        for (Hero hero : this.heros.keySet()) {
            if (checkNeighbor(hero, monster)) return 1;     // hero monster neighboring, trigger battle event
        }
        return 2;                           // no event;
    }

    public Monster selectOpponent(Hero hero) {
        ArrayList<Monster> opponents = new ArrayList<Monster>();
        for (Monster monster : this.monsters.keySet()) {
            if (checkNeighbor(hero, monster)) opponents.add(monster);
        }
        return opponents.get(0);
    }

    public Hero selectOpponent(Monster monster) {
        ArrayList<Hero> opponents = new ArrayList<Hero>();
        for (Hero hero: this.heros.keySet()) {
            if (checkNeighbor(hero, monster)) opponents.add(hero);
        }
        return opponents.get(0);
    }

    public int[] directionParser(String direction) {
        int[] move = new int[2];
        switch (direction) {
            case "w": move = new int[]{-1,0}; break;
            case "a": move = new int[]{0,-1}; break;
            case "s": move = new int[]{1,0}; break;
            case "d": move = new int[]{0,1}; break;
        }
        return move;
    }

    public boolean checkNeighbor(Hero hero, Monster monster) {
        int[] posh = this.heros.get(hero);
        int rowh = posh[0];
        int colh = posh[1];
        int[] posm = this.monsters.get(monster);
        int rowm = posm[0];
        int colm = posm[1];
        boolean ver = (rowh - rowm == 1) || (rowh - rowm == -1);
        boolean hor = (colh - colm == 1) || (colh - colm == -1);
        if (ver && hor) return false;
        if (ver) return true;
        if (hor) return true;
        return false;
    }

    public String getCellName(Hero hero) {
        int[] pos = this.heros.get(hero);
        int row = pos[0];
        int col = pos[1];
        Cell cell = this.cells[row][col];
        return cell.getName();
    }

    public void HeroRevive(Hero hero) {
        int[] pos = this.heros.get(hero);
        int row = pos[0];
        int col = pos[1];
        int newrow = 7;
        int lane = col / 3;
        int newcol = lane * 3;
        int[] newpos = {newrow, newcol};
        this.heros.replace(hero, newpos);
    }

    public void MonsterDie(Monster monster) {
        this.monsters.remove(monster);
    }

    public void teleport() {
        // TODO
    }
}