/**
 * @author aasherknight
 * 
 * @desc Gives appeal based on who went before you
 * if they got less than 3, you get 6
 * if they get 3, you get 3
 * if they get more than 3, you get 0
*/
package skillTypes;

import skills.Skill;

public class CauseEffect extends Skill
{

	public CauseEffect(String n, int s)
	{
		super(n,s);
	}
	
	@Override
	public void use()
	{
		int a = 0;
		
		int order = scoreboard.getPokeOrder(user);
		
		if(order != 0)
		{
			int prevUserLoc = scoreboard.order[order-1];
			int round = scoreboard.getRound();
			
			int prevScore = scoreboard.score[prevUserLoc][round];
			
			if(prevScore<3)
				a = 6;
			else if(prevScore == 3)
				a = 3;
			else
				a = 0;
		}
		
		if(this.equals(user.GetLastMove()))
			a -= 2;
		
		scoreboard.score[scoreboard.getPokeOrder(user)][scoreboard.getRound()] =
				a + scoreboard.ExcitementMeter(this.style) + user.getCondition();
	}

}
