package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
		public static void main(String[] args) {
			String [] candidatos = {"Felipe", "Marcia","Julia","Paulo","Augusto"};
			for(String candidato: candidatos){
				entrandoEmContato(candidato);
			}
			//imprimirSelecionados();
			//selecaoCandidatos();
			//analisarCandidato(1900.0);
			//analisarCandidato(2200.0);
			//analisarCandidato(2000.0);
			//System.out.println("Processo Seletivo");
		}

		static void entrandoEmContato (String candidato){
			int tentativasRealizadas = 1;
			boolean continuarTentando = true;
			boolean atendeu=false;
			do{
				atendeu = atender();
				continuarTentando = !atendeu;
				if(continuarTentando){
					tentativasRealizadas++;
				}else{
					System.out.println("Contato realizado com sucesso.");
				}
			}while(continuarTentando && tentativasRealizadas < 3);

			if(atendeu){
				System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa.");
			}else{
				System.out.println("Não conseguimos contato com " + candidato + ", número máximo de tentativas " + tentativasRealizadas);
			}
		}

		static boolean atender(){
			return new Random().nextInt(3)==1;
		}

		static void imprimirSelecionados(){
			String [] candidatos = {"Felipe", "Marcia","Julia","Paulo","Augusto"};
			System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

			for (int indice = 0; indice < candidatos.length; indice++){
				System.out.println("O candidato de nº "+ (indice + 1) + " é o " +candidatos[indice]);
			}

			System.out.println("\nImprimindo de forma abreviada. - foreach");
			for (String el: candidatos){
				System.out.println("O candidato selecionado foi " + el);
			}
			
		}
		static void  selecaoCandidatos(){

			String [] candidatos = {"Felipe", "Marcia","Julia","Paulo","Augusto","Monica","Fabricio","Mirela","Daniela","Jorge"};
			
			int candidatosSelecionados = 0;
			int candidatoAtual = 0;
			double salarioBase = 2000.0;

			while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){ 
				String candidato = candidatos[candidatoAtual];
				double salarioPretendido = valorPretendido();

				System.out.println("O candidato " + candidato + ", solicitou este valor de salario R$ "+ salarioPretendido);
				if (salarioBase >= salarioPretendido){
					System.out.println("O(A) candidato(a) " + candidato + " foi selecionado para a vaga.");
					candidatosSelecionados++;
				}
				candidatoAtual++;

			}	
		}
		static double valorPretendido(){
			return ThreadLocalRandom.current().nextDouble(1800, 2200);
		}
		static void analisarCandidato(double salarioPretendido) {
			double salarioBase = 2000.0;
			if(salarioBase > salarioPretendido) {
				System.out.println("Ligar para o candidato");
			}else if (salarioBase == salarioPretendido) {
				System.out.println("Ligar para o candidadp com contra-proposta.");
			}else {
				System.out.println("Aguardano o resultado dos demais candidatos");
			}
		}
}
