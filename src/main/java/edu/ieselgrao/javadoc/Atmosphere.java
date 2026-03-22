package edu.ieselgrao.javadoc;
import java.time.LocalDate;

import static edu.ieselgrao.javadoc.UniverseException.*;

/**
 * Representa la atmósfera de un planeta.
 * Contiene información como su composición, presión y densidad.
 *
 * @author Anthony Mendoza
 */
public class Atmosphere {

    // Attributes
    private String composition;
    private LocalDate lastObservation;
    private int airQuality;
    private double pressure;
    private double density;
    private boolean hasClouds;

    // Constructor
    /**
     * Crea una atmósfera con sus propiedades.
     *
     * @param composition composición de la atmósfera
     * @param lastObservation fecha de la última observación
     * @param airQuality índice de calidad del aire
     * @param pressure presión atmosférica
     * @param density densidad atmosférica
     * @param hasClouds indica si hay nubes
     */
    public Atmosphere(String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        setComposition(composition);
        setLastObservation(lastObservation);
        setAirQuality(airQuality);
        setPressure(pressure);
        setDensity(density);
        setHasClouds(hasClouds);
    }

    // Getters and setters
    public String getComposition() {
        return composition;
    }
    /**
     * Establece la composición de la atmósfera.
     *
     * @param composition composición de la atmósfera
     * @throws UniverseException si la composición no es válida
     */
    public void setComposition(String composition) {
        if (composition == null || composition.trim().isEmpty() || !composition.matches("[a-zA-Z0-9, ]+")) {
            throw new UniverseException(INVALID_COMPOSITION);
        }
        this.composition = composition;
    }

    public LocalDate getLastObservation() {
        return lastObservation;
    }
    /**
     * Establece la fecha de la última observación de la atmósfera.
     *
     * @param lastObservation fecha de observación
     * @throws UniverseException si la fecha es nula o futura
     */
    public void setLastObservation(LocalDate lastObservation) {
        // LocalDate.now() can be setted
        if (lastObservation == null || lastObservation.isAfter(LocalDate.now())) {
            throw new UniverseException(INVALID_LAST_OBSERVATION);
        }
        this.lastObservation = lastObservation;
    }

    public int getAirQuality() {
        return airQuality;
    }
    /**
     * Establece la calidad del aire.
     * El valor se ajusta al rango entre 0 y 100.
     *
     * @param airQuality índice de calidad del aire
     */
    public void setAirQuality(int airQuality) {
        // Adjust to range [0, 100]
        if (airQuality < 0) {
            this.airQuality = 0;
        } else if (airQuality > 100) {
            this.airQuality = 100;
        } else {
            this.airQuality = airQuality;
        }
    }


    public double getPressure() {
        return pressure;
    }
    /**
     * Establece la presión de la atmósfera.
     *
     * @param pressure presión atmosférica
     * @throws UniverseException si la presión es negativa
     */
    public void setPressure(double pressure) {
        if (pressure < 0) {
            throw new UniverseException(INVALID_PRESSURE);
        }
        this.pressure = pressure;
    }

    public double getDensity() {
        return density;
    }
    /**
     * Establece la densidad de la atmósfera.
     *
     * @param density densidad atmosférica
     * @throws UniverseException si la densidad es negativa
     */
    public void setDensity(double density) {
        if (density < 0) {
            throw new UniverseException(INVALID_DENSITY);
        }
        this.density = density;
    }
    public boolean hasClouds() {
        return hasClouds;
    }
    /**
     * Indica si la atmósfera tiene nubes.
     *
     * @param hasClouds true si hay nubes
     */
    public void setHasClouds(boolean hasClouds) {
        this.hasClouds = hasClouds;
    }

}
