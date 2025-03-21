package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.LoanStatus;

public class Loan {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date date;
	private Date dueData;
	private LoanStatus status;
	private Client Client;
	private List <Book> books = new ArrayList<>();
	
	public Loan() {}
	
	public Loan(Date date, Date dueData, LoanStatus status, entities.Client client) {
		this.date = date;
		this.dueData = dueData;
		this.status = status;
		Client = client;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDueData() {
		return dueData;
	}

	public void setDueData(Date dueData) {
		this.dueData = dueData;
	}

	public LoanStatus getStatus() {
		return status;
	}

	public void setStatus(LoanStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client client) {
		Client = client;
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void removeBook(Book book) {
		books.remove(book);
	}
	
	public int totalBooks() {
		int contador = 0;
		for(Book x: books) {
			contador += 1;
		} 
		return contador;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(Client);
		sb.append("\nData de emprestimo: ");
		sb.append(sdf.format(date));
		sb.append("\nData de vencimento: ");
		sb.append(sdf.format(dueData));
		sb.append("\nStatus do emprestimo: ");
		sb.append(status);
		
		sb.append("\nRelatorio de livros emprestados: ");
		for(Book x: books) {
			sb.append("\n");
			sb.append(x);
		}
		sb.append("\nTotal de livros emprestados: ");
		sb.append(totalBooks());
		return sb.toString();
	}
	
	
	
}
