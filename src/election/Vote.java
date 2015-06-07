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
public class Vote {
    
    private int voteID;
    private int candidateID;
    
    
    public Vote(int candidateID, int voteID){
        this.voteID = voteID;
        this.candidateID = candidateID;
        
    }
    
    public int getVoteID(){
        return voteID;
    }
    public int getCandidateID(){
        return candidateID;
    }
    
}
