package it.se.obfuscator.helpers;

import java.io.File;
import java.util.List;

import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodNode;

/**
 * Utility class for testing purposes
 * @author mariano
 *
 */

public class TestUtils {

	
	/**
	 * Compute the relative file name for a class
	 * @param clazz the class to look for
	 * @return The relative file name representing this class, for parsing purposes
	 */
	
	public static String fileNameOf(Class<?> clazz) {
		return (clazz.getName().replace('.', '/')) + ".class";
	}
	
	/**
	 * Compute the file handler for a class in a given directory
	 * @param dir where the package structure starts
	 * @param clazz the class to look for
	 * @return The File representing this class, for parsing purposes
	 */
	
	public static File fileFor(String dir, Class<?> clazz) {
		return new File(dir + "/" + clazz.getName().replace('.', '/') + ".class");
	}

	/**
	 * Compute the file name for a class in a given directory
	 * @param dir where the package structure starts
	 * @param clazz the class to look for
	 * @return The String representing this class, for parsing purposes
	 */
	
	public static String fileNameFor(String dir, Class<?> clazz) {
		return dir + "/" + (clazz.getName().replace('.', '/')) + ".class";
	}
	
	/**
	 * Create the directory to store the transformed class 
	 * @param dir where the package structure will be starting
	 * @param clazz the class to store there (useful for the package name)
	 */
	
	public static void crateDirsFor(String dir, Class<?> clazz) {
		String newDirName = dir + "/" + (clazz.getPackage().getName().replace('.', '/'));
		File newDir = new File(newDirName);
		newDir.mkdirs();
	}
	
	/**
	 * Check it a method is in the list
	 * @param candidate Method to check
	 * @param toExclude Exclusion list 
	 * @return whether the first parameter is in the list (second parameter)
	 */
	
	public static boolean notIn(MethodNode candidate, MethodNode[] toExclude) {
		for (MethodNode exclusion: toExclude)
			if (candidate.name.equals(exclusion.name) && candidate.desc.equals(exclusion.desc))
				return false;
		return true;
	}
	
	
	
	/**
	 * Checks if the parsed method signature correspond to the specified method signature
	 * @param parsedDescriptor the method formal parameters from the parsed class
	 * @param expected the method formal parameters from the pattern
	 * @return true if the two signature match, false otherwise
	 */

	public static boolean sameParameters(String parsedDescriptor, Class<?>[] expected) {
		if (parsedDescriptor==null && expected.length==0) 
			return true;
		Type[] actual = Type.getArgumentTypes(parsedDescriptor);
		if (actual.length != expected.length)
			return false;
		for (int i=0; i< actual.length; i++){
			if (!actual[i].getClassName().equals(expected[i].getName()))
				return false;
		}
		return true;
	}

	
	
	/**
	 * Extracts the number of annotations in the given method 
	 * @param node parse tree of method
	 * @return the number of annotations in the method
	 */
	
	public static int sizeofAnnotations(MethodNode node) {
		List<AnnotationNode> annotations= node.invisibleAnnotations;
		if (annotations==null)
			return 0;
		else
			return annotations.size();
	}

	
	
	/**
	 * Extracts the number of bytecode statements in the given method
	 * @param node parse tree of method
	 * @return the number of bytecode statements in the method
	 */
	
	public static int sizeofCode(MethodNode node) {
		InsnList code = node.instructions;
		if (code == null) return 0;
			else
		return node.instructions.size();
	}

}
