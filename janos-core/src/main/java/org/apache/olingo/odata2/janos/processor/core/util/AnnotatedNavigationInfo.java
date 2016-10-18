package org.apache.olingo.odata2.janos.processor.core.util;

import org.apache.olingo.odata2.api.annotation.edm.EdmNavigationProperty;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnnotatedNavigationInfo {

  private class NavInfo {
    private final Field field;
    private final EdmNavigationProperty navProp;
    private NavInfo(Field field, EdmNavigationProperty navProp) {
      this.field = field;
      this.navProp = navProp;
    }
  }

  private List<NavInfo> navsFromSource;
  private List<NavInfo> navsFromTarget;

  public AnnotatedNavigationInfo(Class<?> sourceClass, Class<?> targetClass) {
    navsFromSource = annotatedNavFields(sourceClass, targetClass);
    navsFromTarget = annotatedNavFields(targetClass, sourceClass);
  }

  private List<NavInfo> annotatedNavFields(Class<?> sourceClass, Class<?> targetClass) {
    final List<NavInfo> navInfos = new ArrayList<>();
    if (sourceClass == null || targetClass == null) {
      return navInfos;
    }
    return Arrays.stream(sourceClass.getDeclaredFields())
        .filter(fld -> fld.getAnnotation(EdmNavigationProperty.class) != null)
        .filter(fld -> ClassHelper.getFieldType(fld) != targetClass)
        .map(fld -> new NavInfo(fld, fld.getAnnotation(EdmNavigationProperty.class)))
        .collect(Collectors.toList());
  }

  public boolean isBidirectional() {
    return navsFromSource != null && navsFromTarget != null;
  }

  @Override
  public String toString() {
    return "AnnotatedNavigationInfo{" +
        "navsFromSource=" + navsFromSource +
        ", navsFromTarget=" + navsFromTarget +
        '}';
  }
}
