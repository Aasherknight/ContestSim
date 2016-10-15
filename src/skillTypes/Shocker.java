/**
 * @author aasherknight
 * 
 * @desc Startles all POKeMON that have done their appeals
 * ##jj
 */
package skillTypes;

import scoring.Judge;
import skills.Skill;

public class Shocker extends Skill
{

	public Shocker(String n, int s)
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
			int pokeLoc = scoreboard.order[order];
			int round = scoreboard.getRound();
			
			if(scoreboard.getPokemon(pokeLoc).startle())
				scoreboard.score[pokeLoc][round] -= 2;
				
			order--;
		}
		
		super.use();
	}
}
