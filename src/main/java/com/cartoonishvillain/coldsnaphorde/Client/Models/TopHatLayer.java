package com.cartoonishvillain.coldsnaphorde.Client.Models;

import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Register;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;


public class TopHatLayer <T extends LivingEntity, M extends BipedModel<T>> extends LayerRenderer<T, M> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/armor/tophat.png");
    private final TopHatModel<T> topHatModel = new TopHatModel();

    public TopHatLayer(LivingRenderer<T, M> wearer) {
        super(wearer);
    }



    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if(entity.getItemBySlot(EquipmentSlotType.HEAD).getItem().equals(Register.TOPHAT.get())){
            matrixStackIn.pushPose();
            this.getParentModel().head.translateAndRotate(matrixStackIn);
            renderColoredCutoutModel(topHatModel, TEXTURE, matrixStackIn, bufferIn, packedLightIn, entity, 1f, 1f, 1f);
            matrixStackIn.popPose();
        }
    }
}