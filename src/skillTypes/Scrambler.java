/**
 * @author aasherknight
 * 
 * @desc Scrambles the order for the next round
 * ###
 */

package skillTypes;

import skills.Skill;

public class Scrambler extends Skill
{

	public Scrambler(String string, int s)
	{
		super(string,s);
		appeal = 3;
	}
	
	@Override
	public void use()
	{
		scoreboard.randomizeOrder();
		super.use();
	}
}
