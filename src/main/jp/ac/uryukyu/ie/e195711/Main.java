package jp.ac.uryukyu.ie.e195711;

import javax.swing.JFrame;
import java.awt.Container;

class Main extends JFrame {
    Main() {
        //タイトルの設定
        setTitle("ミノの表示•移動•回転");
        //サイズ変更不可
        setResizable(false);
        //閉じるボタンをクリックしたときの処理を設定
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //パネルを作成してフレームに追加
        Panel panel = new Panel();
        Container contentPane = getContentPane();
        contentPane.add(panel);

        //パネルサイズに合わせてフレームサイズを自動設定
        pack();
    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setVisible(true);
    }
}
