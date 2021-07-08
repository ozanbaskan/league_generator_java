

public class Team implements Comparable<Team> {

    private String name;

    public Team(String name)
    {
        this.name = name;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Team o) {
        int random = (int) Math.round(Math.random());
        if (random == 0) return -1;
        return random;
    }
}
