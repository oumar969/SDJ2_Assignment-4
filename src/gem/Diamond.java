package gem;

public class Diamond implements Gem
{
  @Override public int getValue()
  {
    return 100;
  }

  @Override public String getGemType()
  {
    return "Diamond";
  }
}
