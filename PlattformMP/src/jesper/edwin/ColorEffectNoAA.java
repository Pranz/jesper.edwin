package jesper.edwin;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.Glyph;

//NO ANTI-ALIASING VERSION OF ColorEffect

public class ColorEffectNoAA extends org.newdawn.slick.font.effects.ColorEffect {
	private Color color = Color.white;
	
	@Override public void draw(BufferedImage image, Graphics2D g, UnicodeFont unicodeFont, Glyph glyph) {
		g.setColor(color);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		g.fill(glyph.getShape());
	}
}
