/**
 * @author aasherknight
 * 
 * @desc Attempts to make all POKeMON after the user nervous
 * ##
 */

package skillTypes;

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
		int a = appeal;
		
		int order = scoreboard.getPokeOrder(user);
		
		if(order != 0)
		{
			int userLoc = scoreboard.order[order+1];
			
			while(userLoc<=3)
			{
				scoreboard.getPokemon(userLoc).startle();
				userLoc++;
			}

		}
		
		if(this.equals(user.GetLastMove()))
			a -= 2;
		
		scoreboard.score[scoreboard.getPokeOrder(user)][scoreboard.getRound()] =
				a + scoreboard.ExcitementMeter(this.style) + user.getCondition();

	}

}
