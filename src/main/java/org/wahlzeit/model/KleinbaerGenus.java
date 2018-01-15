/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

/**
 * Represents a specific KleinbaerGenus
 */
public class KleinbaerGenus {

    /**
     * the scientific Declaration of Kleinbaer
     */
    private final String SCIENTIFIC_NAME = "Procyonidae";

    /**
     * The number of teeth a typical Kleinbaer-Genera has
     * Fun Fact: Kleinbaer have 40 teeth, Wickelbaeren have one less per row(total of 36)
     */
    private int numberOfTeeth;

    /**
     * Max weight of the Kleinbaer-Genus in gram
     */
    private int maxWeight;

    /**
     * Max tail length of the Kleinbaer-Genus in cm
     */
    private int maxTailLength;

    /**
     * Max length of the Kleinbaer-Genus without counting the tail in cm
     */
    private int maxSnoutVentLength;

    /**
     * @methodtype initialize
     * Create a new KleinbaerGenus with all the given Kleinbaerfacts
     */
    public KleinbaerGenus(int numberOfTeeth, int maxWeight, int maxTailLength, int maxSnoutVentLength){
        this.numberOfTeeth = numberOfTeeth;
        this.maxWeight = maxWeight;
        this.maxTailLength = maxTailLength;
        this.maxSnoutVentLength = maxSnoutVentLength;
    }

    /**
     * @methodtype initialize
     * @return new Kleinbaer-Class which was created with this KleinbaerGenus
     */
    public Kleinbaer createInstance(){
        return new Kleinbaer(this);
    }

    /**
     * @methodtyp get
     * @return the scientific family declaration for Kleinbaren
     */
    public String getSCIENTIFIC_NAME() {
        return SCIENTIFIC_NAME;
    }

    /**
     * @methodtype get
     * @return the number of teeth the Kleinbaer has
     */
    public int getNumberOfTeeth(){
        return numberOfTeeth;
    }


    /**
     * @methodtype get
     * @return maxWeight of the Kleinbaer in gramms
     */
    public int getMaxWeight(){
        return maxWeight;
    }

    /**
     * @methodtype get
     * @return maxTailLength of the Kleinbaer in cm
     */
    public int getMaxTailLength(){
        return maxTailLength;
    }

    /**
     * @methodtype get
     * @return maxSnoutVentLength of the Kleinbaer in cm
     */
    public int getMaxSnoutVentLength(){
        return maxSnoutVentLength;
    }

}
