/**
 * @author aasherknight
 * 
 * @desc Protects from any jam attempt for this round
 * #
 */
package skillTypes;

import skills.Skill;

public class Focused extends Skill
{

	public Focused(String n, int s)
	{
		super(n, s);
		appeal = 1;
	}

	@Override
	public void use()
	{
		user.setOblivious();
		
		super.use();
	}
}
