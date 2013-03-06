package org.vamp;

import java.util.Hashtable;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import org.pushingpixels.substance.api.skin.SubstanceGraphiteGlassLookAndFeel;

import uk.co.caprica.vlcj.discovery.NativeDiscovery;

public class Main {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public static void main(final String[] pArgs) {
		new NativeDiscovery().discover();

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(new SubstanceGraphiteGlassLookAndFeel());

					/* Reduce font size a little: */
					Main.changeFontSizeBy(-1);
				} catch (final Exception e) {
					e.printStackTrace();
				}

				final String mediaFilename = pArgs[0];

				final String[] vlcArgs = new String[(pArgs.length - 1) + 1];
				System.arraycopy(pArgs, 1, vlcArgs, 0, pArgs.length - 1);
				vlcArgs[vlcArgs.length - 1] = "--no-video-title-show";

				final VAmp vamp = new VAmp(mediaFilename, vlcArgs);

				vamp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				vamp.setLocation(100, 100);
				vamp.setVisible(true);
				vamp.pack();
			}
		});
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

	private static void changeFontSizeBy(final int pSizeReduction) {
		final Hashtable<Object, Object> defaults = UIManager.getDefaults();
		for (final Entry<Object, Object> entry : defaults.entrySet()) {
			final Object key = entry.getKey();
			if ((key instanceof String) && (((String) key).endsWith(".font"))) {
				final FontUIResource font = (FontUIResource) UIManager.get(key);
				defaults.put(key, new FontUIResource(font.getFontName(), font.getStyle(), font.getSize() + pSizeReduction));
			}
		}
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
