package com.zetcode;

import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
class Piece {
    public int xposition = 0;
    public int yposition = 0;
    public int[][] pieces = {{}, {}, {}, {}};
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

        ImageIcon ii = new ImageIcon("/Users/roman/IdeaProjects/untitled6/src/com/company/chess-board-vector-3726578.jpg");
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

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            DisplayImage ex = new DisplayImage();
            ex.setVisible(true);
        });
    }
}