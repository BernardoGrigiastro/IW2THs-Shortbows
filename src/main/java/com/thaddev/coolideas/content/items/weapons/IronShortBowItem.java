package com.thaddev.coolideas.content.items.weapons;

import com.thaddev.coolideas.util.ColorUtils;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.thaddev.coolideas.util.ColorUtils.component;

public class IronShortBowItem extends ShortBowBase {
    public IronShortBowItem(Settings settings) {
        super(settings);
    }

    @Override
    public double getPowerBaseDamage(double baseDamage, int powerLevel) {
        return baseDamage + (double) powerLevel * 0.75D + 0.75D;
    }

    @Override
    public float getCritChance() {
        return 0.2f;
    }

    @Override
    public float getRubberbandHitChance() {
        return 0.2f;
    }

    @Override
    public int getTicksOnFire() {
        return 100;
    }

    @Override
    public float getRubberbandHitDamage() {
        return 6f;
    }

    @Override
    public void appendTooltip(@NotNull ItemStack stack, @Nullable World world, @NotNull List<Text> tooltip, @NotNull TooltipContext context) {
        tooltip.add(component(ColorUtils.fromNoTag("(%$white)Shoots Instantly! (%$italic)Make sure to not hit yourself!")));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public int getRange() {
        return 20;
    }

//    @Override
//    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
//        return (enchantment == Enchantments.MULTISHOT) || super.canApplyAtEnchantingTable(stack, enchantment);
//    }

    @Override
    public boolean canRepair(ItemStack thisItem, ItemStack repairItem) {
        return /*repairItem.getItem() == ItemInit.IRON_ROD.get() || repairItem.getItem() == ItemInit.LATEX_BAND.get()
                || repairItem.getItem() == ItemInit.RUBBER_BAND.get() || */super.canRepair(thisItem, repairItem);
    }

    @Override
    public boolean canHomeArrows() {
        return false;
    }
}
