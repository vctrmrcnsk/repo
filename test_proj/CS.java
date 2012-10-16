abstract class Weapon
{
	float destructivePower;

	public abstract float use();
}

abstract class Firearm extends Weapon
{
	public abstract void addAmmo();
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
















