/**
 * @author aasherknight
 * 
 * @desc Handles the Judge's sprite and a few values
 * @desc Can only be one judge
 */
package scoring;

import javax.swing.ImageIcon;

import Pokemon.Pokemon;

public class Judge
{
	/**
	 * @desc The single judge in the game
	 */
	private static Judge judge;
	
	/**
	 * @desc A flag for if a pokemon has the judge's attention
	 * @This is for combo moves, which are currently not implemented
	 */
	private Pokemon hasAttention;
	
	/**
	 * @desc The judges sprite
	 */
	public ImageIcon sprite = new ImageIcon(Pokemon.class.getResource("/Resources/GUIassets/judge.png"));

	/**
	 * Sets up initial values for the judge
	 */
	private Judge()
	{
		hasAttention = null;
	}
	
	/**
	 * Prevents multiple judges from existing in the game
	 * @return The only judge in the game
	 */
	public static synchronized  Judge getJudge()
	{
		if(judge==null)
			judge = new Judge();
		return judge;
	}
	
	/**
	 * @desc Gives the pokemon the judges attention, which then allows it to pull off a combo move
	 * Combo moves are not currently implemented, so this is a moot point
	 * @param The pokemon that gains the judge's attention
	 */
	public void getAttention(Pokemon poke)
	{
		if(hasAttention!=null)
			hasAttention.lostJudgesAttention();
		
		hasAttention = poke;
		hasAttention.gotJudgesAttention();
	}
	
	/**
	 * @desc Checks if a move was part of a combo move
	 * @return False because this is not currently implemented
	 */
	public boolean isCombo()
	{
		return false;
	}
}
