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
public class Buffer {

    private Vote[] storeVote;
    private int size;
    int cap;//how many items are in the buffer
    private int noOfVotes = 0;
    private int w = 0;
    private int r = -1;
    Booths b;
    int voteid = 0;
    private static Semaphore addvote = new Semaphore(Election.noOfBooths);
    private static Semaphore removevote = new Semaphore(0);

    public Buffer(int size) {
        this.size = size;
        storeVote = new Vote[size];
    }

    public int getSize() {
        return size;
    }

    public void addVote(int boothId) {
        try {
            Random r = new Random();
            int i = r.nextInt(1000);
            int x = r.nextInt(Election.noOfCandidates);

            Thread.sleep(i);

            Vote vote = new Vote(x, voteid);
            System.out.println("Voter: " + voteid + " Candidate: " + x + " Booth " + boothId);
            voteid++;

            addvote.down();
            storeVote[w] = vote;

            w++;
            removevote.up();

        } catch (InterruptedException ex) {
            Logger.getLogger(Booths.class.getName()).log(Level.SEVERE, null, ex);
        }

        // addvote.up();
        //  sem.up();
    }

    public Vote getVote(int officerId) throws InterruptedException {
        Random rand = new Random();
        int i = rand.nextInt(1000);
        System.out.println("Officer " + officerId + " TRYING TO CALL DOWN YO");
        Thread.sleep(i);
        removevote.down();
        if(Election.totalvotes<=0){
            removevote.up();
            return null;
        }
        r++;
        cap++;
        addvote.up();
        System.out.println("Officer " + officerId + " TRYING TO CALL UP WOAH");
        return storeVote[r];

    }

    public int getNoOfVotes() {
        return noOfVotes;
    }

}
