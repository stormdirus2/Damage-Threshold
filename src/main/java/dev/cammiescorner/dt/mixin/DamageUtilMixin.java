package dev.cammiescorner.dt.mixin;

import net.minecraft.entity.DamageUtil;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DamageUtil.class)
public class DamageUtilMixin
{
	@Inject(method = "getDamageLeft", at = @At("HEAD"), cancellable = true)
	private static void getDamageLeft(float damage, float armor, float armorToughness, CallbackInfoReturnable<Float> info)
	{
		float half = 0.5;
		info.setReturnValue(Math.max(half, damage - (armor / (3 - Math.min(2, armorToughness / 10)))));
	}
}
