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

import scoring.Judge;
import skills.Skill;

public class Mirrored extends Skill
{

	public Mirrored(String string, int s)
	{
		super(string, s);
		appeal = 0;
	}
	
	@Override
	public void use()
	{
		appeal = 0;

		int order = scoreboard.getPokeOrder(user);
		int count = 0;
		
		if(order!=0)
			order--;
		
		while(order >= 0)
		{
			int prevUserLoc = scoreboard.order[order-1];
			int round = scoreboard.getRound();
			
			if(scoreboard.getPokemon(prevUserLoc).startle());
				appeal += scoreboard.score[prevUserLoc][round];
				
			order --;
			count++;
		}
		
		if(count!=0)
			appeal = (int)(appeal/ count);
		
		super.use();
	}

}
