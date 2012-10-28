package lab2;

import java.io.*;
import java.util.*;

class Battle {
	public static void save_stats(String filename, String data) {
		try {
			File file = new File(filename);
			if (!file.exists())  {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(data);
			bw.close();
		}
		catch (IOException e) {
			System.out.println("Failed to write to file " + filename);
		}
	}

	public static void main(String[] args) throws IOException {
		int i;
		boolean team0 = false; 
		boolean team1 = false;
		boolean end = false;
		int team0stat = 0;
		int team1stat = 0;
		int playersStat = 0;
		int currentShoe, currentBug;
		String more;

		////////* Create available weapons first *////////
		int fireweaps = 1;
		int nextweap = 0;
		Random generator = new Random();
		Gun[] guns = new Gun[fireweaps];
		Gun[] auxguns;
		Weapon[] set = new Weapon[4];

		System.out.println("=========================================================================");
		System.out.println("Let's create the available fire weapons:");
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
		System.out.println("\nAlso, knife created with 0.9 destructive power\n");
		System.out.println("Now we will create some \"surprises\":");
		ExplosiveWeapon surprises = new ExplosiveWeapon();

		////////* Create the gamers and assign them to  their teams *////////
		int gamers = 1;
		int nextgamer = 0;
		Gamer[] players = new Gamer[gamers];
		Gamer[] auxplayers;

		System.out.println("=========================================================================");
		System.out.println("Now let's create some players:");
		
		do {
			if (gamers < 2)
				System.out.println("\nAt least two players are needed\n");
			players[nextgamer] = new Gamer();
			if (players[nextgamer].get_team() == 0)
				team0 = true;
			else if (players[nextgamer].get_team() == 1)
				team1 = true;
			auxplayers = new Gamer[gamers];
			for (i = 0; i < gamers; i++)
				auxplayers[i] = players[i];
			gamers++;
			nextgamer++;
			players = new Gamer[gamers];
			for (i = 0; i < (gamers - 1); i++)
				players[i] = auxplayers[i];
			System.out.print("Add another player (y/n)? ");
			more = KBInput.readStr();
		}
		while (more.equalsIgnoreCase("y") || gamers <= 2);
		
		System.out.println(nextgamer + " players created");

		for (i = 0; i < (gamers - 1); i++) {
			set[0] = (Weapon)(primary);
			set[1] = (Weapon)(guns[generator.nextInt(fireweaps-1)]);
			set[2] = (Weapon)(guns[generator.nextInt(fireweaps-1)]);
			set[3] = (Weapon)(surprises);
			players[i].set_weapons(set);
		}			
		
		System.out.println("=========================================================================");
		if (team0 && team1) {
			System.out.print("Allow friendly fire (y/n)? ");
			if ((more = KBInput.readStr()).equalsIgnoreCase("y"))
				Gamer.set_friendlyFire(true);
			for (i = 0; i < (gamers - 1); i++) {
				if (players[i].get_team() == 0)
					team0stat++;
				else
					team1stat++;
			}
		}
		else {
			System.out.println("Players only in one team! Friendly fire allowed.");
			Gamer.set_friendlyFire(true);
			playersStat = gamers - 1;
		}
		System.out.println("team0: " + team0stat + " team1: " + team1stat + " no team players: " + playersStat + "\n");

		////////* game loop *////////
		while (!end) {
			currentShoe = generator.nextInt(gamers-1);
			if (Gamer.get_friendlyFire()) {
				do {
					currentBug = generator.nextInt(gamers-1);
				}
				while (currentShoe == currentBug);
			}
			else {
				do {
					currentBug = generator.nextInt(gamers-1);
				}
				while (players[currentShoe].get_team() == players[currentBug].get_team());
			}
			
			if (players[currentShoe].isAlive() && players[currentBug].isAlive()) {
				float bugPrevHealth = players[currentBug].get_health();
				float damg;
				players[currentShoe].set_currentWeapon(generator.nextInt(4));
				players[currentShoe].shoot(players[currentBug]);
				damg = bugPrevHealth - players[currentBug].get_health();

				////////* print game's current status *////////
				switch (players[currentShoe].get_currentWeapon()) {
					case 0:						
						System.out.println(players[currentShoe].get_name() + "[t" + players[currentShoe].get_team() + "]" + " cut " + players[currentBug].get_name() + "[t" + players[currentBug].get_team() + "]" + " with " + damg + " damage");
						if (!(players[currentBug].isAlive()))
							System.out.println(players[currentBug].get_name() + " killed");
						break;
					case 1:					
						System.out.println(players[currentShoe].get_name() + "[t" + players[currentShoe].get_team() + "]" + " shot " + players[currentBug].get_name() + "[t" + players[currentBug].get_team() + "]" + " with " + damg + " damage");
						if (!(players[currentBug].isAlive()))
							System.out.println(players[currentBug].get_name() + " killed");
						break;
					case 2:						
						System.out.println(players[currentShoe].get_name() + "[t" + players[currentShoe].get_team() + "]" + " shot " + players[currentBug].get_name() + "[t" + players[currentBug].get_team() + "]" + " with " + damg + " damage");
						if (!(players[currentBug].isAlive()))
							System.out.println(players[currentBug].get_name() + " killed");
						break;
					default:						
						System.out.println(players[currentShoe].get_name() + "[t" + players[currentShoe].get_team() + "]" + " fragged " + players[currentBug].get_name() + "[t" + players[currentBug].get_team() + "]" + " with " + damg + " damage");
						if (!(players[currentBug].isAlive()))
							System.out.println(players[currentBug].get_name() + " killed");
						break;
				}

				////////* change the victim's team status, if the victim dies or the overall players' counter, if there is only one team  *////////
				if (team0 && team1) {
					if (!(players[currentBug].isAlive())) {
						players[currentShoe].set_kills(players[currentShoe].get_kills() + 1);
						players[currentBug].set_deaths(players[currentBug].get_deaths() + 1);
						if (players[currentBug].get_team() == 0)
							team0stat--;
						else
							team1stat--;
					}
				}
				else {
					if (!(players[currentBug].isAlive())) {
						players[currentShoe].set_kills(players[currentShoe].get_kills() + 1);
						players[currentBug].set_deaths(players[currentBug].get_deaths() + 1);
						playersStat--;
					}
				}
			}
			
			////////* check, if it's not time to end the game, based on teams' statuses or overall players' counter *////////
			if (team0 && team1) {
				if (team0stat == 0 || team1stat == 0)
					end = true;
			}
			else if (playersStat == 1)
				end = true;				
		}

		////////* print final results *////////
		System.out.println("=========================================================================");
		if (team0 && team1) {
			if (team0stat > 0)
				System.out.println("Team 0 won.");
			else if (team1stat > 0)
				System.out.println("Team 1 won.");
			else
				System.out.println("Both teams are even. Nobody won.");
		}
		else {
			boolean survivor = false;
			for (i = 0; i < (gamers - 1); i++)
				if (players[i].isAlive()) {
					System.out.println(players[i].get_name() + " won.");
					survivor = true;
				}
			if (!survivor)
				System.out.println("All players are dead. Nobody won.");
				
		}
			
		System.out.println("Round is over. Will write results in stats.txt");
		
		////////* generate final statistics string and save it into stats.txt *////////
		String head = "Name\t\tKills\t\tDeaths\t\tWeap0\t\tWeap1\t\tWeap2\t\tWeap3\t\tHealth\t\tcWeap\t\tTeam";
		String tofile = head;
		for (i = 0; i < (gamers - 1); i++)
			tofile += "\n" + players[i].toString();
		save_stats("stats.txt", tofile);
	}
}
