package com.base.util.converter;

import com.base.util.exception.ConversionException;

/**
 * 指示类提供数据对象转换的功能。
 * 
 * @author houjun
 * @since 1.0
 * 
 * @param <S>
 *          作为源的对象类型。
 * @param <T>
 *          作为目标的对象类型。
 * 
 */
public interface Converter<S, T> {

  /**
   * 将指定的源数据对象转换为目标数据对象。
   * 
   * @param source
   *          源数据对象，传入nul将导致返回null。
   * @return 返回转换后的目标数据对象。
   * @throws ConversionException
   */
  T convert(S source) throws ConversionException;
}
