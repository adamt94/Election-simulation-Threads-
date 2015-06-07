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
public class Candidate {
    
    
    private int candidateID ;
    private int noVotes = 0;
    
    public Candidate(int candidateID){
        this.candidateID = candidateID;
        
    }
    public int getCandidateID(){
        return candidateID;
    }
    public int getNoVotes(){
        return noVotes;
    }
    
        
    public void IncrementVotes(){
        noVotes++;
    }
    
}
