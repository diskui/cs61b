package lab11.graphs;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */

    private Maze maze;

    private int[] nodeTo;

    public MazeCycles(Maze m) {
        super(m);
        maze = m;
        nodeTo = new int[maze.N() * maze.N()];
    }

    @Override
    public void solve() {
        // TODO: Your code here!
        dfs(0);
    }

    /* its parent, it */
    private void dfs(int v) {
        marked[v] = true;
        announce();

        for (int w : maze.adj(v)) {
            if (!marked[w]) {
                nodeTo[w] = v;
                dfs(w);
            }else{
                if(nodeTo[v] != w){
                    edgeTo[v] = w;
                    return;
                }
            }
        }
    }

    // Helper methods go here
}

