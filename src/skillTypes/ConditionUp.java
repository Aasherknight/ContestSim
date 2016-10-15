/**
 * @author aasherknight
 * 
 * @desc Ups the user's condition. Gives Stars
 * #
 */
package skillTypes;

import skills.Skill;

public class ConditionUp extends Skill
{

	public ConditionUp(String n, int s)
	{
		super(n, s);
		appeal = 1;
	}
	
	@Override
	public void use()
	{
		user.upCondition();
		super.use();
	}

}
