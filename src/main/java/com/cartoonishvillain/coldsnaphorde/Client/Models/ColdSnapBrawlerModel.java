//package com.cartoonishvillain.coldsnaphorde.Client.Models;// Made with Blockbench 3.7.4
//// Exported for Minecraft version 1.15
//// Paste this class into your mod and generate all required imports
//
//
//import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.ColdSnapBrawler;
//import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.GenericHordeMember;
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.blaze3d.vertex.VertexConsumer;
//import net.minecraft.client.model.EntityModel;
//import net.minecraft.client.model.geom.ModelPart;
//
//public class ColdSnapBrawlerModel<C extends GenericHordeMember> extends EntityModel<ColdSnapBrawler> {
//	private final ModelPart lowbody;
//	private final ModelPart body;
//	private final ModelPart left_hand;
//	private final ModelPart right_hand;
//	private final ModelPart head;
//	private final ModelPart hat;
//	private final ModelPart rglove;
//	private final ModelPart cube_r1;
//	private final ModelPart cube_r2;
//	private final ModelPart lglove;
//	private final ModelPart cube_r3;
//	private final ModelPart cube_r4;
//
//	public ColdSnapBrawlerModel() {
//		texWidth = 128;
//		texHeight = 128;
//
//		lowbody = new ModelPart(this);
//		lowbody.setPos(0.0F, 24.0F, 0.0F);
//		lowbody.texOffs(0, 36).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, -0.5F, false);
//
//		body = new ModelPart(this);
//		body.setPos(0.0F, 13.0F, 0.0F);
//		body.texOffs(0, 16).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, -0.5F, false);
//
//		left_hand = new ModelPart(this);
//		left_hand.setPos(5.0F, 6.0F, 0.0F);
//		setRotationAngle(left_hand, 0.0F, 1.4399F, -0.4363F);
//		left_hand.texOffs(32, 0).addBox(-1.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);
//
//		right_hand = new ModelPart(this);
//		right_hand.setPos(-5.0F, 6.0F, 0.0F);
//		setRotationAngle(right_hand, 0.0F, -1.4399F, 0.4363F);
//		right_hand.texOffs(32, 0).addBox(-11.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);
//
//		head = new ModelPart(this);
//		head.setPos(0.0F, 4.0F, 0.0F);
//		head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, -0.5F, false);
//
//		hat = new ModelPart(this);
//		hat.setPos(0.0F, 0.0F, 0.0F);
//		head.addChild(hat);
//		hat.texOffs(63, 13).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 2.0F, 10.0F, -0.5F, false);
//		hat.texOffs(31, 11).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 6.0F, 8.0F, -0.5F, false);
//
//		rglove = new ModelPart(this);
//		rglove.setPos(-6.375F, 5.457F, -8.35F);
//		setRotationAngle(rglove, -0.1745F, 1.5272F, -1.309F);
//		rglove.texOffs(56, 37).addBox(-0.5F, -1.375F, -1.0F, 4.0F, 3.0F, 2.0F, -0.5F, false);
//		rglove.texOffs(56, 37).addBox(1.5F, -1.375F, -2.0F, 2.0F, 3.0F, 2.0F, -0.5F, false);
//		rglove.texOffs(56, 37).addBox(0.5F, -1.375F, -2.0F, 2.0F, 3.0F, 1.0F, -0.5F, false);
//
//		cube_r1 = new ModelPart(this);
//		cube_r1.setPos(18.867F, -11.509F, 2.387F);
//		rglove.addChild(cube_r1);
//		setRotationAngle(cube_r1, -1.5708F, 1.5708F, 0.0F);
//		cube_r1.texOffs(56, 37).addBox(2.383F, 16.352F, 12.138F, 2.0F, 3.0F, 1.0F, -0.5F, false);
//
//		cube_r2 = new ModelPart(this);
//		cube_r2.setPos(18.867F, -13.509F, 2.387F);
//		rglove.addChild(cube_r2);
//		setRotationAngle(cube_r2, -1.5708F, 1.5708F, 0.0F);
//		cube_r2.texOffs(56, 37).addBox(2.383F, 16.352F, 12.138F, 2.0F, 3.0F, 1.0F, -0.5F, false);
//
//		lglove = new ModelPart(this);
//		lglove.setPos(6.1F, 5.557F, -7.975F);
//		setRotationAngle(lglove, 0.0873F, 1.5272F, -1.8326F);
//		lglove.texOffs(52, 27).addBox(-0.502F, -1.5336F, -1.0739F, 4.0F, 3.0F, 2.0F, -0.5F, false);
//		lglove.texOffs(52, 27).addBox(1.498F, -1.5336F, -2.0739F, 2.0F, 3.0F, 2.0F, -0.5F, false);
//		lglove.texOffs(52, 27).addBox(0.498F, -1.5336F, -2.0739F, 2.0F, 3.0F, 1.0F, -0.5F, false);
//
//		cube_r3 = new ModelPart(this);
//		cube_r3.setPos(18.865F, -11.6676F, 2.3131F);
//		lglove.addChild(cube_r3);
//		setRotationAngle(cube_r3, -1.5708F, 1.5708F, 0.0F);
//		cube_r3.texOffs(52, 27).addBox(2.383F, 16.352F, 12.138F, 2.0F, 3.0F, 1.0F, -0.5F, false);
//
//		cube_r4 = new ModelPart(this);
//		cube_r4.setPos(18.865F, -13.6676F, 2.3131F);
//		lglove.addChild(cube_r4);
//		setRotationAngle(cube_r4, -1.5708F, 1.5708F, 0.0F);
//		cube_r4.texOffs(52, 27).addBox(2.383F, 16.352F, 12.138F, 2.0F, 3.0F, 1.0F, -0.5F, false);
//	}
//
//	@Override
//	public void setupAnim(ColdSnapBrawler entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//		this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
//		this.head.xRot = headPitch * ((float)Math.PI / 180F);
//		this.body.yRot = netHeadYaw * ((float)Math.PI / 180F) * 0.25F;
//	}
//
//	@Override
//	public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
//		lowbody.render(matrixStack, buffer, packedLight, packedOverlay);
//		body.render(matrixStack, buffer, packedLight, packedOverlay);
//		left_hand.render(matrixStack, buffer, packedLight, packedOverlay);
//		right_hand.render(matrixStack, buffer, packedLight, packedOverlay);
//		head.render(matrixStack, buffer, packedLight, packedOverlay);
//		rglove.render(matrixStack, buffer, packedLight, packedOverlay);
//		lglove.render(matrixStack, buffer, packedLight, packedOverlay);
//	}
//
//	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
//		modelRenderer.xRot = x;
//		modelRenderer.yRot = y;
//		modelRenderer.zRot = z;
//	}
//}