/**
 * @author aasherknight
 * 
 * @desc Startles POKeMON that made a same-type appeal
 * ##j
 */
package skillTypes;

import scoring.Judge;
import skills.Skill;

public class Highlander extends Skill
{

	public Highlander(String n, int s)
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
		
		while(order >= 0)
		{
			int UserLoc = scoreboard.order[order];
			int round = scoreboard.getRound();
			
			if(!scoreboard.getPokemon(UserLoc).equals(user)&&style==scoreboard.getPokemon(UserLoc).GetLastMove().getStyle())
					if(scoreboard.getPokemon(UserLoc).startle())
						scoreboard.score[UserLoc][round]--;
			
			order--;
		}
		
		super.use();
	}
}
