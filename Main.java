package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            Class concreteClass = Class.forName("reflection.ConcreteClass");
            concreteClass = new ConcreteClass(7).getClass();

            // Get the canonical name of the class
            System.out.println("1. Canonical name of the class: \n" + concreteClass.getCanonicalName());

            // Get the superclass
            Class superClass = concreteClass.getSuperclass();
            System.out.println("2. superclass: \n" + superClass);

            // Get the public interface members inherited from super classes
            // and the public class interface members declared by the class
            Class[] classes = concreteClass.getClasses();
            System.out.println("3. public members classes: \n" + Arrays.toString(classes));

            // Get all the classes and interfaces declared as members of the class (not inherited)
            Class[] declared = concreteClass.getDeclaredClasses();
            System.out.println(Arrays.toString(declared));

            // Get the class Modifiers
            System.out.println(Modifier.toString(concreteClass.getModifiers()));
            System.out.println(Modifier.toString(Class.forName("com.labA.reflection.BaseInterface").getModifiers()));

            // Get the implemented interfaces
            Type[] interfaces = concreteClass.getInterfaces();
            System.out.println(Arrays.toString(interfaces));

            //Get the public methods
            Method[] publicMethods = concreteClass.getMethods();
            System.out.println(Arrays.toString(publicMethods));

            //Get the public constructors
            Constructor[] constructs = concreteClass.getConstructors();
            System.out.println(Arrays.toString(constructs));

            //Get public fields
            Field[] fields = concreteClass.getFields();
            System.out.println(Arrays.toString(fields));

            //Get class annotations
            Annotation[] annotations = concreteClass.getAnnotations();
            System.out.println(Arrays.toString(annotations));

            // Get the constructors and use the constructors to create a new instance


            // Get the constructors and use the Constructor class to create new instance
            Constructor constructor = ConcreteClass.class.getConstructor(int.class);
            Object myObject = (Object) constructor.newInstance(10);


            //Get public fields
            ConcreteClass c1 = new ConcreteClass(10);
            Field field = ConcreteClass.class.getDeclaredField("publicInt");
            field.setInt(c1, 50);

            //prints public fields of ConcreteClass, its superclass and super interfaces
            //Field field = concreteClass.getFields("interfaceInt");
            Field field2 = ConcreteClass.class.getDeclaredField("publicInt");

        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}
