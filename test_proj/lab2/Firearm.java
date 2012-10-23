package lab2;

import java.io.*;
import java.util.*;

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
