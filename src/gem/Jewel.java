package gem;

public class Jewel implements Gem
{
  @Override public int getValue()
  {
    return 40;
  }

  @Override public String getGemType()
  {
    return "Jewel";
  }
}
