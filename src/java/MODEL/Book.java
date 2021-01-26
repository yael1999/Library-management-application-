/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author יעל כץ
 */
public class Book implements java.io.Serializable{
    private String bookName;
    private String bookAuthor;
    private int copyNum;
    private boolean isBorrowed;
    private int isbn;

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }
    /**
     * @return the bookName
     */
  
    

    @Override
    public String toString() {
        return "Book{" + "bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", copyNum=" + copyNum + ", isBorrowed=" + isBorrowed + ", isbn="+ isbn +'}' ;
    }

    public Book(String bookName, String bookAuthor, int copyNum, boolean isBorrowed,int isbn) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.copyNum = copyNum;
        this.isBorrowed = isBorrowed;
        this.isbn=isbn;
    }

    public String getBookName() {
        return bookName;
    }

    /**
     * @param bookName the bookName to set
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * @return the bookAuthor
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * @param bookAuthor the bookAuthor to set
     */
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    /**
     * @return the copyNum
     */
    public int getCopyNum() {
        return copyNum;
    }

    /**
     * @param copyNum the copyNum to set
     */
    public void setCopyNum(int copyNum) {
        this.copyNum = copyNum;
    }

    /**
     * @return the isBorrowed
     */
    public boolean isIsBorrowed() {
        return isBorrowed;
    }

    /**
     * @param isBorrowed the isBorrowed to set
     */
    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }
    
    
}
