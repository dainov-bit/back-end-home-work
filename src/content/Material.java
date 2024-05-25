package content;

public class Material {
    private String header;
    private Category category;
    private Author author;

    public Material(String header, Author author) {
        this.header = header;
        this.author = author;
    }

    public Material() {

    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


}
