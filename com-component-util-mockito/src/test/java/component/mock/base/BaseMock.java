package component.mock.base;

import org.mockito.Mockito;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by wangjianjun on 2017/8/4.
 */
public abstract class BaseMock<T> implements FactoryBean<T> {

    public abstract void initMock(T mock);

    @Override
    public T getObject() throws Exception {
        T mock = Mockito.mock(getObjectType());
        initMock(mock);
        return mock;
    }

    @Override
    public Class<T> getObjectType() {
        Class<T> entityClass = null;
        Type t = getClass().getGenericSuperclass();

        if (t instanceof ParameterizedType){
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            entityClass = (Class<T>) p[0];
        }
        return entityClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
