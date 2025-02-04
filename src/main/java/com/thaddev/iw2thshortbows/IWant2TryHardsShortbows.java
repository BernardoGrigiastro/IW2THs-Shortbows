package com.thaddev.iw2thshortbows;

import com.mojang.logging.LogUtils;
import com.thaddev.iw2thshortbows.mechanics.inits.BlockInit;
import com.thaddev.iw2thshortbows.mechanics.inits.ConfiguredFeaturesInit;
import com.thaddev.iw2thshortbows.mechanics.inits.EffectInit;
import com.thaddev.iw2thshortbows.mechanics.inits.EnchantmentInit;
import com.thaddev.iw2thshortbows.mechanics.inits.EntityTypeInit;
import com.thaddev.iw2thshortbows.mechanics.inits.GlobalLootModifierInit;
import com.thaddev.iw2thshortbows.mechanics.inits.ItemInit;
import com.thaddev.iw2thshortbows.mechanics.inits.PlacedFeaturesInit;
import com.thaddev.iw2thshortbows.mechanics.inits.PotionInit;
import com.thaddev.iw2thshortbows.mechanics.inits.PotionRecipeInit;
import com.thaddev.iw2thshortbows.mechanics.inits.RecipeSerializerInit;
import net.minecraft.client.Minecraft;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(IWant2TryHardsShortbows.MODID)
public class IWant2TryHardsShortbows {
    public static final String MODID = "iw2thshortbows";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static IWant2TryHardsShortbows instance;

    public Minecraft mc;

    public IWant2TryHardsShortbows() {
        instance = this;
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        ItemInit.ITEMS.register(modEventBus);
        EntityTypeInit.ENTITIES.register(modEventBus);
        EnchantmentInit.ENCHANTMENTS.register(modEventBus);
        EffectInit.MOB_EFFECTS.register(modEventBus);
        PotionInit.POTIONS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        ConfiguredFeaturesInit.CONFIGURED_FEATURES.register(modEventBus);
        PlacedFeaturesInit.PLACED_FEATURES.register(modEventBus);
        GlobalLootModifierInit.GLOBAL_LOOT_MODIFIERS.register(modEventBus);
        RecipeSerializerInit.RECIPES.register(modEventBus);
    }

    public void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(PotionRecipeInit::register);
    }
}
