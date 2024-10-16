package net.red.tutorialmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.red.tutorialmod.TutorialMod;
import net.red.tutorialmod.block.ModBlock;
import net.red.tutorialmod.item.ModItems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static List<ItemLike> METEORITE_SMELTABLES = List.of(ModItems.Raw_Meteorite.get(),
            ModBlock.Meteorite_Ore.get(),ModBlock.DeepSlate_Meteorite_Ore.get(),
            ModBlock.End_Meteorite_Ore.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, METEORITE_SMELTABLES, RecipeCategory.MISC, ModItems.Meteorite.get(),0.25f,100,"meteorite");
        oreSmelting(pWriter, METEORITE_SMELTABLES, RecipeCategory.MISC, ModItems.Meteorite.get(),0.25f,200,"meteorite");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.Meteorite_Block.get())
                .pattern("$$$")
                .pattern("$$$")
                .pattern("$$$")
                .define('$',ModItems.Meteorite.get())
                .unlockedBy(getHasName(ModItems.Meteorite.get()),has(ModItems.Meteorite.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.Raw_Meteorite_Block.get())
                .pattern("$$$")
                .pattern("$$$")
                .pattern("$$$")
                .define('$',ModItems.Raw_Meteorite.get())
                .unlockedBy(getHasName(ModItems.Raw_Meteorite.get()),has(ModItems.Raw_Meteorite.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.Meteorite_Detector.get())
                .pattern("$ $")
                .pattern("$ $")
                .pattern(" S ")
                .define('$',ModItems.Meteorite.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.Meteorite.get()),has(ModItems.Meteorite.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Meteorite.get(),9)
                .requires(ModBlock.Meteorite_Block.get())
                .unlockedBy(getHasName(ModBlock.Meteorite_Block.get()),has(ModBlock.Meteorite_Block.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Raw_Meteorite.get(),9)
                .requires(ModBlock.Raw_Meteorite_Block.get())
                .unlockedBy(getHasName(ModBlock.Raw_Meteorite_Block.get()),has(ModBlock.Raw_Meteorite_Block.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, TutorialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
