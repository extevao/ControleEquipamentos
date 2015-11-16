package br.com.controlequipamentos.ferramentas;

public class Media {
	
	
	public float media(String qtdManutencao, String qtdEquipamento){
		float teste;
		if(Float.parseFloat(qtdEquipamento) == 0){
			return 0;
		}
	
		teste = Float.parseFloat(qtdManutencao)/Float.parseFloat(qtdEquipamento);
	
		return teste;
		
	}

}
