package edu.ieselgrao.javadoc;

/**
 * Excepción personalizada usada en el sistema para indicar errores
 * relacionados con planetas, atmósferas o sistemas solares.
 * Extiende IllegalArgumentException.
 *
 * @author Anthony Mendoza
 */
public class UniverseException extends IllegalArgumentException {

    // Constants for error messages
    /**
     * Error cuando el nombre del planeta es inválido.
     */
    public static final String INVALID_PLANET_NAME = "[ERROR] Name cannot be null or empty";
    /**
     * Error cuando el número de lunas es negativo.
     */
    public static final String INVALID_NUMBER_OF_MOONS = "[ERROR] Number of moons cannot be negative";
    /**
     * Error cuando la masa del planeta es demasiado pequeña.
     */
    public static final String INVALID_MASS = "[ERROR] Mass cannot be less than 10e23 kg";
    /**
     * Error cuando el radio del planeta es menor que el mínimo permitido.
     */
    public static final String INVALID_PLANET_RADIUS = "[ERROR] Radius cannot be less than 500 km";
    /**
     * Error cuando la gravedad del planeta es negativa o cero.
     */
    public static final String INVALID_GRAVITY = "[ERROR] Gravity cannot be negative or zero";
    /**
     * Error cuando la fecha de la última medición del albedo es nula o futura.
     */
    public static final String INVALID_LAST_ALBEDO_MEASUREMENT = "[ERROR] Last albedo measurement cannot be null or in the future";
    /**
     * Error cuando el tipo de planeta no es válido.
     */
    public static final String INVALID_PLANET_TYPE = "[ERROR] Invalid planet type";

    // Constants for error messages
    /**
     * Error cuando la composición de la atmósfera es nula o vacía.
     */
    public static final String INVALID_COMPOSITION = "[ERROR] Composition cannot be null or empty";
    /**
     * Error cuando la fecha de la última observación es nula o futura.
     */
    public static final String INVALID_LAST_OBSERVATION = "[ERROR] Last observation cannot be null or in the future";
    /**
     * Error cuando la presión atmosférica es negativa.
     */
    public static final String INVALID_PRESSURE = "[ERROR] Pressure cannot be negative";
    /**
     * Error cuando la densidad atmosférica es negativa.
     */
    public static final String INVALID_DENSITY = "[ERROR] Density cannot be negative";
    /**
     * Error cuando el nombre del sistema solar es inválido.
     */
    public static final String INVALID_SOLAR_SYSTEM_NAME = "[ERROR] Name cannot be null, contain only spaces or have less than 3 characters";
    /**
     * Error cuando el número de estrellas es menor que 1.
     */
    public static final String INVALID_NUMBER_OF_STARS = "[ERROR] Number of stars cannot be less than 1";
    /**
     * Error cuando el radio del sistema solar es menor o igual a cero.
     */
    public static final String INVALID_SOLAR_SYSTEM_RADIUS = "[ERROR] Radius cannot be less or equal to 0";
    /**
     * Error cuando la fecha de registro es nula o futura.
     */
    public static final String INVALID_REGISTRATION_DATE = "[ERROR] Registration date cannot be null or in the future";
    /**
     * Error cuando la fecha del último planeta añadido es futura.
     */
    public static final String INVALID_LAST_PLANET_ADDED = "[ERROR] Last planet date added cannot be in the future";
    /**
     * Error cuando se ha alcanzado el número máximo de planetas.
     */
    public static final String INVALID_MAX_PLANETS = "[ERROR] Maximum number of planets reached";
    /**
     * Error cuando el planeta es nulo.
     */
    public static final String PLANET_NULL = "[ERROR] Planet cannot be null";
    /**
     * Error cuando el planeta ya existe en el sistema.
     */
    public static final String PLANET_ALREADY_EXISTS = "[ERROR] This planet already exists";
    /**
     * Error cuando el planeta no existe en el sistema.
     */
    public static final String PLANET_NOT_FOUND = "[ERROR] This planet does not exist";

    /**
     * Crea una nueva excepción del universo con un mensaje de error.
     *
     * @param message mensaje de error que describe el problema
     */
    public UniverseException(String message) {
        super(message);
    }
}
