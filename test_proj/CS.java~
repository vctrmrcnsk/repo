package lab2;

import java.io.*;
import java.util.*;

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
	final float destructivePower;

	Weapon() {
		
/////////////////* add custom excepion handling here */////////////////
		
		do {
			destructivePower = KBInput.readFloat();
			if (destructivePower <= 0.0f || destructivePower >= 1.0f)
				System.out.println("Value should be greater than 0.0 and less than 1.0.\nPlease, try again...");
		}
		while (destructivePower <= 0.0f || destructivePower >= 1.0f);
	}

	Weapon(float power) {

/////////////////* add custom excepion handling here */////////////////

		if (power >= 0.0f && power < 1.0f)
			destructivePower = power;
		else
			destructivePower = 0.2f;
	}

	public final float get_destructivePower() {
		return destructivePower;
	}

	public final void set_destructivePower(newPower) {

/////////////////* add custom excepion handling here */////////////////

		if (newPower > 0.0f && newPower < 1.0f)
			destructivePower = newPower;
		else
			System.out.println("Invalid destructive power value! Nothing changed.");
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

	public void set_maxdmg(float newmaxdmg) {
		super.set_destructivePower(newmaxdmg);
	}

	public abstract void addAmmo();

	public abstract float use();
}

class Gun extends Firearm {
	int maxBulletsCount, maxBulletsCountInMagazine, currentBulletsCount; currentBulletsCountInMagazine, ammoSetPrice;

	Gun() {
		super();
		System.out.print("Maximum number of bullets that can be carried: ");
		maxBulletsCount = KBInput.readInt();
		System.out.print("Maximum number of bullets that can be stored in the magazine: ");
		maxBulletsCountInMagazine = KBInput.readInt();
		currentBulletsCount = 0;
		currentBulletsCountInMagazine = 0;
		ammoSetPrice = KBInput.readInt;
	}

	Gun(float maxdmg, int mbc, int mbcim, int price) {
		super(maxdmg);
		maxBulletsCount = mbc;
		maxBulletsCountInMagazine = mbcim;
		currentBulletsCount = 0;
		currentBulletsCountInMagazine = 0;
		ammoSetPrice = price;
	}

	public float use() {
		Random generator = new Random();
		float damage = (float)generator.nextDouble();
		if (damage > destructivePower)
			damage = destructivePower;
		return damage;
	}

	public void addAmmo(Gamer shooter) {
		if (shooter.money >= ammoSetPrice) {
			currentBulletsCount = maxBulletsCount;
			shooter.money -= ammoSetPrice;
		}
	}

	public boolean decrementBulletsCount() {
		if (currentBulletsCountInMagazine > 0) 
			currentBulletsCountInMagazine--;
		else if (currentBulletsCount > 0) {
			if (currentBulletsCount > maxBulletsCountInMagazine) {
				currentBulletsCountInMagazine = maxBulletsCountInMagazine;
				currentBulletsCount -= maxBulletsCountInMagazine;
			else {
				currentBulletsCountInMagazine = currentBulletsCount;
				currentBulletsCount = 0;
			}
			currentBulletsCountInMagazine--;
		}
	}
}

class ExplosiveWeapon extends Firearm {
	int maxGrenadesCount, currentGrenadesCount;
	
	ExplosiveWeapon() {

	}

	public float use() {

	}

	public void addAmmo() {

	}
}

class Knife extends Weapon
{
	Knife()
	{

	}

	public float use()
	{

	}

	finalize()
	{

	}
}

class Gamer
{
	String name;
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















