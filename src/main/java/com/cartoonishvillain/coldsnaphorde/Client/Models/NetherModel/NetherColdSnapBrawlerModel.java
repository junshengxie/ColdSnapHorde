package com.cartoonishvillain.coldsnaphorde.Client.Models.NetherModel;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapBrawler;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

public class NetherColdSnapBrawlerModel <C extends GenericHordeMember> extends EntityModel<ColdSnapBrawler> {

    private final ModelPart lowbody;
    private final ModelPart bone;
    private final ModelPart body;
    private final ModelPart left_hand;
    private final ModelPart lglove;
    private final ModelPart cube_r1;
    private final ModelPart right_hand;
    private final ModelPart lglove2;
    private final ModelPart cube_r2;
    private final ModelPart head;
    private final ModelPart hat;
    private static final String BONE = "bone";
    private static final String LOWBODY = "lowbody";
    private static final String BODY = "body";
    private static final String LEFTHAND = "lefthand";
    private static final String HEAD = "head";
    private static final String HAT = "hat";
    private static final String RIGHTHAND = "righthand";
    private static final String LGLOVE = "lglove";
    private static final String LGLOVE2 = "lglove2";
    private static final String CUBE = "cube";
    private static final String CUBE2 = "cube2";

    public NetherColdSnapBrawlerModel(ModelPart part){
        super(RenderType::entityCutoutNoCull);
        lowbody = part.getChild(LOWBODY);
        body = part.getChild(BODY);
        left_hand = part.getChild(LEFTHAND);
        lglove = part.getChild(LGLOVE);
        cube_r1 = part.getChild(CUBE);
        head = part.getChild(HEAD);
        hat = part.getChild(HAT);
        right_hand = part.getChild(RIGHTHAND);
        lglove2 = part.getChild(LGLOVE2);
        cube_r2 = part.getChild(CUBE2);
        bone = part.getChild(BONE);
        lowbody.setPos(0, 24, 0);
        bone.setPos(0, 14.4f, 0);
        bone.setRotation(0.1043F, -0.092F, 0.3041F);
        bone.children.put(BODY, body);
        bone.children.put(LEFTHAND, left_hand);
        left_hand.children.put(LGLOVE, lglove);
        lglove.children.put(CUBE, cube_r1);
        bone.children.put(RIGHTHAND, right_hand);
        right_hand.children.put(LGLOVE2, lglove2);
        lglove2.children.put(CUBE2, cube_r2);
        bone.children.put(HEAD, head);
        head.children.put(HAT, hat);
    }

    public static LayerDefinition createLayer(){
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        CubeDeformation cubeDeformation5 = new CubeDeformation(-0.5f);
        CubeDeformation cubeDeformation2 = new CubeDeformation(-0.2f);
        CubeDeformation cubeDeformation6 = new CubeDeformation(-0.6f);
        CubeDeformation cubeDeformation3 = new CubeDeformation(-0.3f);
        CubeDeformation cubeDeformation48 = new CubeDeformation(-0.48f);
        partDefinition.addOrReplaceChild(LOWBODY, CubeListBuilder.create()
                .texOffs(0,36).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, cubeDeformation5)
                .texOffs(51,90).addBox(-6.0F, -12.0F, 2.25F, 12.0F, 12.0F, 12.0F, cubeDeformation5)
                .texOffs(0,97).addBox(-6.0F, -10.17F, -6.0F, 12.0F, 12.0F, 12.0F, cubeDeformation5), PartPose.ZERO);
        partDefinition.addOrReplaceChild(BONE, CubeListBuilder.create(), PartPose.ZERO);
        partDefinition.addOrReplaceChild(BODY, CubeListBuilder.create()
                .texOffs(0,16).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, cubeDeformation5), PartPose.offset(0.0F, 0.5F, 0.0F));
        partDefinition.addOrReplaceChild(LEFTHAND, CubeListBuilder.create()
                .texOffs(32,0).addBox(-0.5F, -0.5F, -1.0F, 12.0F, 2.0F, 2.0F, cubeDeformation5), PartPose.offsetAndRotation(4.5F, -6.7F, 0.0F,  -0.8198F, 0.9435F, -0.3915F));
        partDefinition.addOrReplaceChild(LGLOVE, CubeListBuilder.create()
                .texOffs(48,48).addBox(-0.5F, -1.3954F, -1.8046F, 5.0F, 3.0F, 4.0F, cubeDeformation5)
                .texOffs(48,55).addBox(-1.3F, -1.3954F, -1.8046F, 5.0F, 3.0F, 4.0F, cubeDeformation6), PartPose.offsetAndRotation(7.2F, 0.857F, -0.075F,  2.5703F, 0.4259F, 0.5713F));
        partDefinition.addOrReplaceChild(CUBE, CubeListBuilder.create()
                .texOffs(0,0).addBox(-0.5F, -0.5F, -1.8F, 2.0F, 1.0F, 2.0F, cubeDeformation2), PartPose.offsetAndRotation(0.8F, 0.1046F, 1.6954F, 0.1719F, -0.7703F, -0.2444F));
        partDefinition.addOrReplaceChild(RIGHTHAND, CubeListBuilder.create()
                .texOffs(61, 0).addBox(-11.5F, -0.5F, -1.0F, 12.0F, 2.0F, 2.0F, cubeDeformation5), PartPose.offsetAndRotation(-3.0F, -7.3F, 1.3F, -0.4799F, -0.8743F, -0.0509F));
        partDefinition.addOrReplaceChild(LGLOVE2, CubeListBuilder.create()
                .texOffs(67,48).addBox(-4.5F, -1.3954F, -1.8046F, 5.0F, 3.0F, 4.0F, cubeDeformation5)
                .texOffs(67,55).addBox(-3.7F, -1.3954F, -1.8046F, 5.0F, 3.0F, 4.0F, cubeDeformation6), PartPose.offsetAndRotation(-7.2F, 0.857F, -0.075F,2.5394F, -0.3776F, -0.4923F));
        partDefinition.addOrReplaceChild(CUBE2, CubeListBuilder.create()
                .texOffs(0,0).addBox(-1.5F, -0.5F, -1.8F, 2.0F, 1.0F, 2.0F, cubeDeformation2), PartPose.offsetAndRotation(-0.8F, 0.1046F, 1.6954F,0.1719F, 0.7703F, 0.2444F ));
        partDefinition.addOrReplaceChild(HEAD, CubeListBuilder.create()
                .texOffs(0,0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubeDeformation5)
                .texOffs(0, 60).addBox(-4.0F, -8.4F, -4.0F, 8.0F, 8.0F, 8.0F, cubeDeformation3), PartPose.offsetAndRotation(0.0F, -8.5F, 0.0F,-0.2164F, -0.0283F, -0.2151F ));
        partDefinition.addOrReplaceChild(HAT, CubeListBuilder.create()
                .texOffs(63,13).addBox(-5.0F, -1.5F, -5.0F, 10.0F, 2.0F, 10.0F, cubeDeformation5)
                .texOffs(31,11).addBox(-4.05F, -6.5F, -4.0F, 8.0F, 6.0F, 8.0F, cubeDeformation48), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -0.1744F, 0.0076F, 0.043F));
        return LayerDefinition.create(meshDefinition, 128, 128);
    }


    @Override
    public void setupAnim(ColdSnapBrawler entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        lowbody.render(matrixStack, buffer, packedLight, packedOverlay);
        bone.render(matrixStack, buffer, packedLight, packedOverlay);
    }
}
