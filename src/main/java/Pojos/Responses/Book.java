package Pojos.Responses;

import java.util.List;

public class Book<T> {
    private T isbn;
    private T title;
    private T subTitle;
    private T author;
    private T publish_date;
    private T publisher;
    private T pages;
    private T description;
    private T website;

    public T getTitle() {
        return title;
    }

    public void setTitle(T title) {
        this.title = title;
    }

    public T getIsbn() {
        return isbn;
    }

    public void setIsbn(T isbn) {
        this.isbn = isbn;
    }

    public T getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(T subTitle) {
        this.subTitle = subTitle;
    }

    public T getAuthor() {
        return author;
    }

    public void setAuthor(T author) {
        this.author = author;
    }

    public T getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(T publish_date) {
        this.publish_date = publish_date;
    }

    public T getPublisher() {
        return publisher;
    }

    public void setPublisher(T publisher) {
        this.publisher = publisher;
    }

    public T getPages() {
        return pages;
    }

    public void setPages(T pages) {
        this.pages = pages;
    }

    public T getDescription() {
        return description;
    }

    public void setDescription(T description) {
        this.description = description;
    }

    public T getWebsite() {
        return website;
    }

    public void setWebsite(T website) {
        this.website = website;
    }
}
