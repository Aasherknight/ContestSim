/**
 * @author aasherknight
 * 
 * @desc The appeal works best the more the crowd is excited
 * If the Applause Meter is empty, you get one appeal
 * point; at two, three points.  At three points, you get four points, and if the
 * Applause Meter is at four, you get six.
 */
package skillTypes;

import skills.Skill;

public class RightTime extends Skill
{

	public RightTime(String n, int s)
	{
		super(n, s);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void use()
	{
		switch(scoreboard.getExcitement())
		{
		case 2:
			appeal = 3;
			break;
		case 3:
			appeal = 4;
			break;
		case 4:
			appeal = 6;
			break;
		default:
			appeal = 1;
		}
		super.use();
	}

}
