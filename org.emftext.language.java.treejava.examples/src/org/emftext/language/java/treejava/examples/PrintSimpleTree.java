package org .emftext .language .java .treejava .examples ; 


class PrintSimpleTree { 
	public static void main (String [] args ) { 
			House myHouse = new House ( "SweetHome" , new Room ( ) , new Room ( "Kitchen" , new Door ( ) , new Door ( ) ) , new Room ( ) , new Room ( new Door ( ) ) , new Room ( new Door ( ) , new Door ( ) ) ) ; 
		} 
} 

