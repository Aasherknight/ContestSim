/**
 * @author aasherknight
 * 
 * @desc The next appeal will be first
 */
package skillTypes;

import skills.Skill;

public class GoFirst extends Skill
{

	public GoFirst(String n, int s)
	{
		super(n, s);
		appeal = 3;
	}

	@Override
	public void use()
	{
		scoreboard.goFirst(user);
		super.use();
	}
}
