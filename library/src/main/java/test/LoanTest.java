package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Book;
import model.Loan;
import model.Member;

public class LoanTest {

	@Test
	public void test() {
		Member member1 = new Member();
		member1.setId("001");
		member1.setLoans(new ArrayList<Loan>());
		member1.setName("simon");
		Book book1 =new Book();
		book1.setId("book_001");
		book1.setISBN("ISBN_001");
		book1.setTitle("系统分析与设计");
		//开始借书
		if(member1.CanLoan(book1)){
			Loan loan1 = member1.Loan(book1);
			book1.setLoanTo(member1);
			assertEquals(member1.getLoans().size(),1);
			System.out.println(member1.getName());
			System.out.println(book1.getTitle());
			System.out.println("借书成功！");
			return ;
		}
	}

}
