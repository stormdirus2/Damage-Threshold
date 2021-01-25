package dev.cammiescorner.dt.mixin;

import net.minecraft.entity.DamageUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(DamageUtil.class)
public class DamageUtilMixin
{
	/**
	 * @author Cammie
	 */
	@Overwrite
	public static float getDamageLeft(float damage, float armor, float armorToughness)
	{
		return Math.max(1, damage - (armor / (2 - Math.min(1, armorToughness / 20))));
	}
}
