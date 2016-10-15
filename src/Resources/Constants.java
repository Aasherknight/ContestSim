/**
 * @author aasherknight
 * 
 * @desc Maintains and catalogs all values that need stored and used throughout the program 
 */

package Resources;

public class Constants
{
	/**
	 * @desc of species available
	 */
	static public String[]	SPECIES	=
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

	/**
	 * Type of skills available
	 * 
	 * [style][nameOf]
	 * # = Appeal Point
	 * j = Jam Point
	 * S = Unnerves POKeMON
	 * * = Ups Condition
	 * - = Worsens Condition
	 * O = Oblivious for one turn ('became oblivious to others')
	 * o = Oblivious for one move ('settled down a little')
	 * X = Loses remaining turns
	 * x = Loses the next turn
	 * 1 = Appeal 1st next turn
	 * 4 = Appeal 4th next turn
	 * ? = Turn order scrambled next turn
	 */
	final static int COOL 	 = 0;
	final static int BEAUTY  = 1;
	final static int CUTE	 = 2;
	final static int SMART	 = 3;
	final static int TOUGH	 = 4;
	
	/**
	 * @desc Do nothing but provide 4 appeal
	 * ####
	 */
	static public String[][] RAW_APPEAL = 
	{
			{	"drill peck", "horn attack", "mega kick", "metal claw", "peck", "solarbeam", "struggle",
				"thunderbolt", "thunderpunch", "thundershock", "triple kick", "vine whip", "zap cannon"},
			{	"blaze kick", "blizzard", "ember", "fire blast", "fire punch", "flame wheel",
					"flamethrower", "heat wave", "hydro pump", "ice punch", "powder snow", "sacred fire",
			"softboiled"},
			{	"mud sport", "snore", "water gun", "water sport"},
			{	"weatherball"},
			{	"bone rush", "bonemerang", "egg bomb", "mega punch", "pound", "scratch", "spit up",
				"tackle", "vice grip"}
	};

	/**
	 * @desc Moves that will ALWAYS excite the audience and gets either 1 or 6 depending on the applause meter
	 * #
	 * ######
	 */
	static public String[][] FRIENDS = 
		{		{""},
				{""},
				{"frustration", "return"},
				{""},
				{""}
		};

	/**
	 * @desc Gives appeal based on who went before you
	 * if they got less than 3, you get 6
	 * if they get 3, you get 3
	 * if they get more than 3, you get 0
	 */
	static public String[][] CAUSE_EFFECT = 
		{	
				{"aeroblast", "cross chop", "leaf blade", "razor leaf", "razor wind", "sky attack", "slash"},
				{"surf"},
				{""},
				{"camouflage"},
				{"crabhammer", "karate chop"}
		};

	/**
	 * @desc These moves make the pokemon more easily startled, but provide a large amount of appeal 
	 * ######
	 */
	static public String[][] SHAKEN = 
		{	
				{"hi jump kick", "jump kick", "submission", "volt tackle"},
				{"overheat"},
				{""},
				{"psycho boost"},
				{"double-edge", "superpower", "take down"}
		};

	/**
	 * @desc Startles all pokemon that went before, and will cut their scores in half for that round 
	 * ##j
	 */
	static public String[][] HALVE_SCORE = 
		{
				{"bullet seed", "cut", "guillotine", "horn drill", "thunder wave"},
				{"perish song", "sheer cold"},
				{""},
				{"beat up", "psywave", "pursuit", "snatch"},
				{"fissure", "super fang"}
		};

	/**
	 * @desc tries to startle the pokemon that went right before you 
	 * #jjjj
	 */
	static public String[][] FRONT_AND_CENTER =
		{
				{"brick break", "crush claw", "dizzy punch", "extrasensory", "hyper fang", "iron tail", "spark"},
				{"will-o-wisp"},
				{""},
				{"acid", "knock off", "mega drain", "mist ball", "needle arm", "pain split"},
				{"body slam", "crunch", "lick", "low kick", "skull bash", "sludge ball", "sludge", "stomp"}
		};

	/**
	 * @desc Does a default jam on pokemon that went before it
	 * #jjj
	 */
	static public String[][] JAMMER = 
		{
				{"dragonbreath", "false swipe", "focus energy", "hyper voice", "rolling kick"},
				{"bubblebeam", "hail", "icy wind", "lovely kiss", "spore"},
				{"sweet scent"},
				{"hypnosis", "metal sound", "nightmare", "psychic", "screech", "sleep powder"},
				{"bite", "earthquake", "glare", "glasswhistle", "mud shot", "rock slide", "smog"}
		};

	/**
	 * @desc Protects from any jam attempt for this round
	 * #
	 */
	static public String[][] FOCUSED =
		{
				{"barrier", "teleport"},
				{"light screen", "mist", "safeguard"},
				{"bounce", "protect", "withdraw"},
				{"dig", "fly", "ingrain", "magic coat", "reflect"},
				{"bide", "iron defense"}
		};

	/**
	 * @desc Protects from any jam attempt for this round
	 * ##
	 */
	static public String[][] FOCUSED_2 = 
		{
				{"Defense Curl", "Detect", "Double Team", "Rapid Spin"},
				{"Dive", "Mirror Coat"},
				{"Minimize", "Rest"},
				{"Calm Mind", "Substitute"},
				{"Counter", "Endure", "Harden", "Stockpile"}
		};
	
	/**
	 * @desc Can be used multiple times without affecting appeal
	 * ###
	 */
	static public String REPEATABLE[][] = 
		{
				{"fury cutter", "rage"},
				{""},
				{"metronome", "present", "sleep talk"},
				{"hidden power", "recycle", "transform"},
				{""}
		};

	/**
	 * @desc Jams the others, and misses one turn of appeals
	 * ####jjjj
	 */
	static public String SUPER_MOVE[][] = 
		{
				{"Frenzy Plant", "Hyper Beam", "Outrage"},
				{"Blast Burn", "Hydro Cannon", "Petal Dance"},
				{"Teeter Dance"},
				{""},
				{"Thrash"}
		};
	
	/**
	 * @desc Makes a great appeal, but allows no more to the end
	 * ########
	 */
	static public String DETONATION[][] =
		{
				{""},
				{"Explosion","Selfdestruct"},
				{""},
				{"Destiny Bond"},
				{"Memento"}
		};
	
	/**
	 * @desc Attempts to make all POKeMON after the user nervous
	 * ##
	 */
	static public String RATTLER[][] =
		{
				{""},
				{""},
				{"Attract", "Baton Pass", "Block", "Encore", "Mean Look", "Sing", "Sweet Kiss", "Yawn"},
				{"Disable", "Flatter", "Helping Hand", "Spider Web", "Spikes", "Taunt"},
				{"Torment"}
		};

	/**
	 * @desc Makes the appeal as good as the one before it
	 * 
	 */
	static public String COPY_CAT[][] =
		{
				{""},
				{""},
				{"Mimic"},
				{"Mirror Move", "Sketch"},
				{""}
		};

	/**
	 * @desc Makes the appeal as good as those before it
	 * #
	 * causes you to gain additional 
	 * appeal points based on the appeal points of all of the POKeMON who appealed
	 * before yours.  Half of the POKeMON's appeal points, rounded down, are added to
	 * yours, plus one more.
	 */
	static public String MIRRORED[][] =
		{
				{""},
				{""},
				{"Covet", "Role Play"},
				{"Skill Swap"},
				{"Thief"}
		};
	
	/**
	 * @desc Scrambles the order of appeals on the next turn
	 * ###
	 */
	static public String SCRAMBLER[][] =
		{
				{"Roar", "Twister"},
				{"Psybeam", "Signal Beam", "Water Pulse"},
				{"Uproar"},
				{"Confuse Ray", "Gust", "Supersonic", "Whirlwind"},
				{"Sandstorm"}
		};
	
	/**
	 * @desc Shifts the JUDGE's attention from others, cancels Combo Standby status for all
	 * POKeMON that moved before you
	 * ###
	 */
	static public String BREAKER[][] =
		{
				{""},
				{"Flash"},
				{""},
				{"Smokescreen", "Shadowball"},
				{""}
		};
	
	/**
	 * @desc Startles all POKeMON that have done their appeals
	 * ##jj
	 */
	static public String SHOCKER[][] =
		{
				{"Thunder"},
				{"Tri Attack"},
				{"Bubble"},
				{"Dream Eater", "Leech Seed"},
				{""}
		};
	
	/**
	 * @desc Startles POKeMON that made a same-type appeal
	 * ##j
	 */
	static public String HIGHLANDER[][] = 
		{
				{"Air Cutter", "Dragon Claw", "Sky Uppercut"},
				{"Aurora Beam", "Ice Beam", "Icicle Spear"},
				{"Charm", "Fake Out"},
				{"Night Shade", "Recover"},
				{"Seismic Toss", "Slam", "Strength"}
		};
	
	/**
	 * @desc Startles the POKeMON that appealed before the user
	 * ##jjj
	 */
	static public String SHELL_SHOCK[][] = 
		{
				{"Twineedle"},
				{""},
				{""},
				{"Absorb", "Astonish", "Confusion", "Leech Life", "Luster Purge", "Poinson Sting",
					"Smellingsalt", "String Shot"},
				{"Constrict", "Headbutt"}
		};
	
	/**
	 * @desc Startles the POKeMON that has the JUDGE's attention
	 * ##j
	 */
	static public String ONE_MAN_SHOW[][] =
		{
				{"DynamicPunch", "Fury Attack", "Pin Missile", "Spike Cannon"},
				{"Cotton Spore"},
				{"Mud-Slap", "Sand-Attack"},
				{"Giga Drain"},
				{"Arm Thrust", "Bone Club", "Doubleslap", "Fury Swipes", "Muddy Water", " Octazooka",
					"Scary Face", "Sludge Bomb"}
		};
	
	/**
	 * @desc Temporarily stops the crowd from growing excited
	 * ###
	 */
	
	static public String PARTY_POOPER[][] =
		{
				{"Doom Desire", "Leer"},
				{"Fire Spin", "Ice Ball", "Whirlpool"},
				{"Follow Me", "Wish"},
				{"Future Sight", "Kinesis", "Lock-on", "Mind Reader", "Rock Tomb", "Sand Tomb"},
				{"Bind", "Clamp", "Rollout", "Wrap"}
		};
	
	/**
	 * @desc The appeal's quality is random, can be any of the below
	 * # 
	 * ##
	 * ####
	 * ########
	 */
	static public String RANDOM_APPEAL[][] =
		{
				{""},
				{"Morning Sun", "Moonlight"},
				{"Cute"},
				{"Synthesis"},
				{""}
		};
	
	/**
	 * @desc The appeal works best the more the crowd is excited
	 * the higher the applause meter the more points awarded
	 */
	static public String RIGHT_PLACE[][] = 
		{
				{""},
				{"Sunny Day", "Nature Power"},
				{""},
				{"Pay Day"},
				{"Magnitude", "Rain Dance"}
		};
	
	/**
	 * @desc The appeal works better the later it is performed, in order of performance
	 * #
	 * ##
	 * ####
	 * ######
	 */
	static public String LATE_BLOOMER[][] =
		{
				{"Dragon Rage"},
				{"Eruption", "Water Spout"},
				{"Flail", "Slack Off"},
				{""},
				{"Grudge"}
		};
	
	/**
	 * @desc The appeal works great if performed first, 6 for first, 2 for other
	 * ######
	 * ##
	 */
	static public String ME_FIRST[][] = 
		{
				{"Aerial Ace", "Shock Wave", "Swift"},
				{"Magical Leaf"},
				{"Swagger"},
				{"Faint Attack", "Shadow Punch"},
				{""}
		};
	
	/**
	 * @desc The appeal works great if performed last, 6 for last, 2 for other
	 * ##
	 * ######
	 */
	static public String ME_LAST[][] = 
		{
				{"Reversal"},
				{"Featherdance", "Heal Bell"},
				{"Facade", "Growl", "Splash", "Tail Whip"},
				{"Aromatherapy", "Fake Tears"},
				{"Endeavor", "Spite", "Waterfall"}
		};
	
	/**
	 * @desc The appeal works well if the user's condition is good
	 * Number of stars
	 * 0 = #
	 * * = ###
	 * ** = #####
	 * *** = #######
	 */
	static public String STAR_POWER[][] = 
		{
				{""},
				{""},
				{""},
				{"Secret Power"},
				{"Rock Smash"}
		};
	
	/**
	 * @desc The next appeal will be first
	 * ###
	 */
	static public String GO_FIRST[][] = 
		{
				{"Agility", "ExtremeSpeed", "Mach Punch", "Quick Attack"},
				{""},
				{""},
				{""},
				{""}
		};
	
	/**
	 * @desc The next appeal will be last
	 * ###
	 */
	static public String GO_LAST[][] =
		{
				{"Vital Throw"},
				{""},
				{""},
				{""},
				{"Curse","Focus Punch", "Revenge"}
		};
	
	/**
	 * @desc Ups the user's condition. Gives Stars
	 */
	static public String CONDITION_UP[][] =
		{
				{"Cosmic Power", "Dragon Dance", "Howl"},
				{"Bulk Up", "Growth", "Meditate", "Silver Wind", "Swords Dance", "Tail Glow"},
				{"Amnesia", "Belly Drum", "Refresh", "Sharpen"},
				{""},
				{"Acid Armor", "Ancient Power", "Swallow"}
		};
	
	/**
	 * @desc Works well if it's the same type as the one before
	 * if the same type
	 * ######
	 * else
	 * ##
	 */
	static public String SAMESIES[][] = 
		{
				{"Double Kick", "Megahorn", "Meteor Mash", "Sonicboom", "Steel Wing", "Wing Attack"},
				{"Conversion", "Conversion2"},
				{"Milk Drink"},
				{"Charge", "Psych Up", "Trick"},
				{"Rock Blast", "Barrage", "Comet Punch", "Rock Throw"}
		};
	
	/**
	 * @desc removes any stars the other pokemon might have
	 */
	static public String MUD_SLINGER[][] = 
		{
				{""},
				{"Haze"},
				{"Tickle"},
				{"Foresight", "Imprison", "Odor Sleuth", "Poison Fang", "Poison Gas", "Poison Tail", "Poisonpowder", "Toxic"}
		};
	/**
	 * COOL 	 = 0;
	 * BEAUTY 	 = 1;
	 * CUTE		 = 2;
	 * SMART	 = 3;
	 * TOUGH	 = 4;
	*/
				
			
	/**
	 * @desc A default move, has an appeal of 2
	 */
	static public String STRUGGLE[][] = 
		{
				{"Struggle"},
				{"Struggle"},
				{"Struggle"},
				{"Struggle"},
				{"Struggle"}
		};
}

