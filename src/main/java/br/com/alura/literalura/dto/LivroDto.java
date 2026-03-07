package br.com.alura.literalura.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LivroDto {

    private String title;

    private String language;

    private int downloads;

    @JsonProperty("author_name")
    private String authorName;

    // Getters e setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public int getDownloads() { return downloads; }
    public void setDownloads(int downloads) { this.downloads = downloads; }

    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }

    @Override
    public String toString() {
        return "LivroDto{" +
                "title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", downloads=" + downloads +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}