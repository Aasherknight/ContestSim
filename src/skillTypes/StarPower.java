/**
 * @author aasherknight
 * 
 * @desc The appeal works well if the user's condition is good
 * 
 * 0   = #
 * *   = ###
 * **  = #####
 * *** = #######
 */
package skillTypes;

import skills.Skill;

public class StarPower extends Skill
{

	public StarPower(String n, int s)
	{
		super(n, s);
	}
	
	@Override
	public void use()
	{
		switch(user.getCondition())
		{
		case 0:
			appeal = 1;
			break;
		case 1:
			appeal = 3;
			break;
		case 2:
			appeal = 5;
			break;
		case 3:
			appeal = 7;
			break;
		}
		
		super.use();
	}

}
