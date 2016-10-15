/**
 * @author aasherknight
 * 
 * @desc The base shell of skills a pokemon may use during a contest
 */
package skills;

import Pokemon.Pokemon;
import Resources.Constants;
import Scoring.ScoreBoard;
import skillTypes.*;

public class Skill
{
	
	protected Pokemon user;
	protected ScoreBoard scoreboard;
	
	/**
	 * @desc The different types of skills available to a pokemon
	 */
	public static enum SKILL_TYPE {
			RAW_APPEAL,
			FRIENDS,
			CAUSE_EFFECT,
			SHAKEN,
			HALVE_SCORE,
			FRONT_AND_CENTER,
			JAMMER,
			FOCUSED,
			REPEATABLE,
			SUPER_MOVE,
			DETONATION,
			RATTLER,
			COPY_CAT,
			MIRRORED,
			SCRAMBLER,
			BREAKER,
			SHOCKER,
			HIGHLANDER,
			SHELL_SHOCK,
			ONE_MAN_SHOW,
			PARTY_POOPER,
			RANDOM_APPEAL,
			RIGHT_TIME,
			LATE_BLOOMER,
			ME_FIRST,
			ME_LAST,
			STAR_POWER,
			GO_FIRST,
			GO_LAST,
			CONDITION_UP,
			SAMESIES,
			MUD_SLINGER,
			STRUGGLE
	}
	
	protected SKILL_TYPE skillType;
	protected int style;
	protected int appeal;
	protected String name;
	
	public Skill(String n, int s)
	{
		name = n;
		appeal = 1;
		style = s;
		scoreboard = ScoreBoard.getScoreBoard();
	}
	
	/**
	 * @desc Provides a base use for all skills that can be then over rode
	 */
	public void use()
	{
		int a = appeal;
		
		if(this.equals(user.GetLastMove()))
			a -= 2;
		
		scoreboard.score[scoreboard.getPokeOrder(user)][scoreboard.getRound()] =
				a + scoreboard.ExcitementMeter(this.style) + user.getCondition();
	}
	
	public static Skill skillLookup(String n)
	{
		boolean found = false;
		
		while(!found)
		{
			SKILL_TYPE type = SKILL_TYPE.RAW_APPEAL;
			
			switch (type)
			{
			case RAW_APPEAL:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.RAW_APPEAL[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.RAW_APPEAL[s][nameLoc]))
						{
							return new RawAppeal(Constants.RAW_APPEAL[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.CAUSE_EFFECT;
				break;
			case CAUSE_EFFECT:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.CAUSE_EFFECT[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.CAUSE_EFFECT[s][nameLoc]))
						{
							return new CauseEffect(Constants.CAUSE_EFFECT[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.FOCUSED;
				break;
			case FOCUSED:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.FOCUSED[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.FOCUSED[s][nameLoc]))
						{
							return new Focused(Constants.FOCUSED[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.FRIENDS;
				break;
			case FRIENDS:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.FRIENDS[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.FRIENDS[s][nameLoc]))
						{
							return new Friends(Constants.FRIENDS[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.FRONT_AND_CENTER;
				break;
			case FRONT_AND_CENTER:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.FRONT_AND_CENTER[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.FRONT_AND_CENTER[s][nameLoc]))
						{
							return new FrontAndCenter(Constants.FRONT_AND_CENTER[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.HALVE_SCORE;
				break;
			case HALVE_SCORE:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.HALVE_SCORE[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.HALVE_SCORE[s][nameLoc]))
						{
							return new HalveScore(Constants.HALVE_SCORE[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.JAMMER;
				break;
			case JAMMER:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.JAMMER[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.JAMMER[s][nameLoc]))
						{
							return new Jammer(Constants.JAMMER[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.REPEATABLE;
				break;
			case REPEATABLE:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.REPEATABLE[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.REPEATABLE[s][nameLoc]))
						{
							return new Repeatable(Constants.REPEATABLE[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.SHAKEN;
				break;
			case SHAKEN:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.SHAKEN[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.SHAKEN[s][nameLoc]))
						{
							return new Shaken(Constants.SHAKEN[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.SUPER_MOVE;
				break;
			case SUPER_MOVE:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.SUPER_MOVE[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.SUPER_MOVE[s][nameLoc]))
						{
							return new SuperMove(Constants.SUPER_MOVE[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.DETONATION;
				break;
			case DETONATION:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.DETONATION[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.DETONATION[s][nameLoc]))
						{
							return new Detonation(Constants.DETONATION[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.RATTLER;
				break;
			case RATTLER:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.RATTLER[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.RATTLER[s][nameLoc]))
						{
							return new Rattler(Constants.RATTLER[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.COPY_CAT;
				break;
			case COPY_CAT:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.COPY_CAT[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.COPY_CAT[s][nameLoc]))
						{
							return new CopyCat(Constants.COPY_CAT[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.MIRRORED;
				break;
			case MIRRORED:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.MIRRORED[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.MIRRORED[s][nameLoc]))
						{
							return new Mirrored(Constants.MIRRORED[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.SCRAMBLER;
				break;
			case SCRAMBLER:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.SCRAMBLER[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.SCRAMBLER[s][nameLoc]))
						{
							return new Scrambler(Constants.SCRAMBLER[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.BREAKER;
				break;
			case BREAKER:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.BREAKER[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.BREAKER[s][nameLoc]))
						{
							return new Breaker(Constants.BREAKER[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.SHOCKER;
				break;
			case SHOCKER:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.SHOCKER[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.SHOCKER[s][nameLoc]))
						{
							return new Shocker(Constants.SHOCKER[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.HIGHLANDER;
				break;
			case HIGHLANDER:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.HIGHLANDER[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.HIGHLANDER[s][nameLoc]))
						{
							return new Highlander(Constants.HIGHLANDER[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.SHELL_SHOCK;
				break;
			case SHELL_SHOCK:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.SHELL_SHOCK[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.SHELL_SHOCK[s][nameLoc]))
						{
							return new ShellShock(Constants.SHELL_SHOCK[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.ONE_MAN_SHOW;
				break;
			case ONE_MAN_SHOW:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.ONE_MAN_SHOW[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.ONE_MAN_SHOW[s][nameLoc]))
						{
							return new OneManShow(Constants.ONE_MAN_SHOW[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.PARTY_POOPER;
				break;
			case PARTY_POOPER:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.PARTY_POOPER[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.PARTY_POOPER[s][nameLoc]))
						{
							return new PartyPooper(Constants.PARTY_POOPER[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.RANDOM_APPEAL;
				break;
			case RANDOM_APPEAL:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.RANDOM_APPEAL[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.RANDOM_APPEAL[s][nameLoc]))
						{
							return new RandomAppeal(Constants.RANDOM_APPEAL[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.RIGHT_TIME;
				break;
			case RIGHT_TIME:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.RIGHT_PLACE[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.RIGHT_PLACE[s][nameLoc]))
						{
							return new RightTime(Constants.RIGHT_PLACE[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.LATE_BLOOMER;
				break;
			case LATE_BLOOMER:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.LATE_BLOOMER[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.LATE_BLOOMER[s][nameLoc]))
						{
							return new LateBloomer(Constants.LATE_BLOOMER[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.ME_FIRST;
				break;
			case ME_FIRST:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.ME_FIRST[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.ME_FIRST[s][nameLoc]))
						{
							return new MeFirst(Constants.ME_FIRST[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.ME_LAST;
				break;
			case ME_LAST:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.ME_LAST[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.ME_LAST[s][nameLoc]))
						{
							return new MeLast(Constants.ME_LAST[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.STAR_POWER;
				break;
			case STAR_POWER:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.STAR_POWER[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.STAR_POWER[s][nameLoc]))
						{
							return new StarPower(Constants.STAR_POWER[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.GO_FIRST;
				break;
			case GO_FIRST:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.GO_FIRST[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.GO_FIRST[s][nameLoc]))
						{
							return new GoFirst(Constants.GO_FIRST[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.GO_LAST;
				break;
			case GO_LAST:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.GO_LAST[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.GO_LAST[s][nameLoc]))
						{
							return new GoLast(Constants.GO_LAST[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.CONDITION_UP;
				break;
			case CONDITION_UP:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.CONDITION_UP[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.CONDITION_UP[s][nameLoc]))
						{
							return new ConditionUp(Constants.CONDITION_UP[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.SAMESIES;
				break;
			case SAMESIES:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.SAMESIES[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.SAMESIES[s][nameLoc]))
						{
							return new Samesies(Constants.SAMESIES[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.MUD_SLINGER;
				break;
			case MUD_SLINGER:
				for(int s = 0;s <= 4;s++)
				{
					for(int nameLoc = 0; nameLoc<Constants.MUD_SLINGER[s].length; nameLoc++)
					{
						if(n.equalsIgnoreCase(Constants.MUD_SLINGER[s][nameLoc]))
						{
							return new MUD_SLINGLER(Constants.MUD_SLINGER[s][nameLoc],s);
						}
					}
				}
				type = SKILL_TYPE.STRUGGLE;
				break;
			default:
				return new Struggle(Constants.STRUGGLE[0][0],1,"Struggle");
				break;
			}
		}
		return null;
	}

	public void attach(Pokemon pokemon)
	{
		user = pokemon;
	}
}