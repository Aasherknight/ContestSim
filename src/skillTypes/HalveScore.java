/**
 * @author aasherknight
 * 
 * @desc Startles all pokemon that went before, and will cut their scores in half for that round 
 * ##j
 */
package skillTypes;

import scoring.Judge;
import skills.Skill;

public class HalveScore extends Skill
{

	public HalveScore(String n, int s)
	{
		super(n, s);
		appeal = 2;
	}
	
	@Override
	public void use()
	{
		int order = scoreboard.getPokeOrder(user);
		
		if(order!=0)
			order--;
		
		if(order >= 0)
		{
			int prevUserLoc = scoreboard.order[order];
			int round = scoreboard.getRound();
			
			while(prevUserLoc>0)
			{
				if(scoreboard.getPokemon(prevUserLoc).startle());
					scoreboard.score[prevUserLoc][round] = (int) ((scoreboard.score[prevUserLoc][round]/2) + .5);
				prevUserLoc--;
			}
		}
		
		super.use();


	}

}
