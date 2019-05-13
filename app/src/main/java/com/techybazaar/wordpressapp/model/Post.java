

package com.techybazaar.wordpressapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("date_gmt")
    @Expose
    private String dateGmt;
    @SerializedName("guid")
    @Expose
    private Guid guid;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("modified_gmt")
    @Expose
    private String modifiedGmt;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("title")
    @Expose
    private Title title;
    @SerializedName("content")
    @Expose
    private Content content;
    @SerializedName("excerpt")
    @Expose
    private Excerpt excerpt;
    @SerializedName("author")
    @Expose
    private Integer author;
    @SerializedName("featured_media")
    @Expose
    private Integer featuredMedia;
    @SerializedName("comment_status")
    @Expose
    private String commentStatus;
    @SerializedName("ping_status")
    @Expose
    private String pingStatus;
    @SerializedName("sticky")
    @Expose
    private Boolean sticky;
    @SerializedName("template")
    @Expose
    private String template;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("meta")
    @Expose
    private List<Object> meta = null;
    @SerializedName("categories")
    @Expose
    private List<Integer> categories = null;
    @SerializedName("tags")
    @Expose
    private List<Integer> tags = null;
    @SerializedName("_links")
    @Expose
    private Links links;
    @SerializedName("_embedded")
    @Expose
    private Embedded embedded;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateGmt() {
        return dateGmt;
    }

    public void setDateGmt(String dateGmt) {
        this.dateGmt = dateGmt;
    }

    public Guid getGuid() {
        return guid;
    }

    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getModifiedGmt() {
        return modifiedGmt;
    }

    public void setModifiedGmt(String modifiedGmt) {
        this.modifiedGmt = modifiedGmt;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Excerpt getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(Excerpt excerpt) {
        this.excerpt = excerpt;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getFeaturedMedia() {
        return featuredMedia;
    }

    public void setFeaturedMedia(Integer featuredMedia) {
        this.featuredMedia = featuredMedia;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getPingStatus() {
        return pingStatus;
    }

    public void setPingStatus(String pingStatus) {
        this.pingStatus = pingStatus;
    }

    public Boolean getSticky() {
        return sticky;
    }

    public void setSticky(Boolean sticky) {
        this.sticky = sticky;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public List<Object> getMeta() {
        return meta;
    }

    public void setMeta(List<Object> meta) {
        this.meta = meta;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }

    public List<Integer> getTags() {
        return tags;
    }

    public void setTags(List<Integer> tags) {
        this.tags = tags;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }



    public class About {

        @SerializedName("href")
        @Expose
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }


    public class About_ {

        @SerializedName("href")
        @Expose
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }


    public class About__ {

        @SerializedName("href")
        @Expose
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }


    public class Author {

        @SerializedName("embeddable")
        @Expose
        private Boolean embeddable;
        @SerializedName("href")
        @Expose
        private String href;

        public Boolean getEmbeddable() {
            return embeddable;
        }

        public void setEmbeddable(Boolean embeddable) {
            this.embeddable = embeddable;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }


    public class Author_ {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("link")
        @Expose
        private String link;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("avatar_urls")
        @Expose
        private AvatarUrls avatarUrls;
        @SerializedName("_links")
        @Expose
        private Links_ links;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public AvatarUrls getAvatarUrls() {
            return avatarUrls;
        }

        public void setAvatarUrls(AvatarUrls avatarUrls) {
            this.avatarUrls = avatarUrls;
        }

        public Links_ getLinks() {
            return links;
        }

        public void setLinks(Links_ links) {
            this.links = links;
        }

    }


    public class Author__ {

        @SerializedName("embeddable")
        @Expose
        private Boolean embeddable;
        @SerializedName("href")
        @Expose
        private String href;

        public Boolean getEmbeddable() {
            return embeddable;
        }

        public void setEmbeddable(Boolean embeddable) {
            this.embeddable = embeddable;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }


    public class AvatarUrls {

        @SerializedName("24")
        @Expose
        private String _24;
        @SerializedName("48")
        @Expose
        private String _48;
        @SerializedName("96")
        @Expose
        private String _96;

        public String get24() {
            return _24;
        }

        public void set24(String _24) {
            this._24 = _24;
        }

        public String get48() {
            return _48;
        }

        public void set48(String _48) {
            this._48 = _48;
        }

        public String get96() {
            return _96;
        }

        public void set96(String _96) {
            this._96 = _96;
        }

    }


    public class Caption {

        @SerializedName("rendered")
        @Expose
        private String rendered;

        public String getRendered() {
            return rendered;
        }

        public void setRendered(String rendered) {
            this.rendered = rendered;
        }

    }


    public class Collection {

        @SerializedName("href")
        @Expose
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }


    public class Collection_ {

        @SerializedName("href")
        @Expose
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }


    public class Collection__ {

        @SerializedName("href")
        @Expose
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }


    public class Collection___ {

        @SerializedName("href")
        @Expose
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }

    public class Content {

        @SerializedName("rendered")
        @Expose
        private String rendered;
        @SerializedName("protected")
        @Expose
        private Boolean _protected;

        public String getRendered() {
            return rendered;
        }

        public void setRendered(String rendered) {
            this.rendered = rendered;
        }

        public Boolean getProtected() {
            return _protected;
        }

        public void setProtected(Boolean _protected) {
            this._protected = _protected;
        }

    }


    public class Cury {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("href")
        @Expose
        private String href;
        @SerializedName("templated")
        @Expose
        private Boolean templated;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public Boolean getTemplated() {
            return templated;
        }

        public void setTemplated(Boolean templated) {
            this.templated = templated;
        }

    }


    public class Cury_ {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("href")
        @Expose
        private String href;
        @SerializedName("templated")
        @Expose
        private Boolean templated;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public Boolean getTemplated() {
            return templated;
        }

        public void setTemplated(Boolean templated) {
            this.templated = templated;
        }

    }


    public class Embedded {

        @SerializedName("author")
        @Expose
        private List<Author_> author = null;
        @SerializedName("wp:featuredmedia")
        @Expose
        private List<WpFeaturedmedium_> wpFeaturedmedia = null;
        @SerializedName("wp:term")
        @Expose
        private List<List<WpTerm_>> wpTerm = null;

        public List<Author_> getAuthor() {
            return author;
        }

        public void setAuthor(List<Author_> author) {
            this.author = author;
        }

        public List<WpFeaturedmedium_> getWpFeaturedmedia() {
            return wpFeaturedmedia;
        }

        public void setWpFeaturedmedia(List<WpFeaturedmedium_> wpFeaturedmedia) {
            this.wpFeaturedmedia = wpFeaturedmedia;
        }

        public List<List<WpTerm_>> getWpTerm() {
            return wpTerm;
        }

        public void setWpTerm(List<List<WpTerm_>> wpTerm) {
            this.wpTerm = wpTerm;
        }

    }


    public class Excerpt {

        @SerializedName("rendered")
        @Expose
        private String rendered;
        @SerializedName("protected")
        @Expose
        private Boolean _protected;

        public String getRendered() {
            return rendered;
        }

        public void setRendered(String rendered) {
            this.rendered = rendered;
        }

        public Boolean getProtected() {
            return _protected;
        }

        public void setProtected(Boolean _protected) {
            this._protected = _protected;
        }

    }

    public class Full {

        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

    }


    public class Guid {

        @SerializedName("rendered")
        @Expose
        private String rendered;

        public String getRendered() {
            return rendered;
        }

        public void setRendered(String rendered) {
            this.rendered = rendered;
        }

    }


    public class ImageMeta {

        @SerializedName("aperture")
        @Expose
        private String aperture;
        @SerializedName("credit")
        @Expose
        private String credit;
        @SerializedName("camera")
        @Expose
        private String camera;
        @SerializedName("caption")
        @Expose
        private String caption;
        @SerializedName("created_timestamp")
        @Expose
        private String createdTimestamp;
        @SerializedName("copyright")
        @Expose
        private String copyright;
        @SerializedName("focal_length")
        @Expose
        private String focalLength;
        @SerializedName("iso")
        @Expose
        private String iso;
        @SerializedName("shutter_speed")
        @Expose
        private String shutterSpeed;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("orientation")
        @Expose
        private String orientation;
        @SerializedName("keywords")
        @Expose
        private List<Object> keywords = null;

        public String getAperture() {
            return aperture;
        }

        public void setAperture(String aperture) {
            this.aperture = aperture;
        }

        public String getCredit() {
            return credit;
        }

        public void setCredit(String credit) {
            this.credit = credit;
        }

        public String getCamera() {
            return camera;
        }

        public void setCamera(String camera) {
            this.camera = camera;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public String getCreatedTimestamp() {
            return createdTimestamp;
        }

        public void setCreatedTimestamp(String createdTimestamp) {
            this.createdTimestamp = createdTimestamp;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getFocalLength() {
            return focalLength;
        }

        public void setFocalLength(String focalLength) {
            this.focalLength = focalLength;
        }

        public String getIso() {
            return iso;
        }

        public void setIso(String iso) {
            this.iso = iso;
        }

        public String getShutterSpeed() {
            return shutterSpeed;
        }

        public void setShutterSpeed(String shutterSpeed) {
            this.shutterSpeed = shutterSpeed;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getOrientation() {
            return orientation;
        }

        public void setOrientation(String orientation) {
            this.orientation = orientation;
        }

        public List<Object> getKeywords() {
            return keywords;
        }

        public void setKeywords(List<Object> keywords) {
            this.keywords = keywords;
        }

    }


    public class Links {

        @SerializedName("self")
        @Expose
        private List<Self> self = null;
        @SerializedName("collection")
        @Expose
        private List<Collection> collection = null;
        @SerializedName("about")
        @Expose
        private List<About> about = null;
        @SerializedName("author")
        @Expose
        private List<Author> author = null;
        @SerializedName("replies")
        @Expose
        private List<Reply> replies = null;
        @SerializedName("version-history")
        @Expose
        private List<VersionHistory> versionHistory = null;
        @SerializedName("predecessor-version")
        @Expose
        private List<PredecessorVersion> predecessorVersion = null;
        @SerializedName("wp:featuredmedia")
        @Expose
        private List<WpFeaturedmedium> wpFeaturedmedia = null;
        @SerializedName("wp:attachment")
        @Expose
        private List<WpAttachment> wpAttachment = null;
        @SerializedName("wp:term")
        @Expose
        private List<WpTerm> wpTerm = null;
        @SerializedName("curies")
        @Expose
        private List<Cury> curies = null;

        public List<Self> getSelf() {
            return self;
        }

        public void setSelf(List<Self> self) {
            this.self = self;
        }

        public List<Collection> getCollection() {
            return collection;
        }

        public void setCollection(List<Collection> collection) {
            this.collection = collection;
        }

        public List<About> getAbout() {
            return about;
        }

        public void setAbout(List<About> about) {
            this.about = about;
        }

        public List<Author> getAuthor() {
            return author;
        }

        public void setAuthor(List<Author> author) {
            this.author = author;
        }

        public List<Reply> getReplies() {
            return replies;
        }

        public void setReplies(List<Reply> replies) {
            this.replies = replies;
        }

        public List<VersionHistory> getVersionHistory() {
            return versionHistory;
        }

        public void setVersionHistory(List<VersionHistory> versionHistory) {
            this.versionHistory = versionHistory;
        }

        public List<PredecessorVersion> getPredecessorVersion() {
            return predecessorVersion;
        }

        public void setPredecessorVersion(List<PredecessorVersion> predecessorVersion) {
            this.predecessorVersion = predecessorVersion;
        }

        public List<WpFeaturedmedium> getWpFeaturedmedia() {
            return wpFeaturedmedia;
        }

        public void setWpFeaturedmedia(List<WpFeaturedmedium> wpFeaturedmedia) {
            this.wpFeaturedmedia = wpFeaturedmedia;
        }

        public List<WpAttachment> getWpAttachment() {
            return wpAttachment;
        }

        public void setWpAttachment(List<WpAttachment> wpAttachment) {
            this.wpAttachment = wpAttachment;
        }

        public List<WpTerm> getWpTerm() {
            return wpTerm;
        }

        public void setWpTerm(List<WpTerm> wpTerm) {
            this.wpTerm = wpTerm;
        }

        public List<Cury> getCuries() {
            return curies;
        }

        public void setCuries(List<Cury> curies) {
            this.curies = curies;
        }

    }

    public class Links_ {

        @SerializedName("self")
        @Expose
        private List<Self_> self = null;
        @SerializedName("collection")
        @Expose
        private List<Collection_> collection = null;

        public List<Self_> getSelf() {
            return self;
        }

        public void setSelf(List<Self_> self) {
            this.self = self;
        }

        public List<Collection_> getCollection() {
            return collection;
        }

        public void setCollection(List<Collection_> collection) {
            this.collection = collection;
        }

    }


    public class Links__ {

        @SerializedName("self")
        @Expose
        private List<Self__> self = null;
        @SerializedName("collection")
        @Expose
        private List<Collection__> collection = null;
        @SerializedName("about")
        @Expose
        private List<About_> about = null;
        @SerializedName("author")
        @Expose
        private List<Author__> author = null;
        @SerializedName("replies")
        @Expose
        private List<Reply_> replies = null;

        public List<Self__> getSelf() {
            return self;
        }

        public void setSelf(List<Self__> self) {
            this.self = self;
        }

        public List<Collection__> getCollection() {
            return collection;
        }

        public void setCollection(List<Collection__> collection) {
            this.collection = collection;
        }

        public List<About_> getAbout() {
            return about;
        }

        public void setAbout(List<About_> about) {
            this.about = about;
        }

        public List<Author__> getAuthor() {
            return author;
        }

        public void setAuthor(List<Author__> author) {
            this.author = author;
        }

        public List<Reply_> getReplies() {
            return replies;
        }

        public void setReplies(List<Reply_> replies) {
            this.replies = replies;
        }

    }


    public class Links___ {

        @SerializedName("self")
        @Expose
        private List<Self___> self = null;
        @SerializedName("collection")
        @Expose
        private List<Collection___> collection = null;
        @SerializedName("about")
        @Expose
        private List<About__> about = null;
        @SerializedName("wp:post_type")
        @Expose
        private List<WpPostType> wpPostType = null;
        @SerializedName("curies")
        @Expose
        private List<Cury_> curies = null;

        public List<Self___> getSelf() {
            return self;
        }

        public void setSelf(List<Self___> self) {
            this.self = self;
        }

        public List<Collection___> getCollection() {
            return collection;
        }

        public void setCollection(List<Collection___> collection) {
            this.collection = collection;
        }

        public List<About__> getAbout() {
            return about;
        }

        public void setAbout(List<About__> about) {
            this.about = about;
        }

        public List<WpPostType> getWpPostType() {
            return wpPostType;
        }

        public void setWpPostType(List<WpPostType> wpPostType) {
            this.wpPostType = wpPostType;
        }

        public List<Cury_> getCuries() {
            return curies;
        }

        public void setCuries(List<Cury_> curies) {
            this.curies = curies;
        }

    }


    public class MediaDetails {

        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("sizes")
        @Expose
        private Sizes sizes;
        @SerializedName("image_meta")
        @Expose
        private ImageMeta imageMeta;

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Sizes getSizes() {
            return sizes;
        }

        public void setSizes(Sizes sizes) {
            this.sizes = sizes;
        }

        public ImageMeta getImageMeta() {
            return imageMeta;
        }

        public void setImageMeta(ImageMeta imageMeta) {
            this.imageMeta = imageMeta;
        }

    }


    public class Medium {

        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

    }


    public class MediumLarge {

        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

    }




    public class PredecessorVersion {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("href")
        @Expose
        private String href;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }


    public class Reply {

        @SerializedName("embeddable")
        @Expose
        private Boolean embeddable;
        @SerializedName("href")
        @Expose
        private String href;

        public Boolean getEmbeddable() {
            return embeddable;
        }

        public void setEmbeddable(Boolean embeddable) {
            this.embeddable = embeddable;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }


    public class Reply_ {

        @SerializedName("embeddable")
        @Expose
        private Boolean embeddable;
        @SerializedName("href")
        @Expose
        private String href;

        public Boolean getEmbeddable() {
            return embeddable;
        }

        public void setEmbeddable(Boolean embeddable) {
            this.embeddable = embeddable;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }


    public class Self {

        @SerializedName("href")
        @Expose
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }


    public class Self_ {

        @SerializedName("href")
        @Expose
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }


    public class Self__ {

        @SerializedName("href")
        @Expose
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }


    public class Self___ {

        @SerializedName("href")
        @Expose
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }


    public class Sizes {

        @SerializedName("medium")
        @Expose
        private Medium medium;
        @SerializedName("medium_large")
        @Expose
        private MediumLarge mediumLarge;
        @SerializedName("td_80x60")
        @Expose
        private Td80x60 td80x60;
        @SerializedName("td_100x70")
        @Expose
        private Td100x70 td100x70;
        @SerializedName("td_218x150")
        @Expose
        private Td218x150 td218x150;
        @SerializedName("td_265x198")
        @Expose
        private Td265x198 td265x198;
        @SerializedName("td_324x160")
        @Expose
        private Td324x160 td324x160;
        @SerializedName("td_324x235")
        @Expose
        private Td324x235 td324x235;
        @SerializedName("td_324x400")
        @Expose
        private Td324x400 td324x400;
        @SerializedName("td_356x220")
        @Expose
        private Td356x220 td356x220;
        @SerializedName("td_356x364")
        @Expose
        private Td356x364 td356x364;
        @SerializedName("td_533x261")
        @Expose
        private Td533x261 td533x261;
        @SerializedName("td_534x462")
        @Expose
        private Td534x462 td534x462;
        @SerializedName("td_696x0")
        @Expose
        private Td696x0 td696x0;
        @SerializedName("td_696x385")
        @Expose
        private Td696x385 td696x385;
        @SerializedName("td_741x486")
        @Expose
        private Td741x486 td741x486;
        @SerializedName("td_0x420")
        @Expose
        private Td0x420 td0x420;
        @SerializedName("full")
        @Expose
        private Full full;

        public Medium getMedium() {
            return medium;
        }

        public void setMedium(Medium medium) {
            this.medium = medium;
        }

        public MediumLarge getMediumLarge() {
            return mediumLarge;
        }

        public void setMediumLarge(MediumLarge mediumLarge) {
            this.mediumLarge = mediumLarge;
        }

        public Td80x60 getTd80x60() {
            return td80x60;
        }

        public void setTd80x60(Td80x60 td80x60) {
            this.td80x60 = td80x60;
        }

        public Td100x70 getTd100x70() {
            return td100x70;
        }

        public void setTd100x70(Td100x70 td100x70) {
            this.td100x70 = td100x70;
        }

        public Td218x150 getTd218x150() {
            return td218x150;
        }

        public void setTd218x150(Td218x150 td218x150) {
            this.td218x150 = td218x150;
        }

        public Td265x198 getTd265x198() {
            return td265x198;
        }

        public void setTd265x198(Td265x198 td265x198) {
            this.td265x198 = td265x198;
        }

        public Td324x160 getTd324x160() {
            return td324x160;
        }

        public void setTd324x160(Td324x160 td324x160) {
            this.td324x160 = td324x160;
        }

        public Td324x235 getTd324x235() {
            return td324x235;
        }

        public void setTd324x235(Td324x235 td324x235) {
            this.td324x235 = td324x235;
        }

        public Td324x400 getTd324x400() {
            return td324x400;
        }

        public void setTd324x400(Td324x400 td324x400) {
            this.td324x400 = td324x400;
        }

        public Td356x220 getTd356x220() {
            return td356x220;
        }

        public void setTd356x220(Td356x220 td356x220) {
            this.td356x220 = td356x220;
        }

        public Td356x364 getTd356x364() {
            return td356x364;
        }

        public void setTd356x364(Td356x364 td356x364) {
            this.td356x364 = td356x364;
        }

        public Td533x261 getTd533x261() {
            return td533x261;
        }

        public void setTd533x261(Td533x261 td533x261) {
            this.td533x261 = td533x261;
        }

        public Td534x462 getTd534x462() {
            return td534x462;
        }

        public void setTd534x462(Td534x462 td534x462) {
            this.td534x462 = td534x462;
        }

        public Td696x0 getTd696x0() {
            return td696x0;
        }

        public void setTd696x0(Td696x0 td696x0) {
            this.td696x0 = td696x0;
        }

        public Td696x385 getTd696x385() {
            return td696x385;
        }

        public void setTd696x385(Td696x385 td696x385) {
            this.td696x385 = td696x385;
        }

        public Td741x486 getTd741x486() {
            return td741x486;
        }

        public void setTd741x486(Td741x486 td741x486) {
            this.td741x486 = td741x486;
        }

        public Td0x420 getTd0x420() {
            return td0x420;
        }

        public void setTd0x420(Td0x420 td0x420) {
            this.td0x420 = td0x420;
        }

        public Full getFull() {
            return full;
        }

        public void setFull(Full full) {
            this.full = full;
        }

    }


    public class Td0x420 {

        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

    }

    public class Td100x70 {

        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

    }


    public class Td218x150 {

        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

    }


    public class Td265x198 {

        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

    }

    public class Td324x160 {

        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

    }


    public class Td324x235 {

        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

    }


    public class Td324x400 {

        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

    }


    public class Td356x220 {

        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

    }


    public class Td356x364 {

        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

    }


    public class Td533x261 {

        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

    }


    public class Td534x462 {

        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

    }


    public class Td696x0 {

        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

    }


    public class Td696x385 {

        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

    }


    public class Td741x486 {

        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

    }


    public class Td80x60 {

        @SerializedName("file")
        @Expose
        private String file;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

    }


    public class Title {

        @SerializedName("rendered")
        @Expose
        private String rendered;

        public String getRendered() {
            return rendered;
        }

        public void setRendered(String rendered) {
            this.rendered = rendered;
        }

    }


    public class Title_ {

        @SerializedName("rendered")
        @Expose
        private String rendered;

        public String getRendered() {
            return rendered;
        }

        public void setRendered(String rendered) {
            this.rendered = rendered;
        }

    }


    public class VersionHistory {

        @SerializedName("count")
        @Expose
        private Integer count;
        @SerializedName("href")
        @Expose
        private String href;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }


    public class WpAttachment {

        @SerializedName("href")
        @Expose
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }


    public class WpFeaturedmedium {

        @SerializedName("embeddable")
        @Expose
        private Boolean embeddable;
        @SerializedName("href")
        @Expose
        private String href;

        public Boolean getEmbeddable() {
            return embeddable;
        }

        public void setEmbeddable(Boolean embeddable) {
            this.embeddable = embeddable;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }


    public class WpFeaturedmedium_ {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("link")
        @Expose
        private String link;
        @SerializedName("title")
        @Expose
        private Title_ title;
        @SerializedName("author")
        @Expose
        private Integer author;
        @SerializedName("caption")
        @Expose
        private Caption caption;
        @SerializedName("alt_text")
        @Expose
        private String altText;
        @SerializedName("media_type")
        @Expose
        private String mediaType;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("media_details")
        @Expose
        private MediaDetails mediaDetails;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;
        @SerializedName("_links")
        @Expose
        private Links__ links;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public Title_ getTitle() {
            return title;
        }

        public void setTitle(Title_ title) {
            this.title = title;
        }

        public Integer getAuthor() {
            return author;
        }

        public void setAuthor(Integer author) {
            this.author = author;
        }

        public Caption getCaption() {
            return caption;
        }

        public void setCaption(Caption caption) {
            this.caption = caption;
        }

        public String getAltText() {
            return altText;
        }

        public void setAltText(String altText) {
            this.altText = altText;
        }

        public String getMediaType() {
            return mediaType;
        }

        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public MediaDetails getMediaDetails() {
            return mediaDetails;
        }

        public void setMediaDetails(MediaDetails mediaDetails) {
            this.mediaDetails = mediaDetails;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

        public Links__ getLinks() {
            return links;
        }

        public void setLinks(Links__ links) {
            this.links = links;
        }

    }


    public class WpPostType {

        @SerializedName("href")
        @Expose
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }

    public class WpTerm {

        @SerializedName("taxonomy")
        @Expose
        private String taxonomy;
        @SerializedName("embeddable")
        @Expose
        private Boolean embeddable;
        @SerializedName("href")
        @Expose
        private String href;

        public String getTaxonomy() {
            return taxonomy;
        }

        public void setTaxonomy(String taxonomy) {
            this.taxonomy = taxonomy;
        }

        public Boolean getEmbeddable() {
            return embeddable;
        }

        public void setEmbeddable(Boolean embeddable) {
            this.embeddable = embeddable;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    }


    public class WpTerm_ {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("link")
        @Expose
        private String link;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("taxonomy")
        @Expose
        private String taxonomy;
        @SerializedName("_links")
        @Expose
        private Links___ links;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getTaxonomy() {
            return taxonomy;
        }

        public void setTaxonomy(String taxonomy) {
            this.taxonomy = taxonomy;
        }

        public Links___ getLinks() {
            return links;
        }

        public void setLinks(Links___ links) {
            this.links = links;
        }

    }
}