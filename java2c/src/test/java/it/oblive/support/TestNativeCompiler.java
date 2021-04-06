package it.oblive.support;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

    @BeforeAll
    public static void setSourceUrl() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("helloworld.c");
        Assertions.assertNotNull(url);
        sourceC = new File(url.getPath());
        url = Thread.currentThread().getContextClassLoader().getResource("helloworld.cpp");
        Assertions.assertNotNull(url);
        sourceCPP = new File(url.getPath());
        url = Thread.currentThread().getContextClassLoader().getResource("helluword.c");
        Assertions.assertNotNull(url);
        wrongC = new File(url.getPath());
        destinationObj =
                new File(System.getProperty("user.dir") + File.separator + "builtdc" + SystemInfo.getObjectExtension());
        destinationObjWrong = new File(System.getProperty("user.dir") + File.separator + "builtc.txt");
        destinationObjFixed = new File(destinationObjWrong.getAbsoluteFile() + SystemInfo.getObjectExtension());
        destinationLib =
                new File(System.getProperty("user.dir") + File.separator + "builtlib" + SystemInfo.getSharedLibraryExtension());
        destinationLibWrong = new File(System.getProperty("user.dir") + File.separator + "builtlib.txt");
        destinationLibFixed =
                new File(System.getProperty("user.dir") + File.separator + "builtlib.txt" + SystemInfo.getSharedLibraryExtension());
    }

    @AfterAll
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
            compiler.compileFile(new File[]{sourceC}, destinationObj, false);
        } catch (IOException | CompilationException | InterruptedException e) {
            Assertions.fail(e.getMessage());
        }
        Assertions.assertTrue(destinationObj.exists()); //the file exists
        Assertions.assertTrue(destinationObj.delete()); //do not leave garbage around

        //incorrect output extension, the new extension should be appended
        try {
            compiler.compileFile(new File[]{sourceC}, destinationObjWrong, false);
        } catch (IOException | CompilationException | InterruptedException e) {
            Assertions.fail(e.getMessage());
        }
        Assertions.assertTrue(destinationObjFixed.exists());
        Assertions.assertFalse(destinationObjWrong.exists());
        Assertions.assertTrue(destinationObjFixed.delete());

        //wrong input file
        try {
            compiler.compileFile(new File[]{sourceCPP}, destinationObj, false);
            Assertions.fail("Exception not thrown");
        } catch (IOException e) {
            Assertions.assertFalse(destinationObj.exists());
        } catch (CompilationException | InterruptedException e) {
            Assertions.fail("Wrong exception thrown");
        }

        //compilation error
        try {
            compiler.compileFile(new File[]{wrongC}, destinationObj, false);
            Assertions.fail("Exception not thrown");
        } catch (IOException | InterruptedException e) {
            Assertions.fail("Wrong exception type");
        } catch (CompilationException e) {
            Assertions.assertFalse(destinationObj.exists());
        }
    }

    @Test
    public void compileSharedLibraryTest() {
        NativeCompiler compiler = new NativeCompiler();
        try {
            compiler.compileFile(new File[]{sourceC}, destinationObj, false);
        } catch (IOException | CompilationException | InterruptedException e) {
            Assertions.fail(e.getMessage());
        }
        Assertions.assertTrue(destinationObj.exists());

        //non-existent file
        try {
            compiler.compileSharedLib(new File[]{new File("iung" + SystemInfo.getObjectExtension())},
                    destinationLib);
            Assertions.fail("Exception not thrown");
        } catch (IOException e) {
            //success!
            Assertions.assertFalse(destinationLib.exists());
        } catch (CompilationException | InterruptedException e) {
            Assertions.fail("Wrong exception thrown");
        }

        //not object file
        try {
            compiler.compileSharedLib(new File[]{sourceC}, destinationLib);
            Assertions.fail("Exception not thrown");
        } catch (IOException e) {
            Assertions.assertFalse(destinationLib.exists());
        } catch (CompilationException | InterruptedException e) {
            Assertions.fail("Wrong exception thrown");
        }

        //correct compilation
        try {
            compiler.compileSharedLib(new File[]{destinationObj}, destinationLib);
            Assertions.assertTrue(destinationLib.exists());
            Assertions.assertTrue(destinationLib.delete());
        } catch (IOException | CompilationException | InterruptedException e) {
            Assertions.fail(e.getMessage());
        }

        //added extension
        try {
            compiler.compileSharedLib(new File[]{destinationObj}, destinationLibWrong);
            Assertions.assertFalse(destinationLibWrong.exists());
            Assertions.assertTrue(destinationLibFixed.exists());
            Assertions.assertTrue(destinationLibFixed.delete());
        } catch (IOException | CompilationException | InterruptedException e) {
            Assertions.fail(e.getMessage());
        }
    }
}
