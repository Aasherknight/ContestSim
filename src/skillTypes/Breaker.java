/**
 * @author aasherknight
 * 
 * @desc Shifts the JUDGE's attention from others, cancels Combo Standby status for all
 * POKeMON that moved before you
 */
package skillTypes;

import scoring.Judge;
import skills.Skill;

public class Breaker extends Skill
{

	public Breaker(String n, int s)
	{
		super(n, s);
		appeal = 3;
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
			
			if(scoreboard.getPokemon(UserLoc).hasJudgesAttention())
			{
				scoreboard.getPokemon(UserLoc).lostJudgesAttention();
				Judge.getJudge().getAttention(null);
			}
			
			order--;
		}
		
		super.use();
	}

}
