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

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;
import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.utils.PatternInstance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * KleinbaerPhotoManager manages Kleinbaer photos
 */
 @PatternInstance(
 patternName = "Singleton",
 participants = {
 "Singleton"
 }
 )

public class KleinbaerPhotoManager extends PhotoManager {


     protected static final KleinbaerPhotoManager instance = new KleinbaerPhotoManager();

     private static final Logger log = Logger.getLogger(PhotoManager.class.getName());

     /**
      * @methodtype initialization
      */
     public KleinbaerPhotoManager() {
         photoTagCollector = KleinbaerPhotoFactory.getInstance().createPhotoTagCollector();
     }

     public static KleinbaerPhotoManager getInstance(){
          return KleinbaerPhotoManager.instance;
     }

     public Photo getPhoto(PhotoId id){
          return instance.getPhotoFromId(id);
     }

     /**
      * @methodtype init loads all Photos from the Datastore and holds them in the cache
      */
     public void init(){
          loadPhotos();
     }


     public void loadPhotos() {
		Collection<KleinbaerPhoto> existingPhotos = ObjectifyService.run(new Work<Collection<KleinbaerPhoto>>() {
			@Override
			public Collection<KleinbaerPhoto> run() {
				Collection<KleinbaerPhoto> existingPhotos = new ArrayList<KleinbaerPhoto>();
				readObjects(existingPhotos, KleinbaerPhoto.class);
				return existingPhotos;
			}
		});

		for (KleinbaerPhoto photo : existingPhotos) {
			if (!doHasPhoto(photo.getId())) {
				log.config(LogBuilder.createSystemMessage().
						addParameter("Load KleinbaerPhoto with ID", photo.getIdAsString()).toString());
				loadScaledImages(photo);
				doAddPhoto(photo);
			} else {
				log.config(LogBuilder.createSystemMessage().
						addParameter("Already loaded KleinbaerPhoto", photo.getIdAsString()).toString());
			}
		}

		log.info(LogBuilder.createSystemMessage().addMessage("All photos loaded.").toString());
	}


     public Photo getPhotoFromId(PhotoId id) throws KleinbaerPhotoManagerException{
          if(id == null){
               return null;
          }

          Photo result = doGetPhotoFromId(id);
          if(result == null){
               result = KleinbaerPhotoFactory.getInstance().loadPhoto(id);
               if(result != null){
                    doAddPhoto(result);
               }
          }

          assertPhotoIsNotNull(result);
          return result;
     }

    /**
     * ------------------------ Assertions ------------------------
     */

    /**
     * Asserts that Photo is not null
     * @methodtype assertion
     * @throws KleinbaerPhotoFactoryException if Photo is null
     */
    static private void assertPhotoIsNotNull(Photo photo){
        if(photo != null){
            throw new KleinbaerPhotoManagerException("Loaded Photo mustn't be null!");
        }
    }

}
