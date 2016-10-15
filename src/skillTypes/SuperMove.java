/**
 * @author aasherknight
 * 
 * @desc Jams the others, and misses one turn of appeals
 * ####jjjj
 */
package skillTypes;

import skills.Skill;

public class SuperMove extends Skill
{

	public SuperMove(String n, int s)
	{
		super(n,s);
		appeal = 4;
	}

	@Override
	public void use()
	{
		int a = appeal;
		
		int order = 3;
		
		while(order>=0)
		{
			int pokeLoc = scoreboard.order[order];
			int round = scoreboard.getRound();
			
			if(!scoreboard.getPokemon(pokeLoc).equals(user))
			{
				if(scoreboard.getPokemon(pokeLoc).startle());
					scoreboard.score[pokeLoc][round] -= 4;
			}
			
			order--;
		}
		
		user.setCooldown(1);
		
		if(this.equals(user.GetLastMove()))
			a -= 2;
		
		scoreboard.score[scoreboard.getPokeOrder(user)][scoreboard.getRound()] =
				a + scoreboard.ExcitementMeter(this.style) + user.getCondition();

	}
}
