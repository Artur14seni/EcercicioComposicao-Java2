package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Book;
import entities.Client;
import entities.Loan;
import enums.LoanStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Qual é o nome do cliente: ");
		String nome = sc.nextLine();
		
		System.out.print("Qual é o email do cliente: ");		
		String email = sc.nextLine();
		
		System.out.print("Qual é o numero de telefone: ");
		String telefone = sc.nextLine();
		
		Client cliente = new Client(nome, email, telefone);
		System.out.println();
	
		System.out.print("Dia do emprestimo do livro(s): ");
		Date dataEmprestimo = date.parse(sc.next());
		
		System.out.print("Dia do vencimento do emprestimo do livro(s): ");
		Date dataVencimento = date.parse(sc.next());
		
		System.out.print("Status do emprestimo: ");
		LoanStatus ls = LoanStatus.valueOf(sc.next());
		
		Loan loan = new Loan(dataEmprestimo, dataVencimento, ls, cliente);
		
		System.out.println();
		
		System.out.print("Quantidade de livros que você gostaria: ");
		int quantidade = sc.nextInt();
		
		for(int i = 0; i < quantidade; i++) {
			sc.nextLine();
			System.out.print("Titulo do livro #" +(i+1)+ ": ");
			String titulo = sc.nextLine();
			
			System.out.print("Autor do livro #" +(i+1)+":");
			String autor = sc.nextLine();
			
			System.out.print("ISBN do livro #" +(i+1)+ ": ");
			String isbn = sc.nextLine();
			
			Book book = new Book(titulo, autor, isbn);
			loan.addBook(book);
		}
		
		System.out.println();
		System.out.println(loan);
		
		
		
		
		sc.close();
	}

}
