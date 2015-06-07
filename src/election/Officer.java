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
public class Officer extends Thread{
    private int noOfficer;
    Candidate c;
    Buffer a;
    int votes = Election.StoreVotes.getNoOfVotes();
    Semaphore emptyVotes = new Semaphore(votes);
    public Officer(int noOfficer){
        this.noOfficer = noOfficer;
        
       
        
        
    }
    
   public void registerVote(Vote Id,int noCandidates){
      
       for(int i =0; i<noCandidates; i++)
       {
           if(Id.getCandidateID()==c.getCandidateID())
           {   
               int h = c.getCandidateID();
               System.out.println("Vote: "+h);
               c.IncrementVotes();
           }
          
       }
       
    
       
       
       
   }
    public void retreiveVote(){
      Vote v =   Election.StoreVotes.getVote();
        System.out.println(v.getCandidateID());
       // registerVote(v,5);
           
       }
    
    @Override
    public void run(){
        System.out.println(votes +"votes "+Election.StoreVotes.getNoOfVotes());
        while(Election.StoreVotes.getNoOfVotes() <10)
        {
            emptyVotes.down();
            System.out.println("acess");
            emptyVotes.up();
        }
   
        
        
    }
    
    
}
