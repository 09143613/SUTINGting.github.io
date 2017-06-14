package specification;

import model.Book;
import model.Member;

public class LoanOnlyOneSpecification implements Specification<Member> {
	private Book wantBook;
	public LoanOnlyOneSpecification(Book book){
		this.wantBook=wantBook;
	}
	@Override
	public boolean IsSatisfiedBy(Member member) {
		// TODO Auto-generated method stub
		return member.getLoans().stream().anyMatch(loan -> 
			(wantBook.getISBN().equals(loan.getBook())));
	}

}
