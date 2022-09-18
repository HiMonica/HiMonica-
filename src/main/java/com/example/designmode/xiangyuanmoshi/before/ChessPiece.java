package com.example.designmode.xiangyuanmoshi.before;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 为了记录每个房间当前的棋局情况，我们需要给每个房间都创建一个ChessBoard棋局对象，因为游戏大厅中有成千上万
 * 的房间，那保存这么多棋局对象就会消耗大量的内存，有没有什么办法来节省内存呢？
 *    享元模式：在内存中会有大量的相似对象。这些相似对象的id、text、color都是相同的，唯独positionX、positionY不同
 *    实际上，我们可以将棋子的id、text、color属性拆分出来，设计成独立的类，并且作为享元供多个棋盘复用。
 */

/**
 * @author julu
 * 棋子
 * @date 2022/9/13 08:07
 */
@Data
public class ChessPiece {

    private int id;

    private String text;

    private Color color;

    private int positionX;

    private int positionY;

    public ChessPiece(int id, String text, Color color, int positionX, int positionY) {
        this.id = id;
        this.text = text;
        this.color = color;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public static enum Color{
        RED, BLACK
    }
}

/**
 * 棋局
 */
class ChessBoard{

    private Map<Integer, ChessPiece> chessPieces = new HashMap<>();

    public ChessBoard(){
        init();
    }

    private void init(){
        chessPieces.put(1, new ChessPiece(1, "车", ChessPiece.Color.RED, 0 ,0));
        chessPieces.put(2, new ChessPiece(2, "马", ChessPiece.Color.BLACK, 0, 0));
    }

    public void move(int chessPieceId, int toPositionX, int toPositionY){

    }
}


/**
 * 改造如下
 */
//享元类
@Data
class ChessPieceUnit{

    private int id;

    private String text;

    private Color color;

    public ChessPieceUnit(int id, String text, Color color) {
        this.id = id;
        this.text = text;
        this.color = color;
    }

    public static enum Color{
        RED,BLACK
    }
}

class ChessPieceUnitFactory{

    private static final Map<Integer, ChessPieceUnit> pieces = new HashMap<>();

    static {
        pieces.put(1, new ChessPieceUnit(1, "车", ChessPieceUnit.Color.RED));
        //省略
    }

    public static ChessPieceUnit get(int chessPieceId){
        return pieces.get(chessPieceId);
    }
}

class ChessPiece1{

    private ChessPieceUnit chessPieceUnit;

    private int x;

    private int y;

    public ChessPiece1(ChessPieceUnit chessPieceUnit, int x, int y) {
        this.chessPieceUnit = chessPieceUnit;
        this.x = x;
        this.y = y;
    }
}

class ChessBoard1{
    private Map<Integer, ChessPiece1> chessPiece1Map = new HashMap<>();

    public ChessBoard1(){
        init();
    }

    private void init() {
        chessPiece1Map.put(1, new ChessPiece1(ChessPieceUnitFactory.get(1), 0, 0));
    }
}


/**
 * 享元模式在Java中的使用
 * 1、IntegerCache就是Integer的享元工厂类
 * 2、String中的常量池
 */
