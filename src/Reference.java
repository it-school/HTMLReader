public class Reference
{
    String text;
    String href;

    public Reference(String text, String href)
    {
        this.text = text;
        this.href = href;
    }

    @Override
    public String toString()
    {
        return "Reference{" +
                "text='" + text + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
