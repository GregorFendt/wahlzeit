/*
 *   Classname: KleinbaerPhotoManager
 *
 *   Version: 1.0 [created while doing 5th ADAP-homework]
 *
 *   Date: 11.11.2017
 *
 */
package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * KleinbaerPhotoManager manages Kleinbaer photos
 */
public class KleinbaerPhotoManager extends PhotoManager {

     protected static final KleinbaerPhotoManager instance = new KleinbaerPhotoManager();

     /**
      * @methodtype initialization
      */
     protected KleinbaerPhotoManager() {
          super();
          photoTagCollector = KleinbaerPhotoFactory.getInstance().createPhotoTagCollector();
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
