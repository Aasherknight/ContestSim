/**
 * @author aasherknight
 * 
 * @desc Makes the appeal as good as the one before it
 */

package skillTypes;

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
		int prevUserLoc = scoreboard.order[order-1];
		int round = scoreboard.getRound();
		
		int a = scoreboard.score[prevUserLoc][round];
		
		if(this.equals(user.GetLastMove()))
			a -= 2;
		
		scoreboard.score[scoreboard.getPokeOrder(user)][scoreboard.getRound()] =
				a + scoreboard.ExcitementMeter(this.style) + user.getCondition();

	}

}
