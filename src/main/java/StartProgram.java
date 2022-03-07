
import java.util.List;
import java.util.Scanner;

import controller.BookHelper;
import model.Book;


/**
 *@author roman-rggeleta@dmacc.edu
 *CIS175-Spring 2022
 *Mar 4, 2022
 */
public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static BookHelper bh = new BookHelper();

	private static void addABook() {
		// TODO Auto-generated method stub
		System.out.print("Enter a book title: ");
		String bookTitle = in.nextLine();
		System.out.print("Enter an book author: ");
		String bookAuthor = in.nextLine();
		Book toAdd = new Book();
		bh.insert(toAdd);

	}

	private static void deleteABook() {
		// TODO Auto-generated method stub
		System.out.print("Enter the book title to delete: ");
		String bookTitle = in.nextLine();
		System.out.print("Enter the book author to delete: ");
		String bookAuthor = in.nextLine();
		Book toDelete = new Book();
		bh.deleteBookTitle(toDelete);

	}

	private static void editABook() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by book title");
		System.out.println("2 : Search by book author");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Book> foundBook;
		if (searchBy == 1) {
			System.out.print("Enter the store name: ");
			String title = in.nextLine();
			foundBook = bh.searchForBooksByBookTitle(title);
		} else {
			System.out.print("Enter the item: ");
			String author = in.nextLine();
			foundBook = bh.searchForBooksByBookAuthor(author);


		}

		if (!foundBook.isEmpty()) {
			System.out.println("Found Results.");
			for (Book l : foundBook) {
				System.out.println( " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Book toEdit = bh.searchForBookAuthorById(idToEdit);
			//System.out.println("Retrieved " + toEdit.getBookAuthor() + " from " + toEdit.getBookAuthor());
			System.out.println("1 : Update book title");
			System.out.println("2 : Update book Author");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New book title: ");
				String newBookTitle = in.nextLine();
				//toEdit.setBookTitle(newBookTitle);
			} else if (update == 2) {
				System.out.print("New Author: ");
				String newBookAuthor = in.nextLine();
				//toEdit.setBookAuthor(newBook);
			}

			bh.updateABook(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome program! ---");
		while (goAgain) {
			System.out.println("*  Select an book:");
			System.out.println("*  1 -- Add an book");
			System.out.println("*  2 -- Edit an book");
			System.out.println("*  3 -- Delete an book");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addABook();
			} else if (selection == 2) {
				editABook();
			} else if (selection == 3) {
				deleteABook();
			} else if (selection == 4) {
				viewTheList();
			} else {
				bh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<Book> allBooks = bh.showAllBooks();
		for(Book singleBook: allBooks) {
			System.out.println(singleBook.toString());
		}

	}


}
