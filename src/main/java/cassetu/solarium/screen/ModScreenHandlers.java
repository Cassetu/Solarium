package cassetu.solarium.screen;

import cassetu.solarium.Solarium;
import cassetu.solarium.screen.custom.DissolverScreen;
import cassetu.solarium.screen.custom.DissolverScreenHandler;
import cassetu.solarium.screen.custom.GrowthChamberScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {

    public static final ScreenHandlerType<GrowthChamberScreenHandler> GROWTH_CHAMBER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Solarium.MOD_ID, "growth_chamber_screen_handler"),
                    new ExtendedScreenHandlerType<>(GrowthChamberScreenHandler::new, BlockPos.PACKET_CODEC));

    public static final ScreenHandlerType<DissolverScreenHandler> DISSOLVER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Solarium.MOD_ID, "dissolver_screen_handler"),
                    new ExtendedScreenHandlerType<>(DissolverScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
        Solarium.LOGGER.info("Registering Screen Handlers for " + Solarium.MOD_ID);
    }
}
