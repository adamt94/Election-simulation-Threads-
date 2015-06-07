/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package election;

import static election.Election.StoreVotes;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ypf12pxu
 */
public class Booths extends Thread {

    private int booth;
    private int boothID;
    int voteId = 0;
    private static int voter;
    int x;
    private int noCandidates;
    Buffer a;
    private static Semaphore sem = new Semaphore(1);
    private static Semaphore addvote = new Semaphore(1);
  

    public Booths(int boothID, int noCandidates, int noOfVotes) {
        voter = noOfVotes;
        this.boothID = boothID;
        this.noCandidates = noCandidates;
       
    }

    public int getBooths() {
        return booth;
    }
  

    @Override
    public void run() {

        while (voter > 0) {
           sem.down();
            voter--;
            
            System.out.println(voter);
            sem.up();
            try {
                Random r = new Random();
                int i = r.nextInt(1000);
                x = r.nextInt(noCandidates);
                  
                Thread.sleep(i);
                System.out.println(" Generating Vote" + " Booth: " + boothID);
                
                Vote  v = new Vote(x, voteId);
            
                voteId++;

           // System.out.println("number of votes generated: "+voteId);
                //System.out.println(v.getCandidateID());
               
               // System.out.println(v.getCandidateID());
                    StoreVotes.addVote(v);
                  //  Vote f = StoreVotes.getVote();
                  // System.out.println(f.getCandidateID());
              
                       
             
            } catch (InterruptedException ex) {
                Logger.getLogger(Booths.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(" voter leaving booth: " + boothID);
          // addvote.up();
          //  sem.up();

        }
    }

}
