/**
 * @author aasherknight
 * 
 * @desc Attempts to make all POKeMON after the user nervous
 * ##
 */

package skillTypes;

import scoring.Judge;
import skills.Skill;

public class Rattler extends Skill
{

	public Rattler(String n, int s)
	{
		super(n, s);
		appeal = 2;
	}
	
	@Override
	public void use()
	{
		int order = scoreboard.getPokeOrder(user);
		
		if(order!=3)
			order++;
		
		if(order <= 3)
		{
			int userLoc = scoreboard.order[order];
			
			while(userLoc<=3)
			{
				scoreboard.getPokemon(userLoc).startle();
				userLoc++;
			}

		}
		
		super.use();
	}

}
