/**
 * @author aasherknight
 * 
 * @desc gives high appeal, but user cannot move for the rest of the contest
 * ######## X
 */
package skillTypes;

import skills.Skill;

public class Detonation extends Skill
{

	public Detonation(String n, int s)
	{
		super(n, s);
		appeal = 8;
	}
	
	@Override
	public void use()
	{
		user.setCooldown(10);
		super.use();
	}

}
