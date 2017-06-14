package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public  class LoanFactory {
	public static Loan CreateLoan(Book book,Member member){
		LocalDate localDate = LocalDate.now();
		Loan loan=new Loan();
		loan.setBook(book);
		loan.setMember(member);
		loan.setLoanDate(localDate);		
		loan.setDateForReturn(localDate.plus(30, ChronoUnit.DAYS));
		return loan;
	}
}
