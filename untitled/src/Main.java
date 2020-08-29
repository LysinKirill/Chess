package com.zetcode;

import javafx.util.Pair;

import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
class Piece {
    static int score = 0;
    int type;
    public int xposition = 0;
    public int yposition = 0;
    public boolean color;
    void move(int new_x, int new_y){
        this.xposition = new_x;
        this.yposition = new_y;
    }
    void eat(Piece p1, Piece p2){
        p1.xposition = p2.xposition;
        p1.yposition = p2.yposition;
        p2.type = 0;
        int x = 0;
        if(p2.type == 1){
            x = 1;
        }
        if((p2.type == 2)|(p2.type == 3)){
            x = 3;
        }
        if(p2.type == 4){
            x = 5;
        }
        if(p2.type == 5){
            x = 9;
        }
        if(p2.color){
            x *= -1;
        }
        score += x;

    }
    public Piece(int xpos, int ypos, int type, boolean color){
        this.xposition = xpos;
        this.yposition = ypos;
        this.color = color; //false - белые, true - черные
        this.type = type;
    }
    //public Pair[] moves
    /*
    1 позиция:
    1 - пешка
    2 - слон
    3 - конь
    4 - ладья
    5 - ферзь
    6 - король
    0 - съедена
     */
}
class DisplayImage extends JFrame {

    public DisplayImage() {

        initUI();
    }

    private void initUI() {

        ImageIcon ii = loadImage();

        JLabel label = new JLabel(ii);

        createLayout(label);

        setTitle("Image");
        setLocationRelativeTo(null);
        setSize(1080, 1080);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private ImageIcon loadImage() {

        ImageIcon ii = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\untitled\\src\\pic\\chessboard.png");

        return ii;
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
        );

        pack();
    }

    /*
1 позиция:
1 - пешка
2 - слон
3 - конь
4 - ладья
5 - ферзь
6 - король
2, 3 позиция - координаты (от 0;0 до 7;7)
4 позиция
0 - белые
1 - черные
 */

    public static void main(String[] args) {
        Piece[] pieces = new Piece[32];
        int[] st = new int[]{0, 0, 4, 1, 0, 3, 2, 0, 2, 3, 0, 5, 4, 0, 6, 5, 0, 2, 6, 0, 3, 7, 0, 4,        0, 1, 1, 1, 1, 1, 2, 1, 1, 3, 1, 1, 4, 1, 1, 5, 1, 1, 6, 1, 1, 7, 1, 1,      0, 7, 4, 1, 7, 3, 2, 7, 2, 3, 7, 5, 4, 7, 6, 5, 7, 2, 6, 7, 3, 7, 7, 4,     0, 6, 1, 1, 6, 1, 2, 6, 1, 3, 6, 1, 4, 6, 1, 5, 6, 1, 6, 6, 1, 7, 6, 1,};
        for(int i = 0; i<32; i++){
            if(i < 16){
                pieces[i] = new Piece(i * 3, (i*3)+1, (i*3)+2, false);
            }else{
                pieces[i] = new Piece(i * 3, (i*3)+1, (i*3)+2, true);
            }

        }




        EventQueue.invokeLater(() -> {
            DisplayImage ex = new DisplayImage();
            ex.setResizable(false);
            ex.setVisible(true);
        });
    }
}