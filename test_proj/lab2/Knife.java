package lab2;

import java.io.*;
import java.util.*;

class Knife extends Weapon {
	final static float destructivePower = 0.9f;

	Knife() {
	}

	public float use() {
		Random generator = new Random();
		float damage = generator.nextFloat();
		if (damage > destructivePower)
			damage = destructivePower;
		return damage;
	}
}
