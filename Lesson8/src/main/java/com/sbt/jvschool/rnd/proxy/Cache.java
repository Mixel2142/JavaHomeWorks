package com.sbt.jvschool.rnd.proxy;

import jdk.nashorn.internal.objects.annotations.Function;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    /*
    Выбор способа кэширования в RAM или в файле.
    RAM - default
     */
    CacheTypeState cacheType() default CacheTypeState.RAM;

    /*
    Название папки в которой будет лежать файл.
    data/ - default
     */
    String fileNamePrefix() default "data";

    /*
    Включить/отключить архивирование файла в zip.
    отключено(false) - default
     */
    boolean zip() default false;

    /*
         Показывает какие аргументы метода учитывать при определении уникальности результата,
         а какие игнорировать(по умолчанию все аргументы учитываются)
     */
    Class[] identityBy() default {};

    /*
     Если возвращаемый тип метода это List, возможно указывать максимальное количество элементов,
      которое достаточно хранить в кеше.
      100 тыс. - default
     */
    int listList() default 100_000;
}

enum CacheTypeState {
    FILE,
    RAM
}