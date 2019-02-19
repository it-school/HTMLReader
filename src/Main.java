import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) {
        String url = "https://www.bbc.com/news";
        System.out.println("Fetching data from URI: "  + url);

        References hlinks = new References();

        int n = 0;
        try
        {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("ul");
            for (Element link : links)
            {
                n++;
                if (n == 2)
                {
                    //System.out.println(link);
                    Elements uls = link.select("li");
                    for (Element ul: uls)
                    {
                        // System.out.println(ul);
                        Element a = ul.child(0);
                        hlinks.list.add(new Reference(a.text(), a.attr("href")));
                        //System.out.println(a.text() + '\t' + a.attr("href"));
                    }
                }
            }

            for (Reference r: hlinks.list)
            {
                if (r.text.contains("r"))
                System.out.println(r);
            }
        }
        catch(Exception exc)
        {
            System.out.println("Page loading error!!!");
        }
    }
}
