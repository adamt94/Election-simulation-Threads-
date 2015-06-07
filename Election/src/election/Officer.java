/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package election;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ypf12pxu
 */
public class Officer extends Thread {

    private int noOfficer;
    Candidate c;
    private int votes;
    

    public Officer(int noOfficer) {
        this.noOfficer = noOfficer;

    }

    public void registerVote(Vote Id, int noCandidates) {

        for (int i = 0; i < noCandidates; i++) {
            if (Id.getCandidateID() == c.getCandidateID()) {
                int h = c.getCandidateID();
                System.out.println("Vote: " + h);
                c.IncrementVotes();
            }

        }

    }

    public void retreiveVote() throws InterruptedException {
     
     Vote vote = Election.StoreVotes.getVote(noOfficer);
       if(vote!=null){
           Election.cand[vote.getCandidateID()].IncrementVotes();
        System.out.println(Election.cand[vote.getCandidateID()]);
       }
     
    }

    @Override
    public void run() {
        
        while (Election.totalvotes>0 && Election.StoreVotes.cap != Election.StoreVotes.getSize()) {
            
            try {
                retreiveVote();
            } catch (InterruptedException ex) {
                Logger.getLogger(Officer.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("OFFICER ID: " + noOfficer + " SWIRLING");
            boolean test = Election.totalvotes>0 && Election.StoreVotes.cap != Election.StoreVotes.getSize();
        System.out.println("test: " + test);
        }
        System.out.println("OFFICER COMPLETE");
        
    }
}
