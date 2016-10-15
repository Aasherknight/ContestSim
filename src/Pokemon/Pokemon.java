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
	/**
	 * @desc The name of the species and the nickname of the pokemon if it has one
	 */
	protected String	nickname, name;
	
	/**
	 * @desc An Item the pokemon is holding
	 * 
	 * Will be added in a later implementation
	 */
	//protected Item		held;
	
	/**
	 * @desc The skills the pokemon is able to use to perform
	 */
	protected Skill		move1, move2, move3, move4, LastUsed = null;
	
	/**
	 * @desc Maintains the startle meter that can affect a pokemon's ability to perform
	 */
	private enum STARTLE {
				FINE,
				SHAKEN,
				STARTLED,
				OBLIVIOUS
		};
		
	private STARTLE startleMeter = STARTLE.FINE;
	
	/**
	 * @desc Maintains a pokemon's condition, which can increase a skill's point value
	 */
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
	protected boolean hasJudgesAttention = false;
	
	/**
	 * @desc A flag for if the pokemon is shiny or not
	 * @desc Stores the pokemons sprite and back spite
	 */
	private boolean		shiny;
	public ImageIcon	sprite		= new ImageIcon(Pokemon.class.getResource("/Resources/pokeBackSprite/Default/0.png"));
	public ImageIcon	backSprite	= new ImageIcon(Pokemon.class.getResource("/Resources/pokeBackSprite/Default/0.png"));


	/**
	 * @desc Creates a pokemon from a  file given
	 * @param The file being read
	 * @throws FileNotFoundException
	 */
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

	/**
	 * @desc Looks for the sprites from the name given
	 * @param n The name given to be searched for
	 */
	private void spriteLookup(String n)
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

	/**
	 * @desc Use moves from 1 to 4
	 */
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
	
	/**
	 * Retrieve information on what the last move used was
	 * @return The last move
	 */
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
	
	/**
	 * @desc Set the pokemon to be oblivious to any startle attempts
	 */
	public void setOblivious()
	{
		startleMeter = STARTLE.OBLIVIOUS;
	}
	
	/**
	 * @desc Set the pokemon to be shaken, making it more likely to be startled
	 */
	public void setShaken()
	{
		startleMeter = STARTLE.SHAKEN;
	}
	
	/**
	 * @desc Describes what happens to the pokemon on a new round
	 */
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
	
	/**
	 * @desc Some skills leave the pokemon unable to perform for one or multiple rounds
	 * @param How many rounds the pokemon will be unable to perform
	 */
	public void setCooldown(int c)
	{
		cooldown = c;
	}
	
	/**
	 * @desc Retrieve the current condition of a pokemon
	 * @return The point value of the condition
	 */
	public int getCondition()
	{
		return conditionMeter;
	}
	
	/**
	 * @desc Ups a pokemon's condition if it is not a max condition
	 */
	public void upCondition()
	{
		if(conditionMeter<3)
			conditionMeter++;
	}
	
	/**
	 * @desc Drops a pokemon's condition if it is not 0
	 */
	public void downCondition()
	{
		if(conditionMeter!=0)
			conditionMeter--;
	}
	
	/**
	 * @desc Removes a pokemon's condition entirely, setting it to zero
	 */
	public void removeCondition()
	{
		conditionMeter=0;
	}

	/**
	 * @desc Flags that a pokemon has the judges attention
	 */
	public void gotJudgesAttention()
	{
		hasJudgesAttention = true;
	}
	
	/**
	 * @desc Flags that a pokemon has lost the judges attention
	 */
	public void lostJudgesAttention()
	{
		hasJudgesAttention = false;
	}

	/**
	 * desc Returns whether a pokemon has the judges attention
	 * @return Returns the value stored at the flag
	 */
	public boolean hasJudgesAttention()
	{
		return hasJudgesAttention;
	}
}
