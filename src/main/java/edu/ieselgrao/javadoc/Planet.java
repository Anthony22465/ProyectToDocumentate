package edu.ieselgrao.javadoc;
import java.time.LocalDate;
import static edu.ieselgrao.javadoc.UniverseException.*;

/**
 * Representa un planeta y sus propiedades.
 * Guarda información como sus lunas, masa, radio y atmósfera.
 *
 * @author Anthony Mendoza
 */
public class Planet {

    // Constants for minimum values
    private static final double MIN_MASS = 5.97e22;
    private static final double MIN_RADIUS = 500;

    // Attributes
    private String name;
    private int numberOfMoons;
    private double mass;
    private double radius;
    private double gravity;
    private LocalDate lastAlbedoMeasurement;
    private boolean hasRings;
    private Atmosphere atmosphere;
    private PlanetType type;

    // Basic constructor
    /**
     * Crea un planeta con sus propiedades básicas.
     *
     * @param name nombre del planeta
     * @param numberOfMoons número de lunas
     * @param mass masa del planeta
     * @param radius radio del planeta
     * @param gravity gravedad del planeta
     * @param lastAlbedoMeasurement fecha de la última medición de albedo
     * @param hasRings indica si el planeta tiene anillos
     * @param type tipo de planeta
     */
    public Planet(String name, int numberOfMoons, double mass, double radius, double gravity, LocalDate lastAlbedoMeasurement, boolean hasRings, PlanetType type) {
        setName(name);
        setNumberOfMoons(numberOfMoons);
        setMass(mass);
        setRadius(radius);
        setGravity(gravity);
        setLastAlbedoMeasurement(lastAlbedoMeasurement);
        setHasRings(hasRings);
        setType(type);

        atmosphere = null;
    }

    // Detailed constructor with atmosphere
    /**
     * Crea un planeta incluyendo información sobre su atmósfera.
     *
     * @param name nombre del planeta
     * @param numberOfMoons número de lunas
     * @param mass masa del planeta
     * @param radius radio del planeta
     * @param gravity gravedad del planeta
     * @param lastAlbedoMeasurement fecha de la última medición de albedo
     * @param hasRings indica si el planeta tiene anillos
     * @param type tipo de planeta
     * @param composition composición de la atmósfera
     * @param lastObservation última fecha de observación
     * @param airQuality índice de calidad del aire
     * @param pressure presión atmosférica
     * @param density densidad atmosférica
     * @param hasClouds indica si hay nubes
     */
    public Planet(String name, int numberOfMoons, double mass, double radius, double gravity, LocalDate lastAlbedoMeasurement, boolean hasRings, PlanetType type, String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        setName(name);
        setNumberOfMoons(numberOfMoons);
        setMass(mass);
        setRadius(radius);
        setGravity(gravity);
        setLastAlbedoMeasurement(lastAlbedoMeasurement);
        setHasRings(hasRings);
        setType(type);

        try {
            setAtmosphere(composition, lastObservation, airQuality, pressure, density, hasClouds);
        } catch (UniverseException e) {
            this.atmosphere = null;
        }
    }

    // Getters and setters
    public String getName() {
        return name;
    }
    /**
     * Establece el nombre del planeta.
     *
     * @param name nombre del planeta
     * @throws UniverseException si el nombre es nulo o vacío
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new UniverseException(INVALID_PLANET_NAME);
        }
        this.name = name;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }
    /**
     * Establece el número de lunas del planeta.
     *
     * @param numberOfMoons número de lunas
     * @throws UniverseException si el número es negativo
     */
    public void setNumberOfMoons(int numberOfMoons) {
        if (numberOfMoons < 0) {
            throw new UniverseException(INVALID_NUMBER_OF_MOONS);
        }
        this.numberOfMoons = numberOfMoons;
    }

    public double getMass() {
        return mass;
    }
    /**
     * Establece la masa del planeta.
     *
     * @param mass masa del planeta
     * @throws UniverseException si la masa es menor que el mínimo permitido
     */
    public void setMass(double mass) {
        if (mass < MIN_MASS) {
            throw new UniverseException(INVALID_MASS);
        }
        this.mass = mass;
    }
    public double getRadius() {
        return radius;
    }
    /**
     * Establece el radio del planeta.
     *
     * @param radius radio del planeta
     * @throws UniverseException si el radio es menor al mínimo permitido
     */
    public void setRadius(double radius) {
        if (radius < MIN_RADIUS) {
            throw new UniverseException(INVALID_PLANET_RADIUS);
        }
        this.radius = radius;
    }
    public double getGravity() {
        return gravity;
    }
    /**
     * Establece la gravedad del planeta.
     *
     * @param gravity valor de la gravedad
     * @throws UniverseException si la gravedad no es válida
     */
    public void setGravity(double gravity) {
        if (gravity <= 0) {
            throw new UniverseException(INVALID_GRAVITY);
        }
        this.gravity = gravity;
    }
    public LocalDate getLastAlbedoMeasurement() {
        return lastAlbedoMeasurement;
    }
    /**
     * Establece la fecha de la última medición del albedo.
     *
     * @param lastAlbedoMeasurement fecha de la medición
     * @throws UniverseException si la fecha es nula o futura
     */
    public void setLastAlbedoMeasurement(LocalDate lastAlbedoMeasurement) {
        // last albedo measurement is allowed to be today (LocalDate.now())
        if (lastAlbedoMeasurement == null || lastAlbedoMeasurement.isAfter(LocalDate.now())) {
            throw new UniverseException(INVALID_LAST_ALBEDO_MEASUREMENT);
        }
        this.lastAlbedoMeasurement = lastAlbedoMeasurement;
    }
    public boolean hasRings() {
        return hasRings;
    }
    /**
     * Indica si el planeta tiene anillos.
     *
     * @param hasRings true si tiene anillos
     */
    public void setHasRings(boolean hasRings) {
        this.hasRings = hasRings;
    }
    public Atmosphere getAtmosphere() {
        return atmosphere;
    }
    /**
     * Crea y asigna una atmósfera al planeta.
     *
     * @param composition composición de la atmósfera
     * @param lastObservation fecha de la última observación
     * @param airQuality calidad del aire
     * @param pressure presión atmosférica
     * @param density densidad atmosférica
     * @param hasClouds indica si hay nubes
     * @throws UniverseException si los datos de la atmósfera no son válidos
     */
    public void setAtmosphere(String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        // Can propagate UniverseException
        atmosphere = new Atmosphere(composition, lastObservation, airQuality, pressure, density, hasClouds);
    }

    public PlanetType getType() {
        return type;
    }
    /**
     * Establece el tipo de planeta.
     *
     * @param type tipo de planeta
     * @throws UniverseException si el tipo es nulo
     */
    public void setType(PlanetType type) {
        if (type == null) {
            throw new UniverseException(INVALID_PLANET_TYPE);
        }
        this.type = type;
    }





}
