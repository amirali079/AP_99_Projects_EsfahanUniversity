import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {

    private final int x = 12;
    private final int y = 7;
    private final HashMap<Hero , String> players;
    private ArrayList<Hero> heroes;
    private Castle team1Castle;
    private Castle team2Castle;
    public gamePage gPage;

    public static int FireT1;
    public static int FireT2;
    public static int IceT1;
    public static int IceT2;
    public static int WindT1;
    public static int WindT2;
    public static int EarthT1;
    public static int EarthT2;
    public static int T1Score;
    public static int T2Score;

    public static boolean status = false;

    public Game(gamePage gamePage) throws IOException {
        gPage = gamePage;
        players = new HashMap<>();
        heroes = new ArrayList<>();

        if (new File("save.txt").exists()) {
            readFile();
        }
    }

    public void startGame() throws InterruptedException {

        Thread.sleep(1000);

        if (team1Castle == null || team2Castle == null)
            throw new RuntimeException("Both Teams Should Have Castle");
        if (heroes.size() == 0)
            throw new RuntimeException("There is No Hero in the Game");

        gPage.getCanvas().add(team2Castle.getBar());
        gPage.getCanvas().add(team1Castle.getBar());
        status = true;

        for (Hero xx: players.keySet()) {
            if (players.get(xx).equals("t1"))
                xx.startMove(team2Castle , players ,gPage);
            else
                xx.startMove(team1Castle , players , gPage);
        }


        new Thread(() -> {
            while (true) {
                System.out.print("");
                if (!status || players.keySet().size() == 0) {
                    status = false;
                    String message;
                    if (team2Castle.getHealth() <= 0) message = "team 1 won";
                    else message = "team 2 won";
                    JOptionPane.showMessageDialog (null, message,
                            "End", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        if (gPage.scorePage != null && gPage.scorePage.isDisplayable())
                            gPage.scorePage.dispose();
                        writeFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
            String[] options = {"New Game", "Exit!" };
            int x = JOptionPane.showOptionDialog(null, "Choose",
                    "New Game or Exit",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
            gPage.dispose();
            if (x == 0) SwingUtilities.invokeLater(() -> {
                try {
                    new gamePage().setVisible(true);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            else System.exit(0);
        }).start();

    }

    public static void writeFile() throws IOException {
        FileWriter fileWriter = new FileWriter("save.txt");
        fileWriter.write(FireT1 + "\n");
        fileWriter.write(FireT2 + "\n");
        fileWriter.write(IceT1 + "\n");
        fileWriter.write(IceT2 + "\n");
        fileWriter.write(WindT1 + "\n");
        fileWriter.write(WindT2 + "\n");
        fileWriter.write(EarthT1 + "\n");
        fileWriter.write(EarthT2 + "\n");
        fileWriter.write(T1Score + "\n");
        fileWriter.write(T2Score + "\n");
        fileWriter.flush();
        fileWriter.close();
    }

    private void readFile() throws IOException {
        FileReader fileReader = new FileReader("save.txt");
        Scanner scanner = new Scanner(fileReader);
        FireT1 = Integer.parseInt(scanner.nextLine());
        FireT2 = Integer.parseInt(scanner.nextLine());
        IceT1 = Integer.parseInt(scanner.nextLine());
        IceT2 = Integer.parseInt(scanner.nextLine());
        WindT1 = Integer.parseInt(scanner.nextLine());
        WindT2 = Integer.parseInt(scanner.nextLine());
        EarthT1 = Integer.parseInt(scanner.nextLine());
        EarthT2 = Integer.parseInt(scanner.nextLine());
        T1Score = Integer.parseInt(scanner.nextLine());
        T2Score = Integer.parseInt(scanner.nextLine());
        scanner.close();
        fileReader.close();
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public HashMap<Hero, String> getPlayers() {
        return players;
    }



    public Castle getTeam1Castle() {
        return team1Castle;
    }

    public Castle getTeam2Castle() {
        return team2Castle;
    }

    public void addHeroTeam1(Hero hero) {
        if (status) throw new RuntimeException("You Cannot Add Hero Now");
        if (hero.getX() > 100) throw new RuntimeException("Entered X is not Valid");
        boolean flag = true;
        for (Hero x : players.keySet())
            if (x.getX() == hero.getX() && x.getY() == hero.getY()) {
                flag = false;
                break;
            }
        if (team1Castle != null && team1Castle.getX() == hero.getX() && team1Castle.getY() == hero.getY()) flag = false;
        if (!flag) throw new RuntimeException("this index is taken");
        heroes.add(hero);
        players.put(hero , "t1");
    }

    public void addHeroTeam2(Hero hero) {
        if (status) throw new RuntimeException("You Cannot Add Hero Now");
        if (hero.getX() < (this.x - 2) * 100) throw new RuntimeException("Entered X is not Valid");
        boolean flag = true;
        for (Hero x : players.keySet())
            if (x.getX() == hero.getX() && x.getY() == hero.getY()) {
                flag = false;
                break;
            }
        if (team2Castle != null && team2Castle.getX() == hero.getX() && team2Castle.getY() == hero.getY()) flag = false;
        if (!flag) throw new RuntimeException("this index is taken");
        heroes.add(hero);
        players.put(hero , "t2");
    }

    public void setTeam1Castle(Castle t1Castle) {
        if (status) throw new RuntimeException("You Cannot Add Castle Now");
        boolean flag = true;
        for (Hero x : players.keySet())
            if (x.getX() == t1Castle.getX() && x.getY() == t1Castle.getY()) {
                flag = false;
                break;
            }
        if (!flag) throw new RuntimeException("this index is taken");
        if (t1Castle.getX() != 0) throw new RuntimeException("Entered X is not Valid");
        this.team1Castle = t1Castle;
    }

    public void setTeam2Castle(Castle t2Castle) {
        if (status) throw new RuntimeException("You Cannot Add Castle Now");
        boolean flag = true;
        for (Hero x : players.keySet())
            if (x.getX() == t2Castle.getX() && x.getY() == t2Castle.getY()) {
                flag = false;
                break;
            }
        if (!flag) throw new RuntimeException("this index is taken");
        if (t2Castle.getX() != (this.x - 1) * 100) throw new RuntimeException("Entered X is not Valid");
        this.team2Castle = t2Castle;
    }
}