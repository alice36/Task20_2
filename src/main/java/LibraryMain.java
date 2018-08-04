import java.sql.SQLException;
import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) throws SQLException {
        LibraryOption libraryOption = new LibraryOption();
        Scanner input = new Scanner(System.in);

        System.out.println("Dictionary: choose your option!");
        System.out.println("Add: 1, read: 2, update: 3, delete: 4");
        long start = System.currentTimeMillis();

        int answer = input.nextInt();
        BookDao bookDao = new BookDao();

        switch (answer){
            case 1:
                Book book = libraryOption.createNew();
                bookDao.save(book);
                bookDao.readAll();
                break;
            case 2:
                System.out.println("Podaj id");
                answer = input.nextInt();
                book = bookDao.read(answer);
                System.out.println(book.toString());
                break;
            case 3:
                book = libraryOption.updateBook();
                System.out.println(book.toString());
                break;
            case 4:
                System.out.println("Podaj id");
                answer = input.nextInt();
                bookDao.delete(answer);
                bookDao.readAll();
                break;
        }

        bookDao.close();
        long end = System.currentTimeMillis();
        System.out.println("Trwało " + (end-start) + "ms");

    }
}
