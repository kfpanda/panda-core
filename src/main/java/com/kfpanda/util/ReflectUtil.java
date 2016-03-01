package com.kfpanda.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 反射工具类
 * 
 * @author kfpanda
 * @date 2015年1月8日 下午2:23:04
 */
public class ReflectUtil {
	// private static Logger log = Logger.getLogger(ReflectUtil.class);

	private static Object operate(Object obj, String fieldName,
			Object fieldVal, String type) {
		Object ret = null;
		try {
			// 获得对象类型
			Class<? extends Object> classType = obj.getClass();
			// 获得对象的所有属�?
			Field fields[] = classType.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				if (field.getName().equals(fieldName)) {

					String firstLetter = fieldName.substring(0, 1)
							.toUpperCase(); // 获得和属性对应的getXXX()方法的名�?
					if ("set".equals(type)) {
						String setMethodName = "set" + firstLetter
								+ fieldName.substring(1); // 获得和属性对应的getXXX()方法
						Method setMethod = classType.getMethod(setMethodName,
								new Class[] { field.getType() }); // 调用原对象的getXXX()方法
						ret = setMethod.invoke(obj, new Object[] { fieldVal });
					}
					if ("get".equals(type)) {
						String getMethodName = "get" + firstLetter
								+ fieldName.substring(1); // 获得和属性对应的setXXX()方法的名�?
						Method getMethod = classType.getMethod(getMethodName,
								new Class[] {});
						ret = getMethod.invoke(obj, new Object[] {});
					}
					return ret;
				}
			}
		} catch (Exception e) {
			// log.warn("reflect error:" + fieldName, e);
		}
		return ret;
	}

	/**
	 * 说明:反射得到指定的值
	 * @param obj
	 * @param fieldName
	 * @return Object
	 */
	public static Object getVal(Object obj, String fieldName) {
		return operate(obj, fieldName, null, "get");
	}

	/**
	 * 说明:反射设置指定的值
	 * @param obj
	 * @param fieldName
	 * @param fieldVal
	 * @return void
	 */
	public static void setVal(Object obj, String fieldName, Object fieldVal) {
		operate(obj, fieldName, fieldVal, "set");
	}

	/**
	 * 说明:得到接口申明的方法
	 * @param object
	 * @param methodName
	 * @param parameterTypes
	 * @return Method
	 */
	private static Method getDeclaredMethod(Object object, String methodName,
			Class<?>[] parameterTypes) {
		for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				// superClass.getMethod(methodName, parameterTypes);
				return superClass.getDeclaredMethod(methodName, parameterTypes);
			} catch (NoSuchMethodException e) {
				// Method 不在当前类定�? 继续向上转型
			}
		}

		return null;
	}

	/**
	 * 说明:如果是非public 属性 设置可访问
	 * @param field
	 * @return void
	 * @author dozen.zhang
	 * @date 2015年6月5日下午2:59:01
	 */
	private static void makeAccessible(Field field) {
		if (!Modifier.isPublic(field.getModifiers())) {
			field.setAccessible(true);
		}
	}

	/**
	 * 说明:得到对象字段
	 * @param object
	 * @param filedName
	 * @return Field
	 */
	private static Field getDeclaredField(Object object, String filedName) {
		for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				return superClass.getDeclaredField(filedName);
			} catch (NoSuchFieldException e) {
				// Field 不在当前类定�? 继续向上转型
			}
		}
		return null;
	}

	/**
	 * 说明:反射方法
	 * @param object
	 * @param methodName
	 * @param parameterTypes
	 * @param parameters
	 * @throws InvocationTargetException
	 * @return Object
	 */
	public static Object invokeMethod(Object object, String methodName,
			Class<?>[] parameterTypes, Object[] parameters)
			throws InvocationTargetException {
		Method method = getDeclaredMethod(object, methodName, parameterTypes);

		if (method == null) {
			throw new IllegalArgumentException("Could not find method ["
					+ methodName + "] on target [" + object + "]");
		}

		method.setAccessible(true);

		try {
			return method.invoke(object, parameters);
		} catch (IllegalAccessException e) {

		}

		return null;
	}

	/**
	 * 说明:设置字段值
	 * @param object
	 * @param fieldName
	 * @param value
	 * @return void
	 */
	public static void setFieldValue(Object object, String fieldName,
			Object value) {
		Field field = getDeclaredField(object, fieldName);

		if (field == null)
			throw new IllegalArgumentException("Could not find field ["
					+ fieldName + "] on target [" + object + "]");

		makeAccessible(field);

		try {
			field.set(object, value);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 说明:得到字段值
	 * @param object
	 * @param fieldName
	 * @return Object
	 */
	public static Object getFieldValue(Object object, String fieldName) {
		Field field = getDeclaredField(object, fieldName);
		if (field == null)
			throw new IllegalArgumentException("Could not find field ["
					+ fieldName + "] on target [" + object + "]");

		makeAccessible(field);

		Object result = null;
		try {
			result = field.get(object);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return result;
	}

}
