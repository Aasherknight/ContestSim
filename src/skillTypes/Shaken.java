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
		
		super.use();
	}
}
