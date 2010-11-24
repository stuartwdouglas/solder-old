package org.jboss.seam.solder.properties;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/**
 * Utility class for working with JavaBean style properties
 * 
 * @author Pete Muir
 * @author Shane Bryzak
 * 
 * @see Property
 */
public class Properties
{
   
   private Properties() {}
 
   /**
    * Create a JavaBean style property from the field
    * 
    * @param <V>
    * @param field
    * @return
    */
   public static <V> FieldProperty<V> createProperty(Field field)
   {
      return new FieldPropertyImpl<V>(field);
   }
   
   /**
    * Create a JavaBean style property from the specified method
    * 
    * @param <V>
    * @param method
    * @return
    * @throws IllegalArgumentException if the method does not match JavaBean conventions
    */
   public static <V> MethodProperty<V> createProperty(Method method)
   {
      return new MethodPropertyImpl<V>(method);
   }
   
   /**
    * Create a JavaBean style property from the specified member
    * 
    * @param <V>
    * @param member
    * @return
    * @throws IllegalArgumentException if the method does not match JavaBean conventions
    */
   public static <V> Property<V> createProperty(Member member)
   {
      if (member instanceof Method)
      {
         return new MethodPropertyImpl<V>(Method.class.cast(member));
      }
      else if (member instanceof Field)
      {
         return new FieldPropertyImpl<V>(Field.class.cast(member));
      }
      else
      {
         throw new IllegalArgumentException("Cannot make a property of " + member + " - it is neither a method or a field");
      }
   }
}
