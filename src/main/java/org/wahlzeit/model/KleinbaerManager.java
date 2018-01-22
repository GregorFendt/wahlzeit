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

import com.googlecode.objectify.annotation.Entity;
import org.wahlzeit.services.ObjectManager;

import java.util.HashMap;
import java.util.Map;

@Entity
public class KleinbaerManager extends ObjectManager {

    /**
     * Singleton instance of KleinbaerManager
     */
    private static final KleinbaerManager manager = new KleinbaerManager();
    /**
     * Accepted genera of Kleinbaer, mainly extinct genera are ignored
     */
    public enum kleinbaerengenus {
        MAKIBAER, WICKELBAER, KATZENFRETT, WASCHBAER, NASENBAER, BERNASENBAER
    }

    /**
     * List of all Kleinbaer-Classes
     */
    protected Map<Integer, Kleinbaer> kleinbaerHashmap = new HashMap<Integer, Kleinbaer>();

    /**
     * List of all KleinbaerGenera
     */
    protected Map<String, KleinbaerGenus> genusHashMap = new HashMap<String, KleinbaerGenus>();

    /**
     * private constructor
     */

    private KleinbaerManager(){
        //do nothing
    }

    /**
     * @methodtype getter
     * @return the only instance of KleinbaerManager
     */
    public static KleinbaerManager getInstance(){
        assertManagerNotNull();
        return manager;
    }

    /**
     * Creates a new KleinbaerClass out of the given genus
     * @param genus which will be used to create the KleinbaerClass
     * @return new KleinbaerClass
     */
    public Kleinbaer createKleinbaer(String genus){
        assertIsValidKleinbaerGenus(genus);
        KleinbaerGenus kg = getKleinbaerGenus(genus);
        Kleinbaer result = kg.createInstance();
        kleinbaerHashmap.put(result.getId(), result);
        return result;
    }

    /**
     * Creates and returns a new KleinbaerGenus
     * @return the newly created KleinbaerGenus
     */
    public KleinbaerGenus createKleinbaerGenus(String genus, int numberOfTeeth, int maxWeight, int maxTailLength, int maxSnoutVentLength){
        assertGenusDoesNotExist(genus);
        KleinbaerGenus kg = new KleinbaerGenus(numberOfTeeth, maxWeight, maxTailLength, maxSnoutVentLength);
        genusHashMap.put(genus, kg);
        return kg;
    }

    /**
     * @methodtype getter
     * @param genus Name of the Genus to be returned
     * @return the Kleinbaergenus with the name genus if already created
     */
    protected KleinbaerGenus getKleinbaerGenus(String genus){
        assertIsValidKleinbaerGenus(genus);
        return genusHashMap.get(genus);
    }

    /**
     * ------------------------ Assertions ------------------------
     */

    /**
     * Assert if the static initialized manager is not null
     * @methodtype assertion
     * @throws KleinbaerException if manager was null
     */
    private static void assertManagerNotNull(){
        if(manager == null){
            throw new KleinbaerException("Static initialized manager was null!");
        }
    }
    /**
     * Asserts if the given genus already exists
     * @methodtype assertion
     * @throws KleinbaerException if given KleinbaerGenus doesnt exist
     */
    private void assertIsValidKleinbaerGenus(String genus){
        if(!genusHashMap.containsKey(genus)) {
            throw new KleinbaerException("Given KleinbaerGenus doesn't exist yet!");
        }
    }

    /**
     * Asserts if the given genus doesnt exist in the genusList
     * @methodtype assertion
     * @throws KleinbaerException if given KleinbaerGenus already exists in the genusList
     */
    private void assertGenusDoesNotExist(String genus){
        if(genusHashMap.containsKey(genus)){
            throw new KleinbaerException("KleinbaerGenus can't be created twice!");
        }
    }
}
