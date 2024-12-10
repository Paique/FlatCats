package net.paiique.flatcat.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.paiique.flatcat.FlatCat;

public class ModSounds {
    public static DeferredRegister<SoundEvent> SOUND = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, FlatCat.MODID);

    public static RegistryObject<SoundEvent> registerSoundEvents(String name) {
       return SOUND.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(FlatCat.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND.register(eventBus);
    }
}
