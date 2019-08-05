public class GameEngine {
    private static GameEngine ourInstance = new GameEngine();

    public static GameEngine getInstance() {
        return ourInstance;
    }

    private GameEngine() {
    }
}
