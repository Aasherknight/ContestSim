/**
 * @author aasherknight
 * 
 * @desc These moves make the pokemon more easily startled, but provide a large amount of appeal 
 */
package skillTypes;

import skills.Skill;

public class Shaken extends Skill
{

	public Shaken(String n, int s)
	{
		super(n, s);
		appeal = 6;
	}

	@Override
	public void use()
	{
		user.setShaken();
		
		int a = appeal;
		
		if(this.equals(user.GetLastMove()))
			a -= 2;
		
		scoreboard.score[scoreboard.getPokeOrder(user)][scoreboard.getRound()] =
				a + scoreboard.ExcitementMeter(this.style) + user.getCondition();
	}
}
