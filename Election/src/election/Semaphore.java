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
public class Semaphore {
    // Allow for both counting or mutex semaphores.
	private int count;

	// *************************************************************
	// Constructor
	public Semaphore ( int n ) 	{
		count = n;
	}

	// *************************************************************
	// Public class methods.
	
	// Only the standard up and down operators are allowed.
	public synchronized void down ( ) {

		while ( count == 0 ) {
		
			try {
				wait(); // Blocking call.
			} catch ( InterruptedException exception ) {
				exception.printStackTrace ( );
			}
		}
		count--;
	}

	public synchronized void up ( ) {
    	count++;
		notify();
	}
    
}
