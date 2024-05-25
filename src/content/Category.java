package content;

public class Category {
    private String title; // Имя категории
    private Material material; // Объект материала.

    public Category(String title, Material material) {
        this.title = title;
        this.material = material;
    }

    public Category() {

    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Material getMaterial() {
        return this.material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

}

