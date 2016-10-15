/**
 * @author aasherknight
 * 
 * @desc Able to be used multiple times in a row
 * ###
 */
package skillTypes;

import scoring.Judge;
import skills.Skill;

public class Repeatable extends Skill
{

	public Repeatable(String n, int s)
	{
		super(n,s);
		appeal = 3;
	}

	@Override
	public void use()
	{
		user.setOblivious();

		int a = appeal;
		
		int multiplier = 1;
		
		if(Judge.getJudge().isCombo())
		{
			if(user.hasJudgesAttention())
				multiplier = 2;
			else
				user.gotJudgesAttention();
		}
		else
			if(user.hasJudgesAttention())
				user.lostJudgesAttention();
		
		scoreboard.score[scoreboard.getPokeOrder(user)][scoreboard.getRound()] =
				(a + scoreboard.ExcitementMeter(this.style) + user.getCondition()) * multiplier;
	}
}
