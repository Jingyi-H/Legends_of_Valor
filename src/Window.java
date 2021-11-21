// GUI display window
public class Window {
    private int width;
    private int height;
    private char[][] pixels;

    public Window(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new char[height][width];
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.pixels[i][j] = ' ';
            }
        }
    }

    public Window(int dim) {
        this(dim, dim);
    }

    public void drawPixel(int row, int col, char pix) {
        this.pixels[row-1][col-1] = pix;
    }

    public void drawRow(int row, int col, String str) {
        // draw a row of board components
        int len = str.length();
        if (col + len - 1 <= this.width) {
            for (int i = 0; i < len; i++) {
                this.pixels[row-1][col-1+i] = str.charAt(i);
            }
        } else {
            System.out.println("Failed to draw row.");
        }
    }

    public void drawCol(int row, int col, String str) {
        // draw a column of board components
        int len = str.length();
        if (row + len - 1 <= this.height) {
            for (int i = 0; i < len; i++) {
                this.pixels[row-1+i][col-1] = str.charAt(i);
            }
        } else {
            System.out.println("Failed to draw col.");
        }
    }

    public void drawBlock(int row, int col, String[] block) {
        // draw block components
        int block_rows = block.length;
        int block_cols = block[0].length();
        if (row + block_rows - 1 <= this.height && col + block_cols - 1 <= this.width) {
            for (int i = 0; i < block_rows; i++) {
                drawRow(row+i, col, block[i]);
            }
        } else {
            System.out.println("Failed to draw block.");
        }
    }

    public void clear(int row1, int col1, int row2, int col2) {
        // clear current board
        for (int i = row1; i < row2+1; i++) {
            for (int j = col1; j < col2+1; j++) {
                drawPixel(i,j,' ');
            }
        }
    }

    public void display() {
        // display window
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(pixels[i][j]);
            }
            System.out.println();
        }
    }
}
