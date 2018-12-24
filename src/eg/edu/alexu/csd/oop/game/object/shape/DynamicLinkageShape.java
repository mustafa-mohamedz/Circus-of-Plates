package eg.edu.alexu.csd.oop.game.object.shape;

import java.awt.image.BufferedImage;
import java.lang.reflect.Constructor;

public class DynamicLinkageShape {

	public static Shape load(String shapeClassName, BufferedImage[] spriteImages, String color) {
		try {
			Class<?> clazz = Class.forName(shapeClassName);
			Constructor<?> ctor = clazz.getDeclaredConstructor(BufferedImage[].class, String.class);
			ctor.setAccessible(true);
			Shape shape = (Shape) ctor.newInstance(spriteImages, color);
			return shape;
		} catch (Exception e) {
			return null;
		}

	}
}
