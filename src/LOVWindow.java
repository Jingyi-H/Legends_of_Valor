import java.util.*;

public class LOVWindow extends Window{
    // GUI display window of LOV
    public LOVWindow() {
        super(70,26);
        String rowLine = "+----+----+----+----+----+----+----+----+";
        String colLine = "+||+||+||+||+||+||+||+||+";
        String rowIndex = "  0    1    2    3    4    5    6    7   ";
        String colIndex = " 0  1  2  3  4  5  6  7  ";
        for (int i = 0; i < 9; i++) {
            drawRow(1+i*3,1,rowLine);
            drawCol(1,1+i*5,colLine);
        }
        drawRow(26,1,rowIndex);
        drawCol(1,43,colIndex);

        String[] hero = {" h0 ", "    "};
        String[] monster = {" xx ", "    "};
        String[] bushcell = {"^^^^", "^^^^"};
        String[] cavecell = {"/"+"--"+"\\", "\\"+"__"+"/"};
        String[] kouloucell = {"|##|", "|##|"};
        drawBlock(2,50, hero);
        drawBlock(5, 50, monster);
        drawBlock(8,50,bushcell);
        drawBlock(11,50,cavecell);
        drawBlock(14,50,kouloucell);
        drawRow(2,56, "HERO");
        drawRow(5,56,"MONSTER");
        drawRow(8,56,"BUSH CELL");
        drawRow(11,56,"CAVE CELL");
        drawRow(14,56,"KOULOU CELL");
    }

    public void drawCell(int row, int col, ArrayList<String> lines) {
        // draw a fancy cell in terminal
        String[] block = new String[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            block[i] = lines.get(i);
        }
        drawBlock((row-1)*3+2,(col-1)*5+2, block);
    }
}
