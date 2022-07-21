package hw2;

import org.junit.Test;

import static org.junit.Assert.*;


public class testPercolation {

    @Test
    public void testPercolation(){
        Percolation p = new Percolation(10);
        assertFalse(p.percolates());

        for(int i = 0; i < 10; i++){
            p.open(i,2);
            assertEquals(i+1,p.numberOfOpenSites());
            System.out.println(p.numberOfOpenSites());
        }





    }
}
