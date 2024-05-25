package content;

public class Author {
    private String name;
    private Material material;

    public Author(String name) {
        this.name = name;
    }

    public Author() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getMaterial() {
        return this.material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

}
