import java.util.*;

public class GroupAnagrams
{ // this is problem #49. hashmap solution's runtime is 24ms on LeetCode.
  public static List<List<String>> groupAnagrams(String[] strs)
  {
    // going to try a hashmap solution. the answer is always hashmaps.
    Map<String, List<String>> map = new HashMap<String, List<String>>(); // to hold a list of anagrams.

    for(int i = 0; i < strs.length; i++) // iterate through the given strings
    {
      char[] str = strs[i].toCharArray(); // in order to use the below sort function
      Arrays.sort(str);
      String key = new String(str); // the key in the map will be the sorted anagram string.
                                    // using new because str.toString() doesn't work for this, which is annoying.

      List<String> check = map.get(key); // let's see if we have anything for this anagram.
      if(check == null) // if we haven't seen this anagram yet
      {
        ArrayList<String> temp = new ArrayList<String>(); // hold the new List we're making
        temp.add(strs[i]); // add the *unsorted* string to the List
        map.put(key, temp); // put the List in the map with the sorted string as the key
      }
      else // if we have another anagram for this.
      {
        check.add(strs[i]); // add the new string to it.
        map.put(key, check); // then re-add it to the list.
      }
    }

    // now we gotta get this map into a List<List<String>>
    List<List<String>> anagrams = new ArrayList<List<String>>();

    for(List<String> lis : map.values()) // iterate through all the lists of anagrams
    {
      Collections.sort(lis); // sorting them only because of LeetCode's problem specification
      anagrams.add(lis); // add to the List of Lists to be returned
    }

    return anagrams;


    // intuitive, first-draft iterative solution. this is pretty slow.
    /*List<List<String>> anagrams = new ArrayList<List<String>>();
    for(int i = 0; i < strs.length; i++)
    {
      int j = 0;
      while(j < anagrams.size())
      {
        // if str[i]'s an anagram of an item already in the list, then just add it to that item.
        if(!anagrams.isEmpty() && !anagrams.get(j).isEmpty() && isAnagram(anagrams.get(j).get(0), strs[i]))
        {
          anagrams.get(j).add(strs[i]);
          break;
        }

        j++;
      }

      // if it's not in the list, create a new list and add that to anagrams
      if(j == anagrams.size())
      {
        List<String> temp = new ArrayList<String>();
        temp.add(strs[i]);
        anagrams.add(temp);
      }
    }

    return anagrams;*/
  }

  // function to determine if two strings are anagrams. written for problem #242.
  // note: this is only used in my slower first-draft solution.
  public static boolean isAnagram(String s, String t)
  {
    // check for conditions where we can just return right away
    if(s.length() != t.length())
    {
      return false;
    }
    if(s == t)
    {
      return true;
    }
    // idea other than a HashMap solution: turn the strings into character arrays and sort them.
    // HashMap solution below:

    // could improve this by abstracting the following two for loops into a function
    // idea: create a HashMap between a character in the string and the number of times
    // that it occurs. then check if the two hashmaps are equal

    // maps letter -> # of occurences
    HashMap<Character, Integer> mapS = new HashMap<Character, Integer>();

    for(int i = 0; i < s.length(); i++)
    {
      char c = s.charAt(i);

      if(mapS.containsKey(c)) // if it's already in the map, increment the counter.
      {
        // there's gotta be a better way to do this than repeat this code
        int num = mapS.get(c);
        num++;
        mapS.remove(c);
        mapS.put(c, num);
      }
      else // if it's not already in the map
      {
        mapS.put(c, 1);
      }
    }

    HashMap<Character, Integer> mapT = new HashMap<Character, Integer>();

    for(int i = 0; i < t.length(); i++)
    {
      char c = t.charAt(i);

      if(mapT.containsKey(c)) // if it's already in the map, increment the counter.
      {
        int num = mapT.get(c);
        num++;
        mapT.remove(c);
        mapT.put(c, num);
      }
      else // if it's not already in the map
      {
        mapT.put(c, 1);
      }
    }

    return mapS.equals(mapT);
  }

  // helper function for debugging purposes
  public static void printListList(List<List<String>> items)
  {
    for(int i = 0; i < items.size(); i++)
    {
      for(int j = 0; j < items.get(i).size(); j++)
      {
        System.out.println("i: " + i + ", j: " + j + ", item: " + items.get(i).get(j));
      }
    }
  }

  public static void main(String[] args)
  {
    // some test cases
    String[] test1 = {"nottest", "test"};
    List<List<String>> test1List = groupAnagrams(test1);
    printListList(test1List);

    System.out.println(" ");

    String[] test2 = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> test2List = groupAnagrams(test2);
    printListList(test2List);

    String[] test3 = {"bluffed","excellently","neurology","nonrefillable","edmund","boyhoods","survivors","sexually","outnumbering","bolero","werewolf","debasing","dragnet","addams","monochromes","flippancy","hoots","digestion","profanity","cellist","enrols","crumble","elderberry","jayson","recopying","threats","exploded","cinnamon","hospitalized","ducat","memorialize","powerlessly","suaver","deservings","genuinely","calliope","oxidize","gamekeeper","slimming","daises","resisted","shanty","receivable","careering","transmigration","dooms","revisiting","financed","severs","hominy","pantomiming","bestride","seam","alibi","churchman","ovule","jaxartes","retirement","translated","pancaking","achiever","navigates","hazes","tubman","versatility","fergus","adjust","narcosis","hightail","mormon","hattie","chinning","teenager","tho","misbehaves","trustfulness","electioneers","emending","disenchanting","barometer","styluses","uruguay","houseboat","rungs","endwise","reinterpretation","gashes","koshers","nostalgic","hateful","bray","sutures","saudis","sentimentalizes","ayers","avoided","spiky","circumnavigated","tonic","dialects","disbursing","manitoba","potbellies","cauldron","whitened","fitter","attorney","doorbell","scrolled","noncontagious","overnight","rubbishes","stove","amortizing","periling","doublet","celina","whitfield","tonsures","overturns","missions","casuals","juxtaposing","sings","hesperus","panhandle","armando","bernays","trimmers","transom","grafts","columns","abelson","archway","infantries","orly","pock","selectors","lecterns","humps","kinked","bridles","essentials","instead","eliminating","mabel","zing","impersonation","cudgels","chang","artifacts","creon","clucking","skedaddled","spryer","footballs","honeys","wafer","knelt","flagstone","americanize","bohr","plottered","simone","conventional","definable","blackbirds","woodsier","carriage","residents","mezzanines","tenement","plymouth","wresting","islanders","malleable","attentively","irrelevancy","paulette","hillbillies","leech","cloaks","individualist","uncannier","patel","effusions","dungs","plugs","discompose","dacrons","teletypes","dismay","germany","travailing","loathes","devouter","chandelier","rinsed","denial","mil","outmanoeuvre","tugged","icings","reefer","dominicans","franz","destruct","bog","pinhole","jackknife","polytheists","chatted","tomfoolery","breeziness","beaked","tasman","possession","partying","shift","anodynes","pontificate","typefaces","mullions","reconnaissance","stanching","bedstead","belligerent","breakwaters","messerschmidt","instincts","sickle","quondam","limos","fosters","mentalities","minestrone","harrowed","folsom","travesty","compendiums","maladies","narrates","interlocks","humbleness","uplifted","slipknot","motorcyclists","restarted","iconoclast","forts","trumpery","cute","harpsichord","klutzier","ashtray","garlicking","sprayer","duodenal","parboiled","ultras","arkansan","metaphor","patterning","lorries","donetsk","coerced","constricted","murkiness","curtailing","bookish","tenacious","araucanian","unmask","forlorner","ills","bert","closures","cahoots","rotundity","sullying","pare","pretences","beggar","childproofs","educable","duct","posits","bushed","southward","echelon","approximates","spoonerism","waitresses","unman","isolation","suleiman","delight","skimping","rambles","redistrict","alderwomen","o","rejoiced","blot","backpedals","clearings","brontosauruses","laughingly","huckleberries","steinbeck","friskier","commander","skivvies","reality","intermingles","cumbersome","bribery","disagreeable","jersey","lamont","profiteered","shooters","transience","scraper","resignedly","grabbing","christies","piaget","executors","reproachfully","spasming","overproduction","incises","priesthoods","straightforwards","poesied","welled","bickered","drolleries","manures","daffy","segregate","waddles","cheerfully","overprinted","molester","lief","summarizes","vaccination","seminole","unlisted","rumping","ed","weir","manufacture","secretariat","fulminated","molybdenum","bakersfield","unpinning","heroism","violence","mistimed","alcoa","perter","manuscripts","separate","retractions","safes","atoll","grottos","boogieing","olga","frisking","grows","redeployment","helmholtz","durant","rankest","thespian","cheese","pilaf","thinness","contrast","parqueted","milkmaids","blackhead","breathlessly","bothering","decoration","arrogant","setups","contraptions","swirly","transgression","misses","handyman","snows","clinic","vatican","forecaster","haughtiness","bovine","strobe","ingram","maratha","descartes","billeting","treetop","aloud","globed","monument","argumentative","squeegee","especial","retrofits","artistes","propose","piraeus","horsetails","tailpipes","throughout","tarted","synods","unconcerned","weighting","duding","roe","undervalued","reachable","thicker","egging","dentistry","byte","distinguished","envisioning","filibusters","housewarming","matzot","dill","remarries","anatomical","kremlinologists","truancy","bostonians","limited","poorer","corniest","contradictory","three","temporaries","convivial","shirting","schisms","balconies","reinterpret","suturing","kumquats","oncology","unbidden","correlates","kowtows","flashest","neighborhood","rumbas","swathed","webb","birches","engages","promoters","outside","cheeriest","suffusion","propounding","bagels","amish","contrarily","xylophonists","familiarize","makes","testimony","crusaded","wildcatted","slackest","bovines","artier","plops","robbie","slosh","dinkier","airworthiest","carbohydrates","teammates","locoweed","stratagems","sarcoma","gougers","yuletide","rosemarie","upholster","sizzle","reminiscing","bluffers","shellac","heckled","hypothalami","showery","supposes","humbug","burnished","lopsided","imprisons","opine","leeches","generic","stimulated","soggily","aftershave","marvell","pekoe","microorganism","burlap","topples","misfire","scuttlebutt","tantrums","exits","eclecticism","alden","ilk","deltas","slack","effortlessly","operationally","offspring","staggers","alkalis","logger","spines","oscilloscope","tiniest","fluxed","collectively","leagues","procter","protruding","flukiest","underemployed","wetter","ignite","puddings","magnetosphere","solids","oceangoing","barrooms","refurnished","operational","mastering","white","organist","blackest","licentiates","marsupial","machinists","borderlands","dingies","kegging","dualism","cohen","existing","wheeler","uncleanly","umlauts","expiate","misspends","ebert","camber","adventured","weave","bounded","religiously","potluck","scions","millionths","goblet","witchery","dodge","sarasota","pier","membranous","stomaching","tallyhos","cohort","leveraged","makeshift","hexagon","thumped","zedong","versions","ultraconservatives","obeyed","pace","wicks","luncheoning","minerals","medications","moralizes","unites","rant","portents","apparelling","hums","farrowed","verve","boggiest","weal","josephus","perfects","beef","stairwell","comment","arrant","stature","kc","quoits","galls","adoption","reformulate","physicals","schroeder","scoundrels","delivered","crushed","rue","thrives","cerf","hijacker","inkier","vulvae","deterring","burgles","catechism","unhorse","reclined","dapple","angioplasties","sluggards","emceed","snobbery","accessory","cardiologist","browning","crosses","boasted","summonsing","gamble","overdue","scourge","dirges","cascades","precious","peacefuller","oysters","hoods","pirates","sauerkraut","whiskers","defames","repute","foolish","lactate","tharp","electrocutions","fating","freezers","invocation","dissenter","should","hells","homesickness","archdukes","preconceiving","scroungers","embellishment","massacre","upon","aerated","protuberant","sternly","meticulously","virulent","loch","enchant","raindrop","atrophies","magyar","interring","coachmen","exorcism","faintness","pointlessness","kawabata","installment","maliciously","vindicating","monkeying","uncanny","tangibles","blessed","forensic","arty","toppled","dilapidation","klutzes","moots","cottage","seismograph","diarists","aperitif","facing","filial","soundings","salsa","clear","cayenne","stilling","thighs","contrasting","cloistered","custodial","woodland","frillier","unrolls","landsat","chartres","toughly","saluted","verbose","transfiguring","zapped","iconoclasts","parkman","charlestons","spadework","okaying","numismatics","chestnuts","ghostwriters","nobelists","insouciant","vivisection","moods","edifices","relocated","wisdom","ignobly","namesakes","tapestry","schismatics","agra","blundering","sailboards","fruited","anticlimax","viewed","locus","barricading","rehearsed","irater","sibyl","steps","airsickness","blasphemous","swelling","salinger","veal","normalizes","gullet","inhabitant","slut","zinced","homing","headphone","chatters","winged","wingspread","kneecaps","tam","withdraws","repatriating","peter","isobars","dix","rekindled","snider","depends","mute","knowledgeably","mends","tides","stoutness","hempen","victoria","slaloming","buttons","grammars","astounding","memorandum","kenmore","solid","bandoliers","flowered","equivocation","assuredly","festers","helios","lebanese","impugned","shiftlessness","statement","announcer","vagueness","punctures","colonnade","exist","displeasing","diocletian","untold","unprintable","hereford","sidereal","joke","automatically","rendezvousing","surfed","surreptitious","depopulating","arching","massive","excise","beatles","rigorous","turnovers","impromptus","jezebels","glinted","leveraging","capsizing","voices","hitchhiking","ramon","wyeth","larva","unblushing","inanest","vacillate","contrives","kw","carboniferous","disinterred","predicated","song","andean","youths","previous","yours","supplicates","gompers","apprenticed","half","lactic","authenticating","charlatan","mendacious","flanks","hieronymus","dressy","owns","vestry","strobes","clapping","informers","sermoning","rifer","headstone","bobbing","forgiven","hypocritical","legation","adjusted","glibness","peeled","actuators","composition","payloads","abdication","delete","unnecessary","misprint","wooziest","cannibalistic","voiced","marooned","einstein","erratically","obsessions","impracticality","hoffa","rheumatics","handsets","tricked","afield","abdul","sounding","tray","massacring","iowan","grits","billy","purchases","profitably","resilience","eyed","vocabularies","golden","barking","riviera","helmsmen","cavorting","shrinks","hangmen","heliports","salve","assorting","neuroses","contribute","triathlon","adherents","gismo","sering","pulsate","hoarders","vacating","pulverization","destabilize","wore","eureka","gobs","raiding","valhalla","aureole","illustration","null","ageing","umbrellaing","characterize","ethel","bagging","lucas","nakedly","rinded","wainscottings","through","falter","clearness","smart","overspecializes","older","entourage","dawn"};

    List<List<String>> test3List = groupAnagrams(test3);
    printListList(test3List);
  }
}
