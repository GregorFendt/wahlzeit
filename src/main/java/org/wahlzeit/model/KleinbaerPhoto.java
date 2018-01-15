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
import com.googlecode.objectify.annotation.Subclass;

import java.util.List;

/**
 * KleinbaerPhoto represents a Photo of a Kleinbaer {@link Kleinbaer}
 */
@Entity
@Subclass
public class KleinbaerPhoto extends Photo {

    /**
     *  Kleinbaeren in the Photo
     */
    private List<Kleinbaer> kleinbaeren;

    /**
     * @methodtype initialization
     */
    public KleinbaerPhoto(){
        super();
    }

    /**
     * @methodtype initialization
     * @param kleinbaeren which are in the Photo
     */
    public KleinbaerPhoto(List<Kleinbaer> kleinbaeren){
        super();
       assertKleinbaerNotNull(kleinbaeren);
       this.kleinbaeren = kleinbaeren;
    }

    /**
     * @methodtype initialization
     */
    public KleinbaerPhoto(PhotoId id){
        super(id);
    }

    /**
     * @methodtype initialization
     */
    public KleinbaerPhoto(List<Kleinbaer> kleinbaeren, PhotoId id){
        super(id);
        assertKleinbaerNotNull(kleinbaeren);
        this.kleinbaeren = kleinbaeren;
    }

    /**
     * @methodtype get
     * @return A List of Kleinbaeren which appear in the photo
     */
    public List<Kleinbaer> getKleinbaeren(){
        assertKleinbaerNotNull(kleinbaeren);

        return kleinbaeren;
    }

    /**
     * @methodtype set
     * @param kleinbaeren is newly set for the photo
     */
    public void setKleinbaeren(List<Kleinbaer> kleinbaeren){
        assertKleinbaerNotNull(kleinbaeren);

        this.kleinbaeren = kleinbaeren;
    }

    /**
     * ------------------------ Assertions ------------------------
     */

    /**
     * Asserts that the given Kleinbaer-List is not null
     * @methodtype assertion
     * @throws KleinbaerPhotoException if given Kleinbaer-List is null
     */
    private void assertKleinbaerNotNull(List<Kleinbaer> kleinbaeren){
        if(kleinbaeren == null){
            throw new KleinbaerPhotoException("Kleinbaer-List mustn't be null");
        }
    }

}
