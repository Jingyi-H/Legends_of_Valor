import java.util.*;

public class LOVWindow extends Window{
    public LOVWindow() {
        super(41,25);
        String rowLine = "+----+----+----+----+----+----+----+----+";
        String colLine = "+||+||+||+||+||+||+||+||+";
        for (int i = 0; i < 9; i++) {
            drawRow(1+i*3,1,rowLine);
            drawCol(1,1+i*5,colLine);
        }
    }

    public void drawCell(int row, int col, ArrayList<String> lines) {
        String[] block = new String[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            block[i] = lines.get(i);
        }
        drawBlock((row-1)*3+2,(col-1)*5+2, block);
    }
}
