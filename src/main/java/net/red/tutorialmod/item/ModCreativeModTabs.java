package net.red.tutorialmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.red.tutorialmod.TutorialMod;
import net.red.tutorialmod.block.ModBlock;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS=
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            ()-> CreativeModeTab.builder().icon(()->new ItemStack(ModItems.Meteorite.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.Meteorite.get());
                        output.accept(ModItems.Raw_Meteorite.get());
                        output.accept(ModBlock.Meteorite_Block.get());
                        output.accept(ModBlock.Raw_Meteorite_Block.get());
                        output.accept(ModBlock.Meteorite_Ore.get());
                        output.accept(ModBlock.DeepSlate_Meteorite_Ore.get());
                        output.accept(ModBlock.End_Meteorite_Ore.get());
                        output.accept(ModItems.Meteorite_Detector.get());
                        output.accept(ModBlock.Sound_Block.get());
                        output.accept(ModItems.Starfruit.get());
                        output.accept(ModItems.StarFrO_ouit.get());
                        output.accept(ModItems.BlackStrawStarFruit.get());
                        output.accept(ModBlock.Meteorite_Bricks.get());
                        output.accept(ModBlock.Meteorite_Bricks_Slab.get());
                        output.accept(ModBlock.Meteorite_Bricks_Stairs.get());
                        output.accept(ModBlock.Meteorite_Bricks_Wall.get());
                        output.accept(ModBlock.Meteorite_Bricks_Wall_Gate.get());
                        output.accept(ModBlock.Meteorite_Bricks_Button.get());
                        output.accept(ModBlock.Meteorite_Bricks_Pressure_Plate.get());
                        output.accept(ModBlock.Meteorite_Bricks_Door.get());
                        output.accept(ModBlock.Meteorite_Bricks_TrapDoor.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
