import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.AppConfig;
import content.*;

public class SpringClass {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Category category = context.getBean(Category.class);
        Material material = context.getBean(Material.class);
        Author author = context.getBean(Author.class);
        category.setTitle("Новости");
        material.setHeader("Первая новость");
        material.setCategory(category);
        author.setName("Artem");
        material.setAuthor(author);
        author.setMaterial(material);
        category.setMaterial(material);
        System.out.println("Результат.\n\n Материал: " + category.getMaterial().getHeader() + "\n Категория: " + category.getMaterial().getCategory().getTitle() + "\n Автор: " + category.getMaterial().getAuthor().getName());

    }
}
