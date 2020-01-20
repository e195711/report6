package jp.ac.uryukyu.ie.e195711;

import java.awt.Color;
import java.awt.Graphics;

class Mino {
    int[][] mino;

    //ミノの大きさ
    static int HEIGHT = 4;
    static int WIDTH = 4;

    //ブロックのサイズ
    static int BLOCK_SIZE = Field.BLOCK_SIZE;

    //現在地の座標
    int x;
    int y;

    Mino() {
        mino = new int[HEIGHT][WIDTH];

        init();

        //Iミノを作成
        //□■□□
        //□■□□
        //□■□□
        //□■□□
        mino[0][1] = 1;
        mino[1][1] = 1;
        mino[2][1] = 1;
        mino[3][1] = 1;

        x = 4;
        y = 4;
    }

    void init() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                mino[i][j] = 0;
            }
        }
    }

    void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (mino[i][j] == 1) {
                    g.fillRect((x + j) * BLOCK_SIZE, (y + i) * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }
    }

    void turn() {
        int[][] turnedBlock = new int[HEIGHT][WIDTH];

        // 回転したブロック
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                turnedBlock[j][HEIGHT - 1 - i] = mino[i][j];
            }
        }

        mino = turnedBlock;
    }

    void move(int direction) {
        switch (direction) {
            case 0:  //direction: 0 = LEFT
                x -= 1;
                break;
            case 1:  //direction: 1 = RIGHT
                x += 1;
                break;
            case 2:  //direction: 2 = DOWN
                y += 1;
                break;
        }
    }
}
