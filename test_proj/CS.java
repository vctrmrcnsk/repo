package lab2;

import java.io.*;
import java.util.*;

abstract class Weapon implements Damage {
	final float destructivePower;

	Weapon() {
		
/////////////////* add custom excepion handling here */////////////////
		
		do {
			destructivePower = readFloat();
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

	public float get_destructivePower() {
		return destructivePower;
	}

	public void set_destructivePower(newPower) {

/////////////////* add custom excepion handling here */////////////////

		if (newPower > 0.0f && newPower < 1.0f)
			destructivePower = newPower;
		else
			System.out.println("Invalid destructive power value! Nothing changed.");
	} 
			
	public abstract float use();
}

abstract class Firearm extends Weapon implements Damage {

	public final abstract void addAmmo();

	public abstract float use();
}

class Gun extends Firearm
{
	int maxBulletsCount, maxBulletsCountInMagazine, currentBulletsCount; currentBulletsCountInMagazine;

	Gun()
	{

	}

	public float use()
	{

	}

	public void addAmmo()
	{

	}

	public boolean decrementBulletsCount()
	{
	
	}

	finalize()
	{

	}
}

class ExplosiveWeapon extends Firearm
{
	int maxGrenadesCount, currentGrenadesCount;
	
	ExplosiveWeapon()
	{

	}

	public float use()
	{

	}

	public void addAmmo()
	{

	}

	finalize()
	{

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















