/**
 * @author aasherknight
 * 
 * @desc Protects from any jam attempt for this round
 * #
 */
package skillTypes;

import skills.Skill;

public class Repeatable extends Skill
{

	public Repeatable(String n, int s)
	{
		super(n,s);
		appeal = 1;
	}

	@Override
	public void use()
	{
		user.setOblivious();

		int a = appeal;
		
		scoreboard.score[scoreboard.getPokeOrder(user)][scoreboard.getRound()] =
				a + scoreboard.ExcitementMeter(this.style) + user.getCondition();
	}
}
