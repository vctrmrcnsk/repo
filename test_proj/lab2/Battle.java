package lab2;

import java.io.*;
import java.util.*;

class Battle {
	public static void main(String[] args) {
		int i;
		String more;
////////* Create available weapons first *////////
		int fireweaps = 1;
		int nextweap = 0;
		Gun[] guns = new Gun[fireweaps];
		Gun[] auxguns;

		System.out.println("=========================================================================");
		System.out.println("Let's create the available weapons:");
		do {
			guns[nextweap] = new Gun();
			auxguns = new Gun[fireweaps];
			for (i = 0; i < fireweaps; i++)
				auxguns[i] = guns[i];
			fireweaps++;
			nextweap++;
			guns = new Gun[fireweaps];
			for (i = 0; i < (fireweaps - 1); i++)
				guns[i] = auxguns[i];
			System.out.print("Add another gun (y/n)? ");
			more = KBInput.readStr();
		}
		while (more.equalsIgnoreCase("y"));
		
		auxguns = null;		

		Knife primary = new Knife();

		ExplosiveWeapon surprises = new ExplosiveWeapon();

////////* Create the gamers and assign them to  their teams *////////
		int gamers = 1;
		int nextgamer = 0;
		Gamer[] players = new Gamer[gamers];
		Gamer[] auxplayers;

		System.out.println("=========================================================================");
		System.out.println("Now let's create some players:");
		
		do {
			players[nextgamer] = new Gamer();
			auxplayers = new Gamer[gamers];
			for (i = 0; i < gamers; i++)
				auxplayers[i] = players[i];
			gamers++;
			nextgamers++;
			players = new Gamer[gamers];
			for (i = 0; i < (gamers - 1); i++)
				players[i] = auxplayers[i];
			System.out.print("Add another player (y/n)? ");
			more = KBInput.readStr();
		}
		while (more.equalsIgnoreCase("y"));
		
		
		
			
			
			
			
	}
}