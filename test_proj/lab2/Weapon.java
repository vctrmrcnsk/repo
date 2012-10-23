package lab2;

import java.io.*;
import java.util.*;

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

