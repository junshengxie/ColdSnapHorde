package com.jedijoe.coldsnaphorde.Client.Models;// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ColdSnapBrawlerModel extends EntityModel<Entity> {
	private final ModelRenderer lowbody;
	private final ModelRenderer body;
	private final ModelRenderer left_hand;
	private final ModelRenderer right_hand;
	private final ModelRenderer head;
	private final ModelRenderer hat;
	private final ModelRenderer rglove;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer lglove;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;

	public ColdSnapBrawlerModel() {
		textureWidth = 128;
		textureHeight = 128;

		lowbody = new ModelRenderer(this);
		lowbody.setRotationPoint(0.0F, 24.0F, 0.0F);
		lowbody.setTextureOffset(0, 36).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, -0.5F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 13.0F, 0.0F);
		body.setTextureOffset(0, 16).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, -0.5F, false);

		left_hand = new ModelRenderer(this);
		left_hand.setRotationPoint(5.0F, 6.0F, 0.0F);
		setRotationAngle(left_hand, 0.0F, 1.4399F, -0.4363F);
		left_hand.setTextureOffset(32, 0).addBox(-1.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);

		right_hand = new ModelRenderer(this);
		right_hand.setRotationPoint(-5.0F, 6.0F, 0.0F);
		setRotationAngle(right_hand, 0.0F, -1.4399F, 0.4363F);
		right_hand.setTextureOffset(32, 0).addBox(-11.0F, 0.0F, -1.0F, 12.0F, 2.0F, 2.0F, -0.5F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 4.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, -0.5F, false);

		hat = new ModelRenderer(this);
		hat.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(hat);
		hat.setTextureOffset(63, 13).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 2.0F, 10.0F, -0.5F, false);
		hat.setTextureOffset(31, 11).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 6.0F, 8.0F, -0.5F, false);

		rglove = new ModelRenderer(this);
		rglove.setRotationPoint(-6.375F, 5.457F, -8.35F);
		setRotationAngle(rglove, -0.1745F, 1.5272F, -1.309F);
		rglove.setTextureOffset(56, 37).addBox(-0.5F, -1.375F, -1.0F, 4.0F, 3.0F, 2.0F, -0.5F, false);
		rglove.setTextureOffset(56, 37).addBox(1.5F, -1.375F, -2.0F, 2.0F, 3.0F, 2.0F, -0.5F, false);
		rglove.setTextureOffset(56, 37).addBox(0.5F, -1.375F, -2.0F, 2.0F, 3.0F, 1.0F, -0.5F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(18.867F, -11.509F, 2.387F);
		rglove.addChild(cube_r1);
		setRotationAngle(cube_r1, -1.5708F, 1.5708F, 0.0F);
		cube_r1.setTextureOffset(56, 37).addBox(2.383F, 16.352F, 12.138F, 2.0F, 3.0F, 1.0F, -0.5F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(18.867F, -13.509F, 2.387F);
		rglove.addChild(cube_r2);
		setRotationAngle(cube_r2, -1.5708F, 1.5708F, 0.0F);
		cube_r2.setTextureOffset(56, 37).addBox(2.383F, 16.352F, 12.138F, 2.0F, 3.0F, 1.0F, -0.5F, false);

		lglove = new ModelRenderer(this);
		lglove.setRotationPoint(6.1F, 5.557F, -7.975F);
		setRotationAngle(lglove, 0.0873F, 1.5272F, -1.8326F);
		lglove.setTextureOffset(52, 27).addBox(-0.502F, -1.5336F, -1.0739F, 4.0F, 3.0F, 2.0F, -0.5F, false);
		lglove.setTextureOffset(52, 27).addBox(1.498F, -1.5336F, -2.0739F, 2.0F, 3.0F, 2.0F, -0.5F, false);
		lglove.setTextureOffset(52, 27).addBox(0.498F, -1.5336F, -2.0739F, 2.0F, 3.0F, 1.0F, -0.5F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(18.865F, -11.6676F, 2.3131F);
		lglove.addChild(cube_r3);
		setRotationAngle(cube_r3, -1.5708F, 1.5708F, 0.0F);
		cube_r3.setTextureOffset(52, 27).addBox(2.383F, 16.352F, 12.138F, 2.0F, 3.0F, 1.0F, -0.5F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(18.865F, -13.6676F, 2.3131F);
		lglove.addChild(cube_r4);
		setRotationAngle(cube_r4, -1.5708F, 1.5708F, 0.0F);
		cube_r4.setTextureOffset(52, 27).addBox(2.383F, 16.352F, 12.138F, 2.0F, 3.0F, 1.0F, -0.5F, false);
	}

	@Override
	public void setRotationAngles(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
		this.body.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F) * 0.25F;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		lowbody.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		left_hand.render(matrixStack, buffer, packedLight, packedOverlay);
		right_hand.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		rglove.render(matrixStack, buffer, packedLight, packedOverlay);
		lglove.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}