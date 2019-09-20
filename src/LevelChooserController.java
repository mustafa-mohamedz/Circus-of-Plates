import eg.edu.alexu.csd.oop.game.world.levels.EasyLevel;
import eg.edu.alexu.csd.oop.game.world.levels.HardLevel;
import eg.edu.alexu.csd.oop.game.world.levels.NormalLevel;

public class LevelChooserController {
    public void easy() {
        Game.play(new EasyLevel());
    }

    public void normal() {
        Game.play(new NormalLevel());
    }

    public void hard() {
        Game.play(new HardLevel());
    }
}
