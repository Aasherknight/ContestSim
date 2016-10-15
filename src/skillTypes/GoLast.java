/**
 * @author aasherknight
 * 
 * @desc The next appeal will be last
 * ###
 */
package skillTypes;

import skills.Skill;

public class GoLast extends Skill
{

	public GoLast(String n, int s)
	{
		super(n, s);
		appeal = 3;
	}
	
	@Override
	public void use()
	{
		scoreboard.goLast(user);
		super.use();
	}

}
