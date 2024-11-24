package net.paiique.flatcat.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.paiique.flatcat.FlatCat;

public class ModBlocks {
    public static DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, FlatCat.MODID);

    public static RegistryObject<Block> LOOK_INSIDE_CAT = BLOCK.register("ooia_cat", () -> new Block(BlockBehaviour.Properties.of()));

    public static void register(IEventBus eventBus) {
        BLOCK.register(eventBus);
    }


}
