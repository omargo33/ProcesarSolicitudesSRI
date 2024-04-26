package com.leon.batch.datasource;

/**
 * Clase que se utiliza para manejar el contexto de la fuente de datos en un
 * entorno de múltiples fuentes de datos.
 * 
 * En este caso, se utiliza para almacenar y recuperar el nombre de la fuente de
 * datos que se debe usar para una operación de base de datos específica.
 * 
 * La clase utiliza `ThreadLocal`, que es una clase en Java que proporciona
 * variables de hilo. Las variables de hilo son variables que tienen una copia
 * separada para cada hilo que las está utilizando. Esto es útil en un entorno
 * de múltiples hilos, donde diferentes hilos pueden necesitar usar diferentes
 * fuentes de datos.
 * 
 * Aquí está lo que hace cada método:
 * 
 * - `setBranchContext(String dataSourceEnum)`: Este método se utiliza para
 * establecer el nombre de la fuente de datos que se debe usar para el hilo
 * actual.
 * 
 * - `getBranchContext()`: Este método se utiliza para obtener el nombre de la
 * fuente de datos que se está utilizando para el hilo actual.
 * 
 * - `clearBranchContext()`: Este método se utiliza para eliminar el nombre de
 * la fuente de datos del hilo actual. Esto es útil para limpiar el contexto de
 * la fuente de datos después de que se ha completado una operación de base de
 * datos.
 * 
 * En resumen, esta clase proporciona una forma de manejar el contexto de la
 * fuente de datos en un entorno de múltiples fuentes de datos.
 * 
 * @author omargo33
 * @since 2024-04-02
 * 
 */
public class DataSourceContextHolder {
	private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

	private DataSourceContextHolder() {
		super();
	}

	public static void setBranchContext(String dataSourceEnum) {
		threadLocal.set(dataSourceEnum);
	}

	public static String getBranchContext() {
		return threadLocal.get();
	}

	public static void clearBranchContext() {
		threadLocal.remove();
	}
}
