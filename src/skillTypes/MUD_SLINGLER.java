/**
 * @author aasherknight
 * 
 * @desc removes any stars the other pokemon might have
 * ###
 */
package skillTypes;

import scoring.Judge;
import skills.Skill;

public class MUD_SLINGLER extends Skill
{

	public MUD_SLINGLER(String n, int s)
	{
		super(n, s);
	}
	
	@Override
	public void use()
	{
		int order = scoreboard.getPokeOrder(user);
		
		if(order!=0)
			order--;
		
		while(order >= 0)
		{
			int UserLoc = scoreboard.order[order];
			int round = scoreboard.getRound();
			
			if(scoreboard.getPokemon(UserLoc).getCondition()!=0)
			{
				scoreboard.getPokemon(UserLoc).removeCondition();
			}
			
			order--;
		}
		
		super.use();
	}

}
