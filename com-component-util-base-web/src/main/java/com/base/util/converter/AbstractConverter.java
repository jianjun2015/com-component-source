package com.base.util.converter;


import com.base.util.entity.HasCreateInfo;
import com.base.util.entity.HasId;
import com.base.util.entity.HasModifyInfo;
import com.base.util.entity.HasVersion;
import com.base.util.exception.ConversionException;

/**
 * Created by houjun on 2016-5-5.
 */
public abstract class AbstractConverter<S, T> implements Converter<S, T> {

    @Override
    public T convert(S source) throws ConversionException {
        if (source == null)
            return null;
        T target = initTarget();
        if (target == null)
            throw new ConversionException("实例化的target不能为空.");
        assignValue(target, source);

        if (source instanceof HasId && target instanceof HasId) {
            ((HasId) target).setId(((HasId) source).getId());
        }

        if (source instanceof HasVersion && target instanceof HasVersion) {
            ((HasVersion) target).setEdition(((HasVersion) source).getEdition());
        }

        if (source instanceof HasCreateInfo && target instanceof HasCreateInfo) {
            ((HasCreateInfo) target).setCreateBy(((HasCreateInfo) source).getCreateBy());
            ((HasCreateInfo) target).setCreateTime(((HasCreateInfo) source).getCreateTime());
        }

        if (source instanceof HasModifyInfo && target instanceof HasModifyInfo) {
            ((HasModifyInfo) target).setModifyBy(((HasModifyInfo) source).getModifyBy());
            ((HasModifyInfo) target).setModifyTime(((HasModifyInfo) source).getModifyTime());
        }
        return target;
    }

    /**
     * 赋值
     *
     * @param target 目标对象,not null
     * @param source 起始对象, not null
     */
    protected abstract void assignValue(T target, S source);


    /**
     * @return 目标对象的初始化
     */
    protected abstract T initTarget();
}
