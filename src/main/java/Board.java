import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Board extends JFrame {
    private final JButton[][] squares = new JButton[7][];
private boolean playerRedTurn;
private int turn;
private int [] row = new int[7];
    public Board() {
        for(int i = 0; i < Constant.BOARD_WIDTH; ++i) {
            this.squares[i] = new JButton[Constant.BOARD_WIDTH];

            for(int j = 0; j < Constant.BOARD_WIDTH; ++j) {
                row [i] = 1;
                JButton square = new JButton();
                if (i == 0) {
                    square.setText(String.valueOf(j + 1));
                    square.setBackground(Color.WHITE);
                    square.setFont(new Font(Constant.FONT_NAME, 1, Constant.FONT_SIZE));
                    square.addActionListener((e) -> {
                        int turn = 1;
                        if (row[Integer.parseInt(square.getText()) - 1] <= 6) {
                        int k = 1;
                            if (playerRedTurn) {
                                playerRedTurn = false;
                                turn = 1;
                            } else {
                                turn = 2;
                                playerRedTurn = true;
                            }
                            int x = Integer.parseInt(square.getText());
                            int y = row[Integer.parseInt(square.getText()) - 1];
                            placeSquare(x, y, turn);
                                row[Integer.parseInt(square.getText()) - 1]++;
                            }
                    });
                } else {
                    square.setEnabled(false);
                }

                this.squares[i][j] = square;
                this.add(square);
            }
        }

        this.setLocationRelativeTo((Component)null);
        GridLayout gridLayout = new GridLayout(Constant.BOARD_WIDTH, Constant.BOARD_HEIGHT);
        this.setLayout(gridLayout);
        this.setSize(Constant.BOARD_HEIGHT * Constant.SQUARE_SIZE, Constant.BOARD_HEIGHT * Constant.SQUARE_SIZE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void placeSquare(int x, int y, int player) {
        this.squares[Constant.BOARD_WIDTH - y][x - 1].setBackground(player == 1 ? Color.RED : Color.YELLOW);
    }

    public int getPlayerInSquare(int x, int y) {
        byte player = 0;

        try {
            Color backgroundColor = this.squares[Constant.BOARD_WIDTH - y][x - 1].getBackground();
            if (backgroundColor.equals(Color.RED)) {
                player = 1;
            } else if (backgroundColor.equals(Color.YELLOW)) {
                player = 2;
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return player;
    }
    public void victory (int player){
        int BOARD_WIDTH = 7;
        int BOARD_HEIGHT = 6;
        for (int i = 0; i < BOARD_HEIGHT; i++){
            
                System.out.println("yow win");
        }
    }
}
