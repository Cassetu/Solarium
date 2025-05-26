package cassetu.solarium;

import cassetu.solarium.block.entity.ModBlockEntities;
import cassetu.solarium.block.entity.custom.GrowthChamberBlockEntity;
import cassetu.solarium.block.entity.renderer.PedestalBlockEntityRenderer;
import cassetu.solarium.screen.ModScreenHandlers;
import cassetu.solarium.screen.custom.GrowthChamberScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class SolariumClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BE, PedestalBlockEntityRenderer::new);
        HandledScreens.register(ModScreenHandlers.GROWTH_CHAMBER_SCREEN_HANDLER, GrowthChamberScreen::new);
    }
}
