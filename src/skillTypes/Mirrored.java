/**
 * @author aasherknight
 * 
 * @desc Makes the appeal as good as those before it
 * causes you to gain additional 
 * appeal points based on the appeal points of all of the POKeMON who appealed
 * before yours.  Half of the POKeMON's appeal points, rounded down, are added to
 * yours, plus one more.
 */

package skillTypes;

import skills.Skill;

public class Mirrored extends Skill
{

	public Mirrored(String string, int s)
	{
		super(string, s);
	}
	
	@Override
	public void use()
	{
		int a = 0;
		
		int order = scoreboard.getPokeOrder(user);
		int count = 0;
		
		while(order != 0)
		{
			int prevUserLoc = scoreboard.order[order-1];
			int round = scoreboard.getRound();
			
			if(scoreboard.getPokemon(prevUserLoc).startle());
				a += scoreboard.score[prevUserLoc][round];
				
			order --;
			count++;
		}
		
		if(count!=0)
			a = (int)(a/ count);
		
		if(this.equals(user.GetLastMove()))
			a -= 2;
		
		scoreboard.score[scoreboard.getPokeOrder(user)][scoreboard.getRound()] =
				a + scoreboard.ExcitementMeter(this.style) + user.getCondition();
	}

}
