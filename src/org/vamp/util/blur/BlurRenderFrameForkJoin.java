package org.vamp.util.blur;

import org.vamp.util.RenderFrameForkJoin;


public abstract class BlurRenderFrameForkJoin extends RenderFrameForkJoin {
	// ===========================================================
	// Constants
	// ===========================================================

	private static final long serialVersionUID = -3376186430415623730L;

	// ===========================================================
	// Fields
	// ===========================================================

	protected final int mBlurRadius;

	// ===========================================================
	// Constructors
	// ===========================================================

	public BlurRenderFrameForkJoin(final int[] pInputRenderFrameBuffer, final int pWidth, final int pHeight, final int[] pOutputRenderFrameBuffer, final int pBlurRadius) {
		this(pInputRenderFrameBuffer, pWidth, pHeight, 0, 0, pWidth, pHeight, pOutputRenderFrameBuffer, pBlurRadius);
	}

	public BlurRenderFrameForkJoin(final int[] pInputRenderFrameBuffer, final int pWidth, final int pHeight, final int pWindowLeft, final int pWindowTop, final int pWindowRight, final int pWindowBottom, final int[] pOutputRenderFrameBuffer, final int pBlurRadius) {
		super(pInputRenderFrameBuffer, pWidth, pHeight, pWindowLeft, pWindowTop, pWindowRight, pWindowBottom, pOutputRenderFrameBuffer);

		this.mBlurRadius = pBlurRadius;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}