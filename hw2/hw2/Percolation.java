package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    /** the inner disjoint-set */
    private WeightedQuickUnionUF wqu;

    /** the is-open? grid */
    private boolean[][] grid;

    private int N;

    private int openSite;

    public Percolation(int N){

        if(N <= 0){
            throw new java.lang.IllegalArgumentException();
        }

        this.N = N;
        openSite = 0;

        wqu = new WeightedQuickUnionUF(N * N + 2);
        grid = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == 0){
                    wqu.union(xy2n(i,j),N*N);
                }
                if(i == N-1){
                    wqu.union(xy2n(i,j),N*N+1);
                }
                grid[i][j] = false;
            }
        }
    }                // create N-by-N grid, with all sites initially blocked
    public void open(int row, int col){       // open the site (row, col) if it is not open already
       if(row < 0 || col < 0 || row >= N || col >= N){
           throw new java.lang.IndexOutOfBoundsException();
       }

        grid[row][col] = true;

        if(row != 0 && isOpen(row-1,col)){
            wqu.union(xy2n(row-1,col),xy2n(row,col));
        }
        if(col != 0 && isOpen(row,col -1 )){
            wqu.union(xy2n(row,col - 1),xy2n(row,col));
        }
        if(row != N-1 && isOpen(row+1,col)){
            wqu.union(xy2n(row+1,col),xy2n(row,col));
        }
        if(col != N-1 && isOpen(row,col+1)){
            wqu.union(xy2n(row,col+1),xy2n(row,col));
        }


        openSite += 1;
    }

    public boolean isOpen(int row, int col){  // is the site (row, col) open?
        if(row < 0 || col < 0 || row >= N || col >= N){
            throw new java.lang.IndexOutOfBoundsException();
        }
        return grid[row][col];
    }
    public boolean isFull(int row, int col){  // is the site (row, col) full?
        if(row < 0 || col < 0 || row >= N || col >= N){
            throw new java.lang.IndexOutOfBoundsException();
        }
        return wqu.connected(xy2n(row,col),N*N);
    }
    public int numberOfOpenSites(){           // number of open sites
        return openSite;
    }
    public boolean percolates(){              // does the system percolate?
        return wqu.connected(N*N,N*N+1);
    }

    private int xy2n(int x,int y){
        return x * this.N + y;
    }

    public int getN(){
        return N;
    }

    public static void main(String[] args){   // use for unit testing (not required)

    }

}
