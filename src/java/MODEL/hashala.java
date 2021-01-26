package MODEL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author יעל כץ
 */
public class hashala implements java.io.Serializable {
    private int copyNum;
    private int isbn;

    public hashala(int copyNum, int isbn) {
        this.copyNum = copyNum;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "hashala{" + "copyNum=" + getCopyNum() + ", isbn=" + getIsbn() + '}';
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
     * @return the isbn
     */
    public int getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    
}
