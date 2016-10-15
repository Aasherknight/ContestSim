/**
 * @author aasherknight
 * 
 * @desc Does a default jam on pokemon that went before it
 * #jjj
 */
package skillTypes;

import scoring.Judge;
import skills.Skill;

public class Jammer extends Skill
{

	public Jammer(String n, int s)
	{
		super(n,s);
		appeal = 1;
	}

	@Override
	public void use()
	{		
		int order = scoreboard.getPokeOrder(user);
		
		if(order!=0)
			order--;
			
		while(order >= 0)
		{
			int prevUserLoc = scoreboard.order[order];
			int round = scoreboard.getRound();
			
			if(scoreboard.getPokemon(prevUserLoc).startle());
				scoreboard.score[prevUserLoc][round] -= 3;

			order--;
		}
		
		super.use();
	}
}

