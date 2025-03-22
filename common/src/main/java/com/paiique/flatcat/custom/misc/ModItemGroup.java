package com.paiique.flatcat.custom.misc;

import com.paiique.flatcat.FlatCats;
import com.paiique.flatcat.registry.common.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

import java.util.Optional;

public class ModItemGroup {
    private static final Text TITLE = Text.translatable("itemGroup.flatcat.main");
    public static final ItemGroup FLAT_CAT = register("main", ItemGroup.create(ItemGroup.Row.TOP, 1)
            .displayName(TITLE)
            //.icon(ModItems.COOKED_FLAT_FISH.get()::getDefaultStack)
            .entries(((displayContext, entries) -> Registries.ITEM.getIds()
                    .stream()
                    .filter(key -> key.getNamespace().equals(FlatCats.MOD_ID))
                    .map(Registries.ITEM::get)
                    .forEach(entries::add))
            ).build());

    public static <T extends ItemGroup> T register(String name, T itemGroup) {
       return Registry.register(Registries.ITEM_GROUP, FlatCats.MOD_ID + ":" + name, itemGroup);
    }

    public static void init() {}
}
