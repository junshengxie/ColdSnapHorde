package com.cartoonishvillain.coldsnaphorde.Client.Models;

// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.ColdSnapSnowballer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.SnowGolemModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.monster.Monster;

public class ColdSnapSnowballerModel<C extends Monster> extends EntityModel<ColdSnapSnowballer> {
    private static final String LOWBODY = "lowbody";
    private static final String BODY = "body";
    private static final String LEFTHAND = "lefthand";
    private static final String RIGHTHAND = "righthand";
    private static final String HAT = "hat";
    private static final String HEAD = "head";
    private final ModelPart lowbody;
    private final ModelPart body;
    private final ModelPart left_hand;
    private final ModelPart right_hand;
    private final ModelPart head;
    private final ModelPart hat;

    public ColdSnapSnowballerModel(ModelPart part) {
        super(RenderType::entityCutoutNoCull);
        this.head = part.getChild(HEAD);
        this.hat = part.getChild(HAT);
        this.right_hand = part.getChild(RIGHTHAND);
        this.left_hand = part.getChild(LEFTHAND);
        this.body = part.getChild(BODY);
        this.lowbody = part.getChild(LOWBODY);
        lowbody.setPos(0.0F, 24.0F, 0.0F);
        body.setPos(0, 13, 0);
        right_hand.setPos(-5, 6, 0);
        left_hand.setPos(5, 6, 0);
        head.setPos(0, 4, 0);
        hat.setPos(0, 4, 0);
        left_hand.setRotation(0.0F, 0.0F, 1.1345F);
        right_hand.setRotation(0.0F, 0.0F, -1.1345f);

//        texWidth = 128;
//        texHeight = 128;
//
//        lowbody = new ModelPart(this);
//        lowbody.setPos(0.0F, 24.0F, 0.0F);
//        lowbody.texOffs(0, 36).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, -0.5F, false);
//
//        body = new ModelPart(this);
//        body.setPos(0.0F, 13.0F, 0.0F);
//        body.texOffs(0, 16).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, -0.5F, false);
//
//        left_hand = new ModelPart(this);
//        left_hand.setPos(5.0F, 6.0F, 0.0F);
//        setRotationAngle(left_hand, 0.0F, 0.0F, 1.1345F);
//        left_hand.texOffs(32, 0).addBox(-1.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);
//
//        right_hand = new ModelPart(this);
//        right_hand.setPos(-5.0F, 6.0F, 0.0F);
//        setRotationAngle(right_hand, 0.0F, 0.0F, -1.1345F);
//        right_hand.texOffs(32, 0).addBox(-11.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);
//
//        head = new ModelPart(this);
//        head.setPos(0.0F, 4.0F, 0.0F);
//        head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, -0.5F, false);
//
//        hat = new ModelPart(this);
//        hat.setPos(0.0F, 0.0F, 0.0F);
//        head.addChild(hat);
//        hat.texOffs(63, 13).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 2.0F, 10.0F, -0.5F, false);
//        hat.texOffs(31, 11).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 6.0F, 8.0F, -0.5F, false);
    }

    public static LayerDefinition createLayer(){
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        CubeDeformation cubedeformation5 = new CubeDeformation(-0.5F);
        CubeDeformation cubedeformation25 = new CubeDeformation(-0.25F);
        partDefinition.addOrReplaceChild(LOWBODY, CubeListBuilder.create()
                .texOffs(0, 36).addBox(-6, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, cubedeformation5), PartPose.ZERO);
        partDefinition.addOrReplaceChild(BODY, CubeListBuilder.create()
                .texOffs(0, 16).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, cubedeformation5), PartPose.ZERO);
        partDefinition.addOrReplaceChild(LEFTHAND, CubeListBuilder.create()
                .texOffs(32, 0).addBox(-1.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, cubedeformation5), PartPose.ZERO);
        partDefinition.addOrReplaceChild(RIGHTHAND, CubeListBuilder.create()
                .texOffs(32, 0).addBox(-11.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, cubedeformation5), PartPose.ZERO);
        partDefinition.addOrReplaceChild(HEAD, CubeListBuilder.create()
                .texOffs(0,0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubedeformation5), PartPose.ZERO);
        partDefinition.addOrReplaceChild(HAT, CubeListBuilder.create()
                .texOffs(63, 13).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 2.0F, 10.0F, cubedeformation5)
                .texOffs(31,11).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 6.0F, 8.0F, cubedeformation5), PartPose.ZERO);
        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    @Override
    public void setupAnim(ColdSnapSnowballer entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
        this.hat.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.hat.xRot = headPitch * ((float)Math.PI / 180F);
        this.body.yRot = netHeadYaw * ((float)Math.PI / 180F) * 0.25F;
    }


    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        lowbody.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        left_hand.render(matrixStack, buffer, packedLight, packedOverlay);
        right_hand.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        hat.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}