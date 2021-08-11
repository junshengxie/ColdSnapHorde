package com.cartoonishvillain.coldsnaphorde.Client.Models.StandardModel;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapGunner;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

public class ColdSnapGunnerModel<C extends GenericHordeMember> extends EntityModel<ColdSnapGunner> {
    private static final String LOWBODY = "lowbody";
    private static final String BODY = "body";
    private static final String LEFTHAND = "lefthand";
    private static final String HEAD = "head";
    private static final String HAT = "hat";
    private static final String RIGHTHAND = "righthand";
    private static final String GUN = "gun";

    private final ModelPart lowbody;
    private final ModelPart body;
    private final ModelPart left_hand;
    private final ModelPart head;
    private final ModelPart hat;
    private final ModelPart right_hand;
    private final ModelPart gun;

    public ColdSnapGunnerModel(ModelPart part) {
        super(RenderType::entityCutoutNoCull);
        this.head = part.getChild(HEAD);
        this.lowbody = part.getChild(LOWBODY);
        this.body = part.getChild(BODY);
        this.left_hand = part.getChild(LEFTHAND);
        this.hat = part.getChild(HAT);
        this.right_hand = part.getChild(RIGHTHAND);
        this.gun = part.getChild(GUN);
        head.children.put(HAT, hat);
        right_hand.children.put(GUN, gun);
        lowbody.setPos(0.0F, 24.0F, 0.0F);
        body.setPos(0.0F, 13.0F, 0.0F);
        left_hand.setPos(4.5f, 5.7f, 0.0f);
        left_hand.setRotation(0.0F, 0.0F, 1.1345F);
        head.setPos(0.0F, 4.0F, 0.0F);
        right_hand.setPos(-4.5f, 5.7f, 0);
        right_hand.setRotation(-1.3728F, -1.2784F, 0.3372F);
    }

    public static LayerDefinition createLayer(){
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        CubeDeformation cubeDeformation5 = new CubeDeformation(-0.5f);
        CubeDeformation cubeDeformation51 = new CubeDeformation(-0.51f);
        partDefinition.addOrReplaceChild(LOWBODY, CubeListBuilder.create()
                .texOffs(0,36).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, cubeDeformation5), PartPose.ZERO);
        partDefinition.addOrReplaceChild(BODY, CubeListBuilder.create()
                .texOffs(0, 16).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, cubeDeformation5), PartPose.ZERO);
        partDefinition.addOrReplaceChild(LEFTHAND, CubeListBuilder.create()
                .texOffs(32, 0).addBox(-0.6105F, -0.5038F, -1.0F, 12.0F, 2.0F, 2.0F, cubeDeformation5), PartPose.ZERO);
        partDefinition.addOrReplaceChild(HEAD, CubeListBuilder.create()
                .texOffs(0,0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubeDeformation5), PartPose.ZERO);
        partDefinition.addOrReplaceChild(HAT, CubeListBuilder.create()
                .texOffs(63, 13).addBox(-5.0F, -8.1F, -5.0F, 10.0F, 2.0F, 10.0F, cubeDeformation5)
                .texOffs(31, 11).addBox(-4.0F, -13.1F, -4.0F, 8.0F, 6.0F, 8.0F, cubeDeformation5), PartPose.ZERO);
        partDefinition.addOrReplaceChild(RIGHTHAND, CubeListBuilder.create()
                .texOffs(32, 0).addBox(-11.3895F, -0.5038F, -1.0F, 12.0F, 2.0F, 2.0F, cubeDeformation5).mirror(true), PartPose.ZERO);
        partDefinition.addOrReplaceChild(GUN, CubeListBuilder.create()
                .texOffs(120,124).addBox(-1.0F, -4.6F, -7.4F, 2.0F, 2.0F, 2.0F, cubeDeformation51)
                .texOffs(103, 119).addBox(-1.0F, -5.0F, -6.9F, 2.0F, 4.0F, 5.0F, cubeDeformation51)
                .texOffs(94, 115).addBox(-1.0F, -5.0F, -4.5F, 2.0F, 4.0F, 5.0F, cubeDeformation5)
                .texOffs(114, 94).addBox(-1.0F, -2.0F, -4.5F, 2.0F, 4.0F, 5.0F, cubeDeformation5)
                .texOffs(114, 102).addBox(-1.0F, -2.75F, -2.1F, 2.0F, 4.0F, 5.0F, cubeDeformation5)
                .texOffs(112, 115).addBox(-0.5F, -3.5F, -6.1F, 2.0F, 4.0F, 5.0F, cubeDeformation5)
                .texOffs(72, 119).addBox(-0.5F, -6.5F, -3.7F, 2.0F, 4.0F, 5.0F, cubeDeformation5)
                .texOffs(120, 124).addBox(-1.0F, -3.4F, -7.4F, 2.0F, 2.0F, 2.0F, cubeDeformation51), PartPose.offsetAndRotation(-10.6F, 0.4F, 0.0F, 1.4904F, 0.2494F, 1.2553F));
        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    @Override
    public void setupAnim(ColdSnapGunner entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
        this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
        this.body.yRot = netHeadYaw * ((float)Math.PI / 180F) * 0.25F;

    }

    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        lowbody.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        left_hand.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        right_hand.render(matrixStack, buffer, packedLight, packedOverlay);
    }


}