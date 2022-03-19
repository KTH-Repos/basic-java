/**
   * A class that maintains information on a book.
   * This might form part of a larger application such
   * as a library system, for instance.
   *
   * @author (Insert your name here.)
   * @version (Insert today’s date here.)
   */
  public class Book
  {
      // The fields.
      private String author;
      private String title;
      private int pages;
      private String refNumber;
      private int borrowed;
      /**
       * Set the author, title and pages fields when this object
       * is constructed.
       */
      public Book(String bookAuthor, String bookTitle, int bookPages)
      {
          author = bookAuthor;
          title = bookTitle;
          pages = bookPages;
          refNumber = "";
      }
      // Print the name of the author
      public void printAuthor ()
      {
        System.out.println (author);
      }
      //Print the title of the book
      public void printTitle ()
      {
        System.out.println (title);
      }
      //Find out the number of pages in the book
      public int getPages ()
      {
        return pages;
      }
      //Assign a reference number to the book
      public void setRefNumber (String ref)
      {
        if (ref.length() >= 3) {
        refNumber = ref;
        }
        else {
          System.out.println ("Error: The reference number must be at least three characters long");
          refNumber = refNumber;
        }
      }
      //Print the details of the title, author, pages and reference number of the book
      public void printDetails ()
      {
        if (refNumber.length() > 0) {
        System.out.println ("Title: " + title + "," + " Author: " + author + "," + " Pages: " + pages + "," + " Reference Number: " + refNumber + "," + " Number of times borrowed: " + borrowed);
        }
        else {
        System.out.println ("Title: " + title + "," + " Author: " + author + "," + " Pages: " + pages + "," + " Reference Number: " + " ZZZ" + "," + " Number of times borrowed: " + borrowed);
        }
      }

      //Find out the reference number of the book
      public String getRefNumber ()
      {
        return refNumber;
      }
      //Update borrowed every time the book is borrowed
      public void borrow ()
      {
        borrowed = borrowed + 1;
      }
      //Find out how many times the book is borrowed
      public int getBorrowed ()
      {
        return borrowed;
      }
  }
