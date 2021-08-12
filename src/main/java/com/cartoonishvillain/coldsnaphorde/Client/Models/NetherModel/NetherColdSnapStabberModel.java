package com.cartoonishvillain.coldsnaphorde.Client.Models.NetherModel;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapStabber;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

public class NetherColdSnapStabberModel<C extends GenericHordeMember> extends EntityModel<ColdSnapStabber> {
    private final ModelPart lowbody;
    private final ModelPart bone2;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart hat;
    private final ModelPart left_hand;
    private final ModelPart right_hand;
    private final ModelPart bone;
    private final ModelPart cube_r1;
    private static final String LOWBODY = "lowbody";
    private static final String BODY = "body";
    private static final String LEFTHAND = "lefthand";
    private static final String HEAD = "head";
    private static final String HAT = "hat";
    private static final String RIGHTHAND = "righthand";
    private static final String CUBE = "cube";
    private static final String BONE = "bone";
    private static final String BONE2 = "bone2";

    public NetherColdSnapStabberModel(ModelPart part){
        super(RenderType::entityCutoutNoCull);
        this.lowbody = part.getChild(LOWBODY);
        this.body = part.getChild(BODY);
        this.left_hand = part.getChild(LEFTHAND);
        this.head = part.getChild(HEAD);
        this.hat = part.getChild(HAT);
        this.right_hand = part.getChild(RIGHTHAND);
        this.bone = part.getChild(BONE);
        this.cube_r1 = part.getChild(CUBE);
        this.bone2 = part.getChild(BONE2);
        lowbody.setPos(0, 24, 0);
        bone2.setPos(0, 14.4f, 0);
        bone2.setRotation( 0.1222F, 0.0F, -0.1745F);
        bone2.children.put(BODY, body);
        bone2.children.put(HEAD, head);
        head.children.put(HAT, hat);
        bone2.children.put(LEFTHAND, left_hand);
        bone2.children.put(RIGHTHAND, right_hand);
        right_hand.children.put(BONE, bone);
        bone.children.put(CUBE, cube_r1);
    }

    public static LayerDefinition createLayer(){
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        CubeDeformation cubeDeformation5 = new CubeDeformation(-0.5f);
        CubeDeformation cubeDeformation7 = new CubeDeformation(-0.7f);
        CubeDeformation cubeDeformation1 = new CubeDeformation(-0.1f);
        CubeDeformation cubeDeformation49 = new CubeDeformation(-0.49f);

        partDefinition.addOrReplaceChild(LOWBODY, CubeListBuilder.create()
                .texOffs(0, 36).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, cubeDeformation5)
                .texOffs(53, 95).addBox(-6.0F, -12.0F, -1.45F, 12.0F, 12.0F, 12.0F, cubeDeformation5)
                .texOffs(62, 36).addBox(-6.0F, -10.17F, -6.0F, 12.0F, 12.0F, 12.0F, cubeDeformation5),  PartPose.ZERO);
        partDefinition.addOrReplaceChild(BONE2, CubeListBuilder.create(), PartPose.ZERO);
        partDefinition.addOrReplaceChild(BODY, CubeListBuilder.create()
                .texOffs(0,16).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, cubeDeformation5)
                .texOffs(0, 96).addBox(-2.9F, -4.3F, -2.9F, 8.0F, 8.0F, 8.0F, cubeDeformation5)
                .texOffs(0,80).addBox(-2.9F, -11.3F, -2.9F, 8.0F, 8.0F, 8.0F, cubeDeformation5)
                .texOffs(32,96).addBox(1.48F, -11.3F, 0.6F, 8.0F, 8.0F, 8.0F, cubeDeformation5), PartPose.offset(0,0.5f,0));
        partDefinition.addOrReplaceChild(HEAD, CubeListBuilder.create()
                .texOffs(0,0).addBox(-4.0F, -7.5F, -4.0F, 8.0F, 8.0F, 8.0F, cubeDeformation5)
                .texOffs(0, 60).addBox(-4.9F, -2.7F, -5.0F, 10.0F, 10.0F, 10.0F, cubeDeformation7), PartPose.offsetAndRotation(0.0F, -9.7F, 0.0F, 0.0F, 0.0F, 0.1745F));
        partDefinition.addOrReplaceChild(HAT, CubeListBuilder.create()
                .texOffs(63,13).addBox(-5.0F, -1.5F, -5.0F, 10.0F, 2.0F, 10.0F, cubeDeformation5)
                .texOffs(63,1).addBox(-5.0F, -0.5F, -5.0F, 10.0F, 2.0F, 10.0F, cubeDeformation5)
                .texOffs(31,11).addBox(-4.0F, -6.5F, -4.0F, 8.0F, 6.0F, 8.0F, cubeDeformation49), PartPose.offsetAndRotation(0.0F, -6.1F, 0.0F, 0.1745F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild(LEFTHAND, CubeListBuilder.create()
                .texOffs(32,0).addBox(-0.6105F, -0.5038F, -1.0F, 12.0F, 2.0F, 2.0F, cubeDeformation5), PartPose.offsetAndRotation(3.3F, -9.1F, -1.0F,0.0F, 0.2182F, 1.1345F));
        partDefinition.addOrReplaceChild(RIGHTHAND, CubeListBuilder.create()
                .texOffs(32,0).addBox(-11.3895F, -0.5038F, -1.0F, 12.0F, 2.0F, 2.0F, cubeDeformation5), PartPose.offsetAndRotation(-4.5F, -6.8F, 0.0F,  0.0F, -0.6109F, 1.4835F));
        partDefinition.addOrReplaceChild(BONE, CubeListBuilder.create(), PartPose.offsetAndRotation(-10.1F, 1.0F, -0.2F, -3.1416F, 0.4363F, 3.1416F));
        partDefinition.addOrReplaceChild(CUBE, CubeListBuilder.create()
                .texOffs(45, 35).addBox(-12.0F, 0.0F, -1.0F, 2.0F, 1.0F, 4.0F, cubeDeformation1)
                .texOffs(50, 47).addBox(-12.0F, -0.4F, 6.6F, 2.0F, 1.0F, 4.0F, cubeDeformation1)
                .texOffs(50,43).addBox(-11.1F, -0.4F, 2.8F, 2.0F, 1.0F, 4.0F, cubeDeformation1)
                .texOffs(44,43).addBox(-12.0F, -0.4F, 2.8F, 2.0F, 1.0F, 4.0F, cubeDeformation1), PartPose.offsetAndRotation(11.0F, 0.0F, 1.0F, 3.1416F, 0.0F, 0.0F));
        return LayerDefinition.create(meshDefinition, 128, 128);
    }




    @Override
    public void setupAnim(ColdSnapStabber entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        lowbody.render(matrixStack, buffer, packedLight, packedOverlay);
        bone2.render(matrixStack, buffer, packedLight, packedOverlay);
    }
}
