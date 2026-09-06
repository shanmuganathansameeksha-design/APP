interface Confidential
{
}

class PersonalDocument
{
    String name;

    PersonalDocument(String name)
    {
        this.name = name;
    }
}

class OfficialDocument implements Confidential
{
    String name;

    OfficialDocument(String name)
    {
        this.name = name;
    }
}

class PublicDocument
{
    String name;

    PublicDocument(String name)
    {
        this.name = name;
    }
}

class SecretDocument implements Confidential
{
    String name;

    SecretDocument(String name)
    {
        this.name = name;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Object[] documents =
        {
            new PersonalDocument("Personal File"),
            new OfficialDocument("Official Report"),
            new PublicDocument("Public Notice"),
            new SecretDocument("Secret File")
        };

        for (Object document : documents)
        {
            if (document instanceof Confidential)
            {
                System.out.println("Confidential Document");
            }
            else
            {
                System.out.println("Non-Confidential Document");
            }
        }
    }
}