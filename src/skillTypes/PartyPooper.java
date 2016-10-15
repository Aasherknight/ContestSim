/**
 * @author aasherknight
 * 
 * @desc Temporarily stops the crowd from growing excited
 * ###
 */

package skillTypes;

import skills.Skill;

public class PartyPooper extends Skill
{

	public PartyPooper(String n, int s)
	{
		super(n, s);
		appeal = 3;
	}
	
	@Override
	public void use()
	{
		scoreboard.KillExcitement();
		super.use();
	}

}
