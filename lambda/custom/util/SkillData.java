package util;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.exception.AskSdkException;
import com.amazon.ask.model.SupportedInterfaces;
import com.amazon.ask.model.interfaces.alexa.presentation.apl.AlexaPresentationAplInterface;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.apache.commons.io.FileUtils;

import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Trends;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class SkillData {

  public static final Map<String, Integer> LOCATION_MAP = new HashMap<String, Integer>() {
    {
      // FIXME This is just a small list of cities and WOEIDs.
      // Full list of available WOEIDs can be queried here
      // https://developer.twitter.com/en/docs/trends/locations-with-trending-topics/api-reference/get-trends-available
      put("Seattle", 2490383);
      put("Austin", 2357536);
      put("Chicago", 2379574);
      put("Houston", 2424766);
      put("Orlando", 2466256);
      put("New York", 2459115);
      put("Los Angeles", 2442047);
      put("San Francisco", 2487956);
      put("Denver", 2391279);
      put("London", 44418);
      put("Canada", 23424775);
      put("Toronto", 615702);
      put("Paris", 615702);
      put("New Delhi", 2295019);
      put("Varanasi", 2295380);
      put("California", 2347563);
      put("Iran", 23424851);
      put("Kaithi", 29128560);
      put("Ireland", 23424803);
      put("United Kingdom", 23424975);
      put("England", 24554868);
      put("Greater London", 23416974);
      put("Mexico", 23424900);
      put("Brazil", 23424768);
      put("Sao Paulo", 2344868);
      put("United States", 23424977);
      put("Illinois", 2347572);
      put("District of Columbia", 2347567);
      put("Washington", 2514815);
      put("Baltimore City", 12588679);

      put("Massachusetts", 2347580);
      put("Boston", 2367105);
      put("Georgia", 2347569);

      put("Atlanta", 2357024);

      put("Texas", 2347602);

      put("Houston", 2424766);

      put("Dallas", 12590063);

      put("San Antonio", 2487796);

      put("Pennsylvania", 2347597);

      put("Philadelphia", 12589778);



      put("Nigeria", 1398823);
      put("United Arab Emirates", 23424738);

      put("Toronto", 4118);


      put("Westminster", 23538863);


      put("Sweden", 23424954);
      put("Japan", 1118108);
      put("Scotland", 24875064);
      put("Edinburgh", 19344);


      put("Glasgow", 21125);


      put("Quebec", 3444);
      put("Ottawa", 3369);
      put("Edmonton", 8676);
      put("Calgary", 8775);
      put("Vancouver", 9807);
      put("Birmingham", 12723);
      put("Blackpool", 12903);
      put("Bournemouth", 13383);
      put("Brighton", 13911);
      put("Glasgow", 21125);
      put("Belfast", 44544);
      put("Santo Domingo", 76456);
      put("Manchester", 28218);
      put("Guatemala City", 3369);
      put("Acapulco", 110978);
      put("Winnipeg", 2972);
      put("Montreal", 3534);
      put("Bristol", 13963);
      put("Cardiff", 15127);
      put("Coventry", 17044);
      put("Derby", 18114);
      put("Hull", 25211);
      put("Leeds", 26042);
      put("Leicester", 26062);
      put("Liverpool", 26734);
      put("Aguascalientes", 111579);
      put("Middlesbrough", 28869);
      put("Newcastle", 30079);
      put("Nottingham", 30720);
      put("Plymouth", 32185);
      put("Portsmouth", 32452);
      put("Preston", 32566);
      put("Sheffield", 34503);
      put("Stoke-on-Trent", 36240);
      put("Swansea", 36758);
      put("Chihuahua", 115958);
      put("Mexico City", 116545);
      put("Ciudad Juarez", 116556);
      put("Guadalajara", 124162);
      put("Monterrey", 134047);
      put("Morelia", 134091);
      put("Puebla", 137612);
      put("Saltillo", 141272);
      put("Toluca", 149769);
      put("Cali", 368149);
      put("Barranquilla", 368151);
      put("Quito", 375732);
      put("Guayaquil", 375733);
      put("Caracas", 395269);
      put("Maracaibo", 395270);
      put("Maracay", 395271);
      put("Valencia", 395272);
      put("Barcelona", 395273);
      put("Ciudad Guayana", 395275);
      put("Turmero", 395277);
      put("Lima", 418440);
      put("Curitiba", 455822);
      put("Porto Alegre", 455823);
      put("Recife", 455824);
      put("Rio de Janeiro", 455825);
      put("Salvador", 455826);
      put("Sao Paulo", 455827);
      put("Campinas", 455828);
      put("Fortaleza", 455830);
      put("Manaus", 455833);
      put("Guarulhos", 455867);
      put("Buenos Aires", 468739);
      put("Warsaw", 523920);
      put("Wroclaw", 526363);
      put("Vienna", 551801);
      put("Cork", 560472);
      put("Dublin", 560743);
      put("Galway", 560912);
      put("Bordeaux", 580778);
      put("Lille", 608105);
      put("Lyon", 609125);
      put("Marseille", 610264);
      put("Montpellier", 612977);
      put("Nantes", 613858);
      put("Paris", 615702);
      put("Rennes", 619163);
      put("Strasbourg", 627791);
      put("Toulouse", 628886);
      put("Berlin", 638242);
      put("Bremen", 641142);
      put("Dortmund", 645458);
      put("Dresden", 645686);
      put("Dusseldorf", 646099);
      put("Essen", 648820);
      put("Frankfurt", 650272);
      put("Hamburg", 656958);
      put("Cologne", 667931);
      put("Leipzig", 671072);
      put("Munich", 676757);
      put("Stuttgart", 698064);
      put("Bologna", 711080);
      put("Genoa", 716085);
      put("Milan", 718345);
      put("Naples", 719258);
      put("Palermo", 719846);
      put("Rome", 721943);
      put("Turin", 725003);
      put("Den Haag", 726874);
      put("Amsterdam", 727232);
      put("Rotterdam", 733075);
      put("Utrecht", 734047);
      put("Barcelona", 753692);
      put("Bilbao", 754542);
      put("Las Palmas", 764814);
      put("Madrid", 766273);
      put("Malaga", 766356);
      put("Murcia", 768026);
      put("Palma", 769293);
      put("Seville", 774508);
      put("Valencia", 776688);
      put("Zaragoza", 779063);
      put("Geneva", 782538);
      put("Lausanne", 783058);
      put("Zurich", 784794);
      put("Brest", 824382);
      put("Grodno", 825848);
      put("Gomel", 825978);
      put("Minsk", 834463);
      put("Riga", 854823);
      put("Bergen", 857105);
      put("Oslo", 862592);
      put("Gothenburg", 890869);
      put("Stockholm", 906057);
      put("Dnipropetrovsk", 918981);
      put("Kharkiv", 922137);
      put("Donetsk", 919163);
      put("Kyiv", 924938);
      put("Lviv", 924943);
      put("Odesa", 929398);
      put("Zaporozhye", 939628);
      put("Athens", 946738);
      put("Thessaloniki", 963291);
      put("Bekasi", 1030077);
      put("Depok", 1032539);
      put("Pekanbaru", 1040779);
      put("Surabaya", 1044316);
      put("Makassar", 1046138);
      put("Bandung", 1047180);
      put("Jakarta", 1047378);
      put("Medan", 1047908);
      put("Palembang", 1048059);
      put("Semarang", 1048324);
      put("Tangerang", 1048536);
      put("Singapore", 1062617);
      put("Perth", 1098081);
      put("Adelaide", 1099805);
      put("Brisbane", 1100661);
      put("Canberra", 1100968);
      put("Darwin", 1101597);
      put("Melbourne", 1103816);
      put("Sydney", 1105779);
      put("Kitakyushu", 1110809);
      put("Saitama", 1116753);
      put("Chiba", 1117034);
      put("Fukuoka", 1117099);
      put("Hamamatsu", 1117155);
      put("Hiroshima", 1117227);
      put("Kawasaki", 1117502);
      put("Kobe", 1117545);
      put("Kumamoto", 1117605);
      put("Nagoya", 1117817);
      put("Niigata", 1117881);
      put("Sagamihara", 1118072);
      put("Sapporo", 1118108);
      put("Sendai", 1118129);
      put("Takamatsu", 1118285);
      put("Tokyo", 1118370);
      put("Yokohama", 1118550);
      put("Goyang", 1130853);
      put("Yongin", 1132094);
      put("Ansan", 1132444);
      put("Bucheon", 1132445);
      put("Busan", 1132447);
      put("Changwon", 1132449);
      put("Daegu", 1132466);
      put("Gwangju", 1132481);
      put("Incheon", 1132496);
      put("Seongnam", 1132559);
      put("Suwon", 1132567);
      put("Ulsan", 1132578);
      put("Seoul", 1132599);
      put("Kajang", 1141268);
      put("Ipoh", 1154679);
      put("Johor Bahru", 1154698);
      put("Klang", 1154726);
      put("Kuala Lumpur", 1154781);
      put("Calocan", 1167715);
      put("Makati", 1180689);
      put("Pasig", 1187115);
      put("Taguig", 1195098);
      put("Antipolo", 1198785);
      put("Cagayan de Oro", 1199002);
      put("Cebu City", 1199079);
      put("Davao City", 1199136);
      put("Manila", 1199477);
      put("Quezon City", 1199682);
      put("Zamboanga City", 1199980);
      put("Bangkok", 1225448);
      put("Hanoi", 1236594);
      put("Hai Phong", 1236690);
      put("Can Tho", 1252351);
      put("Da Nang", 1252376);
      put("Ho Chi Minh City", 1252431);
      put("Algiers", 1253079);
      put("Accra", 1326075);
      put("Kumasi", 1330595);
      put("Benin City", 1387660);
      put("Ibadan", 1393672);
      put("Kaduna", 1396439);
      put("Kano", 1396803);
      put("Lagos", 1398823);
      put("Port Harcourt", 1404447);
      put("Giza", 1521643);
      put("Cairo", 1521894);
      put("Alexandria", 1522006);
      put("Mombasa", 1528335);
      put("Nairobi", 1528488);
      put("Durban", 1580913);
      put("Johannesburg", 1582504);
      put("Port Elizabeth", 1586614);
      put("Pretoria", 1586638);
      put("Soweto", 1587677);
      put("Cape Town", 1591691);
      put("Medina", 1937801);
      put("Dammam", 1939574);
      put("Riyadh", 1939753);
      put("Jeddah", 1939873);
      put("Mecca", 1939897);
      put("Sharjah", 1940119);
      put("Abu Dhabi", 1940330);
      put("Dubai", 1940345);
      put("Haifa", 1967449);
      put("Tel Aviv", 1968212);
      put("Jerusalem", 1968222);
      put("Amman", 1968902);
      put("Chelyabinsk", 1997422);
      put("Samara", 2077746);
      put("Voronezh", 2108210);
      put("Yekaterinburg", 2112237);
      put("Irkutsk", 2121040);
      put("Kazan", 2121267);
      put("Moscow", 2122265);
      put("Nizhny Novgorod", 2122471);
      put("Novosibirsk", 2122541);
      put("Omsk", 2122641);
      put("Perm", 2122814);
      put("Rostov-on-Don", 2123177);
      put("Saint Petersburg", 2123260);
      put("Ufa", 2124045);
      put("Vladivostok", 2124288);
      put("Volgograd", 2124298);
      put("Karachi", 2211096);
      put("Lahore", 2211177);
      put("Multan", 2211269);
      put("Rawalpindi", 2211387);
      put("Faisalabad", 2211574);
      put("Muscat", 2268284);
      put("Nagpur", 2282863);
      put("Lucknow", 2295377);
      put("Kanpur", 2295378);
      put("Patna", 2295381);
      put("Ranchi", 2295383);
      put("Kolkata", 2295386);
      put("Srinagar", 2295387);
      put("Amritsar", 2295388);
      put("Jaipur", 2295401);
      put("Ahmedabad", 2295402);
      put("Rajkot", 2295404);
      put("Surat", 2295405);
      put("Bhopal", 2295407);
      put("Indore", 2295408);
      put("Thane", 2295410);
      put("Mumbai", 2295411);
      put("Pune", 2295412);
      put("Hyderabad", 2295414);
      put("Bangalore", 2295420);
      put("Chennai", 2295424);
      put("Mersin", 2323778);
      put("Adana", 2343678);
      put("Ankara", 2343732);
      put("Antalya", 2343733);
      put("Bursa", 2343843);
      put("Gaziantep", 2343999);
      put("Istanbul", 2344116);
      put("Izmir", 2344117);
      put("Kayseri", 2344174);
      put("Konya", 2344210);
      put("Okinawa", 2345896);
      put("Daejeon", 2345975);
      put("Auckland", 2348079);
      put("Albuquerque", 2352824);
      put("Atlanta", 2357024);
      put("Austin", 2357536);
      put("Baltimore", 2358820);
      put("Baton Rouge", 2359991);
      put("Birmingham", 2364559);
      put("Charlotte", 2378426);
      put("Cincinnati", 2380358);
      put("Cleveland", 2381475);
      put("Colorado Springs", 2383489);
      put("Columbus", 2383660);
      put("Dallas-Ft. Worth", 2388929);
      put("Denver", 2391279);
      put("Detroit", 2391585);
      put("El Paso", 2397816);
      put("Fresno", 2407517);
      put("Greensboro", 2414469);
      put("Harrisburg", 2418046);
      put("Honolulu", 2423945);
      put("Houston", 2424766);
      put("Indianapolis", 2427032);
      put("Jackson", 2428184);
      put("Jacksonville", 2428344);
      put("Kansas City", 2430683);
      put("Las Vegas", 2436704);
      put("Long Beach", 2441472);
      put("Los Angeles", 2442047);
      put("Louisville", 2442327);
      put("Memphis", 2449323);
      put("Mesa", 2449808);
      put("Miami", 2450022);
      put("Milwaukee", 2451822);
      put("Minneapolis", 2452078);
      put("Nashville", 2457170);
      put("New Haven", 2458410);
      put("New Orleans", 2458833);
      put("New York", 2459115);
      put("Norfolk", 2460389);
      put("Oklahoma City", 2464592);
      put("Omaha", 2465512);
      put("Orlando", 2466256);
      put("Philadelphia", 2471217);
      put("Phoenix", 2471390);
      put("Pittsburgh", 2473224);
      put("Portland", 2475687);
      put("Providence", 2477058);
      put("Raleigh", 2478307);
      put("Richmond", 2480894);
      put("Sacramento", 2486340);
      put("St. Louis", 2486982);
      put("Salt Lake City", 2487610);
      put("San Francisco", 2487956);
      put("San Jose", 2488042);
      put("Tallahassee", 2503713);
      put("Tampa", 2503863);
      put("Tucson", 2508428);
      put("Virginia Beach", 2512636);
      put("Osaka", 15015370);
      put("Kyoto", 15015372);
      put("Delhi", 20070458);
      put("United Arab Emirates", 23424738);
      put("Algeria", 23424740);
      put("Argentina", 23424747);
      put("Australia", 23424748);
      put("Austria", 23424750);
      put("Bahrain", 23424753);
      put("Belgium", 23424757);
      put("Belarus", 23424765);
      put("Brazil", 23424768);
      put("Chile", 23424782);
      put("Colombia", 23424787);
      put("Denmark", 23424796);
      put("Dominican Republic", 23424800);
      put("Ecuador", 23424801);
      put("Ireland", 23424803);
      put("France", 23424819);
      put("Ghana", 23424824);
      put("Germany", 23424829);
      put("Greece", 23424833);
      put("Guatemala", 23424834);
      put("Indonesia", 23424846);
      put("India", 23424848);
      put("Israel", 23424852);
      put("Italy", 23424853);
      put("Japan", 23424856);
      put("Jordan", 23424860);
      put("Kenya", 23424863);
      put("Korea", 23424868);
      put("Kuwait", 23424870);
      put("Lebanon", 23424873);
      put("Latvia", 23424874);
      put("Oman", 23424898);
      put("Mexico", 23424900);
      put("Malaysia", 23424901);
      put("Nigeria", 23424908);
      put("Netherlands", 23424909);
      put("Norway", 23424910);
      put("New Zealand", 23424916);
      put("Peru", 23424919);
      put("Pakistan", 23424922);
      put("Poland", 23424923);
      put("Panama", 23424924);
      put("Portugal", 23424925);
      put("Qatar", 23424930);
      put("Philippines", 23424934);
      put("Puerto Rico", 23424935);
      put("Russia", 23424936);
      put("Saudi Arabia", 23424938);
      put("South Africa", 23424942);
      put("Singapore", 23424948);
      put("Spain", 23424950);
      put("Sweden", 23424954);
      put("Switzerland", 23424957);
      put("Thailand", 23424960);
      put("Turkey", 23424969);
      put("Venezuela", 23424982);
      put("Vietnam", 23424984);
      put("Petaling", 56013632);
      put("Hulu Langat", 56013645);
      put("Scotland", 24875297);
      
    }
  };

  public static String getTrendsAsString(Trends trends) {
    int i = 0;
    StringBuilder sb = new StringBuilder();
    for (Trend trend : trends.getTrends()) {
      if (i < 5) {
        sb.append(String.format("%s,", trend.getName().replace("#", "")));
        i++;
      }
    }
    return sb.toString();
  }

  public static List<String> getListOfRandomTrends(Trends trends) {
    int i = 0;
    List<String> trendList = new ArrayList<>();
    for (Trend trend : trends.getTrends()) {
      if (i < 5) {
        trendList.add(trend.getName().replace("#", ""));
        i++;
      }
    }
    return trendList;
  }

  public static String getAplDocForTrends() {
    String content = "";
    try {
      content = SkillData.getFileContentAsString("trends.json");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return content;
  }

  public static String getAplDocforTweets() {
    String result;
    try {
      result = SkillData.getFileContentAsString("tweets.json");
    } catch (IOException e) {
      e.printStackTrace();
      throw new AskSdkException("Unable to read or deserialize template data", e);
    }
    return result;
  }

  /*
   * Helper method that checks if the device supports display capabilities
   */
  public static boolean supportsAPL(HandlerInput input) {
    SupportedInterfaces supportedInterfaces = input.getRequestEnvelope().getContext().getSystem().getDevice()
        .getSupportedInterfaces();
    AlexaPresentationAplInterface alexaPresentationAplInterface = supportedInterfaces.getAlexaPresentationAPL();
    return alexaPresentationAplInterface != null;
  }

  public static String getFileContentAsString(String fileName) throws IOException {
    File file = new File(fileName);
    return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
  }

  /*
   * Excludes tweets text that include http in the text to make it cleaner for
   * Alexa to read
   */
  public static List<Status> getFilteredStatuses(List<Status> statues) {
    List<Status> statusList = new ArrayList<>();
    for (Status status : statues) {
      if (!status.getText().contains("http")) {
        statusList.add(status);
      }
    }
    return statusList;
  }

  public static String getTweetsAsSpeechText(List<Status> statuses) {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    for (Status status : statuses) {
      if (i < 5) {
        if (null != status.getUser() && null != status.getUser().getLocation()
            && !status.getUser().getLocation().equals("")) {
          sb.append(String.format("From %s of %s. %s. ", getCleanedStringForSpeech(status.getUser().getName()),
              getCleanedStringForSpeech(status.getUser().getLocation()), getCleanedStringForSpeech(status.getText())));
        } else {
          sb.append(String.format("From %s. %s. ", getCleanedStringForSpeech(status.getUser().getName()),
              getCleanedStringForSpeech(status.getText())));
        }
        i++;
      }
    }
    return sb.toString();
  }

  /*
   * Helper function that checks if a users location is present to include in
   * Alexa's speech
   */
  private static String getTweetForSpeechText(Status status) {
    if (null != status.getUser() && null != status.getUser().getLocation()
        && !status.getUser().getLocation().equals("")) {
      return String.format("From %s of %s. %s. ", getCleanedStringForSpeech(status.getUser().getName()),
          getCleanedStringForSpeech(status.getUser().getLocation()), getCleanedStringForSpeech(status.getText()));
    } else {
      return String.format("From %s. %s. ", getCleanedStringForSpeech(status.getUser().getName()),
          getCleanedStringForSpeech(status.getText()));
    }
  }

  /*
   * Helper function that removes emojis, whitespace and maintains quotes so Alexa
   * can pronounce just the strings
   */
  private static String getCleanedStringForSpeech(String text) {
    String characterFilter = "[^\\p{L}\\p{M}\\p{N}\\p{P}\\p{Z}\\p{Cf}\\p{Cs}\\s]";
    return text.replace("&", "and").replace("#", "").replaceAll("\"", "\\\\\"").replaceAll("\\s{2,}", " ")
        .replaceAll(characterFilter, "").trim();
  }

  /*
   * Helper function that replaces large emptyspace with a single line break
   */
  private static String getCleanedTweetText(Status tweet) {
    return tweet.getText().replaceAll("\"", "\\\\\"").replaceAll("\\s{2,}", "\n").trim();
  }

  public static JsonObject getDataSourceForTweets(List<Status> tweets) {
    JsonObject object = new JsonObject();
    JsonObject firstTweet = new JsonObject();
    firstTweet.addProperty("text", tweets.get(0).getText());
    firstTweet.addProperty("name", String.format("<b>%s</b>", tweets.get(0).getUser().getName()));
    firstTweet.addProperty("handle", String.format("@%s", tweets.get(0).getUser().getScreenName()));
    firstTweet.addProperty("imageUrl", tweets.get(0).getUser().getProfileImageURLHttps());
    firstTweet.add("properties", getTweetSsmlProperty(getTweetForSpeechText(tweets.get(0))));
    firstTweet.add("transformers", getTransformers("firstTweetAsSpeech"));
    object.add("firstTweet", firstTweet);

    JsonObject secondTweet = new JsonObject();
    object.add("secondTweet", secondTweet);
    secondTweet.addProperty("text", tweets.get(1).getText());
    secondTweet.addProperty("name", String.format("<b>%s</b>", tweets.get(1).getUser().getName()));
    secondTweet.addProperty("handle", String.format("@%s", tweets.get(1).getUser().getScreenName()));
    secondTweet.addProperty("imageUrl", tweets.get(1).getUser().getProfileImageURLHttps());
    secondTweet.add("properties", getTweetSsmlProperty(getTweetForSpeechText(tweets.get(1))));
    secondTweet.add("transformers", getTransformers("secondTweetAsSpeech"));
    object.add("secondTweet", secondTweet);

    JsonObject thirdTweet = new JsonObject();
    object.add("thirdTweet", thirdTweet);
    thirdTweet.addProperty("text", tweets.get(2).getText());
    thirdTweet.addProperty("name", String.format("<b>%s</b>", tweets.get(2).getUser().getName()));
    thirdTweet.addProperty("handle", String.format("@%s", tweets.get(2).getUser().getScreenName()));
    thirdTweet.addProperty("imageUrl", tweets.get(2).getUser().getProfileImageURLHttps());
    thirdTweet.add("properties", getTweetSsmlProperty(getTweetForSpeechText(tweets.get(2))));
    thirdTweet.add("transformers", getTransformers("thirdTweetAsSpeech"));
    object.add("thirdTweet", thirdTweet);

    return object;
  }

  private static JsonObject getTweetSsmlProperty(String text) {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("tweetSsml", String.format("<speak>%s</speak>", text));
    return jsonObject;
  }

  private static JsonArray getTransformers(String label) {
    JsonArray array = new JsonArray();
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("inputPath", "tweetSsml");
    jsonObject.addProperty("outputName", label);
    jsonObject.addProperty("transformer", "ssmlToSpeech");
    array.add(jsonObject);
    return array;
  }

  public static JsonObject getDataSourceForTrends(String location, List<String> trends) {
    JsonObject jsonObject = new JsonObject();
    JsonObject data = new JsonObject();
    data.addProperty("location", String.format("<b>Top trends for %s</b>", location));
    data.addProperty("firstTrend", String.format("1. #%s", trends.get(0)));
    data.addProperty("secondTrend", String.format("2. #%s", trends.get(1)));
    data.addProperty("thirdTrend", String.format("3. #%s", trends.get(2)));
    data.addProperty("fourthTrend", String.format("4. #%s", trends.get(3)));
    data.addProperty("fifthTrend", String.format("5. #%s", trends.get(4)));
    
    
    jsonObject.add("data", data);
    return jsonObject;
  }
}
