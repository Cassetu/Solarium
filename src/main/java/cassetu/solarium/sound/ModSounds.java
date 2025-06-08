package cassetu.solarium.sound;

import cassetu.solarium.Solarium;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent DISSOLVER_OPEN = registerSoundEvent("dissolver_open");
    public static final SoundEvent GROWTH_CHAMBER_OPEN = registerSoundEvent("growth_chamber_open");

    public static final SoundEvent BLIGHTED_SILT_STEP = registerSoundEvent("blighted_silt_step");
    public static final SoundEvent BLIGHTED_SILT_BREAK = registerSoundEvent("blighted_silt_break");
    public static final SoundEvent BLIGHTED_SILT_PLACE = registerSoundEvent("blighted_silt_place");
    public static final SoundEvent BLIGHTED_SILT_HIT = registerSoundEvent("blighted_silt_hit");
    public static final SoundEvent BLIGHTED_SILT_FALL = registerSoundEvent("blighted_silt_fall");

    public static final BlockSoundGroup BLIGHTED_SILT_SOUND = new BlockSoundGroup(1f, 1f,
            BLIGHTED_SILT_BREAK, BLIGHTED_SILT_STEP, BLIGHTED_SILT_PLACE, BLIGHTED_SILT_HIT, BLIGHTED_SILT_FALL);

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Solarium.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        Solarium.LOGGER.info("Registering Mod Sounds for " + Solarium.MOD_ID);
    }
}
