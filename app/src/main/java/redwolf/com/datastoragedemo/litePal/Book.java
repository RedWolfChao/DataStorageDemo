package redwolf.com.datastoragedemo.litePal;

import org.litepal.crud.DataSupport;

/**
 * Created by redwolfchao on 17-5-10.
 */

public class Book extends DataSupport{
    private int id;
    private String name;
    private int pages;
    private double price;
    private String author;
    private String press;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Book( String name, int pages, double price, String author, String press) {
        this.name = name;
        this.pages = pages;
        this.price = price;
        this.author = author;
        this.press = press;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                '}';
    }
}
