import java.io.*;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class Pokemon
{
	String		nickname, name;
	Item		held;
	Skill		move1, move2, move3, move4;
	boolean		shiny;
	int			score, order;
	ImageIcon	sprite		= new ImageIcon(Pokemon.class.getResource("/Resources/pokeBackSprite/Default/0.png"));
	ImageIcon	backSprite	= new ImageIcon(Pokemon.class.getResource("/Resources/pokeBackSprite/Default/0.png"));

	String[]	species		=
	{ "null", "bulbasaur", "ivysaur", "venusaur", "charmander", "charmeleon", "charizard", "squirtle", "wartortle",
			"blastoise", "caterpie", "metapod", "butterfree", "weedle", "kakuna", "beedrill", "pidgey", "pidgeotto",
			"pidgeot", "rattata", "raticate", "spearow", "fearow", "ekans", "arbok", "pikachu", "raichu", "sandshrew",
			"sandslash", "nidoran f", "nidorina", "nidoqueen", "nidoran m", "nidorino", "nidoking", "clefairy",
			"clefable", "vulpix", "ninetales", "jigglypuff", "wigglytuff", "zubat", "golbat", "oddish", "gloom",
			"vileplume", "paras", "parasect", "venonat", "venomoth", "diglett", "digtrio", "meowth", "persian", 
			"psyduck", "golduck", "mankey", "primeape", "growlithe", "arcanine", "poliwag", "poliwhirl", "poliwrath",
			"abra", "kadabra", "alakazam", "machop", "machoke", "machamp", "bellsprout", "weepinbell", "victreebel",
			"tentacool", "tentacruel", "geodude", "graveler", "golem", "ponyta", "rapidash", "slowpoke", "slowbro",
			"magnemite", "magneton", "farfetch'd", "doduo", "dodrio", "seel", "dewgong", "grimer", "muk", "shellder",
			"cloyster", "gastly", "haunter", "gengar", "onix", "drowzee", "hypno", "krabby", "kingler", "voltorb",
			"electrode", "exeggcute", "exeggutor", "cubone", "marowak", "hitmonlee", "hitmonchan", "lickitung",
			"koffing", "weezing", "rhyhorn", "rhydon", "chansey", "tangela", "kangaskhan", "horsea", "seadra",
			"goldeen", "seaking", "staryu", "starmie", "mr. mime", "scyther", "jynx", "electabuzz", "magmar", 
			"pinsir", "tauros", "magikarp", "gyarados", "lapras", "ditto", "eevee", "vaporeon", "jolteon",
			"flareon", "porygon", "omanyte", "omastar", "kabuto", "kabutops", "aerodactyl", "snorlax", "articuno",
			"zapdos", "moltres", "dratini", "dragonair", "dragonite", "mewtwo", "mew",
			
			"chikorita", "bayleef", "meganium", "cyndaquil", "quilava", "typhlosion", "totodile", "croconaw",
			"feraligatr", "sentret", "furret", "hoothoot", "noctowl", "ledyba", "ledian", "spinarak", "ariados",
			"crobat", "chinchou", "lanturn", "pichu", "cleffa", "igglybuff", "togepi", "togetic", "natu", "xatu",
			"mareep", "flaaffy", "ampharos", "bellossom", "marill", "azumarill", "sudowoodo", "politoed", "hoppip",
			"skiploom", "jumpluff", "aipom", "sunkern", "sunflora", "yanma", "wooper", "quagsire", "espeon",
			"umbreon", "murkrow", "slowking", "misdreavus", "unown", "wobbuffet", "girafarig", "pineco", "forretress",
			"dunsparce", "gligar", "steelix", "snubbull", "granbull", "qwilfish", "scizor", "shuckle", "heracross",
			"sneasel", "teddiursa", "ursaring", "slugma", "magcargo", "swinub", "pilowsine", "corsola", "remoraid",
			"octillery", "delibird", "mantine", "skarmory", "houndour", "houndoom", "kingdra", "phanpy", "donphan",
			"porygon2", "stantler", "smeargle", "tyrogue", "hitmontop", "smoochum", "elekid", "magby", "miltank",
			"blissey", "raikou", "entei", "suicune", "larvitar", "pupitar", "tyranitar", "lugia", "ho-oh", "celebi",
			
			"treecko", "grovyle", "sceptile", "torchic", "combusken", "blaziken", "mudkip", "marshtomp", "swampert",
			"poochyena", "mightyena", "zigzagoon", "linoone", "wurmple", "silcoon", "beautifly", "cascoon", "dustox",
			"lotad", "lombre", "ludicolo", "seedot", "nuzleaf", "shiftry", "taillow", "swellow", "wingull", " pelipper",
			"ralts", "kirlia", "gardevoir", "surskit", "masquerain", "shroomish", "breloom", "slakoth", "vigoroth", 
			"slaking", "nincada", "ninjask", "shedinja", "whismur", "loudred", "exploud", "makuhita", "hariyama", "azurill",
			"nosepass", "skitty", "delcatty", "sableye", "mawile", "aron", "lairon", "aggron", "meditite", "medicham",
			"medicham", "electrike", "manectric", "plusle", "minun", "volbeat", "illumise", "roselia", "glupin", "swalot",
			"carvanha", "sharpedo", "wailmer", "wailord", "numel", "camerupt", "torkoal", "spoink", "grumpig", "spinda",
			"trapinch", "vibrava", "flygon", "cacnea", "cacturne", "swablu", "altaria", "zangoose", "seviper", "lunatone",
			"solrock", "barboach", "whiscash", "corphish", "crawdaunt", "baltoy", "claydol", "lileep", "cradily",
			"anorith", "armaldo", "feebas", "milotic", "castform", "kecleon", "shuppet", "banette", "duskull", "dusclops",
			"tropius", "chimecho", "absol", "wynaut", "snorunt", "glalie", "spheal", "sealeo", "walrein", "clamperl", 
			"huntail", "gorebyss", "relicanth", "luvdisc", "bagon", "shelgon", "salamence", "beldum", "metang", "metagross",
			"regirock", "regice", "registeel", "latias", "latios", "kyogre", "groudon", "rayquaza", "jirachi", "deoxys"};

	public Pokemon(File poke) throws FileNotFoundException
	{
		/* species
		 * nickname
		 * shiny(y/n)
		 * item
		 * move1
		 * move2
		 * move3
		 * move4
		 */
		
		Scanner reader = new Scanner(poke);
		name = reader.nextLine();
		name.toLowerCase();
		nickname = reader.nextLine();
		String temp = reader.nextLine();

		if (temp.contains("n"))
			shiny = false;
		else
			shiny = true;
		
		spriteLookup(name);

		temp = reader.nextLine();
		held = Item.itemLookup(temp);

		temp = reader.nextLine();
		move1 = Skill.skillLookup(temp);

		temp = reader.nextLine();
		move2 = Skill.skillLookup(temp);

		temp = reader.nextLine();
		move3 = Skill.skillLookup(temp);

		temp = reader.nextLine();
		move4 = Skill.skillLookup(temp);
	}

	private void spriteLookup(String name2)
	{
		for(int i = 0; i<=species.length; i++)
		{
			if(name.equalsIgnoreCase(species[i]))
			{
				if(shiny)
					backSprite = new ImageIcon(Pokemon.class.getResource("/Resources/pokeBackSprite/Shiny/" + i + ".png"));
				else
					backSprite = new ImageIcon(Pokemon.class.getResource("/Resources/pokeBackSprite/Default/" + i + ".png"));
			}
		}
	}
}
