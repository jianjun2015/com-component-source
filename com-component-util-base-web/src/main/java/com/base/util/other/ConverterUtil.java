
package com.base.util.other;

import com.base.util.converter.Converter;
import org.springframework.core.convert.ConversionException;

import java.util.*;


/**
 * 提供与数据对象转换与注入相关操作的工具集。
 * 
 * @author houjun
 * 
 */
public class ConverterUtil {

  /**
   * 批量进行数据转换，此方法将会尝试对转换过程进行优化。<br>
   * 如果源数据对象集合中存在重复的对象（根据equals/hashCode的返回结果判断），将会尝试避免重复转换，
   * 因此在这种情况下转换结果列表中将会出现重复的目标对象。
   * 
   * @param <S>
   *          作为源的数据对象类型。
   * @param <T>
   *          作为目标的数据对象类型。
   * @param sources
   *          源对象集合，集合元素允许null，将导致转换后对应的目标对象也为null。传入null将导致返回null。
   * @param converter
   *          从源类型到目标类型的转换器。not null。
   * @return 返回转换后的目标数据对象列表，其中的顺序与参数sources的顺序（由对应的迭代器iterator()返回的顺序决定）一致。
   * @throws IllegalArgumentException
   *           当参数converter为null时抛出。
   * @throws ConversionException
   * @see #exhaustedlyConvert(Collection, Converter)
   */
  public static <S, T> List<T> convert(Collection<? extends S> sources, Converter<S, T> converter)
      throws IllegalArgumentException, ConversionException {
    if (sources == null) {
      return null;
    }
    if (converter == null) {
      throw new IllegalArgumentException("converter不能为空");
    }

    List<T> targets = new ArrayList<T>();
    Map<S, T> buffer = new HashMap<S, T>();
    for (S source : sources) {
      T target = null;
      if (buffer.containsKey(source)) {
        target = buffer.get(source);
      } else {
        target = converter.convert(source);
        buffer.put(source, target);
      }
      targets.add(target);
    }
    return targets;
  }

  /**
   * 批量进行数据转换，此方法将不采用任何优化措施。
   * 
   * @param <S>
   *          作为源的数据对象类型。
   * @param <T>
   *          作为目标的数据对象类型。
   * @param sources
   *          源对象集合，集合元素允许null，将导致转换后对应的目标对象也为null。传入null将导致返回null。
   * @param converter
   *          从源类型到目标类型的转换器。not null。
   * @return 返回转换后的目标数据对象列表，其中的顺序与参数sources的顺序（由对应的迭代器iterator()返回的顺序决定）一致。
   * @throws IllegalArgumentException
   *           当参数converter为null时抛出。
   * @throws ConversionException
   * @see #convert(Collection, Converter)
   */
  public static <S, T> List<T> exhaustedlyConvert(Collection<? extends S> sources, Converter<S, T> converter)
      throws IllegalArgumentException, ConversionException {
    if (sources == null) {
      return null;
    }
    if (converter == null) {
      throw new IllegalArgumentException("converter不能为空");
    }

    List<T> targets = new ArrayList<T>();
    for (S source : sources) {
      T target = converter.convert(source);
      targets.add(target);
    }
    return targets;
  }

}
