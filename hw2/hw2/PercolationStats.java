package hw2;

import edu.princeton.cs.introcs.StdRandom;

import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    private double[] res;

    private int N;
    public PercolationStats(int N, int T, PercolationFactory pf){   // perform T independent experiments on an N-by-N grid
        if(N <= 0 || T <= 0){
            throw new java.lang.IllegalArgumentException();
        }
        this.N = N;
        res = new double[T];
        int i = 0;
        while(i < T){
            Percolation p = pf.make(N);
            res[i] = compute(p);
            i++;
        }
    }

    private double compute(Percolation p){
        int opened = 0;
        int n = N;
        while(!p.percolates()){
            int x = StdRandom.uniform(n);
            int y = StdRandom.uniform(n);
            while(p.isOpen(x,y)){
                x = StdRandom.uniform(n);
                y = StdRandom.uniform(n);
            }
            p.open(x,y);
            opened += 1;
        }
        return opened / n * n;
    }

    public double mean(){                                           // sample mean of percolation threshold
        return StdStats.mean(res);
    }
    public double stddev(){                                         // sample standard deviation of percolation threshold
        return StdStats.stddev(res);
    }
    public double confidenceLow(){                                  // low endpoint of 95% confidence interval
        return mean() - 1.96 * stddev() / Math.sqrt(res.length);
    }
    public double confidenceHigh(){                                 // high endpoint of 95% confidence interval
        return mean() + 1.96 * stddev() / Math.sqrt(res.length);
    }
}
