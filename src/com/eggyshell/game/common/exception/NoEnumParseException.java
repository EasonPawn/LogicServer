package com.eggyshell.game.common.exception;

/**
 * 枚举转换异常
 * @author Pawn
 * @date 2018年8月30日
 */
public class NoEnumParseException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoEnumParseException(Class<?> class1, Object object) {
		super("No enum of " + class1.getName() + " for value " + object);
	}
	
}
