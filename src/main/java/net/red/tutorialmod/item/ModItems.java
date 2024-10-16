package net.red.tutorialmod.item;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.red.tutorialmod.TutorialMod;
import net.red.tutorialmod.item.custom.MeteorDetector;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> Meteorite = ITEMS.register("meteorite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Raw_Meteorite = ITEMS.register("raw_meteorite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Meteor_Detector = ITEMS.register("meteor_detector",
            () -> new MeteorDetector(new Item.Properties().durability(50)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
