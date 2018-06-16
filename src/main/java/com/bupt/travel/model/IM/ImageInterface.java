package com.bupt.travel.model.IM;

import com.bupt.travel.utils.JacksonUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.StringUtils;

import java.util.List;

public class ImageInterface {
    /**
     * action : post
     * application : b64ad4c0-6f7e-11e8-aa39-43104d36ddc7
     * path : /chatfiles
     * uri : https://a1.easemob.com/1148180614146538/travel/chatfiles
     * entities : [{"uuid":"949d43f0-7071-11e8-81ee-db5d90cd369a","type":"chatfile","share-secret":"lJ1D-nBxEeiAjzUOkNWd5AgkPUKPy4_MpslxBNJrVZpB4L7N"}]
     * timestamp : 1529049376188
     * duration : 0
     * organization : 1148180614146538
     * applicationName : travel
     */
    private String action;
    private String application;
    private String path;
    private String uri;
    private long timestamp;
    private int duration;
    private String organization;
    private String applicationName;
    private List<ImageEntity> entities;

    public  static ImageEntity decode(String json){

        if(StringUtils.isEmpty(json)){
            return null;
        }

        ImageInterface imageInterface = JacksonUtil.readValue(json, ImageInterface.class);
        if(imageInterface == null){
            return  null;
        }
        return  imageInterface.getEntities()==null ? null:imageInterface.getEntities().get(0);
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public List<ImageEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<ImageEntity> entities) {
        this.entities = entities;
    }

}
