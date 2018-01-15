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

import java.math.BigInteger;

/**
 * Kleinbaer-Class represents a specific Kleinbaer
 */
public class Kleinbaer {

    /**
     * the genus of a Kleinbaer
     */
    protected KleinbaerGenus genus = null;

    /**
     * counter to give out unique Id's
     */
    private static Integer idCounter = new Integer(0);

    /**
     * unique id of a Kleinbaer-Class
     */
    private Integer id;


    /**
     * @methodtype initialize
     * initialized all the Kleinbaerfacts and the genus of the Kleinbaer
     * @param genus for which the Kleinbaerfacts are set
     */
    public Kleinbaer(KleinbaerGenus genus){
        assertGenusNotNull(genus);
        setId();
    }

    /**
     * @methodtype get
     * @return ID of the Kleinbaer-Class
     */
    public Integer getId(){
        return id;
    }

    /**
     * @methodtype set
     * sets the id for a Kleinbaer-Class
     */
    private synchronized void setId(){
        id = idCounter++;
    }

    /**
     * @methodtype get
     * @return genus of the Kleinbaer
     */
    public KleinbaerGenus getGenus(){
        assertGenusNotNull(genus);
        return genus;
    }

    /**
     * ------------------------ Assertions ------------------------
     */

    /**
     * Asserts that the given genus is not null
     * @methodtype assertion
     * @throws KleinbaerException if given KleinbaerGenus-Class is null
     */
    private void assertGenusNotNull(KleinbaerGenus genus){
        if(genus == null){
            throw new KleinbaerException("KleinbaerGenus mustn't be null");
        }
    }

}
