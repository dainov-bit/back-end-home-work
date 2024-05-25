import content.*;

public class Application {
    public static void main(String[] args) {
        Author author = new Author("Artem");
        Material material = new Material("Первая статья", author);
        Category category = new Category("Новости", material);
        material.setCategory(category);
        author.setMaterial(material);
        // Попробуем вызвать сразу, через категорию, статью
        System.out.println("Вызов через категорию.\n\n Категория: " + category.getTitle() + "\n Материал: " + category.getMaterial().getHeader() + "\n Автор: " + category.getMaterial().getAuthor().getName());
// Теперь обратимся к материалу.
        System.out.println("\nВызов через материал.\n\n Категория: " + material.getCategory().getTitle() + "\n Материал: " + material.getHeader() + "\n Автор: " + material.getAuthor().getName());
        // Теперь вызов через автора.
        System.out.println("\nВызов через авторв.\n\n Категория: " + author.getMaterial().getCategory().getTitle() + "\n Материал: " + author.getMaterial().getHeader() + "\n Автор: " + author.getName());
    }
}
