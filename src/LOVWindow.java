import java.util.*;

public class LOVWindow extends Window{
    // GUI display window of LOV
    public LOVWindow() {
        super(42,26);
        String rowLine = "+----+----+----+----+----+----+----+----+";
        String colLine = "+||+||+||+||+||+||+||+||+";
        String rowIndex = "  0    1    2    3    4    5    6    7   ";
        String colIndex = " 0  1  2  3  4  5  6  7  ";
        for (int i = 0; i < 9; i++) {
            drawRow(1+i*3,1,rowLine);
            drawCol(1,1+i*5,colLine);
        }
        drawRow(26,1,rowIndex);
        drawCol(1,42,colIndex);
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
