package model;

import java.util.Date;
import java.time.LocalDate;

public class Loan {
	private String Id;
	private LocalDate LoanDate;
	private LocalDate ReturnDate;
	private LocalDate DateForReturn;
	private Book book;
	private Member member;
	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public LocalDate getLoanDate() {
		return LoanDate;
	}

	public void setLoanDate(LocalDate loanDate) {
		LoanDate = loanDate;
	}

	public LocalDate getReturnDate() {
		return ReturnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		ReturnDate = returnDate;
	}

	public LocalDate getDateForReturn() {
		return DateForReturn;
	}

	public void setDateForReturn(LocalDate dateForReturn) {
		DateForReturn = dateForReturn;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	//两个方法
	public boolean HasNotBeenReturned(){
		return ReturnDate == null;
	}
	
	public void MarkAsReturned(){
		//ReturnDate = DateTime.Now;
		ReturnDate = LocalDate.now();
	}
}
