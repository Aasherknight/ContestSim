/**
 * @author aasherknight
 * 
 * @desc Startles all pokemon that went before, and will cut their scores in half for that round 
 * ##j
 */
package skillTypes;

import skills.Skill;

public class HalveScore extends Skill
{

	public HalveScore(String n, int s)
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
			int prevUserLoc = scoreboard.order[order-1];
			int round = scoreboard.getRound();
			
			while(prevUserLoc>0)
			{
				if(scoreboard.getPokemon(prevUserLoc).startle());
					scoreboard.score[prevUserLoc][round] -= 1;
				prevUserLoc--;
			}
		}
		
		if(this.equals(user.GetLastMove()))
			a -= 2;
		
		scoreboard.score[scoreboard.getPokeOrder(user)][scoreboard.getRound()] =
				a + scoreboard.ExcitementMeter(this.style) + user.getCondition();

	}

}
