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

    public int getBoothID() {
        return boothID;
    }

    public int getBooths() {
        return booth;
    }

    @Override
    public void run() {

        while (true) {

            sem.down();
            if (Election.totalvotes <= 0) {
                sem.up();
                break;
            }

            
            StoreVotes.addVote(boothID);
            Election.totalvotes--;
            sem.up();
        }
    }

}
