package com.githup.swing.entity;

public class DataModel {
    private String id;
    private String pic;
    private String text;
    private String tkl;
    private Long uploadtime;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTkl() {
        return tkl;
    }

    public void setTkl(String tkl) {
        this.tkl = tkl;
    }

    public Long getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Long uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
