/**
 * @author aasherknight
 * 
 * @desc Moves that will ALWAYS excite the audience and gets either 1 or 6 depending on the applause meter
*/
package skillTypes;

import skills.Skill;

public class Friends extends Skill
{
	public Friends(String n, int s)
	{
		super(n, s);
		appeal = 0;
		style = scoreboard.getType();
	}
}
