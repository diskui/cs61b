package hw4.puzzle;

import  edu.princeton.cs.algs4.MinPQ;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.List;

public class Solver {
    private class SearchNode implements Comparable<SearchNode>{
        private WorldState state;
        private int moves;
        private SearchNode prev;

        public SearchNode(WorldState s,int m,SearchNode p){
            state = s;
            moves = m;
            prev = p;
        }

        public WorldState getState() {
            return state;
        }

        public int getMoves() {
            return moves;
        }

        public SearchNode getPrev() {
            return prev;
        }

        @Override
        public int compareTo(SearchNode o) {
            return this.getMoves() + this.getState().estimatedDistanceToGoal() - o.getMoves() - o.getState().estimatedDistanceToGoal();
        }
    }

    private int totalMove;

    private MinPQ<SearchNode> pq;

    private List<WorldState> solution;

    private void getAnswer(SearchNode s){
        totalMove = s.getMoves();
        solution = new ArrayList<>();
        while (s != null){
            solution.add(s.getState());
            s = s.prev;
        }
    }

    public Solver(WorldState initial){
        pq = new MinPQ<>();
        pq.insert(new SearchNode(initial,0,null));
        SearchNode curSearch = pq.delMin();
        WorldState curWorld = curSearch.getState();
        while(!curWorld.isGoal()){
            for(WorldState w:curWorld.neighbors()){
                if(curSearch.prev == null || !w.equals(curSearch.prev.getState())){
                    SearchNode newSearch = new SearchNode(w,curSearch.getMoves() + 1,curSearch);
                    pq.insert(newSearch);
                }
            }
            curSearch = pq.delMin();
            curWorld = curSearch.getState();
        }
        getAnswer(curSearch);
    }
    public int moves(){
        return totalMove;
    }
    public Iterable<WorldState> solution(){
        List<WorldState> res = new ArrayList<>();
        for(int i = totalMove; i >= 0; i--){
            res.add(solution.get(i));
        }
        return res;
    }
}
