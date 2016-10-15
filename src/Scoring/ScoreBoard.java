/**
 * @author aasherknight
 * 
 * @desc Keeps track of the scores between the contestants and the rounds
 */
package scoring;

import java.util.ArrayList;
import java.util.Random;

import Pokemon.Pokemon;

public class ScoreBoard
{
	/**
	 * @desc There can only be one scoreboard in the game
	 * @desc The type of contest the game shall be
	 */
	private static ScoreBoard scoreboard;
	private int contest_type;
	
	/**
	 * @desc A set of flags for when order is determined
	 */
	private boolean randomOrder;
	private Pokemon goesFirst;
	private Pokemon goesLast;
	
	protected static ArrayList contestants = new ArrayList<Pokemon>();
	
	/**
	 * @desc manages the rounds
	 */
	private enum ROUND {
		ROUND_1,
		ROUND_2,
		ROUND_3,
		ROUND_4
	}
	
	protected ROUND round;
	
	/**
	 * @desc Manages the excitement meter
	 * @desc A flag for if the excitement meter can move or not
	 */
	private enum EXCITEMENT {
		NONE,
		ONE,
		TWO,
		THREE,
		FOUR,
		EXCITED
	}
	private EXCITEMENT E_meter = EXCITEMENT.NONE;
	boolean frozenExcitement;
	
	/**
	 * @desc manages the scores of each of the contestant's scores in the 4 rounds
	 * 
	 * [user][round]
	 */
	public int score[][] = {
			{0,0,0,0},
			{0,0,0,0},
			{0,0,0,0},
			{0,0,0,0}
	};
	
	/**
	 * @desc each contestant will be given a number that corresponds to them
	 */
	public int order[] = {0,1,2,3};
	
	/**
	 * @desc A private constructor to allow for a singleton
	 */
	private ScoreBoard()
	{
		round = ROUND.ROUND_1;
		contest_type = 0;
		randomOrder = false;
		goesFirst = null;
		goesLast = null;
	}
	
	/**
	 * @desc Allows for access to the scoreboard without creating a new one
	 * @return The only instance of the scoreboard
	 */
	public static synchronized ScoreBoard getScoreBoard()
	{
		if(scoreboard==null)
			scoreboard = new ScoreBoard();
		return scoreboard;
	}

	/**
	 * @desc Part of initialization of the game, adds a contestant to the scoreboard
	 * @param contestant
	 */
	public void addContestant(Pokemon contestant)
	{
		if(contestant!=null&&contestants.size()<4)
			contestants.add(contestant);
	}
	
	/**
	 * @desc Moves the game into the next round, and ends the game if round 4 is ended
	 */
	public void nextRound()
	{
		getOrder();
		frozenExcitement = false;
		
		switch (round)
		{
		case ROUND_1:
			round = ROUND.ROUND_2;
			break;
		case ROUND_2:
			round = ROUND.ROUND_3;
			break;
		case ROUND_3:
			round = ROUND.ROUND_4;
			break;
		case ROUND_4:
			//End the sim, tally scores
			break;
		}	
	}
	
	/**
	 * @desc Determines the order for the next round
	 */
	private void getOrder()
	{
		int p1 = score[0][getRound()];
		int p2 = score[1][getRound()];
		int p3 = score[2][getRound()];
		int p4 = score[3][getRound()];
		
		if(goesFirst!=null)
		{
			switch(getPokeOrder(goesFirst))
			{
			case 0:
				p1 = 100;
				break;
			case 1:
				p2 = 100;
				break;
			case 2:
				p3 = 100;
				break;
			case 3:
				p4 = 100;
			}
		}
		
		if(goesLast!=null)
		{
			switch(getPokeOrder(goesLast))
			{
			case 0:
				p1 = 100;
				break;
			case 1:
				p2 = 100;
				break;
			case 2:
				p3 = 100;
				break;
			case 3:
				p4 = 100;
			}
		}
		
		if(randomOrder)
		{
			Random rand = new Random();
			p1 = rand.nextInt(100);
			p2 = rand.nextInt(100);
			p3 = rand.nextInt(100);
			p4 = rand.nextInt(100);
		}
			
		int search[][] = {{p1,0}, {p2,1}, {p3,2}, {p4,3}};
		
		for(int i = 0; i<4; i++)
		{
			if(search[0][0]<search[1][0])
			{
				int temp = search[0][0];
				search[0][0] = search[1][0];
				search[1][0] = temp;
				temp = search[0][1];
				search[0][1] = search[1][1];
				search[1][1] = temp;
			}
			if(search[1][0]<search[2][0])
			{
				int temp = search[1][0];
				search[1][0] = search[2][0];
				search[2][0] = temp;
				temp = search[1][1];
				search[1][1] = search[2][1];
				search[2][1] = temp;
			}
			if(search[2][0]<search[3][0])
			{
				int temp = search[2][0];
				search[2][0] = search[3][0];
				search[3][0] = temp;
				temp = search[2][1];
				search[2][1] = search[3][1];
				search[3][1] = temp;
			}
		}
	
		order[0] = search[0][1];
		order[1] = search[1][1];
		order[2] = search[2][1];
		order[3] = search[3][1];
	}

	/**
	 * @desc Looks for a contestant in the contest, and if found returns their order in the current round
	 * @param contestant
	 * @return the position of the contestant given
	 */
	public int getPokeOrder(Pokemon contestant)
	{
		int pos = contestants.indexOf(contestant);
		
		for(int i = 0; i< order.length; i++)
		{
			if(order[i]==pos)
				return i;
		}
		
		return 0;
	}

	/**
	 * @desc Looks at the position of a contestant and returns the contestant
	 * @param Location to be searched
	 * @return The contestant from the specified location
	 */
	public Pokemon getPokemon(int loc)
	{
		return (Pokemon) contestants.get(loc);
	}
	
	/**
	 * @desc Returns the round that the game is currently in
	 * @return The round in integer form
	 */
	public int getRound()
	{
		int r = 1;
		switch (round)
		{
		case ROUND_1:
			r = 0;
		case ROUND_2:
			r = 1;
		case ROUND_3:
			r = 2;
		case ROUND_4:
			r = 3;
		}
		
		return r;
	}
	
	/**
	 * @desc Returns the type of contest is taking place
	 * @return The contest type
	 */
	public int getType()
	{
		return contest_type;
	}
	
	/**
	 * @desc Manages the Excitement meter, and returns a point value for a contestants move
	 * @param The type of move that had been used
	 * @return The point value for that move
	 */
	public int ExcitementMeter(int type)
	{
		if(!frozenExcitement)
			switch(E_meter)
			{
			case NONE:
				if(type==contest_type)
				{
					E_meter = EXCITEMENT.ONE;
					return 1;
				}
				else
					return -1;
			case ONE:
				if(type==contest_type)
				{
					E_meter = EXCITEMENT.TWO;
					return 1;
				}
				else
				{
					E_meter = EXCITEMENT.NONE;
					return -1;
				}
			case TWO:
				if(type==contest_type)
				{
					E_meter = EXCITEMENT.THREE;
					return 1;
				}
				else
				{
					E_meter = EXCITEMENT.ONE;
					return -1;
				}
			case THREE:
				if(type==contest_type)
				{
					E_meter = EXCITEMENT.FOUR;
					return 1;
				}
				else
				{
					E_meter = EXCITEMENT.TWO;
					return -1;
				}
			case FOUR:
				if(type==contest_type)
				{
					E_meter = EXCITEMENT.EXCITED; //play animation for this
					E_meter = EXCITEMENT.NONE;
					return 6;
				}
				else
				{
					E_meter = EXCITEMENT.THREE;
					return -1;
				}
			}
		return  0;
	}

	/**
	 * @desc Freezes the excitement meter until next round
	 */
	public void KillExcitement()
	{
		frozenExcitement = true;
	}
	
	/**
	 * @desc Flags a pokemon to go first in the next round
	 * @param Pokemon that wishes to go first
	 */
	public void goFirst(Pokemon poke)
	{
		goesFirst = poke;
	}
	
	/**
	 * @desc Flags a pokemon to go last in the next round
	 * @param Pokemon that wishes to go last
	 */
	public void goLast(Pokemon poke)
	{
		goesLast = poke;
	}
	
	/**
	 * @desc Flags that the order for the next round is to be randomized
	 */
	public void randomizeOrder()
	{
		randomOrder = true;
	}

	public int getExcitement()
	{
		switch(E_meter)
		{
		case NONE:
			return 0;
		case ONE:
			return 1;
		case TWO:
			return 2;
		case THREE:
			return 3;
		case FOUR:
			return 4;
		default:
			return 0;
		}
		
	}
}
