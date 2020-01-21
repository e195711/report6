package jp.ac.uryukyu.ie.e195711;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel implements KeyListener, Runnable{
    //パネルサイズ
    static int HEIGHT;
    static int WIDTH;

    Field field;
    Mino mino;

    Panel() {
        HEIGHT = Field.HEIGHT * Field.BLOCK_SIZE;
        WIDTH = Field.WIDTH * Field.BLOCK_SIZE;

        // パネルの推奨サイズを設定、pack()するときに必要
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // パネルがキー入力を受け付けるようにする
        setFocusable(true);

        field = new Field();
        mino = new Mino();

        addKeyListener(this);

        //自由落下開始
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //フィールドを描画
        field.draw(g);

        //ミノを描画
        mino.draw(g);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(750);
                mino.move(2);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch ( e.getKeyCode() ) {
            case KeyEvent.VK_LEFT:
                mino.move(0);  //direction: 0 = LEFT
                break;
            case KeyEvent.VK_RIGHT:
                mino.move(1);  //direction: 1 = RIGHT
                break;
            case KeyEvent.VK_DOWN:
                mino.move(2);  ////direction: 3 = DOWN
                break;
            case KeyEvent.VK_SPACE:
                mino.turn();
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
