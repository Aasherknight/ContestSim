/**
 * @author aasherknight
 * 
 * @desc Keeps track of the scores between the contestants and the rounds
 */
package Scoring;

import java.util.ArrayList;
import java.util.Random;

import Pokemon.Pokemon;

public class ScoreBoard
{
	//Is a singleton
	private static ScoreBoard scoreboard;
	private int contest_type;
	
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
	 */
	private enum EXCITEMENT {
		NONE,
		ONE,
		TWO,
		THREE,
		FOUR,
		EXCITED
	}
	
	private EXCITEMENT meter = EXCITEMENT.NONE;
	
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
	
	private ScoreBoard()
	{
		round = ROUND.ROUND_1;
		contest_type = 0;
		randomOrder = false;
		goesFirst = null;
		goesLast = null;
	}
	
	public static synchronized ScoreBoard getScoreBoard()
	{
		if(scoreboard==null)
			scoreboard = new ScoreBoard();
		return scoreboard;
	}
	
	public void addContestant(Pokemon contestant)
	{
		if(contestant!=null&&contestants.size()<4)
			contestants.add(contestant);
	}
	
	public void nextRound()
	{
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
		
		getOrder();
		
	}
	
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

	public Pokemon getPokemon(int loc)
	{
		return (Pokemon) contestants.get(loc);
	}
	
	public int getRound()
	{
		int r = 1;
		switch (round)
		{
		case ROUND_1:
			r = 1;
		case ROUND_2:
			r = 2;
		case ROUND_3:
			r = 3;
		case ROUND_4:
			r = 4;
		}
		
		return r;
	}
	
	public int getType()
	{
		return contest_type;
	}
	
	public int ExcitementMeter(int type)
	{
		switch(meter)
		{
		case NONE:
			if(type==contest_type)
			{
				meter = EXCITEMENT.ONE;
				return 1;
			}
			else
				return -1;
		case ONE:
			if(type==contest_type)
			{
				meter = EXCITEMENT.TWO;
				return 1;
			}
			else
			{
				meter = EXCITEMENT.NONE;
				return -1;
			}
		case TWO:
			if(type==contest_type)
			{
				meter = EXCITEMENT.THREE;
				return 1;
			}
			else
			{
				meter = EXCITEMENT.ONE;
				return -1;
			}
		case THREE:
			if(type==contest_type)
			{
				meter = EXCITEMENT.FOUR;
				return 1;
			}
			else
			{
				meter = EXCITEMENT.TWO;
				return -1;
			}
		case FOUR:
			if(type==contest_type)
			{
				meter = EXCITEMENT.EXCITED;
				return 1;
			}
			else
			{
				meter = EXCITEMENT.THREE;
				return -1;
			}
		case EXCITED:
			if(type==contest_type)
			{
				meter = EXCITEMENT.NONE;
				return 6;
			}
			else
			{
				meter = EXCITEMENT.FOUR;
				return -1;
			}
		}
		return  0;
	}

	public void goFirst(Pokemon poke)
	{
		goesFirst = poke;
	}
	
	public void goLast(Pokemon poke)
	{
		goesLast = poke;
	}
	
	public void randomizeOrder()
	{
		randomOrder = true;
	}
}
