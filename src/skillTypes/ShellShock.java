/**
 * @author aasherknight
 * 
 * @desc Startles the POKeMON that appealed before the user
 * ##jjj
 */
package skillTypes;

import skills.Skill;

public class ShellShock extends Skill
{

	public ShellShock(String n, int s)
	{
		super(n, s);
		appeal = 2;
	}

	@Override
	public void use()
	{		
		int order = scoreboard.getPokeOrder(user);
		
		if(order != 0)
		{
			int prevUserLoc = scoreboard.order[order-1];
			int round = scoreboard.getRound();
			
			if(scoreboard.getPokemon(prevUserLoc).startle());
				scoreboard.score[prevUserLoc][round] -= 3;

		}
		
		super.use();
	}
	
}
