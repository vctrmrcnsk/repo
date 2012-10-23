package lab2;

import java.io.*;
import java.util.*;

class Gamer {
	String name;
////////* in main shall create a seprate array for each type of weapon (gun and explosive)
////////* and shall fill the arrays with all possible weapons
////////* from which the players will randomly select one into their own weapon array
	Weapon[] weapons;
	float health;
	static boolean friendlyFire;
	int currentWeapon;
	int team;
	int kills, deaths;
	public static int players, clones;

	boolean x;
	
	Gamer() {
		players++;
		System.out.print("Player's name: ");
		do {
			if (!(x = set_name(KBInput.readStr())))
				System.out.println("Please, try again.");
		}
		while (!x);
		weapons = new Weapon[4];
		health = 1.0f;
		System.out.print("Choose the player's current weapon (slot 0-3): ");
		do {
			if (!(x = set_currentWeapon(KBInput.readInt())))
				System.out.println("Please, try again.");
		}
		while (!x);
		System.out.print("Player is in team (0 or 1): ");
		do {
			if (!(x = set_team(KBInput.readInt())))
				System.out.println("Please, try again.");
		}
		while (!x);
		kills = 0;
	}
	
	/* Gamer(String name, float hp, boolean friendFire, int cWeapon, int team) {
	
	} */

	Gamer(Gamer clone) {
		players++;
		clones++;
		weapons = new Weapon[4]
		name = clone.name + "_clone_" + clones;
		for (int i = 0; i < 4; i++)
			weapons[i] = clone.weapons[i];
		health = clone.health;
		team = clone.team;
		kills = 0;
	}

	public boolean isAlive() {
		if (health > 0)
			return true;
		return false;
	}

	public boolean hit(Gamer victim) {
		if (team != victim.team) {
			Random generator = new Random();
			if (generator.nextInt(2) == 1)
				return true;
		}
		else if (friendlyFire) {
			Random generator = new Random();
			if (generator.nextInt(2) == 1)
				return true;
		}
		return false;
	}

	public void hurt(float injury) {
		if (injury < health)
			health -= injury;
		else {
			health = 0.0f;
			deaths++;
	}

	public void shoot(Gamer target) {
		if (isAlive()) {
			if (currentWeapon == 1 || currentWeapon == 2) {
				int firedBullets;
				Random generator = new Random();
				
				firedBullets = generator.nextInt(weapons[currentWeapon].currentBulletsCountInMagazine) + generator.nextInt(2);
				for (int i = 0; i < firedBullets; i++) {
					if (hit(target)) {
						target.hurt(weapons[currentWeapon].use());
						if (target.health == 0.0f)
							kills++;
					}
				weapons[currentWeapon].decrementBulletsCount();
				}
			}
			else if (currentWeapon == 3) {
				if (hit(target)) {
					target.hurt(weapons[currentWeapon].use());
				}
				weapons[currentWeapon].decrementGrenadesCount();
			}
			else {
				if (hit(target)) {
					target.hurt(weapons[currentWeapon].use());
				}
			}
		}
	}

	public String toString() {
		str = "";
		str += name + "\t";
		str += kills + "\t";
		str += deaths + "\t";
		/*str += " Knife: " + weapon[0].get_destructivePower() + " Gun1: " + weapon[1].get_destructivePower() + " Gun2: " + weapon[2].get_destructivePower() + " Grenades: " + weapon[3].get_destructivePower();*/
		str += weapons[0].get_destructivePower() + "\t" + weapons[1].get_destructivePower() + "\t" + weapons[2].get_destructivePower() + "\t" + weapons[3].get_destructivePower() + "\t";
		str += health + "\t";
		str += currentWeapon + "\t";
		str += team;
		return str;
	}

////////* get_* methods *////////
	public String get_name() {
		return name;		
	}

	public Weapon[] get_weapons() {
		return weapons;
	}

	public float get_health() {
		return health;
	}
	
	public boolean get_friendlyFire() {
		return friendlyFire;
	}

	public int get_currentWeapon () {
		return current_Weapon;
	}

	public int get_team() {
		return team;
	}

////////* set_* methods *////////
	public boolean set_name(String newname) {
		if (!(newname.isEmpty())) {
			name = newname;
			return true;
		}
		else
			System.out.println("Name should be at least one character!");
		return false;
	}

	public boolean set_weapons(Weapon[] newWeapons) {
		for (int i = 0; i < 4; i++)
			if (newWeapons[i] == null) {
				System.out.println("No weapon slot can be null!");
				return false;
			}
		for (int i = 0; i < 4; i++)
			weapons[i] = newWeapons[i];
		return true;
	}

	public boolean set_health(float newhealth) {
		if (newhealth >= 0.0f && newhealth <= 1.0f) {
			health = newhealth;
			return true;
		}
		else
			System.out.println("Health can be from 0.0 to 1.0 only!");
		return false;
	}
	
	public boolean set_friendlyFire(boolean newfriendlyFire) {
		friendlyFire = newfriendlyFire;
		return true;
	}

	public boolean set_currentWeapon(int newcurrentWeapon) {
		if (newcurrentWeapon >= 0 && newcurrentWeapon <= 3) {
			currentWeapon = newcurrentWeapon;
			return true;
		}
		else
			System.out.println("Current weapon can be slot 0-3 only!");
		return false;
	}

	public boolean set_team(int newteam) {
		if (newteam == 0 || newteam == 1) {
			team = newteam;
			return true;
		}
		else
			System.out.println("Team can be either 0 or 1 only!");
		return false;
	}
}



