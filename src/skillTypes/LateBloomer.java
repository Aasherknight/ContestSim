/**
 * @desc The appeal works better the later it is performed, in order of performance
 * #
 * ##
 * ####
 * ######
 */
package skillTypes;

import skills.Skill;

public class LateBloomer extends Skill
{

	public LateBloomer(String n, int s)
	{
		super(n, s);
	}
	
	@Override 
	public void use()
	{
		switch(scoreboard.getPokeOrder(user))
		{
		case 0: 
			appeal = 1;
			break;
		case 1: 
			appeal = 2;
			break;
		case 2:
			appeal = 4;
			break;
		case 3:
			appeal = 6;
			break;
		default:
			appeal = 0;
			break;
		}
		
		super.use();
	}

}
