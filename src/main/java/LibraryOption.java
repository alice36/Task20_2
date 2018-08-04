
import java.util.Scanner;

public class LibraryOption {
    Scanner input = new Scanner(System.in);

    public Book createNew(){

        System.out.println("Podaj tytuł");
        String title = input.nextLine();

        System.out.println("Podaj autora");
        String author = input.nextLine();

        System.out.println("Podaj rok");
        int year = input.nextInt();
        input.nextLine();

        System.out.println("Podaj isbn");
        String isbn = input.nextLine();

        return new Book(title, author, year, isbn);
    }

    public Book updateBook(){
        System.out.println("Podaj id");
        int answer = input.nextInt();

        BookDao bookDao = new BookDao();
        Book book = bookDao.read(answer);

        System.out.println("Podaj nowy rok:");
        input.nextLine();
        int answer1 = input.nextInt();

        book.setYear(answer1);
        bookDao.update(book);
        book = bookDao.read(answer);

        return book;
    }
}
