/**
 * @author aasherknight
 * 
 * @desc Works well if it's the same type as the one before
 */
package skillTypes;

import skills.Skill;

public class Samesies extends Skill
{

	public Samesies(String n, int s)
	{
		super(n, s);
	}

	@Override
	public void use()
	{
		appeal = 2;
		int order = scoreboard.getPokeOrder(user);
		
		if(order != 0)
		{
			int prevUserLoc = scoreboard.order[order-1];
			int round = scoreboard.getRound();
			
			if(scoreboard.getPokemon(prevUserLoc).GetLastMove().getStyle() == style)
				appeal = 6;
		}
		
		super.use();
	}
}
