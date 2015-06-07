/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package election;

/**
 *
 * @author ypf12pxu
 */
public class Buffer {
    
    private Vote[] storeVote;
    private int size;
    private int noOfVotes=0;
    private int w =0;
    private int r = -1;
      private static Semaphore addvote = new Semaphore(1);
    
    public Buffer(int size){
        this.size = size;
        storeVote = new Vote[size];
    }
    
    
    public void addVote(Vote v){
        addvote.down();
       storeVote[w] = v;
       w++;
       addvote.up();
        noOfVotes();
    }
    
    public Vote getVote(){
       addvote.down();
        r++;
         addvote.up();
        return storeVote[r];
       
    }
    public void noOfVotes(){
        noOfVotes++;
        
    }
    public int getNoOfVotes(){
        return noOfVotes;
    }
    
    
    
}
