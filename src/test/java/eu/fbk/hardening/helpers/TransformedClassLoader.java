package eu.fbk.hardening.helpers;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;
import java.security.AccessControlException;
import java.security.Policy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class loader loads classes and resources in the same way of {@see URLClassLoader}
 * but using a URL first delegation method.
 * <p>
 * The search sequence is:
 * <ol>
 * <li>local search (by this class loader) mandatory for transformed classes</li>
 * <li>local cache</li>
 * <li>boot class loader</li>
 * <li>parent class loader</li>
 * </ol>
 * The first match of the class is the one returned.
 * <p>
 * Part of this code is from the Apache Tomcat Project and is released under ASF License:
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * @author Andrea Nasato
 * @author mariano
 */
public class TransformedClassLoader extends URLClassLoader
{

    /**
     * List of classes that we permit to search in the parent class loader.
     */
    /*final List<String> allowedClassesFromParent = Arrays.asList("eu.twoaspire.split.Slice",
            "eu.twoaspire.split.Slice$InputData","eu.twoaspire.split.Slice$OutputData");*/

    private static final String CLASS_FILE_SUFFIX = ".class";

    private ClassLoader javaSEClassLoader;

    private SecurityManager sm;

    // classes that must be load locally and not delegated to other class loaders
    private Set<String> localClasses;

    //private String[] jars;

    public TransformedClassLoader(URL[] urls, ClassLoader parent, String[] localClasses)
    {
        super(urls, parent);
        initializeLocalFields(localClasses);
    }

    public TransformedClassLoader(URL[] urls, String[] localClasses)
    {
        super(urls);
        initializeLocalFields(localClasses);
    }

    public TransformedClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory, String[] localClasses)
    {
        super(urls, parent, factory);
        initializeLocalFields(localClasses);
    }


    @Override
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException
    {

        synchronized (getClassLoadingLock(name))
        {

            Class<?> c = null;


            // 1. local search: I'm giving precedence to the URL, because the a class with 
            //    the same name (the non-transformed one) should be available in the path
            try
            {
                c = findClass(name);
                if (c != null)
                {
                    /*if(logger.isDebugEnabled()) {
                        logger.debug("class: " + name + " loaded from local search");
                    }*/
                    if (resolve)
                    {
                        resolveClass(c);
                    }
                    return c;
                }
            } catch (ClassNotFoundException e)
            {
                // Ignore
            }

            //1.1 it the class is a transformed one, it should fail now
            if (localClasses.contains(name))
            {
                String message = "Class " + name + "should be available in the specified URL(s)";
                throw new ClassNotFoundException(message);
            }

            // 2. check if class is already loaded in the cache
            c = findLoadedClass(name);

            if (c != null)
            {
                /*if(logger.isDebugEnabled()) {
                    logger.debug("class: " + name + " loaded from cache");
                }*/
                if (resolve)
                {
                    resolveClass(c);
                }

                return c;
            }

            // 3. load class from system class loader
            String resourceName = binaryNameToPath(name, false);
            ClassLoader javaSELoader = getJavaSEClassLoader();
            if (javaSELoader.getResource(resourceName) != null)
            {
                try
                {
                    c = javaSELoader.loadClass(name);
                    if (c != null)
                    {
                        /*if(logger.isDebugEnabled()) {
                            logger.debug("class: " + name + " loaded from javaSEClassLoader");
                        }*/
                        if (resolve)
                        {
                            resolveClass(c);
                        }

                        return c;
                    }
                } catch (ClassNotFoundException e)
                {
                    // Ignore
                }
            }

            // 3.1 Permission to access this class when using a SecurityManager
            if (sm != null)
            {
                int i = name.lastIndexOf('.');
                if (i >= 0)
                {
                    try
                    {
                        sm.checkPackageAccess(name.substring(0, i));
                    } catch (SecurityException se)
                    {
                        String error = "Security Violation, attempt to use " +
                                "Restricted Class: " + name;
                        /*logger.info(error, se);*/
                        throw new ClassNotFoundException(error, se);
                    }
                }
            }


            // 4. last resort: parent search for any class
            try
            {
                //if(allowedClassesFromParent.stream().anyMatch(s -> s.equals(name))) {
                c = Class.forName(name, false, getParent());
                if (c != null)
                {
                        /*if (logger.isDebugEnabled()) {
                            logger.debug("class: " + name + " loaded from parent");
                        }*/
                    if (resolve)
                    {
                        resolveClass(c);
                    }

                    return c;
                }
                //}
            } catch (ClassNotFoundException e)
            {
                // Ignore
            }

        }
        throw new ClassNotFoundException(name);
    }


    public ClassLoader getJavaSEClassLoader()
    {
        return javaSEClassLoader;
    }

    public void setJavaSEClassLoader(ClassLoader javaSEClassLoader)
    {
        if (javaSEClassLoader == null)
        {
            throw new IllegalArgumentException(
                    "javaSEClassLoader cannot be null");
        }
        this.javaSEClassLoader = javaSEClassLoader;
    }

    private String binaryNameToPath(String binaryName, boolean withLeadingSlash)
    {
        // 1 for leading '/', 6 for ".class"
        StringBuilder path = new StringBuilder(7 + binaryName.length());
        if (withLeadingSlash)
        {
            path.append('/');
        }
        path.append(binaryName.replace('.', '/'));
        path.append(CLASS_FILE_SUFFIX);
        return path.toString();
    }

    private void initializeLocalFields(String[] localClasses)
    {
        this.localClasses = new HashSet<String>(Arrays.asList(localClasses));
        ClassLoader j = String.class.getClassLoader();
        if (j == null)
        {
            j = getSystemClassLoader();
            while (j.getParent() != null)
            {
                j = j.getParent();
            }
        }
        this.javaSEClassLoader = j;

        sm = System.getSecurityManager();
        if (sm != null)
        {
            refreshPolicy();
        }
    }

    /**
     * Refresh the system policy file, to pick up eventual changes.
     */
    protected void refreshPolicy()
    {

        try
        {
            // The policy file may have been modified to adjust
            // permissions, so we're reloading it when loading or
            // reloading a Context
            Policy policy = Policy.getPolicy();
            policy.refresh();
        } catch (AccessControlException e)
        {
            // Some policy files may restrict this, even for the core,
            // so this exception is ignored
        }
    }
}