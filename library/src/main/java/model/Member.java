package model;

import java.util.ArrayList;

public class Member {
	private String Id;
	private String name;
	private ArrayList<Loan> loans;
	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Loan> getLoans() {
		return loans;
	}

	public void setLoans(ArrayList<Loan> loans) {
		this.loans = loans;
	}
	//4¸ö·½·¨
	public final void Return(Book book){
		model.Loan loan =FindCurrentLoanFor(book);
		if(loan != null){
			loan.MarkAsReturned();
			book.setLoanTo(null);
		}
	}
	
	public final boolean CanLoan(Book book){
		return book.getLoanTo() == null;
	}
	
	public final Loan Loan(Book book){
		Loan loan = null;
		if(CanLoan(book)){
			loan = LoanFactory.CreateLoan(book,this);
			getLoans().add(loan);
		}
		return loan;
	}
	public Loan FindCurrentLoanFor(Book book){
		for(Loan loan:loans){
            if(loan.getBook().getId().equals(book.getId())){
        		return loan;	
            }
        }
		return null;
	}
}
