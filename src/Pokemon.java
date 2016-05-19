import java.io.*;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class Pokemon
{
	String nickname, name;
	Item held;
	Skill move1, move2, move3, move4;
	boolean shiny;
	int score, order;
	ImageIcon sprite = new ImageIcon(Pokemon.class.getResource("/Resources/pokeBackSprite/Default/0.png"));
	
	public Pokemon(File poke) throws FileNotFoundException
	{
		Scanner reader = new Scanner(poke);
		name = reader.nextLine();
		nickname = reader.nextLine();
		String temp = reader.nextLine();
		
		if(temp.contains("n"))
			shiny = false;
		else
			shiny = true;
		
		temp = reader.nextLine();
		held = Item.itemLookup(temp);
		
		temp = reader.nextLine();
		move1 = Skill.skillLookup(temp);
		
		temp = reader.nextLine();
		move2 = Skill.skillLookup(temp);
		
		temp = reader.nextLine();
		move3 = Skill.skillLookup(temp);
		
		temp = reader.nextLine();
		move4 = Skill.skillLookup(temp);
	}
}
