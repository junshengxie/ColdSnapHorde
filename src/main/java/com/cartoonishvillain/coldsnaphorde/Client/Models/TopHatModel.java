package com.cartoonishvillain.coldsnaphorde.Client.Models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

public class TopHatModel<T extends LivingEntity> extends EntityModel<T> {
    final ModelRenderer brim;
    final ModelRenderer hat;

    public TopHatModel() {
        brim = new ModelRenderer(this, 63, 13);
        hat = new ModelRenderer(this, 31, 11);
        texWidth = 128;
        texHeight = 128;
        brim.setPos(0, -7,0);
        brim.addChild(hat);
        brim.addBox(-5.0F, -8.1F, -5.0F, 10.0F, 2.0F, 10.0F, -0.5F, false);
        hat.addBox(-4.0F, -13.1F, -4.0F, 8.0F, 6.0F, 8.0F, -0.5F, false);

    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//        this.hat.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
//        this.hat.rotateAngleX = headPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        brim.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }
//    EntityAttributeCreationEvent
}