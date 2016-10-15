/**
 * @author aasherknight
 * 
 * @desc A Pokemon that is participating in the contest
 */
package Pokemon;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

import skills.Skill;

import javax.swing.ImageIcon;

import Resources.Constants;

public class Pokemon
{
	protected String	nickname, name;
	//protected Item		held;
	protected Skill		move1, move2, move3, move4, LastUsed = null;
	
	//Goes from 0-5; shaken = 3
	private enum STARTLE {
				FINE,
				SHAKEN,
				STARTLED,
				OBLIVIOUS
		};
		
	public STARTLE startleMeter = STARTLE.FINE;
	
	//Condition
	protected int conditionMeter = 0;
	final protected int MAX_CONDITION = 3;
	
	/**
	 * @desc A flag for if a pokemon is able to go this turn
	 */
	private int cooldown;
	
	/**
	 * @desc Flag for a combo move, which doubles the appeal of a move
	 * 
	 * Will be added in another iteration
	 */
	//protected boolean hasJudgesAttention = false;
	
	private boolean		shiny;
	public ImageIcon	sprite		= new ImageIcon(Pokemon.class.getResource("/Resources/pokeBackSprite/Default/0.png"));
	public ImageIcon	backSprite	= new ImageIcon(Pokemon.class.getResource("/Resources/pokeBackSprite/Default/0.png"));


	public Pokemon(File poke) throws FileNotFoundException
	{
		/* species
		 * nickname
		 * shiny(y/n)
		 * item
		 * move1
		 * move2
		 * move3
		 * move4
		 */
		
		Scanner reader = new Scanner(poke);
		name = reader.nextLine();
		name.toLowerCase();
		nickname = reader.nextLine();
		String temp = reader.nextLine();

		if (temp.contains("n"))
			shiny = false;
		else
			shiny = true;
		
		spriteLookup(name);
		
		cooldown = 0;

		//Skip items until I decide to put them in
		temp = reader.nextLine();

		temp = reader.nextLine();
		move1 = Skill.skillLookup(temp);
		move1.attach(this);
		
		temp = reader.nextLine();
		move2 = Skill.skillLookup(temp);
		move2.attach(this);
		
		temp = reader.nextLine();
		move3 = Skill.skillLookup(temp);
		move3.attach(this);

		temp = reader.nextLine();
		move4 = Skill.skillLookup(temp);
		move4.attach(this);
	}

	private void spriteLookup(String name2)
	{
		for(int i = 0; i<=Constants.SPECIES.length; i++)
		{
			if(name.equalsIgnoreCase(Constants.SPECIES[i]))
			{
				if(shiny)
				{
					backSprite = new ImageIcon(Pokemon.class.getResource("/Resources/pokeBackSprite/Shiny/" + i + ".png"));
					sprite = new ImageIcon(Pokemon.class.getResource("/Resources/pokeSprite/Shiny/" + i + ".png"));
				}
				else
				{
					backSprite = new ImageIcon(Pokemon.class.getResource("/Resources/pokeBackSprite/Default/" + i + ".png"));
					sprite = new ImageIcon(Pokemon.class.getResource("/Resources/pokeSprite/Default/" + i + ".png"));
				}
				return;
			}
		}
	}

	public void useMove1()
	{
		if(startleMeter!=STARTLE.STARTLED)
			move1.use();
		LastUsed = move1;
	}
	
	public void useMove2()
	{
		if(startleMeter!=STARTLE.STARTLED)
			move2.use();
		LastUsed = move2;
	}
	
	public void useMove3()
	{
		if(startleMeter!=STARTLE.STARTLED)
			move3.use();
		LastUsed = move3;
	}
	
	public void useMove4()
	{
		if(startleMeter!=STARTLE.STARTLED)
			move4.use();
		LastUsed = move4;
	}
	
	public Skill GetLastMove()
	{
		return LastUsed;
	}

	/**
	 * @desc Runs an random number to determine if a pokemon is startled or not
	 * @return true if the pokemon is startled
	 * @return false if the pokemon is fine
	 */
	public boolean startle()
	{
		Random r = new Random();
		int rand;
		
		switch(startleMeter)
		{
		case FINE:
			rand = r.nextInt(5)+1;
			if(rand>=3)
			{
				startleMeter = STARTLE.STARTLED;
				return true;
			}
			break;
		case SHAKEN:
			rand = r.nextInt(3) + 1;
			if(rand>=2)
			{
				startleMeter = STARTLE.STARTLED;
				return true;
			}
			break;
		case STARTLED:
			return true;
		}
		
		return false;
	}
	
	public void setOblivious()
	{
		startleMeter = STARTLE.OBLIVIOUS;
	}
	
	public void setShaken()
	{
		startleMeter = STARTLE.SHAKEN;
	}
	
	public void newRound()
	{
		if(cooldown==0)
		{
			startleMeter = STARTLE.FINE;
		}
		else
		{
			startleMeter = STARTLE.STARTLED;
			cooldown --;
		}
	}
	
	public void setCooldown(int c)
	{
		cooldown = c;
	}
	
	public int getCondition()
	{
		return conditionMeter;
	}
	
	public void upCondition()
	{
		if(conditionMeter<3)
			conditionMeter++;
	}
	
	public void removeCondition()
	{
		conditionMeter=0;
	}
}
