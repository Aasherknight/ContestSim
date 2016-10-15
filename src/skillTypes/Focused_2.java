package skillTypes;

import skills.Skill;

public class Focused_2 extends Skill
{

	public Focused_2(String n, int s)
	{
		super(n, s);
		appeal = 2;
	}
	
	@Override
	public void use()
	{
		user.setOblivious();
		
		super.use();
	}

}
