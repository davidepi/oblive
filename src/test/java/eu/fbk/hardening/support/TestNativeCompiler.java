package eu.fbk.hardening.support;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestNativeCompiler {

    //source C
    private static File sourceC;
    //source c++
    private static File sourceCPP;
    //source C wrong
    private static File wrongC;
    //output of the compilation correct
    private static File destinationObj;
    //output of the compilation, wrong extension
    private static File destinationObjWrong;
    //output of the compilation, fixed extension
    private static File destinationObjFixed;
    //output of the library compilation, correct
    private static File destinationLib;
    //output of the library compilation, wrong extension
    private static File destinationLibWrong;
    //output of the library compilation, fixed extension
    private static File destinationLibFixed;

    @BeforeClass
    public static void setSourceUrl() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("helloworld.c");
        Assert.assertNotNull(url);
        sourceC = new File(url.getPath());
        url = Thread.currentThread().getContextClassLoader().getResource("helloworld.cpp");
        Assert.assertNotNull(url);
        sourceCPP = new File(url.getPath());
        url = Thread.currentThread().getContextClassLoader().getResource("helluword.c");
        Assert.assertNotNull(url);
        wrongC = new File(url.getPath());
        destinationObj = new File(System.getProperty("user.dir") + File.separator + "buildedc" + SystemInfo.getObjectExtension());
        destinationObjWrong = new File(System.getProperty("user.dir") + File.separator + "buildedc.txt");
        destinationObjFixed = new File(destinationObjWrong.getAbsoluteFile() + SystemInfo.getObjectExtension());
        destinationLib = new File(System.getProperty("user.dir") + File.separator + "buildedlib" + SystemInfo.getSharedLibraryExtension());
        destinationLibWrong = new File(System.getProperty("user.dir") + File.separator + "buildedlib.txt");
        destinationLibFixed = new File(System.getProperty("user.dir") + File.separator + "buildedlib.txt" + SystemInfo.getSharedLibraryExtension());
    }

    @AfterClass
    public static void removeGarbage() {
        if (destinationObj.exists())
            destinationObj.delete();
        if (destinationObjFixed.exists())
            destinationObjFixed.delete();
        if (destinationObjWrong.exists())
            destinationObjWrong.delete();
        if (destinationLib.exists())
            destinationLib.delete();
        if (destinationLibFixed.exists())
            destinationObjFixed.delete();
        if (destinationLibWrong.exists())
            destinationLibWrong.delete();
    }

    @Test
    public void compileObjectTest() {
        NativeCompiler compiler = new NativeCompiler();
        String compilerError;

        //correct output extension
        try {
            compilerError = compiler.compileFile(new File[]{sourceC}, destinationObj);
            Assert.assertNull(compilerError);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
        Assert.assertTrue(destinationObj.exists()); //the file exists
        Assert.assertTrue(destinationObj.delete()); //do not leave garbage around

        //incorrect output extension, the new extension should be appended
        try {
            compilerError = compiler.compileFile(new File[]{sourceC}, destinationObjWrong);
            Assert.assertNull(compilerError);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
        Assert.assertTrue(destinationObjFixed.exists());
        Assert.assertFalse(destinationObjWrong.exists());
        Assert.assertTrue(destinationObjFixed.delete());

        //wrong input file
        try {
            compilerError = compiler.compileFile(new File[]{sourceCPP}, destinationObj);
            Assert.assertNull(compilerError);
            Assert.fail();
        } catch (IOException e) {
            Assert.assertFalse(destinationObj.exists());
        }

        //compilation error
        try {
            compilerError = compiler.compileFile(new File[]{wrongC}, destinationObj);
            Assert.assertNotNull(compilerError);
            System.err.println(compilerError);
            Assert.assertFalse(destinationObj.exists());
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void compileSharedLibraryTest() {
        String compilerError;
        NativeCompiler compiler = new NativeCompiler();
        try {
            compilerError = compiler.compileFile(new File[]{sourceC}, destinationObj);
            Assert.assertNull(compilerError);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
        Assert.assertTrue(destinationObj.exists());

        //unexistent file
        try {
            compilerError = compiler.compileSharedLib(new File[]{new File("iung" + SystemInfo.getObjectExtension())}, destinationLib);
            Assert.assertNull(compilerError);
            Assert.fail();
        } catch (IOException e) {
            //success!
            Assert.assertFalse(destinationLib.exists());
        }

        //not object file
        try {
            compilerError = compiler.compileSharedLib(new File[]{sourceC}, destinationLib);
            Assert.assertNull(compilerError);
            Assert.fail();
        } catch (IOException e) {
            Assert.assertFalse(destinationLib.exists());
        }

        //correct compilation
        try {
            compilerError = compiler.compileSharedLib(new File[]{destinationObj}, destinationLib);
            Assert.assertNull(compilerError);
            Assert.assertTrue(destinationLib.exists());
            Assert.assertTrue(destinationLib.delete());
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }

        //added extension
        try {
            compilerError = compiler.compileSharedLib(new File[]{destinationObj}, destinationLibWrong);
            Assert.assertNull(compilerError);
            Assert.assertFalse(destinationLibWrong.exists());
            Assert.assertTrue(destinationLibFixed.exists());
            Assert.assertTrue(destinationLibFixed.delete());
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
}
