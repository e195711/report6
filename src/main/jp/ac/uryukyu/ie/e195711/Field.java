package jp.ac.uryukyu.ie.e195711;

import java.awt.Color;
import java.awt.Graphics;

public class Field {
    //フィールドのサイズ(単位:ブロック)
    static int HEIGHT = 26;
    static int WIDTH = 12;

    //ブロックのサイズ
    static int BLOCK_SIZE = 15;

    //フィールドをint[][]で表現
    int[][] field;

    Field() {
        field = new int[HEIGHT][WIDTH];
        //初期化
        init();
    }

    void init() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                //壁を1, エリア内は0としてフィールドを初期化
                if (x == 0) {
                    field[y][x] = 1;
                }else if (x == WIDTH - 1) {
                    field[y][x] = 1;
                }else if (y == HEIGHT - 1) {
                    field[y][x] = 1;
                }else {
                    field[y][x] = 0;
                }
            }
        }
    }

    void draw(Graphics g) {
        //エリア内を黒く塗りつぶす
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Panel.WIDTH * BLOCK_SIZE, Panel.HEIGHT * BLOCK_SIZE);

        //壁を灰色に塗りつぶす
        g.setColor(Color.LIGHT_GRAY);
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (field[y][x] == 1) {
                    g.fillRect(x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }
    }

}
