import app.control.Start;
import app.domain.MusicProduct;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Application {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext("app");
        Start start = context.getBean(Start.class);
        System.out.println(start.getShop()+"\n");
        // Пример работы.
        MusicProduct mp = start.getById(2L);
        System.out.println("ID: "+mp.getId()+"\n Композиция: "+mp.getArtist()+" - "+mp.getSong()+"\n Цена: "+mp.getPrice().doubleValue()+"\n Артикуль: "+mp.getArticle());
   }
}
