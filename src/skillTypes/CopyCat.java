/**
 * @author aasherknight
 * 
 * @desc Makes the appeal as good as the one before it
 */

package skillTypes;

import scoring.Judge;
import skills.Skill;

public class CopyCat extends Skill
{

	public CopyCat(String string, int s)
	{
		super(string, s);
		appeal = 0;
	}
	
	@Override
	public void use()
	{
		int order = scoreboard.getPokeOrder(user);
		if(order!=0)
		{
			int prevUserLoc = scoreboard.order[order-1];
			int round = scoreboard.getRound();
		
			appeal = scoreboard.score[prevUserLoc][round];
		}
		else
			appeal = 0;
		
		super.use();
	}

}
