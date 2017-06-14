package specification;

import java.util.ArrayList;

import model.Loan;
import model.Member;

public class HasReachMaxSpecification implements Specification<Member> {

	@Override
	public boolean IsSatisfiedBy(Member member) {
		// TODO Auto-generated method stub
		ArrayList<Loan> loans = new ArrayList();
		loans=member.getLoans();
		int i = 0;
		for(Loan loan:loans){
			if(loan.getReturnDate()== null){
				i++;
			}
			
		}
		if(i>3){//超过三次不行
			return false;
		}
		return true;
	}

}
