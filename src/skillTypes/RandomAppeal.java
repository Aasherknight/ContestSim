/**
 * @author aasherknight
 * 
 * @desc The appeal's quality is random, can be any of the below
 * #
 * ##
 * ####
 * ########
 */
package skillTypes;

import java.util.Random;

import skills.Skill;

public class RandomAppeal extends Skill
{

	public RandomAppeal(String n, int s)
	{
		super(n, s);
	}

	@Override
	public void use()
	{
		Random rand = new Random();
		int r = rand.nextInt(3)+1;
		
		switch(r)
		{
		case 1:
			appeal = 8;
			break;
		case 2:
			appeal = 4;
			break;
		case 3:
			appeal = 2;
			break;
		default:
			appeal = 1;
			break;	
		}
		
		super.use();
	}
}
