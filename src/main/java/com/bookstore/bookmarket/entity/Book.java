package com.bookstore.bookmarket.entity;

import jakarta.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "book", catalog = "test_db")
public class Book {
	private static final int id = 0;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int no;
	private String name;

	public Book() {
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [no=" + no + ", name=" + name + "]";
	}

	public String getPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}
}