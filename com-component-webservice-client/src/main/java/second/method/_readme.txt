CMD下 执行
 wsimport  -keep -second.method -s . http://localhost:9000/HelloWorld
 注意:second.method-[这个是对应的生成文件所在包路径，如果不指定，则会出现Exception in thread "main" com.sun.xml.internal.ws.spi.db.DatabindingException: com.sun.xml.internal.bind.v2.runtime.IllegalAnnotationsException: 2 counts of IllegalAnnotationExceptions]
生成java文件,拷贝到对应目录
