/*
 *   Classname: KleinbaerPhotoManager
 *
 *   Version: 1.0 [created while doing 5th ADAP-homework]
 *
 *   Date: 11.11.2017
 *
 */
package org.wahlzeit.model;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;
import org.wahlzeit.services.LogBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * KleinbaerPhotoManager manages Kleinbaer photos
 */
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


     public Photo getPhotoFromId(PhotoId id){
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

          return result;
     }
}
