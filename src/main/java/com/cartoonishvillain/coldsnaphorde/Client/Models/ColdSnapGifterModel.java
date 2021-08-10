package com.cartoonishvillain.coldsnaphorde.Client.Models;// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapGifter;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.monster.Monster;

public class ColdSnapGifterModel<C extends Monster> extends EntityModel<ColdSnapGifter> {
    private static final String LOWBODY = "lowbody";
    private static final String BODY = "body";
    private static final String LEFTHAND = "lefthand";
    private static final String RIGHTHAND = "righthand";
    private static final String PRESENT = "present";
    private static final String HAT = "hat";
    private static final String HEAD = "head";
	private final ModelPart lowbody;
	private final ModelPart body;
	private final ModelPart left_hand;
	private final ModelPart right_hand;
	private final ModelPart head;
	private final ModelPart hat;
	private final ModelPart present;

	public ColdSnapGifterModel(ModelPart part) {
        super(RenderType::entityCutoutNoCull);
        this.head = part.getChild(HEAD);
        this.hat = part.getChild(HAT);
        this.present = part.getChild(PRESENT);
        this.right_hand = part.getChild(RIGHTHAND);
        this.left_hand = part.getChild(LEFTHAND);
        this.body = part.getChild(BODY);
        this.lowbody = part.getChild(LOWBODY);
        lowbody.setPos(0.0F, 24.0F, 0.0F);
        body.setPos(0, 13, 0);
        right_hand.setPos(-4, 6, 0);
        left_hand.setPos(5, 6, 0);
        present.setPos(-0.25F, 7.0F, -10.0F);
        head.setPos(0, 4, 0);
        hat.setPos(0, 4, 0);
        right_hand.setRotation(0.0F, -1.5272F, 0.0F);
        left_hand.setRotation( 0.0F, 1.5272F, 0.0F);

//		texWidth = 128;
//		texHeight = 128;
//
//		lowbody = new ModelPart(this);
//		lowbody.setPos(0.0F, 24.0F, 0.0F);
//		lowbody.texOffs(0, 0).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, -0.5F, false);
//
//		body = new ModelPart(this);
//		body.setPos(0.0F, 13.0F, 0.0F);
//		body.texOffs(0, 24).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, -0.5F, false);
//
//		left_hand = new ModelPart(this);
//		left_hand.setPos(5.0F, 6.0F, 0.0F);
//		setRotationAngle(left_hand, 0.0F, 1.4399F, 0.0F);
//		left_hand.texOffs(48, 11).addBox(-1.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);
//
//		right_hand = new ModelPart(this);
//		right_hand.setPos(-5.0F, 6.0F, 0.0F);
//		setRotationAngle(right_hand, 0.0F, -1.5272F, 0.0F);
//		right_hand.texOffs(48, 11).addBox(-11.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);
//
//		head = new ModelPart(this);
//		head.setPos(0.0F, 4.0F, 0.0F);
//		head.texOffs(40, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, -0.5F, false);
//
//		hat = new ModelPart(this);
//		hat.setPos(0.0F, 0.0F, 0.0F);
//		head.addChild(hat);
//		hat.texOffs(30, 34).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 2.0F, 10.0F, -0.5F, false);
//		hat.texOffs(0, 44).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 6.0F, 8.0F, -0.5F, false);
//
//		present = new ModelPart(this);
//		present.setPos(-0.25F, 7.0F, -10.0F);
//		present.texOffs(32, 46).addBox(-5.0F, -3.0F, -3.0F, 11.0F, 3.0F, 5.0F, -0.05F, false);
//		present.texOffs(36, 0).addBox(-6.0F, -5.0F, -4.0F, 13.0F, 4.0F, 7.0F, -0.6F, false);
	}

	public static LayerDefinition createLayer(){
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();
		CubeDeformation cubedeformation5 = new CubeDeformation(-0.5F);
		CubeDeformation cubedeformation6 = new CubeDeformation(-0.6F);
		CubeDeformation cubedeformation05 = new CubeDeformation(-0.05F);
		partDefinition.addOrReplaceChild(LOWBODY, CubeListBuilder.create()
				.texOffs(0, 0).addBox(-6, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, cubedeformation5), PartPose.ZERO);
		partDefinition.addOrReplaceChild(BODY, CubeListBuilder.create()
				.texOffs(0, 24).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, cubedeformation5), PartPose.ZERO);
		partDefinition.addOrReplaceChild(LEFTHAND, CubeListBuilder.create()
				.texOffs(48, 11).addBox(-1.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, cubedeformation5), PartPose.ZERO);
		partDefinition.addOrReplaceChild(RIGHTHAND, CubeListBuilder.create()
				.texOffs(48, 11).addBox(-11.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, cubedeformation5), PartPose.ZERO);
		partDefinition.addOrReplaceChild(PRESENT, CubeListBuilder.create()
				.texOffs(32, 46).addBox(-5.0F, -3.0F, -3.0F, 11.0F, 3.0F, 5.0F, cubedeformation05)
				.texOffs(36, 0).addBox(-6.0F, -5.0F, -4.0F, 13.0F, 4.0F, 7.0F, cubedeformation6), PartPose.ZERO);
		partDefinition.addOrReplaceChild(HEAD, CubeListBuilder.create()
				.texOffs(40,16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, cubedeformation5), PartPose.ZERO);
		partDefinition.addOrReplaceChild(HAT, CubeListBuilder.create()
				.texOffs(30, 34).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 2.0F, 10.0F, cubedeformation5)
				.texOffs(0,44).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 6.0F, 8.0F, cubedeformation5), PartPose.ZERO);
		return LayerDefinition.create(meshDefinition, 128, 128);
	}

	@Override
	public void setupAnim(ColdSnapGifter entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
		present.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}