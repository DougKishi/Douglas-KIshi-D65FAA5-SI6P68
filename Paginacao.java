package paginacao;

public class Paginacao {
	int[] vetor1 = { 0, 0, 0, 0, 0 };
	int[] vetor2 = { 1, 2, 3, 4, 5, 9, 10, 3, 2 };
	int lost = 0;
	int size = 0;
	int position = 0;
	int p = 0;

	// Leitura do Vetor2 e passagem dos valores para o Vetor 1
	public void verificar() {

		for (int i = 0; i < vetor2.length; i++) {
			valorVetor(vetor2[i]);
		}
	
		System.out.println("Paginação Perdida: "+lost);
		System.out.println("Valor Final do Vetor 1: ");
		imprimeVetor();
	}

	// Verifica o Vetor2 e valida se o processo add ou substitui
	public void valorVetor(int valor) {
		
		System.out.println("Valor a ser inserido: " +valor);
		System.out.println("Valores no Vetor 1");
		imprimeVetor();
		
		if (size < 5) {
			if (verificaValor(valor)) {

			}

			else {
				add(position, valor);
				position++;
				lost++;
				size++;
				System.out.println("Paginação Perdida!");

			}
		} 
		
		else {
			
			if (verificaValor(valor)) {

			}

			else {
				
				liberaVetor();
				vetor1[4] = valor;
				lost++;
				System.out.println("Paginação Perdida!");
			}
		}
	}

	// Verifica o vetor1 e valida se o valor foi atribuido a ele, caso sim retorna
	// True ou senão false
	public boolean verificaValor(int valor) {

		boolean v = false;

		for (int i = 0; i < vetor1.length; i++) {
			if (valor == vetor1[i]) {
				v = true;
				break;
			}
		}
		if (v == true) {

			return true;
		} 
		else {
			
			return false;
		}

	}

	private void add(int position, int valor) {
		if (p == position) {
			vetor1[0] = valor;

		}

		else if (p + 1 == position) {
			vetor1[1] = valor;

		} else if (p + 2 == position) {
			vetor1[2] = valor;

		} else if (p + 3 == position) {
			vetor1[3] = valor;

		} else {
			vetor1[4] = valor;

		}
	}

	public void liberaVetor() {
		vetor1[0] = vetor1[1];
		vetor1[1] = vetor1[2];
		vetor1[2] = vetor1[3];
		vetor1[3] = vetor1[4];
		vetor1[4] = 0;

	}
	
	public void imprimeVetor( ) {
		for (int i = 0; i < vetor1.length; i++) {
			System.out.println(vetor1[i]);
		}
	}

	public static void main(String[] args) {
		Paginacao page = new Paginacao();
		page.verificar();

	}

}
