package com.cartoonishvillain.coldsnaphorde.Client.Models.NetherModel;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapGifter;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

public class NetherColdSnapGifterModel <C extends GenericHordeMember> extends EntityModel<ColdSnapGifter> {
    private static final String LOWBODY = "lowbody";
    private static final String BODY = "body";
    private static final String LEFTHAND = "lefthand";
    private static final String HEAD = "head";
    private static final String HAT = "hat";
    private static final String RIGHTHAND = "righthand";
    private static final String PRESENT = "present";
    private static final String BOW1 = "bow";
    private static final String BOW2 = "bow2";
    private static final String BONE = "bone";
    private static final String BONE2 = "bone2";
    private static final String BONE3 = "bone3";
    private static final String BONE4 = "bone4";
    private static final String BASE1 = "base1";

    private final ModelPart bone4;
    private final ModelPart bone2;
    private final ModelPart head;
    private final ModelPart bone3;
    private final ModelPart bone;
    private final ModelPart bow1_r1;
    private final ModelPart bow2_r1;
    private final ModelPart left_hand;
    private final ModelPart present;
    private final ModelPart base_r1;
    private final ModelPart right_hand;
    private final ModelPart body;
    private final ModelPart hat;
    private final ModelPart lowbody;
    public NetherColdSnapGifterModel(ModelPart part){
        super(RenderType::entityCutoutNoCull);
        this.lowbody = part.getChild(LOWBODY);
        this.body = part.getChild(BODY);
        this.left_hand = part.getChild(LEFTHAND);
        this.right_hand = part.getChild(RIGHTHAND);
        this.head = part.getChild(HEAD);
        this.hat = part.getChild(HAT);
        this.present = part.getChild(PRESENT);
        this.bow1_r1 = part.getChild(BOW1);
        this.bow2_r1 = part.getChild(BOW2);
        this.bone = part.getChild(BONE);
        this.bone2 = part.getChild(BONE2);
        this.bone3 = part.getChild(BONE3);
        this.bone4 = part.getChild(BONE4);
        this.base_r1 = part.getChild(BASE1);
        bone4.setPos(0, 24.5f, 0);
        bone4.children.put(BONE2, bone2);
        bone2.children.put(HEAD, head);
        head.children.put(BONE3, bone3);
        head.children.put(BONE, bone);
        bone.children.put(BOW2, bow2_r1);
        bone.children.put(BOW1, bow1_r1);
        bone2.children.put(LEFTHAND, left_hand);
        left_hand.children.put(PRESENT, present);
        present.children.put(BASE1, base_r1);
        bone2.children.put(RIGHTHAND, right_hand);
        bone2.children.put(BODY, body);
        bone4.children.put(HAT, hat);
        bone4.children.put(LOWBODY, lowbody);
    }

    public static LayerDefinition createLayer(){
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        CubeDeformation cubeDeformation5 = new CubeDeformation(-0.5f);
        CubeDeformation cubeDeformation05 = new CubeDeformation(-0.05f);
        CubeDeformation cubeDeformation099 = new CubeDeformation(-0.099f);
        CubeDeformation cubeDeformation6 = new CubeDeformation(-0.6f);
        partDefinition.addOrReplaceChild(BONE4, CubeListBuilder.create(), PartPose.ZERO);
        partDefinition.addOrReplaceChild(BONE2, CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -9.1F, 0.0F, 0.2559F, 0.056F, -0.1237F));
        partDefinition.addOrReplaceChild(HEAD, CubeListBuilder.create()
                .texOffs(40,16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubeDeformation5), PartPose.offsetAndRotation(0.0F, -7.3F, -1.5F,  -0.6545F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild(BONE3, CubeListBuilder.create()
                .texOffs(0,0).addBox(-0.95F, -4.05F, -4.45F, 1.0F, 1.0F, 1.0F, cubeDeformation05)
                .texOffs(4,0).addBox(-0.95F, -4.05F, -5.35F, 1.0F, 1.0F, 1.0F, cubeDeformation05), PartPose.offsetAndRotation(1.0F, -1.2F, 0.6F,  0.2355F, 0.3829F, 0.0894F));
        partDefinition.addOrReplaceChild(BONE, CubeListBuilder.create()
                .texOffs(36, 0).addBox(-6.0F, -3.4F, -4.0F, 13.0F, 4.0F, 7.0F, cubeDeformation6), PartPose.offsetAndRotation(-0.45F, -7.2F, -0.5F, -0.0859F, 0.0151F, 0.1739F));
        partDefinition.addOrReplaceChild(BOW1, CubeListBuilder.create()
                .texOffs(0,58).addBox(-3.5F, -3.5F, -0.5F, 7.0F, 4.0F, 1.0F, cubeDeformation5), PartPose.offsetAndRotation(0.5F, -2.8F, -0.5F,  0.0F, 0.7418F, 0.0F));
        partDefinition.addOrReplaceChild(BOW2, CubeListBuilder.create()
                .texOffs(0,58), PartPose.offsetAndRotation(0.5F, -2.8F, -0.5F, 0.0F, -0.7418F, 0.0F));
        partDefinition.addOrReplaceChild(LEFTHAND, CubeListBuilder.create()
                .texOffs(48, 11).addBox(-0.9782F, -0.5F, -0.5005F, 12.0F, 2.0F, 2.0F, cubeDeformation5), PartPose.offsetAndRotation(4.5F, -6.0F, 0.0F, 0.662F, 1.1366F, 0.6271F));
        partDefinition.addOrReplaceChild(PRESENT, CubeListBuilder.create(), PartPose.offset(9.8718F, 0.1F, 0.9995F));
        partDefinition.addOrReplaceChild(BASE1, CubeListBuilder.create()
                .texOffs(32,46).addBox(-5.6282F, -2.903F, -2.5F, 11.0F, 3.0F, 5.0F, cubeDeformation099), PartPose.offsetAndRotation(0.6282F, -0.1F, -0.5F, 0.0F, 0.0F, 0.0436F));
        partDefinition.addOrReplaceChild(RIGHTHAND, CubeListBuilder.create()
                .texOffs(48, 11).addBox(-8.9F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, cubeDeformation5), PartPose.offsetAndRotation(-3.1F, -4.8F, 0.9F, 0.2943F, -0.6534F, -0.3822F));
        partDefinition.addOrReplaceChild(BODY, CubeListBuilder.create()
                .texOffs(0,24).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, cubeDeformation5), PartPose.offset(0, 0.5f, 0));
        partDefinition.addOrReplaceChild(HAT, CubeListBuilder.create()
                .texOffs(30,34).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 2.0F, 10.0F, cubeDeformation5)
                .texOffs(0,44).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 6.0F, 8.0F, cubeDeformation5), PartPose.offsetAndRotation(0.0F, -13.1F, -3.0F, -1.3111F, 0.0338F, -0.1265F));
        partDefinition.addOrReplaceChild(LOWBODY, CubeListBuilder.create()
                .texOffs(12,71).addBox(-6.0F, -10.17F, -6.0F, 12.0F, 12.0F, 12.0F, cubeDeformation5)
                .texOffs(51,91).addBox(-6.0F, -12.0F, 0.4F, 12.0F, 12.0F, 12.0F, cubeDeformation5)
                .texOffs(0,104).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, cubeDeformation5), PartPose.ZERO);
        return LayerDefinition.create(meshDefinition, 128,128);

    }


    @Override
    public void setupAnim(ColdSnapGifter entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        bone4.render(matrixStack, buffer, packedLight, packedOverlay);
    }
}
