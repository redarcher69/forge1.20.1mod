package net.red.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties StarFruit = new FoodProperties.Builder().nutrition(3).fast()
            .saturationMod(0.6f).effect(()->new MobEffectInstance(MobEffects.GLOWING,200),0.4f).
            build();
    public static final FoodProperties StarFrO_ouit = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.8f).effect(()->new MobEffectInstance(MobEffects.LEVITATION,200),0.6f).
            effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST,1000,3),1f).build();
    public static final FoodProperties BlackStrawStarFruit = new FoodProperties.Builder().nutrition(10).fast()
            .saturationMod(1.3f).effect(()->new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,2000),1f).
            effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST,4000,5),1f)
            .effect(()-> new MobEffectInstance(MobEffects.LUCK,10000,3),1f).alwaysEat()
            .build();

}
