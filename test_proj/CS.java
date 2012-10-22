package lab2;

import java.io.*;
import java.util.*;

////////* Class for basic type keyboard input automation *////////
public class KBInput {

	////////////////* input from keyboard methods *////////////////
	////////////////* HUGE exception handling modifications HERE!!! *////////////////

	public static int readInt() throws IOException
	{
		/* String str = "";
		BufferedReader value = new BufferedReader(new InputStreamReader(System.in));
		str = value.readLine(); */

		String str = KBInput.readStr();
		Integer n = Integer.decode(str);
		int result = n.intValue();
		return result;
	}

	public static float readFloat() throws IOException
	{
		/* String str = "";
		BufferedReader value = new BufferedReader(new InputStreamReader(System.in));
		str = value.readLine(); */

		String str = KBInput.readStr();
		float result = (Float.valueOf(str)).floatValue();
		return result;
	}

	public static double readDouble() throws IOException
	{
		String str = KBInput.readStr();
		double result = (Double.valueOf(str)).doubleValue();
		return result;
	}

	public static String readStr() {
		String str = "";
		boolean x;

		do {
			x = false;
			try {
				BufferedReader value = new BufferedReader(new InputStreamReader(System.in));
				str = value.readLine();
			}
			catch (IOException e) {
				x = true;
				System.out.println("Could not read from input! Try again.");
			}
		}
		while (x);
		return str;
	}
}
		
abstract class Weapon implements Damage {
	float destructivePower;

	Weapon() {
		
/////////////////* add custom excepion handling here */////////////////
		boolean x;
		System.out.print("Give the weapon's destructive power: ");
		do {
			if (!(x = set_destructivePower(KBInput.readFloat())))
				System.out.print("Please, try again: ");
		}
		while (!x);
	}

	Weapon(float power) {

/////////////////* add custom excepion handling here */////////////////
		boolean x;
		if (!(x = set_destructivePower(power))) {
			System.out.println("Will set the default value of 0.2");
			destructivePower = 0.2f;
		}
	}

	public final float get_destructivePower() {
		return destructivePower;
	}

	public final boolean set_destructivePower(float newPower) {

/////////////////* add custom excepion handling here */////////////////

		if (newPower > 0.0f && newPower < 1.0f) {
			destructivePower = newPower;
			return true;
		}
		else
			System.out.println("Destructive power should be greater than 0.0 and less than 1.0!");
		return false;
	} 

	public abstract float use();
}

abstract class Firearm extends Weapon implements Damage {

	Firearm() {
		super();
	}

	Firearm(float maxdmg) {
		super(maxdmg);
	}

	public float get_maxdmg() {
		float maxdmg = super.get_destructivePower();
		return maxdmg;
	}

	public boolean set_maxdmg(float newmaxdmg) {
		boolean success = super.set_destructivePower(newmaxdmg);
		return success;
	}

	public abstract void addAmmo();

	public abstract float use();
}

class Gun extends Firearm {
	int maxBulletsCount, maxBulletsCountInMagazine, currentBulletsCount; currentBulletsCountInMagazine, ammoSetPrice;

	Gun() {
		boolean x;

		super();
		System.out.print("Maximum number of bullets that can be carried: ");
		do {
			if (!(x = set_maxBulletsCount(KBIntput.readInt())))
				System.out.print("Please, try again: ");
		}
		while (!x);
		System.out.print("Maximum number of bullets the magazine can hold: ");
		do {
			if (!(x = set_maxBulletsCountInMagazine(KBIntput.readInt())))
				System.out.print("Please, try again: ");
		}
		while (!x);
		currentBulletsCount = 0;
		currentBulletsCountInMagazine = maxBulletsCountInMagazine;
		System.out.println("The price for a set of ammo for this weapon, $: ");
		do {
			if (!(x = set_ammoSetPrice(KBIntput.readInt())))
				System.out.print("Please, try again: ");
		}
		while (!x);
	}

	Gun(float maxdmg, int mbc, int mbcim, int price) {
		boolean x;

		super(maxdmg);
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
		if (!(x = set_ammoSetPrice(price))) {
			System.out.println("Will set the default value of 30");
			ammoSetPrice = 30;
		}
	}

	public float use() {
		Random generator = new Random();
		float damage = (float)generator.nextDouble();
		if (damage > destructivePower)
			damage = destructivePower;
		return damage;
	}

	public boolean addAmmo(Gamer shooter) {
		boolean x;

		//if (shooter.get_money() >= ammoSetPrice) {
		if (x = shooter.set_money(shooter.get_money() - ammoSetPrice, ammoSetPrice)) {
			currentBulletsCount = maxBulletsCount;
			//in Gamer will define the set_money method like public boolean set_money(int newmoney, int bill) {...}
			return true;
		}
		return false;
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

	public int get_ammoSetPrice() {
		return ammoSetPrice;
	}

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

	public boolean set_ammoSetPrice(int newAmmoSetPrice) {
		if (newAmmoSetPrice >= 0) {
			ammoSetPrice = newAmmoSetPrice;
			return true;
		}
		else
			System.out.println("Ammo set price should be 0 or more!");
		return false;
	}
}
class ExplosiveWeapon extends Firearm {
	int maxGrenadesCount, currentGrenadesCount, ammoSetPrice;
	
	ExplosiveWeapon() {
		boolean x;

		super();
		System.out.print("Maximum number of grenades that can be carried: ");
		do {
			if (!(x = set_maxGrenadesCount(KBIntput.readInt())))
				System.out.print("Please, try again: ");
		}
		while (!x);
		currentGrenadesCount = 0;
		System.out.println("The price for a set of these grenades, $: ");
		do {
			if (!(x = set_ammoSetPrice(KBIntput.readInt())))
				System.out.print("Please, try again: ");
		}
		while (!x);
	}

	ExplosiveWeapon(float power, int mgc, int price) {
		boolean x;

		super(power);
		if (!(x = set_maxGrenadesCount(mgc))) {
			System.out.println("Will set the default value of 2");
			maxGrenadesCount = 2;
		}
		currentGrenadesCount = 0;
		if (!(x = set_ammoSetPrice(price))) {
			System.out.println("Will set the default value of 100");
			ammoSetPrice = 100;
		}
	}

	public float use() {
		Random generator = new Random();
		float damage = (float)generator.nextDouble();
		if (damage > destructivePower)
			damage = destructivePower;
		return damage;
	}

	public boolean addAmmo() {
		boolean x;

		if (x = shooter.set_money(shooter.get_money() - ammoSetPrice, ammoSetPrice)) {
			currentGrenadesCount = maxGrenadesCount;
			return true;
		}
		return false;
	}

	public boolean decrementGrenadesCount() {
		if (currentGrenadesCount > 0) {
			currentGrenadesCount--;
			return true;
		}
		return false;
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

	public int get_AmmoSetPrice() {
		return ammoSetPrice;
	}

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

	public boolean set_ammoSetPrice(int newAmmoSetPrice) {
		if (newAmmoSetPrice >= 0) {
			ammoSetPrice = newAmmoSetPrice;
			return true;
		}
		else
			System.out.println("Ammo set price should be 0 or more!");
		return false;
	}
}

class Knife extends Weapon {
	final static float destructivePower = 0.9f;

	Knife() {
	}

	public float use() {
		Random generator = new Random();
		float damage = (float)generator.nextDouble();
		if (damage > destructivePower)
			damage = destructivePower;
		return damage;
	}
}

class Gamer
{
	String name;
////////* in main shall create a seprate array for each type of weapon (gun and explosive)
////////* and shall fill the arrays with all possible weapons
////////* from which the players will randomly select one into their own weapon array
	Weapon weapons[] = new Weapon[4];
	float health;
	boolean friendlyFire;
	int currentWeapon;
	int team;
	
	Gamer()
	{

	}

	public void boolean isAlive()
	{

	}

	public boolean hit(Gamer victim)
	{

	}

	public void hurt(float injury)
	{

	}

	public void shoot(Gamer target)
	{

	}

	public String toString()
	{

	}

	finalize()
	{

	}
}

class Battle
{
	public static void main(String[] args)
	{

	}
}

Interface Damage
{
	public float use();
}















