package hw4.puzzle;

import edu.princeton.cs.algs4.Queue;

public class Board implements WorldState{

    private final int[][] tiles;

    private static final int BLANK = 0;

    private int N;

    public Board(int[][] tiles){
        if(tiles == null || tiles.length != tiles[0].length){
            throw new IllegalArgumentException();
        }
        N = tiles.length;
        this.tiles = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                this.tiles[i][j] = tiles[i][j];
            }
        }

    }
    public int tileAt(int i, int j){
        if(i < 0 || i >= N || j < 0 || j >= N){
            throw new IndexOutOfBoundsException();
        }
        return tiles[i][j];
    }
    public int size(){
        return N;
    }
    public Iterable<WorldState> neighbors(){
        Queue<WorldState> neighbors = new Queue<WorldState>();
        int hug = size();
        int bug = -1;
        int zug = -1;
        //find the blank tile
        for (int rug = 0; rug < hug; rug++) {
            for (int tug = 0; tug < hug; tug++) {
                if (tileAt(rug, tug) == BLANK) {
                    bug = rug;
                    zug = tug;
                }
            }
        }
        //copy a tiles array
        int[][] newTiles = new int[hug][hug];
        for (int pug = 0; pug < hug; pug++) {
            for (int yug = 0; yug < hug; yug++) {
                newTiles[pug][yug] = tileAt(pug, yug);
            }
        }
        for (int i = 0; i < hug; i++) {
            for (int j = 0; j < hug; j++) {
                if (Math.abs(-bug + i) + Math.abs(j - zug) - 1 == 0) {// found the blank
                    newTiles[bug][zug] = newTiles[i][j];
                    newTiles[i][j] = BLANK;
                    Board neighbor = new Board(newTiles);
                    neighbors.enqueue(neighbor);
                    newTiles[i][j] = newTiles[bug][zug];
                    newTiles[bug][zug] = BLANK;
                }
            }
        }
        return neighbors;
    }
    public int hamming(){
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(tiles[i][j] == 0){
                    continue;
                }
                else if(tiles[i][j] != i * N + j + 1){
                    count += 1;
                }
            }
        }
        return count;
    }
    public int manhattan(){
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(tiles[i][j] == 0){
                    continue;
                }else{

                    int val = tiles[i][j];
                    int h = Math.abs(((val - 1)  % N) - j);
                    int v = Math.abs(((val - 1) / N) - i);
                    count += h + v;

                }
            }
        }
        return count;
    }
    public int estimatedDistanceToGoal(){
        return manhattan();
    }
    public boolean equals(Object y){

        if(this == null || y == null){
            return false;
        }

        if(this == y){
            return true;
        }

        if(y.getClass().equals("".getClass())){
            return this.toString().equals(y);
        }

        Board b = (Board) y;

        if(this.size() != b.size()){
            return false;
        }
        for(int i =  0; i < this.size(); i++){
            for(int j = 0; j < this.size();j++){
                if(this.tileAt(i,j) != b.tileAt(i,j)){
                    return false;
                }
            }
        }
        return true;
    }

    /** Returns the string representation of the board.
      * Uncomment this method. */
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i,j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

    public int hachCode(){
        return 0;
    }

}
