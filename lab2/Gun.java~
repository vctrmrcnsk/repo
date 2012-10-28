package lab2;

import java.io.*;
import java.util.*;

class Gun extends Firearm {
	int maxBulletsCount, maxBulletsCountInMagazine, currentBulletsCount, currentBulletsCountInMagazine;

	Gun() throws IOException {
		super();
		boolean x;
		System.out.print("Maximum number of bullets that can be carried: ");
		do {
			if (!(x = set_maxBulletsCount(KBInput.readInt())))
				System.out.print("Please, try again: ");
		}
		while (!x);
		System.out.print("Maximum number of bullets the magazine can hold: ");
		do {
			if (!(x = set_maxBulletsCountInMagazine(KBInput.readInt())))
				System.out.print("Please, try again: ");
		}
		while (!x);
		currentBulletsCount = 0;
		currentBulletsCountInMagazine = maxBulletsCountInMagazine;
		/* System.out.println("The price for a set of ammo for this weapon, $: ");
		do {
			if (!(x = set_ammoSetPrice(KBInput.readInt())))
				System.out.print("Please, try again: ");
		}
		while (!x); */
	}

	Gun(float maxdmg, int mbc, int mbcim) throws IOException {
		super(maxdmg);
		boolean x;
		if (!(x = set_maxBulletsCount(mbc))) {
			System.out.println("Will set the default value of 30");
			maxBulletsCount = 30;
		}
		if (!(x = set_maxBulletsCountInMagazine(mbcim))) {
			System.out.println("Will set the default value of 10");
			maxBulletsCountInMagazine = 10;
		}
		currentBulletsCount = 0;
		currentBulletsCountInMagazine = maxBulletsCountInMagazine;
		/* if (!(x = set_ammoSetPrice(price))) {
			System.out.println("Will set the default value of 30");
			ammoSetPrice = 30;
		} */
	}

	public float use() { //implement cycle for automatic fire
		Random generator = new Random();
		float damage = generator.nextFloat();
		if (damage > destructivePower)
			damage = destructivePower;
		return damage;
	}

	public boolean addAmmo() {
		currentBulletsCount = maxBulletsCount;
		return true;
		/* boolean x;

		 //if (shooter.get_money() >= ammoSetPrice) {
		if (x = shooter.set_money(shooter.get_money() - ammoSetPrice, ammoSetPrice)) {
			currentBulletsCount = maxBulletsCount;
			//in Gamer will define the set_money method like public boolean set_money(int newmoney, int bill) {...}
			return true;
		}
		return false; */
	}

	public boolean decrementBulletsCount() {
		if (currentBulletsCountInMagazine > 0) {
			currentBulletsCountInMagazine--;
			return true;
		}
		else if (currentBulletsCount > 0) {
			if (currentBulletsCount > maxBulletsCountInMagazine) {
				currentBulletsCountInMagazine = maxBulletsCountInMagazine;
				currentBulletsCount -= maxBulletsCountInMagazine;
			}
			else {
				currentBulletsCountInMagazine = currentBulletsCount;
				currentBulletsCount = 0;
			}
			currentBulletsCountInMagazine--;
			return true;
		}
		return false;
	}

////////* get_* methods *////////
	public float get_maxdmg() {
		float maxdmg = super.get_maxdmg();
		return maxdmg;
	}

	public int get_maxBulletsCount() {
		return maxBulletsCount;
	}

	public int get_maxBulletsCountInMagazine() {
		return maxBulletsCountInMagazine;
	}

	public int get_currentBulletsCount() {
		return currentBulletsCount;
	}

	public int get_currentBulletsCountInMagazine() {
		return currentBulletsCountInMagazine;
	}

	/* public int get_ammoSetPrice() {
		return ammoSetPrice;
	} */

////////* set_* methods *////////
	public boolean set_maxdmg(float newmaxdmg) {
		boolean success = super.set_maxdmg(newmaxdmg);
		return success;
	}

	public boolean set_maxBulletsCount(int newMaxBulletsCount) {
		if (newMaxBulletsCount > 0) {
			maxBulletsCount = newMaxBulletsCount;
			return true;
		}
		else
			System.out.println("Maximum bullets count should be 1 or more!");
		return false;
	}

	public boolean set_maxBulletsCountInMagazine(int newMaxBulletsCountInMagazine) {
		if (newMaxBulletsCountInMagazine > 0) {
			maxBulletsCountInMagazine = newMaxBulletsCountInMagazine;
			return true;
		}
		else
			System.out.println("The magazine should hold a maximum of 1 or more bullets!");
		return false;
	}

	public boolean set_currentBulletsCount(int newCurrentBulletsCount) {
		if (newCurrentBulletsCount >= 0) {
			currentBulletsCount = newCurrentBulletsCount;
			return true;
		}
		else
			System.out.println("The current bullets count should be 0 or more!");
		return false;
	}

	public boolean set_currentBulletsCountInMagazine(int newCurrentBulletsCountInMagazine) {
		if (newCurrentBulletsCountInMagazine >= 0) {
			currentBulletsCountInMagazine = newCurrentBulletsCountInMagazine;
			return true;
		}
		else
			System.out.println("The current bullets count in magazine should be 0 or more!");
		return false;
	}

	/* public boolean set_ammoSetPrice(int newAmmoSetPrice) {
		if (newAmmoSetPrice >= 0) {
			ammoSetPrice = newAmmoSetPrice;
			return true;
		}
		else
			System.out.println("Ammo set price should be 0 or more!");
		return false;
	} */
}
