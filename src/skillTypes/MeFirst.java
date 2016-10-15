/**
 * @author aasherknight
 * 
 * @desc The appeal works great if performed first, 6 for first, 2 for other
 */
package skillTypes;

import skills.Skill;

public class MeFirst extends Skill
{

	public MeFirst(String n, int s)
	{
		super(n, s);
	}

	@Override
	public void use()
	{
		if(scoreboard.getPokeOrder(user)==0)
			appeal = 6;
		else
			appeal = 2;
		
		super.use();
	}
	
}
