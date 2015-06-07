/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package election;

import java.util.ArrayList;

/**
 *
 * @author ypf12pxu
 */
public class Election {

    /**
     * @param args the command line arguments
     */
    
   static Buffer StoreVotes = new Buffer(20);
    
    public static void main(String[] args) {
           Vote t = new Vote(1,5);
     

        ArrayList<Candidate> cand = new ArrayList();
        for (int i = 0; i < 5; i++) {
            Candidate c = new Candidate(i);
            cand.add(c);

        }
        
        for (int i = 0; i < 3; i++) {
            Booths s = new Booths(i, 5, 10);
           
            s.start();
           
              
        }
        Officer p = new Officer(1);
        p.start();
        
       
    
    

    }

}
