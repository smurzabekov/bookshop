package ru.sferum.bookmvp;

import org.json.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;
import ru.sferum.bookmvp.model.Book;
import ru.sferum.bookmvp.model.Product;
import ru.sferum.bookmvp.service.AccountService;
import ru.sferum.bookmvp.service.MarketService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Validated
public class BookMvpApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMvpApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(AccountService account, MarketService market) {
        return args -> {
            String file = "src/main/resources/data.json";
            if(args.length != 0){
            file = args[0];
            }
            try {
                String json = readFileAsString(file);
                JSONObject obj = new JSONObject(json);

                int money = obj.getJSONObject("account").getInt("money");
                account.setBalance(money);

                JSONArray arr = obj.getJSONArray("books");
                List<Product> products = new ArrayList<>();
                for (int i = 0; i < arr.length(); i++)
                {
                    JSONObject jsonObject = arr.getJSONObject(i);
                    String author = jsonObject.getString("author");
                    String name = jsonObject.getString("name");
                    int price = jsonObject.getInt("price");
                    int amount = jsonObject.getInt("amount");

                    Book book = Book.builder()
                            .author(author)
                            .name(name)
                            .build();
                    Product product = Product.builder()
                            .id(i)
                            .book(book)
                            .price(price)
                            .amount(amount)
                            .build();
                    products.add(product);
                }
                market.setASSORTMENT(products);
            } catch (IOException | JSONException e) {
                System.out.println(e.getMessage());
            }
        };
    }
    public static String readFileAsString(String file) throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}
