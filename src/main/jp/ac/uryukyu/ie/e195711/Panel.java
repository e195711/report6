package jp.ac.uryukyu.ie.e195711;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

public class Panel extends JPanel {
    //パネルサイズ
    int HEIGHT;
    int WIDTH;

    Field field;

    Panel() {
        field = new Field();

        HEIGHT = field.HEIGHT * field.BLOCK_SIZE;
        WIDTH = field.WIDTH * field.BLOCK_SIZE;

        // パネルの推奨サイズを設定、pack()するときに必要
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // フィールドを描画
        field.draw(g);
    }
}
