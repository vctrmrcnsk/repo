package lab2;

import java.io.*;
import java.util.*;

class ExplosiveWeapon extends Firearm {
	int maxGrenadesCount, currentGrenadesCount;//, ammoSetPrice;
	
	ExplosiveWeapon() throws IOException {
		super();
		
		boolean x;
		System.out.print("Maximum number of grenades that can be carried: ");
		do {
			if (!(x = set_maxGrenadesCount(KBInput.readInt())))
				System.out.print("Please, try again: ");
		}
		while (!x);
		currentGrenadesCount = 1;
		/* System.out.println("The price for a set of these grenades, $: ");
		do {
			if (!(x = set_ammoSetPrice(KBInput.readInt())))
				System.out.print("Please, try again: ");
		}
		while (!x); */
	}

	ExplosiveWeapon(float power, int mgc) throws IOException {
		super(power);
		
		boolean x;
		if (!(x = set_maxGrenadesCount(mgc))) {
			System.out.println("Will set the default value of 2");
			maxGrenadesCount = 2;
		}
		currentGrenadesCount = 1;
		/* if (!(x = set_ammoSetPrice(price))) {
			System.out.println("Will set the default value of 100");
			ammoSetPrice = 100;
		} */
	}

	public float use() {
		Random generator = new Random();
		float damage = generator.nextFloat();
		if (damage > destructivePower)
			damage = destructivePower;
		return damage;
	}

	public boolean addAmmo() {
		currentGrenadesCount = maxGrenadesCount;
		return true;
		/* boolean x;

		 if (x = shooter.set_money(shooter.get_money() - ammoSetPrice, ammoSetPrice)) {
			currentGrenadesCount = maxGrenadesCount;
			return true;
		}
		return false; */
	}

	public boolean decrementGrenadesCount() {
		if (currentGrenadesCount > 0) {
			currentGrenadesCount--;
			return true;
		}
		else {
			addAmmo();
			return true;
		}
		//return false;
	}

////////* get_* methods *////////
	public float get_maxdmg() {
		float maxdmg = super.get_maxdmg();
		return maxdmg;
	}

	public int get_maxGrenadesCount() {
		return maxGrenadesCount;
	}

	public int get_currentGrenadesCount() {
		return currentGrenadesCount;
	}

	/* public int get_AmmoSetPrice() {
		return ammoSetPrice;
	} */

////////* set_* methods *////////
	public boolean set_maxdmg(float newmaxdmg) {
		boolean success = super.set_maxdmg(newmaxdmg);
		return success;
	}

	public boolean set_maxGrenadesCount(int newMaxGrenadesCount) {
		if (newMaxGrenadesCount > 0) {
			maxGrenadesCount = newMaxGrenadesCount;
			return true;
		}
		else
			System.out.println("Maximum grenades count should be 1 or more!");
		return false;
	}

	public boolean set_currentGrenadesCount(int newCurrentGrenadesCount) {
		if (newCurrentGrenadesCount >= 0) {
			currentGrenadesCount = newCurrentGrenadesCount;
			return true;
		}
		else
			System.out.println("Current grenades count should be 0 or more!");
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
