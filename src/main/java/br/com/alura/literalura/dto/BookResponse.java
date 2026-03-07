package br.com.alura.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookResponse {

    private int count; // total de livros retornados
    private String next;
    private String previous;
    private List<Book> results;

    // getters e setters
    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    public String getNext() { return next; }
    public void setNext(String next) { this.next = next; }

    public String getPrevious() { return previous; }
    public void setPrevious(String previous) { this.previous = previous; }

    public List<Book> getResults() { return results; }
    public void setResults(List<Book> results) { this.results = results; }

    // Classe interna para mapear cada livro
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Book {
        private String title;
        private int downloads;

        @JsonProperty("languages")
        private List<String> language; // agora é lista, pois a API retorna ["pt", "en"] por exemplo

        @JsonProperty("authors")
        private List<Author> authors;

        // getters e setters
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public int getDownloads() { return downloads; }
        public void setDownloads(int downloads) { this.downloads = downloads; }

        public List<String> getLanguage() { return language; }
        public void setLanguage(List<String> language) { this.language = language; }

        public List<Author> getAuthors() { return authors; }
        public void setAuthors(List<Author> authors) { this.authors = authors; }

        // Classe interna Author
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Author {
            private String name;

            @JsonProperty("birth_year")
            private Integer birthYear;

            @JsonProperty("death_year")
            private Integer deathYear;

            // getters e setters
            public String getName() { return name; }
            public void setName(String name) { this.name = name; }

            public Integer getBirthYear() { return birthYear; }
            public void setBirthYear(Integer birthYear) { this.birthYear = birthYear; }

            public Integer getDeathYear() { return deathYear; }
            public void setDeathYear(Integer deathYear) { this.deathYear = deathYear; }
        }
    }
}