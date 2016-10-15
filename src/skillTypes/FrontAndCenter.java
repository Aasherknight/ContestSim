/**
 * @author aasherknight
 * 
 * @desc tries to startle the pokemon that went right before you 
 * #jjjj
 */
package skillTypes;

import scoring.Judge;
import skills.Skill;

public class FrontAndCenter extends Skill
{

	public FrontAndCenter(String n, int s)
	{
		super(n, s);
		appeal = 1;
	}
	
	@Override
	public void use()
	{		
		int order = scoreboard.getPokeOrder(user);
		
		if(order != 0)
		{
			int prevUserLoc = scoreboard.order[order-1];
			int round = scoreboard.getRound();
			
			if(scoreboard.getPokemon(prevUserLoc).startle());
				scoreboard.score[prevUserLoc][round] -= 4;

		}
		
		super.use();
	}

}
