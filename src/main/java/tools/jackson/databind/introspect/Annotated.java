package tools.jackson.databind.introspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Modifier;

import tools.jackson.databind.JavaType;

/**
 * Shared base class used for anything on which annotations (included
 * within a {@link AnnotationMap}).
 */
public abstract class Annotated
{
    protected Annotated() { }

    public abstract <A extends Annotation> A getAnnotation(Class<A> acls);

    public abstract boolean hasAnnotation(Class<?> acls);

    public abstract boolean hasOneOf(Class<? extends Annotation>[] annoClasses);

    /**
     * Method that can be used to find actual JDK element that this instance
     * represents. It is non-null, except for method/constructor parameters
     * which do not have a JDK counterpart.
     */
    public abstract AnnotatedElement getAnnotated();

    protected abstract int getModifiers();

    public boolean isPublic() {
        return Modifier.isPublic(getModifiers());
    }

    /**
     * @since 2.16.2
     */
    public boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    public abstract String getName();

    /**
     * Full generic type of the annotated element; definition
     * of what exactly this means depends on sub-class.
     */
    public abstract JavaType getType();

    /**
     * "Raw" type (type-erased class) of the annotated element; definition
     * of what exactly this means depends on sub-class.
     */
    public abstract Class<?> getRawType();

    // Also: ensure we can use #equals, #hashCode

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

    @Override
    public abstract String toString();
}
