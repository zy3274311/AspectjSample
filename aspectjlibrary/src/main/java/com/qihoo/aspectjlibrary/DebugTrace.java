package com.qihoo.aspectjlibrary;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zhangying-pd on 2016/6/29.
 * 被注释的方法将被跟踪并且将会与Aspect程序中截获该注释的Advise关联，调用该切点
 * 的Advise
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface DebugTrace {}
