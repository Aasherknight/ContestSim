/**
 * @author aasherknight
 * 
 * @desc The appeal works great if performed last, 6 for last, 2 for other
 */
package skillTypes;

import skills.Skill;

public class MeLast extends Skill
{

	public MeLast(String n, int s)
	{
		super(n, s);
	}
	
	@Override
	public void use()
	{
		if(scoreboard.getPokeOrder(user)==3)
			appeal = 6;
		else
			appeal = 2;
		
		super.use();
	}

}
