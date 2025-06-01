package cassetu.solarium.compat;

import cassetu.solarium.Solarium;
import cassetu.solarium.block.ModBlocks;
import cassetu.solarium.screen.custom.DissolverScreenHandler;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.LinkedList;
import java.util.List;

public class DissolverCategory implements DisplayCategory<BasicDisplay> {
    public static final Identifier TEXTURE = Identifier.of(Solarium.MOD_ID,
            "textures/gui/dissolver/dissolver_gui.png");
    public static final CategoryIdentifier<DissolverDisplay> DISSOLVER =
            CategoryIdentifier.of(Solarium.MOD_ID, "dissolver");

    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
    return DISSOLVER;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("block.solarium.dissolver");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.DISSOLVER.asItem().getDefaultStack());
    }

    // Done with the help:
    // https://github.com/TeamGalacticraft/Galacticraft/tree/main (MIT License)
    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 87, bounds.getCenterY() - 35);
        List<Widget> widgets = new LinkedList<>();

        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(startPoint.x, startPoint.y, 175, 82)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 54, startPoint.y + 34))
                .entries(display.getInputEntries().get(0)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 104, startPoint.y + 34))
                .entries(display.getOutputEntries().get(0)).markOutput());

        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 90;
    }
}
