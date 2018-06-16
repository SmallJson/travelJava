package com.bupt.travel.model.IM;

import com.fasterxml.jackson.annotation.JsonProperty;

public  class ImageEntity {
    /**
     * uuid : 949d43f0-7071-11e8-81ee-db5d90cd369a
     * type : chatfile
     * share-secret : lJ1D-nBxEeiAjzUOkNWd5AgkPUKPy4_MpslxBNJrVZpB4L7N
     */

    private String uuid;
    private String type;
    @JsonProperty("share-secret")
    private String sharesecret;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSharesecret() {
        return sharesecret;
    }

    public void setSharesecret(String sharesecret) {
        this.sharesecret = sharesecret;
    }
}
