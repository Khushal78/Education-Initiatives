// LibrarySystemApp.java
import java.util.Scanner;

public class LibrarySystemApp {
    public static void main(String[] args) {
        LibraryManager library = LibraryManager.getInstance();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Search Book by Author");
            System.out.println("5. Search Book by Genre");
            System.out.println("6. Borrow Book");
            System.out.println("7. Return Book");
            System.out.println("8. View All Books");
            System.out.println("9. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book genre: ");
                    String genre = scanner.nextLine();
                    Book book = BookFactory.createBook(title, author, genre);
                    library.addBook(book);
                    break;

                case 2:
                    System.out.print("Enter title of the book to remove: ");
                    String removeTitle = scanner.nextLine();
                    library.removeBook(removeTitle);
                    break;

                case 3:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchByTitle(searchTitle);
                    break;

                case 4:
                    System.out.print("Enter book author to search: ");
                    String searchAuthor = scanner.nextLine();
                    library.searchByAuthor(searchAuthor);
                    break;

                case 5:
                    System.out.print("Enter book genre to search: ");
                    String searchGenre = scanner.nextLine();
                    library.searchByGenre(searchGenre);
                    break;

                case 6:
                    System.out.print("Enter title of the book to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowBook(borrowTitle);
                    break;

                case 7:
                    System.out.print("Enter title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;

                case 8:
                    System.out.println("All books in the library:");
                    library.viewAllBooks();
                    break;

                case 9:
                    running = false;
                    System.out.println("Exiting Library Management System...");
                    break;

                default:
                    System.out.println("Invalid option! Please select a valid option.");
                    break;
            }
        }

        scanner.close();
    }
}
