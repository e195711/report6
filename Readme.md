# 大まかな仕様の目標  
- フィールドの大きさは20x10  
- キーボードで操作  
- 右回転の実装  
- 自由落下の実装  
- 左右移動の実装  
- テトリミノはI,S,Z,L,J,O,T  
- 降ってくるテトリミノは7種一巡とする  
- テトリミノが設置され、横一列のブロックが隙間なく揃ったラインは削除  
- 20列埋まるorテトリミノの出現位置とブロックが重なるとゲームオーバー  

# クラスの詳細決め  
1. フィールドの表示までの機能
2. ミノの実装(ひとまずIミノのみ)
3. 自動落下の実装
## Fieldクラス  
### フィールド変数  
- int[][] field  
    - 二重配列で表現する  
    - 中身はinitメソッドで作る  
- int HEIGHT = 26  
    - 20ブロック + 底1ブロック + ブロック出現スペース5ブロック = 26とする  
- int WIDTH = 12  
    - 10ブロック + 壁2ブロック = 12ブロックとする  
        - ブロックのサイズを単位とする  
- int BLOCK_SIZE = 15  
    - ブロックのサイズ  
### メソッド  
- Field()
    - Fieldを作り，初期化するコントラクタ
- init()  
    - 壁しかないfieldを作る  
- draw()  
    - fieldを基に実際の画面に描画する
## Panelクラス  
### フィールド変数
- int HEIGHT
- int WIDTH  
    - パネルの大きさ(ブロックの数xブロックのサイズとする)  
- Field field  
    - Fieldのインスタンス  
- Mino mino  
    - Minoのインスタンス  
### メソッド  
- Panel()  
    - フィールド変数の設定，パネルの大きさを設定するコントラクタ  
    - インスタンスの実体化もここで行う  
- paintComponent(Graphics g)  
    - 描画するためにはOverrideしないといけない  
    - FieldとMinoの描画処理を呼び出す  
- run()  
    - 並列処理のためにOverrideしないといけない  
    - 一定秒ごとに下に落ちることで自由落下を実装する
- keyTyped()
- keyReleased()
- keyPressed()
    - 左右下を押した時にMinoのmoveを呼び出す
    - spaceキーで右回転させる
        - キー入力処理のためにOverrideしないといけないメッソド
## Minoクラス  
### フィールド変数  
- int[][] Mino  
    - 二重配列で表現する  
    - 中身はinitメソッドで作る  
- int HEIGHT = 4  
- int WIDTH = 4  
    - ミノの大きさ  
- int BLOCK_SIZE = Field.BLOCK_SIZE  
    - ブロックのサイズ  
- int x  
- int y  
    - 現在地の座標  
### メソッド  
- Mino()  
    - Minoを作り，初期化するコントラクタ  
- init()  
    - Minoを作る  
- draw()  
    - Minoを基に実際の画面に描画する  
- turn()  
    - Minoを右回転させる  
- move(int direction)  
    - directionによって現在地の座標を変える  
## Mainクラス  
### フィールド変数    
### メソッド  
- Main()  
    - フレームの設定をするコントラクタ  
    - パネルの実体化もここで行う  
- main(String[] args)  
    - フレームの実体化を行う  