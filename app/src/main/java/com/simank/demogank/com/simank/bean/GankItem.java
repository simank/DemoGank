package com.simank.demogank.com.simank.bean;

/**
 * Created by sx on 2016/11/3.
 * "results": [
 {
 "_id": "5816e3e0421aa90e6f21b489",
 "createdAt": "2016-10-31T14:25:36.974Z",
 "desc": "dex\u6587\u4ef6\u7ed3\u6784\u89e3\u6790\u4ee5\u53ca\u5176\u5e94\u7528",
 "publishedAt": "2016-11-03T11:48:43.342Z",
 "source": "web",
 "type": "Android",
 "url": "http://www.zjutkz.net/2016/10/27/dex%E6%96%87%E4%BB%B6%E7%BB%93%E6%9E%84%E5%8F%8A%E5%85%B6%E5%BA%94%E7%94%A8/",
 "used": true,
 "who": null
 }
 */
public class GankItem {
    private String images;

    private String _id;

    private String createdAt;

    private String desc;

    private String source;

    private String url;

    private boolean used;

    private String who;

    private String publishedAt;

    private String type;

    public GankItem() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
