
public class HelloPlugin implements Plugin
{
    public void invoke()
    {
        System.out.println("Hello world");
    }
    public String toString()
    {
        return "TestModule, version 1!";
    }
}