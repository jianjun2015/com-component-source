load、get、iterate查询实体对象时，支持一级缓存，但查询普通属性时不支持一级缓存，当我们大批量数据插入或更新时，由于缓存中数据量太大，我们可以设置缓存中的条数，使用session.clear()来清除缓存


Hibernate二级缓存总结

从上可知，二级缓存时比一级缓存作用域更大，是在整个应用程序中。一级缓存是不能被卸载的，是必需的，不允许也无法卸载，它是事务范围的缓存。而二级缓存是可配置的，可卸载的，SessionFactory生命周期和应用程序整个过程对应，就有可能出现并发问题。

什么样的数据适合放到二级缓存中？

1、          很少被修改的数据

2、          不是很重要的，并允许出现偶尔的并发数据

3、          不会被并发的数据

4、          常量数据



什么样的数据适不合放到二级缓存中？

1、          经常被修改的数据。

2、          绝对不允许并发的数据。

3、          与其他应用共享的数据