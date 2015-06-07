/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package election;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ypf12pxu
 */
public class Election {

    /**
     * @param args the command line arguments
     */
    static int totalvotes = 20;
    static int noOfBooths = 5;
    static int noOfOfficers = 2;
    static int noOfCandidates = 5;
    static Candidate[] cand = new Candidate[noOfCandidates];
    static Buffer StoreVotes = new Buffer(totalvotes);
    static Officer[] officers = new Officer[noOfOfficers];

    public static void main(String[] args) {
        Vote t = new Vote(1, 5);

        for (int i = 0; i < noOfCandidates; i++) {

            cand[i] = new Candidate(i);

        }

        for (int i = 0; i < noOfBooths; i++) {
            Booths s = new Booths(i, noOfCandidates, totalvotes);

            s.start();

        }
        
        for (int i = 0; i < noOfOfficers; i++) {
            officers[i] = new Officer(i);
            officers[i].start();
        }
        try {
            for (int i = 0; i < noOfOfficers; i++) {
                officers[i].join();
            }
            for (int i = 0; i < noOfCandidates; i++) {

                System.out.println(cand[i]);

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Election.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
