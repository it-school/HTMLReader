import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String url = "https://www.bbc.com/news";
        System.out.println("Fetching %s..."  + url);

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
        /*
        Elements links = doc.select("a[href]");
        Elements media = doc.select("[src]");
        Elements imports = doc.select("link[href]");

        print("\nMedia: (%d)", media.size());
        for (Element src : media) {
            if (src.tagName().equals("img"))
                print(" * %s: <%s> %sx%s (%s)",
                        src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
                        trim(src.attr("alt"), 20));
            else
                print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
        }

        print("\nImports: (%d)", imports.size());
        for (Element link : imports) {
            print(" * %s <%s> (%s)", link.tagName(),link.attr("abs:href"), link.attr("rel"));
        }

        print("\nLinks: (%d)", links.size());
        for (Element link : links) {
            print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
        }
*/

        }
        catch(Exception exc)
        {
            System.out.println("Error loading page");
        }
    }

}

