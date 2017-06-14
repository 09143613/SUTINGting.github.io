package model;

public class Book extends entityBase{
	private String Id;
	public final String getId(){
		return Id;
	}
	public final void setId(String Id){
		this.Id=Id;
	}
	private String ISBN;
	public final String getISBN(){
		return ISBN;
	}
	public final void setISBN(String ISBN){
		this.ISBN=ISBN;
	}
	private String Title;
	public final String getTitle(){
		return Title;
	}
	public final void setTitle(String Title){
		this.Title=Title;
	}
	private Member LoanTo;
	public Member getLoanTo(){
		return LoanTo;
	}
	public void setLoanTo(Member LoanTo){
		this.LoanTo=LoanTo;
	}
}
