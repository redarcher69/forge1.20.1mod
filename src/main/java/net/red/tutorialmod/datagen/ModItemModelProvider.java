package net.red.tutorialmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.red.tutorialmod.TutorialMod;
import net.red.tutorialmod.block.ModBlock;
import net.red.tutorialmod.item.ModItems;


public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.Meteorite);
        simpleItem(ModItems.Raw_Meteorite);

        simpleItem(ModItems.Meteorite_Detector);
        simpleItem(ModItems.Starfruit);
        simpleItem(ModItems.StarFrO_ouit);
        simpleItem(ModItems.BlackStrawStarFruit);

        simpleBlockItem(ModBlock.Meteorite_Bricks_Door);

        wallItem(ModBlock.Meteorite_Bricks_Wall, ModBlock.Meteorite_Bricks);
        buttonItem(ModBlock.Meteorite_Bricks_Button, ModBlock.Meteorite_Bricks);

        evenSimplerBlockItem(ModBlock.Meteorite_Bricks_Stairs);
        evenSimplerBlockItem(ModBlock.Meteorite_Bricks_Slab);
        evenSimplerBlockItem(ModBlock.Meteorite_Bricks_Pressure_Plate);
        evenSimplerBlockItem(ModBlock.Meteorite_Bricks_Wall_Gate);

        trapdoorItem(ModBlock.Meteorite_Bricks_TrapDoor);
    }

    private void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(TutorialMod.MOD_ID,"block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    private void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(TutorialMod.MOD_ID,"block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    private void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(TutorialMod.MOD_ID,"block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(TutorialMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TutorialMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TutorialMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
