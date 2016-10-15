/**
 * @author aasherknight
 * 
 * @desc Startles the POKeMON that has the JUDGE's attention
 * ##j
 */
package skillTypes;

import skills.Skill;

public class OneManShow extends Skill
{

	public OneManShow(String n, int s)
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
			
			if(scoreboard.getPokemon(UserLoc).hasJudgesAttention())
					if(scoreboard.getPokemon(UserLoc).startle())
						scoreboard.score[UserLoc][round]--;
			
			order--;
		}
		
		super.use();
	}

}
