import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TreeSet<Team> league = new TreeSet<>();
        int teamNumber = 0;
        Scanner s = new Scanner(System.in);

        do
        {
            try
            {
                System.out.print("Kaç takımla bir lig oluşturmak istiyorsunuz? (100 max): ");
                teamNumber = s.nextInt();
            }
            catch (Exception e)
            {
                System.out.println("Uygun olmayan bir girişte bulundunuz.");
                s.next();
            }
        } while (teamNumber <= 0 || teamNumber > 100);

        for (int i = 0; i < teamNumber;i++)
        {
            System.out.print((i + 1) + ". takım ismini giriniz: ");
            league.add(new Team(s.next()));
        }

        if (league.size() % 2 == 1)
        {
            league.add(new Team("Bay"));
        }

        List<Team> list = new ArrayList<Team>(league);

        System.out.println();
        System.out.println("Takımlar");
        for (Team t : list)
        {
            System.out.println("- " + t.getName());
        }


        Team constant = list.get(0);
        list.remove(list.get(0));


        for (int i = 0; i < list.size() * 2; i++)
        {
            System.out.println();
            System.out.println("Round " + (i + 1));

            if (i < list.size())
            {
                System.out.println(constant.getName() + " vs " + list.get(0).getName());
                for (int j = 1; j < (list.size() + 1) / 2;j++)
                {
                    System.out.println(list.get(j).getName() + " vs " + list.get(list.size() - j).getName());
                }
            }
            else
            {
                System.out.println(list.get(0).getName() + " vs " + constant.getName());
                for (int j = 1; j < (list.size() + 1) / 2;j++)
                {
                    System.out.println(list.get(list.size() - j).getName() + " vs " + list.get(j).getName());
                }
            }

            Team hold = list.get(0);
            for (int j = 0; j < list.size() - 1;j++)
            {
                list.set(j,list.get(j+1));
            }
            list.set(list.size() - 1,hold);

        }


    }

}
