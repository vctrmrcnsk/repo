import java.io.*;
import java.util.*;

class Motan 
{
/////////////////////// class fields ///////////////////////
	String cat_name;	//cat's name
	int poison_drops;	//number of stuff drops taken
	int direction[];	//trajectory directions array
	static int cats;	//number of cats created
	float meow_volume;	//cat's meow volume in dB
	int age;		//age of the cat in months
	float weight;		//weight of the cat in kgs
	boolean state;		//state of the cat: dead or alive
	public static int old_dirs[];	//saving the old directions array if setting a new number of stuff drops
	static int max;		//the maximum number of drops taken by a single cat
	
/////////////////////// class constructors /////////////////
	Motan() // default constructor
	{
		cats++;
		String str = "";
		BufferedReader container = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please give the new cat's name: ");
		try 
		{
			cat_name = container.readLine();
		}
		catch(Exception e) {};
		Integer intextr;
		do
		{
			System.out.print("number of poison drops taken: ");
			try 
			{
				str = container.readLine();
			}
			catch(Exception e) {};
			intextr = Integer.decode(str); 
			poison_drops = intextr.intValue();
		}
		while(poison_drops < 0);
		/*if (poison_drops < 0)
			poison_drops = 0;*/
		direction = new int[poison_drops];
		Random generator = new Random();
		for (int i = 0; i < poison_drops; i++)
			direction[i] = generator.nextInt(5);
		System.out.print("meow volume, dB: ");
		try 
		{
			str = container.readLine();
		}
		catch(Exception e) {};
		meow_volume = (Float.valueOf(str)).floatValue();
		if (meow_volume < 0.0 || meow_volume > 70.0)
			meow_volume = 40.0f;
		System.out.print("age, months: ");
		try 
		{
			str = container.readLine();
		}
		catch(Exception e) {};
		intextr = Integer.decode(str);
		age = intextr.intValue();
		if (age < 0)
			age = 1;
		else if (age > 240)
			age = 240;
		System.out.print("weight, kgs: ");
		try 
		{
			str = container.readLine();
		}
		catch(Exception e) {};
		weight = (Float.valueOf(str)).floatValue();
		if (weight < 0.01)
			weight = 0.1f;
		if (poison_drops/weight >= 10)
			state = false;
		else
			state = true;
		System.out.println("\nNew cat object created.\n\n");
	}

	Motan(int stuff_taken, int age, float kg) //constructor with 3 parameters
	{
		cats++;
		cat_name = String.format("cat%d", cats);
		this.poison_drops = stuff_taken;
		direction = new int[stuff_taken];
		Random generator = new Random();
		for (int i = 0; i < stuff_taken; i++)
			direction[i] = generator.nextInt(5);
		meow_volume = 40.0f;
		this.age = age;
		this.weight = kg;
		if (stuff_taken/kg >= 10)
			state = false;
		else
			state = true;
		System.out.println("\nNew cat object created.\n\n");
	}

	Motan(String cat_name, float volume) //another constructor with parameters
	{
		cats++;
		this.cat_name = cat_name;
		poison_drops = 0;
		direction = new int[poison_drops];
		Random generator = new Random();
		for (int i = 0; i < poison_drops; i++)
			direction[i] = generator.nextInt(5);
		this.meow_volume = volume;
		age = 0;
		weight = 0.1f;
		state = true;
		System.out.println("\nNew cat object created.\n\n");
	}

	Motan(Motan animal) //clone constructor
	{
		cats++;
		this.cat_name = animal.cat_name;
		this.poison_drops = animal.poison_drops;
		this.direction = new int[this.poison_drops];
		for (int i = 0; i < this.poison_drops; i++)
			this.direction[i] = animal.direction[i];
		this.meow_volume = animal.meow_volume;
		this.age = animal.age;
		this.weight = animal.weight;
		this.state = animal.state;
		System.out.println("\nNew cat object created.\n\n");
	}
	
	Motan(String filename) //file reading constructor
	{
		String str = null;
		String[] values;
		try 
		{
    			BufferedReader in = new BufferedReader(new FileReader(filename));
    			str = in.readLine();
   			in.close();
		}
		catch (IOException e)
		{
			System.out.println("File " + filename + " not found!\n");
			return;
		}
		if (str != null)
		{
			values = str.split(",");
		}
		else
		{
			System.out.println("File " + filename + " is empty!\n");
			return;
		}
		cats++;
		this.cat_name = values[0];
		Integer n = Integer.decode(values[1]);
		this.poison_drops = n.intValue();
		if (this.poison_drops < 0)
			this.poison_drops = 0;
		this.direction = new int[this.poison_drops];
		Random generator = new Random();
		for (int i = 0; i < poison_drops; i++)
			this.direction[i] = generator.nextInt(5);
		this.meow_volume = (Float.valueOf(values[2])).floatValue();
		if (this.meow_volume < 0.0 || this.meow_volume > 70.0)
			this.meow_volume = 40.0f;
		n = Integer.decode(values[3]);
		this.age = n.intValue();
		this.weight = (Float.valueOf(values[4])).floatValue();
		if (this.weight < 0.01)
			this.weight = 0.1f;
		if (this.poison_drops/this.weight >= 10)
			this.state = false;
		else
			this.state = true;
		System.out.println("\nNew cat object created.\n\n");
	}
		

///////////////////////// class methods (functions) ////////////////////////////

//the get class field methods//
	public String get_cat_name()
	{
		return cat_name;
	}
	public int get_poison_drops()
	{
		return poison_drops;
	}
	public int[] get_direction()
	{
		return direction;
	}
	public int get_cats()
	{
		return cats;
	}
	public float get_meow_volume()
	{
		return meow_volume;
	}
	public int get_age()
	{
		return age;
	}
	public float get_weight()
	{
		return weight;
	}
	public boolean get_state()
	{
		return state;
	}

//the set class field methods//
	public void set_cat_name(String name)
	{
		this.cat_name = name;
	}
	public void set_poison_drops(int drops)
	{
		if (drops >= 0)
		{
		old_dirs = new int[this.poison_drops];
		for (int i = 0; i < this.poison_drops; i++)
			old_dirs[i] = this.direction[i];
		this.poison_drops = drops;
		Random generator = new Random();
		for (int i = 0; i < this.poison_drops; i++)
			this.direction[i] = generator.nextInt(4);
		if (this.poison_drops/weight >= 10)
			state = false;
		else
			state = true;
		}
	}
	public void set_meow_volume(float volume)
	{
		if (volume >= 0.0f && volume <= 70.0f)
			meow_volume = volume;
	}
	public void set_age(int new_age)
	{
		if (new_age >= 0)
			age = new_age;
	}
	public void set_weight(float new_weight)
	{
		if (new_weight > 0)
			weight = new_weight;
	}
//print class fields//
	public void print_fields()
	{
		System.out.println("Cat name: " + cat_name);
		System.out.println("Drops taken: " + poison_drops);
		System.out.println("The cat usually meows at " + meow_volume + " dB volume");
		System.out.println("Age: " + age + " months");
		System.out.println("Weight: " + weight + " kilograms");
		System.out.println("==========================================================\n\n");
	}
//trajectory print//
	public void trajectory()
	{
		int cdrop = 0;
		System.out.println("The cat \"" + this.cat_name + "\" took the stuff and has now started to move...\nMovement:\n\n");
		for (int i = 0; i < poison_drops; i++)
		{
			if (cdrop >= 10)
			{
				System.out.println("zzzzz-zzzzz-zzzzz");
				cdrop = 0;
				i--;
			}
			else
			{
				switch (direction[i])
				{
					case 0: cdrop++;
						System.out.println("[Move " + i + "] UP");
						break;
					case 1: cdrop++;
						System.out.println("[Move " + i + "] DOWN");
						break;
					case 2: cdrop++;
						System.out.println("[Move " + i + "] LEFT");
						break;
					case 3: cdrop++;
						System.out.println("[Move " + i + "] RIGHT");
						break;
					default:cdrop++;
						System.out.println("[Move " + i + "] The cat is shaking in severe convulsions!");
						break;
				}
			}
			if (cdrop >= 10)
			{
				System.out.println("zzzzz-zzzzz-zzzzz");
				cdrop = 0;
			}
		}
		if (!state)
			System.out.println("Congratulations! You have poisoned your cat to death.\n You are now a cat murderer!!! Please, SUFFER!");
		System.out.println("/////////////////////////////////////////////////");
	}
//static method returning an integer, read from standard input//
	public static int readintnr()
	{
		String str = "";
		BufferedReader number_get = new BufferedReader(new InputStreamReader(System.in));
		try 
		{
			str = number_get.readLine();
		}
		catch(Exception e) {};
		Integer n = Integer.decode(str);
		int result = n.intValue();
		return result;
	}
//static method that determines the maximum 'poison_drops' value//
	public static void heaviest_drinker(Motan cat1, Motan cat2, Motan cat3, Motan[] cat_vect, int cat_nr, Motan cat4)
	{
		Motan.max = cat1.poison_drops;
		if (cat2.poison_drops > Motan.max)
			Motan.max = cat2.poison_drops;
		if (cat3.poison_drops > Motan.max)
			Motan.max = cat3.poison_drops;
		if (cat4.poison_drops > Motan.max)
			Motan.max = cat4.poison_drops;
		for (int i = 0; i < cat_nr; i++)
			if (cat_vect[i].poison_drops > Motan.max)
				Motan.max = cat_vect[i].poison_drops;
	}

//write object data to file method//
	public void save_cat(String filename)
	{
		try
		{
			String data = cat_name + "," + poison_drops + "," + meow_volume + "," + age + "," + weight;
			File file = new File(filename);
			if (!file.exists()) 
			{
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(data);
			bw.close();
		}
		catch (IOException e)
		{
			System.out.println("Failed to write to file " + filename);
		}
	}

	public static void main(String[] args)
	{
		int i, argc, filecount;
		int nrcats;
		int drops, months;
		int drops_total;
		float kgs, meow;
		String str = "";
		String name = "";
		//String previous, current;

		
//creating an object, using the constructor, which reads data from file//
		Motan Fileborn = new Motan(args[0]);
		if (Fileborn.cat_name != null)
		{
			Fileborn.print_fields();
			Fileborn.trajectory();
		}
		
		/*System.out.println("Cats so far: " + cats);

		System.out.println("argc: " + args.length);
		System.out.println(args[0]);*/

//creating an object with the default constructor//
		Motan Cyanide = new Motan();
		Cyanide.print_fields();
		Cyanide.trajectory();
		
///creating an object with the first parameter constructor//
		BufferedReader container = new BufferedReader(new InputStreamReader(System.in));
		do
		{
			System.out.print("\nPlease give the number of drops taken by the cat object Boss: ");
			drops = Motan.readintnr();
		}
		while(drops < 0);
		System.out.print("Age of the cat, months: ");
		months = Motan.readintnr();
		System.out.print("Weight of the cat, kgs: ");
		try 
		{
			str = container.readLine();
		}
		catch(Exception e) {};
		kgs = (Float.valueOf(str)).floatValue();
		Motan Boss = new Motan(drops, months, kgs); 
		Boss.print_fields();
		System.out.print("Give the Boss a decent name: ");
		try
		{
			str = container.readLine();
		}
		catch (Exception e) {};
		Boss.set_cat_name(str);
		Boss.trajectory();

//creating an object with the second parameter constructor//
		System.out.print("Please specify the name of the cat object Predator: ");
		try
		{
			name = container.readLine();
		}
		catch(Exception e) {};
		System.out.print("Predator meow volume is: ");
		try 
		{
			str = container.readLine();
		}
		catch(Exception e) {};
		meow = (Float.valueOf(str)).floatValue();
		Motan predator = new Motan(name, meow);
		predator.print_fields();
		predator.trajectory();

//creating an object using the clone constructor//
		Motan fourty_seven = new Motan(Cyanide);
		fourty_seven.print_fields();
		fourty_seven.trajectory();

//creating an array of objects using all constructors
		System.out.print("Give the number of cats to store in a cat array: ");
		nrcats = Motan.readintnr();
		if (nrcats < 4)
			nrcats = 4;
		Motan gang[] = new Motan[nrcats];
		for (i = 0; i < nrcats/4; i++)
		{
			gang[i] = new Motan();
			gang[i].print_fields();
			gang[i].trajectory();
		}
		int ind = i + (nrcats/4);
		for (; i < ind; i++)
		{
			gang[i] = new Motan(drops, months, kgs);
			gang[i].print_fields();
			gang[i].trajectory();
		}
		ind = i + (nrcats/4);
		for (; i < ind; i++)
		{
			gang[i] = new Motan(name, meow);
			gang[i].print_fields();
			gang[i].trajectory();
		}
		for (; i < nrcats; i++)
		{
			gang[i] = new Motan(predator);
			gang[i].print_fields();
			gang[i].trajectory();
		}

		drops_total = Fileborn.get_poison_drops() + Cyanide.get_poison_drops() + Boss.get_poison_drops() + predator.get_poison_drops() + fourty_seven.get_poison_drops();
		for (i = 0; i < nrcats; i++)
			drops_total += gang[i].get_poison_drops();
		System.out.println("The cats have taken a total of " + drops_total + " poison drops");
		Motan.heaviest_drinker(Cyanide, Boss, predator, gang, nrcats, Fileborn);
		System.out.println("\nThe heaviest drinker(s) with " + Motan.max + " drops taken is/are:");
		if (Cyanide.poison_drops == Motan.max)
			System.out.println("* " + Cyanide.cat_name);
		if (Boss.poison_drops == Motan.max)
			System.out.println("* " + Boss.cat_name);
		if (predator.poison_drops == Motan.max)
			System.out.println("* " + predator.cat_name);
		if (fourty_seven.poison_drops == Motan.max)
			System.out.println("* " + fourty_seven.cat_name);
		if (Fileborn.poison_drops == Motan.max)
			System.out.println("* " + Fileborn.cat_name);
		for (i = 0; i < nrcats; i++)
			if (gang[i].poison_drops == Motan.max)
				System.out.println("* " + gang[i].cat_name);
		System.out.println("\nTotal number of cats, given a drink: " + Motan.cats);
		
//saving objects into separate files//
		filecount = 0;
		filecount++;
		Fileborn.save_cat("cats/" + Fileborn.cat_name + "obj" + filecount + ".ihc");

		filecount++;
		Cyanide.save_cat("cats/" + Cyanide.cat_name + "obj" + filecount + ".ihc");

		filecount++;
		Boss.save_cat("cats/" + Boss.cat_name + "obj" + filecount + ".ihc");

		filecount++;
		predator.save_cat("cats/" + predator.cat_name + "obj" + filecount + ".ihc");
		
		filecount++;
		fourty_seven.save_cat("cats/" + fourty_seven.cat_name + "obj" + filecount + ".ihc");

		for (i = 0; i < nrcats; i++)
		{
			filecount++;
			gang[i].save_cat("cats/" + gang[i].cat_name + "obj" + filecount + ".ihc");
		}
		
		System.out.println("All objects saved to files");
	}
}		